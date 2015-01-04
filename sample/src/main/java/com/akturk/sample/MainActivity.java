package com.akturk.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.akturk.contextualview.ContextualView;


public class MainActivity extends ActionBarActivity implements ContextualView.OnContextualClickListener {
    private ContextualView mContextualView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    @Override
    public void onSupportContentChanged() {
        super.onContentChanged();

        mContextualView = (ContextualView) findViewById(R.id.activity_main_contextualview);
        mContextualView.setContextualClickListener(this);
    }


    @Override
    public void onNegativeContextualButtonClick() {

    }

    @Override
    public void onPositiveContextualButtonClick() {

    }
}
