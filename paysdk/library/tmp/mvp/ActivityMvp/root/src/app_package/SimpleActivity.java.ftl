
package ${packageName};

<#if applicationPackage??>import ${applicationPackage}.R;</#if>
import javax.inject.Inject;

public class ${mvpClass}Activity extends BaseActivity implements ${mvpClass}.V {

    public static final String TAG = ${mvpClass}Activity.class.getSimpleName();
    public static final String EXTRA_ID = "EXTRA_ID";
    public String mId;
    @Inject ${mvpClass}Presenter presenter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutActivityName});
        ButterKnife.bind(this);
        Dagger${mvpClass}_C.builder().module(new ${mvpClass}.Module(this)).build().inject(this);
        mId = getIntent() == null ? "" : getIntent().getStringExtra(EXTRA_ID);
        presenter.start();
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
