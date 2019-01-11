package com.loaderman.signaturedemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignatureActivity.class));
            }
        });
        iv = findViewById(R.id.iv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bitmap loacalBitmap = getLoacalBitmap(new File(FileUtil.getFile(), "signature.png"));
        if (loacalBitmap != null) {
            iv.setImageBitmap(loacalBitmap);
        }
    }

    /**
     * 加载本地图片
     *
     * @param file
     * @return
     */
    public static Bitmap getLoacalBitmap(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
