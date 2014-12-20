package akturk.contextualview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ContextualView extends LinearLayout implements View.OnClickListener {

    private OnContextualButtonClickListener mListener;

    public ContextualView(Context context) {
        super(context);

        if (!isInEditMode())
            init();
    }

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            init();
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        ContextualButton contextualButton = (ContextualButton) v;
        mListener.onContextualButtonClick(contextualButton);
    }

    public void setOnContextualButtonClickListener(OnContextualButtonClickListener callback) {
        mListener = callback;
    }

    public static interface OnContextualButtonClickListener {
        public void onContextualButtonClick(ContextualButton button);
    }

}
