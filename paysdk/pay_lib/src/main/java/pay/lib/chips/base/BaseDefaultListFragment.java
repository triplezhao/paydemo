package pay.lib.chips.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.potato.library.adapter.PotatoBaseRecyclerViewAdapter;
import com.potato.library.view.NormalEmptyView;
import com.potato.library.view.refresh.PotatoRecyclerSwipeLayout;

import java.util.ArrayList;
import java.util.List;

import pay.lib.R;
import pay.lib.chips.api.PayLibResultEntity;
import pay.lib.chips.api.BaseResultEntity;
import pay.lib.chips.util.UIUtils;
import pay.lib.mvp.util.BaseListView;


public abstract class BaseDefaultListFragment extends BaseFragment implements View.OnClickListener, Handler.Callback, BaseListView {

    public static final String TAG = BaseDefaultListFragment.class.getSimpleName();

    public LinearLayout              include_a;
    public PotatoRecyclerSwipeLayout mSwipeContainer;
    public RecyclerView              listview;
    public NormalEmptyView           mNormalEmptyView;
    public String mId      = "";
    public int    mPage    = 0;
    public String pageSize = "20";
    public List   mList    = new ArrayList();
    public PotatoBaseRecyclerViewAdapter mAdapter;
    public BaseResultEntity              mEntity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        include_a = (LinearLayout) mView.findViewById(R.id.include_a);
        mSwipeContainer = (PotatoRecyclerSwipeLayout) mView.findViewById(R.id.swipe_container);
        listview = (RecyclerView) mView.findViewById(R.id.list);
        mNormalEmptyView = (NormalEmptyView) mView.findViewById(R.id.empty_view);
        return mView;
    }

    public abstract PotatoBaseRecyclerViewAdapter getAdapter();

    public abstract void reqRefresh();

    public abstract void reqLoadMore();

    @Override
    public void initListView() {

        mAdapter = getAdapter();
        mEntity = new PayLibResultEntity();
        mSwipeContainer.setRecyclerView(listview, mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        //  瀑布流
        //setLayoutManager
        /*ExStaggeredGridLayoutManager manager = new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setSpanSizeLookup(new HFGridlayoutSpanSizeLookup((HFRecyclerViewAdapter) listview.getAdapter(), manager.getSpanCount()));
        mSwipeContainer.setLayoutManager(manager);*/

        // 网格
        //setLayoutManager
//        GridLayoutManager manager = new GridLayoutManager(this, 2);
//        manager.setSpanSizeLookup(new HFGridlayoutSpanSizeLookup((HFRecyclerViewAdapter) listview.getAdapter(), manager.getSpanCount()));
        mSwipeContainer.setLayoutManager(manager);

        //默认添加上上拉更多的footer
//        mSwipeContainer.addLoadMoreView(listview, R.layout.ifsee_list_footer);
//        mSwipeContainer.addEndView(listview, R.layout.ifsee_list_footer_end);
//        mSwipeContainer.addTipsView(listview, R.layout.ifsee_list_footer_tips);
        ((TextView) mNormalEmptyView.findViewById(R.id.tv_text)).setTextSize(14);
        /*View headerview = getLayoutInflater().inflate(R.layout.header_bshop_home, null);
        mSwipeContainer.setHeaderView(listview, headerview);*/

        mSwipeContainer.setColorSchemeResources(R.color.ifsee_blue, R.color.ifsee_blue, R.color.ifsee_blue, R.color.ifsee_blue);
        mSwipeContainer.setScrollStateLisener(new PotatoRecyclerSwipeLayout.ScrollStateLisener() {
            @Override
            public void pause() {
                ImageLoader
                        .getInstance()
                        .pause();
            }

            @Override
            public void resume() {
                ImageLoader
                        .getInstance()
                        .resume();
            }
        });
        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reqRefresh();
            }
        });
        mSwipeContainer.setOnLoadListener(new PotatoRecyclerSwipeLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                reqLoadMore();
            }
        });
        mSwipeContainer.setEmptyView(mNormalEmptyView);
        mNormalEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reqRefresh();
            }
        });
//        mNormalEmptyView.setmEmptyTxt(getResources().getString(R.string.error_no_content));
//        mNormalEmptyView.setmErrorTxt(getResources().getString(R.string.error_net_fail));
//        mNormalEmptyView.setmEmptyDrawableRes(R.drawable.rc_empty);
//        mNormalEmptyView.setmErrorDrawableRes(R.drawable.rc_empty);
    }

    @Override
    public void onRefreshSucc(BaseResultEntity entity) {
        if (this.isDetached()) {
            return;
        }
        try {
            if (entity.list == null || entity.list.size() == 0) {
                //拉取为空，并且原来列表数据也为空，则显示数据空界面
                mSwipeContainer.showEmptyViewNoContent();
                //清空本地数据
                mList.clear();
                mAdapter.setDataList(mList);
                mAdapter.notifyDataSetChanged();
                mSwipeContainer.autoShowByTotal(mEntity.total);
                return;
            }
            mEntity = entity;
            mList = entity.list;
            mSwipeContainer.showSucc();
            mAdapter.setDataList(mList);
            mAdapter.notifyDataSetChanged();
            mSwipeContainer.autoShowByTotal(mEntity.total);
        } catch (Exception e) {

        }
    }

    @Override
    public void onRefreshFail(String err) {
        if (this.isDetached()) {
            return;
        }
        try {
            if (mList.isEmpty()) {
//                mNormalEmptyView.setmErrorTxt(getResources().getString(R.string.error_net_fail));
                mSwipeContainer.showEmptyViewFail();
            } else {
                mSwipeContainer.showSucc();
                mSwipeContainer.autoShowByTotal(mEntity.total);
            }
            UIUtils.toast(mContext, err);
        } catch (Exception e) {

        }
    }

    @Override
    public void onLoadMoreSucc(BaseResultEntity entity) {
        if (this.isDetached()) {
            return;
        }
        try {
            if (entity.list == null || entity.list.size() == 0) {
                mSwipeContainer.autoShowByTotal(mEntity.total);
                return;
            }
            mPage = mPage + 1;
            mEntity = entity;
            mList.addAll(entity.list);
            mAdapter.setDataList(mList);
            mAdapter.notifyDataSetChanged();
            mSwipeContainer.autoShowByTotal(mEntity.total);
        } catch (Exception e) {

        }
    }

    @Override
    public void onLoadMoreFail(String err) {
        if (this.isDetached()) {
            return;
        }
        try {
            mSwipeContainer.setRefreshing(false);
            mSwipeContainer.autoShowByTotal(mEntity.total);
            UIUtils.toast(mContext, err);
        } catch (Exception e) {

        }
    }

    @Override
    public void onCacheLoaded(BaseResultEntity entity) {
        if (this.isDetached()) {
            return;
        }
        if (!entity.isSucc()) {
            if (mList.isEmpty()) {
                mSwipeContainer.showEmptyViewFail();
            }
            return;
        }
        if (entity.list == null || entity.list.size() == 0) {
            if (mList.isEmpty()) {
                mSwipeContainer.showEmptyViewNoContent();
            }
            return;
        }
        mEntity = entity;
        mList = entity.list;
        mSwipeContainer.showSucc();
        mAdapter.setDataList(mList);
        mAdapter.notifyDataSetChanged();
        mSwipeContainer.autoShowByTotal(mEntity.total);
    }


}
