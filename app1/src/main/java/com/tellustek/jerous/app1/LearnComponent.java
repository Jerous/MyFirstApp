package com.tellustek.jerous.app1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class LearnComponent extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Spinner spinner1;
    private String[] dataSource = new String[]{"Jerous", "Tellustek", "tlu3"};

    private Button btnChooseDate, btnChooseTime, btnRadioSubmit;

    private RadioButton RadioButton1;

    private CheckBox checkBox1, checkBox2, checkBox3;
    private TextView tVcBout;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_learn_component);

            spinner1 = (Spinner) findViewById(R.id.spinner);

            btnChooseDate = (Button) findViewById(R.id.btnChooseDate);

            btnChooseTime = (Button) findViewById(R.id.btnChooseTime);

            RadioButton1 = (RadioButton) findViewById(R.id.radioButton1);
            btnRadioSubmit = (Button) findViewById(R.id.btnRadioSubmit);

            checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            tVcBout = (TextView) findViewById(R.id.tVcBout);


            //提供一個spinner數據
            spinner1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource));

            //監聽spinner選擇事件
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println("用戶選擇的是"+dataSource[position]);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            btnChooseDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //呈現日期選擇器
                    new DatePickerDialog(LearnComponent.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            String theDate = String.format("%d-%d-%d", year, month+1, dayOfMonth);

                            System.out.println(theDate);
                            btnChooseDate.setText(theDate);
                        }
                    },2016,9,18).show();  //初始化日期
                }
            });

            btnChooseTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //呈現時間選擇器
                    new TimePickerDialog(LearnComponent.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            String theTime = String.format("%d:%d", hourOfDay, minute);

                            System.out.println(theTime);
                            btnChooseTime.setText(theTime);
                        }
                    },0,0,true).show();  //初始化時間
                }
            });

            btnRadioSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (RadioButton1.isChecked()) {
                        Toast.makeText(LearnComponent.this, "所選的是正確的", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LearnComponent.this, "所選的是錯誤的", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            checkBox1.setOnCheckedChangeListener(this);
            checkBox2.setOnCheckedChangeListener(this);
            checkBox3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = "你喜歡 ";

        if (checkBox1.isChecked()){
            str += checkBox1.getText() + ", ";
        }
        if (checkBox2.isChecked()){
            str += checkBox2.getText() + ", ";
        }
        if (checkBox3.isChecked()){
            str += checkBox3.getText();
        }
        tVcBout.setText(str);
    }
}
