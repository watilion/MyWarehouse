package com.watilion.mywarehouse.enter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.watilion.mywarehouse.MainActivity;
import com.watilion.mywarehouse.R;
import com.watilion.mywarehouse.utils.Constant;
import com.watilion.mywarehouse.utils.DbManger;
import com.watilion.mywarehouse.utils.MySqliteHelper;

/**
 * Created by watilion on 2017/2/26 0026.
 */

public class EnterActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_modelnumber;
    private EditText edt_number;
    private EditText edt_location;
    private MySqliteHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        edt_name= (EditText) findViewById(R.id.edt_name);
        edt_modelnumber= (EditText) findViewById(R.id.edt_modelnumber );
        edt_number= (EditText) findViewById(R.id.edt_number);
        edt_location= (EditText) findViewById(R.id.edt_location);

        Button btn_save = (Button) findViewById(R.id.btn_save);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_save.setOnClickListener(new ButtonListener());
        btn_cancel.setOnClickListener(new ButtonListener());
        helper= DbManger.getIntace(this);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_save:
                    SQLiteDatabase db=helper.getWritableDatabase();
                    String sql="insert into "+Constant.TABLE_NAME+"("+Constant._ID+","+Constant.NAME+","+Constant.MODELNUMBER+","+Constant.NUMBER+","+Constant.LOCATION+") values(null,'"+edt_name.getText()+"','"+edt_modelnumber.getText()+"','"+edt_number.getText()+"','"+edt_location.getText()+"')";
                    db.execSQL(sql);
                    db.close();
                    Intent intent=new Intent(EnterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.btn_cancel:
                    Intent intent1=new Intent(EnterActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}