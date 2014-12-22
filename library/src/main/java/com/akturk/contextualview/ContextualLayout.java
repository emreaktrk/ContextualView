package com.akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ContextualLayout extends LinearLayout implements View.OnClickListener {

    private OnContextualButtonClickListener mListener;

    public ContextualLayout(Context context) {
        super(context);

        if (!isInEditMode())
            init();
    }

    public ContextualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            init();
    }

    public ContextualLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            init();
    }

    protected void init() {
        setOrientation(HORIZONTAL);
    }

    private void setListeners() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewChild = getChildAt(i);
            if (viewChild instanceof ContextualButton)
                viewChild.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (mListener == null)
            return;

        ContextualButton contextualButton = (ContextualButton) v;
        mListener.onContextualButtonClick(contextualButton);
    }

    public void setOnContextualButtonClickListener(OnContextualButtonClickListener callback) {
        setListeners();
        mListener = callback;
    }

}
