package com.salton123.yuemei.net;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/14 12:59
 * Time: 12:59
 * Description:
 */
public class NetConnection {
    public static <T> void Get(String url, Callback.CommonCallback<T> callback, String... kvs) {
        RequestParams _RequestParams = new RequestParams(url);
        for (int i = 0; i < kvs.length; i += 2) {
            _RequestParams.addBodyParameter(kvs[i], kvs[i + 1]);
        }
        System.out.println(_RequestParams.toString());
        x.http().get(_RequestParams, callback);

    }
}
