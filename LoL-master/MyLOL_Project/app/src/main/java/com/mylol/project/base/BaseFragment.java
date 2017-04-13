package com.mylol.project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kim
 * on 2017/4/13.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 获取布局id
     * @return
     */
    public  abstract  int getLayoutId();

    /**
     * 初始化变量
     */
    public  abstract  void initVariables();

    /**
     *
     * @param view  初始化布局
     * @param savedInstanceState
     */
    public  abstract  void initViews(View view, Bundle savedInstanceState);

    /**
     *  初始化加载数据
     */
    public  abstract  void initLoadingDatas();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(), container, false);
        initVariables();
        initViews(view,savedInstanceState);
        initLoadingDatas();
        return view;
    }
}
