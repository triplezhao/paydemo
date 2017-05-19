package pay.lib.data.request;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;

import pay.lib.chips.api.ApiUrls;
import pay.lib.chips.api.BaiduCallback;
import pay.lib.data.result.BaiduImageListByCategoryEntity;

public class BaiduApi implements ApiUrls {
    //获取用户发布的视频. 命名，取api接口的后两位单词
    public static final String imageList = BaseBaiduURL;

    /**
     * http://image.baidu.com/data/imgs?col=%E7%BE%8E%E5%A5%B3&tag=%E5%85%A8%E9%83%A8&pn=1&rn=20&from=1
     */
    public static void imageList(CacheMode cacheMode, String id, String page, String pageSize, BaiduCallback<BaiduImageListByCategoryEntity> callback) {
        callback.setEntity(new BaiduImageListByCategoryEntity());
        OkHttpUtils.get(imageList)//
                   .tag("imageList")//
                   .cacheKey(imageList + id + page + pageSize)//
                   .cacheMode(cacheMode)//
                   .params("col", id)
                   .params("tag", "全部")
                   .params("pn", page)
                   .params("rn", pageSize)
                   .params("from", "1")
                   .execute(callback);
    }

}
