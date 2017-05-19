package com.potato.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.potato.library.R;
import com.potato.library.util.L;


public class NormalEmptyView extends RelativeLayout implements EmptyViewInterface{
    public static final int EMPTY_TYPE_LOADING = 1;
    public static final int EMPTY_TYPE_ERROR = 2;
    public static final int EMPTY_TYPE_NOCONTENT = 3;
    public static final int EMPTY_TYPE_GONE = 4;
    public static final int EMPTY_SHOW = 5;

    public LinearLayout ll_empty;
    public TextView tv_text;
    public View pb_loading;
    public ImageView iv_pic;

    public String mEmptyTxt = "内容暂时为空，敬请等待~";
    public String mLoadingTxt = "内容获取中...";
    public String mErrorTxt = "数据加载异常，请稍后重试";

    public int mEmptyDrawableRes = R.drawable.empty_nocontent;
    public int mErrorDrawableRes = R.drawable.empty_nocontent;

    public int mEmptyType = EMPTY_TYPE_GONE;

    public String mTxt = mEmptyTxt;
    public int mPic = mEmptyDrawableRes;

    public Context mContext;

    public NormalEmptyView(Context context) {
        super(context);
    }

    public NormalEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.potato_normal_empty, this);
        ll_empty = (LinearLayout) findViewById(R.id.ll_empty);
        tv_text = (TextView) findViewById(R.id.tv_text);
        pb_loading = (View) findViewById(R.id.pb_loading);
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
        iv_pic.setImageResource(mEmptyDrawableRes);
        L.i("NormalEmptyView", "NormalEmptyView()");
    }

    public void showError() {
        mTxt = mErrorTxt;
        mPic = mErrorDrawableRes;

        iv_pic.setVisibility(View.VISIBLE);
        pb_loading.setVisibility(View.GONE);
        setClickable(true);
        mEmptyType = EMPTY_TYPE_ERROR;
        show();
    }

    public void showEmpty() {
        mTxt = mEmptyTxt;
        mPic = mEmptyDrawableRes;

        iv_pic.setVisibility(View.VISIBLE);
        pb_loading.setVisibility(View.GONE);
//        setClickable(false);
        setClickable(true);
        mEmptyType = EMPTY_TYPE_NOCONTENT;
        show();

    }

    public void showLoading() {
        mTxt = mLoadingTxt;

        tv_text.setText(mLoadingTxt);
        pb_loading.setVisibility(View.VISIBLE);
        iv_pic.setVisibility(View.GONE);
        setClickable(false);
        mEmptyType = EMPTY_TYPE_LOADING;
        show();
    }

    public void hide() {
        this.setVisibility(View.GONE);
        mEmptyType = EMPTY_TYPE_GONE;
    }

    public void show() {
        this.setVisibility(View.VISIBLE);
        mEmptyType = EMPTY_SHOW;
        tv_text.setText(mTxt);
        iv_pic.setImageResource(mPic);
    }

    public void setEmptyType(int type) {

        this.setVisibility(View.VISIBLE);

        switch (type) {
            case EMPTY_TYPE_ERROR:
                showError();
                break;
            case EMPTY_TYPE_NOCONTENT:
                showEmpty();
                break;
            case EMPTY_TYPE_LOADING:
                showLoading();
                break;
            case EMPTY_TYPE_GONE:
                hide();
                break;
        }
        mEmptyType = type;
    }

    public String getmEmptyTxt() {
        return mEmptyTxt;
    }

    public void setmEmptyTxt(String mEmptyTxt) {
        this.mEmptyTxt = mEmptyTxt;
    }

    public String getmLoadingTxt() {
        return mLoadingTxt;
    }

    public void setmLoadingTxt(String mLoadingTxt) {
        this.mLoadingTxt = mLoadingTxt;
    }

    public int getmEmptyDrawableRes() {
        return mEmptyDrawableRes;
    }

    public void setmEmptyDrawableRes(int mEmptyDrawableRes) {
        this.mEmptyDrawableRes = mEmptyDrawableRes;
    }

    public int getmErrorDrawableRes() {
        return mErrorDrawableRes;
    }

    public void setmErrorDrawableRes(int mErrorDrawableRes) {
        this.mErrorDrawableRes = mErrorDrawableRes;
    }

    public String getmErrorTxt() {
        return mErrorTxt;
    }

    public void setmErrorTxt(String mErrorTxt) {
        this.mErrorTxt = mErrorTxt;
    }
}
