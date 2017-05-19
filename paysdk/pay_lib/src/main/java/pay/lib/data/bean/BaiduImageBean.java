package pay.lib.data.bean;

//import

import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import pay.lib.chips.base.BaseBean;
import pay.lib.data.db.BaiduImageBeanDao;

public class BaiduImageBean extends BaseBean implements Serializable {

    //keypslist
    private String id;
    private String desc;
    private String tags;
    private String owner;
    private String fromPageTitle;
    private String column;
    private String parentTag;
    private String date;
    private String downloadUrl;
    private String imageUrl;
    private String imageWidth;
    private String imageHeight;
    private String thumbnailUrl;
    private String thumbnailWidth;
    private String thumbnailHeight;
    private String thumbLargeWidth;
    private String thumbLargeHeight;
    private String thumbLargeUrl;
    private String thumbLargeTnWidth;
    private String thumbLargeTnHeight;
    private String thumbLargeTnUrl;
    private String siteName;
    private String siteLogo;
    private String siteUrl;
    private String fromUrl;
    private String isBook;
    private String bookId;
    private String objUrl;
    private String shareUrl;
    private String setId;
    private String albumId;
    private String isAlbum;
    private String albumName;
    private String albumNum;
    private String userId;
    private String isVip;
    private String isDapei;
    private String dressId;
    private String dressBuyLink;
    private String dressPrice;
    private String dressDiscount;
    private String dressExtInfo;
    private String dressTag;
    private String dressNum;
    private String objTag;
    private String dressImgNum;
    private String hostName;
    private String pictureId;
    private String pictureSign;
    private String dataSrc;
    private String contentSign;
    private String albumDi;
    private String canAlbumId;
    private String albumObjNum;
    private String appId;
    private String photoId;
    private String fromName;
    private String fashion;
    private String title;

    //set get list
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return this.tags;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setFromPageTitle(String fromPageTitle) {
        this.fromPageTitle = fromPageTitle;
    }

