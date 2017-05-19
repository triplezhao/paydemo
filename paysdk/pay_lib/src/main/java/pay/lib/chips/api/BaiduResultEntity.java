package pay.lib.chips.api;

import org.json.JSONException;
import org.json.JSONObject;

public class BaiduResultEntity extends BaseResultEntity {

    @Override
    public boolean isSucc() {
        return code.equals("0");
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public BaseResultEntity parse(String json) {
        try {
            JSONObject root = new JSONObject(json);
            code = "0";
            if (root.has("error")) {
                code = root
                        .optJSONObject("error")
                        .optString("code");
                message = root
                        .optJSONObject("error")
                        .optString("description");
            }
            total = root.optInt("totalNum");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
}