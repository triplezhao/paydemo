package pay.lib.mvp.pay;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.switfpass.pay.MainApplication;
import com.switfpass.pay.activity.PayPlugin;
import com.switfpass.pay.bean.RequestMsg;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import pay.lib.R;
import pay.lib.chips.base.BaseActivity;
import pay.lib.chips.common.PageCtrl;
import pay.lib.chips.event.PayEvent;
import pay.lib.data.abe.PrepayBean;
import pay.lib.data.abe.PrepayEntity;
import pay.lib.data.abe.PrepayParam;
import pay.lib.data.request.PayLibApi;


/**
 * 微信支付流程
 * 1获取预付id
 * 2获取成功tokenid后，则构造三方sdk的msg。（设置支付方式，设置appid等）
 * 3唤起微信支付流程
 * 4本地收到sdk的成功回调
 * <p>
 * 支付宝流程
 * 1直接用带着参数，去webview访问url页面。
 * 2页面内拦截成功跳转的地址，手动回调给本sdk
 */

public class PayPageActivity extends BaseActivity implements PayPage.V {

    public static final String TAG        = PayPageActivity.class.getSimpleName();
    public static final String EXTRA_ID   = "EXTRA_ID";
    public static final String EXTRA_Bean = "EXTRA_Bean";
    public String mId;
    PrepayParam mPrepayParam;
    View        iv_back;
    TextView    etOutTradeNo;
    TextView    etBody;
    TextView    etAttch;
    TextView    etTotalFee;
    RadioButton rb_wx;
    RadioButton rb_zfb;
    @Inject PayPagePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_page);
        iv_back = findViewById(R.id.iv_back);
        DaggerPayPage_C
                .builder()
                .module(new PayPage.Module(this))
                .build()
                .inject(this);
        mId = getIntent() == null ? "" : getIntent().getStringExtra(EXTRA_ID);
        mPrepayParam = getIntent() == null ? null : (PrepayParam) getIntent().getSerializableExtra(EXTRA_Bean);
        render(mPrepayParam);

    }

    @Override
    public void render(PrepayParam prepayParam) {
        etOutTradeNo = (TextView) findViewById(R.id.et_out_trade_no);
        etBody = (TextView) findViewById(R.id.et_body);
        etAttch = (TextView) findViewById(R.id.et_attch);
        etTotalFee = (TextView) findViewById(R.id.et_total_fee);
        rb_wx = (RadioButton) findViewById(R.id.rb_wx);
        rb_zfb = (RadioButton) findViewById(R.id.rb_zfb);

        //填写模拟信息
        etOutTradeNo.setText(prepayParam.getOut_trade_no());
        etBody.setText(prepayParam.getBody());
        etAttch.setText(prepayParam.getAttch());
        etTotalFee.setText(prepayParam.getTotal_fee() + "");

        iv_back.setOnClickListener(this);

        if (prepayParam
                .getLib_payType()
                .equals("0")) {
            rb_wx.setChecked(true);
        }
        if (prepayParam
                .getLib_payType()
                .equals("1")) {
            rb_zfb.setChecked(true);
        }
        rb_wx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mPrepayParam.setLib_payType("0");
                }
            }
        });
        rb_zfb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mPrepayParam.setLib_payType("1");
                }
            }
        });
    }

    @Override
    public void reqPrePayId() {
        showProgressDialog("加载中");

        //微信支付流程
        mPrepayParam.setMch_create_ip("127.0.0.1");
        mPrepayParam.setMethod("submitOrderInfo");
        presenter.reqPrePayId(mPrepayParam);

    }

    @Override
    public void reqWxPay(PrepayBean prepayBean) {
        RequestMsg msg = new RequestMsg();
        msg.setTokenId(prepayBean.token_id);
        msg.setTradeType(MainApplication.WX_APP_TYPE);
        msg.setAppId("wx2a5538052969956e");//wxd3a1cdf74d0c41b3
        PayPlugin.unifiedAppPay(PayPageActivity.this, msg);
//        finish();
    }


    @Override
    public void reqZfbPay(PrepayBean prepayBean) {
        float total = 1;
        try {
            total = Integer.parseInt(mPrepayParam.getTotal_fee());
            total = total / 100;
        } catch (Exception e) {
        }
//        http://i.pay.123sec.com/pay/pay.php?total_fee=1&body=%E6%B0%B4%E6%9E%9C&tradeno=1020
        StringBuilder params = new StringBuilder();
        params
                .append("tradeno=")
                .append(mPrepayParam.getOut_trade_no())
                .append("&body=")
                .append(mPrepayParam.getBody())
                .append("&total_fee=")
                .append(total + "")
                .append("&token_id=")
                .append(prepayBean.token_id);

        String url = PayLibApi.url_zfb + "?" + params.toString();
        PageCtrl.start2WebViewActivity(mContext, url);
        finish();

    }


    @Override
    public void onReqSucc(PrepayEntity entity) {
        dissmissProgressDialog();
        //请求sdk进行支付
        //微信支付流程
        if (mPrepayParam
                .getLib_payType()
                .equals("0")) {
            reqWxPay(entity.bean);
        } else {
            reqZfbPay(entity.bean);
        }

    }

    @Override
    public void onReqFail(String msg) {
        dissmissProgressDialog();
    }

    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.iv_back) {
            finish();
        }
        if (i == R.id.bt_done) {
            reqPrePayId();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(PayEvent event) {
        if (event.what == 0) {
        } else {
            finish();
        }
    }

}
