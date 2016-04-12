package com.salton123.yuemei.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salton123.yuemei.R;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 19:00
 * Time: 19:00
 * Description:
 */
public class PictureFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_picture, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText("内容页：" + this.getArguments().getInt("pictureId"));

    }

    public static Fragment newInstance(int arg) {
        PictureFragment fragment = new PictureFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pictureId", arg);
        fragment.setArguments(bundle);
        return fragment;
    }
}
