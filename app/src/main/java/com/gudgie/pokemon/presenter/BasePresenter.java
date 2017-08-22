package com.gudgie.pokemon.presenter;

import android.support.annotation.CallSuper;

import com.gudgie.pokemon.view.BaseView;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends BaseView> {

    private WeakReference<T> viewRef;

    @CallSuper
    public void onViewCreated(T view) {
        this.viewRef = new WeakReference<>(view);
    }

    protected final T getView() {
        if (viewRef != null && viewRef.get() != null) {
            return viewRef.get();
        } else {
            throw new ViewNotReadyException();
        }
    }

    @CallSuper
    void onViewDestroyed() {
        if (viewRef != null && viewRef.get() != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    private static class ViewNotReadyException extends IllegalStateException {}

}
