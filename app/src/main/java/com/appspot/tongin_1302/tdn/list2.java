package com.appspot.tongin_1302.tdn;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016-07-18.
 */
public class list2 extends AppCompatActivity{
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;
    ArrayList<String> lines =null;
    String idnum="";
    ArrayList<String> imgs=null;
    ArrayList<String> rtexts=null;
    public static Toast mToast;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        mToast = Toast.makeText(this, "null", Toast.LENGTH_SHORT);
        /*String id = Integer.toString(getIntent().getExtras().getInt("id"));
        FileReader fr = null;
        String dirPath = getFilesDir().getAbsolutePath();
        try {
            fr = new FileReader(dirPath + "/detail.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = null;
        String emp = "";
        int startindex=0;
        BufferedReader Br = new BufferedReader(fr);//buffer 생성
        try {
            for (int i = 0; (temp = Br.readLine()) != null; i++)
            {
                //Log.i("아아야아",temp);
                if (temp.equals(id))
                {
                    startindex=i;
                    idnum+=temp;
                }
                else if(temp.equals(id+"평가종료") )
                {
                    break;
                }
                else if (startindex!=0 && i>startindex )
                {
                    lines.add(temp);
                    //Log.i("아아야아",temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String title=lines.get(0)+" ("+getIntent().getExtras().getString("rank")+")";
        final String toastTitle=lines.get(0)+"\n("+getIntent().getExtras().getString("rank")+")";
        setTitle(title);
        mToast.setText(toastTitle);
        mToast.show();
        //Button totalButton = (Button) findViewById(R.id.total);
        //totalButton.setText(lines.get(7));
        RadarChart chart = (RadarChart) findViewById(R.id.chart);
        ArrayList<Entry> entries = new ArrayList<>();
        String []attr=lines.get(7).split(",");
        for (int i=0;i<5;i++)
            entries.add(new Entry((float)(Double.parseDouble(attr[i])),i));
        RadarDataSet dataset_comp1 = new RadarDataSet(entries,"");
        dataset_comp1.setColor(Color.RED);
        dataset_comp1.setDrawFilled(true);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("맛");
        labels.add("가격");
        labels.add("서비스");
        labels.add("청결도");
        labels.add("분위기");
        RadarData data = new RadarData(labels, dataset_comp1);
        chart.setData(data);
        chart.setDescription("");
        //chart.getXAxis().setDrawLabels(false);
        chart.getYAxis().setDrawLabels(false);
        chart.getLegend().setEnabled(false);
        chart.animate();


        Button foodButton = (Button) findViewById(R.id.food);
        foodButton.setText(lines.get(6));
        Button statusButton = (Button) findViewById(R.id.status);
        statusButton.setText("최근 리뷰: "+lines.get(3)+"\n지금 까지 "+lines.get(4));
        Button reviewButton = (Button) findViewById(R.id.review);
        reviewButton.setText("'"+lines.get(0)+"'"+" 평가하기");
        reviewButton.setTextColor(Color.parseColor("#FF0000"));
        Button mapButton = (Button) findViewById(R.id.findmap);
        mapButton.setTextColor(Color.parseColor("#006400"));
        mapButton.setText(lines.get(1));
        Button phoneButton = (Button) findViewById(R.id.phone);
        phoneButton.setTextColor(Color.parseColor("#335ce5"));
        phoneButton.setText(lines.get(2));
        mListView = (ListView) findViewById(R.id.mList2);
        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);



        for (int i=0;i<lines.size();i++)
        {
            if (lines.get(i).startsWith("['"))
            {
                String[] arr=lines.get(i+3).split("/");
                String path=dirPath+"/"+arr[arr.length-1]+".png";
                mAdapter.addItem(Drawable.createFromPath(path),(lines.get(i)+"\n"+lines.get(i+2)),lines.get(i+1),path);

                imgs.add(path);
                rtexts.add(lines.get(i)+"\n\n"+lines.get(i+2)+"\n\n"+lines.get(i+1));
            }
        }
        */
        /*
        for (int i=0;i<lines.size();i++)
            emp+=(i+","+lines.get(i)+"\n");
        editText.setText(emp);
        setContentView(R.layout.activity_list2);
        */
        /*
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                DetailData mData = mAdapter.mDetailData.get(position);
                //Toast.makeText(getApplicationContext(), Integer.toString(mData.mId), Toast.LENGTH_SHORT).show();
                Intent review=new Intent(v.getContext(),reviewGallery.class);
                String []img=new String[imgs.size()];
                String []reviewText=new String[rtexts.size()];
                for (int i=0;i<imgs.size();i++)
                {
                    img[i]=imgs.get(i);
                    reviewText[i]=rtexts.get(i);
                }
                String temp;
                temp=img[0];
                img[0]=img[position];
                img[position]=temp;
                temp=reviewText[0];
                reviewText[0]=reviewText[position];
                reviewText[position]=temp;

                review.putExtra("title", title);
                review.putExtra("img", img);
                review.putExtra("reviewText", reviewText);
                //review.putExtra("id",mData.mId);
                String []rank=mData.mTitle.split(":");
                startActivity(review);
            }
        });
        */
    }

    @Override
    protected void onResume()
    {
        super.onResume();
         mListView = null;
         mAdapter = null;
        lines = new ArrayList<String>();
        idnum="";
        imgs=new ArrayList<String>();
        rtexts=new ArrayList<String>();
        String id = Integer.toString(getIntent().getExtras().getInt("id"));
        FileReader fr = null;
        String dirPath = getFilesDir().getAbsolutePath();
        try {
            fr = new FileReader(dirPath + "/detail.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = null;
        String emp = "";
        int startindex=0;
        BufferedReader Br = new BufferedReader(fr);//buffer 생성
        try {
            for (int i = 0; (temp = Br.readLine()) != null; i++)
            {
                //Log.i("아아야아",temp);
                if (temp.equals(id))
                {
                    startindex=i;
                    idnum+=temp;
                }
                else if(temp.equals(id+"평가종료") )
                {
                    break;
                }
                else if (startindex!=0 && i>startindex )
                {
                    lines.add(temp);
                    //Log.i("아아야아",temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String title=lines.get(0)+" ("+getIntent().getExtras().getString("rank")+")";
        final String toastTitle=lines.get(0)+"\n("+getIntent().getExtras().getString("rank")+")";
        setTitle(title);
        mToast.setText(toastTitle);
        mToast.show();
        //Button totalButton = (Button) findViewById(R.id.total);
        //totalButton.setText(lines.get(7));
        RadarChart chart = (RadarChart) findViewById(R.id.chart);
        ArrayList<Entry> entries = new ArrayList<>();
        String []attr=lines.get(7).split(",");
        for (int i=0;i<5;i++)
            entries.add(new Entry((float)(Double.parseDouble(attr[i])),i));
        RadarDataSet dataset_comp1 = new RadarDataSet(entries,"");
        dataset_comp1.setColor(Color.RED);
        dataset_comp1.setDrawFilled(true);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("맛");
        labels.add("가격");
        labels.add("서비스");
        labels.add("청결도");
        labels.add("분위기");
        RadarData data = new RadarData(labels, dataset_comp1);
        chart.setData(data);
        chart.setDescription("");
        //chart.getXAxis().setDrawLabels(false);
        chart.getYAxis().setDrawLabels(false);
        chart.getLegend().setEnabled(false);
        chart.animate();


        Button foodButton = (Button) findViewById(R.id.food);
        foodButton.setText(lines.get(6));
        Button statusButton = (Button) findViewById(R.id.status);
        statusButton.setText("최근 리뷰: "+lines.get(3)+"\n지금 까지 "+lines.get(4));
        Button reviewButton = (Button) findViewById(R.id.review);
        reviewButton.setText("'"+lines.get(0)+"'"+" 평가하기");
        reviewButton.setTextColor(Color.parseColor("#FF0000"));
        Button mapButton = (Button) findViewById(R.id.findmap);
        mapButton.setTextColor(Color.parseColor("#006400"));
        mapButton.setText(lines.get(1));
        Button phoneButton = (Button) findViewById(R.id.phone);
        phoneButton.setTextColor(Color.parseColor("#335ce5"));
        phoneButton.setText(lines.get(2));
        mListView = (ListView) findViewById(R.id.mList2);
        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);



        for (int i=0;i<lines.size();i++)
        {
            if (lines.get(i).startsWith("['"))
            {
                String[] arr=lines.get(i+3).split("/");
                String path=dirPath+"/"+arr[arr.length-1]+".png";
                mAdapter.addItem(Drawable.createFromPath(path),(lines.get(i)+"\n"+lines.get(i+2)),lines.get(i+1),path);

                imgs.add(path);
                rtexts.add(lines.get(i)+"\n\n"+lines.get(i+2)+"\n\n"+lines.get(i+1));
            }
        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                DetailData mData = mAdapter.mDetailData.get(position);
                //Toast.makeText(getApplicationContext(), Integer.toString(mData.mId), Toast.LENGTH_SHORT).show();
                Intent review=new Intent(v.getContext(),reviewGallery.class);
                String []img=new String[imgs.size()];
                String []reviewText=new String[rtexts.size()];
                for (int i=0;i<imgs.size();i++)
                {
                    img[i]=imgs.get(i);
                    reviewText[i]=rtexts.get(i);
                }
                String temp;
                temp=img[0];
                img[0]=img[position];
                img[position]=temp;
                temp=reviewText[0];
                reviewText[0]=reviewText[position];
                reviewText[position]=temp;

                review.putExtra("title", title);
                review.putExtra("img", img);
                review.putExtra("reviewText", reviewText);
                //review.putExtra("id",mData.mId);
                String []rank=mData.mTitle.split(":");
                startActivity(review);
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findmap:
                Intent mapview=new Intent(this,MapsActivity.class);
                mapview.putExtra("location",lines.get(5));
                mapview.putExtra("title",lines.get(0));
                mapview.putExtra("juso",lines.get(1));
                startActivity(mapview);
                break;

            case R.id.phone:
                Intent phonecall=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+lines.get(2)));
                startActivity(phonecall);
                break;

            case R.id.review:
                Intent review=new Intent(this,review.class);
                review.putExtra("id",idnum);
                review.putExtra("title",lines.get(0));
                startActivity(review);
                //reload();
                break;

            /*
            case R.id.air:
                Intent list1air=new Intent(this,list1.class);
                list1air.putExtra("id",title);
                startActivity(list1air);
                break;
            case R.id.service:
                Intent list1service=new Intent(this,list1.class);
                list1service.putExtra("id",title);
                startActivity(list1service);
                break;
            case R.id.clean:
                Intent list1clean=new Intent(this,list1.class);
                list1clean.putExtra("id",title);
                startActivity(list1clean);
                break;
            case R.id.replies:
                Intent list1replies=new Intent(this,list1.class);
                list1replies.putExtra("id",title);
                startActivity(list1replies);
                break;
            case R.id.random:
                Intent list1random=new Intent(this,list1.class);
                list1random.putExtra("id",title);
                startActivity(list1random);
                break;
            case R.id.total:
                Intent list1total=new Intent(this,list1.class);
                list1total.putExtra("id",title);
                startActivity(list1total);
                break;
                */
        }
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
    private class ViewHolder {
        public ImageView mIcon;

        public TextView mText;

        public TextView mDate;

        public String mId;
    }
    // Ctrl + i

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<DetailData> mDetailData = new ArrayList<DetailData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mDetailData.size();
        }

        @Override
        public Object getItem(int position) {
            return mDetailData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void addItem(Drawable icon, String mTitle){
            DetailData addInfo = null;
            addInfo = new DetailData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;

            mDetailData.add(addInfo);
        }
        //public void addItem(Drawable icon, String mTitle, String mDate){
        public void addItem(Drawable icon, String mTitle, String mDate, String mId){
            DetailData addInfo = null;
            addInfo = new DetailData();
            addInfo.mIcon = icon;
            //addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;
            addInfo.mId=mId;
            mDetailData.add(addInfo);
        }

        public void remove(int position){
            mDetailData.remove(position);
            dataChange();
        }

       /* public void sort(){
            Collections.sort(mDetailData, DetailData.ALPHA_COMPARATOR);
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

            DetailData mData = mDetailData.get(position);

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


}
