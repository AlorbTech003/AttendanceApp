package com.example.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.github.tibolte.agendacalendarview.widgets.FloatingActionButton;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class splash_screen extends AppCompatActivity {
    private FragmentManager fragmentManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash_screen);
        fragmentManager = getSupportFragmentManager();
        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.splash_screen, paperOnboardingFragment);
        fragmentTransaction.commit();


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(splash_screen.this, MainActivity.class));
                finish();
            }
        }, 4000);


    // Intent intent=new Intent(this,MainActivity.class);
       // startActivity(intent);

        //finish();

    }

    private ArrayList<PaperOnboardingPage> getDataforOnboarding() {

        PaperOnboardingPage src1 = new PaperOnboardingPage("Easy Access ! !", "adipiscing elit. Sed pellentesque varius dui nec lobortis. In a nunc a erat hendrerit mollis.", Color.parseColor("#6495ED"), R.drawable.splash_screen, R.drawable.ic_baseline_arrow_forward_24);
        PaperOnboardingPage src2 = new PaperOnboardingPage("Manage Task Easily !", "adipiscing elit. Sed pellentesque varius dui nec lobortis. In a nunc a erat hendrerit mollis.", Color.parseColor("#6495ED"), R.drawable.splashscreen1, R.drawable.ic_baseline_arrow_forward_24);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(src1);
        elements.add(src2);
        return elements;
    }

}
