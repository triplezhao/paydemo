package pay.lib.data.request;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.callback.AbsCallback;
import com.lzy.okhttputils.model.HttpParams;

import okhttp3.MediaType;
import pay.lib.chips.api.ApiUrls;

public class PayLibApi implements ApiUrls {
    //获取用户发布的视频. 命名，取api接口的后两位单词
    public static final String url_prepay = "http://i.pay.123sec.com/server/request.php";
    public static final String url_zfb    = " http://i.pay.123sec.com/pay/pay.php";


    public static void baseReq(String url, HttpParams map, AbsCallback callback, CacheMode cacheMode) {
        OkHttpUtils.post(url)//
                   .tag(callback.hashCode())//
                   .cacheKey(url + map.toString())//
                   .cacheMode(cacheMode)//
                   .params(map)
//                   .params("signature", ApiTool.getSign(map))
                   .mediaType(MediaType.parse("application/json"))
                   .execute(callback);
    }

    public static void baseReqGet(String url, HttpParams map, AbsCallback callback, CacheMode cacheMode) {
        OkHttpUtils.get(url)//
                   .tag(callback.hashCode())//
                   .cacheKey(url + map.toString())//
                   .cacheMode(cacheMode)//
                   .params(map)
//                   .params("signature", ApiTool.getSign(map))
//                   .mediaType(MediaType.parse("application/json"))
                   .execute(callback);
    }

}
