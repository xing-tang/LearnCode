package com.open.learncode.android.view的事件分发;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

/**
 * ParentView
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class ParentView extends ScrollView {

    public ParentView(Context context) {
        super(context);
    }

    public ParentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
