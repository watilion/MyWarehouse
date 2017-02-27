package com.watilion.mywarehouse.query;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.watilion.mywarehouse.MainActivity;
import com.watilion.mywarehouse.R;
import com.watilion.mywarehouse.listview.ListActivity;

/**
 * Created by watilion on 2017/2/26 0026.
 */

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        Button btn_query = (Button) findViewById(R.id.btn_query1);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel1);

        btn_query.setOnClickListener(new ButtonListener());
        btn_cancel.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_query1:
                    EditText edt_querynumber = (EditText) findViewById(R.id.edt_querynumber);
                    String querynumber= String.valueOf(edt_querynumber.getText());
                    Intent intent=new Intent(QueryActivity.this, ListActivity.class);
                    Bundle bunuel=new Bundle();
                    bunuel.putCharSequence("querynumber",querynumber);
                    intent.putExtras(bunuel);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.btn_cancel1:
                    Intent intent1=new Intent(QueryActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
            }
        }
    }
}
