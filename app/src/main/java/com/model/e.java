package com.model;

import com.dianping.archive.c;
import com.dianping.archive.DPObject;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class e {
    protected ByteBuffer a;

    private byte[] b;


    public e(ByteBuffer paramByteBuffer) {
        this.a = paramByteBuffer;
        paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public e(byte[] paramArrayOfbyte) {
        this.a = ByteBuffer.wrap(paramArrayOfbyte);
        this.a.order(ByteOrder.BIG_ENDIAN);
    }

    public <T> T a(c<T> paramc) throws a {
        byte b = this.a.get();
        if (b == 78)
            return paramc.createInstance(0);
        if (b == 79) {
            int i = this.a.getShort() & 0xFFFF;
            paramc = (c<T>)paramc.createInstance(i);
            if (paramc != null) {
                if (paramc instanceof b) {
                    ((b)paramc).decode(this);
                    return (T)paramc;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("unable to decode class: ");
                stringBuilder2.append(paramc.getClass().getSimpleName());
                throw new a(stringBuilder2.toString());
            }
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("unable to create instance: ");
            stringBuilder1.append(Integer.toHexString(i));
            throw new a(stringBuilder1.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read object: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public boolean a() {
        return this.a.hasRemaining() ^ true;
    }

    public boolean b() throws a {
        byte b = this.a.get();
        if (b == 84)
            return true;
        if (b == 70 || b == 78)
            return false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read boolean: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public <T> T[] b(c<T> paramc) throws a {
        byte b = this.a.get();
        int i = 0;
        if (b == 78)
            return paramc.createArray(0);
        if (b == 65) {
            int j = this.a.getShort() & 0xFFFF;
            T[] arrayOfT = paramc.createArray(j);
            while (i < j) {
                arrayOfT[i] = a(paramc);
                i++;
            }
            return arrayOfT;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read array (object): ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public int c() throws a {
        byte b = this.a.get();
        if (b == 73)
            return this.a.getInt();
        if (b == 78)
            return 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read int: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public long d() throws a {
        byte b = this.a.get();
        if (b == 76)
            return this.a.getLong();
        if (b == 78)
            return 0L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read long: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public double e() throws a {
        byte b = this.a.get();
        if (b == 68)
            return this.a.getDouble();
        if (b == 78)
            return 0.0D;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read double: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public long f() throws a {
        byte b = this.a.get();
        if (b == 85)
            return this.a.getInt() * 1000L;
        if (b == 88)
            return this.a.getLong();
        if (b == 78)
            return 0L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read date: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public String g() throws a {
        int i = this.a.get();
        if (i == 83) {
            i = this.a.getShort() & 0xFFFF;
            int j = (i / 4096 + 1) * 4096;
            byte[] arrayOfByte = this.b;
            if (arrayOfByte == null || arrayOfByte.length < j)
                this.b = new byte[j];
            this.a.get(this.b, 0, i);
            try {
                return new String(this.b, 0, i, "utf-8");
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new a("unable to encode string");
            }
        }
        if (i == 66) {
            i = this.a.getInt();
            int j = (i / 4096 + 1) * 4096;
            byte[] arrayOfByte = this.b;
            if (arrayOfByte == null || arrayOfByte.length < j)
                this.b = new byte[j];
            this.a.get(this.b, 0, i);
            try {
                return new String(this.b, 0, i, "utf-8");
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new a("unable to encode string");
            }
        }
        if (i == 78)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read string: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public DPObject h() throws a {
        int i = this.a.position();
        byte b = this.a.get(i);
        if (b == 78) {
            this.a.get();
            return null;
        }
        if (b == 79) {
            i();
            return new DPObject(this.a.array(), i, this.a.position() - i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read dpobject: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public void i() throws a {
        short s1;
        int i;
        short s2;
        StringBuilder stringBuilder;
        ByteBuffer byteBuffer;
        switch (this.a.get()) {
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("unable to skip object: ");
                stringBuilder.append(this);
                throw new a(stringBuilder.toString());
            case 88:
                this.a.getLong();
                return;
            case 85:
                this.a.getInt();
                return;
            case 83:
                s1 = this.a.getShort();
                byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + (s1 & 0xFFFF));
                return;
            case 79:
                this.a.getShort();
                while (j() > 0)
                    i();
                break;
            case 76:
                this.a.getLong();
                return;
            case 73:
                this.a.getInt();
                return;
            case 68:
                this.a.getDouble();
                return;
            case 66:
                i = this.a.getInt();
                byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + i);
                return;
            case 65:
                s2 = this.a.getShort();
                for (i = 0; i < (s2 & 0xFFFF); i++)
                    i();
                break;
            case 70:
            case 78:
            case 84:
                break;
        }
    }

    public int j() throws a {
        byte b = this.a.get();
        if (b == 77)
            return this.a.getShort() & 0xFFFF;
        if (b == 90)
            return 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read member hash 16: ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public int[] k() throws a {
        byte b = this.a.get();
        int i = 0;
        if (b == 78)
            return new int[0];
        if (b == 65) {
            int j = this.a.getShort() & 0xFFFF;
            int[] arrayOfInt = new int[j];
            while (i < j) {
                arrayOfInt[i] = c();
                i++;
            }
            return arrayOfInt;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read array (int): ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public long[] l() throws a {
        byte b = this.a.get();
        int i = 0;
        if (b == 78)
            return new long[0];
        if (b == 65) {
            int j = this.a.getShort() & 0xFFFF;
            long[] arrayOfLong = new long[j];
            while (i < j) {
                arrayOfLong[i] = f();
                i++;
            }
            return arrayOfLong;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read array (date): ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
    }

    public String[] m() throws a {
        byte b = this.a.get();
        int i = 0;
        if (b == 78)
            return new String[0];
        if (b == 65) {
            int j = this.a.getShort() & 0xFFFF;
            String[] arrayOfString = new String[j];
            while (i < j) {
                arrayOfString[i] = g();
                i++;
            }
            return arrayOfString;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unable to read array (string): ");
        stringBuilder.append(this);
        throw new a(stringBuilder.toString());
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
            while (i < 6) {
                if (this.a.hasRemaining()) {
                    stringBuffer.append(Integer.toHexString(this.a.get() & 0xFF));
                    i++;
                    continue;
                }
                stringBuffer.append("(EOF)");
            }
        } catch (Exception exception) {

            if (a())
                stringBuffer.append("EOF");
        } finally {}
        this.a.reset();
        return stringBuffer.toString();
    }
}
