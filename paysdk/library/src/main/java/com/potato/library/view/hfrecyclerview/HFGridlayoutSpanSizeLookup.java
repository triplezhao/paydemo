package com.potato.library.view.hfrecyclerview;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by cundong on 2015/10/23.
 * <p/>
 * RecyclerView为GridLayoutManager时，设置了HeaderView，就会用到这个SpanSizeLookup
 */
public class HFGridlayoutSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    public HFRecyclerViewAdapter adapter;
    public int mSpanSize = 1;

    public HFGridlayoutSpanSizeLookup(HFRecyclerViewAdapter adapter, int spanSize) {
        this.adapter = adapter;
        this.mSpanSize = spanSize;
    }

    @Override
    public int getSpanSize(int position) {
        boolean isHeaderOrFooter = adapter.isHeader(position) || adapter.isFooter(position);
        if (isHeaderOrFooter) {
            return mSpanSize;
        } else {
            return 1;
        }
    }
}