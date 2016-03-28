package com.tbvanderleystudios.joke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button delayedMessageServiceButton = (Button) findViewById(R.id.delayedMessageServiceButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DelayedMessageService.class);
                intent.putExtra(DelayedMessageService.EXTRA_MESSAGE, getString(R.string.button_response));
                startService(intent);
            }
        };

        delayedMessageServiceButton.setOnClickListener(listener);
    }
}
