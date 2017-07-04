package florent37.github.com.mam.ui.apps;

import java.util.List;

import javax.inject.Inject;

import florent37.github.com.mam.bus.MainBus;
import florent37.github.com.mam.common.AbstractPresenter;
import florent37.github.com.mam.model.App;
import florent37.github.com.mam.repository.AppRepository;

public class AppsPresenter extends AbstractPresenter<AppsPresenter.View> {

    private final AppRepository appRepository;
    private final MainBus mainBus;

    @Inject
    public AppsPresenter(AppRepository appRepository, MainBus mainBus) {
        this.appRepository = appRepository;
        this.mainBus = mainBus;
    }

    public void start() {
        appRepository.applications()
                .compose(super.<List<App>>compose())
                .subscribe(
                        apps ->
                                getView().displayApps(apps),
                        throwable -> {
                            throwable.printStackTrace();
                });
    }

    public void onAppClicked(App app) {
        getView().displayApp(app);
    }

    public interface View extends AbstractPresenter.View {
        void displayApps(List<App> apps);

        void displayApp(App app);
    }

}
