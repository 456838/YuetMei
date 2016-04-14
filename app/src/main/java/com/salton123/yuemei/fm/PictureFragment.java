package com.salton123.yuemei.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.salton123.yuemei.R;
import com.salton123.yuemei.adapter.PictureAdapter;
import com.salton123.yuemei.bean.PictureListItem;
import com.salton123.yuemei.constant.Config;
import com.salton123.yuemei.net.NetConnection;

import org.xutils.common.Callback;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * User: 巫金生(newSalton@outlook.com)
 * Date: 2016/4/12 19:00
 * Time: 19:00
 * Description:
 */
public class PictureFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private BGARefreshLayout picture_swipe;
    private RecyclerView picture_list;
    private PictureAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_picture, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        picture_swipe.beginRefreshing();
    }

    private void initView(View view) {
        picture_swipe = (BGARefreshLayout) view.findViewById(R.id.picture_swipe);
        picture_list = (RecyclerView) view.findViewById(R.id.picture_list);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        picture_list.setLayoutManager(layoutManager);
        picture_swipe.setDelegate(this);
        View emptyView = LayoutInflater.from(getActivity()).inflate(R.layout.empty_view, null);
//        picture_swipe.setCustomHeaderView(emptyView, true);
        mAdapter = new PictureAdapter(picture_list);
        picture_list.setAdapter(mAdapter);
        id = getArguments().getInt("pictureId");
        picture_swipe.setRefreshViewHolder(new BGANormalRefreshViewHolder(getActivity(), true));
    }

    public static Fragment newInstance(int arg) {
        PictureFragment fragment = new PictureFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pictureId", arg);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        isfinishLoading = false;
        page = 1;
        loadPic();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
//        Toast.makeText(getActivity(), "图片加载...", Toast.LENGTH_SHORT).show();
        Log.e("调用LoadingMore", "" + count++);
        if (!isfinishLoading) {
            loadPic();
        } else {
            Toast.makeText(getActivity(), "图片加载完毕", Toast.LENGTH_SHORT).show();
            return false;
        }
        return false;
    }

    private int page = 1;
    private int rows = 20;
    private int id;
    private boolean isfinishLoading = false;

    int count = 1;

    private void loadPic() {
        String targetUrl = Config.PIC_LIST_API;
//        http://www.tngou.net/tnfs/api/list?id=1&rows=20&page=4
        NetConnection.Get(targetUrl, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        PictureListItem _item = new Gson().fromJson(result, PictureListItem.class);
                        if (_item != null & _item.getTngou() != null) {
                            mAdapter.addMoreDatas(_item.getTngou());
                            page++;
                            if (_item.getTngou().size() < rows) {
                                isfinishLoading = true;
                                picture_swipe.endRefreshing();
                                Toast.makeText(getActivity(), "图片加载完毕", Toast.LENGTH_SHORT).show();
                            }
                            picture_swipe.endRefreshing();
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                }, "id", id + "", "page", page + "", "rows",
                rows + "");
    }
}
