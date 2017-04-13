package com.mylol.project.ui.fragment;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import com.it.administrator.mylol_project.R;
import com.mylol.project.Config;
import com.mylol.project.base.BaseFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kim
 * on 2017/4/10.
 */
public class HomeFt extends BaseFragment {
    boolean connected;
    private List<Integer> images;//滑动广告的图片地址

    @Override
    public int getLayoutId() {
        return R.layout.homeft_fragment_layout;
    }

    @Override
    public void initVariables() {
        checkNet();
        images = new ArrayList<>();
        images = Arrays.asList(Config.IMAGE);

    }

    /**
     * 检查网络
     */
    private void checkNet() {
        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        connected = info != null && info.isConnected();

    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initLoadingDatas() {

    }


}
