package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonDel;
    Button buttonDot;
    Button buttonEqually;
    Button buttonMinus;
    Button buttonPlus;
    Button buttonMulriply;
    EditText textInput;
    static boolean DelBaseTextInput = false;

    SaveEditText saveEditText = new SaveEditText();
    Bundle bundle;

    protected static final String keyEditText = "KEY_INPUT_EDIT_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid_layout);
        this.bundle = savedInstanceState;
        butListener();

    }
    private void butListener(){
        this.buttonOne = findViewById(R.id.button_1);
        this.buttonTwo = findViewById(R.id.button_2);
        this.buttonThree = findViewById(R.id.button_3);
        this.buttonFour = findViewById(R.id.button_4);
        this.buttonFive = findViewById(R.id.button_5);
        this.buttonSix = findViewById(R.id.button_6);
        this.buttonSeven = findViewById(R.id.button_7);
        this.buttonEight = findViewById(R.id.button_8);
        this.buttonNine = findViewById(R.id.button_9);
        this.buttonZero = findViewById(R.id.button_0);
        this.buttonDel = findViewById(R.id.button_del);
        this.buttonDot = findViewById(R.id.button_dot);
        this.buttonEqually = findViewById(R.id.button_equally);
        this.buttonMinus = findViewById(R.id.button_minus);
        this.buttonPlus = findViewById(R.id.button_plus);
        this.buttonMulriply = findViewById(R.id.button_mulriply);
        this.textInput = findViewById(R.id.text_input);

        createListener(buttonZero);
        createListener(buttonOne);
        createListener(buttonTwo);
        createListener(buttonThree);
        createListener(buttonFour);
        createListener(buttonFive);
        createListener(buttonSix);
        createListener(buttonSeven);
        createListener(buttonEight);
        createListener(buttonNine);
        createListener(buttonEqually);
        createListener(buttonDel);
        createListener(buttonDot);
        createListener(buttonMulriply);
        createListener(buttonPlus);
        createListener(buttonMinus);
    }

    private void createListener(Button button) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInput.getText() != null && MainActivity.DelBaseTextInput && !textInput.getText().toString().equals("Введите число")) {
                    textInput.setText(textInput.getText().toString() + button.getText().toString());
//                    textInput.setText(saveEditText.restoreText(bundle) + button.getText().toString()); //См. в SaveEditText
//                    saveEditText.saveText(bundle, textInput.getText().toString());  //См. в SaveEditText

                } else {
                    textInput.setText(button.getText().toString());
                    MainActivity.DelBaseTextInput = true;
                }
            }
        });

    }
    // Сохранение данных EditText
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(keyEditText, textInput.getText().toString());
    }

    // Восстановление данных EditText
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        textInput.setText(instanceState.getSerializable(keyEditText).toString());
    }






}