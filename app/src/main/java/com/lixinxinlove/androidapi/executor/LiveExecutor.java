package com.lixinxinlove.androidapi.executor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LiveExecutor {
    private final static ScheduledThreadPoolExecutor POOL;
    private static final String TAG = "LiveExecutor";
    private static ScheduledFuture scheduledFuture = null;


    private static final Handler handler = new Handler(Looper.getMainLooper());

    static {
        POOL = new ScheduledThreadPoolExecutor(1);
        POOL.setKeepAliveTime(60, TimeUnit.SECONDS);
    }

    private LiveExecutor() {
    }

    public static void start() {
        try {
            Log.e(TAG, "start");
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                scheduledFuture = null;
            }
            scheduledFuture = POOL.scheduleAtFixedRate(() -> {
                Log.e(TAG, "schedule");
            }, 10, 10, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execute(Runnable command) {
        POOL.execute(command);
    }

    public static ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return POOL.schedule(command, delay, unit);
    }


}
