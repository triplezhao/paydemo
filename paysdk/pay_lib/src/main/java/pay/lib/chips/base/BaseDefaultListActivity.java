package pay.lib.chips.base;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public abstract class BaseDefaultListActivity extends BaseActivity implements BaseListView {

    public static final String TAG = BaseDefaultListActivity.class.getSimpleName();

    public PotatoRecyclerSwipeLayout mSwipeContainer;
    public RecyclerView              listview;
    public NormalEmptyView           mNormalEmptyView;
    public String mId      = "汽车";
    public int    mPage    = 0;
    public String pageSize = "20";
    public List   mList    = new ArrayList();
    public PotatoBaseRecyclerViewAdapter mAdapter;
    public BaseResultEntity              mEntity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwipeContainer = (PotatoRecyclerSwipeLayout) findViewById(R.id.swipe_container);
        listview = (RecyclerView) findViewById(R.id.list);
        mNormalEmptyView = (NormalEmptyView) findViewById(R.id.empty_view);
    }

    public abstract PotatoBaseRecyclerViewAdapter getAdapter();

    public abstract void reqRefresh();

    public abstract void reqLoadMore();

    @Override
    public void initListView() {
        mAdapter = getAdapter();
        mEntity = new PayLibResultEntity();
        mSwipeContainer.setRecyclerView(listview, mAdapter);

        mSwipeContainer.setLayoutManager(getLayoutManager());
        //默认添加上上拉更多的footer
//        mSwipeContainer.addLoadMoreView(listview, R.layout.ifsee_list_footer);
//        mSwipeContainer.addEndView(listview, R.layout.ifsee_list_footer_end);
//        mSwipeContainer.addTipsView(listview, R.layout.ifsee_list_footer_tips);
//        mSwipeContainer.setEndViewColor(getResources().getColor(R.color.ifsee_blue));
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
        ((TextView) mNormalEmptyView.findViewById(R.id.tv_text)).setTextSize(14);
    }

    @Override
    public void onRefreshSucc(BaseResultEntity entity) {
        if (entity.list == null || entity.list.size() == 0) {
            //拉取为空，并且原来列表数据也为空，则显示数据空界面
//            mNormalEmptyView.setmEmptyTxt(getResources().getString(R.string.error_no_content));
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
    }

    @Override
    public void onRefreshFail(String err) {
        if (mList.isEmpty()) {
//            mNormalEmptyView.setmErrorTxt(getResources().getString(R.string.error_net_fail));
            mSwipeContainer.showEmptyViewFail();
        } else {
            mSwipeContainer.showSucc();
            mSwipeContainer.autoShowByTotal(mEntity.total);
        }
        UIUtils.toast(mContext, err);

    }

    @Override
    public void onLoadMoreSucc(BaseResultEntity entity) {
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
    }

    @Override
    public void onLoadMoreFail(String err) {
        UIUtils.toast(mContext, err);

        mSwipeContainer.setRefreshing(false);
        mSwipeContainer.autoShowByTotal(mEntity.total);
    }

    @Override
    public void onCacheLoaded(BaseResultEntity entity) {
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

    public RecyclerView.LayoutManager getLayoutManager() {
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
        return manager;
    }


}
