package com.example.goods.basemvp.base;

import com.example.goods.basemvp.prestener.IBasePrestener;
import com.example.goods.basemvp.view.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
//p层抽取
public class BasePrestener<V extends IBaseView> implements IBasePrestener<V> {

    private WeakReference<V> vWeakReference;
    //项目全局
    protected V mView;
    private CompositeDisposable compositeDisposable;

    //为了防止销毁activity时，因为p层持有v引用，从而导致v层不能被销毁引起内存泄漏，我们将其放入弱引用
    //让弱引用持有view，view 为 空 时候会自动带走一起销毁view避免引起内存泄漏
    @Override
    public void attachView(V view) {
        vWeakReference = new WeakReference<>(view);
        mView = vWeakReference.get();
    }


    //view为空时候解绑弱引用
    @Override
    public void detachView() {
        mView = null;
        unbindSubscribe();
    }

    /**
     * 没有网络请求时候
     * 把请求网络的数据对象加入到排列中
     *
     * @param disposable
     */
    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }


    //vWeakReference有view引用时候不会去清空弱引用所持有的view或是其他引用。
    private void unbindSubscribe() {
        if (vWeakReference != null) {
            vWeakReference.clear();
        }
    }
}
