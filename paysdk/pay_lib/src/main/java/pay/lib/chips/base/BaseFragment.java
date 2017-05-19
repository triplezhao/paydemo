package pay.lib.chips.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import pay.lib.chips.common.CommonEvent;


public abstract class BaseFragment extends Fragment implements View.OnClickListener, Handler.Callback {
    /** extrars */
    /** views */
    /** adapters */
    /** data */
    /**
     * logic
     */
    public Handler mHandler = null;
    public Context mContext;
    public MaterialDialog progDialog = null;
    public View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mHandler = new Handler(this);
        EventBus
                .getDefault()
                .register(this);
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
        EventBus
                .getDefault()
                .unregister(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //  If null, all callbacks and messages will be removed.
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
        EventBus
                .getDefault()
                .unregister(this);
    }

    /**
     * 显示进度框
     */
    public void showProgressDialog(String msg) {
        if (progDialog == null)
            progDialog = new MaterialDialog.Builder(mContext)
                    .content(msg)
                    .progress(true, 0)
                    .build();
        progDialog.show();
    }

    /**
     * 隐藏进度框
     */
    public void dissmissProgressDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
            progDialog = null;
        }
    }

    /**
     * 接收到EventBus发布的消息事件
     *
     * @param event 消息事件
     */
    @CallSuper
    @Subscribe
    public void onEventMainThread(CommonEvent event) {

    }

    @Override
    public void onClick(View v) {

    }
}
