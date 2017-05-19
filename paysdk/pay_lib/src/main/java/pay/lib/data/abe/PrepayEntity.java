package pay.lib.data.abe;

import com.google.gson.Gson;

import org.json.JSONObject;

import pay.lib.chips.api.PayLibResultEntity;

/**
 * create by freemaker
 */

public class PrepayEntity extends PayLibResultEntity {
    public static final String TAG = "PrepayEntity";
    public PrepayBean bean;

    @Override
    public PayLibResultEntity parse(String json) {
        try {
            JSONObject root = new JSONObject(json);
            code = "0000";
            message = "respMsg";

//            JSONObject data = root.optJSONObject("respResult");

//            total = data.optInt("count");
//            list = new Gson().fromJson(data
//                    .optJSONArray("list")
//                    .toString(), new TypeToken<ArrayList<PrepayBean>>() {
//            }.getType());
            bean = new Gson().fromJson(root.toString(), PrepayBean.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }

}