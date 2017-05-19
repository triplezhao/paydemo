package com.potato.library.view.refresh;

import android.view.View;

/**
 * Created by ztw on 2015/12/18.
 */
public interface PotatoRefreshImpl<T> {


    public void initListView(View view);

    public void onRefreshSucc(T t);

    public void onRefreshFail(String err);

    public void onLoadMoreSucc(T t);

    public void onLoadMoreFail(String err);

    public void reqRefresh();

    public void reqLoadMore();

}
