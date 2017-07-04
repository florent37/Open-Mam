package florent37.github.com.mam;

import android.app.Application;

import com.facebook.stetho.Stetho;

import florent37.github.com.mam.dagger.AppComponent;
import florent37.github.com.mam.dagger.AppModule;
import florent37.github.com.mam.dagger.DaggerAppComponent;

/**
 * Created by florentchampigny on 18/06/2017.
 */

public class MainApplication extends Application{
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Stetho.initializeWithDefaults(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
