package com.akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;

public class ContextualView extends ContextualLayout {
    private AttributeHelper mAttributeHelper;

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mAttributeHelper = new AttributeHelper(context, attrs);
        addButtons();
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mAttributeHelper = new AttributeHelper(context, attrs);
        addButtons();
    }

    private void addButtons() {
        Context context = getContext();
        ContextualButton positiveContextualButton = new ContextualButton
                .Builder(context)
                .setText(mAttributeHelper.getPositiveText())
                .setTextColor(mAttributeHelper.getPositiveTextColorResource())
                .setBackgroundResource(mAttributeHelper.getBackgroundResource())
                .setId(R.id.positive_contextual_button)
                .build();

        ContextualButton negativeContextualButton = new ContextualButton
                .Builder(context)
                .setText(mAttributeHelper.getNegativeText())
                .setTextColor(mAttributeHelper.getNegativeTextColorResource())
                .setBackgroundResource(mAttributeHelper.getBackgroundResource())
                .setId(R.id.negative_contextual_button)
                .build();

        addView(positiveContextualButton);
        addView(negativeContextualButton);
    }
}
