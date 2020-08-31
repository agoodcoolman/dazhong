package com.model.dianping;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Iterator;
import java.util.Map;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import androidx.annotation.NonNull;
import com.model.dianping.libutil;
import com.model.dianping.c;

public class DPObject implements Parcelable, Iterable<Map.Entry<Integer, Object>> {
    public static final Parcelable.Creator<DPObject> CREATOR = new Parcelable.Creator<DPObject>() {
        /* renamed from: a */
        public DPObject createFromParcel(Parcel parcel) {
            return new DPObject(parcel);
        }

        /* renamed from: a */
        public DPObject[] newArray(int i) {
            return new DPObject[i];
        }
    };
    /* access modifiers changed from: private */
    public static final boolean a;
    /* access modifiers changed from: private */
    public byte[] b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f2193c;
    /* access modifiers changed from: private */
    public int d;

    public interface e {
        e a(String str, int[] iArr);

        e a(String str, long[] jArr);

        e a(String str, String[] strArr);

        DPObject a();

        e b(int i);

        e b(int i, double d);

        e b(int i, int i2);

        e b(int i, DPObject dPObject);

        e b(int i, String str);

        e b(int i, boolean z);

        e b(int i, DPObject[] dPObjectArr);

        e b(String str);

        e b(String str, double d);

        e b(String str, int i);

        e b(String str, DPObject dPObject);

        e b(String str, String str2);

        e b(String str, boolean z);

        e b(String str, DPObject[] dPObjectArr);

        e c(int i, long j);

        e c(String str, long j);

        e d(int i, long j);

        e d(String str, long j);
    }

    private static native boolean a();

    private static native boolean nativeArraySkip(byte[] bArr, int i, int i2, int i3, int[] iArr);

