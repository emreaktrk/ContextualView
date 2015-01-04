package com.akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ContextualView extends LinearLayout implements View.OnClickListener {
    private OnContextualClickListener mListener;
    private ContextualButton mNegativeContextualButton;
    private ContextualButton mPositiveContextualButton;

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.contextual_view, this);

        mNegativeContextualButton = (ContextualButton) findViewById(R.id.contextual_button_negative);
        mNegativeContextualButton.setOnClickListener(this);

        mPositiveContextualButton = (ContextualButton) findViewById(R.id.contextual_button_positive);
        mPositiveContextualButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener == null)
            return;

        int id = v.getId();
        if (id == R.id.contextual_button_negative)
            mListener.onNegativeContextualButtonClick();
        else if (id == R.id.contextual_button_positive)
            mListener.onPositiveContextualButtonClick();
    }

    public void setNegativeText(CharSequence text){
        mNegativeContextualButton.setText(text);
    }

    public void setPositiveText(CharSequence text){
        mPositiveContextualButton.setText(text);
    }

    public void setContextualClickListener(ContextualView.OnContextualClickListener listener) {
        this.mListener = listener;
    }

    public static interface OnContextualClickListener {
        public void onNegativeContextualButtonClick();

        public void onPositiveContextualButtonClick();
    }
}
