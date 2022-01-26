package com.theost.surfacegame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton buttonPlay;
    private ImageButton buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonScore = findViewById(R.id.buttonScore);
        buttonPlay.setOnClickListener(this);
        buttonScore.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == buttonPlay) {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }

        if (v == buttonScore) {
            startActivity(new Intent(MainActivity.this, HightScore.class));
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы хотите выйти?")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> {

                    GameView.stopMusic();
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    finish();
                })
                .setNegativeButton("Нет", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();

    }
}
