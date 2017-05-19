package com.potato.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.potato.library.R;

public class KeepRatioImageView extends ImageView{
	private int targetH;
	private int targetW;
	public KeepRatioImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public KeepRatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		//方式1获取属性
		TypedArray a = context
				.obtainStyledAttributes(attrs, R.styleable.ratioimageview);
		targetW = a.getInteger(R.styleable.ratioimageview_targetx, 0);
		targetH = a.getInteger(R.styleable.ratioimageview_targety, 0);
		a.recycle(); // 提示大家不要忘了回收资源
	}

	public KeepRatioImageView(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// TODO Auto-generated method stub
//		heightMeasureSpec=(int) (widthMeasureSpec*1.8);
		if(targetH==0||targetW==0) return ;
		int currentWidth = getMeasuredWidth();
		int currentHeight = getMeasuredHeight();
		currentHeight=(int) (currentWidth*(float)targetH/(float)targetW);
//		L.i("ImageLoadView", "currentWidth"+currentWidth+"currentHeight"+currentHeight);
		setMeasuredDimension(currentWidth, currentHeight);
	}

	public void setTargetWH(int targetW, int targetH){
		this.targetW=targetW;
		this.targetH=targetH;
	}
}
