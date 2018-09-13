package com.util;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.stu.EpassUserInfo;
import com.stu.TokenResult;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    private static String codeUrl = "https://202.175.27.221/o/authorize";
    private static String tokenUrl = "https://202.175.27.221/o/token/";
    private static String verifyTokenUrl = "https://202.175.27.221/o/token-info/";
    private static String getUserUrl = "https://202.175.27.221/o/profile/";
    private static String client_id = "client_id";
    private static String client_id_value = "EtVErk9D3mF45x0StEajiWVYB8tOlxUX0aRZ20KJ";
    private static String client_secret = "client_secret";
    private static String client_secret_value = "";
    private static String grant_type = "grant_type";
    private static String grant_type_value = "code";
    private static String code = "code";
    private static String code_value = "";
    private static String redirect_uri = "redirect_uri";
    private static String redirect_uri_value = "http://10.100.4.73:8109/resources/request/UserModule@matchEpassUser";
    private static String response_type ="response_type";
    private static String response_type_value = "code";


    public static TokenResult getEpassTokenByCode(String code){

        TokenResult tokenResult = null;
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc");
        map.put("client_secret","lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU");
        map.put("grant_type","authorization_code");
        map.put("code",code);
        map.put(redirect_uri,redirect_uri_value);

        String body = HttpRequest.post(tokenUrl)
                .trustAllCerts()
                .trustAllHosts()
                .form(map)
                .body();

        tokenResult = new Gson().fromJson(body,TokenResult.class);
        System.out.println("responseBody===="+body);

        return tokenResult;
    }

    public static void verifyToken(String token){
        String body = HttpRequest.get(verifyTokenUrl+token)
                .header("Content-Type","application/json")
                .accept("applicaiton/json")
                .trustAllCerts()
                .trustAllHosts()
                .body();
        System.out.println("verifyResposeBody======"+body);
    }

    public static void getUserInfo(String token){

        EpassUserInfo userInfo = new EpassUserInfo();
        String body = HttpRequest.get(getUserUrl)
                .header("Authorization","bearer "+token)
                .header("Content-Type","application/json")
                .accept("application/json")
                .trustAllCerts()
                .trustAllHosts()
                .body();
        userInfo = new Gson().fromJson(body,EpassUserInfo.class);

        System.out.println("resposeBody======"+body);
    }

    public static void refreshToken(String token){
        TokenResult tokenResult = null;
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc");
        map.put("client_secret","lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU");
        map.put("grant_type","refresh_token");
        map.put("refresh_token",token);
        String body = HttpRequest.post(tokenUrl)
                .trustAllCerts()
                .trustAllHosts()
                .form(map)
                .body();

        tokenResult = new Gson().fromJson(body,TokenResult.class);
        System.out.println("responseBody===="+body);
    }

    public static void main(String[] args) {

        /*TokenResult tokenResult = HttpUtils.getEpassTokenByCode("gV6QY2GCHsijYL8PxdoPjLhXTsVvYq");
        if(tokenResult.getAccess_token() != null){
            HttpUtils.verifyToken("omKTr9ZVYtlpdBH8WOBuEKZIKPRiFZ");
            //HttpUtils.getUserInfo(tokenResult.getAccess_token());
        }*/
        //HttpUtils.verifyToken("omKTr9ZVYtlpdBH8WOBuEKZIKPRiFZ");
        getUserInfo("omKTr9ZVYtlpdBH8WOBuEKZIKPRiFZ");
    }
}
