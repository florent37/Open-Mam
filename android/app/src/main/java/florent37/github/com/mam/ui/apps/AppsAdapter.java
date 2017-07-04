package florent37.github.com.mam.ui.apps;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import florent37.github.com.mam.common.ClickListenerWrapper;
import florent37.github.com.mam.model.App;

public class AppsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int HEADER_SIZE = 1;
    private final int TYPE_HEADER = 1;
    private final int TYPE_CELL = 2;

    private List<App> appList = new ArrayList<>();
    private ClickListenerWrapper<ClickListener> clickListenerWrapper = new ClickListenerWrapper<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_CELL:
        return AppViewHolder.build(parent, clickListenerWrapper);
            case TYPE_HEADER:
                return AppsHeaderViewHolder.build(parent, clickListenerWrapper);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if(position < HEADER_SIZE){
            return TYPE_HEADER;
        }
        return TYPE_CELL;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position >= HEADER_SIZE) {
            if (holder instanceof AppViewHolder) {
                ((AppViewHolder) holder).bind(getItem(position));
            }
        }
    }

    public AppsAdapter onClick(ClickListener clickListener){
        this.clickListenerWrapper.setListener(clickListener);
        return this;
    }


    public App getItem(int position) {
        return appList.get(position - HEADER_SIZE);
    }

    @Override
    public int getItemCount() {
        return appList.size() + HEADER_SIZE;
    }

    public void setItems(List<App> items) {
        this.appList.clear();
        this.appList.addAll(items);
        notifyDataSetChanged();
    }

    public interface ClickListener {
        void onAppClicked(App app);
    }
}
