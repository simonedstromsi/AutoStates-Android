package com.example.autostate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPinkNormal = (Button) findViewById(R.id.button_pink_normal);
        Button buttonPinkPressed = (Button) findViewById(R.id.button_pink_pressed);
        buttonPinkPressed.setPressed(true);
        Button buttonPinkDisabled = (Button) findViewById(R.id.button_pink_disabled);
        buttonPinkDisabled.setEnabled(false);
        Button buttonGreenNormal = (Button) findViewById(R.id.button_green_normal);
        Button buttonGreenPressed = (Button) findViewById(R.id.button_green_pressed);
        buttonGreenPressed.setPressed(true);
        Button buttonGreenDisabled = (Button) findViewById(R.id.button_green_disabled);
        buttonGreenDisabled.setEnabled(false);

        AutoState.apply(buttonPinkNormal,buttonPinkPressed, buttonPinkDisabled,
                buttonGreenNormal, buttonGreenPressed, buttonGreenDisabled);
    }


}
