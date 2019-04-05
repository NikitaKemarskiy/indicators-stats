package com.jsondb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

class Hashing {
    // Private
    private Hashing() {}

    // Public
    public static String md5(String str) {
        // Variables
        MessageDigest md5 = null;

        // Get MD5 MessageDigest instance
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException err) {
            System.out.println(err.getMessage());
            System.exit(1);
        }

        byte[] bytes = md5.digest(str.getBytes(StandardCharsets.UTF_8)); // MD5 bytes

        return bytesToHex(bytes);
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
