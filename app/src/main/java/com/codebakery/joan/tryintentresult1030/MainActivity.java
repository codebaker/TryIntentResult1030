package com.codebakery.joan.tryintentresult1030;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implements View.OnClickListener 했으니까 리스너 등록하고 메서드 오버라이드
        findViewById(R.id.buttonSave).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextRefrigerator = findViewById(R.id.editTextRefrigerator);
        RadioButton selectedRadioButton = findViewById(((RadioGroup)findViewById(R.id.radioGroupSections))
                                                .getCheckedRadioButtonId());
        Bundle bundle = new Bundle();
        bundle.putString("alias",editTextRefrigerator.getText().toString());
        bundle.putString("sections",selectedRadioButton.getText().toString());
        Intent intent = new Intent(this,SecondActivity.class).putExtras(bundle);
        startActivityForResult(intent,Activity.RESULT_FIRST_USER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(resultCode == RESULT_OK && requestCode == Activity.RESULT_FIRST_USER && data != null){
        if(data != null){
            if(data.hasExtra("result")) {
                ((TextView)findViewById(R.id.textViewResult)).setText(data.getStringExtra("result"));
            }
        }
    }
}
