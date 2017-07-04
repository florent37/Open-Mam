package florent37.github.com.mam.ui.apps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import florent37.github.com.mam.R;
import florent37.github.com.mam.common.BaseFragment;
import florent37.github.com.mam.dagger.*;
import florent37.github.com.mam.model.App;
import florent37.github.com.mam.ui.versions.VersionsActivity;

public class AppsListFragment extends BaseFragment implements AppsPresenter.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    AppsPresenter presenter;

    @BindView(R.id.apps_header)
    View header;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent.from(getContext()).inject(this);
        presenter.bind(getLifecycle(), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.apps_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerView.setAdapter(new AppsAdapter().onClick(presenter::onAppClicked));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter.start();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int y = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                this.y -= dy;

                header.setTranslationY(y/2f);
            }
        });
    }

    public static Fragment newInstance() {
        return new AppsListFragment();
    }

    @Override
    public void displayApps(List<App> apps) {
        ((AppsAdapter) recyclerView.getAdapter()).setItems(apps);
    }

    @Override
    public void displayApp(App app) {
        startActivity(VersionsActivity.newInstance(getContext(), app));
    }
}
