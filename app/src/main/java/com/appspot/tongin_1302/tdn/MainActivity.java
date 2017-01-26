package com.appspot.tongin_1302.tdn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, SplashActivity.class));
        super.onCreate(savedInstanceState);
        setTitle(R.string.main_title);
        setContentView(R.layout.activity_main);

        //dbInitialize();
    }

    @Override
    public void onClick(View v) {
        String title=v.getResources().getResourceName(v.getId());
        switch (v.getId()){
            case R.id.latest:
                Intent list1latest=new Intent(this,list1.class);
                list1latest.putExtra("id",title);
                startActivity(list1latest);
                break;
            case R.id.price:
                Intent list1price=new Intent(this,list1.class);
                list1price.putExtra("id",title);
                startActivity(list1price);
                break;
            case R.id.taste:
                Intent list1taste=new Intent(this,list1.class);
                list1taste.putExtra("id",title);
                startActivity(list1taste);
                break;
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
                Intent gweb=new Intent(Intent.ACTION_VIEW, Uri.parse("http://tongin-1302.appspot.com"));
                //gweb.setPackage("com.android.chrome");
                startActivity(gweb);
                break;
            case R.id.total:
                Intent list1total=new Intent(this,list1.class);
                list1total.putExtra("id",title);
                startActivity(list1total);
                break;

        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("test", "onPrepareOptionsMenu - 옵션메뉴가 " +
                "화면에 보여질때 마다 호출됨");

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");
        int id = item.getItemId();
        switch(id) {
            case R.id.update:
                Intent intent1=new Intent(getApplicationContext(),SplashActivity.class);
                startActivity(intent1);
                return true;
            case R.id.maker:
                Intent intent2=new Intent(getApplicationContext(),maker.class);
                startActivity(intent2);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    */

}
