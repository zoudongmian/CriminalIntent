package android.com.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Administrator on 2017/7/11.
 */

public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay()
                .getSize(size);
        return getScaledBitMap(path,size.x,size.y);
    }
    public static Bitmap getScaledBitMap(String path,int destWidth,int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);
        float scrWidth = options.outWidth;
        float scrHeight = options.outHeight;

        int inSampleSize = 1;
        if (scrHeight > destHeight || scrWidth > destHeight){
            if (scrWidth  > scrHeight){
                inSampleSize = Math.round(scrHeight/destHeight);
            }else {
                inSampleSize = Math.round(scrWidth/destWidth);
            }
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(path,options);
    }
}
