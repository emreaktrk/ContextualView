package com.akturk.contextualview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

final class AttributeHelper {
    private CharSequence mPositiveText;
    private CharSequence mNegativeText;
    private int mPositiveTextColor;
    private int mNegativeTextColor;
    private int mBackgroundResource;

    AttributeHelper(Context context, AttributeSet attrs) {
        setDefaultValues();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ContextualView);
        mPositiveText = typedArray.getText(R.styleable.ContextualView_positiveText);
        mNegativeText = typedArray.getText(R.styleable.ContextualView_negativeText);
        mPositiveTextColor = typedArray.getColor(R.styleable.ContextualView_positiveTextColor, Color.BLACK);
        mNegativeTextColor = typedArray.getColor(R.styleable.ContextualView_negativeTextColor, Color.BLACK);
        mBackgroundResource = typedArray.getResourceId(R.styleable.ContextualView_buttonBackground, android.R.color.transparent);

        typedArray.recycle();
    }

    private void setDefaultValues() {
        mPositiveText = "Positive";
        mNegativeText = "Negative";
        mBackgroundResource = android.R.color.transparent;
        mPositiveTextColor = Color.BLACK;
        mNegativeTextColor = Color.BLACK;
    }

    public CharSequence getPositiveText() {
        return mPositiveText;
    }

    public CharSequence getNegativeText() {
        return mNegativeText;
    }

    public int getPositiveTextColor() {
        return mPositiveTextColor;
    }

    public int getNegativeTextColor() {
        return mNegativeTextColor;
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }
}
