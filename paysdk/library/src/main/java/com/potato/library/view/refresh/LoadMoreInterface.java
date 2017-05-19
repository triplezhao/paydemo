package com.potato.library.view.refresh;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface LoadMoreInterface {

    //是否可以上拉更多
    void setLoadEnable(boolean canLoadMore);

    //刚进入的时候，不显示footer. 等待加载完毕，根据情况进行显示，
    // 比如数据不够一页，则showEndView。
    // 数据够一页，并且count不到total，则显示loadingview。

    //加载更多的loadingview
    void addLoadMoreView(RecyclerView recyclerView, View view);

    void addLoadMoreView(RecyclerView recyclerView, int layoutId);

    //没有更多的提示view
    void addEndView(RecyclerView recyclerView, View view);

    void addEndView(RecyclerView recyclerView, int layoutId);

    //提示上拉加载更多的提示view
    void addTipsView(RecyclerView recyclerView, View view);

    void addTipsView(RecyclerView recyclerView, int layoutId);

    void showLoadMoreView(boolean isshow);

    void showEndView(boolean isshow);

    void showTipsView(boolean isshow);


    void setTipsTxt(String sp);

    void setEndTxt(String sp);

    void setTipsSize(int sp);

    void setTipsColor(int color);

    void setEndViewSize(int sp);

    void setEndViewColor(int color);

}
