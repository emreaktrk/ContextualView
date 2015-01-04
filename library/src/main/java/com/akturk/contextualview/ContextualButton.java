package com.akturk.contextualview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.LinearLayout;

public class ContextualButton extends Button {

    public ContextualButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ContextualButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = LayoutParamsProvider.getInstance();
        setLayoutParams(layoutParams);
    }
}
