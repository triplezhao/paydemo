package pay.lib.mvp.baidu;

import android.os.Handler;
import android.support.annotation.Nullable;

import com.lzy.okhttputils.cache.CacheMode;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import pay.lib.chips.api.BaiduCallback;
import pay.lib.data.request.BaiduApi;
import pay.lib.data.result.BaiduImageListByCategoryEntity;

final class BaiduListPresenter implements BaiduList.P {


    private BaiduList.V view;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    BaiduListPresenter(BaiduList.V view) {
        this.view = view;
    }


    @Override
    public void start() {

    }


    @Override
    public void reqRefresh(String id, String page, String pageSize) {
        BaiduApi.imageList(CacheMode.NET_ONLY, id, page, pageSize, new BaiduCallback<BaiduImageListByCategoryEntity>() {
            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {

                if (e != null)
                    view.onRefreshFail(e.getMessage());
            }

            @Override
            public void onResponse(boolean isFromCache, final BaiduImageListByCategoryEntity entity, Request request, @Nullable Response response) {

                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        view.onRefreshSucc(entity);
                        //execute the task
                    }

                }, 3000);
            }
        });
    }

    @Override
    public void reqLoadMore(String id, String page, String pageSize) {
        BaiduApi.imageList(CacheMode.NET_ONLY, id, page, pageSize, new BaiduCallback<BaiduImageListByCategoryEntity>() {
            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                if (e != null)
                    view.onLoadMoreFail(e.getMessage());
            }

            @Override
            public void onResponse(boolean isFromCache, final BaiduImageListByCategoryEntity entity, Request request, @Nullable Response response) {
                view.onLoadMoreSucc(entity);

            }
        });
    }
}