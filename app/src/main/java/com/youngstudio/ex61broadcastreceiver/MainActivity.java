package com.youngstudio.ex61broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyReceiver myreceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Broadcast Receiver 디바이스의 상태변화를 인지하고자 할 때 사용( 베터리부족, 와이파이 불가능, 블루투스 검색)
        //즉 앱에서 운영체제의 정보를 취득하고 싶을때.
        //안드로이드 운영체제는 운영체제의 정보를 방송(Broadcast)를 통해 모든 앱에게
        //알려주고 있음.그러므로 이를 이용하고 싶다면..
        //방송수신기를 (Broadcase Receiver)를 만들면 됨.


    }

    public void clickBtn(View view) {
        //방송 보내기!

        //명시적 인텐트를 통해 리시버 실행하기[ 내 앱안에 리시버 실행]
//        Intent intent= new Intent(this,MyReceiver.class);
//        sendBroadcast(intent);

        //묵시적 인텐트로 리시버 실행하기 [ 내 디바이스에 설치된 모든 앱에게 방송보내기]
        Intent intent= new Intent();
        intent.setAction("aaa"); /// aaa라는 방송을 듣는 모든 리시버 반응해라

        sendBroadcast(intent);

        //Oreo버전부터 브로드캐스트리시버나 서비스 컴포넌트 사용에 제한을 두고 있음( 백그라운드에서 너무 리소스를 많이 잠식할 수 있어서)
        //묵시적 인텐트를 통한 리시버호출은 금지
        //그럼에도 묵시적 인텐트로 하고 싶다면..
        //앱이 켜져 있을 때만 동작하도록
        //리시버를 이 액티비티에서 등록시켜 사용함
        //즉 Manifest.xml에 등록하지 않고
        //자바에서 리시버를 등록하여 사용할 수 있음

        //시스템 브로드캐스트 인텐트는 여전히 묵시적 인텐트로 사용 가능함.

    }

    //액티비티가 화면에 보여질때
    //자동으로 실행되는 메소드
    @Override
    protected void onResume() {
        super.onResume();

        //동적으로 리시버 등록..(Manifest에 등록하지 않음);
        myreceiver= new MyReceiver();
        IntentFilter filter= new IntentFilter();
        filter.addAction("aaa");
        registerReceiver(myreceiver, filter);



    }

    //액티비티가 화면에 보여지지 않을 때
    //자동으로 실행되는 메소드
    @Override
    protected void onPause() {
        super.onPause();

        //리시버를 제거
        unregisterReceiver(myreceiver);
    }



}




















