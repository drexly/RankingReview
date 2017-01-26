package com.appspot.tongin_1302.tdn;

/**
 * Created by busanetri06 on 2016-07-22.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class reviewGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //    1. 다량의 데이터
        //    2. Adapter
        //    3. AdapterView : Gallery
        /*
        final int img[] = {
                R.drawable.canada,R.drawable.france,R.drawable.korea,
                R.drawable.mexico,R.drawable.poland,R.drawable.saudi_arabia
        };
        final String reviewText[] = {
                "리뷰 테슷트 1111","리뷰 테슷트 2222","리뷰 테슷트 3333",
                "리뷰 테슷트 4444","리뷰 테슷트 5555","리뷰 테슷트 6666"
        };
        */
        setTitle(getIntent().getExtras().getString("title"));
        Intent i=getIntent();
        String imgs[]=i.getStringArrayExtra("img");
        final Drawable []img=new Drawable[imgs.length];
        for (int x=0;x<imgs.length;x++)
        {
            img[x]=Drawable.createFromPath(imgs[x]);
        }

        final String reviewText[]=i.getStringArrayExtra("reviewText");
        // adapter
        MyAdapter adapter = new MyAdapter(
                getApplicationContext(), // 현재 화면의 제어권자
                R.layout.row,
                img);

        // adapterView
        Gallery g = (Gallery)findViewById(R.id.gallery1);
        g.setAdapter(adapter);

        final ImageView iv = (ImageView)findViewById(R.id.imageView1);
        final TextView review = (TextView)findViewById(R.id.textView1);

        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) { // 선택되었을 때 콜백메서드
                review.setMovementMethod(new ScrollingMovementMethod());
                review.setText(reviewText[position]);
                review.setTextColor(Color.WHITE);
                iv.setImageDrawable(img[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    } // end of onCreate
} // end of class

class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    Drawable img[];
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, Drawable[] img) {
        this.context = context;
        this.layout = layout;
        this.img = img;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 보여줄 데이터의 총 개수 - 꼭 작성해야 함
        return img.length;
    }

    @Override
    public Object getItem(int position) { // 해당행의 데이터- 안해도 됨
        return null;
    }

    @Override
    public long getItemId(int position) { // 해당행의 유니크한 id - 안해도 됨
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 보여줄 해당행의 row xml 파일의 데이터를 셋팅해서 뷰를 완성하는 작업
        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }

        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        iv.setImageDrawable(img[position]);
        return convertView;
    }
}
