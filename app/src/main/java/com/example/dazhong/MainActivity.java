package com.example.dazhong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.http.HttpClientUtil;
import com.model.SearchIndexPromptResult;
import com.model.dianping.DPObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String model = "AES/CBC/NoPadding";
    /* renamed from: b  reason: collision with root package name */
    public static final byte[] key;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] iv;
    static {
        byte[] bArr = {92, 115, 116, 117, 112, 113, 6, 112, 112, 3, 3, 4, 6, 118, 0, 112};
        byte b2 = 24;
        for (int i = 0; i < bArr.length; i++) {
            b2 = (byte) (b2 ^ (bArr[i] & 255));
            bArr[i] = b2;
        }
        key = bArr;
        byte[] bArr2 = {0, 118, 122, 10, 3, 116, 124, 10, 5, 117, 6, 5, 3, 4, 2, 37};
        byte b3 = 97;
        for (int length = bArr2.length - 1; length >= 0; length--) {
            b3 = (byte) (b3 ^ (bArr2[length] & 255));
            bArr2[length] = b3;
        }
        iv = bArr2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("Accept-Encoding", "Accept-Encoding");
        stringStringHashMap.put("pragma-device", "00000000000000");
        stringStringHashMap.put("pragma-newtoken", "01bc418993f9f2cc59afce1e9bb09943bb0394b233849187050d007762f91fe810427defe8c585fa596f30efff1a933619dc488f81b4c42551ba3fc06c7e5489");
        stringStringHashMap.put("network-type", "wifi");
        stringStringHashMap.put("pragma-os", "MApi 1.3 (com.dianping.v1 10.32.12 om_sd_sgsztc11 Google; Android 7.0)");
        stringStringHashMap.put("M-SHARK-TRACEID", "11b86a7f3ac5f947e49a1ec22ea3ef4080a15982979873852758481bf59159833013699875aa54");
        stringStringHashMap.put("pragma-uuid", "e426abce-210d-49c6-8cd8-03cde130b222");
        stringStringHashMap.put("pragma-token", "01bc418993f9f2cc59afce1e9bb09943bb0394b233849187050d007762f91fe810427defe8c585fa596f30efff1a933619dc488f81b4c42551ba3fc06c7e5489");
        stringStringHashMap.put("pragma-unionid", "b86a7f3ac5f947e49a1ec22ea3ef4080a159829798738527584");
        stringStringHashMap.put("User-Agent", "MApi 1.3 (com.dianping.v1 10.32.12 om_sd_sgsztc11 Google; Android 7.0)");
        stringStringHashMap.put("pragma-dpid", "b86a7f3ac5f947e49a1ec22ea3ef4080a159829798738527584");
        stringStringHashMap.put("host", "mapi.dianping.com");
        String url = "https://mapi.dianping.com/mapi/searchindexprompt.bin?cityid=16&source=home&locatecityid=0&noprofile=0&__skck=8f5973b085446090f224af74e30e0181&__skts=1598330137&__skua=88c71cbea37c93441ffac4f3308d1c40&__skno=9ebe0092-62f8-446d-82d2-d5be372ae920&__skvs=1.17&__skcy=ZW/qBZlDdNUV1ndmGLTlmEblR7s=";
        HttpClientUtil.get(url, stringStringHashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                try {
                    byte[] decode = decode(bytes);
                    if (decode.length <= 0 || decode[0] != 83) {
                        Object dianping = DPObject.a(decode, 0, decode.length);
                        SearchIndexPromptResult searchIndexPromptResult = ((DPObject)(dianping)).a(SearchIndexPromptResult.l);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    /**
     * 大众点评解密算法
     * @param bArr
     * @return
     * @throws Exception
     */
    public static byte[] decode(byte[] bArr) throws Exception {
        byte[] bArr2 = null;

        if (bArr.length % 16 != 0) {
            System.out.println("长度不正确");
            return null;
        }
        Cipher instance = Cipher.getInstance(model);
        instance.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, model.substring(0, 3)), new IvParameterSpec(iv));
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(instance.doFinal(bArr)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] bArr3 = new byte[4096];
        while (true) {
            int read = gZIPInputStream.read(bArr3);
            if (read > 0) {
                byteArrayOutputStream.write(bArr3, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
