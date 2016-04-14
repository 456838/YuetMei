package com.salton123.yuemei.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.salton123.yuemei.R;
import com.salton123.yuemei.bean.PictureListItem;
import com.salton123.yuemei.constant.Config;
import com.salton123.yuemei.net.ImageLoaderUtils;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/14 12:21
 * Time: 12:21
 * Description:
 */
public class PictureAdapter extends BGARecyclerViewAdapter<PictureListItem.TngouBean> {


    public PictureAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.picture_list_item);
    }

    @Override
    protected void fillData(BGAViewHolderHelper viewHolderHelper, int position, PictureListItem.TngouBean model) {
        viewHolderHelper.setText(R.id.picture_title, model.getTitle());
        ImageView iv = viewHolderHelper.getView(R.id.picture);
        ImageLoaderUtils.display(iv, Config.PIC_SHOW+ model.getImg());
    }
}
