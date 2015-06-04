package shuza.sa.babyapp;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import shuza.sa.babyapp.adapter.CategoryAdapter;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    ImageView ivUnlock;
    Handler handler;
    int count;
    boolean lock;
    HomeKeyLocker homeKeyLocker;
    ArrayList<String> category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);
        ivUnlock = (ImageView) findViewById(R.id.ivUnlock);
        ivUnlock.setOnClickListener(this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        category = new ArrayList<String>();
        category.add("Food");
        category.add("Number");
        isAppPurchase();
        viewPager.setAdapter(new CategoryAdapter(getSupportFragmentManager(), category));

        handler = new Handler();
        count = 0;
        lock = true;
    }

    private void isAppPurchase() {
        SharedPreferences sp = getSharedPreferences(Utility.FILENAME, 0);
        boolean isPurchase = sp.getBoolean(Utility.IS_PURCHASE, false);
        if(isPurchase){
            category.add("Animal");
            category.add("Alphabet");
        }
    }

    @Override
    public void onClick(View view) {
        if(lock){
            if(count >= 3){
                lock = false;
                Toast.makeText(this, "Unlocked", Toast.LENGTH_SHORT).show();
                count = 0;
            }
            count++;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    count = 0;
                }
            }, 2000);
        }else{
            lock = true;
        }
    }

    @Override
    public void onBackPressed() {
        if(!lock){
            super.onBackPressed();
        }
    }
}