package ${packageName};

import javax.inject.Inject;

final class ${presenterClass} implements ${mvpClass}.P {


    private ${mvpClass}.V view;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */
    @Inject
    ${presenterClass}(
            ${mvpClass}.V view) {
        this.view = view;
    }


    @Override
    public void start() {

    }
	
    @Override
    public void reqRefresh(String id, String page, String pageSize) {
        BaiduApi.imageList(CacheMode.REQUEST_FAILED_READ_CACHE, id, page, pageSize, new BaiduCallback<BaiduImageListByCategoryEntity>() {
            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {

                if (e != null)
                    view.onRefreshFail(e.getMessage());
            }

            @Override
            public void onResponse(boolean isFromCache, BaiduImageListByCategoryEntity entity, Request request, @Nullable Response response) {
                view.onRefreshSucc(entity);
            }
        });
    }

    @Override
    public void reqLoadMore(String id, String page, String pageSize) {
        BaiduApi.imageList(CacheMode.REQUEST_FAILED_READ_CACHE, id, page, pageSize, new BaiduCallback<BaiduImageListByCategoryEntity>() {
            @Override
            public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
                if (e != null)
                    view.onLoadMoreFail(e.getMessage());
            }

            @Override
            public void onResponse(boolean isFromCache, BaiduImageListByCategoryEntity entity, Request request, @Nullable Response response) {
                view.onLoadMoreSucc(entity);

            }
        });
    }

}