package com.example.xinan.util;

import com.example.xinan.db.Content;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static String cookie;
    public static void setToken(String token){
        cookie = token;
    }
    public static String getToken(){
        return cookie;
    }
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).addHeader("Cookie", cookie).build();
        client.newCall(request).enqueue(callback);
    }
    //for cookie
    public static void postOkHttpRequest(String address,okhttp3.Callback callback) {
        RequestBody formBody = new FormBody.Builder()
                .add("account", "test")
                .add("password", "test")
                .build();//临时措施
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }
    //for send
    public static void postOkHttpRequest(String address,Content con, okhttp3.Callback callback) {
        RequestBody formBody = new FormBody.Builder()
                .add("title", con.getTitle())
                .add("price", String.valueOf(con.getPrice()))
                .add("desc", con.getDescription())
                .add("tag", con.getTag())
                .add("pic", "")
                .add("name", con.getName())
                .add("contact_type", String.valueOf(con.getContactType()))
                .add("contact", con.getContact())
                .add("type", String.valueOf(con.getType()))
                .build();//临时措施
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).post(formBody).addHeader("Cookie",cookie).build();
        client.newCall(request).enqueue(callback);
    }
}
