package florent37.github.com.mam.dagger;

import android.app.Application;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import florent37.github.com.mam.BuildConfig;
import florent37.github.com.mam.api.MamAPI;
import florent37.github.com.mam.bus.MainBus;
import florent37.github.com.mam.repository.AppRepository;
import mam.repository.AppRepositoryImpl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by florentchampigny on 18/05/2017.
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public AppRepository provideAppsRepository(MamAPI mamAPI) {
        return new AppRepositoryImpl(mamAPI);
    }

    @Provides
    @Singleton
    public MainBus provideMainBus() {
        return new MainBus();
    }

    @Provides
    @Singleton
    public OkHttpClient provideMainOkHttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    @Singleton
    public MamAPI providesGithubApi(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.MAM_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MamAPI.class);
    }
}
