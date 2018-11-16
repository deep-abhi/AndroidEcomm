package com.softcrylic.androidtutorials.activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.softcrylic.androidtutorials.R;

import org.w3c.dom.Text;

public class DescribeActivity extends AppCompatActivity {
    public int index ;
    public TextView text;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describe);
        res = getResources();
        text = (TextView) findViewById(R.id.describeText);
        index = ContentActivity.ItemIndex;
        setText(index);

    }

    public void setText(int item){
        switch (index){
            case 0 : text.setText(res.getString(R.string.AboutActivity));
            getSupportActionBar().setTitle("About Activity");
                break;
            case 1 :text.setText(res.getString(R.string.AboutIntent));
                getSupportActionBar().setTitle("About Intent");
                break;
            case 2 :
                break;
                default:

        }
    }
}
