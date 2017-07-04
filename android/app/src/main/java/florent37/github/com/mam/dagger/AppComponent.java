package florent37.github.com.mam.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import florent37.github.com.mam.ui.apps.AppsActivity;
import florent37.github.com.mam.MainApplication;
import florent37.github.com.mam.ui.apps.AppsListFragment;
import florent37.github.com.mam.ui.versions.VersionsListFragment;

/**
 * Created by florentchampigny on 18/05/2017.
 */

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context){
        return ((MainApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(AppsActivity appsActivity);

    public abstract void inject(AppsListFragment appsListFragment);

    public abstract void inject(VersionsListFragment versionsListFragment);
}
