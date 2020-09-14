package com.example.goods.basemvp.net;



import com.example.goods.utils.DigestUtils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpHelper {

    private static OkHttpClient client;


    /**
     * post请求
     *
     * @param url
     * @param map
     * @param cb
     */
    public static synchronized void post(String url, Map<String, String> map, Callback cb) {
        client = new OkHttpClient.Builder()
                .build();
        FormBody.Builder body = new FormBody.Builder();
        for (String key : map.keySet()) {
            body.add(key, map.get(key));
        }

        //时间戳
        int timestamp = (int) (new Date().getTime() / 1000);
        //获取一个随机的UUID
        String nonce = UUID.randomUUID().toString();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IjEiLCJwYXNzd29yZCI6IjEiLCJ1aWQiOiJiZjZmNGFmNC02ODgxLTRhN2UtYjE0OS03Zjg3MTgxMGIwYTYiLCJpYXQiOjE1OTg4NTI2Mjh9.iYjW27lK51efn1DCUgR_3V9umuB6KaNxemUPC_KMoE0";
        map.put("timestamp", String.valueOf(timestamp));
        map.put("nonce", nonce);
        map.put("token", token);
        //获取签名组装的字符
        String source = DigestUtils.getSignSource(map);
        String sign = DigestUtils.Encrypt(source, null);

        Request request = new Request.Builder()
                .url(url)
                .post(body.build())
                .addHeader("timestamp", String.valueOf(timestamp))
                .addHeader("nonce", nonce)
                .addHeader("sign", sign)
                .addHeader("token", token)
                .build();

        Call call = client.newCall(request);
        call.enqueue(cb);


    }

}
