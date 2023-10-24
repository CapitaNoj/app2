package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class TestResources extends AppCompatActivity {

    private boolean isSurbscribed = false;
    private Button colorChangeButton;
    private View mainLoyout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_resources);

        String profileName = "@alex";
        setTitle("Профиль пользователя" + profileName);

        Button buttonSub = findViewById(R.id.buttonSubscribe);
        buttonSub.setOnClickListener(view -> {
            if (isSurbscribed) {
                Snackbar snackbar = Snackbar.make(view, "Вы точно хотите отписаться?" + profileName + "?" , Snackbar.LENGTH_SHORT)
                        .setAction("Да, отписться", v -> {
                            buttonSub.setBackgroundColor(getResources().getColor(R.color.notSurbscribeButtonColor));
                            buttonSub.setText("Подписаться");

                            isSurbscribed = !isSurbscribed;
                        });
                snackbar.show();
            } else {
                buttonSub.setBackgroundColor(getResources().getColor(R.color.SurbscribeButtonColor));
                buttonSub.setText("Отписаться");

                Toast toast = Toast.makeText(getApplicationContext(), "Вы подписались на" + profileName, Toast.LENGTH_SHORT);
                toast.show();

                isSurbscribed = !isSurbscribed;
            }

        });

        colorChangeButton = findViewById(R.id.changeColorButton);
        mainLoyout = findViewById(R.id.main_layout);

        colorChangeButton.setOnClickListener(v -> changeBackgroundColor());
    }
    private void changeBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        mainLoyout.setBackgroundColor(color);
    }
}