package akturk.contextualview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import akturk.contextualview.R;
import akturk.contextualview.interfaces.ContextualButtonClickListener;

public class ContextualView extends LinearLayout implements View.OnClickListener {

    private Button mButtonPositive;
    private Button mButtonNegative;

    private ContextualButtonClickListener mListener;

    public ContextualView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            initView();
            initAttributes(attrs);
        }
    }

    public ContextualView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            initView();
            initAttributes(attrs);
        }
    }

    private void initView() {
        inflate(getContext(), R.layout.cell_contextual, this);

        mButtonNegative = (Button) findViewById(R.id.contextualview_button_negative);
        mButtonNegative.setOnClickListener(this);

        mButtonPositive = (Button) findViewById(R.id.contextualview_button_positive);
        mButtonPositive.setOnClickListener(this);
    }

    private void initAttributes(AttributeSet attributeSet) {
        TypedArray mTypedArray = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ContextualView, 0, 0);

        try {
            String mStringNegative = mTypedArray.getString(R.styleable.ContextualView_text_negative);
            mButtonNegative.setText(mStringNegative);

            String mStringPositive = mTypedArray.getString(R.styleable.ContextualView_text_positive);
            mButtonPositive.setText(mStringPositive);
        } finally {
            mTypedArray.recycle();
        }

    }


    @Override
    public void onClick(View view) {
        if (mListener == null)
            return;

        switch (view.getId()) {
            case R.id.contextualview_button_negative:
                mListener.onNegativeButtonClick();
                return;
            case R.id.contextualview_button_positive:
                mListener.onPositiveButtonClick();
                return;
        }
    }


    public void setOnContextualButtonClickListener(ContextualButtonClickListener mListener) {
        this.mListener = mListener;
    }
}
