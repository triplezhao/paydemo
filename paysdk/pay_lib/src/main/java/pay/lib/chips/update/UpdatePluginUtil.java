/*
package potato.demo.chips.update;

import android.app.Activity;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.UpdateConfig;
import org.lzh.framework.updatepluginlib.callback.UpdateCheckCB;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.model.UpdateParser;
import org.lzh.framework.updatepluginlib.strategy.UpdateStrategy;

import ifsee.aiyouyun.chips.util.UIUtils;

import static ifsee.aiyouyun.data.request.AiyouyunApi.url_version;
import static potato.demo.data.request.QIApi.url_version;

*/
/**
 * Created by admin on 2016/10/14.
 *//*


public class UpdatePluginUtil {
    */
/**
     * 使用说明
     * https://github.com/yjfnypeu/UpdatePlugin/blob/master/Usage.md
     *//*


    public static void init(final Context context) {

       */
/* CheckEntity checkEntity = new CheckEntity();
        checkEntity.setUrl(url_version);
        Map<String, String> params = new HashMap<>();
        params.put("version", BuildConfig.VERSION_NAME);
        params.put("plateform", "android");
        checkEntity.setParams(params);*//*


        UpdateConfig.getConfig()
                // url 与 checkEntity方法可任选一种填写，且至少必填一种。
                .url(url_version)
                // 同url方法。CheckEntity方法可填写url,params,method。可在此设置为post请求
//                .checkEntity(checkEntity)
                // 必填：用于从数据更新接口获取的数据response中。解析出Update实例。以便框架内部处理
                .jsonParser(new UpdateParser() {
                                @Override
                                public Update parse(String response) {
                                    // 此处根据上面url接口返回的数据response进行update类组装。框架内部会使用此
                                    // 组装的update实例判断是否需要更新以做进一步工作
                                    Update update = new Update("");
                                    try {
                                        JSONObject root = new JSONObject(response);
                                        int code = Integer.parseInt(root.optString("code"));
                                        if (code == 10000) {
                                            JSONObject data = root.optJSONObject("data");
                                            update.setUpdateUrl(data.optString("link"));
                                            update.setVersionCode(Integer.valueOf(data.optString("version").replace(".", "")));
                                            update.setVersionName(data.optString("version"));
                                            // 此apk包是否为强制更新
                                            update.setForced(data.optString("status").equals("1"));
                                            update.setUpdateContent(data.optString("msg"));
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    return update;
                                }
                            }
                )
                .strategy(new UpdateStrategy() {
                    @Override
                    public boolean isShowUpdateDialog(Update update) {
                        return true;
                    }

                    @Override
                    public boolean isAutoInstall() {
                        return true;
                    }

                    @Override
                    public boolean isShowDownloadDialog() {
                        return true;
                    }
                })
        ;
    }

    //检测更新，强制
    public static void checkUseQiangzhi(Activity activity) {

        UpdateBuilder.create()
                .check(activity);

    }

    //检测更新，不强制
    public static void checkNotQiangzhi(final Activity activity) {

        UpdateBuilder.create()
                .jsonParser(
                        new UpdateParser() {
                            @Override
                            public Update parse(String response) {
                                // 此处根据上面url接口返回的数据response进行update类组装。框架内部会使用此
                                // 组装的update实例判断是否需要更新以做进一步工作
                                Update update = new Update("");
                                try {
                                    JSONObject root = new JSONObject(response);
                                    int code = Integer.parseInt(root.optString("code"));
                                    if (code == 10000) {
                                        JSONObject data = root.optJSONObject("data");
                                        update.setUpdateUrl(data.optString("link"));
                                        update.setVersionCode(Integer.valueOf(data.optString("version").replace(".", "")));
                                        update.setVersionName(data.optString("version"));
                                        //永远不强制
                                        update.setForced(false);
                                        update.setUpdateContent(data.optString("msg"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                return update;
                            }
                        }
                )
                .checkCB(new UpdateCheckCB() {
                    @Override
                    public void hasUpdate(Update update) {
                        // 有新版本APK更新的回调
                    }

                    @Override
                    public void noUpdate() {
                        // 没有新版本的回调
                        UIUtils.toast(activity.getApplicationContext(), "已经是最新版本");
                    }

                    @Override
                    public void onCheckError(int i, String s) {
                        // 更新检查错误的回调
                        UIUtils.toast(activity.getApplicationContext(), s);
                    }

                    @Override
                    public void onUserCancel() {
                        // 用于取消更新时的回调
                    }

                    @Override
                    public void onCheckIgnore(Update update) {
                        // 用户点击忽略此版本更新时的回调
                    }
                }).check(activity);
    }

}
*/
