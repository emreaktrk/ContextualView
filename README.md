ContextualView
==============
This library is inspired from Chris Banes' Done Discard bar. It has material design already.

Install
--------------
```groovy
repositories {
    maven { url 'http://raw.github.com/emreaktrk/ContextualView/master/repository/' }
}

dependencies {
    compile 'com.akturk.contextualview:release:1.0.0@aar'
}
```

Usage
--------------
* ContextualView
```xml
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.akturk.contextualview.ContextualView
        android:id="@+id/contextual_view"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_gravity="bottom"
        android:background="@android:color/holo_blue_dark"/>
    </FrameLayout>
```

```java
public class MainActivity extends ActionBarActivity implements OnContextualButtonClickListener {
    private ContextualView mContextualView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();

        mContextualView = (ContextualView) findViewById(R.id.contextual_view);
        mContextualView.setOnContextualButtonClickListener(this);
    }

    @Override
    public void onContextualButtonClick(ContextualButton contextualButton) {
        int id = contextualButton.getId();
        switch (id) {
            case R.id.positive_contextual_button:
                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show();
                return;
            case R.id.negative_contextual_button:
                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show();
                return;
        }
    }
}
```
* ContextualLayout
* ```xml
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.akturk.contextualview.ContextualLayout
        android:id="@+id/contextual_view"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_gravity="bottom"
        android:background="@android:color/holo_blue_dark">

        <com.akturk.contextualview.ContextualButton
            android:id="@+id/my_first_button"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="@null"/>

        <com.akturk.contextualview.ContextualButton
            android:id="@+id/my_second_button"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="@null"/>

        <com.akturk.contextualview.ContextualButton
            android:id="@+id/my_third_button"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="@null"/>
    </com.akturk.contextualview.ContextualLayout>

</FrameLayout>
```

```java
public class MainActivity extends ActionBarActivity implements OnContextualButtonClickListener {
    private ContextualLayout mContextualLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();

        mContextualLayout = (ContextualLayout) findViewById(R.id.contextual_view);
        mContextualLayout.setOnContextualButtonClickListener(this);
    }

    @Override
    public void onContextualButtonClick(ContextualButton contextualButton) {
        int id = contextualButton.getId();
        switch (id) {
            case R.id.my_first_button:
                Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
                return;
            case R.id.my_second_button:
                Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
                return;
            case R.id.my_third_button:
                Toast.makeText(this, "Third", Toast.LENGTH_SHORT).show();
                return;
        }
    }
}
```

TODO
--------------
* Ripple effect
* XML attributes
* Push to maven central

Contribution
--------------
1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

Licence
--------------
Copyright 2014 Emre Akturk

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

Author
--------------
[Emre Akturk](https://github.com/emreaktrk)
