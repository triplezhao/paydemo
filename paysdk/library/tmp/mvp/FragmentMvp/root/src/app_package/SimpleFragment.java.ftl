package ${packageName};

<#if applicationPackage??>import ${applicationPackage}.R;</#if>
import javax.inject.Inject;

public class ${mvpClass}Fragment extends BaseFragment implements ${mvpClass}.V {

    public static final String TAG = ${mvpClass}Fragment.class.getSimpleName();
    public static final String EXTRA_ID = "EXTRA_ID";
    public String mId;
    @Inject ${mvpClass}Presenter presenter;


     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.${layoutFragmentName}, container, false);

        ButterKnife.bind(this, view);
                       
        Dagger${mvpClass}_C.builder().module(new ${mvpClass}.Module(this)).build().inject(this);
        mId = getArguments() == null ? "" : getArguments().getString(EXTRARS__ID);
        presenter.start();
		
		return view;
    }

    @Override
    public void render(Object obj) {
		
	}
	
	@Override
    public void onClick(View v) {
         switch (v.getId()) {
                    case 1:
                        break;
                }
    }
	
}