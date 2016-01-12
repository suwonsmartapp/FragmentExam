package com.massivcode.fragmentexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트를 배치할 공간입니다.
        mContainer = (FrameLayout) findViewById(R.id.container);
        // 이 버튼을 누르면 프래그먼트가 배치됩니다.
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 공간에 배치할 프래그먼트를 생성하고
        Fragment1 fragment = Fragment1.newInstance("아주대학교", "산업공학과");
        // 아래와 같은 방법으로 프래그먼트를 추가합니다.
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }
}
