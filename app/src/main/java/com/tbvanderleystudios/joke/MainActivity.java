package com.tbvanderleystudios.joke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button delayedMessageServiceButton = (Button) findViewById(R.id.delayedMessageServiceButton);
        final EditText messageEditText = (EditText) findViewById(R.id.messageEditText);



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (messageEditText != null) {
                    if(messageEditText.getText().toString().trim().length() != 0) {
                        String message = messageEditText.getText().toString();
                        Intent intent = new Intent(MainActivity.this, DelayedMessageService.class);
                        intent.putExtra(DelayedMessageService.EXTRA_MESSAGE, message);
                        startService(intent);
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, "You didn't enter a message", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        };

        // This if statement was created to remove the possibility of a null pointer exception.
        if(delayedMessageServiceButton != null) {
            delayedMessageServiceButton.setOnClickListener(listener);
        }
    }
}
