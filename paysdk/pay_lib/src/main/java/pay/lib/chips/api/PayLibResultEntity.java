package pay.lib.chips.api;

import org.json.JSONObject;


public class PayLibResultEntity extends BaseResultEntity {


    @Override
    public boolean isSucc() {
        return code.equals("0000");
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public BaseResultEntity parse(String json) {
        try {
            JSONObject root = new JSONObject(json);
            code = root.optString("respCode");
            message = root.optString("respMsg");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }

}