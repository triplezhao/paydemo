package com.potato.library.view.refresh;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.potato.library.R;
import com.potato.library.util.L;
import com.potato.library.view.hfrecyclerview.HFRecyclerViewAdapter;


public class PotatoRecyclerSwipeLayout extends PotatoBaseSwipeLayout implements LoadMoreInterface {

    public final String TAG = PotatoRecyclerSwipeLayout.class.getSimpleName();
    public RecyclerView mRecyclerView;
    private OnLoadListener mOnLoadListener;

    private boolean isLoading = false;

    private boolean mEnableLoad = true;
    private boolean mLoadMoreNever = false;

    private static final int CIRCLE_DIAMETER_LARGE = 56;
    public View mListViewFooter;
    public View mListViewEnder;
    public View mListViewTips;
    private View mListViewHeader;

    public ScrollStateLisener ScrollStateLisener;

    public PotatoRecyclerSwipeLayout(Context context) {
        this(context, null);
        init(context);
    }

    public PotatoRecyclerSwipeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context) {
        super.init(context);

    }

    public ScrollStateLisener getScrollStateLisener() {
        return ScrollStateLisener;
    }

    public void setScrollStateLisener(ScrollStateLisener ScrollStateLisener) {
        this.ScrollStateLisener = ScrollStateLisener;
    }

    public void setOnLoadListener(OnLoadListener loadListener) {
        mOnLoadListener = loadListener;
    }

    public static interface OnLoadListener {
        public void onLoad();
    }

    public interface ScrollStateLisener {
        public void pause();

        public void resume();
    }


    ///////////////////////////////hf code /////////////////////////////////////////////////
    /**
     * 当前RecyclerView类型
     */
    protected LayoutManagerType layoutManagerType;

    /**
     * 最后一个的位置
     */
    private int[] lastPositions;

    /**
     * 最后一个可见的item的位置
     */
    private int lastVisibleItemPosition;

    /**
     * 当前滑动的状态
     */
    private int currentScrollState = 0;


    /**
     * 取数组中最大值
     *
     * @param lastPositions
     * @return
     */
    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }


    public static enum LayoutManagerType {
        LinearLayout,
        StaggeredGridLayout,
        GridLayout
    }

    public HFRecyclerViewAdapter getHFAdapter() {
        RecyclerView.Adapter outerAdapter = mRecyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
            return null;
        }

        return (HFRecyclerViewAdapter) outerAdapter;
    }

    /**
     * 移除FooterView
     *
     * @param recyclerView
     */
    public void removeFooterView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int footerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getFooterViewsCount();
            if (footerViewCounter > 0) {
//                View footerView = ((HFRecyclerViewAdapter) outerAdapter).getFooterView();
                ((HFRecyclerViewAdapter) outerAdapter).removeFooterView(mListViewFooter);
            }
        }
    }

    /**
     * 移除FooterView
     *
     * @param recyclerView
     */
    public void removeEnderView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int footerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getFooterViewsCount();
            if (footerViewCounter > 0) {
//                View footerView = ((HFRecyclerViewAdapter) outerAdapter).getFooterView();
                ((HFRecyclerViewAdapter) outerAdapter).removeFooterView(mListViewEnder);
                L.i(mListViewEnder.toString());
            }
        }
    }

    /**
     * 移除FooterView
     *
     * @param recyclerView
     */
    public void removeTipsView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int footerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getFooterViewsCount();
            if (footerViewCounter > 0) {
//                View footerView = ((HFRecyclerViewAdapter) outerAdapter).getFooterView();
                ((HFRecyclerViewAdapter) outerAdapter).removeFooterView(mListViewEnder);
                L.i(mListViewEnder.toString());
            }
        }
    }

    /**
     * 移除HeaderView
     *
     * @param recyclerView
     */
    public void removeHeaderView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int headerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                View headerView = ((HFRecyclerViewAdapter) outerAdapter).getHeaderView();
                ((HFRecyclerViewAdapter) outerAdapter).removeFooterView(headerView);
            }
        }
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getLayoutPosition()方法
     *
     * @param recyclerView
     * @param holder
     * @return
     */
    public int getLayoutPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int headerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                return holder.getLayoutPosition() - headerViewCounter;
            }
        }

        return holder.getLayoutPosition();
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getAdapterPosition()方法
     *
     * @param recyclerView
     * @param holder
     * @return
     */
    public int getAdapterPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
        if (outerAdapter != null && outerAdapter instanceof HFRecyclerViewAdapter) {

            int headerViewCounter = ((HFRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                return holder.getAdapterPosition() - headerViewCounter;
            }
        }

        return holder.getAdapterPosition();
    }

    public void setRecyclerView(RecyclerView recyclerView, final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        mRecyclerView = recyclerView;
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                L.i(TAG, "onScrollStateChanged");
                if (ScrollStateLisener != null) {
                    switch (newState) {

                        case RecyclerView.SCROLL_STATE_IDLE://停止滚动
                        {
                            //设置为停止滚动
                            ScrollStateLisener.resume();
                            break;
                        }
                        case RecyclerView.SCROLL_STATE_DRAGGING://滚动做出了抛的动作
                        {
                            //设置为正在滚动
                            ScrollStateLisener.pause();
                            break;
                        }

                        case RecyclerView.SCROLL_STATE_SETTLING://正在滚动
                        {
                            //设置为正在滚动
                            ScrollStateLisener.pause();
                            break;
                        }
                    }
                }
                currentScrollState = newState;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
//                int totalItemCount = layoutManager.getItemCount() - getHFAdapter().getHeaderViewsCount()-getHFAdapter().getFooterViewsCount();

//                L.i(TAG, "visibleItemCount=" + visibleItemCount + "totalItemCount" + totalItemCount);
                if ((visibleItemCount > 0 && currentScrollState == RecyclerView.SCROLL_STATE_IDLE && (lastVisibleItemPosition) >= totalItemCount - 1)) {
                    if (adapter.getItemCount() > 0) {
                        loadMoreData();
                    }
                }
            }


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                L.i(TAG, "onScrolled");
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                if (layoutManagerType == null) {
                    if (layoutManager instanceof LinearLayoutManager) {
                        layoutManagerType = LayoutManagerType.LinearLayout;
                    } else if (layoutManager instanceof GridLayoutManager) {
                        layoutManagerType = LayoutManagerType.GridLayout;
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        layoutManagerType = LayoutManagerType.StaggeredGridLayout;
                    } else {
                        throw new RuntimeException(
                                "Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
                    }
                }

                switch (layoutManagerType) {
                    case LinearLayout:
                        lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                        break;
                    case GridLayout:
                        lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                        break;
                    case StaggeredGridLayout:
                        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                        if (lastPositions == null) {
                            lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                        }
                        staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                        lastVisibleItemPosition = findMax(lastPositions);
                        break;
                }
            }

        });

        HFRecyclerViewAdapter hfRecyclerViewAdapter = new HFRecyclerViewAdapter(adapter);
        mRecyclerView.setAdapter(hfRecyclerViewAdapter);

        //默认添加上上拉更多的footer
        addLoadMoreView(mRecyclerView, com.potato.library.R.layout.potato_listview_footer);
        addEndView(mRecyclerView, com.potato.library.R.layout.potato_listview_footer_end);
        addTipsView(mRecyclerView, com.potato.library.R.layout.potato_listview_footer_tips);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        if (mRecyclerView == null) {
            throw new NullPointerException("call this func,please call setRecyclerView before ");
        }
        mRecyclerView.setLayoutManager(layout);
    }

    public void loadMoreData() {
        if (!mEnableLoad) return;
        if (isLoading) return;
        if (isRefreshing()) return;

        if (mOnLoadListener != null) {
            showLoadMoreView(true);
            mOnLoadListener.onLoad();
        }
    }

    public boolean ismLoadMoreNever() {
        return mLoadMoreNever;
    }

    public void setmLoadMoreNever(boolean mLoadMoreNever) {
        this.mLoadMoreNever = mLoadMoreNever;
    }

    @Override
    public void setLoadEnable(boolean canLoadMore) {
        RecyclerView.Adapter outerAdapter = mRecyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
            return;
        }

        mEnableLoad = canLoadMore;

        //可以加载更多的时候，就隐藏 endview
        if (canLoadMore) {
            showTipsView(true);
        } else {
            showEndView(true);
            /*showEndView(false);
            showTipsView(false);
            showLoadMoreView(false);*/
        }
    }

    @Override
    public void addLoadMoreView(RecyclerView recyclerView, int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        addLoadMoreView(recyclerView, view);
    }

    @Override
    public void addEndView(RecyclerView recyclerView, int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        addEndView(recyclerView, view);
    }

    @Override
    public void addTipsView(RecyclerView recyclerView, int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        addTipsView(recyclerView, view);
    }

    @Override
    public void addLoadMoreView(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
            return;
        }
        HFRecyclerViewAdapter headerAndFooterAdapter = (HFRecyclerViewAdapter) outerAdapter;

        //先把之前的删除，再添加新的
        if (mListViewFooter != null && headerAndFooterAdapter.mFooterViews.contains(mListViewFooter)) {
            headerAndFooterAdapter.mFooterViews.remove(mListViewFooter);
        }
        //如果没有则增加上去
        if (!headerAndFooterAdapter.mFooterViews.contains(view)) {
            headerAndFooterAdapter.addFooterView(view);
            mListViewFooter = view;
            L.i(mListViewFooter.toString());
        }
    }

    @Override
    public void addEndView(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
            return;
        }
        HFRecyclerViewAdapter headerAndFooterAdapter = (HFRecyclerViewAdapter) outerAdapter;

        //先把之前的删除，再添加新的
        if (mListViewEnder != null && headerAndFooterAdapter.mFooterViews.contains(mListViewEnder)) {
            headerAndFooterAdapter.mFooterViews.remove(mListViewEnder);
        }
        //如果没有则增加上去
        if (!headerAndFooterAdapter.mFooterViews.contains(view)) {
            headerAndFooterAdapter.addFooterView(view);
            mListViewEnder = view;
            L.i(mListViewEnder.toString());
        }
    }

    @Override
    public void addTipsView(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
            return;
        }
        HFRecyclerViewAdapter headerAndFooterAdapter = (HFRecyclerViewAdapter) outerAdapter;

        //先把之前的删除，再添加新的
        if (mListViewTips != null && headerAndFooterAdapter.mFooterViews.contains(mListViewTips)) {
            headerAndFooterAdapter.mFooterViews.remove(mListViewTips);
        }
        //如果没有则增加上去
        if (!headerAndFooterAdapter.mFooterViews.contains(view)) {
            headerAndFooterAdapter.addFooterView(view);
            mListViewTips = view;
            L.i(mListViewTips.toString());
        }
    }

    @Override
    public void showLoadMoreView(boolean isshow) {
        if (mListViewFooter == null) {
            return;
        }
        isLoading = isshow;
        if (isshow) {
            /*if (mListViewFooter.getLayoutParams() != null) {
                mListViewFooter.getLayoutParams().height = LayoutParams.WRAP_CONTENT;
                mListViewFooter.setLayoutParams(mListViewFooter.getLayoutParams());
            }*/
            mListViewFooter.findViewById(R.id.rl_footer).setVisibility(View.VISIBLE);
            showTipsView(false);
            showEndView(false);
        } else {
            /*if (mListViewFooter.getLayoutParams() != null) {
                mListViewFooter.getLayoutParams().height = 1;
                mListViewFooter.setLayoutParams(mListViewFooter.getLayoutParams());
            }*/
            mListViewFooter.findViewById(R.id.rl_footer).setVisibility(View.GONE);
        }
    }

    @Override
    public void showEndView(boolean isshow) {
        if (mListViewEnder == null) {
            return;
        }
        if (isshow) {
           /* if (mListViewEnder.getLayoutParams() != null) {
                mListViewEnder.getLayoutParams().height = LayoutParams.WRAP_CONTENT;
                mListViewEnder.setLayoutParams(mListViewEnder.getLayoutParams());
            }*/
            mListViewEnder.findViewById(R.id.rl_footer).setVisibility(View.VISIBLE);
            showTipsView(false);
            showLoadMoreView(false);
        } else {
            /*if (mListViewEnder.getLayoutParams() != null) {
                mListViewEnder.getLayoutParams().height = 1;
                mListViewEnder.setLayoutParams(mListViewEnder.getLayoutParams());
            }*/
            mListViewEnder.findViewById(R.id.rl_footer).setVisibility(View.GONE);
        }
    }

    @Override
    public void setTipsTxt(String sp) {
        try {
            TextView tv_more = (TextView) mListViewTips.findViewById(R.id.tv_more);
            tv_more.setText(sp);
        } catch (Exception e) {

        }

    }


    @Override
    public void setTipsSize(int sp) {
        try {
            TextView tv_more = (TextView) mListViewTips.findViewById(R.id.tv_more);
            tv_more.setTextSize(sp);
        } catch (Exception e) {

        }

    }

    @Override
    public void setTipsColor(int color) {
        try {
            TextView tv_more = (TextView) mListViewTips.findViewById(R.id.tv_more);
            tv_more.setTextColor(color);
        } catch (Exception e) {

        }
    }

    @Override
    public void setEndTxt(String sp) {
        try {
            TextView tv_nomore = (TextView) mListViewEnder.findViewById(R.id.tv_nomore);
            tv_nomore.setText(sp);
        } catch (Exception e) {

        }

    }

    @Override
    public void setEndViewSize(int sp) {
        try {
            TextView tv_nomore = (TextView) mListViewEnder.findViewById(R.id.tv_nomore);
            tv_nomore.setTextSize(sp);
        } catch (Exception e) {

        }
    }

    @Override
    public void setEndViewColor(int color) {
        try {
            TextView tv_nomore = (TextView) mListViewEnder.findViewById(R.id.tv_nomore);
            tv_nomore.setTextColor(color);
        } catch (Exception e) {

        }
    }

    @Override
    public void showTipsView(boolean isshow) {
        if (mListViewTips == null) {
            return;
        }
        if (isshow) {
//            mListViewTips.findViewById(R.id.rl_footer).setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            // ((TextView) mListViewTips.findViewById(R.id.rl_footer)).setHeight(LayoutParams.WRAP_CONTENT);
            /*if (mListViewTips.getLayoutParams() != null) {
                mListViewTips.getLayoutParams().height = LayoutParams.WRAP_CONTENT;
                mListViewTips.setLayoutParams(mListViewTips.getLayoutParams());
            }*/
            mListViewTips.findViewById(R.id.rl_footer).setVisibility(View.VISIBLE);
            showEndView(false);
            showLoadMoreView(false);
        } else {
            /*if (mListViewTips.getLayoutParams() != null) {
                mListViewTips.getLayoutParams().height = 1;
                mListViewTips.setLayoutParams(mListViewTips.getLayoutParams());
            }*/
//            ((TextView) mListViewTips.findViewById(R.id.rl_footer)).setHeight(1);
//            mListViewTips.findViewById(R.id.rl_footer).setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1));
            mListViewTips.findViewById(R.id.rl_footer).setVisibility(View.GONE);
        }
    }

    public void autoShowByTotal(int total) {
        //如果设置了不支持下拉刷新，则直接全部隐藏
        if (mLoadMoreNever) {
            //底部什么都不显示
            mEnableLoad = false;
            showEndView(false);
            showLoadMoreView(false);
            showTipsView(false);
        } else {
            RecyclerView.Adapter outerAdapter = mRecyclerView.getAdapter();

            if (outerAdapter == null || !(outerAdapter instanceof HFRecyclerViewAdapter)) {
//                setLoadEnable(false);
                //底部什么都不显示
                mEnableLoad = false;
                showEndView(false);
                showLoadMoreView(false);
                showTipsView(false);
                return;
            }
            RecyclerView.Adapter innerAdapter = ((HFRecyclerViewAdapter) outerAdapter).getInnerAdapter();
            if (innerAdapter == null) {
                //底部什么都不显示
                mEnableLoad = false;
                showEndView(false);
                showLoadMoreView(false);
                showTipsView(false);
                return;
            }
            if (innerAdapter.getItemCount() > 0 && innerAdapter.getItemCount() < total) {
                setLoadEnable(true);
            } else if (innerAdapter.getItemCount() == 0) {
                //底部什么都不显示
                mEnableLoad = false;
                showEndView(false);
                showLoadMoreView(false);
                showTipsView(false);
            } else if (innerAdapter.getItemCount() >= total) {
                setLoadEnable(false);
            }
        }

    }
}