    private static native int nativeSeekMember(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: private */
    public static native int nativeSkipAny(byte[] bArr, int i, int i2);

    public int describeContents() {
        return 0;
    }

    static {
        boolean z;
//        com.meituan.android.paladin.b.a("9aec1d254346bd8f2d7db40471b4fa2d");
        try {
            if (!libutil.a("dpobj", DPObject.class)) {
                // 如果读取失败了，在用这个默认的读取。
//                System.loadLibrary(com.meituan.android.paladin.b.b("dpobj"));
            }
            z = a();
        } catch (Throwable th) {

            z = false;
        }
        a = z;
    }

    public DPObject(byte[] bArr, int i, int i2) {
        this.b = bArr;
        this.f2193c = i;
        this.d = i2;
    }

    public boolean b() {
        return this.d >= 0 && this.f2193c >= 0 && this.b != null;
    }

    public DPObject(int i) {
        this.b = new byte[]{79, (byte) (i >>> 8), (byte) i, 90};
        this.f2193c = 0;
        this.d = 4;
    }

    public DPObject(String str) {
        this(a(str));
    }

    public DPObject() {
        this.b = new byte[0];
        this.f2193c = 0;
        this.d = 0;
    }

    protected DPObject(Parcel parcel) {
        this.f2193c = parcel.readInt();
        this.d = parcel.readInt();
        this.b = parcel.createByteArray();
    }

    public static int a(String str) {
        int hashCode = str.hashCode();
        return (hashCode >>> 16) ^ (65535 & hashCode);
    }

    public static DPObject a(byte[] bArr, int i, int i2) {
        if (i2 >= 4 && bArr[i] == 79) {
            return new DPObject(bArr, i, i2);
        }
        return null;
    }

    public static DPObject[] b(byte[] bArr, int i, int i2) {
        if (i2 >= 3 && bArr[i] == 65) {
            int i3 = ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255);
            int i4 = 0;
            if (i3 == 0) {
                return new DPObject[0];
            }
            if (a) {
                int i5 = i + 3;
                int[] iArr = new int[i3];
                if (nativeArraySkip(bArr, i5, i2 - 3, i3, iArr)) {
                    DPObject[] dPObjectArr = new DPObject[i3];
                    while (i4 < i3) {
                        int i6 = iArr[i4];
                        byte b2 = bArr[i5];
                        if (b2 == 78) {
                            dPObjectArr[i4] = null;
                        } else if (b2 != 79) {
                            return null;
                        } else {
                            dPObjectArr[i4] = new DPObject(bArr, i5, i6);
                        }
                        i5 += i6;
                        i4++;
                    }
                    return dPObjectArr;
                }
            } else {
                ByteBuffer wrap = ByteBuffer.wrap(bArr, i + 3, i2 - 3);
                DPObject[] dPObjectArr2 = new DPObject[i3];
                int position = wrap.position();
                while (i4 < i3) {
                    if (b(wrap) != 0) {
                        return null;
                    }
                    switch (bArr[position]) {
                        case 78:
                            dPObjectArr2[i4] = null;
                            break;
                        case 79:
                            dPObjectArr2[i4] = new DPObject(bArr, position, wrap.position() - position);
                            break;
                        default:
                            return null;
                    }
                    position = wrap.position();
                    i4++;
                }
                return dPObjectArr2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static int b(ByteBuffer byteBuffer) {
        int i;
        short s;
        if (byteBuffer.remaining() == 0) {
            return -1;
        }
        switch (byteBuffer.get()) {
            case 65 /*65*/:
                if (byteBuffer.remaining() < 2) {
                    return -1;
                }
                short s2 = (short)(byteBuffer.getShort() & 65535);
                for (int i2 = 0; i2 < s2; i2++) {
                    int b2 = b(byteBuffer);
                    if (b2 != 0) {
                        return b2;
                    }
                }
                return 0;
            case 66:
                if (byteBuffer.remaining() < 4 || byteBuffer.remaining() < (i = byteBuffer.getInt())) {
                    return -1;
                }
                byteBuffer.position(byteBuffer.position() + i);
                return 0;
            case 68 /*68*/:
                if (byteBuffer.remaining() < 8) {
                    return -1;
                }
                byteBuffer.getDouble();
                return 0;
            case 70:
            case 78:
            case 84:
                return 0;
            case 73:
                if (byteBuffer.remaining() < 4) {
                    return -1;
                }
                byteBuffer.getInt();
                return 0;
            case 76:
                if (byteBuffer.remaining() < 8) {
                    return -1;
                }
                byteBuffer.getLong();
                return 0;
            case 79:
                if (byteBuffer.remaining() < 2) {
                    return -1;
                }
                byteBuffer.getShort();
                while (byteBuffer.remaining() > 0) {
                    byte b3 = byteBuffer.get();
                    if (b3 != 77) {
                        return b3 == 90 ? 0 : -2;
                    }
                    if (byteBuffer.remaining() < 2) {
                        return -1;
                    }
                    byteBuffer.getShort();
                    int b4 = b(byteBuffer);
                    if (b4 != 0) {
                        return b4;
                    }
                }
                return -1;
            case 83 /*83*/:
                if (byteBuffer.remaining() < 2 || byteBuffer.remaining() < (s = (short)(byteBuffer.getShort() & 65535))) {
                    return -1;
                }
                byteBuffer.position(byteBuffer.position() + s);
                return 0;
            case 85:
                if (byteBuffer.remaining() < 4) {
                    return -1;
                }
                byteBuffer.getInt();
                return 0;
            case 88:
                if (byteBuffer.remaining() < 8) {
                    return -1;
                }
                byteBuffer.getLong();
                return 0;
            default:
                return -2;
        }
    }

    private static int a(ByteBuffer byteBuffer, int i) {
        if (byteBuffer.remaining() < 4) {
            return -1;
        }
        byteBuffer.position(byteBuffer.position() + 3);
        while (byteBuffer.remaining() != 0) {
            byte b2 = byteBuffer.get();
            if (b2 != 77) {
                if (b2 != 90) {
                    return -2;
                }
                return -1;
            } else if (byteBuffer.remaining() < 3) {
                return -1;
            } else {
                if ((byteBuffer.getShort() & 65535) == i) {
                    return 0;
                }
                int b3 = b(byteBuffer);
                if (b3 != 0) {
                    return b3;
                }
            }
        }
        return -1;
    }

    public static <T> T[] a(DPObject[] dPObjectArr, com.model.c<T> cVar) throws com.model.dianping.a {
        T[] createArray = cVar.createArray(dPObjectArr.length);
        for (int i = 0; i < dPObjectArr.length; i++) {
            createArray[i] = dPObjectArr[i].a(cVar);
        }
        return createArray;
    }

    public boolean a(int i) {
        if (this.d > 0) {
            byte[] bArr = this.b;
            int i2 = this.f2193c;
            if (bArr[i2] == 79) {
                if (((bArr[i2 + 2] & 255) | ((bArr[i2 + 1] & 255) << 8)) == i) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean b(String str) {
        return a(a(str));
    }

    public <T> T a(com.model.c<T> cVar) throws com.model.dianping.a {
        return new com.model.dianping.e(ByteBuffer.wrap(this.b, this.f2193c, this.d)).a(cVar);
    }

    public e c() {
        return new c();
    }

    public boolean b(int i) {
        if (!a) {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0) {
                return true;
            }
            return false;
        } else if (nativeSeekMember(this.b, this.f2193c, this.d, i) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean c(String str) {
        return b(a(str));
    }

    public byte c(int i) {
        byte b2;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            b2 = (nativeSeekMember <= 0 || nativeSeekMember >= this.d) ? 0 : this.b[this.f2193c + nativeSeekMember];
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            b2 = (a(wrap, i) != 0 || wrap.remaining() <= 0) ? 0 : wrap.get();
        }
        if (b2 == 73) {
            return 73;
        }
        if (b2 == 83) {
            return 83;
        }
        if (b2 == 84 || b2 == 70) {
            return 66;
        }
        if (b2 == 68) {
            return 68;
        }
        if (b2 == 76) {
            return 76;
        }
        if (b2 == 85) {
            return 85;
        }
        if (b2 == 78) {
            return 78;
        }
        if (b2 == 79) {
            return 79;
        }
        if (b2 == 65) {
            return 65;
        }
        if (b2 == 66) {
            return 83;
        }
        if (b2 == 88) {
            return 85;
        }
        return 0;
    }

    public boolean d(int i) {
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember > 0 && nativeSeekMember < this.d) {
                byte b2 = this.b[this.f2193c + nativeSeekMember];
                if (b2 == 84) {
                    return true;
                }
                if (b2 == 70) {
                    return false;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0 && wrap.remaining() > 0 && wrap.get() == 84) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean d(String str) {
        return d(a(str));
    }

    public int e(int i) {
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember <= 0 || nativeSeekMember + 4 >= this.d) {
                return 0;
            }
            int i2 = this.f2193c + nativeSeekMember;
            byte[] bArr = this.b;
            if (bArr[i2] != 73) {
                return 0;
            }
            return (bArr[i2 + 4] & 255) | ((bArr[i2 + 1] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 8);
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
        wrap.order(ByteOrder.BIG_ENDIAN);
        if (a(wrap, i) == 0 && wrap.remaining() > 4 && wrap.get() == 73) {
            return wrap.getInt();
        }
        return 0;
    }

    public int e(String str) {
        return e(a(str));
    }

    public String f(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember > 0 && nativeSeekMember < (i2 = this.d)) {
                int i6 = this.f2193c + nativeSeekMember;
                byte[] bArr = this.b;
                byte b2 = bArr[i6];
                if (b2 == 83 && (i5 = nativeSeekMember + 2) < i2) {
                    byte b3 = (byte) (((bArr[i6 + 1] & 255) << 8) | (bArr[i6 + 2] & 255));
                    if (b3 == 0) {
                        return "";
                    }
                    if (i5 + b3 < i2) {
                        try {
                            return new String(bArr, i6 + 3, b3, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {

                        }
                    }
                } else if (b2 == 66 && (i3 = nativeSeekMember + 4) < (i4 = this.d)) {
                    byte[] bArr2 = this.b;
                    byte b4 = (byte)(((bArr2[i6 + 1] & 255) << 24) | ((bArr2[i6 + 2] & 255) << 16) | ((bArr2[i6 + 3] & 255) << 8) | (bArr2[i6 + 4] & 255));
                    if (b4 == 0) {
                        return "";
                    }
                    if (i3 + b4 < i4) {
                        try {
                            return new String(bArr2, i6 + 5, b4, "UTF-8");
                        } catch (UnsupportedEncodingException e3) {

                        }
                    }
                } else if (b2 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0 && wrap.remaining() > 0) {
                byte b5 = wrap.get();
                if (b5 == 83 && wrap.remaining() > 1) {
                    short s = (short)(wrap.getShort() & 65535);
                    if (s == 0) {
                        return "";
                    }
                    if (wrap.remaining() >= s) {
                        try {
                            return new String(this.b, wrap.position(), s, "UTF-8");
                        } catch (UnsupportedEncodingException e4) {

                            Log.e("dpobj", "unable to decode string", e4);
                        }
                    }
                } else if (b5 == 66 && wrap.remaining() > 3) {
                    int i7 = wrap.getInt();
                    if (i7 == 0) {
                        return "";
                    }
                    if (wrap.remaining() >= i7) {
                        try {
                            return new String(this.b, wrap.position(), i7, "UTF-8");
                        } catch (UnsupportedEncodingException e5) {

                            Log.e("dpobj", "unable to decode string", e5);
                        }
                    }
                } else if (b5 == 78) {
                    return null;
                }
            }
        }
        return null;
    }

    public String f(String str) {
        return f(a(str));
    }

    public long g(int i) {
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember <= 0 || nativeSeekMember + 8 >= this.d) {
                return 0;
            }
            int i2 = this.f2193c + nativeSeekMember;
            byte[] bArr = this.b;
            if (bArr[i2] != 76) {
                return 0;
            }
            return (((long) bArr[i2 + 8]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 56) | ((((long) bArr[i2 + 2]) & 255) << 48) | ((((long) bArr[i2 + 3]) & 255) << 40) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 24) | ((((long) bArr[i2 + 6]) & 255) << 16) | ((((long) bArr[i2 + 7]) & 255) << 8);
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
        wrap.order(ByteOrder.BIG_ENDIAN);
        if (a(wrap, i) == 0 && wrap.remaining() > 8 && wrap.get() == 76) {
            return wrap.getLong();
        }
        return 0;
    }

    public long g(String str) {
        return g(a(str));
    }

    public double h(int i) {
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember <= 0 || nativeSeekMember + 8 >= this.d) {
                return 0.0d;
            }
            int i2 = this.f2193c + nativeSeekMember;
            byte[] bArr = this.b;
            if (bArr[i2] != 68) {
                return 0.0d;
            }
            return Double.longBitsToDouble((((long) bArr[i2 + 8]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 56) | ((((long) bArr[i2 + 2]) & 255) << 48) | ((((long) bArr[i2 + 3]) & 255) << 40) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 24) | ((((long) bArr[i2 + 6]) & 255) << 16) | ((((long) bArr[i2 + 7]) & 255) << 8));
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
        wrap.order(ByteOrder.BIG_ENDIAN);
        if (a(wrap, i) == 0 && wrap.remaining() > 8 && wrap.get() == 68) {
            return wrap.getDouble();
        }
        return 0.0d;
    }

    public double h(String str) {
        return h(a(str));
    }

    public long i(int i) {
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            int i2 = this.f2193c + nativeSeekMember;
            if (nativeSeekMember <= 0) {
                return 0;
            }
            byte[] bArr = this.b;
            byte b2 = bArr[i2];
            if (b2 == 85) {
                if (nativeSeekMember + 4 < this.d) {
                    return ((long) (((bArr[i2 + 1] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 8) | (bArr[i2 + 4] & 255))) * 1000;
                }
                return 0;
            } else if (b2 != 88 || nativeSeekMember + 8 >= this.d) {
                return 0;
            } else {
                return ((((long) bArr[i2 + 1]) & 255) << 56) | ((((long) bArr[i2 + 2]) & 255) << 48) | ((((long) bArr[i2 + 3]) & 255) << 40) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 24) | ((((long) bArr[i2 + 6]) & 255) << 16) | ((((long) bArr[i2 + 7]) & 255) << 8) | (255 & ((long) bArr[i2 + 8]));
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) != 0) {
                return 0;
            }
            byte b3 = wrap.get();
            if (b3 == 85 && wrap.remaining() >= 4) {
                return ((long) wrap.getInt()) * 1000;
            }
            if (b3 != 88 || wrap.remaining() < 8) {
                return 0;
            }
            return wrap.getLong();
        }
    }

    public long i(String str) {
        return i(a(str));
    }

    public DPObject j(int i) {
        int i2;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember > 0) {
                int i3 = this.f2193c;
                byte[] bArr = this.b;
                byte b2 = bArr[i3 + nativeSeekMember];
                if (b2 == 79 && nativeSeekMember + 2 < (i2 = this.d)) {
                    return new DPObject(bArr, i3 + nativeSeekMember, i2 - nativeSeekMember);
                }
                if (b2 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0 && wrap.remaining() > 0) {
                byte b3 = wrap.get();
                if (b3 == 79 && wrap.remaining() > 2) {
                    return new DPObject(this.b, wrap.position() - 1, (this.d - wrap.position()) + this.f2193c + 1);
                }
                if (b3 == 78) {
                    return null;
                }
            }
        }
        return null;
    }

    public DPObject j(String str) {
        return j(a(str));
    }

    public DPObject[] k(int i) {
        int i2;
        int i3 = 0;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember > 0) {
                int i4 = this.f2193c;
                int i5 = i4 + nativeSeekMember;
                byte[] bArr = this.b;
                byte b2 = bArr[i5];
                if (b2 == 65 && nativeSeekMember + 2 < (i2 = this.d)) {
                    int i6 = ((bArr[i5 + 1] & 255) << 8) | (bArr[i5 + 2] & 255);
                    if (i6 == 0) {
                        return new DPObject[0];
                    }
                    int i7 = i4 + nativeSeekMember + 3;
                    int[] iArr = new int[i6];
                    if (nativeArraySkip(bArr, i7, (i2 - nativeSeekMember) - 3, i6, iArr)) {
                        DPObject[] dPObjectArr = new DPObject[i6];
                        while (i3 < i6) {
                            int i8 = iArr[i3];
                            byte[] bArr2 = this.b;
                            byte b3 = bArr2[i7];
                            if (b3 == 78) {
                                dPObjectArr[i3] = null;
                            } else if (b3 != 79) {
                                return null;
                            } else {
                                dPObjectArr[i3] = new DPObject(bArr2, i7, i8);
                            }
                            i7 += i8;
                            i3++;
                        }
                        return dPObjectArr;
                    }
                } else if (b2 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0 && wrap.remaining() > 0 && wrap.get() == 65 && wrap.remaining() > 1) {
                int i9 = wrap.getShort() & 65535;
                if (i9 == 0) {
                    return new DPObject[0];
                }
                DPObject[] dPObjectArr2 = new DPObject[i9];
                int position = wrap.position();
                while (i3 < i9) {
                    if (b(wrap) != 0) {
                        return null;
                    }
                    byte[] bArr3 = this.b;
                    switch (bArr3[position]) {
                        case 78:
                            dPObjectArr2[i3] = null;
                            break;
                        case 79:
                            dPObjectArr2[i3] = new DPObject(bArr3, position, wrap.position() - position);
                            break;
                        default:
                            return null;
                    }
                    position = wrap.position();
                    i3++;
                }
                return dPObjectArr2;
            }
        }
        return null;
    }

    public DPObject[] k(String str) {
        return k(a(str));
    }

    public int[] l(int i) {
        int i2;
        int i3 = 0;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i);
            if (nativeSeekMember > 0) {
                int i4 = this.f2193c;
                int i5 = i4 + nativeSeekMember;
                byte[] bArr = this.b;
                byte b2 = bArr[i5];
                if (b2 == 65 && nativeSeekMember + 2 < (i2 = this.d)) {
                    int i6 = ((bArr[i5 + 1] & 255) << 8) | (bArr[i5 + 2] & 255);
                    if (i6 == 0) {
                        return new int[0];
                    }
                    int i7 = i4 + nativeSeekMember + 3;
                    int[] iArr = new int[i6];
                    if (nativeArraySkip(bArr, i7, (i2 - nativeSeekMember) - 3, i6, iArr)) {
                        int[] iArr2 = new int[i6];
                        while (i3 < i6) {
                            int i8 = iArr[i3];
                            byte[] bArr2 = this.b;
                            if (bArr2[i7] != 73) {
                                return null;
                            }
                            iArr2[i3] = (bArr2[i7 + 4] & 255) | ((bArr2[i7 + 1] & 255) << 24) | ((bArr2[i7 + 2] & 255) << 16) | ((bArr2[i7 + 3] & 255) << 8);
                            i7 += i8;
                            i3++;
                        }
                        return iArr2;
                    }
                } else if (b2 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i) == 0 && wrap.remaining() > 0 && wrap.get() == 65 && wrap.remaining() > 1) {
                int i9 = wrap.getShort() & 65535;
                if (i9 == 0) {
                    return new int[0];
                }
                int[] iArr3 = new int[i9];
                while (i3 < i9) {
                    if (wrap.remaining() <= 4 || wrap.get() != 73) {
                        return null;
                    }
                    iArr3[i3] = wrap.getInt();
                    i3++;
                }
                return iArr3;
            }
        }
        return null;
    }

