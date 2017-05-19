package pay.lib.mvp.pay;

import android.support.annotation.Nullable;

import com.lzy.okhttputils.cache.CacheMode;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import pay.lib.chips.api.PaylibCallback;
import pay.lib.data.abe.PrepayApi;
import pay.lib.data.abe.PrepayEntity;
import pay.lib.data.abe.PrepayParam;

final class PayPagePresenter implements PayPage.P {


    private PayPage.V view;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    PayPagePresenter(PayPage.V view) {
        this.view = view;
    }


    @Override
    public void start() {

    }


    @Override
    public void reqPrePayId(PrepayParam param) {

        PrepayApi.req(CacheMode.NET_ONLY, param, new PaylibCallback<PrepayEntity>() {
            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {

                if (e != null)
                    view.onReqFail(e.getMessage());
            }

            @Override
            public void onResponse(boolean isFromCache, PrepayEntity entity, Request request, @Nullable Response response) {
                view.onReqSucc(entity);
            }
        });


    }
}