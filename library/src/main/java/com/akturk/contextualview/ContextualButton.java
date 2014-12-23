package com.akturk.contextualview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.LinearLayout;

public class ContextualButton extends Button {

    public ContextualButton(Context context) {
        super(context);

        if (!isInEditMode())
            init();
    }

    public ContextualButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            init();

    }

    public ContextualButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            init();
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = LayoutParamsProvider.getInstance();
        setLayoutParams(layoutParams);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                getBackground().setColorFilter(Color.argb(150, 255, 255, 255), PorterDuff.Mode.LIGHTEN);
                break;
            case MotionEvent.ACTION_UP:
                getBackground().setColorFilter(null);
                break;
            case MotionEvent.ACTION_CANCEL:
                getBackground().setColorFilter(null);
                break;
        }

        invalidate();
        return super.onTouchEvent(event);
    }

    public static class Builder {
        private Context mContext;
        private CharSequence mText;
        private int mTextColorResource;
        private int mBackgroundResource;
        private int mId;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setText(CharSequence text) {
            mText = text;
            return this;
        }

        public Builder setTextColor(int colorResource) {
            mTextColorResource = colorResource;
            return this;
        }

        public Builder setBackgroundResource(int backgroundResource) {
            mBackgroundResource = backgroundResource;
            return this;
        }

        public Builder setId(int id) {
            mId = id;
            return this;
        }

        public ContextualButton build() {
            ContextualButton contextualButton = new ContextualButton(mContext);
            contextualButton.setText(mText);
            contextualButton.setTextColor(mTextColorResource);
            contextualButton.setBackgroundResource(mBackgroundResource);
            contextualButton.setId(mId);

            return contextualButton;
        }
    }

}
