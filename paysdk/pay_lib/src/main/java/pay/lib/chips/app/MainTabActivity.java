package pay.lib.chips.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pay.lib.R;
import pay.lib.chips.base.BaseTabHostActivity;
import pay.lib.mvp.baidu.BaiduHomeActivity;

public class MainTabActivity extends BaseTabHostActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    public TabItem getTabItemView(int position) {

        TabItem tabItem = new TabItem();
        View tabItemView = mLayoutflater.inflate(R.layout.item_main_tab, null);
        ImageView iv_icon = (ImageView) tabItemView.findViewById(R.id.iv_icon);
        switch (position) {
            case 0:
                iv_icon.setImageResource(R.drawable.selector_nav_home);
                tabItem.setTitle("" + position);
                tabItem.setView(tabItemView);
                tabItem.setIntent(new Intent(getApplication(), BaiduHomeActivity.class));
                break;

            case 1:

                iv_icon.setImageResource(R.drawable.selector_nav_explore);
                tabItem.setTitle("" + position);
                tabItem.setView(tabItemView);
                tabItem.setIntent(new Intent(getApplication(), BaiduHomeActivity.class));
                break;
        }

        return tabItem;
    }

    @Override
    public int getTabItemCount() {
        return 2;
    }

    @Override
    public void onTabChanged(String s) {

    }
}
