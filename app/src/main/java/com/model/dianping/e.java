package com.model.dianping;


import com.model.UIMsg;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/**
 * unchrive
 */
public class e {
    protected ByteBuffer a;
    private byte[] b;



    public e(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public e(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
        this.a.order(ByteOrder.BIG_ENDIAN);
    }

    public boolean a() {
        return !this.a.hasRemaining();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(20);
        this.a.mark();
        try {
            stringBuffer.append("@");
            stringBuffer.append(this.a.position());
            stringBuffer.append("(x");
            stringBuffer.append(Integer.toHexString(this.a.position()));
            stringBuffer.append("): ");
            int i = 0;
            while (true) {
                if (i < 6) {
                    if (!this.a.hasRemaining()) {
                        stringBuffer.append("(EOF)");
                        break;
                    }
                    stringBuffer.append(Integer.toHexString(this.a.get() & 255));
                    i++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {

            if (a()) {
                stringBuffer.append("EOF");
            }
        } catch (Throwable th) {

            this.a.reset();
            throw th;
        }
        this.a.reset();
        return stringBuffer.toString();
    }

    public boolean b() throws a {
        byte b2 = this.a.get();
        if (b2 == 84) {
            return true;
        }
        if (b2 == 70 || b2 == 78) {
            return false;
        }
        throw new a("unable to read boolean: " + this);
    }

    public int c() throws a {
        byte b2 = this.a.get();
        if (b2 == 73) {
            return this.a.getInt();
        }
        if (b2 == 78) {
            return 0;
        }
        throw new a("unable to read int: " + this);
    }

    public long d() throws a {
        byte b2 = this.a.get();
        if (b2 == 76) {
            return this.a.getLong();
        }
        if (b2 == 78) {
            return 0;
        }
        throw new a("unable to read long: " + this);
    }

    public double e() throws a {
        byte b2 = this.a.get();
        if (b2 == 68) {
            return this.a.getDouble();
        }
        if (b2 == 78) {
            return 0.0d;
        }
        throw new a("unable to read double: " + this);
    }

    public long f() throws a {
        byte b2 = this.a.get();
        if (b2 == 85) {
            return ((long) this.a.getInt()) * 1000;
        }
        if (b2 == 88) {
            return this.a.getLong();
        }
        if (b2 == 78) {
            return 0;
        }
        throw new a("unable to read date: " + this);
    }

    public String g() throws a {
        byte b2 = this.a.get();
        if (b2 == 83) {
            short s = (short) (this.a.getShort() & 65535);
            int i = ((s / 4096) + 1) * 4096;
            byte[] bArr = this.b;
            if (bArr == null || bArr.length < i) {
                this.b = new byte[i];
            }
            this.a.get(this.b, 0, s);
            try {
                return new String(this.b, 0, s, "utf-8");
            } catch (UnsupportedEncodingException e) {

                throw new a("unable to encode string");
            }
        } else if (b2 == 66) {
            int i2 = this.a.getInt();
            int i3 = ((i2 / 4096) + 1) * 4096;
            byte[] bArr2 = this.b;
            if (bArr2 == null || bArr2.length < i3) {
                this.b = new byte[i3];
            }
            this.a.get(this.b, 0, i2);
            try {
                return new String(this.b, 0, i2, "utf-8");
            } catch (UnsupportedEncodingException e2) {

                throw new a("unable to encode string");
            }
        } else if (b2 == 78) {
            return "";
        } else {
            throw new a("unable to read string: " + this);
        }
    }

    public <T> T a(c<T> cVar) throws a {
        byte b2 = this.a.get();
        if (b2 == 78) {
            return cVar.createInstance(0);
        }
        if (b2 == 79) {
            short s = (short)(this.a.getShort() & 65535);
            T createInstance = cVar.createInstance(s);
            if (createInstance == null) {
                throw new a("unable to create instance: " + Integer.toHexString(s));
            } else if (createInstance instanceof b) {
                ((b) createInstance).decode(this);
                return createInstance;
            } else {
                throw new a("unable to decode class: " + createInstance.getClass().getSimpleName());
            }
        } else {
            throw new a("unable to read object: " + this);
        }
    }

    public DPObject h() throws a {
        int position = this.a.position();
        byte b2 = this.a.get(position);
        if (b2 == 78) {
            this.a.get();
            return null;
        } else if (b2 == 79) {
            i();
            return new DPObject(this.a.array(), position, this.a.position() - position);
        } else {
            throw new a("unable to read dpobject: " + this);
        }
    }

    public void i() throws a {
        switch (this.a.get()) {
            case UIMsg.k_event.V_A:
                short s = (short)(this.a.getShort() & 65535);
                for (int i = 0; i < s; i++) {
                    i();
                }
                return;
            case 66:
                int i2 = this.a.getInt();
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + i2);
                return;
            case UIMsg.k_event.V_D:
                this.a.getDouble();
                return;
            case 70:
            case 78:
            case 84:
                return;
            case 73:
                this.a.getInt();
                return;
            case 76:
                this.a.getLong();
                return;
            case 79:
                this.a.getShort();
                while (j() > 0) {
                    i();
                }
                return;
            case UIMsg.k_event.V_S:
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer2.position(byteBuffer2.position() + (this.a.getShort() & 65535));
                return;
            case 85:
                this.a.getInt();
                return;
            case 88:
                this.a.getLong();
                return;
            default:
                throw new a("unable to skip object: " + this);
        }
    }

    public int j() throws a {
        byte b2 = this.a.get();
        if (b2 == 77) {
            return this.a.getShort() & 65535;
        }
        if (b2 == 90) {
            return 0;
        }
        throw new a("unable to read member hash 16: " + this);
    }

    public int[] k() throws a {
        byte b2 = this.a.get();
        if (b2 == 78) {
            return new int[0];
        }
        if (b2 == 65) {
            int i = this.a.getShort() & 65535;
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = c();
            }
            return iArr;
        }
        throw new a("unable to read array (int): " + this);
    }

    public long[] l() throws a {
        byte b2 = this.a.get();
        if (b2 == 78) {
            return new long[0];
        }
        if (b2 == 65) {
            int i = this.a.getShort() & 65535;
            long[] jArr = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = f();
            }
            return jArr;
        }
        throw new a("unable to read array (date): " + this);
    }

    public String[] m() throws a {
        byte b2 = this.a.get();
        if (b2 == 78) {
            return new String[0];
        }
        if (b2 == 65) {
            int i = this.a.getShort() & 65535;
            String[] strArr = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr[i2] = g();
            }
            return strArr;
        }
        throw new a("unable to read array (string): " + this);
    }

    public <T> T[] b(c<T> cVar) throws a {
        byte b2 = this.a.get();
        if (b2 == 78) {
            return cVar.createArray(0);
        }
        if (b2 == 65) {
            short s = (short)(this.a.getShort() & 65535);
            T[] createArray = cVar.createArray(s);
            for (int i = 0; i < s; i++) {
                createArray[i] = a(cVar);
            }
            return createArray;
        }
        throw new a("unable to read array (object): " + this);
    }
}
