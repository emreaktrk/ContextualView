package akturk.contextualview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import akturk.contextualview.R;
import akturk.contextualview.interfaces.ContextualButtonClickListener;
import akturk.contextualview.view.ContextualView;


public class TestActivity extends Activity implements ContextualButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        ContextualView mContextualView = (ContextualView) findViewById(R.id.activity_test_contextualview);
        mContextualView.setOnContextualButtonClickListener(this);
    }

    @Override
    public void onPositiveButtonClick() {
        Toast.makeText(getApplicationContext(), "Positive", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(getApplicationContext(), "Negative", Toast.LENGTH_SHORT).show();
    }
}
