package pay.lib.chips.api;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.lzy.okhttputils.callback.AbsCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * ================================================
 * 修订历史：
 * ================================================
 */
public abstract class BaiduCallback<T> extends AbsCallback<T> {


    private BaseResultEntity entity;

    public BaseResultEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseResultEntity entity) {
        this.entity = entity;
    }

    //该方法是子线程处理，不能做ui相关的工作
    @Override
    public T parseNetworkResponse(Response response) throws Exception {
        String responseData = response
                .body()
                .string();
        if (TextUtils.isEmpty(responseData))
            throw getServerFail();
        /**
         * 一般来说，服务器返回的响应码都包含 code，msg，data 三部分，在此根据自己的业务需要完成相应的逻辑判断
         * 以下只是一个示例，具体业务具体实现
         */
        if (entity == null) {
            throw getServerFail();
        } else {
            entity = entity.parse(responseData);
        }
        if (entity.isSucc()) {
            return (T) entity;
        } else {
            final int code = Integer.valueOf(entity.code);
            switch (code) {
                case 0:
                    /**
                     * code = 0 代表成功，默认实现了Gson解析成相应的实体Bean返回，可以自己替换成fastjson等
                     * 对于返回参数，先支持 String，然后优先支持class类型的字节码，最后支持type类型的参数
                     */
                    break;
                case 400:
                    throw getServerFail();
                default:
                    throw getServerFail();
            }
            throw getServerFail();
        }
    }

    /**
     * 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程
     */
    public abstract void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e);

    public Exception getNetConnectFail() {
        return new Err(Err.NET_CONNECTFAIL, "网络未连接");
    }

    public Exception getNetFail() {
        return new Err(Err.NET_FAIL, "网络请求失败");
    }

    public Exception getServerFail() {
        return new Err(Err.SERVER_FAIL, "服务器请求失败");
    }

    public Exception getApiFail(String msg) {
        return new Err(Err.API_FAIL, "请求失败," + msg);
    }

    public Exception getCacheFail() {
        return new Err(Err.CACHE_FAIL, "缓存不存在");
    }

}
