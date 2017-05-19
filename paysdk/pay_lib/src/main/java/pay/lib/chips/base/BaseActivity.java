package pay.lib.chips.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.potato.library.util.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import pay.lib.chips.common.CommonEvent;
import pay.lib.chips.util.PhoneUtils;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, Handler.Callback, ActionMode.Callback {
    public static final String         EXTRA_From_Push = "EXTRA_From_Push";
    public              Context        mContext        = null;
    public              Handler        mHandler        = null;
    // 搜索时进度条
    public              MaterialDialog progDialog      = null;
    public InputMethodManager manager;
    public boolean fromPush = false;
    /** extrars */
    /** views */
    /** adapters */
    /** data */
    /**
     * logic
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		VMRuntime.getRuntime().setTargetHeapUtilization(TARGET_HEAP_UTILIZATION);
        mContext = this;
        fromPush = getIntent() == null ? false : getIntent().getBooleanExtra(EXTRA_From_Push, false);
        mHandler = new Handler(this);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        // 注册事件总线，不要在onStart和onResume中注册，会有问题：xx already registered to event class xxx
        if (!EventBus
                .getDefault()
                .isRegistered(this))
            EventBus
                    .getDefault()
                    .register(this);
    }

    public void onCreate(Bundle savedInstanceState, boolean islogin) {
        super.onCreate(savedInstanceState);
//		VMRuntime.getRuntime().setTargetHeapUtilization(TARGET_HEAP_UTILIZATION);
        mContext = this;
        mHandler = new Handler(this);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        // 注册事件总线，不要在onStart和onResume中注册，会有问题：xx already registered to event class xxx
        if (!EventBus
                .getDefault()
                .isRegistered(this))
            EventBus
                    .getDefault()
                    .register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
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

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {

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
    public void onBackPressed() {
        if (fromPush) {
            PhoneUtils.goBackOperate(mContext);
        } else {
            super.onBackPressed();
        }
//        PhoneUtils.goBackOperate(mContext);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        L.d("BaseActivity", "onActivityResult:" + requestCode + ":");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        L.d("BaseActivity", "onRequestPermissionsResult:");
        // Forward results to EasyPermissionsUtil
    }


}
