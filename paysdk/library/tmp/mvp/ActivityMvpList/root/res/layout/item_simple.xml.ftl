<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_vertical"
    android:orientation="horizontal"
    android:paddingBottom="8dp"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:paddingTop="8dp">


    <com.makeramen.roundedimageview.RoundedImageView
        android:id="@+id/iv_pic"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:scaleType="fitXY"
        app:riv_border_color="#333333"
        app:riv_corner_radius="5dip" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        android:orientation="vertical"
        android:padding="9dp">

        <TextView
            android:id="@+id/tv_title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="title"
            android:textAppearance="?attr/textAppearanceListItem" />

        <TextView
            android:id="@+id/tv_content"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="tv_content"
            android:textAppearance="?attr/textAppearanceListItem" />
    </LinearLayout>
</LinearLayout>