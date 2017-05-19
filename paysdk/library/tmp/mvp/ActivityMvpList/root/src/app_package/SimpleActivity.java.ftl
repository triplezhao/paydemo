
package ${packageName};

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
<#if applicationPackage??>import ${applicationPackage}.R;</#if>
import javax.inject.Inject;

public class ${mvpClass}Activity extends BaseDefaultListActivity implements ${mvpClass}.V {

    public static final String TAG = ${mvpClass}Activity.class.getSimpleName();
    public static final String EXTRA_ID = "EXTRA_ID";

    @Inject ${mvpClass}Presenter presenter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutActivityName});
        ButterKnife.bind(this);

        Dagger${mvpClass}_C.builder().module(new ${mvpClass}.Module(this)).build().inject(this);
        mId = getIntent() == null ? "" : getIntent().getStringExtra(EXTRA_ID);

        initListView();

        reqRefresh();
        
    }
    @Override
    public PotatoBaseRecyclerViewAdapter getAdapter() {
        return mAdapter = new AAdapter(mContext);
    }

    @Override
    public void reqRefresh() {
        mSwipeContainer.showProgress();
        mPage = 1;
        presenter.reqRefresh("", "1", pageSize);
    }

    @Override
    public void reqLoadMore() {
        presenter.reqLoadMore("", mPage + 1 + "", pageSize);
    }

	@Override
    public void onClick(View v) {
         switch (v.getId()) {
                    case 1:
                        break;
                }
     }
	
	public static class ${mvpClass}Adapter extends PotatoBaseRecyclerViewAdapter<AAdapter.VH> {

        public AAdapter(Context context) {
            super(context);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(
                    R.layout.item_${mvpClass},
                    parent,
                    false);
            VH holder = new VH(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(VH vh, int position) {
            final ${mvpClass} bean = (${mvpClass}) mData.get(position);

            vh.tv_title.setText(bean.getTitle());
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    PageCtrl.start${mvpClass}DetailActivity(context, bean);
                }
            });
            ImageLoaderUtil.displayImage(bean.getBigCover(), vh.iv_pic, R.drawable.def_gray_big);

        }


        static class VH extends RecyclerView.ViewHolder {

            @Bind(R.id.iv_pic)
            ImageView iv_pic;
            @Bind(R.id.tv_title)
            TextView tv_title;

            public VH(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
	
	
}
