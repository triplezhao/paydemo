package com.potato.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AutoChangeImageView extends ImageView {

    public AutoChangeImageView(Context context) {
        super(context);
    }

    public AutoChangeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //
        if (getDrawable() == null) return;
        int width = getDrawable().getIntrinsicWidth();
        int height = getDrawable().getIntrinsicHeight();
        int currentWidth = getMeasuredWidth();

        int currentHeight = getMeasuredHeight();
        float xx = (float) currentWidth / (float) width;
        currentHeight = (int) (xx * height);
        setMeasuredDimension(currentWidth, currentHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//		 paint.setAntiAlias(true);
//		Drawable drawable = getDrawable();
//		float scale = (float) getMeasuredWidth() / (float) drawable.getIntrinsicWidth();
//		canvas.save();
//		canvas.scale(scale, scale);
//		drawable.draw(canvas);
//		canvas.restore();
    }
}
