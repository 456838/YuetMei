package com.salton123.yuemei;

import android.app.Application;

import org.xutils.x;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 18:28
 * Time: 18:28
 * Description:需要在AndroidManifest中配置Application节点的name属性为CustomApplication
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initXutils();
    }

    /**
     * 初始化xutils框架
     */
    private void initXutils() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
