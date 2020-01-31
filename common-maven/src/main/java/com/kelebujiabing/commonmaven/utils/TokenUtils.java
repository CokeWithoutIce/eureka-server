package com.kelebujiabing.commonmaven.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TokenUtils
{
  private static TokenUtils tokenUtils = new TokenUtils();
  
  public static TokenUtils getInstance()
  {
    return tokenUtils;
  }
  
  public static void main(String[] args)
  {
    String token = getToken();
    System.out.println("token:" + token);
  }
  
  public static String getToken()
  {
    String token = UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis();
    try
    {
      MessageDigest md = MessageDigest.getInstance("md5");
      byte[] md5 = md.digest(token.getBytes());
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(md5);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
  }
}
