package com.mylol.project;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.it.administrator.mylol_project.R;
import com.mylol.project.ui.fragment.HomeFt;
import com.mylol.project.ui.fragment.MineFt;
import com.mylol.project.ui.fragment.MomentFt;
import com.mylol.project.ui.fragment.VideoFt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_bottomBar)
    BottomNavigationBar mainBottomBar;
    private FragmentManager fm;
    private HomeFt mHomeFt;
    private VideoFt mVideoFt;
    private MomentFt mMomentFt;
    private MineFt mMineFt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initBottomBar();

    }

    /**
     * 初始化底部按钮
     */
    private void initBottomBar() {

        mainBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        mainBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mainBottomBar.addItem(new BottomNavigationItem(R.drawable.main_tab_tool_btn_pressed, R.string.main_shouye)
                .setActiveColorResource(R.color.colorYellow)
                .setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_tool_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_micro_video_bg_pressed, R.string.main_shipin)
                        .setActiveColorResource(R.color.colorYellow)
                        .setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_micro_video_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_moment_bg_pressed, R.string.main_dongtai).setActiveColorResource(R.color.colorYellow).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_moment_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_me_bg_pressed, R.string.main_wo).setActiveColorResource(R.color.colorYellow).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_me_bg_normal)))
                .setFirstSelectedPosition(0)
                .initialise();
        //设置默认的第一个fragment
        showFragments(0);
        /**
         * 设置对应fragment
         */
        mainBottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                switch (position) {
                    case 0:
                        Log.d(TAG, "onTabSelected: " + position);
                        showFragments(0);
                        break;
                    case 1:
                        showFragments(1);
                        break;
                    case 2:
                        showFragments(2);
                        break;
                    case 3:
                        showFragments(3);
                        break;
                    default:
                        break;

                }

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }

    /**
     * @param position 显示对应fragment
     */
    private void showFragments(int position) {

        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (position) {
            case 0:
                if (mHomeFt != null) {
                    ft.show(mHomeFt);
                } else {
                    mHomeFt = new HomeFt();
                    ft.add(R.id.main_frame, mHomeFt);
                }
                break;
            case 1:
                if (mVideoFt != null) {
                    ft.show(mVideoFt);
                } else {
                    mVideoFt = new VideoFt();
                    ft.add(R.id.main_frame, mVideoFt);
                }
                break;

            case 2:
                if (mMomentFt != null) {
                    ft.show(mMomentFt);
                } else {
                    mMomentFt = new MomentFt();
                    ft.add(R.id.main_frame, mMomentFt);
                }
                break;
            case 3:
                if (mMineFt != null) {
                    ft.show(mMineFt);
                } else {
                    mMineFt = new MineFt();
                    ft.add(R.id.main_frame, mMineFt);
                }
                break;
        }
        ft.commit();

    }

    private void hideFragments(FragmentTransaction ft) {
        if (mHomeFt != null) {
            ft.hide(mHomeFt);
        }
        if (mVideoFt != null) {
            ft.hide(mVideoFt);
        }
        if (mMomentFt != null) {
            ft.hide(mMomentFt);
        }
        if (mMineFt != null) {
            ft.hide(mMineFt);
        }

    }
}
