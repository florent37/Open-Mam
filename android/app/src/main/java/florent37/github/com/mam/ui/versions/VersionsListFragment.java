package florent37.github.com.mam.ui.versions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import florent37.github.com.mam.R;
import florent37.github.com.mam.common.BaseFragment;
import florent37.github.com.mam.dagger.AppComponent;
import florent37.github.com.mam.model.App;
import florent37.github.com.mam.model.AppVersion;

public class VersionsListFragment extends BaseFragment implements VersionsPresenter.View {

    static final String APPLICATION = "APPLICATION";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.appversions_header)
    View header;

    @BindView(R.id.appName)
    TextView appName;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    VersionsPresenter presenter;

    public static VersionsListFragment newInstance(App app) {
        final Bundle args = new Bundle();
        args.putSerializable(APPLICATION, app);
        VersionsListFragment fragment = new VersionsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent.from(getContext()).inject(this);
        presenter.bind(getLifecycle(), this);
        presenter.init((App) getArguments().getSerializable(APPLICATION));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.appversions_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        AppCompatActivity appCompatActivity = ((AppCompatActivity) getActivity());
        appCompatActivity.setSupportActionBar(toolbar);

        final ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);

        recyclerView.setAdapter(new VersionsAdapter().onClick(presenter::onVersionClicked));
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

    @Override
    public void displayAppVersions(List<AppVersion> versions) {
        ((VersionsAdapter) recyclerView.getAdapter()).setItems(versions);
    }

    @Override
    public void displayAppName(String name) {
        appName.setText(name);
    }
}
