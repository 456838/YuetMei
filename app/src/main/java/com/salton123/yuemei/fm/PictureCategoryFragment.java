package com.salton123.yuemei.fm;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salton123.yuemei.R;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 18:40
 * Time: 18:40
 * Description:
 */
public class PictureCategoryFragment extends Fragment {
    List<String> listTitle;
    private List<Fragment> fragmentList;
    protected TabLayout tabLayout;
    protected ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_picture_category, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initTab();
    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.picture_tab);
        viewPager = (ViewPager) view.findViewById(R.id.picture_viewpage);
    }

    private void initTab() {
        listTitle = new ArrayList<>();
        fragmentList = new ArrayList<>();
        listTitle.add("性感美女");
        listTitle.add("韩日美女");
        listTitle.add("丝袜美腿");
        listTitle.add("美女照片");
        listTitle.add("美女写真");
        listTitle.add("清纯美女");
        listTitle.add("性感车模");
        for (int i = 0; i < listTitle.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(listTitle.get(i)));
            fragmentList.add(PictureFragment.newInstance(i + 1));
        }
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void initViewPager() {
        viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager()));
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listTitle.get(position);
        }
    }
}
