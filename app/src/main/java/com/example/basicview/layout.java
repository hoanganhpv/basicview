package com.example.basicview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Button btnCancel =  (Button)findViewById(R.id.btncancel);
        Button btnInfo =  (Button)findViewById(R.id.btninfo);
        final EditText editName =  (EditText)findViewById(R.id.editTen);
        final EditText editEmail =  (EditText)findViewById(R.id.editEmail);
        final CheckBox chk1 =  (CheckBox) findViewById(R.id.chk1);
        final CheckBox chk2 =  (CheckBox) findViewById(R.id.chk2);
        final CheckBox chk3 =  (CheckBox) findViewById(R.id.chk3);
        final RadioButton rdMale =  (RadioButton) findViewById(R.id.rbNam);
        final RadioButton rdFemale =  (RadioButton) findViewById(R.id.rbNu);
        final Spinner spinLang =  (Spinner) findViewById(R.id.spinLang);
        final Switch switchExpert =  (Switch) findViewById(R.id.switchExpert);


        List<String> lan_array =  new ArrayList<String>();
        lan_array.add("VietNamese");
        lan_array.add("English");
        lan_array.add("French");
        lan_array.add("Chinese");

//khởi tạo đối tượng ArrayAdapter dùng tập hợp dữ liệu và layout spinner mặc định

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lan_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//gán đối tượng adapter đến spinner

        spinLang.setAdapter(adapter);

        //khởi tạo đối tượng Switch


        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cancel(v);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            // thực thi phương thức callback onClick
            public void onClick(View v) {
                String msg = "My name: " + editName.getText().toString() +
                        System.getProperty("line.separator") +
                        "Email: " + editEmail.getText().toString()
                        + System.getProperty("line.separator") +
                        "Giới tính: ";

                editName.setText("");
                editEmail.setText("");

                if(rdFemale.isChecked())
                    msg += rdFemale.getText().toString()+ System.getProperty("line.separator") +"Sở thích: ";
                if(rdMale.isChecked())
                    msg += rdMale.getText().toString()+ System.getProperty("line.separator") +"Sở thích: ";

                if(chk1.isChecked())
                    msg +=  chk1.getText().toString()+ ", ";
                if(chk2.isChecked())
                    msg += chk2.getText().toString() + ", ";
                if(chk3.isChecked())
                    msg += chk3.getText().toString()+ ", ";



                rdFemale.setChecked(false);
                rdMale.setChecked(false);

                msg += System.getProperty("line.separator") + "Ngôn ngữ: " +
                        spinLang.getSelectedItem().toString()
                        + System.getProperty("line.separator") + "Kinh nghiệm java: ";
                if(switchExpert.isChecked())
                    msg += "Yes";
                else
                    msg += "No";
                info(v,msg);

            }
        });

    }
    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Tin ");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
    public void cancel(View v) {System.exit(  0);}
}
