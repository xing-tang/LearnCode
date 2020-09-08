package com.open.learncode.android.三级缓存

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.ListView
import learncode.open.com.learncode.R
import java.io.File


class ImageCacheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_cache)

        // 创建文件路径
        var dir: File? = null
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
             dir = File(getExternalFilesDir(null)!!.path + "ImageCache")
            if (!dir.exists()) {
                dir.mkdir()
            }
        }
        ImageCache.getInstance().init(this, dir!!.path)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ImageCacheAdapter(this)
        //假设是从网络上来的
        val options = BitmapFactory.Options()
        //如果要复用，需要设计成异变
        options.inMutable = true
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.wyz_p, options)
        for (i in 0..99) {
            options.inBitmap = bitmap
            bitmap = BitmapFactory.decodeResource(resources, R.drawable.wyz_p, options)
        }
    }

    internal fun i(bitmap: Bitmap) {
        Log.i("BitmapCache", "图片" + bitmap.width + "x" + bitmap.height + " 内存大小是:" + bitmap.byteCount)
    }
}
