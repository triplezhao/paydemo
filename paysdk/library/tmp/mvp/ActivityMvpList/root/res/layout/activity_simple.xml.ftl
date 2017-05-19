<?xml version="1.0" encoding="utf-8"?>

<android.support.design.widget.CoordinatorLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.design.widget.AppBarLayout
        android:id="@+id/appbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

		  <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
		
        <RelativeLayout
            android:id="@+id/rl_header"
            android:layout_width="fill_parent"
            android:layout_height="50dip"
            android:background="@color/sticker_blue"
            android:gravity="center_vertical">

            <TextView
                android:id="@+id/tv_title"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_centerInParent="true"
                android:layout_centerVertical="true"
                android:layout_marginLeft="20dp"
                android:ellipsize="end"
                android:singleLine="true"
                android:text="FitTime"
                android:textColor="@color/potato_white"
                android:textSize="@dimen/txt_max"/>

            <ImageView
                android:id="@+id/iv_back"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentLeft="true"
                android:layout_centerVertical="true"
                android:onClick="onClick"
                android:padding="10dip"
                android:src="@drawable/potato_ic_back"/>
        </RelativeLayout>

    </android.support.design.widget.AppBarLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_behavior="@string/appbar_scrolling_view_behavior">

        <include
            android:id="@+id/include_a"
            layout="@layout/include_list"></include>
    </LinearLayout>

</android.support.design.widget.CoordinatorLayout>
