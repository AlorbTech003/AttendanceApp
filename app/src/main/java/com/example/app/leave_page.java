package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class leave_page extends Fragment {
    Button leave;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.apply_for_leaves, container, false);
        leave=v.findViewById(R.id.apply_for_leavesbtn);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





        return v;
    }

}
