package pay.lib.mvp.baidu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.potato.library.util.L;
import com.potato.library.view.NormalEmptyView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pay.lib.R;
import pay.lib.chips.base.BaseActivity;
import pay.lib.data.bean.BaiduCategory;

public class BaiduHomeActivity extends BaseActivity implements BaiduHome.V {

    public static final String TAG = BaiduHomeActivity.class.getSimpleName();

    ViewPager       viewPager;
    TabLayout       tabLayout;
    NormalEmptyView emptyView;
    Toolbar         toolbar;
    @Inject BaiduHomePresenter presenter;
    private HeaderPageAdapter  adapter;
    private List<BaiduCategory> mList = new ArrayList<BaiduCategory>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_home);
//        ButterKnife.bind(this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        emptyView = (NormalEmptyView) findViewById(R.id.empty_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DaggerBaiduHome_C
                .builder()
                .module(new BaiduHome.Module(this))
                .build()
                .inject(this);

        adapter = new HeaderPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_LOADING);
        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);
        presenter.loadData();
    }

    @Override
    public void render(List<BaiduCategory> list) {
        if (list == null) {
            emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_NOCONTENT);
            return;
        }
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_GONE);

        if (list != null && list.size() > 0) {
            mList.clear();
            mList.addAll(list);
            adapter.notifyDataSetChanged();
            tabLayout.setTabsFromPagerAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {


    }

    private class HeaderPageAdapter extends FragmentStatePagerAdapter {

        public HeaderPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BaiduCategory obj = mList.get(position);
            L.d("In ViewPager#getItem, header: " + obj.getName() + ", position: " + position);
            BaiduListFragment pageFragement = BaiduListFragment.instance(mContext, obj.getId(), obj.getName());
            return pageFragement;
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mList
                    .get(position)
                    .getName();
        }
    }

}
