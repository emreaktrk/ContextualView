package com.akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ContextualLayout extends LinearLayout implements View.OnClickListener {
    private OnContextualClickListener mListener;

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

    private void init() {
        setOrientation(HORIZONTAL);
        setListeners();
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

        int id = v.getId();
        mListener.onContextualButtonClick(v, id);
    }

    public void setContextualClickListener(ContextualLayout.OnContextualClickListener listener) {
        this.mListener = listener;
    }

    public static interface OnContextualClickListener {
        public void onContextualButtonClick(View button, long id);
    }

}
