//package com.open.learncode.android.bitmap;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import learncode.open.com.learncode.R;
//
//public class BitmapActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BigView bigView=findViewById(R.id.bigView);
//        InputStream is=null;
//        try{
//            //加载图片
//            is=getAssets().open("big.png");
//            bigView.setImage(is);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            if(is!=null){
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//}
