package pay.lib.mvp.baidu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pay.lib.data.bean.BaiduCategory;

final class BaiduHomePresenter implements BaiduHome.P {


    private BaiduHome.V view;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    BaiduHomePresenter(
            BaiduHome.V view) {
        this.view = view;
    }


    @Override
    public void start() {

    }


    @Override
    public void loadData() {
        List<BaiduCategory> resultData = new ArrayList<BaiduCategory>();
        resultData.add(new BaiduCategory("美女", "美女"));
        resultData.add(new BaiduCategory("动漫", "动漫"));
        resultData.add(new BaiduCategory("明星", "明星"));
        resultData.add(new BaiduCategory("汽车", "汽车"));
        resultData.add(new BaiduCategory("摄影", "摄影"));
        resultData.add(new BaiduCategory("美食", "美食"));
        view.render(resultData);
    }
}