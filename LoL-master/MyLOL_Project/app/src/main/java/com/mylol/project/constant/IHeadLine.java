package com.mylol.project.constant;

import com.mylol.project.model.HeadLine;

import java.util.List;
/**
 * Created by kim
 * on 2017/4/13.
 */
public interface IHeadLine {

    public interface Views {

        void showInfo(List<HeadLine.DataBean> mList);//显示正确的信息
    }
    public interface presenter
    {
        void loadingDataFromNet(int p);
        void loadingDataFromCache(String p);
    }

    public interface  newspresenter
    {
        void loadingDataFromNet(String s,int p);

        void loadingDataFromCache(String p);

    }
}
