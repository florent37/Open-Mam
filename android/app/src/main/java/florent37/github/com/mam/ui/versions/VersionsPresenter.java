package florent37.github.com.mam.ui.versions;

import java.util.List;

import javax.inject.Inject;

import florent37.github.com.mam.common.AbstractPresenter;
import florent37.github.com.mam.model.App;
import florent37.github.com.mam.model.AppVersion;
import florent37.github.com.mam.repository.AppRepository;

public class VersionsPresenter extends AbstractPresenter<VersionsPresenter.View> {

    private final AppRepository appRepository;
    private App app;

    @Inject
    public VersionsPresenter(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public void init(App app){
        this.app = app;
    }

    public void start() {
        appRepository.application(app.getName())
                .compose(super.<List<AppVersion>>compose())
                .subscribe(
                        versions -> getView().displayAppVersions(versions),
                        throwable -> {
                });

        getView().displayAppName(app.getPackageName());
    }

    public void onVersionClicked(AppVersion appVersion) {

    }

    public interface View extends AbstractPresenter.View {
        void displayAppVersions(List<AppVersion> versions);

        void displayAppName(String name);
    }

}
