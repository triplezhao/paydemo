package com.potato.library.view.refresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import com.potato.library.util.L;
import com.potato.library.view.EmptyViewInterface;
import com.potato.library.view.NormalEmptyView;

public class PotatoBaseSwipeLayout extends SwipeRefreshLayout {

    private int mEnd;
    private int mStart=0;
    private boolean mRefreshEnable=true;
    protected int mTouchSlop;

    public PotatoBaseSwipeLayout(Context context) {
        this(context, null);
        init(context);
    }

    public PotatoBaseSwipeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context) {
        final DisplayMetrics metrics = getResources().getDisplayMetrics();
        if(mEnd==0){
            mEnd = (int) (24 * metrics.density);
        }
        L.i("BaseSwipeLayout","mEnd="+mEnd);
        this.setColorSchemeResources(com.potato.library.R.color.google_blue,
                com.potato.library.R.color.google_green,
                com.potato.library.R.color.google_red,
                com.potato.library.R.color.google_yellow);
    }

    //设置刷新动画最大位置
    public void setEnd(int mEnd) {
        this.mEnd = mEnd;
        L.i("BaseSwipeLayout","mEnd="+mEnd);
    }
    public void setStartOffset(int start) {
        this.mStart = start;
        L.i("BaseSwipeLayout","mStart="+start);
    }

    public void setRefreshing(boolean isLoading) {
        if(!mRefreshEnable&&!isLoading){
            setRefreshEnable(false);
            L.i("!mRefreshEnable&&!isLoading");
        }

        //没在刷新，并且要进行刷新操作
        if (!isRefreshing()&&isLoading){
            setProgressViewOffset(false, mStart, mEnd);
            L.i("!isRefreshing()&&!isLoading");
        }
        L.i("setRefreshing,true");
        super.setRefreshing(isLoading);
    }

    //禁用了刷新显示
    public void setRefreshEnable(boolean isEnable){
        mRefreshEnable=isEnable;
        if(!mRefreshEnable){
            setStartOffset(-30000);
            setEnd(-50000);
            setDistanceToTriggerSync(20000);
            setProgressViewOffset(false, mStart, mEnd);
        }else {
            setStartOffset(0);
            setEnd(80);
            setDistanceToTriggerSync(-1);
        }
    }

    //强制显示，配置了禁用了刷新，调用这个也能显示刷新球
    public void showProgressOffset(int start,int end){
        setStartOffset(start);
        setEnd(end);
//        setDistanceToTriggerSync(distance);
        if(mEmptyview!=null){
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_GONE);
        }
        setProgressViewOffset(false, mStart, mEnd);
        setRefreshing(true);
    }
    //强制显示，配置了禁用了刷新，调用这个也能显示刷新球
    public void showProgressOffset(){
        showProgressOffset(0,100);
    }


    private EmptyViewInterface mEmptyview;



    public void setEmptyView(NormalEmptyView emptyView){
        mEmptyview = emptyView;
    }

    //显示顶部圆圈的loading
    public void showProgress(){
        if(mEmptyview!=null){
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_GONE);
        }
        setRefreshing(true);
    }

    //显示emptyview的loading
    public void showEmptyViewProgress(){
        if(mEmptyview!=null){
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_LOADING);
        }
        setRefreshing(true);
    }
    public void showSucc(){
        if(mEmptyview!=null){
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_GONE);
        }
        setRefreshing(false);
    }
    public void showEmptyViewFail(){
        if(mEmptyview!=null) {
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_ERROR);
        }
        setRefreshing(false);
    }
    public void showEmptyViewNoContent(){
        if(mEmptyview!=null) {
            mEmptyview.setEmptyType(NormalEmptyView.EMPTY_TYPE_NOCONTENT);
        }
        setRefreshing(false);
    }

}