package pay.lib.chips.api;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.lzy.okhttputils.model.HttpParams;
import com.lzy.okhttputils.request.BaseRequest;
import com.potato.library.util.MD5Util;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * ================================================
 * 修订历史：
 * ================================================
 */
public abstract class PaylibCallback<T> extends CommonCallback<T> {

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
                case 1:
                    throw new Err(Err.API_FAIL, "请求失败," + entity.getMsg());
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
        return new Err(Err.API_FAIL, "" + msg);
    }

    public Exception getCacheFail() {
        return new Err(Err.CACHE_FAIL, "缓存不存在");
    }


    /**
     * 请求加密代码
     */
    private static final Random RANDOM = new Random();
    private static final String CHARS  = "0123456789abcdefghijklmnopqrstuvwxyz";

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //以下是示例加密代码，根据自己的业务需求和服务器的配合，算法自行决定
//        sign(request.getParams());
    }

    /**
     * 针对URL进行签名，关于这几个参数的作用，详细请看
     * http://www.cnblogs.com/bestzrz/archive/2011/09/03/2164620.html
     */
    private void sign(HttpParams params) {
        params.put("nonce", getRndStr(6 + RANDOM.nextInt(8)));
        params.put("timestamp", "" + (System.currentTimeMillis() / 1000L));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : getSortedMapByKey(params.urlParamsMap).entrySet()) {
            sb
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        sb.delete(sb.length() - 1, sb.length());
        String sign = MD5Util.md5(sb.toString());
        params.put("sign", sign);
    }

    /**
     * 获取随机数
     */
    private String getRndStr(int length) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < length; i++) {
            ch = CHARS.charAt(RANDOM.nextInt(CHARS.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 按照key的自然顺序进行排序，并返回
     */
    private Map<String, String> getSortedMapByKey(ConcurrentHashMap<String, String> map) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        };
        TreeMap<String, String> treeMap = new TreeMap<>(comparator);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }
        return treeMap;
    }
}

