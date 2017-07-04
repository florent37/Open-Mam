package florent37.github.com.mam.common;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class ClickListenerWrapper<V> {

    public V listener;

    public ClickListenerWrapper() {
    }

    public void setListener(V listener) {
        this.listener = listener;
    }

    public interface Callback<V>{
        void get(V listener);
    }

    public void getListener(Callback<V> callback){
        if (listener != null) {
            callback.get(listener);
        }
    }
}
