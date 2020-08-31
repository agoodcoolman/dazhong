package com.model.sankuai.jarvis;
/* compiled from: IJarvis */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public interface a {
    Thread a(String str, Runnable runnable);

    Executor a();

    ExecutorService a(String str, ThreadFactory threadFactory);

    ScheduledExecutorService a(String str, int i, ThreadFactory threadFactory);

    ThreadPoolExecutor a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler);

    Executor b();

    ScheduledExecutorService b(String str, ThreadFactory threadFactory);
}
