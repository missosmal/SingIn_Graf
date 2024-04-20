package com.example.singin_graf;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
    }

    public int start_x = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                start_x = (int)event.getX();
                break;
            case  MotionEvent.ACTION_UP:
                if(Math.abs((int)event.getX() - start_x) > 50)
                {
                    if(start_x < (int)event.getX())
                    {
                        setContentView((R.layout.signin));
                    } else {
                        setContentView(R.layout.regin);
                    }
                }
        }
        return false;
    }
    public String login, password;

    public void onAuthorization(View view)
    {
        TextView tv_login = findViewById(R.id.editTextTextPersonNane);
        login = tv_login.getText().toString();

        TextView tv_password = findViewById(R.id.editTextTextPersonName2);
        password = tv_password.getText().toString();

        GetDataUser gdu = new GetDataUser();
        gdu.execute();
    }
    public class DataUser{
        public String id;
        public String login;
        public String password;

        public void setId(String _id) {this.id = _id;}
        public String getId(){return this.id;}
        public void setLogin(String _login) {this.login = _login;}
        public String getLogin(){
            return this.login;}
        public void setPassword(String _password) {this.password = _password;}
        public String getPassword(){return this.password;}
    }
    ArrayList<DataUser> dataUser = new ArrayList();
}