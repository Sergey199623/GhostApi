package sv.ghostapiposts.utils;

import android.content.Context;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import tk.ursusexmachina.ghosapiposts.R;

public class TimeAgo {

    public static long getDuration(String string_date){

//                                                           2019-10-29T10:39:49.000+00:00
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss.S+hh:mm");
        try {
            Date d = f.parse(string_date);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("DEVS",e.getMessage());
            return 0;
        }
    }

    public static String getTimeAgo(Context ctx, String string_date) {
        Date now = new Date();
        long duration = getDuration(string_date);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - duration);
        long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - duration);
        long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - duration);

        if (minutes == 1) {
            return ctx.getString(R.string.post_ago_1);
        } else if (minutes > 1 && minutes < 60) {
            return ctx.getString(R.string.post_ago_2,minutes);
        } else if (hours == 1) {
            return ctx.getString(R.string.post_ago_3);
        } else if (hours > 1 && hours < 24) {
            return ctx.getString(R.string.post_ago_4,hours);
        } else if (days == 1) {
            return ctx.getString(R.string.post_ago_5);
        } else {
            return ctx.getString(R.string.post_ago_6,days);
        }

    }

}
