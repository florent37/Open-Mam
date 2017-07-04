package florent37.github.com.mam.common;

import android.arch.lifecycle.LifecycleRegistry;

import java.lang.ref.WeakReference;

import florent37.github.com.rxlifecycle.RxLifecycle;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by florentchampigny on 20/06/2017.
 */

public class AbstractPresenter<V extends AbstractPresenter.View> {

    private final CompositeDisposable compositeDisposable;
    private WeakReference<V> viewReference;

    public AbstractPresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    protected void call(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected V getView() {
        return viewReference.get();
    }

    public void bind(LifecycleRegistry lifecycle, V view) {
        unbind();
        this.viewReference = new WeakReference<V>(view);
        RxLifecycle.with(lifecycle)
                .onDestroy()
                .doOnSubscribe(this::call)
                .subscribe(x -> unbind());
    }

    private void unbind() {
        compositeDisposable.clear();
        if (viewReference != null) {
            viewReference.clear();
        }
    }

    public <R> SingleTransformer<? super R, ? extends R> compose() {
        return new SingleTransformer<R, R>() {
            @Override
            public SingleSource<R> apply(@NonNull Single<R> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(AbstractPresenter.this::call);
            }
        };
    }

    public interface View {

    }

}
