package pay.lib.data.abe;

//import

import java.io.Serializable;

import pay.lib.chips.base.BaseBean;

public class PrepayParam extends BaseBean implements Serializable {

    private String out_trade_no  = "0";//业务方订单号
    private String body          = "测试购买商品";
    private String attch         = "附加信息";
    private String total_fee     = "1"; // 总金额 单位分";
    private String method        = "submitOrderInfo";
    private String mch_create_ip = "127.0.0.1";
    private String lib_payType   = "0"; //0是微信  1是支付宝

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttch() {
        return attch;
    }

    public void setAttch(String attch) {
        this.attch = attch;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMch_create_ip() {
        return mch_create_ip;
    }

    public void setMch_create_ip(String mch_create_ip) {
        this.mch_create_ip = mch_create_ip;
    }

    public String getLib_payType() {
        return lib_payType;
    }

    public void setLib_payType(String lib_payType) {
        this.lib_payType = lib_payType;
    }
}