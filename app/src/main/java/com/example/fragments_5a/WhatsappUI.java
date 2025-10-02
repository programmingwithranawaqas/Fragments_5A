package com.example.fragments_5a;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WhatsappUI extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;
    boolean isVisited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_whatsapp_ui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        isVisited = false;
        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i)
                {
                    case 0:
                        tab.setText("Chats");
                        BadgeDrawable bd = tab.getOrCreateBadge();
                        bd.setMaxCharacterCount(2);
                        bd.setNumber(1000);
                        break;
                    case 1:
                        tab.setText("Calls");
                        BadgeDrawable bd1 = tab.getOrCreateBadge();
                        bd1.setMaxCharacterCount(2);
                        bd1.setNumber(1000);
                        break;
                    case 2:
                        tab.setText("Settings");
                        break;
                    default:
                        tab.setText("Chats");
                        break;
                }
            }
        });

        mediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(!isVisited)
                    {
                        isVisited = true;
                    }
                    else {
                        TabLayout.Tab tab = tabLayout.getTabAt(position);
                        BadgeDrawable bd = tab.getOrCreateBadge();
                        bd.setNumber(0);
                        bd.setVisible(false);
                    }
                }
        });

    }
}