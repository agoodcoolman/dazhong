package com.model.dianping.paladin;

import android.app.Application;
import android.content.Context;
import android.os.Process;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PaladinManager {

//    private static a k;
    private Context b;
    private volatile boolean c;
    private boolean d;
    private ExecutorService e;
    private ConcurrentLinkedQueue<String> f;
    private ScheduledExecutorService g;
    private double h;
    private boolean i;
    private int j;

//    private static final class a {
//        /* access modifiers changed from: private */
//        public static final PaladinManager a = new PaladinManager();
//    }
//
//    public static PaladinManager a() {
//        Object[] objArr = new Object[0];
//
//        return a.a;
//    }
//
//    public PaladinManager() {
//        Object[] objArr = new Object[0];
//
//        this.h = 1.0d;
//        this.i = true;
//        this.j = 1000;
//    }
//
//    public void a(Context context, boolean z) {
//        Object[] objArr = {context, new Byte(z ? (byte) 1 : 0)};
//        if (context != null && !this.c) {
//            this.c = true;
//            this.b = context.getApplicationContext();
//            this.d = z;
//            Babel.init(context);
//            Horn.init(context);
//            Horn.register("paladin_horn_code_detector", new d());
//            if (this.f == null) {
//                this.f = new ConcurrentLinkedQueue<>();
//            }
//            if (k == null) {
//                k = PaladinFilter.a();
//            }
//            if (this.e == null) {
//                this.e = b.a("Paladin-Code");
//            }
//            if (!g.a(context)) {
//                this.g = b.c("Paladin-schedule");
//                this.g.scheduleAtFixedRate(new Runnable() {
//
//                    public void run() {
//                        Object[] objArr = new Object[0];
//
//                        Process.setThreadPriority(10);
//                        PaladinManager.this.b();
//                    }
//                }, 2, 2, TimeUnit.MINUTES);
//            } else if (context.getApplicationContext() instanceof Application) {
//                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new e());
//            }
//        }
//    }
//
//    @Keep
//    public static void setFilter(a aVar) {
//        if (aVar != null) {
//            k = aVar;
//        }
//    }
//
//    public void a(String str) {
//        Object[] objArr = {str};
//        ChangeQuickRedirect changeQuickRedirect = a;
//        if (PatchProxy.isSupport(objArr, this, changeQuickRedirect, false, "f3aad2193495ff05642b2b45a302767c", 4611686018427387904L)) {
//            PatchProxy.accessDispatch(objArr, this, changeQuickRedirect, false, "f3aad2193495ff05642b2b45a302767c");
//            return;
//        }
//        try {
//            if (this.i) {
//                if (this.f == null) {
//                    this.f = new ConcurrentLinkedQueue<>();
//                }
//                this.f.add(str);
//                if (this.f.size() >= this.j) {
//                    b();
//                }
//            }
//        } catch (Throwable th) {
//            com.dianping.v1.b.a(th);
//        }
//    }
//
//    public void a(int i2) {
//        Object[] objArr = {new Integer(i2)};
//        ChangeQuickRedirect changeQuickRedirect = a;
//        if (PatchProxy.isSupport(objArr, this, changeQuickRedirect, false, "9d4accc6e17e38e7778359b19bde9874", 4611686018427387904L)) {
//            PatchProxy.accessDispatch(objArr, this, changeQuickRedirect, false, "9d4accc6e17e38e7778359b19bde9874");
//            return;
//        }
//        try {
//            if (this.i) {
//                if (!k.isHit(i2)) {
//                    if (this.d) {
//                        g.b("[PaladinReport] resourceReportedFilter not contain, report..." + i2);
//                    }
//                    k.add(i2);
//                    a(String.valueOf(i2));
//                } else if (this.d) {
//                    g.b("[PaladinReport] resourceReportedFilter contained, return..." + i2);
//                }
//            }
//        } catch (Throwable th) {
//            com.dianping.v1.b.a(th);
//        }
//    }
//
//    public void b() {
//        Object[] objArr = new Object[0];
//        ChangeQuickRedirect changeQuickRedirect = a;
//        if (PatchProxy.isSupport(objArr, this, changeQuickRedirect, false, "d74e650d4d88fafd1224b771a6ca67e5", 4611686018427387904L)) {
//            PatchProxy.accessDispatch(objArr, this, changeQuickRedirect, false, "d74e650d4d88fafd1224b771a6ca67e5");
//            return;
//        }
//        ConcurrentLinkedQueue<String> concurrentLinkedQueue = this.f;
//        if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0 && this.b != null) {
//            ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
//            concurrentLinkedQueue2.addAll(this.f);
//            this.f.clear();
//            if (this.e == null) {
//                this.e = b.a("Paladin-Code");
//            }
//            this.e.execute(new f(this.b, concurrentLinkedQueue2));
//        }
//    }
//
//    public void a(c cVar) {
//        ScheduledExecutorService scheduledExecutorService;
//        Object[] objArr = {cVar};
//        ChangeQuickRedirect changeQuickRedirect = a;
//        if (PatchProxy.isSupport(objArr, this, changeQuickRedirect, false, "24904b6e256445f6d397b53dc09cd04f", 4611686018427387904L)) {
//            PatchProxy.accessDispatch(objArr, this, changeQuickRedirect, false, "24904b6e256445f6d397b53dc09cd04f");
//        } else if (cVar != null) {
//            if (this.d) {
//                g.b("execute PaladinManager.hornCallBack:" + cVar.toString());
//            }
//            this.i = cVar.a();
//            if (cVar.d() >= 200) {
//                this.j = cVar.d();
//            }
//            if (!cVar.a()) {
//                ScheduledExecutorService scheduledExecutorService2 = this.g;
//                if (scheduledExecutorService2 != null) {
//                    scheduledExecutorService2.shutdown();
//                    return;
//                }
//                return;
//            }
//            if (cVar.c() && (scheduledExecutorService = this.g) != null) {
//                scheduledExecutorService.shutdown();
//            }
//            this.h = cVar.b();
//        }
//    }

    public boolean c() {
        return this.d;
    }

    public double d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }
}
