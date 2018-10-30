package com.codebakery.joan.tryintentresult1030;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        result = bundle.getString("alias") + " " + bundle.getString("sections");

        ((TextView)findViewById(R.id.textViewResult)).setText(result);
    }

    @Override
    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        Intent intent = new Intent().putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER,intent);
        super.finish();
    }
}
