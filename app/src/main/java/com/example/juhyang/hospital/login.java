package com.example.juhyang.hospital;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class login extends AppCompatActivity {

    EditText txt_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView b = (ImageView) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner spinner = (Spinner)findViewById(R.id.spinner1);
                final String text = spinner.getSelectedItem().toString();

                txt_name = (EditText)findViewById(R.id.name);



                if(text.equals("재고관리자")) {
                    Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            ManagerMenu.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("name", txt_name.getText().toString()); //이름 전달
                    startActivity(intent); // 다음 화면으로 넘어간다
                } else {
                    Intent intent = new Intent(
                            getApplicationContext(), // 현재 화면의 제어권자
                            PrimaryMenu.class); // 다음 넘어갈 클래스 지정
                    intent.putExtra("value",text); //어느부서인지 text 보내주기
                    intent.putExtra("name", txt_name.getText().toString()); //이름 전달
                    startActivity(intent);

                }


            }
        });




    }


}




