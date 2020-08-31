package com.model.dianping.paladin;


import android.content.Context;
import android.os.Process;
import android.util.Base64;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
/* compiled from: PaladinTask */
public class f implements Runnable {

    private Context b;
    private ConcurrentLinkedQueue<String> c;

    public f(Context context, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        Object[] objArr = {context, concurrentLinkedQueue};

        this.b = context;
        this.c = concurrentLinkedQueue;
    }

    public void run() {
        Object[] objArr = new Object[0];

        Process.setThreadPriority(10);
        if (PaladinManager.a().c()) {
            g.b("start execute task. isMainProcess:" + g.a(this.b) + ", classNameList size:" + this.c.size());
        }
        try {
            if (g.a(this.b)) {
                a();
            }
        } catch (Throwable th) {

        }
    }

    private void a() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        Object[] objArr = new Object[0];
        if (PaladinManager.a().e() && new Random().nextDouble() <= PaladinManager.a().d() && g.a(this.b) && (concurrentLinkedQueue = this.c) != null && concurrentLinkedQueue.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.c.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(next);
            }
            if (PaladinManager.a().c()) {
                g.b("[PaladinTask.report] origin log: " + sb.toString());
            }
            byte[] a2 = g.a(sb.toString());
            if (a2 != null) {
                String encodeToString = Base64.encodeToString(a2, 2);
                if (PaladinManager.a().c()) {
                    g.b("[PaladinTask.report] compress log: " + encodeToString);
                }
//                Babel.logRT("paladin_babel_code_detector", encodeToString);
            }
        }
    }
}

