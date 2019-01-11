package com.ssy.app.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 余昊泽的工具类
 *
 */
public class YhzUtils {
    private final static ThreadLocal<String> vo = new ThreadLocal<>();
    private final static int VDM =6;

    private final static int DATE_OUT = 30*60*100;

    private final static String TOKEN_SECERT = "YAOHAOZE";

    public static String sign(String name,long id) {

        Date date = new Date(System.currentTimeMillis()+DATE_OUT);

        try {
            Algorithm al = Algorithm.HMAC256(TOKEN_SECERT);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", "JWT");
            map.put("alg", "HMAC256");
            return JWT.create().withHeader(map).withClaim("loginName", name).withClaim("id", id).withExpiresAt(date).sign(al);
        } catch (Exception e) {

            return null;
        }
    }


    public static boolean verify(String token) {
        try {
            Algorithm al = Algorithm.HMAC256(TOKEN_SECERT);
            JWTVerifier verify = JWT.require(al).build();
            DecodedJWT jwt = verify.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private final static String ERROR="ERROR";
    private final static String SUCCESS="SUCCESS";
    private static ResponseJson responseJson = new ResponseJson();

    public static ResponseJson responseError(Object data){
        responseJson.setData(data);
        responseJson.setStatus(YhzUtils.ERROR);
        return responseJson;
    }
    public static ResponseJson responseSuccess(Object data){
        responseJson.setData(data);
        responseJson.setStatus(YhzUtils.SUCCESS);
        return responseJson;
    }

    public static String setValidator(){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(VDM);
        for(int i=0; i < VDM; i++)
            sb.append((char)('0' + rnd.nextInt(10)));
        return sb.toString();
    }


    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=format.parse("2019-1-11");
            String st = YhzUtils.getTime(date);
            System.out.println(st);
        }catch (Exception e){

        }

    }

    public static long getDateTimeMillis(Date date){
        long l = 0;
        try{
            l = date.getTime();
        }catch (Exception e){
            System.out.println("时间错误");
        }
        return l;
    }

    public static String getTime(Date date){
        long current = System.currentTimeMillis();
        long dateTime = YhzUtils.getDateTimeMillis(date);
        long diff = current - dateTime;
        long min=diff/(1000*60);
        if (min<60){
            return min+"分钟";
        } else {
            long hour = min/60;
            min = min%60;
            if (hour<24){
                 return hour+"小时"+min+"分钟";
             }else {
                long m = hour/24;
                hour = hour%24;
                return m+"天"+hour+"小时"+min+"分钟";
            }
        }
    }


}
