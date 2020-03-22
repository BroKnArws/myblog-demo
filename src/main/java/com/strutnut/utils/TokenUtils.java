package com.strutnut.utils;


import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;

import com.strutnut.model.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@PropertySource("classpath:token.properties")
public class TokenUtils {


    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    //过期时间的属性
    private static final String EXP = "exp";


    private static final String PAYLOAD = "payload";

    //过期时间
    @Value("${token.expiration}")
    private long expiration;

    // 加密，传入一个对象
    public String generateToken(User user) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<>();
            claims.put(PAYLOAD, user.getAccount());
            claims.put(EXP, System.currentTimeMillis() + expiration);
            return signer.sign(claims);
        } catch (Exception e) {
            return null;
        }
    }

    //解密，传入一个加密后的token
    public String getEmailByToken(String token) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String, Object> claims = verifier.verify(token);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long) claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    return claims.get(PAYLOAD).toString();
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


}
