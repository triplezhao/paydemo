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
            android:layout_height="@dimen/header_h"
            android:background="?attr/colorPrimary"
            app:contentInsetLeft="0dp"
            app:contentInsetStart="0dp"
            app:layout_scrollFlags="enterAlways"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
        >

            <RelativeLayout
                android:id="@+id/rl_header"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:background="@color/ifsee_blue"
                android:gravity="center_vertical">

                <TextView
                    android:id="@+id/tv_title"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_centerInParent="true"
                    android:ellipsize="end"
                    android:singleLine="true"
                    android:text="客户详情"
                    android:textColor="@color/potato_white"
                    android:textSize="@dimen/txt_max"/>

                <ImageView
                    android:id="@+id/iv_back"
                    style="@style/BackWhite"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_alignParentLeft="true"
                    android:layout_centerVertical="true"
                    android:src="@drawable/potato_ic_back"/>
                <ImageView
                    android:id="@+id/iv_setting"
                    style="@style/BackBlack"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_alignParentRight="true"
                    android:layout_centerVertical="true"
                    android:src="@drawable/setting"
                    android:visibility="gone"
                />

            </RelativeLayout>
        </android.support.v7.widget.Toolbar>
    </android.support.design.widget.AppBarLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layout_behavior="@string/appbar_scrolling_view_behavior">

        <com.potato.library.view.NormalEmptyView
            android:id="@+id/empty_view"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent">
        </com.potato.library.view.NormalEmptyView>
        <LinearLayout
            android:id="@+id/container"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

        </LinearLayout>


    </LinearLayout>

</android.support.design.widget.CoordinatorLayout>
