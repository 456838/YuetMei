package com.salton123.yuemei.aty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.salton123.yuemei.R;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 18:28
 * Time: 18:28
 * Description:
 */
public class BaseAty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
    }
}
