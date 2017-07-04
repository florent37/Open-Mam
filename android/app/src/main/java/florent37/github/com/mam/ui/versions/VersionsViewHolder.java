package florent37.github.com.mam.ui.versions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import florent37.github.com.mam.R;
import florent37.github.com.mam.common.ClickListenerWrapper;
import florent37.github.com.mam.model.AppVersion;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class VersionsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.version)
    TextView version;
    @BindView(R.id.code)
    TextView code;
    private AppVersion appVersion;
    private ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerWrapper;
    public VersionsViewHolder(View itemView, ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerWrapper) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListenerWrapper = clickListenerWrapper;
    }

    public static RecyclerView.ViewHolder build(ViewGroup parent, ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerClickListenerWrapper) {
        return new VersionsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.appversion_cell, parent, false), clickListenerClickListenerWrapper);
    }

    @OnClick(R.id.download)
    public void onLayoutClicked() {
        clickListenerWrapper.getListener(listener ->
                listener.onAppClicked(appVersion)
        );
    }

    public void bind(final AppVersion appVersion) {
        this.appVersion = appVersion;

        this.date.setText(appVersion.getDate());
        this.code.setText(String.format("(%s)", appVersion.getCode()));
        this.version.setText(appVersion.getVersion());
    }
}
