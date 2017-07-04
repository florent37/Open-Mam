package florent37.github.com.mam.ui.apps;

import android.os.Bundle;

import florent37.github.com.mam.R;
import florent37.github.com.mam.common.BaseActivity;

public class AppsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayApps();
    }

    public void displayApps() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, AppsListFragment.newInstance())
                .commitAllowingStateLoss();
    }
}
