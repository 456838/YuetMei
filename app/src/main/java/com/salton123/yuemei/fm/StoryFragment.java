package com.salton123.yuemei.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salton123.yuemei.R;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 18:48
 * Time: 18:48
 * Description:
 */
public class StoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_story, null, false);
    }
}
