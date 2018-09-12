package com.util;

import com.github.kevinsawicki.http.HttpRequest;

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




    public static void getEpassCode() {
        //http://account.intertest.informac/o/authorize/?client_id=EtVErk9D3mF45x0StEajiWVYB8tOlxUX0aRZ20KJ&amp;grant_type=implicit&amp;redirect_uri=http%3A%2F%2Flocalhost%2Fredirect_uri&amp;response_type=token&amp;state=http%3A%2F%2Flocalhost%2Fredirect_uri

        HttpRequest request = HttpRequest.get(codeUrl,true,client_id,client_id_value,grant_type,grant_type_value,redirect_uri,redirect_uri_value,response_type,response_type_value);
        request.trustAllCerts();
        request.trustAllHosts();
        System.out.println("responseBody===="+request.body());
    }

    public static void getEpassTokenByCode(String code){

        Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","oJYX0iHDR8mDnajbR9r13QhBLs2zUSAd533SUXnc");
        map.put("client_secret","lkGqNT2yDeF5jozpf85pahMJHD8ad8i7xQIkLe1BKpahiuQFt0xivLjzEEVegte8FWd5YoBNfSJNuokSbSTO3tcOt9VxdMDaWhouPc7EItHbLwAE3h3eHCdieNEukABU");
        map.put("grant_type","authorization_code");
        map.put("code",code);
        map.put(redirect_uri,redirect_uri_value);
        //HttpRequest request = HttpRequest.get(url,true,client_id,client_id_value,grant_type,"implicit",redirect_uri,redirect_uri_value,"response_type","token","state",redirect_uri_value);
        String body = HttpRequest.post(tokenUrl)
                .trustAllCerts()
                .trustAllHosts()
                .form(map)
                .body();
        //request.form(map);
        //StringWriter writer = new StringWriter();
        //request.receive(writer);
        System.out.println("responseBody===="+body);
    }

    public static void verifyToken(){

        String token = "8HjcIo1NbEq5qrzVxsqtIkY1SaxU5k";
        String body = HttpRequest.post(verifyTokenUrl+token)
                .trustAllCerts()
                .trustAllHosts()
                .body();
        System.out.println("verifyResposeBody======"+body);
    }

    public static void getUserInfo(String token){

        String body = HttpRequest.post(getUserUrl)
                .header("Authorization",token)
                .trustAllCerts()
                .trustAllHosts()
                .body();
        System.out.println("verifyResposeBody======"+body);
    }

    public static void main(String[] args) {
        //HttpUtils.getEpassTokenByCode("");
        HttpUtils.getUserInfo("GHjJxm2DY3MJWiTtWEOoebZoJMN1LQ");
    }

    /*public static void httpGet(){
        InputStream is = null;
        BufferedReader br = null;
        try {
            URL url = new URL("https://202.175.27.221"); // openapi.alipay.com

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setHostnameVerifier(new HttpUtils().new TrustAnyHostnameVerifier());

            conn.connect();

            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }*/

    /*public class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }*/

}
