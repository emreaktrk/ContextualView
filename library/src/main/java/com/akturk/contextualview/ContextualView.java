package com.akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;

public class ContextualView extends ContextualLayout {

    public ContextualView(Context context) {
        super(context);
    }

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        addButtons();
    }

    private void addButtons() {
        Context context = getContext();
        ContextualButton positiveContextualButton = new ContextualButton
                .Builder(context)
                .setText("Accept")
                .setId(R.id.positive_contextual_button)
                .build();

        ContextualButton negativeContextualButton = new ContextualButton
                .Builder(context)
                .setText("Decline")
                .setId(R.id.negative_contextual_button)
                .build();

        addView(positiveContextualButton);
        addView(negativeContextualButton);
    }
}
