package com.model.dianping.paladin;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* compiled from: PaladinUtil */
public class g {

    private static String b;
    private static String c;
    private static Boolean d;

    public static byte[] a(String str, String str2) {
        Object[] objArr = {str, str2};

        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (IOException e) {

        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(String str) {
        Object[] objArr = {str};
        return a(str, "UTF-8");
    }

    public static boolean a(Context context) {
        boolean z = true;
        Object[] objArr = {context};

        if (d == null) {
            b(context);
            c(context);
            String str = c;
            if (str != null && !str.equalsIgnoreCase(b)) {
                z = false;
            }
            d = Boolean.valueOf(z);
        }
        return d.booleanValue();
    }

    private static String b(Context context) {
        Object[] objArr = {context};

        if (TextUtils.isEmpty(b)) {
            b = context.getPackageName();
        }
        return b;
    }

    private static String c(Context context) {
        Object[] objArr = {context};

        if (TextUtils.isEmpty(c)) {
            c = d(context);
        }
        return c;
    }

    private static String d(Context context) {
        Object[] objArr = {context};

        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = b();
        }
        return TextUtils.isEmpty(a2) ? e(context) : a2;
    }

    private static String a() {
        Object[] objArr = new Object[0];

        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
                Method declaredMethod2 = cls.getDeclaredMethod("getProcessName", new Class[0]);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(invoke, new Object[0]);
            } catch (Throwable th) {

                th.printStackTrace();
            }
        }
        return null;
    }

    private static String e(Context context) {
        Object[] objArr = {context};

        try {

            int myPid = android.os.Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == myPid) {
                        return next.processName;
                    }
                }
            }
        } catch (Throwable th) {

            th.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076 A[SYNTHETIC, Splitter:B:22:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[SYNTHETIC, Splitter:B:29:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b() {
        /*
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.meituan.robust.ChangeQuickRedirect r8 = a
            java.lang.String r9 = "b1b29041156220342af73a17a8bcb59d"
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            r2 = 0
            r4 = 1
            r1 = r0
            r3 = r8
            r5 = r9
            boolean r1 = com.meituan.robust.PatchProxy.isSupport(r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x001c
            r1 = 1
            java.lang.Object r0 = com.meituan.robust.PatchProxy.accessDispatch(r0, r2, r8, r1, r9)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L_0x001c:
            java.io.File r0 = new java.io.File     // Catch:{ Throwable -> 0x006d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006d }
            r1.<init>()     // Catch:{ Throwable -> 0x006d }
            java.lang.String r3 = "/proc/"
            r1.append(r3)     // Catch:{ Throwable -> 0x006d }
            int r3 = android.os.Process.myPid()     // Catch:{ Throwable -> 0x006d }
            r1.append(r3)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r3 = "/cmdline"
            r1.append(r3)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x006d }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x006d }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x006d }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Throwable -> 0x006d }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x006d }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x006d }
            java.lang.String r0 = r1.readLine()     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            java.lang.String r2 = "[^0-9a-zA-Z.-_+:]+"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replaceAll(r2, r3)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            r1.close()     // Catch:{ Throwable -> 0x005d }
            goto L_0x0064
        L_0x005d:
            r1 = move-exception
            com.dianping.v1.b.a(r1)
            r1.printStackTrace()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            r2 = r1
            goto L_0x0084
        L_0x0068:
            r0 = move-exception
            r2 = r1
            goto L_0x006e
        L_0x006b:
            r0 = move-exception
            goto L_0x0084
        L_0x006d:
            r0 = move-exception
        L_0x006e:
            com.dianping.v1.b.a(r0)     // Catch:{ all -> 0x006b }
            r0.printStackTrace()     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Throwable -> 0x007a }
            goto L_0x0081
        L_0x007a:
            r0 = move-exception
            com.dianping.v1.b.a(r0)
            r0.printStackTrace()
        L_0x0081:
            java.lang.String r0 = ""
            return r0
        L_0x0084:
            com.dianping.v1.b.a(r0)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ Throwable -> 0x008d }
            goto L_0x0094
        L_0x008d:
            r1 = move-exception
            com.dianping.v1.b.a(r1)
            r1.printStackTrace()
        L_0x0094:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meituan.android.paladin.g.b():java.lang.String");
    }

    public static void b(String str) {
        int i = 0;
        Object[] objArr = {str};
        if (str.length() > 4000) {
            int length = str.length() / 4000;
            while (i <= length) {
                int i2 = i + 1;
                int i3 = i2 * 4000;
                if (i3 >= str.length()) {
                    Log.v("PaladinLogger", "chunk " + i + " of " + length + ":" + str.substring(i * 4000));
                } else {
                    Log.v("PaladinLogger", "chunk " + i + " of " + length + ":" + str.substring(i * 4000, i3));
                }
                i = i2;
            }
        } else {
            Log.v("PaladinLogger", str);
        }
    }
}
