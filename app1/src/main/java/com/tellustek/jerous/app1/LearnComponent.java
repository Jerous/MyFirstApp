package com.tellustek.jerous.app1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

public class LearnComponent extends AppCompatActivity {

    private Spinner s;
    private String[] dataSource = new String[]{"Jerous", "Tellustek", "tlu3"};

    private Button btnChooseDate;
    private Button btnChooseTime;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_learn_component);

            s = (Spinner) findViewById(R.id.spinner);
            btnChooseDate = (Button) findViewById(R.id.btnChooseDate);
            btnChooseTime = (Button) findViewById(R.id.btnChooseTime);


            //提供一個spinner數據
            s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSource));

            //監聽spinner選擇事件
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    }
}
