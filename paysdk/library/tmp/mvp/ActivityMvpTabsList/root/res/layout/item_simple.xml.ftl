<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:orientation="vertical">

    <android.support.v7.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="@dimen/cardview_default_radius"
        app:cardElevation="8dp"
        app:cardPreventCornerOverlap="false"
        app:cardUseCompatPadding="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/iv_pic"
                android:layout_width="fill_parent"
                android:layout_height="180dp"
                android:scaleType="fitXY"/>

            <TextView
                android:id="@+id/tv_title"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:ellipsize="end"
                android:maxLines="2"
                android:padding="10dp"
                android:text="tv_contet"
                android:textAppearance="?attr/textAppearanceListItem"/>

        </LinearLayout>
    </android.support.v7.widget.CardView>
</LinearLayout>