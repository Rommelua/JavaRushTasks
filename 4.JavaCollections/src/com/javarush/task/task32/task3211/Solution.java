package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
//        MessageDigest digest = MessageDigest.getInstance("MD5");
//        digest.update(byteArrayOutputStream.toByteArray());
//        byte[]dig = digest.digest();
//        // convert the byte to hex format
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < dig.length; j++) {
//            String s = Integer.toHexString(0xff & dig[j]);
//            s = (s.length() == 1) ? "0" + s : s;
//            sb.append(s);
//        }
//        System.out.println(sb.toString());
//        return sb.toString().equals(md5);
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BigInteger i = new BigInteger(1, messageDigest.digest(byteArrayOutputStream.toByteArray()));
        System.out.println(i.toString(16));
        return i.toString(16).equals(md5);
        //return String.format("%032x", i).equals(md5);
    }
}
