
package pay.lib.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.potato.library.util.L;

import java.util.ArrayList;
import java.util.List;

import pay.lib.chips.common.DatabaseHelper;
import pay.lib.data.bean.BaiduImageBean;


/**
 * create by freemaker
 */
public class BaiduImageBeanDao {
    public static final String TAG = "BaituImageBeanDao";
    public static final String TABLE_NAME = "BaituImageBeanTB";
    public SQLiteOpenHelper mOpenHelper;
    
    public static class Columns implements BaseColumns {
			public static final String id = "id";
			public static final String desc = "desc";
			public static final String tags = "tags";
			public static final String owner = "owner";
			public static final String fromPageTitle = "fromPageTitle";
			public static final String column = "column";
			public static final String parentTag = "parentTag";
			public static final String date = "date";
			public static final String downloadUrl = "downloadUrl";
			public static final String imageUrl = "imageUrl";
			public static final String imageWidth = "imageWidth";
			public static final String imageHeight = "imageHeight";
			public static final String thumbnailUrl = "thumbnailUrl";
			public static final String thumbnailWidth = "thumbnailWidth";
			public static final String thumbnailHeight = "thumbnailHeight";
			public static final String thumbLargeWidth = "thumbLargeWidth";
			public static final String thumbLargeHeight = "thumbLargeHeight";
			public static final String thumbLargeUrl = "thumbLargeUrl";
			public static final String thumbLargeTnWidth = "thumbLargeTnWidth";
			public static final String thumbLargeTnHeight = "thumbLargeTnHeight";
			public static final String thumbLargeTnUrl = "thumbLargeTnUrl";
			public static final String siteName = "siteName";
			public static final String siteLogo = "siteLogo";
			public static final String siteUrl = "siteUrl";
			public static final String fromUrl = "fromUrl";
			public static final String isBook = "isBook";
			public static final String bookId = "bookId";
			public static final String objUrl = "objUrl";
			public static final String shareUrl = "shareUrl";
			public static final String setId = "setId";
			public static final String albumId = "albumId";
			public static final String isAlbum = "isAlbum";
			public static final String albumName = "albumName";
			public static final String albumNum = "albumNum";
			public static final String userId = "userId";
			public static final String isVip = "isVip";
			public static final String isDapei = "isDapei";
			public static final String dressId = "dressId";
			public static final String dressBuyLink = "dressBuyLink";
			public static final String dressPrice = "dressPrice";
			public static final String dressDiscount = "dressDiscount";
			public static final String dressExtInfo = "dressExtInfo";
			public static final String dressTag = "dressTag";
			public static final String dressNum = "dressNum";
			public static final String objTag = "objTag";
			public static final String dressImgNum = "dressImgNum";
			public static final String hostName = "hostName";
			public static final String pictureId = "pictureId";
			public static final String pictureSign = "pictureSign";
			public static final String dataSrc = "dataSrc";
			public static final String contentSign = "contentSign";
			public static final String albumDi = "albumDi";
			public static final String canAlbumId = "canAlbumId";
			public static final String albumObjNum = "albumObjNum";
			public static final String appId = "appId";
			public static final String photoId = "photoId";
			public static final String fromName = "fromName";
			public static final String fashion = "fashion";
			public static final String title = "title";
    }
    
     public String[] allkeyjection = new String[]{
     				Columns._ID,
	                Columns.id,
	                Columns.desc,
	                Columns.tags,
	                Columns.owner,
	                Columns.fromPageTitle,
	                Columns.column,
	                Columns.parentTag,
	                Columns.date,
	                Columns.downloadUrl,
	                Columns.imageUrl,
	                Columns.imageWidth,
	                Columns.imageHeight,
	                Columns.thumbnailUrl,
	                Columns.thumbnailWidth,
	                Columns.thumbnailHeight,
	                Columns.thumbLargeWidth,
	                Columns.thumbLargeHeight,
	                Columns.thumbLargeUrl,
	                Columns.thumbLargeTnWidth,
	                Columns.thumbLargeTnHeight,
	                Columns.thumbLargeTnUrl,
	                Columns.siteName,
	                Columns.siteLogo,
	                Columns.siteUrl,
	                Columns.fromUrl,
	                Columns.isBook,
	                Columns.bookId,
	                Columns.objUrl,
	                Columns.shareUrl,
	                Columns.setId,
	                Columns.albumId,
	                Columns.isAlbum,
	                Columns.albumName,
	                Columns.albumNum,
	                Columns.userId,
	                Columns.isVip,
	                Columns.isDapei,
	                Columns.dressId,
	                Columns.dressBuyLink,
	                Columns.dressPrice,
	                Columns.dressDiscount,
	                Columns.dressExtInfo,
	                Columns.dressTag,
	                Columns.dressNum,
	                Columns.objTag,
	                Columns.dressImgNum,
	                Columns.hostName,
	                Columns.pictureId,
	                Columns.pictureSign,
	                Columns.dataSrc,
	                Columns.contentSign,
	                Columns.albumDi,
	                Columns.canAlbumId,
	                Columns.albumObjNum,
	                Columns.appId,
	                Columns.photoId,
	                Columns.fromName,
	                Columns.fashion,
	                Columns.title
		
		};
    
    
    public BaiduImageBeanDao(Context context) {
        mOpenHelper = DatabaseHelper.getInstance(context);
        L.d(TAG, "In onCreate method, create the keyvider: " + this
                + ", and DatabaseHelper: " + mOpenHelper);
    }
    
