package com.example.servicesbcrypt.utils;

import com.example.servicesbcrypt.controller.auth.dto.BeanToAuth;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

import java.security.Key;


public class Encrypt {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static  String KEY = "el@ConGr3z041!12"; // La clave need ser de 16 bytes


    public static String encrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        byte[] initializationVector = new byte[16]; // AES utiliza bloques de 16 bytes
        new SecureRandom().nextBytes(initializationVector);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        byte[] encryptedValueWithIv = new byte[initializationVector.length + encryptedByteValue.length];
        System.arraycopy(initializationVector, 0, encryptedValueWithIv, 0, initializationVector.length);
        System.arraycopy(encryptedByteValue, 0, encryptedValueWithIv, initializationVector.length, encryptedByteValue.length);
        return Base64.getEncoder().encodeToString(encryptedValueWithIv);
    }

    public static String decrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        byte[] decodedValue = Base64.getDecoder().decode(value);
        byte[] iv = new byte[16];
        System.arraycopy(decodedValue, 0, iv, 0, iv.length);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        byte[] decryptedByteValue = cipher.doFinal(decodedValue, iv.length, decodedValue.length - iv.length);
        return new String(decryptedByteValue, "utf-8");
    }

    public static String encryptObject(Object object, String secretKey) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(object);

        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");

        byte[] initializationVector = new byte[16];
        new SecureRandom().nextBytes(initializationVector);
        IvParameterSpec ivSpec = new IvParameterSpec(initializationVector);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encryptedBytes = cipher.doFinal(jsonData.getBytes("UTF-8"));

        byte[] encryptedInitializationVectorAndText = new byte[initializationVector.length + encryptedBytes.length];
        System.arraycopy(initializationVector, 0, encryptedInitializationVectorAndText, 0, initializationVector.length);
        System.arraycopy(encryptedBytes, 0, encryptedInitializationVectorAndText, initializationVector.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(encryptedInitializationVectorAndText);
    }

    public static String decryptObject(String encryptedDataWithIv, String secretKey) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedDataWithIv);

        byte[] initializationVector = new byte[16];
        System.arraycopy(decodedData, 0, initializationVector, 0, initializationVector.length);
        IvParameterSpec ivSpec = new IvParameterSpec(initializationVector);

        byte[] encryptedData = new byte[decodedData.length - initializationVector.length];
        System.arraycopy(decodedData, initializationVector.length, encryptedData, 0, encryptedData.length);

        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedData);

        return new String(decryptedBytes);
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(KEY.getBytes(), ALGORITHM);
    }
}
