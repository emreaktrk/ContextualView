package com.akturk.contextualview;

import android.widget.LinearLayout;

final class LayoutParamsProvider {
    private static LinearLayout.LayoutParams mLayoutParams;

    public static LinearLayout.LayoutParams getInstance() {
        if (mLayoutParams == null)
            mLayoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);

        return mLayoutParams;
    }

    private LayoutParamsProvider() {
    }
}
