package com.appspot.tongin_1302.tdn;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;


import android.widget.ImageView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.bumptech.glide.Glide;


public class SplashActivity extends Activity {
    AQuery aq= new AQuery(this);
    public static Toast mToast;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        mToast = Toast.makeText(this, "null", Toast.LENGTH_SHORT);
        Glide.with(this).load(R.drawable.loading).asGif().into(imageView);
        final String current= getFilesDir().getAbsolutePath();
        //mToast.setText("업데이트중입니다. 잠시만 기다려주세요");
        //mToast.show();
        Handler handler = new Handler()
        {
            public void handleMessage(Message msg) {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8)
                {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    try {
                        //mToast.setText("기다려 주셔서 감사합니다");
                        //mToast.show();
                        copyDirectory(current);
                        dbInitialize(current);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0,1000);
    }

    private class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class)); // 로딩이 끝난후 이동할 Activity
            SplashActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }
    // If targetLocation does not exist, it will be created.
    public void copyDirectory(String location) throws IOException
    {
        File chker = new File(location+"/latest.txt");
        File tmp=null;
        if(!chker.exists())
        {
            AssetManager assetManager = getAssets();
            String[] files = null;
            try {
                files = assetManager.list("");
            } catch (IOException e) {
            }
            if (files != null) for (String filename : files)
            {
                if (filename.contains(".png")||filename.contains(".txt"))
                {
                    tmp=new File(location + "/" + filename);
                    if (!tmp.exists())
                    {
                        InputStream in = assetManager.open(filename);
                        OutputStream out = new FileOutputStream(location + "/" + filename);
                        // Copy the bits from instream to outstream
                        byte[] buf = new byte[1024];
                        int len;
                        while ((len = in.read(buf)) > 0) {
                            out.write(buf, 0, len);
                        }
                        in.close();
                        out.close();
                    }
                }
            }
        }
    }

    public void dbInitialize(String location) throws IOException
    {
        URL url; // The URL to read
        HttpURLConnection conn; // The actual connection to the web page
        BufferedReader rd; // Used to read results from the web page
        String line; // An individual line of the web page HTML
        String result = ""; // A long string containing all the HTML
        String dirPath =location;
        // TODO Auto-generated method stub
        url = new URL("http://tongin-1302.appspot.com/dosirak/parse");
        //Log.i("중요","test",url.toString());
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            //mToast.cancel();
            //mToast.setText("서버 연결이 성공적입니다.");
            //mToast.show();
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            boolean chknew=true;//db가 최신상태인지 비교위한 변수
            while ((line = rd.readLine()) != null)
            {
                if(line.trim().length() > 0)
                {
                    line=line.trim();
                    if (chknew)//첫 줄용
                    {
                        if(line.startsWith("201"));
                        {
                            String chkername=line.replaceAll(":", ".");
                            String flag=dirPath+"/"+chkername+".txt";
                            File file = new File(flag);
                            if(file.exists())//첫줄에서 최신임이 밝혀지면
                            {
                                //mToast.cancel();
                                //mToast.setText("앱 데이터가 최신입니다.");
                                //mToast.show();
                                return;//쫑내
                            }
                            chknew=false;//못쫑내면 일로 들어가지 인터넷은 연결되있고 파일은 오래됐고 업데이트를 시작한다,
                            FileWriter fw = new FileWriter(file) ;
                            fw.close();//파일만들어짐
                            //mToast.cancel();
                            //mToast.setText("앱 데이터를 최신버전으로\n업데이트합니다.");
                            //mToast.show();
                        }
                    }
                    result += line;
                }
            }
            rd.close();
            conn.disconnect();
            update(result,dirPath);
        }
    }
    void update(String result, String dirPath) throws IOException {
        String multiple[]=result.split("<br>");
        int txtlength=multiple.length;
        int indexUpdate=0,indexTaste=0,indexPrice=0,indexService=0,indexClean=0,indexAir=0,indexReple=0,indexTotal=0,indexTree=0;;
        for(int i=0;i<txtlength;i++)
        {
            multiple[i] = multiple[i].trim();
            switch (multiple[i])
            {
                case "최근 업데이트 된 순":
                    indexUpdate = i;
                    break;
                case "맛 평점이 제일 높은 순":
                    indexTaste = i;
                    break;
                case "가격 평점이 제일 높은 순":
                    indexPrice = i;
                    break;
                case "서비스 평점이 제일 높은 순":
                    indexService = i;
                    break;
                case "청결도 평점이 제일 높은 순":
                    indexClean = i;
                    break;
                case "분위기 평점이 제일 높은 순":
                    indexAir = i;
                    break;
                case "평가자 많은 순":
                    indexReple = i;
                    break;
                case "종합 평점이 제일 높은 순":
                    indexTotal = i;
                    break;
                case "전체전체전체전체":
                    indexTree = i;
                    break;
            }
            if (multiple[i].contains("http"))
            {
                String[] imgs = multiple[i].split("/");
                File file = new File(dirPath + "/" + imgs[imgs.length - 1] + ".png");
                if (!file.exists())
                {
                    aq.download(multiple[i], file, new AjaxCallback<File>() {
                        @Override
                        public void callback(String url, File object, AjaxStatus status) {

                        }
                    });
                }
            }
            //Log.i("지금줄",Integer.toString(i));
        }
        String pathUpdate=dirPath+"/latest.txt";
        String pathTaste=dirPath+"/taste.txt";
        String pathPrice=dirPath+"/price.txt";
        String pathService=dirPath+"/service.txt";
        String pathClean=dirPath+"/clean.txt";
        String pathAir=dirPath+"/air.txt";
        String pathReple=dirPath+"/replies.txt";
        String pathTotal=dirPath+"/total.txt";
        String pathDetail=dirPath+"/detail.txt";
        BufferedWriter update=new BufferedWriter(new FileWriter(pathUpdate));
        BufferedWriter taste=new BufferedWriter(new FileWriter(pathTaste));
        BufferedWriter price=new BufferedWriter(new FileWriter(pathPrice));
        BufferedWriter service=new BufferedWriter(new FileWriter(pathService));
        BufferedWriter clean=new BufferedWriter(new FileWriter(pathClean));
        BufferedWriter air=new BufferedWriter(new FileWriter(pathAir));
        BufferedWriter reple=new BufferedWriter(new FileWriter(pathReple));
        BufferedWriter total=new BufferedWriter(new FileWriter(pathTotal));
        BufferedWriter detail=new BufferedWriter(new FileWriter(pathDetail));
        for(int i=indexUpdate;i<indexTaste;i++)
        {
            writeToFile(update, multiple[i], pathUpdate);
            //Log.i("ind",Integer.toString(i));
            //Log.i("업뎃",multiple[i].toString());
        }
        update.close();
        //mToast.cancel();
        //mToast.setText("최신 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexTaste;i<indexPrice;i++)
        {
            writeToFile(taste, multiple[i], pathTaste);
            //Log.i("ind",Integer.toString(i));
            //Log.i("맛",multiple[i].toString());
        }
        taste.close();
        //mToast.cancel();
        //mToast.setText("맛 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexPrice;i<indexService;i++)
        {
            writeToFile(price, multiple[i], pathPrice);
            //Log.i("ind",Integer.toString(i));
            //Log.i("가격",multiple[i].toString());
        }
        price.close();
        //mToast.cancel();
        //mToast.setText("가격 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexService;i<indexClean;i++)
        {
            writeToFile(service, multiple[i], pathService);
            //Log.i("ind",Integer.toString(i));
            //Log.i("서비스",multiple[i].toString());
        }
        service.close();
        //mToast.cancel();
        //mToast.setText("서비스 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexClean;i<indexAir;i++)
        {
            writeToFile(clean, multiple[i], pathClean);
            //Log.i("ind",Integer.toString(i));
            //Log.i("클린",multiple[i].toString());
        }
        clean.close();
        //mToast.cancel();
        //mToast.setText("청결도 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexAir;i<indexReple;i++) {
            writeToFile(air, multiple[i], pathAir);
            //Log.i("ind",Integer.toString(i));
            //Log.i("분위기",multiple[i].toString());
        }
        air.close();
        //mToast.cancel();
        //mToast.setText("분위기 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexReple;i<indexTotal;i++)
        {
            writeToFile(reple, multiple[i], pathReple);
            //Log.i("ind",Integer.toString(i));
            //Log.i("리플많은순",multiple[i].toString());
        }
        reple.close();
        //mToast.cancel();
        //mToast.setText("리플 많은 순 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexTotal;i<indexTree;i++)
        {
            writeToFile(total, multiple[i], pathTotal);
            //Log.i("ind",Integer.toString(i));
            //Log.i("전체",multiple[i].toString());
        }
        total.close();
        //mToast.cancel();
        //mToast.setText("종합 랭킹이 업데이트 되었습니다.");
        //mToast.show();
        for(int i=indexTree;i<txtlength;i++)
        {
            writeToFile(detail, multiple[i], pathDetail);
            //Log.i("하하호호ind",Integer.toString(i));
            //Log.i("하하호호",multiple[i].toString());
        }
        detail.close();
        //mToast.cancel();
        //mToast.setText("모든 랭킹이 업데이트 되었습니다. 기다려주셔서 감사합니다");
        //mToast.show();
        //Log.i("test",result);
    }
    private void writeToFile(BufferedWriter output, String data, String savepath)
    {
        try {
            output.write(data);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}