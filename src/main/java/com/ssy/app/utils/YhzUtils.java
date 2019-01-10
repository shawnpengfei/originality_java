package com.ssy.app.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

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
        String vv = YhzUtils.setValidator();
        System.out.println(vv);

        vo.set(vv);

        System.out.println(vo.get());
    }
}