    public String getFromPageTitle() {
        return this.fromPageTitle;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumn() {
        return this.column;
    }

    public void setParentTag(String parentTag) {
        this.parentTag = parentTag;
    }

    public String getParentTag() {
        return this.parentTag;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageWidth() {
        return this.imageWidth;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageHeight() {
        return this.imageHeight;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailWidth(String thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public void setThumbnailHeight(String thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public void setThumbLargeWidth(String thumbLargeWidth) {
        this.thumbLargeWidth = thumbLargeWidth;
    }

    public String getThumbLargeWidth() {
        return this.thumbLargeWidth;
    }

    public void setThumbLargeHeight(String thumbLargeHeight) {
        this.thumbLargeHeight = thumbLargeHeight;
    }

    public String getThumbLargeHeight() {
        return this.thumbLargeHeight;
    }

    public void setThumbLargeUrl(String thumbLargeUrl) {
        this.thumbLargeUrl = thumbLargeUrl;
    }

    public String getThumbLargeUrl() {
        return this.thumbLargeUrl;
    }

    public void setThumbLargeTnWidth(String thumbLargeTnWidth) {
        this.thumbLargeTnWidth = thumbLargeTnWidth;
    }

    public String getThumbLargeTnWidth() {
        return this.thumbLargeTnWidth;
    }

    public void setThumbLargeTnHeight(String thumbLargeTnHeight) {
        this.thumbLargeTnHeight = thumbLargeTnHeight;
    }

    public String getThumbLargeTnHeight() {
        return this.thumbLargeTnHeight;
    }

    public void setThumbLargeTnUrl(String thumbLargeTnUrl) {
        this.thumbLargeTnUrl = thumbLargeTnUrl;
    }

    public String getThumbLargeTnUrl() {
        return this.thumbLargeTnUrl;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo;
    }

    public String getSiteLogo() {
        return this.siteLogo;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteUrl() {
        return this.siteUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getFromUrl() {
        return this.fromUrl;
    }

    public void setIsBook(String isBook) {
        this.isBook = isBook;
    }

    public String getIsBook() {
        return this.isBook;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setObjUrl(String objUrl) {
        this.objUrl = objUrl;
    }

    public String getObjUrl() {
        return this.objUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getSetId() {
        return this.setId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public void setIsAlbum(String isAlbum) {
        this.isAlbum = isAlbum;
    }

    public String getIsAlbum() {
        return this.isAlbum;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public void setAlbumNum(String albumNum) {
        this.albumNum = albumNum;
    }

    public String getAlbumNum() {
        return this.albumNum;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getIsVip() {
        return this.isVip;
    }

    public void setIsDapei(String isDapei) {
        this.isDapei = isDapei;
    }

    public String getIsDapei() {
        return this.isDapei;
    }

    public void setDressId(String dressId) {
        this.dressId = dressId;
    }

    public String getDressId() {
        return this.dressId;
    }

    public void setDressBuyLink(String dressBuyLink) {
        this.dressBuyLink = dressBuyLink;
    }

    public String getDressBuyLink() {
        return this.dressBuyLink;
    }

    public void setDressPrice(String dressPrice) {
        this.dressPrice = dressPrice;
    }

    public String getDressPrice() {
        return this.dressPrice;
    }

    public void setDressDiscount(String dressDiscount) {
        this.dressDiscount = dressDiscount;
    }

    public String getDressDiscount() {
        return this.dressDiscount;
    }

    public void setDressExtInfo(String dressExtInfo) {
        this.dressExtInfo = dressExtInfo;
    }

    public String getDressExtInfo() {
        return this.dressExtInfo;
    }

    public void setDressTag(String dressTag) {
        this.dressTag = dressTag;
    }

    public String getDressTag() {
        return this.dressTag;
    }

    public void setDressNum(String dressNum) {
        this.dressNum = dressNum;
    }

    public String getDressNum() {
        return this.dressNum;
    }

    public void setObjTag(String objTag) {
        this.objTag = objTag;
    }

    public String getObjTag() {
        return this.objTag;
    }

    public void setDressImgNum(String dressImgNum) {
        this.dressImgNum = dressImgNum;
    }

    public String getDressImgNum() {
        return this.dressImgNum;
    }

    public String getHostName() {
        return this.hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureSign() {
        return this.pictureSign;
    }

    public void setPictureSign(String pictureSign) {
        this.pictureSign = pictureSign;
    }

    public String getDataSrc() {
        return this.dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc;
    }

    public String getContentSign() {
        return this.contentSign;
    }

    public void setContentSign(String contentSign) {
        this.contentSign = contentSign;
    }

    public String getAlbumDi() {
        return this.albumDi;
    }

    public void setAlbumDi(String albumDi) {
        this.albumDi = albumDi;
    }

    public String getCanAlbumId() {
        return this.canAlbumId;
    }

    public void setCanAlbumId(String canAlbumId) {
        this.canAlbumId = canAlbumId;
    }

    public String getAlbumObjNum() {
        return this.albumObjNum;
    }

    public void setAlbumObjNum(String albumObjNum) {
        this.albumObjNum = albumObjNum;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFashion() {
        return this.fashion;
    }    //other

    //createFromCursor
    public static BaiduImageBean cursor2Bean(Cursor cursor) {
        if (cursor == null)
            return null;
        BaiduImageBean bean = new BaiduImageBean();
        bean.setId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.id)));
        bean.setDesc(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.desc)));
        bean.setTags(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.tags)));
        bean.setOwner(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.owner)));
        bean.setFromPageTitle(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.fromPageTitle)));
        bean.setColumn(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.column)));
        bean.setParentTag(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.parentTag)));
        bean.setDate(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.date)));
        bean.setDownloadUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.downloadUrl)));
        bean.setImageUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.imageUrl)));
        bean.setImageWidth(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.imageWidth)));
        bean.setImageHeight(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.imageHeight)));
        bean.setThumbnailUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbnailUrl)));
        bean.setThumbnailWidth(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbnailWidth)));
        bean.setThumbnailHeight(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbnailHeight)));
        bean.setThumbLargeWidth(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeWidth)));
        bean.setThumbLargeHeight(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeHeight)));
        bean.setThumbLargeUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeUrl)));
        bean.setThumbLargeTnWidth(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeTnWidth)));
        bean.setThumbLargeTnHeight(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeTnHeight)));
        bean.setThumbLargeTnUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.thumbLargeTnUrl)));
        bean.setSiteName(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.siteName)));
        bean.setSiteLogo(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.siteLogo)));
        bean.setSiteUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.siteUrl)));
        bean.setFromUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.fromUrl)));
        bean.setIsBook(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.isBook)));
        bean.setBookId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.bookId)));
        bean.setObjUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.objUrl)));
        bean.setShareUrl(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.shareUrl)));
        bean.setSetId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.setId)));
        bean.setAlbumId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.albumId)));
        bean.setIsAlbum(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.isAlbum)));
        bean.setAlbumName(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.albumName)));
        bean.setAlbumNum(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.albumNum)));
        bean.setUserId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.userId)));
        bean.setIsVip(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.isVip)));
        bean.setIsDapei(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.isDapei)));
        bean.setDressId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressId)));
        bean.setDressBuyLink(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressBuyLink)));
        bean.setDressPrice(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressPrice)));
        bean.setDressDiscount(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressDiscount)));
        bean.setDressExtInfo(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressExtInfo)));
        bean.setDressTag(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressTag)));
        bean.setDressNum(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressNum)));
        bean.setObjTag(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.objTag)));
        bean.setDressImgNum(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dressImgNum)));
        bean.setHostName(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.hostName)));
        bean.setPictureId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.pictureId)));
        bean.setPictureSign(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.pictureSign)));
        bean.setDataSrc(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.dataSrc)));
        bean.setContentSign(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.contentSign)));
        bean.setAlbumDi(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.albumDi)));
        bean.setCanAlbumId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.canAlbumId)));
        bean.setAlbumObjNum(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.albumObjNum)));
        bean.setAppId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.appId)));
        bean.setPhotoId(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.photoId)));
        bean.setFromName(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.fromName)));
        bean.setFashion(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.fashion)));
        bean.setTitle(cursor.getString(cursor.getColumnIndex(BaiduImageBeanDao.Columns.title)));
        return bean;
    }

    public void setFashion(String fashion) {
        this.fashion = fashion;
    }    //createFromJSON

    public static BaiduImageBean json2Bean(JSONObject json) throws JSONException {
        if (json == null)
            return null;
        BaiduImageBean bean = new BaiduImageBean();
        bean.setId(json.optString("id"));
        bean.setDesc(json.optString("desc"));
        bean.setTags(json.optString("tags"));
        bean.setOwner(json.optString("owner"));
        bean.setFromPageTitle(json.optString("fromPageTitle"));
        bean.setColumn(json.optString("column"));
        bean.setParentTag(json.optString("parentTag"));
        bean.setDate(json.optString("date"));
        bean.setDownloadUrl(json.optString("downloadUrl"));
        bean.setImageUrl(json.optString("imageUrl"));
        bean.setImageWidth(json.optString("imageWidth"));
        bean.setImageHeight(json.optString("imageHeight"));
        bean.setThumbnailUrl(json.optString("thumbnailUrl"));
        bean.setThumbnailWidth(json.optString("thumbnailWidth"));
        bean.setThumbnailHeight(json.optString("thumbnailHeight"));
        bean.setThumbLargeWidth(json.optString("thumbLargeWidth"));
        bean.setThumbLargeHeight(json.optString("thumbLargeHeight"));
        bean.setThumbLargeUrl(json.optString("thumbLargeUrl"));
        bean.setThumbLargeTnWidth(json.optString("thumbLargeTnWidth"));
        bean.setThumbLargeTnHeight(json.optString("thumbLargeTnHeight"));
        bean.setThumbLargeTnUrl(json.optString("thumbLargeTnUrl"));
        bean.setSiteName(json.optString("siteName"));
        bean.setSiteLogo(json.optString("siteLogo"));
        bean.setSiteUrl(json.optString("siteUrl"));
        bean.setFromUrl(json.optString("fromUrl"));
        bean.setIsBook(json.optString("isBook"));
        bean.setBookId(json.optString("bookId"));
        bean.setObjUrl(json.optString("objUrl"));
        bean.setShareUrl(json.optString("shareUrl"));
        bean.setSetId(json.optString("setId"));
        bean.setAlbumId(json.optString("albumId"));
        bean.setIsAlbum(json.optString("isAlbum"));
        bean.setAlbumName(json.optString("albumName"));
        bean.setAlbumNum(json.optString("albumNum"));
        bean.setUserId(json.optString("userId"));
        bean.setIsVip(json.optString("isVip"));
        bean.setIsDapei(json.optString("isDapei"));
        bean.setDressId(json.optString("dressId"));
        bean.setDressBuyLink(json.optString("dressBuyLink"));
        bean.setDressPrice(json.optString("dressPrice"));
        bean.setDressDiscount(json.optString("dressDiscount"));
        bean.setDressExtInfo(json.optString("dressExtInfo"));
        bean.setDressTag(json.optString("dressTag"));
        bean.setDressNum(json.optString("dressNum"));
        bean.setObjTag(json.optString("objTag"));
        bean.setDressImgNum(json.optString("dressImgNum"));
        bean.setHostName(json.optString("hostName"));
        bean.setPictureId(json.optString("pictureId"));
        bean.setPictureSign(json.optString("pictureSign"));
        bean.setDataSrc(json.optString("dataSrc"));
        bean.setContentSign(json.optString("contentSign"));
        bean.setAlbumDi(json.optString("albumDi"));
        bean.setCanAlbumId(json.optString("canAlbumId"));
        bean.setAlbumObjNum(json.optString("albumObjNum"));
        bean.setAppId(json.optString("appId"));
        bean.setPhotoId(json.optString("photoId"));
        bean.setFromName(json.optString("fromName"));
        bean.setFashion(json.optString("fashion"));
        bean.setTitle(json.optString("title"));
        return bean;
    }

    public String getTitle() {
        return this.title;
    }    //createFromJSONArray

    public static ArrayList<BaiduImageBean> jsonArray2BeanList(JSONArray jsonArray) throws JSONException {

        if (jsonArray == null)
            return null;

        ArrayList<BaiduImageBean> list = new ArrayList<BaiduImageBean>();

        int count = jsonArray.length();
        for (int i = 0; i < count; i++) {
            JSONObject jsonObj = jsonArray.optJSONObject(i);
            BaiduImageBean entity = BaiduImageBean.json2Bean(jsonObj);
            list.add(entity);
        }
        return list;
    }

    public void setTitle(String title) {
        this.title = title;
    }    //buildContentValues

    public static ContentValues bean2CV(BaseBean baseBean) {
        BaiduImageBean bean = new BaiduImageBean();

        if (baseBean != null) {
            bean = (BaiduImageBean) baseBean;
        }
        ContentValues values = new ContentValues();
        values.put(BaiduImageBeanDao.Columns.id, bean.getId());
        values.put(BaiduImageBeanDao.Columns.desc, bean.getDesc());
        values.put(BaiduImageBeanDao.Columns.tags, bean.getTags());
        values.put(BaiduImageBeanDao.Columns.owner, bean.getOwner());
        values.put(BaiduImageBeanDao.Columns.fromPageTitle, bean.getFromPageTitle());
        values.put(BaiduImageBeanDao.Columns.column, bean.getColumn());
        values.put(BaiduImageBeanDao.Columns.parentTag, bean.getParentTag());
        values.put(BaiduImageBeanDao.Columns.date, bean.getDate());
        values.put(BaiduImageBeanDao.Columns.downloadUrl, bean.getDownloadUrl());
        values.put(BaiduImageBeanDao.Columns.imageUrl, bean.getImageUrl());
        values.put(BaiduImageBeanDao.Columns.imageWidth, bean.getImageWidth());
        values.put(BaiduImageBeanDao.Columns.imageHeight, bean.getImageHeight());
        values.put(BaiduImageBeanDao.Columns.thumbnailUrl, bean.getThumbnailUrl());
        values.put(BaiduImageBeanDao.Columns.thumbnailWidth, bean.getThumbnailWidth());
        values.put(BaiduImageBeanDao.Columns.thumbnailHeight, bean.getThumbnailHeight());
        values.put(BaiduImageBeanDao.Columns.thumbLargeWidth, bean.getThumbLargeWidth());
        values.put(BaiduImageBeanDao.Columns.thumbLargeHeight, bean.getThumbLargeHeight());
        values.put(BaiduImageBeanDao.Columns.thumbLargeUrl, bean.getThumbLargeUrl());
        values.put(BaiduImageBeanDao.Columns.thumbLargeTnWidth, bean.getThumbLargeTnWidth());
        values.put(BaiduImageBeanDao.Columns.thumbLargeTnHeight, bean.getThumbLargeTnHeight());
        values.put(BaiduImageBeanDao.Columns.thumbLargeTnUrl, bean.getThumbLargeTnUrl());
        values.put(BaiduImageBeanDao.Columns.siteName, bean.getSiteName());
        values.put(BaiduImageBeanDao.Columns.siteLogo, bean.getSiteLogo());
        values.put(BaiduImageBeanDao.Columns.siteUrl, bean.getSiteUrl());
        values.put(BaiduImageBeanDao.Columns.fromUrl, bean.getFromUrl());
        values.put(BaiduImageBeanDao.Columns.isBook, bean.getIsBook());
        values.put(BaiduImageBeanDao.Columns.bookId, bean.getBookId());
        values.put(BaiduImageBeanDao.Columns.objUrl, bean.getObjUrl());
        values.put(BaiduImageBeanDao.Columns.shareUrl, bean.getShareUrl());
        values.put(BaiduImageBeanDao.Columns.setId, bean.getSetId());
        values.put(BaiduImageBeanDao.Columns.albumId, bean.getAlbumId());
        values.put(BaiduImageBeanDao.Columns.isAlbum, bean.getIsAlbum());
        values.put(BaiduImageBeanDao.Columns.albumName, bean.getAlbumName());
        values.put(BaiduImageBeanDao.Columns.albumNum, bean.getAlbumNum());
        values.put(BaiduImageBeanDao.Columns.userId, bean.getUserId());
        values.put(BaiduImageBeanDao.Columns.isVip, bean.getIsVip());
        values.put(BaiduImageBeanDao.Columns.isDapei, bean.getIsDapei());
        values.put(BaiduImageBeanDao.Columns.dressId, bean.getDressId());
        values.put(BaiduImageBeanDao.Columns.dressBuyLink, bean.getDressBuyLink());
        values.put(BaiduImageBeanDao.Columns.dressPrice, bean.getDressPrice());
        values.put(BaiduImageBeanDao.Columns.dressDiscount, bean.getDressDiscount());
        values.put(BaiduImageBeanDao.Columns.dressExtInfo, bean.getDressExtInfo());
        values.put(BaiduImageBeanDao.Columns.dressTag, bean.getDressTag());
        values.put(BaiduImageBeanDao.Columns.dressNum, bean.getDressNum());
        values.put(BaiduImageBeanDao.Columns.objTag, bean.getObjTag());
        values.put(BaiduImageBeanDao.Columns.dressImgNum, bean.getDressImgNum());
        values.put(BaiduImageBeanDao.Columns.hostName, bean.getHostName());
        values.put(BaiduImageBeanDao.Columns.pictureId, bean.getPictureId());
        values.put(BaiduImageBeanDao.Columns.pictureSign, bean.getPictureSign());
        values.put(BaiduImageBeanDao.Columns.dataSrc, bean.getDataSrc());
        values.put(BaiduImageBeanDao.Columns.contentSign, bean.getContentSign());
        values.put(BaiduImageBeanDao.Columns.albumDi, bean.getAlbumDi());
        values.put(BaiduImageBeanDao.Columns.canAlbumId, bean.getCanAlbumId());
        values.put(BaiduImageBeanDao.Columns.albumObjNum, bean.getAlbumObjNum());
        values.put(BaiduImageBeanDao.Columns.appId, bean.getAppId());
        values.put(BaiduImageBeanDao.Columns.photoId, bean.getPhotoId());
        values.put(BaiduImageBeanDao.Columns.fromName, bean.getFromName());
        values.put(BaiduImageBeanDao.Columns.fashion, bean.getFashion());
        values.put(BaiduImageBeanDao.Columns.title, bean.getTitle());
        return values;
    }

}