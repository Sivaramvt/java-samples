package com.computepatterns.aws;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * AWS signature generation.
 */
public class AwsSignatureV4Utils {

    public static byte[] computeHmacSHA256(byte[] key, String data) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException,
            UnsupportedEncodingException {
        String algorithm = "HmacSHA256";
        String charsetName = "UTF-8";

        Mac sha256_HMAC = Mac.getInstance(algorithm);
        SecretKeySpec secret_key = new SecretKeySpec(key, algorithm);
        sha256_HMAC.init(secret_key);

        return sha256_HMAC.doFinal(data.getBytes(charsetName));
    }

    public static byte[] computeHmacSHA256(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException,
            UnsupportedEncodingException {
        return computeHmacSHA256(key.getBytes(), data);
    }

    public static String getSignatureV4(String accessSecretKey, String date, String region, String regionService, String signing, String stringToSign)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, UnsupportedEncodingException {

        byte[] dateKey = computeHmacSHA256(accessSecretKey, date);

        byte[] dateRegionKey = computeHmacSHA256(dateKey, region);

        byte[] dateRegionServiceKey = computeHmacSHA256(dateRegionKey, regionService);

        byte[] signingKey = computeHmacSHA256(dateRegionServiceKey, signing);

        byte[] signature = computeHmacSHA256(signingKey, stringToSign);

        return bytesToHex(signature);
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, UnsupportedEncodingException {
        // http://docs.aws.amazon.com/AmazonS3/latest/API/sigv4-post-example.html
        String accessSecretKey = "AWS4" + "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
        String date = "20130806";
        String region = "us-east-1";
        String regionService = "s3";
        String signing = "aws4_request";
        String stringToSign = "AWS4-HMAC-SHA256\n" +
                "20150830T123600Z\n" +
                "20150830/us-east-1/service/aws4_request\n" +
                "bb579772317eb040ac9ed261061d46c1f17a8133879d6129b6e1c25292927e63";

        System.out.println("signature: " + getSignatureV4(accessSecretKey, date, region, regionService, signing, stringToSign));
    }

}