    public int[] l(String str) {
        return l(a(str));
    }

    public String[] m(int i) {
        int i2;
        int i3 = i;
        byte b2 = 83;
        int i4 = 0;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i3);
            if (nativeSeekMember > 0) {
                int i5 = this.f2193c;
                int i6 = i5 + nativeSeekMember;
                byte[] bArr = this.b;
                byte b3 = bArr[i6];
                if (b3 == 65 && nativeSeekMember + 2 < (i2 = this.d)) {
                    int i7 = ((bArr[i6 + 1] & 255) << 8) | (bArr[i6 + 2] & 255);
                    if (i7 == 0) {
                        return new String[0];
                    }
                    int i8 = i5 + nativeSeekMember + 3;
                    int[] iArr = new int[i7];
                    if (nativeArraySkip(bArr, i8, (i2 - nativeSeekMember) - 3, i7, iArr)) {
                        String[] strArr = new String[i7];
                        while (i4 < i7) {
                            int i9 = iArr[i4];
                            byte[] bArr2 = this.b;
                            byte b4 = bArr2[i8];
                            if (b4 == 78) {
                                strArr[i4] = null;
                            } else if (b4 == 83) {
                                strArr[i4] = new String(bArr2, i8 + 3, ((bArr2[i8 + 1] & 255) << 8) | (bArr2[i8 + 2] & 255));
                            } else if (b4 != 66) {
                                return null;
                            } else {
                                strArr[i4] = new String(bArr2, i8 + 5, ((bArr2[i8 + 1] & 255) << 24) | ((bArr2[i8 + 2] & 255) << 16) | ((bArr2[i8 + 3] & 255) << 8) | (bArr2[i8 + 4] & 255));
                            }
                            i8 += i9;
                            i4++;
                        }
                        return strArr;
                    }
                } else if (b3 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i3) == 0 && wrap.remaining() > 0 && wrap.get() == 65 && wrap.remaining() > 1) {
                int i10 = wrap.getShort() & 65535;
                if (i10 == 0) {
                    return new String[0];
                }
                String[] strArr2 = new String[i10];
                while (i4 < i10) {
                    if (wrap.remaining() == 0) {
                        return null;
                    }
                    byte b5 = wrap.get();
                    if (b5 != 66) {
                        if (b5 == 78) {
                            strArr2[i4] = null;
                        } else if (b5 != b2) {
                            return null;
                        } else {
                            if (wrap.remaining() > 1) {
                                short s = (short) (wrap.getShort() & 65535);
                                if (s == 0) {
                                    strArr2[i4] = "";
                                } else if (wrap.remaining() >= s) {
                                    try {
                                        strArr2[i4] = new String(this.b, wrap.position(), s, "UTF-8");
                                    } catch (UnsupportedEncodingException e2) {

                                        strArr2[i4] = null;
                                    }
                                }
                                wrap.position(wrap.position() + s);
                            }
                        }
                    } else if (wrap.remaining() > 3) {
                        int i11 = wrap.getInt();
                        if (i11 == 0) {
                            strArr2[i4] = "";
                        } else if (wrap.remaining() >= i11) {
                            try {
                                strArr2[i4] = new String(this.b, wrap.position(), i11, "UTF-8");
                            } catch (UnsupportedEncodingException e3) {

                                Log.e("dpobj", "unable to decode string", e3);
                                strArr2[i4] = null;
                            }
                        }
                        wrap.position(wrap.position() + i11);
                    }
                    i4++;
                    b2 = 83;
                }
                return strArr2;
            }
        }
        return null;
    }

    public String[] m(String str) {
        return m(a(str));
    }

    public long[] n(int i) {
        int i2;
        int i3 = i;
        long j = 1000;
        byte b2 = 88;
        byte b3 = 85;
        int i4 = 0;
        if (a) {
            int nativeSeekMember = nativeSeekMember(this.b, this.f2193c, this.d, i3);
            if (nativeSeekMember > 0) {
                int i5 = this.f2193c;
                int i6 = i5 + nativeSeekMember;
                byte[] bArr = this.b;
                byte b4 = bArr[i6];
                if (b4 == 65 && nativeSeekMember + 2 < (i2 = this.d)) {
                    int i7 = ((bArr[i6 + 1] & 255) << 8) | (bArr[i6 + 2] & 255);
                    if (i7 == 0) {
                        return new long[0];
                    }
                    int i8 = i5 + nativeSeekMember + 3;
                    int[] iArr = new int[i7];
                    if (nativeArraySkip(bArr, i8, (i2 - nativeSeekMember) - 3, i7, iArr)) {
                        long[] jArr = new long[i7];
                        while (i4 < i7) {
                            int i9 = iArr[i4];
                            byte[] bArr2 = this.b;
                            byte b5 = bArr2[i8];
                            if (b5 == b3) {
                                jArr[i4] = ((long) (((bArr2[i8 + 2] & 255) << 16) | ((bArr2[i8 + 1] & 255) << 24) | ((bArr2[i8 + 3] & 255) << 8) | (bArr2[i8 + 4] & 255))) * j;
                            } else if (b5 != b2) {
                                return null;
                            } else {
                                jArr[i4] = ((((long) bArr2[i8 + 2]) & 255) << 48) | ((((long) bArr2[i8 + 1]) & 255) << 56) | ((((long) bArr2[i8 + 3]) & 255) << 40) | ((((long) bArr2[i8 + 4]) & 255) << 32) | ((((long) bArr2[i8 + 5]) & 255) << 24) | ((((long) bArr2[i8 + 6]) & 255) << 16) | ((((long) bArr2[i8 + 7]) & 255) << 8) | (((long) bArr2[i8 + 8]) & 255);
                            }
                            i8 += i9;
                            i4++;
                            j = 1000;
                            b2 = 88;
                            b3 = 85;
                        }
                        return jArr;
                    }
                } else if (b4 == 78) {
                    return null;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
            wrap.order(ByteOrder.BIG_ENDIAN);
            if (a(wrap, i3) == 0 && wrap.remaining() > 0 && wrap.get() == 65 && wrap.remaining() > 1) {
                int i10 = wrap.getShort() & 65535;
                if (i10 == 0) {
                    return new long[0];
                }
                long[] jArr2 = new long[i10];
                while (i4 < i10) {
                    byte b6 = wrap.get();
                    if (b6 == 85 && wrap.remaining() >= 4) {
                        jArr2[i4] = ((long) wrap.getInt()) * 1000;
                    } else if (b6 != 88 || wrap.remaining() < 8) {
                        return null;
                    } else {
                        jArr2[i4] = wrap.getLong();
                    }
                    i4++;
                }
                return jArr2;
            }
        }
        return null;
    }

    public long[] n(String str) {
        return n(a(str));
    }

    /* access modifiers changed from: private */
    public int f() {
        if (a) {
            return nativeSkipAny(this.b, this.f2193c, this.d);
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.b, this.f2193c, this.d);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int b2 = b(wrap);
        return b2 == 0 ? wrap.position() - this.f2193c : b2;
    }

    public byte[] d() {
        int f = f();
        if (f > 0) {
            byte[] bArr = new byte[f];
            System.arraycopy(this.b, this.f2193c, bArr, 0, f);
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        bArr2[0] = 79;
        bArr2[3] = 90;
        return bArr2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int f = f();
        if (f <= 0) {
            f = this.d;
        }
        parcel.writeInt(0);
        parcel.writeInt(f);
        int i2 = this.f2193c;
        if (i2 == 0) {
            parcel.writeByteArray(this.b, 0, f);
            return;
        }
        byte[] bArr = new byte[f];
        System.arraycopy(this.b, i2, bArr, 0, f);
        parcel.writeByteArray(bArr);
    }

    public Iterator<Map.Entry<Integer, Object>> iterator() {
        return new b();
    }

    private static class d {
        public int a;
        public byte b;

        /* renamed from: c  reason: collision with root package name */
        public int f2195c;
        public long d;
        public double e;
        public long f;
        public String g;
        public DPObject h;
        public DPObject[] i;
        public int[] j;
        public String[] k;
        public double[] l;
        public boolean[] m;
        public long[] n;
        public long[] o;

        private d() {
        }

        /* access modifiers changed from: private */
        public void a(ByteArrayOutputStream byteArrayOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            int i2 = 0;
            int i3 = 65535;
            switch (this.b) {
                case 65 /*65*/:
                    DPObject[] dPObjectArr = this.i;
                    if (dPObjectArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length = dPObjectArr.length;
                    if (length <= 65535) {
                        i3 = length;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        a(byteArrayOutputStream2, this.i[i2]);
                        i2++;
                    }
                    return;
                case 66:
                    int[] iArr = this.j;
                    if (iArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length2 = iArr.length;
                    if (length2 <= 65535) {
                        i3 = length2;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        int i4 = this.j[i2];
                        byteArrayOutputStream2.write(73);
                        byteArrayOutputStream2.write((byte) (i4 >>> 24));
                        byteArrayOutputStream2.write((byte) (i4 >>> 16));
                        byteArrayOutputStream2.write((byte) (i4 >>> 8));
                        byteArrayOutputStream2.write((byte) i4);
                        i2++;
                    }
                    return;
                case 67:
                    String[] strArr = this.k;
                    if (strArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length3 = strArr.length;
                    if (length3 <= 65535) {
                        i3 = length3;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        a(byteArrayOutputStream2, this.k[i2]);
                        i2++;
                    }
                    return;
                case 68 /*68*/:
                    byteArrayOutputStream2.write(68);
                    long doubleToRawLongBits = Double.doubleToRawLongBits(this.e);
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 56)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 48)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 40)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 32)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 24)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 16)));
                    byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits >>> 8)));
                    byteArrayOutputStream2.write((byte) ((int) doubleToRawLongBits));
                    return;
                case 70:
                    byteArrayOutputStream2.write(70);
                    return;
                case 73:
                    byteArrayOutputStream2.write(73);
                    byteArrayOutputStream2.write((byte) (this.f2195c >>> 24));
                    byteArrayOutputStream2.write((byte) (this.f2195c >>> 16));
                    byteArrayOutputStream2.write((byte) (this.f2195c >>> 8));
                    byteArrayOutputStream2.write((byte) this.f2195c);
                    return;
                case 76:
                    byteArrayOutputStream2.write(76);
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 56)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 48)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 40)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 32)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 24)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 16)));
                    byteArrayOutputStream2.write((byte) ((int) (this.d >>> 8)));
                    byteArrayOutputStream2.write((byte) ((int) this.d));
                    return;
                case 79:
                    a(byteArrayOutputStream2, this.h);
                    return;
                case 83 /*83*/:
                    a(byteArrayOutputStream2, this.g);
                    return;
                case 84:
                    byteArrayOutputStream2.write(84);
                    return;
                case 85:
                    byteArrayOutputStream2.write(88);
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 56)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 48)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 40)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 32)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 24)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 16)));
                    byteArrayOutputStream2.write((byte) ((int) (this.f >>> 8)));
                    byteArrayOutputStream2.write((byte) ((int) this.f));
                    return;
                case 87 /*87*/:
                    long[] jArr = this.o;
                    if (jArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length4 = jArr.length;
                    if (length4 <= 65535) {
                        i3 = length4;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        long j2 = this.o[i2];
                        byteArrayOutputStream2.write(76);
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 56)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 48)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 40)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 32)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 24)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 16)));
                        byteArrayOutputStream2.write((byte) ((int) (j2 >>> 8)));
                        byteArrayOutputStream2.write((byte) ((int) j2));
                        i2++;
                    }
                    return;
                case 88:
                    double[] dArr = this.l;
                    if (dArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length5 = dArr.length;
                    if (length5 <= 65535) {
                        i3 = length5;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        double d2 = this.l[i2];
                        byteArrayOutputStream2.write(68);
                        long doubleToRawLongBits2 = Double.doubleToRawLongBits(d2);
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 56)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 48)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 40)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 32)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 24)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 16)));
                        byteArrayOutputStream2.write((byte) ((int) (doubleToRawLongBits2 >>> 8)));
                        byteArrayOutputStream2.write((byte) ((int) doubleToRawLongBits2));
                        i2++;
                    }
                    return;
                case 89:
                    boolean[] zArr = this.m;
                    if (zArr == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length6 = zArr.length;
                    if (length6 <= 65535) {
                        i3 = length6;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        byteArrayOutputStream2.write((byte) (this.m[i2] ? 84 : 70));
                        i2++;
                    }
                    return;
                case 90:
                    long[] jArr2 = this.n;
                    if (jArr2 == null) {
                        byteArrayOutputStream2.write(78);
                        return;
                    }
                    int length7 = jArr2.length;
                    if (length7 <= 65535) {
                        i3 = length7;
                    }
                    byteArrayOutputStream2.write(65);
                    byteArrayOutputStream2.write((byte) (i3 >>> 8));
                    byteArrayOutputStream2.write((byte) i3);
                    while (i2 < i3) {
                        long j3 = this.n[i2];
                        byteArrayOutputStream2.write(88);
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 56)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 48)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 40)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 32)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 24)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 16)));
                        byteArrayOutputStream2.write((byte) ((int) (j3 >>> 8)));
                        byteArrayOutputStream2.write((byte) ((int) j3));
                        i2++;
                    }
                    return;
                default:
                    return;
            }
        }

        private void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
            byte[] bArr;
            if (str == null) {
                byteArrayOutputStream.write(78);
                return;
            }
            byteArrayOutputStream.write(66);
            try {
                bArr = str.getBytes("UTF-8");
            } catch (Exception e2) {
                bArr = new byte[0];
            }
            int length = bArr.length;
            byteArrayOutputStream.write((byte) (length >>> 24));
            byteArrayOutputStream.write((byte) (length >>> 16));
            byteArrayOutputStream.write((byte) (length >>> 8));
            byteArrayOutputStream.write((byte) length);
            byteArrayOutputStream.write(bArr, 0, length);
        }

        private void a(ByteArrayOutputStream byteArrayOutputStream, DPObject dPObject) {
            if (dPObject == null) {
                byteArrayOutputStream.write(78);
                return;
            }
            int a2 = dPObject.f();
            if (a2 > 0) {
                byteArrayOutputStream.write(dPObject.b, dPObject.f2193c, a2);
                return;
            }
            byteArrayOutputStream.write(79);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(90);
        }
    }

    private class a implements Map.Entry<Integer, Object> {
        private int b;

        a(int i) {
            this.b = i;
        }

        /* renamed from: a */
        public Integer getKey() {
            return Integer.valueOf(this.b);
        }

        public Object getValue() {
            byte c2 = DPObject.this.c(this.b);
            if (c2 == 68) {
                return Double.valueOf(DPObject.this.h(this.b));
            }
            if (c2 == 73) {
                return Integer.valueOf(DPObject.this.e(this.b));
            }
            if (c2 == 76) {
                return Long.valueOf(DPObject.this.g(this.b));
            }
            if (c2 == 79) {
                return DPObject.this.j(this.b);
            }
            if (c2 == 83) {
                return DPObject.this.f(this.b);
            }
            if (c2 == 85) {
                return new Date(DPObject.this.i(this.b));
            }
            switch (c2) {
                case 65 /*65*/:
                    return DPObject.this.k(this.b);
                case 66:
                    return Boolean.valueOf(DPObject.this.d(this.b));
                default:
                    return null;
            }
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return "0x" + Integer.toHexString(this.b) + ": " + getValue();
        }
    }

    private class b implements Iterator<Map.Entry<Integer, Object>> {
        ByteBuffer a;
        a b;

        public b() {
            this.a = ByteBuffer.wrap(DPObject.this.b, DPObject.this.f2193c, DPObject.this.d);
            this.a.order(ByteOrder.BIG_ENDIAN);
            if (this.a.remaining() > 3) {
                this.a.get();
                this.a.getShort();
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.a.remaining() > 0) {
                byte b2 = this.a.get();
                if (b2 == 77) {
                    if (this.a.remaining() > 1) {
                        short s =(short) (this.a.getShort() & 65535);
                        if (DPObject.a) {
                            int c2 = DPObject.nativeSkipAny(DPObject.this.b, this.a.position(), (DPObject.this.f2193c + DPObject.this.d) - this.a.position());
                            if (c2 > 0) {
                                ByteBuffer byteBuffer = this.a;
                                byteBuffer.position(byteBuffer.position() + c2);
                                this.b = new a(s);
                                return;
                            }
                            this.b = null;
                        } else if (DPObject.b(this.a) == 0) {
                            this.b = new a(s);
                        } else {
                            this.b = null;
                        }
                    }
                } else if (b2 == 90) {
                    this.b = null;
                } else {
                    this.b = null;
                }
            } else {
                this.b = null;
            }
        }

        public boolean hasNext() {
            return this.b != null;
        }

        /* renamed from: b */
        public a next() {
            a aVar = this.b;
            if (aVar != null) {
                a();
                return aVar;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class c implements e {
        private final ArrayList<d> b;

        private c() {
            this.b = new ArrayList<>();
        }

        /* renamed from: a */
        public c b(int i, boolean z) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = (byte) (z ? 84 : 70);
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, boolean z) {
            b(DPObject.a(str), z);
            return this;
        }

        /* renamed from: a */
        public c b(int i, int i2) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 73;
            dVar.f2195c = i2;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, int i) {
            b(DPObject.a(str), i);
            return this;
        }

        /* renamed from: a */
        public c d(int i, long j) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 76;
            dVar.d = j;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c d(String str, long j) {
            d(DPObject.a(str), j);
            return this;
        }

        /* renamed from: a */
        public c b(int i, double d) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 68;
            dVar.e = d;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, double d) {
            b(DPObject.a(str), d);
            return this;
        }

        /* renamed from: b */
        public c c(int i, long j) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 85;
            dVar.f = j;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: b */
        public c c(String str, long j) {
            c(DPObject.a(str), j);
            return this;
        }

        /* renamed from: a */
        public c b(int i, String str) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 83;
            dVar.g = str;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, String str2) {
            b(DPObject.a(str), str2);
            return this;
        }

        /* renamed from: a */
        public c b(int i, DPObject dPObject) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 79;
            dVar.h = dPObject;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, DPObject dPObject) {
            b(DPObject.a(str), dPObject);
            return this;
        }

        /* renamed from: a */
        public c b(int i, DPObject[] dPObjectArr) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 65;
            dVar.i = dPObjectArr;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str, DPObject[] dPObjectArr) {
            b(DPObject.a(str), dPObjectArr);
            return this;
        }

        public e a(int i, int[] iArr) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 66;
            dVar.j = iArr;
            this.b.add(dVar);
            return this;
        }

        public e a(String str, int[] iArr) {
            a(DPObject.a(str), iArr);
            return this;
        }

        public e a(int i, String[] strArr) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 67;
            dVar.k = strArr;
            this.b.add(dVar);
            return this;
        }

        public e a(String str, String[] strArr) {
            a(DPObject.a(str), strArr);
            return this;
        }

        public e a(int i, long[] jArr) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 90;
            dVar.n = jArr;
            this.b.add(dVar);
            return this;
        }

        public e a(String str, long[] jArr) {
            return a(DPObject.a(str), jArr);
        }

        /* renamed from: a */
        public c b(int i) {
            d dVar = new d();
            dVar.a = i;
            dVar.b = 82;
            this.b.add(dVar);
            return this;
        }

        /* renamed from: a */
        public c b(String str) {
            b(DPObject.a(str));
            return this;
        }

        public DPObject a() {
            int i;
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HashMap hashMap = new HashMap(this.b.size());
            Iterator<d> it = this.b.iterator();
            while (it.hasNext()) {
                d next = it.next();
                hashMap.put(Integer.valueOf(next.a), next);
            }
            byteArrayOutputStream.write(79);
            if (DPObject.this.d > 2) {
                byteArrayOutputStream.write(DPObject.this.b[DPObject.this.f2193c + 1]);
                byteArrayOutputStream.write(DPObject.this.b[DPObject.this.f2193c + 2]);
            } else {
                byteArrayOutputStream.write(0);
                byteArrayOutputStream.write(0);
            }
            int i3 = 3;
            while (i3 < DPObject.this.d) {
                byte b2 = DPObject.this.b[DPObject.this.f2193c + i3];
                int i4 = i3 + 1;
                if (b2 != 77 || (i = i4 + 2) >= DPObject.this.d) {
                    break;
                }
                byte b3 = (byte)((DPObject.this.b[DPObject.this.f2193c + i4 + 1] & 255) | ((DPObject.this.b[DPObject.this.f2193c + i4] & 255) << 8));
                d dVar = (d) hashMap.remove(Integer.valueOf(b3));
                if (DPObject.a) {
                    i2 = DPObject.nativeSkipAny(DPObject.this.b, DPObject.this.f2193c + i, DPObject.this.d - i);
                } else {
                    ByteBuffer wrap = ByteBuffer.wrap(DPObject.this.b, DPObject.this.f2193c + i, DPObject.this.d - i);
                    wrap.order(ByteOrder.BIG_ENDIAN);
                    int a2 = DPObject.b(wrap);
                    i2 = a2 == 0 ? (wrap.position() - DPObject.this.f2193c) - i : a2;
                }
                if (dVar == null) {
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(77);
                    byteArrayOutputStream.write((byte) (b3 >>> 8));
                    byteArrayOutputStream.write((byte) b3);
                    byteArrayOutputStream.write(DPObject.this.b, DPObject.this.f2193c + i, i2);
                } else if (dVar.b != 82) {
                    byteArrayOutputStream.write(77);
                    byteArrayOutputStream.write((byte) (b3 >>> 8));
                    byteArrayOutputStream.write((byte) b3);
                    dVar.a(byteArrayOutputStream);
                }
                if (i2 <= 0) {
                    break;
                }
                i3 = i + i2;
            }
            Iterator<d> it2 = this.b.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) hashMap.remove(Integer.valueOf(it2.next().a));
                if (!(dVar2 == null || dVar2.b == 82)) {
                    byteArrayOutputStream.write(77);
                    byteArrayOutputStream.write((byte) (dVar2.a >>> 8));
                    byteArrayOutputStream.write((byte) dVar2.a);
                    dVar2.a(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(90);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return new DPObject(byteArray, 0, byteArray.length);
        }
    }
}
