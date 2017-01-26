package com.appspot.tongin_1302.tdn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class list1 extends AppCompatActivity {
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list1);
        //Toast test = Toast.makeText(getApplicationContext(), koreanTitle, Toast.LENGTH_LONG);
        //test.show();
/*
        FileReader fr = null;
        String dirPath = getFilesDir().getAbsolutePath();
        ArrayList<String> lines = new ArrayList<String>();
        try {
            fr = new FileReader(dirPath+"/"+toolbar+".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = null;
        String emp="";
        BufferedReader Br = new BufferedReader(fr);//buffer 생성
        try {
            for (int i = 0; (temp = Br.readLine()) != null; i++) {
                lines.add(i, temp);
                //Log.i("ttt",temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mListView = (ListView) findViewById(R.id.mList);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        String[] contents= new String[(lines.size()-1)/6];
        String[] date= new String[(lines.size()-1)/6];
        String[] img= new String[(lines.size()-1)/6];
        int[] ids= new int[(lines.size()-1)/6];
        for (int i=0;i<(lines.size())/6;i++)
        {
            img[i]=date[i]=contents[i]="";
        }
        for(int i=1;i<lines.size();i++)
        {
            if(i%6>2&&i%6<6)
            {
                contents[i / 6] += (lines.get(i) + "\n");
            }
            else if(i%6==0)
            {
                date[(i / 6)-1] = (lines.get(i));
            }
            else if(i%6==1)
            {
                String[] arr=lines.get(i).split("/");
                ids[i/6]=Integer.parseInt(arr[arr.length-1]);
            }
            else if(i%6==2)
            {
                String[] arr=lines.get(i).split("/");
                img[i / 6] = ( getFilesDir().getAbsolutePath()+"/"+arr[arr.length-1]+".png");
            }

        }
        for (int i=0;i<(lines.size()-1)/6;i++)
        {
            // mAdapter.addItem(img[i], contents[i],date[i]);
            // mAdapter.addItem(loadImageFromWeb(img[i]), contents[i],date[i]);
            //mAdapter.addItem(createDrawableFromUrl(img[i]), contents[i],date[i]);
            mAdapter.addItem(Drawable.createFromPath(img[i]), contents[i],date[i],ids[i]);
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                ListData mData = mAdapter.mListData.get(position);
                //Toast.makeText(getApplicationContext(), Integer.toString(mData.mId), Toast.LENGTH_SHORT).show();
                Intent detail=new Intent(v.getContext(),list2.class);
                detail.putExtra("id",mData.mId);
                String []rank=mData.mTitle.split(":");
                detail.putExtra("rank",koreanTitle+" "+rank[0]);
                startActivity(detail);
            }
        });
*/
    }

    @Override
    protected void onResume() {
        super.onResume();
         mListView = null;
         mAdapter = null;
        String title = getIntent().getExtras().getString("id");
        String[] realTitle = title.split("/");
        String toolbar = realTitle[realTitle.length - 1] ;
        final String koreanTitle=getResources().getString(getResources().getIdentifier(toolbar, "string", getPackageName()));
        setTitle(koreanTitle);
        //Toast test = Toast.makeText(getApplicationContext(), koreanTitle, Toast.LENGTH_LONG);
        //test.show();

        FileReader fr = null;
        String dirPath = getFilesDir().getAbsolutePath();
        ArrayList<String> lines = new ArrayList<String>();
        try {
            fr = new FileReader(dirPath+"/"+toolbar+".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = null;
        String emp="";
        BufferedReader Br = new BufferedReader(fr);//buffer 생성
        try {
            for (int i = 0; (temp = Br.readLine()) != null; i++) {
                lines.add(i, temp);
                //Log.i("ttt",temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mListView = (ListView) findViewById(R.id.mList);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        String[] contents= new String[(lines.size()-1)/6];
        String[] date= new String[(lines.size()-1)/6];
        String[] img= new String[(lines.size()-1)/6];
        int[] ids= new int[(lines.size()-1)/6];
        for (int i=0;i<(lines.size())/6;i++)
        {
            img[i]=date[i]=contents[i]="";
        }
        for(int i=1;i<lines.size();i++)
        {
            if(i%6>2&&i%6<6)
            {
                contents[i / 6] += (lines.get(i) + "\n");
            }
            else if(i%6==0)
            {
                date[(i / 6)-1] = (lines.get(i));
            }
            else if(i%6==1)
            {
                String[] arr=lines.get(i).split("/");
                ids[i/6]=Integer.parseInt(arr[arr.length-1]);
            }
            else if(i%6==2)
            {
                String[] arr=lines.get(i).split("/");
                img[i / 6] = ( getFilesDir().getAbsolutePath()+"/"+arr[arr.length-1]+".png");
            }

        }
        for (int i=0;i<(lines.size()-1)/6;i++)
        {
            // mAdapter.addItem(img[i], contents[i],date[i]);
            // mAdapter.addItem(loadImageFromWeb(img[i]), contents[i],date[i]);
            //mAdapter.addItem(createDrawableFromUrl(img[i]), contents[i],date[i]);
            mAdapter.addItem(Drawable.createFromPath(img[i]), contents[i],date[i],ids[i]);
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                ListData mData = mAdapter.mListData.get(position);
                //Toast.makeText(getApplicationContext(), Integer.toString(mData.mId), Toast.LENGTH_SHORT).show();
                Intent detail=new Intent(v.getContext(),list2.class);
                detail.putExtra("id",mData.mId);
                String []rank=mData.mTitle.split(":");
                detail.putExtra("rank",koreanTitle+" "+rank[0]);
                startActivity(detail);
            }
        });

    }

    private class ViewHolder {
        public ImageView mIcon;

        public TextView mText;

        public TextView mDate;

        public int mId;
    }
    // Ctrl + i

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(Drawable icon, String mTitle){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;

            mListData.add(addInfo);
        }
        //public void addItem(Drawable icon, String mTitle, String mDate){
        public void addItem(Drawable icon, String mTitle, String mDate, int mId){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            //addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;
            addInfo.mId=mId;
            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

       /* public void sort(){
            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
            dataChange();
        }*/

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                holder.mText = (TextView) convertView.findViewById(R.id.mText);
                holder.mDate = (TextView) convertView.findViewById(R.id.mData);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            ListData mData = mListData.get(position);

            if (mData.mIcon != null) {
                holder.mIcon.setVisibility(View.VISIBLE);
                holder.mIcon.setImageDrawable(mData.mIcon);
            }else{
                holder.mIcon.setVisibility(View.GONE);
            }

            holder.mText.setText(mData.mTitle);
            holder.mDate.setText(mData.mDate);
            holder.mId=mData.mId;

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
       /*  Log.d("test", "onPrepareOptionsMenu - 옵션메뉴가 " +
                "화면에 보여질때 마다 호출됨");
       if(bLog){ // 로그인 한 상태: 로그인은 안보이게, 로그아웃은 보이게
            menu.getItem(0).setEnabled(true);
            menu.getItem(1).setEnabled(false);
        }else{ // 로그 아웃 한 상태 : 로그인 보이게, 로그아웃은 안보이게
            menu.getItem(0).setEnabled(false);
            menu.getItem(1).setEnabled(true);
        }

        bLog = !bLog;   // 값을 반대로 바꿈*/

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");
        int id = item.getItemId();
        switch(id) {
            case R.id.update:
                //Intent intent1=new Intent(getApplicationContext(),SplashActivity.class);
                //startActivity(intent1);
                //finish();
                /*if (android.os.Build.VERSION.SDK_INT >= 11)
                {

                    super.recreate();

                }else{
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }*/
                reload();
                startActivity(new Intent(getApplication(), SplashActivity.class)); // 로딩이 끝난후 이동할 Activity

                break;
            //return true;
            case R.id.maker:
                Intent intent2=new Intent(getApplicationContext(),maker.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void reload()
    {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
    /*
    public static Drawable createDrawableFromUrl(String imageWebAddress)
    {
        Drawable drawable = null;
        try
        {
            InputStream inputStream = new URL(imageWebAddress).openStream();
            drawable = Drawable.createFromStream(inputStream, null);
            inputStream.close();
        }
        catch (MalformedURLException ex) { }
        catch (IOException ex) { }

        return drawable;
    }
    */
}