package com.example.sinki.bai27_autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtTen,txtInfor;
    AutoCompleteTextView autotxtTinh;
    Button btnXacNhan;
    String[] arrTinh;
    ArrayAdapter<String>adapterTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhan();
            }
        });
    }

    private void xuLyXacNhan() {
        String s = txtTen.getText().toString() +
                "\nNơi sinh:" + autotxtTinh.getText().toString();
        txtInfor.setText(s);
    }

    private void addControls() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        txtInfor = (EditText) findViewById(R.id.txtInfor);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        autotxtTinh = (AutoCompleteTextView) findViewById(R.id.autotxtTinh);

        arrTinh = getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinh = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinh);

        autotxtTinh.setAdapter(adapterTinh);
    }
}
