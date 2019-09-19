/*
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

public class HttpRequestUtils {

    private static String tokenUrl = "https://202.175.27.221/o/token/";
    private static String verifyTokenUrl = "https://202.175.27.221/o/token-info/";
    private static String getUserUrl = "https://202.175.27.221/o/profile/";
    private static String redirect_uri = "redirect_uri";
    private static String redirect_uri_value = "";


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
                */
/*.useProxy("127.0.0.1",1080)*//*

                .form(map)
                .body();

        System.out.println("responseBody===="+body);
        tokenResult = new Gson().fromJson(body,TokenResult.class);


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

    public static EpassUserInfo getUserInfo(String token){

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
        return userInfo;
    }

    public static void refreshToken(String token){
        TokenResult tokenResult = null;
        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc");
        map.put("client_secret","lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU");
        map.put("grant_type","refresh_token");
        map.put("refresh_token",token);
        String body = HttpRequest.post(tokenUrl)
               */
/* .trustAllCerts()
                .trustAllHosts()*//*

                .form(map)
                .body();

        tokenResult = new Gson().fromJson(body,TokenResult.class);
        System.out.println("responseBody===="+body);
    }

    public static void cbisTest(){
        String url = "http://localhost:8102/resources/request/SSOAuthorizeModule@generateAuthorizeCode";

        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","0oahb0a040ZiBgVrM0h7");

        String body = HttpRequest.post(url)
                .form(map)
                .body();

        System.out.println("resposeBody======"+body);
    }

    public static void main(String[] args) {
        cbisTest();
        //EpassUserInfo epassUserInfo = new EpassUserInfo();
        //TokenResult tokenResult = HttpRequestUtils.getEpassTokenByCode("lPlWjwNeMO7zQZf6Tp2Ht7Gh2HW9Cj");
        //if(tokenResult.getAccess_token() != null){
          //  epassUserInfo = HttpRequestUtils.getUserInfo("O9lsJspCzSn93uTkobxI6pjMjhtPld");
        //}
        //HttpRequestUtils.verifyToken("omKTr9ZVYtlpdBH8WOBuEKZIKPRiFZ");
        */
/*EpassUserInfo epassUserInfo = getUserInfo("fGpeqOpXvrvH06p1J8xXNXfwvSGbgE");*//*

        //System.out.println(epassUserInfo);

        */
/*Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc");
        map.put("client_secret","lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU");
        map.put("grant_type","authorization_code");
        map.put("code","code");
        map.put(redirect_uri,redirect_uri_value);*//*


        //System.out.println(new Gson().toJson(map));
        //getEpassTokenByCode("zyyaBW1LQHyLwQpZL0MDb930qmJkSF");
        //String url = "https://172.17.17.254:20110/aopoauth/oauth/authorize?app_id=501563&response_type=code&redirect_uri=http://www.baidu.com";
        //HttpRequest.get(url).trustAllHosts().trustAllCerts().useProxy("localhost",1081).proxyBasic("root","cbis123!@#");

    }
}
*/
