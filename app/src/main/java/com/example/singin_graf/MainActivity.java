package com.example.singin_graf;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.os.Bundle;

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
}