    /**
     * Use this static method to create the table
     * It will be called by {@link DatabaseHelper} during first launch time to create DB.
     * @param db
     */
    public static void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + Columns._ID + " integer primary key autoincrement, "
	                + Columns.id + " text, "
	                + Columns.desc + " text, "
	                + Columns.tags + " text, "
	                + Columns.owner + " text, "
	                + Columns.fromPageTitle + " text, "
	                + Columns.column + " text, "
	                + Columns.parentTag + " text, "
	                + Columns.date + " text, "
	                + Columns.downloadUrl + " text, "
	                + Columns.imageUrl + " text, "
	                + Columns.imageWidth + " text, "
	                + Columns.imageHeight + " text, "
	                + Columns.thumbnailUrl + " text, "
	                + Columns.thumbnailWidth + " text, "
	                + Columns.thumbnailHeight + " text, "
	                + Columns.thumbLargeWidth + " text, "
	                + Columns.thumbLargeHeight + " text, "
	                + Columns.thumbLargeUrl + " text, "
	                + Columns.thumbLargeTnWidth + " text, "
	                + Columns.thumbLargeTnHeight + " text, "
	                + Columns.thumbLargeTnUrl + " text, "
	                + Columns.siteName + " text, "
	                + Columns.siteLogo + " text, "
	                + Columns.siteUrl + " text, "
	                + Columns.fromUrl + " text, "
	                + Columns.isBook + " text, "
	                + Columns.bookId + " text, "
	                + Columns.objUrl + " text, "
	                + Columns.shareUrl + " text, "
	                + Columns.setId + " text, "
	                + Columns.albumId + " text, "
	                + Columns.isAlbum + " text, "
	                + Columns.albumName + " text, "
	                + Columns.albumNum + " text, "
	                + Columns.userId + " text, "
	                + Columns.isVip + " text, "
	                + Columns.isDapei + " text, "
	                + Columns.dressId + " text, "
	                + Columns.dressBuyLink + " text, "
	                + Columns.dressPrice + " text, "
	                + Columns.dressDiscount + " text, "
	                + Columns.dressExtInfo + " text, "
	                + Columns.dressTag + " text, "
	                + Columns.dressNum + " text, "
	                + Columns.objTag + " text, "
	                + Columns.dressImgNum + " text, "
	                + Columns.hostName + " text, "
	                + Columns.pictureId + " text, "
	                + Columns.pictureSign + " text, "
	                + Columns.dataSrc + " text, "
	                + Columns.contentSign + " text, "
	                + Columns.albumDi + " text, "
	                + Columns.canAlbumId + " text, "
	                + Columns.albumObjNum + " text, "
	                + Columns.appId + " text, "
	                + Columns.photoId + " text, "
	                + Columns.fromName + " text, "
	                + Columns.fashion + " text, "
	                + Columns.title + " text "
                + ");");
    }
    
    public long insert(BaiduImageBean bean) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = BaiduImageBean.bean2CV(bean);
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public void delete(String columnsName,String value) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        String selection = columnsName + " = ?";
        String[] selectionArgs = {value};
        db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    public void update(String columnsName,BaiduImageBean bean) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = BaiduImageBean.bean2CV(bean);
        String selection = columnsName + " = ?";
        String[] selectionArgs = {"id"};

        db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }

    public BaiduImageBean getBaituImageBeanByKey(String columnsName, String key) {
        BaiduImageBean bean = null;
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        String selection = columnsName + " = ?";
        String[] selectionArgs = {key};
        Cursor c = db.query(
                TABLE_NAME, allkeyjection, selection, selectionArgs, null, null, null);
        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                bean = BaiduImageBean.cursor2Bean(c);
                break;
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return bean;
    }

    public List<BaiduImageBean> getBaituImageBeanList() {
        List<BaiduImageBean> list = new ArrayList<BaiduImageBean>();
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = db.query(
                TABLE_NAME, allkeyjection, null, null, null, null, null);
        if (c != null && c.getCount() > 0) {
            BaiduImageBean bean = null;
            while (c.moveToNext()) {
                bean = BaiduImageBean.cursor2Bean(c);
                list.add(bean);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        return list;
    }
    
}

