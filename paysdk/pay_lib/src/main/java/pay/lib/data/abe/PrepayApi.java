package pay.lib.data.abe;

import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.model.HttpParams;

import pay.lib.chips.api.PaylibCallback;
import pay.lib.chips.util.ApiTool;
import pay.lib.data.request.PayLibApi;


public class PrepayApi extends PayLibApi {

    /**
     * method：submitOrderInfo
     * out_trade_no：831422358455799
     * body：测试购买商品
     * attch：附加信息
     * total_fee：1
     * mch_create_ip：127.0.0.1
     */
    public static void req(CacheMode cacheMode, PrepayParam param, PaylibCallback<PrepayEntity> callback) {
        //请求地址
        String url = url_prepay;
        //请求回来后使用的解析器
        callback.setEntity(new PrepayEntity());
        HttpParams map = ApiTool.bean2Map(param);
        //除了那4个其他的参数删除
        map.removeUrl("lib_payType");
//        HttpParams map = new HttpParams();

//        map.put("out_trade_no", out_trade_no);
//        map.put("body", body);
//        map.put("attch", attch);
//        map.put("total_fee", total_fee + "");
//
//        map.put("method", "submitOrderInfo");
//        map.put("mch_create_ip", "127.0.0.1");

        baseReq(url, map, callback, cacheMode);
    }
}
