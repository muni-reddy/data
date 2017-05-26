package com.example.muni.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.ContactsContract.Intents.Insert.PHONE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String message="";
    String no;
    CharSequence gen="";
    EditText editText, editno;
    TextView txtView;
    private RadioButton radioSexButton;
    private RadioGroup radioSexGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);

        editText = (EditText) findViewById(R.id.editname);

        editno = (EditText) findViewById(R.id.editphone);

        Button button = (Button) findViewById(R.id.button);
          txtView = (TextView) findViewById(R.id.text);


        editno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no = editno.getText().toString();
                message = editText.getText().toString();
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = (RadioButton) findViewById(selectedId);
                if (radioSexButton != null) {
                    gen = radioSexButton.getText().toString();
                    if (message.equals("") || no.equals("")) {
                        Toast.makeText(getApplicationContext(), "enter your name and phone no",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    txtView.setText("name:" + message + "\n" + "phone no:" + no + "\n" + "gender :" + gen);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
              sendMessage();
                return true;
            case R.id.item2:
               send() ;
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void send() {
        getadta();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Name:" + message + "\n" + "Phone no:" + no + "\n" + "Gender :" +gen);

        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    public void sendMessage() {
        getadta();
        Intent intent = new Intent(this, Main2Activity.class);

            intent.putExtra(EXTRA_MESSAGE,message);
            intent.putExtra("Phone",no);
            intent.putExtra("gender",gen);
            startActivity(intent);
        }
     public void getadta(){
         no = editno.getText().toString();
         message = editText.getText().toString();
         int selectedId = radioSexGroup.getCheckedRadioButtonId();
         radioSexButton = (RadioButton) findViewById(selectedId);
         gen = radioSexButton.getText().toString();

     }
    }


