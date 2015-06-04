package shuza.sa.babyapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import shuza.sa.babyapp.util.IabHelper;
import shuza.sa.babyapp.util.IabResult;
import shuza.sa.babyapp.util.Purchase;

/**
 * Created by Boka on 31-May-15.
 */
public class WellcomeActivity extends Activity implements View.OnClickListener {
    Button btnSwipe, btnPack;

    String SKU = "abcdefghij1234567890";
    IabHelper mHelper;
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        btnSwipe = (Button) findViewById(R.id.btnLetsSwipe);
        btnPack = (Button) findViewById(R.id.btnPack);
        btnSwipe.setOnClickListener(this);
        btnPack.setOnClickListener(this);

        String base64EncodedPUblicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqB9Q3xLqZHsm9sVo5s/K7vl6byzRLYYUa2phbb1mCXt7ACyihiFVn8u/GmXZRjGBA3/pewCGeo3ftTwnOhWo1LCf6LekLsu+UCWsSM3zVMDAEAbr9W2p+240GrtK+OOYkENSzE/y9w8CwS91s0ARhswkmu2wIMe1fj8TwPCT+w48o5WAd+lzVjBtOiptYiYKDLGyBlADxqjAJasqc5VQTDbjBxu9Hig+pQj+gDG+yvjcf7oI49gdCdfg8Puz8LogtAeZXKszIGq2z1gkxyGfrALSwqQ4eQRfcSD0wj5LpsIblWwjcMcR0qSYI4Hkc2J+VK2b7KkCJrJ4lTMOPfcFHQIDAQAB";

        mHelper = new IabHelper(this, base64EncodedPUblicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            @Override
            public void onIabSetupFinished(IabResult result) {
                if(!result.isSuccess()){
                    Log.d("shuza", "Problem setting in app bittling " + result.getMessage());
                }
            }
        });
        mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
            @Override
            public void onIabPurchaseFinished(IabResult result, Purchase info) {
                if(result.isFailure()){
                    Toast.makeText(WellcomeActivity.this, "Faild to purchase!", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences sp = getSharedPreferences(Utility.FILENAME, 0);
                sp.edit().putBoolean(Utility.IS_PURCHASE, true).commit();
                Toast.makeText(WellcomeActivity.this, "Purchase successfully", Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLetsSwipe:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnPack:
                mHelper.launchPurchaseFlow(this, SKU, 1001, mPurchaseFinishedListener, SKU);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }
}
