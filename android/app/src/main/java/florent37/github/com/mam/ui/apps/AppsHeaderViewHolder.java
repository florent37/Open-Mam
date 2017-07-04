package florent37.github.com.mam.ui.apps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import florent37.github.com.mam.R;
import florent37.github.com.mam.common.ClickListenerWrapper;
import florent37.github.com.mam.ui.versions.VersionsAdapter;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class AppsHeaderViewHolder extends RecyclerView.ViewHolder {

    public static RecyclerView.ViewHolder build(ViewGroup parent, ClickListenerWrapper<AppsAdapter.ClickListener> clickListenerClickListenerWrapper) {
        return new AppsHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.app_header_cell, parent, false), clickListenerClickListenerWrapper);
    }

    private ClickListenerWrapper<AppsAdapter.ClickListener> clickListenerWrapper;

    public AppsHeaderViewHolder(View itemView, ClickListenerWrapper<AppsAdapter.ClickListener> clickListenerWrapper) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListenerWrapper = clickListenerWrapper;
    }

}
