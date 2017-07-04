package florent37.github.com.mam.ui.versions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import florent37.github.com.mam.R;
import florent37.github.com.mam.common.BaseActivity;
import florent37.github.com.mam.model.App;

public class VersionsActivity extends BaseActivity {

    static final String APP = "APP";

    public static Intent newInstance(Context context, App app){
        return new Intent(context, VersionsActivity.class)
                .putExtra(APP, app);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayApp((App) getIntent().getSerializableExtra(APP));
    }

    public void displayApp(App app) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, VersionsListFragment.newInstance(app))
                .commitAllowingStateLoss();
    }
}
