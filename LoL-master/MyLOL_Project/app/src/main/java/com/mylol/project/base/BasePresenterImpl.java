package com.mylol.project.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kim
 * on 2017/4/14.
 */
public class BasePresenterImpl implements BasePresenter {

    private CompositeSubscription mCompositeSubscription;
    /**
     *
     * @param s 增加绑定事件
     */
    protected  void addSubscrible(Subscription s)
    {
        if(mCompositeSubscription==null)
        {
            mCompositeSubscription=new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);

    }

    @Override
    public void unSubcrible() {

        if(mCompositeSubscription!=null)
        {
            this.mCompositeSubscription.unsubscribe();
        }

    }
}
