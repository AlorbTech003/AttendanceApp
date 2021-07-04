package com.example.app;

import android.app.Fragment;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;



import java.util.Date;


public class apply_for_leaves_calender extends Fragment {
    Spinner spinner;
    EditText reason;
    ArrayAdapter<CharSequence> adapter;
    Context thiscontext;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
         CalendarView calendar_view = v.findViewById(R.id.Date_picker);
//getting current
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Date today = new Date();

//add one year to calendar from todays date

        Spinner spinner=v.findViewById(R.id.spinner_leaves);
reason=v.findViewById(R.id.reasonforleave);
       thiscontext = container.getContext();
        super.onActivityCreated(savedInstanceState);
        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.type_of_leaves, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.isEnabled(1);

        spinner.setAdapter(adapter);




        return v;
    }



}
