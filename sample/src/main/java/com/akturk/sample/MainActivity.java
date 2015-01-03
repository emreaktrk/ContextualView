package com.akturk.sample;

import android.app.Activity;
import android.os.Bundle;

import com.akturk.contextualview.ContextualButton;
import com.akturk.contextualview.ContextualView;
import com.akturk.contextualview.OnContextualButtonClickListener;


public class MainActivity extends Activity implements OnContextualButtonClickListener {
    private ContextualView mContextualView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        mContextualView = (ContextualView) findViewById(R.id.activity_main_contextualview);
        mContextualView.setOnContextualButtonClickListener(this);
    }

    @Override
    public void onContextualButtonClick(ContextualButton button) {

    }
}
