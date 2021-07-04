package com.example.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class Applyforleavesfragment extends Fragment {
    Button applyforleavesbtn;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.apply_for_leaves,container,false);

        applyforleavesbtn=v.findViewById(R.id.apply_for_leavesbtn);

        applyforleavesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Fragment applyforleavescalender=new apply_for_leaves_calender();
               FragmentTransaction fragmentTransaction=getActivity().getFragmentManager().beginTransaction();
//               fragmentTransaction.replace(R.id.fragment_home, new )
               fragmentTransaction.replace(R.id.app_for_leaves, applyforleavescalender);
               applyforleavesbtn.setVisibility(View.GONE);
               fragmentTransaction.commit();
//                android.app.FragmentManager fragmentManager = getActivity().getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();beginTransaction

            }
        });
        return v;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.applyforleaves, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}