package com.expensewise.security;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;

public class JwtKeyGenerator {

    public static void main(String[] args) {

        SecretKey key = Jwts.SIG.HS256.key().build();

        String encodedKey =
                java.util.Base64.getEncoder()
                        .encodeToString(key.getEncoded());

        System.out.println(encodedKey);
    }
}