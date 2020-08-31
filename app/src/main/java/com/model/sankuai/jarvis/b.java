package com.model.sankuai.jarvis;
/* compiled from: Jarvis */
import android.os.AsyncTask;
import android.text.TextUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class b {
    private static volatile com.model.sankuai.jarvis.a b;



    public static void a(com.model.sankuai.jarvis.a aVar) {
        b = aVar;
    }

    public static Executor a() {
        Object[] objArr = new Object[0];

        if (b == null) {
            return AsyncTask.THREAD_POOL_EXECUTOR;
        }
        return b.a();
    }

    public static Executor b() {
        Object[] objArr = new Object[0];

        if (b == null) {
            return AsyncTask.SERIAL_EXECUTOR;
        }
        return b.b();
    }

    public static Thread a(String str, Runnable runnable) {
        Object[] objArr = {str, runnable};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (runnable == null) {
            throw new IllegalArgumentException("thread task must not be null");
        } else if (b == null) {
            return new Thread(runnable, str);
        } else {
            return b.a(str, runnable);
        }
    }

    public static ExecutorService a(String str) {
        Object[] objArr = {str};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return Executors.newSingleThreadExecutor(new a(str));
        } else {
            return b.a(str, (ThreadFactory) null);
        }
    }

    public static ExecutorService a(String str, ThreadFactory threadFactory) {
        Object[] objArr = {str, threadFactory};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return Executors.newSingleThreadExecutor(threadFactory);
        } else {
            return b.a(str, threadFactory);
        }
    }

    public static ExecutorService a(String str, int i) {
        Object[] objArr = {str, new Integer(i)};

        return a(str, i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService b(String str) {
        Object[] objArr = {str};

        return a(str, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService b(String str, ThreadFactory threadFactory) {
        Object[] objArr = {str, threadFactory};

        return a(str, 0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService c(String str) {
        Object[] objArr = {str};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return Executors.newSingleThreadScheduledExecutor(new a(str));
        } else {
            return b.b(str, (ThreadFactory) null);
        }
    }

    public static ScheduledExecutorService b(String str, int i) {
        Object[] objArr = {str, new Integer(i)};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return Executors.newScheduledThreadPool(i, new a(str));
        } else {
            return b.a(str, i, (ThreadFactory) null);
        }
    }

    public static ScheduledExecutorService a(String str, int i, ThreadFactory threadFactory) {
        Object[] objArr = {str, new Integer(i), threadFactory};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return Executors.newScheduledThreadPool(i, threadFactory);
        } else {
            return b.a(str, i, threadFactory);
        }
    }

    public static ThreadPoolExecutor a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        String str2 = str;
        Object[] objArr = {str2, new Integer(i), new Integer(i2), new Long(j), timeUnit, blockingQueue};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b != null) {
            return b.a(str, i, i2, j, timeUnit, blockingQueue, (ThreadFactory) null, (RejectedExecutionHandler) null);
        } else {
            return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, new a(str2));
        }
    }

    public static ThreadPoolExecutor a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        Object[] objArr = {str, new Integer(i), new Integer(i2), new Long(j), timeUnit, blockingQueue, threadFactory};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, threadFactory);
        } else {
            return b.a(str, i, i2, j, timeUnit, blockingQueue, threadFactory, (RejectedExecutionHandler) null);
        }
    }

    public static ThreadPoolExecutor a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        Object[] objArr = {str, new Integer(i), new Integer(i2), new Long(j), timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler};

        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("thread name must not be null");
        } else if (b == null) {
            return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        } else {
            return b.a(str, i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }
    }

    /* compiled from: Jarvis */
    static class a extends AtomicInteger implements ThreadFactory {

        public String b;

        public a(String str) {
            Object[] objArr = {str};
            this.b = str;

        }

        public Thread newThread(Runnable runnable) {
            Object[] objArr = {runnable};

            Thread thread = new Thread(runnable, this.b + "#" + getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }
}
