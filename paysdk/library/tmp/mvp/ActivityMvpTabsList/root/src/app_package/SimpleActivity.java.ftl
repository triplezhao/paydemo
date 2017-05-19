
package ${packageName};

<#if applicationPackage??>import ${applicationPackage}.R;</#if>
import javax.inject.Inject;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
public class ${mvpClass}Activity extends BaseActivity implements ${mvpClass}.V {

    public static final String TAG = ${mvpClass}Activity.class.getSimpleName();
	
    @Bind(R.id.viewpager) ViewPager viewPager;
    @Bind(R.id.tabs) TabLayout tabLayout;
    @Bind(R.id.empty_view) NormalEmptyView emptyView;
   
    private HeaderPageAdapter adapter;
    private List<${mvpClass}Section> mList = new ArrayList<${mvpClass}Section>();
    @Inject ${mvpClass}Presenter presenter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutActivityName});
        ButterKnife.bind(this);

        Dagger${mvpClass}_C.builder().module(new ${mvpClass}.Module(this)).build().inject(this);
       
        adapter = new HeaderPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_LOADING);
        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);
        presenter.loadData();
    }

    @Override
    public void render(Object obj) {
		 if (entity == null) {
            emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_NOCONTENT);
            return;
        }
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        emptyView.setEmptyType(NormalEmptyView.EMPTY_TYPE_GONE);

        List<${mvpClass}Section> list = entity.list;
        if (list != null && list.size() > 0) {
            mList.clear(); mList.addAll(list); adapter.notifyDataSetChanged();
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
            xxxSection obj = mList.get(position);
            L.d("In ViewPager#getItem, header: " + obj.getTitle() + ", position: "
                    + position);
            ${fragmentClass} pageFragement = ${fragmentClass}.instance(mContext,obj.getSectionId(), obj.getTitle();
            return pageFragement;
        }
		
        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position).getTitle();
        }
    }
	
}
