package pay.demo.act;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.switfpass.pay.utils.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pay.demo.R;
import pay.lib.chips.base.BaseActivity;
import pay.lib.chips.common.PageCtrl;
import pay.lib.chips.util.UIUtils;
import pay.lib.data.abe.PrepayParam;

public class DemoActivity extends BaseActivity implements Demo.V {

    public static final String TAG = DemoActivity.class.getSimpleName();
    @Inject DemoPresenter presenter;
    EditText etOutTradeNo;
    EditText etBody;
    EditText etAttch;
    EditText etTotalFee;
    private DemoActivity context;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ssddd");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        context = this;
        DaggerDemo_C
                .builder()
                .module(new Demo.Module(this))
                .build()
                .inject(this);
        etOutTradeNo = (EditText) findViewById(R.id.et_out_trade_no);
        etBody = (EditText) findViewById(R.id.et_body);
        etAttch = (EditText) findViewById(R.id.et_attch);
        etTotalFee = (EditText) findViewById(R.id.et_total_fee);


//        out_trade_no：831422358455799//业务方订单号
//        body：测试购买商品
//        attch：附加信息
//        total_fee：1 // 总金额 单位分
        //跳转到支付订单页面，参数为 商家这边的订单信息
        String out_trade_no = dateFormat
                .format(new Date())
                .toString();
        String body = "测试购买商品xxx";
        String attch = "附加信息xxx";
        int total_fee = 2; //单位分


        //填写模拟信息
        etOutTradeNo.setText(out_trade_no);
        etBody.setText(body);
        etAttch.setText(attch);
        etTotalFee.setText(total_fee + "");

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_done) {
            gotoPay();
        }

    }

    @Override
    public void navigateToHomePage() {
//        PageCtrl.start2MainActivity(mContext);

    }

    private String genNonceStr() {
        Random random = new Random();
        return MD5.getMessageDigest(String
                .valueOf(random.nextInt(10000))
                .getBytes());
    }

    void gotoPay() {

        if (etOutTradeNo
                .getText()
                .length() <= 0) {
            UIUtils.toast(mContext, "请填写完整");
            return;
        }
        if (etBody
                .getText()
                .length() <= 0) {
            UIUtils.toast(mContext, "请填写完整");
            return;
        }
        if (etAttch
                .getText()
                .length() <= 0) {
            UIUtils.toast(mContext, "请填写完整");
            return;
        }
        if (etTotalFee
                .getText()
                .length() <= 0) {
            UIUtils.toast(mContext, "请填写完整");
            return;
        }

        PrepayParam prepayParam = new PrepayParam();

        prepayParam.setOut_trade_no(etOutTradeNo
                .getText()
                .toString());
        prepayParam.setBody(etBody
                .getText()
                .toString());
        prepayParam.setAttch(etAttch
                .getText()
                .toString());

        String fee = etTotalFee
                .getText()
                .toString();
        prepayParam.setTotal_fee(fee);
        PageCtrl.start2PayPage(mContext, prepayParam);

    }

}
