package com.model.dianping.paladin;

import android.content.Context;
public class b {


    public static void a(Context context) {
        Object[] objArr = {context};

        try {
            a(context, false);
        } catch (Throwable th) {

        }
    }

    public static void a(Context context, boolean z) {
        Object[] objArr = {context, new Byte(z ? (byte) 1 : 0)};

        try {
            PaladinManager.a().a(context, z);
        } catch (Throwable th) {

        }
    }

    public static void a(String str) {
        Object[] objArr = {str};

        try {
            PaladinManager.a().a(str);
        } catch (Throwable th) {

        }
    }

    public static int a(int i) {
        Object[] objArr = {new Integer(i)};

        try {
            PaladinManager.a().a(i);
        } catch (Throwable th) {

        }
        return i;
    }

    public static String b(String str) {
        Object[] objArr = {str};

        try {
            if (str.startsWith("SourcePic/")) {
                return str;
            }
            PaladinManager.a().a(str.endsWith(".so") ? str.substring(str.lastIndexOf("/") + 4, str.length() - 3) : str);
            return str;
        } catch (Throwable th) {
           return "";
        }
    }
}
