package com.example.fragments_5a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NamesFragment.OnNameClicked {

    TextView tvDetail;
    // hook to check mode
    View portrait;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        manager = getSupportFragmentManager();
        tvDetail = Objects.requireNonNull(manager.findFragmentById(R.id.detail_frag)).requireView().findViewById(R.id.tvDetail);
        portrait = findViewById(R.id.portrait);



        tvDetail.setText("Select Passenger from Left Panel");

        if(portrait!=null)
        {
            manager.beginTransaction()
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.names_frag)))
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.detail_frag)))
                    .commit();
        }
        else
        {
            manager.beginTransaction()
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.names_frag)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.detail_frag)))
                    .commit();
        }
    }

    @Override
    public void onClick(int position) {
       // Toast.makeText(this, "Index : "+position, Toast.LENGTH_SHORT).show();
        Passenger p = MyApplication.passengers.get(position);
        String text = "NAME : "+p.getName()+"\nPREFERENCE : "+p.getPreference()+"\nPAYMENT : "+p.getPayment()+"\nSEAT #. : "+p.getSeat_number()+"\nCONTACT #. : "+p.getContact_number()+"\n";
        tvDetail.setText(text);

        if(portrait!=null)
        {
            manager.beginTransaction()
                    .hide(Objects.requireNonNull(manager.findFragmentById(R.id.names_frag)))
                    .show(Objects.requireNonNull(manager.findFragmentById(R.id.detail_frag)))
                    .addToBackStack(null)
                    .commit();
        }
    }
}