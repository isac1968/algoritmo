package br.com.isaccanedo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cipher {

    public static String encryptThisString(String input)
    {
        try {
            // O método getInstance() é chamado com o algoritmo SHA-512
            MessageDigest md = MessageDigest.getInstance("MD5");

            // método digest() é chamado
            // para calcular o resumo da mensagem da string de entrada
            // retornada como matriz de bytes
            byte[] messageDigest = md.digest(input.getBytes());

            // Converter matriz de bytes em representação de signum
            BigInteger no = new BigInteger(1, messageDigest);

            // Converta o resumo da mensagem em valor hexadecimal
            String hashtext = no.toString(16);

            // Adicione o sistema operacional anterior para torná-lo de 32 bits
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // retorna o HashText
            return hashtext;
        }

        // Para especificar algoritmos de resumo de mensagem errados
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException
    {

        System.out.println("HashCode gerado por MD5 para: ");

        String s1 = "Isac Canedo";
        System.out.println("\n" + s1 + " : " + encryptThisString(s1));

        String s2 = "Especialista em Engenharia de Software";
        System.out.println("\n" + s2 + " : " + encryptThisString(s2));
    }
}
