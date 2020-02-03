package com.example.newmyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RegencyDetailPage extends AppCompatActivity {

    private static final String TAG = "RegencyDetailPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regency_detail_page);
        getIncomingIntent();
    }
    private void getIncomingIntent() {
        Log.d(TAG, "getIntent: checking for incoming intent");
        if(getIntent().hasExtra("name") && getIntent().hasExtra("info") && getIntent().hasExtra("image")
                )
        {
            Log.d(TAG, "getIncomingIntent: intent extra found");
            String extraName=getIntent().getStringExtra("name");

            String extraInfo=getIntent().getStringExtra("info");
            String extraImage=getIntent().getStringExtra("image");

            setName(extraName);
            setInfo(extraInfo);
//            setImage(extraImage);


        }

    }

    private void setName(String extraName)
    {
        TextView name = findViewById(R.id.txtDetailName);
        name.setText(extraName);
    }
//    private void setImage(String extraImage) {
//        ImageView imageView = findViewById(R.id.imageViewDetail);
//        Glide.with(this).asBit
//    }


    private void setInfo(String extraInfo) {
        TextView info = findViewById(R.id.txtDetailInfo);
        info.setText(extraInfo);
    }
}
