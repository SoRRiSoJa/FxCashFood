/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author joao
 */
public class SafePass {
    public static String crypPass(String pass){
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
            pass+="MaRGaReTHTaCHeRSuPeRSeXYCaSHFooD";
            byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));
            
            
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Erro--->"+ex);
        }
        return hexString.toString();
    }
    public static String KeyGen(int lengthPass){
        String newKey="";
        Random rand = new Random();
        char key[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        char keyN[] = {'0', '1', '2', '3', '4', '5', '6', '7','8','9' };
        char keyE[] = { '_', '.', '-', '$', '%', '/', '&', '(', ')', '[', ']', '?', '!', '@', '=', '+', '*' };
            for(int i=0;i<lengthPass;i++){
                switch((rand.nextInt(3))){
                    case 0:
                     newKey+=""+key[rand.nextInt(52)]+"";       
                    break;
                    case 1:
                    newKey+=""+keyN[rand.nextInt(10)]+"";
                    break;
                    case 2:
                    newKey+=""+keyE[rand.nextInt(17)]+"";
                    break;
                }
            }
        return newKey;
    
    }
}
