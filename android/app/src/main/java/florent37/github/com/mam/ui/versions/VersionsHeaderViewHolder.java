package florent37.github.com.mam.ui.versions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import florent37.github.com.mam.R;
import florent37.github.com.mam.common.ClickListenerWrapper;
import florent37.github.com.mam.model.App;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class VersionsHeaderViewHolder extends RecyclerView.ViewHolder {

    public static RecyclerView.ViewHolder build(ViewGroup parent, ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerClickListenerWrapper) {
        return new VersionsHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.appversion_header_cell, parent, false), clickListenerClickListenerWrapper);
    }

    private ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerWrapper;

    public VersionsHeaderViewHolder(View itemView, ClickListenerWrapper<VersionsAdapter.ClickListener> clickListenerWrapper) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListenerWrapper = clickListenerWrapper;
    }

}
