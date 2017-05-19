package ${packageName};

<#if applicationPackage??>import ${applicationPackage}.R;</#if>
import javax.inject.Inject;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ${fragmentMvpClass}Fragment extends BaseDefaultListFragment implements ${fragmentMvpClass}.V {

    public static final String TAG = ${fragmentMvpClass}Fragment.class.getSimpleName();
    
	public static final String EXTRARS_SECTION_ID = "EXTRARS_SECTION_ID";
    public static final String EXTRARS_TITLE = "EXTRARS_TITLE";

    @Inject ${fragmentMvpClass}Presenter presenter;

	 public static ${fragmentClass} instance(Context context,long sectionId, String title){
        Bundle args = new Bundle();
        args.putLong(${fragmentClass}.EXTRARS_SECTION_ID, sectionId);
        args.putString(${fragmentClass}.EXTRARS_TITLE, title);
        ${fragmentClass} pageFragement = (${fragmentClass})Fragment.instantiate(context, ${fragmentClass}.class.getName(), args);
		return pageFragement;
    }
	
	
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.${layoutFragmentName}, container, false);

        ButterKnife.bind(this, view);
                       
        Dagger${fragmentMvpClass}_C.builder().module(new ${fragmentMvpClass}.Module(this)).build().inject(this);
       
        mSectionId = getArguments() == null ? 0 : getArguments().getLong(EXTRARS_SECTION_ID);
        mTitle = getArguments() == null ? "" : getArguments().getString(EXTRARS_TITLE);

        initListView();
        reqRefresh();
		return view;
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

    }

    public static class ${fragmentMvpClass}Adapter extends PotatoBaseRecyclerViewAdapter<AAdapter.VH> {

        public AAdapter(Context context) {
            super(context);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(
                    R.layout.item_${classToResource(fragmentMvpClass)},
                    parent,
                    false);
            VH holder = new VH(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(final VH vh, int position) {
            final Object bean = (Object) mData.get(position);

            vh.tv_title.setText(bean.getTitle());
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    PageCtrl.startJiongTuDetailActivity(context, bean);
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