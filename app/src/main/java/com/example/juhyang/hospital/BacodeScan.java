package com.example.juhyang.hospital;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class BacodeScan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onResume(){
        super.onResume();

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CustomScannerActivity.class);
        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent intent) {


        Log.d("onActivityResult", "onActivityResult: .");
        if (resultCode == Activity.RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            String re = scanResult.getContents();
            final String message = re;
            Log.d("onActivityResult", "onActivityResult: ." + re);
            Toast.makeText(this, re, Toast.LENGTH_LONG).show();


            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    //여기에 딜레이 후 시작할 작업들을 입력
                    Intent change = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            M_Purchase.class); // 다음 넘어갈 클래스 지정
                            intent.putExtra("data",message);
                    startActivity(change);

                }
            }, 500);// 0.5초 정도 딜레이를 준 후 시작


        }
    }
}
