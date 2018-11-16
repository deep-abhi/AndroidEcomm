package com.softcrylic.androidtutorials.activity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.softcrylic.androidtutorials.R;

public class ContentActivity extends AppCompatActivity {
    Toast toast;
    public static int ItemIndex = 0;
    String[] IntentTopic = {"Implicit Intent","Explicit Intent"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

    }

    public void topicClicked(View view) {
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.topicButton1:
               toast =toast.makeText(getApplicationContext(), "1",Toast.LENGTH_SHORT);
                toast.show();
                ItemIndex = 0;
                describeScreen();
                    // male
                    break;
            case R.id.topicButton2:
                ItemIndex = 1;
                Button  btn = (Button) findViewById(R.id.topicButton2);
                btn.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        listIntent();
                        return true;
                    }
                });
                    break;
        }


}
public void describeScreen(){
    startActivity(new Intent(ContentActivity.this,DescribeActivity.class));

}

public void listIntent(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Pick a topic");
    builder.setItems(IntentTopic, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // the user clicked on colors[which]
            describeScreen();
        }
    });
    builder.show();
}
}
