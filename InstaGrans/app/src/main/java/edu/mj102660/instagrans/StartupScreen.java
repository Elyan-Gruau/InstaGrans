package edu.mj102660.instagrans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class StartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.coc);
        mp.setVolume((float) 1, (float) 1);
        mp.start();


        //buttonDisplayed.replace(btnFondu,false);
        ImageView logo = findViewById(R.id.logo);
        TextView text = findViewById(R.id.textView);

        logo.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        logo.startAnimation(AnimationUtils.loadAnimation(
                StartupScreen.this, R.anim.fade));
        text.startAnimation(AnimationUtils.loadAnimation(
                StartupScreen.this, R.anim.fade_text));
        logo.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);



        Intent intent = new Intent(this, MainActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(() -> startActivity(intent), 3000);
    }

}