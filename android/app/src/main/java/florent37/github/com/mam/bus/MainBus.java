package florent37.github.com.mam.bus;

import com.github.florent37.rxsharedpreferences.RxBus;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class MainBus extends RxBus {

    public void displayApp(String name) {
        super.post(new DisplayAppEvent(name));
    }

    public Observable<String> onDisplayApp() {
        return super.onEvent(DisplayAppEvent.class)
                .map(e -> e.name)
                .throttleWithTimeout(1, TimeUnit.SECONDS);
    }

    class DisplayAppEvent {
        public String name;

        public DisplayAppEvent(String name) {
            this.name = name;
        }
    }

}
