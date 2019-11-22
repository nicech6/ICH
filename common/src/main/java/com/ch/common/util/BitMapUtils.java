package com.ch.common.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;

import com.kuxue.common.common.Constants;
import com.kuxue.common.utils.ScreenUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by :xixim
 * date:2019/8/19.
 * describe:bitmap处理
 */
public final class BitMapUtils {
    /**
     * 按照屏幕尺寸放大缩小bitmap。并且对中心点按照屏幕尺寸裁剪
     * @param context
     * @param bitmap
     * @return
     */
    public static Bitmap doMatrix(Context context, Bitmap bitmap){
        float scaleWidth = ((float) ScreenUtil.getScreenWidth(context)) / bitmap.getWidth();
        float scaleHeight = ((float) ScreenUtil.getScreenHeight(context)) / bitmap.getHeight();
        // 取得想要缩放的matrix参数.
        Matrix matrix = new Matrix();
        //以縮放比大的为主,图片不会被压缩.不然一边会不足,取得想要缩放的matrix参数.
        matrix.postScale(scaleHeight>scaleWidth?scaleHeight:scaleWidth,scaleHeight>scaleWidth?scaleHeight:scaleWidth);
        // 得到新的图片.
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return toCenter(context,newbm.getWidth(),newbm.getHeight(),newbm);
    }
    public static Bitmap toCenter(Context context, int width, int height, Bitmap bitmap2){
        //设置显示图片的中心区域
        BitmapRegionDecoder bitmapRegionDecoder = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, baos);
            InputStream isBm = new ByteArrayInputStream(baos.toByteArray());
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(isBm, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect( 0+(width-ScreenUtil.getScreenWidth(context))/2,
                0+(height-ScreenUtil.getScreenHeight(context))/2,
                width-(width-ScreenUtil.getScreenWidth(context))/2,
                height-(height-ScreenUtil.getScreenHeight(context))/2), options);
        return bitmap;
    }
    public static Bitmap doMatrixByWidth(Context context, Bitmap bitmap){
        float scaleWidth = ((float) ScreenUtil.getScreenWidth(context)) / bitmap.getWidth();
        // 取得想要缩放的matrix参数.
        Matrix matrix = new Matrix();
        //以縮放比大的为主,图片不会被压缩.不然一边会不足,取得想要缩放的matrix参数.
        matrix.postScale(scaleWidth,scaleWidth);
        // 得到新的图片.
        Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return newbm;
    }
    /**
     * 保存图片 自定义文件夹
     *
     * @param context 上下文
     * @param bitName 文件名字
     * @param dirName 文件夹文字
     * @param bitmap  位图
     * @param quality 权重
     */
    public static File saveMyBitmap(Context context, String bitName, String dirName, Bitmap bitmap, int quality) {
        if (bitmap == null) return null;
        String filePath = Constants.SP_PIC_PATH;
        if (TextUtils.isEmpty(filePath)) return null;
        File Dfile = new File(filePath + dirName + "/");// sxzqudao
        if (!Dfile.exists()) {
            boolean b = Dfile.mkdir();
        }
        File f = new File(filePath + dirName + "/", bitName + ".png");
        FileOutputStream fOut = null;
        try {
            f.createNewFile();
            fOut = new FileOutputStream(f, false);
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, fOut);

            fOut.flush();
            fOut.close();
            //通知相册刷新
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(f)));
            return f;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
