package com.ry.xk.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ry.xk.springbootframe.config.CommonConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 * JWT工具类 <描述类的作用>
 * 
 * @ClassName: JwtHelper
 * @author 幸仁强
 * @date 2018年5月26日
 */
@Component
public class JwtHelper
{
    private static Logger log = LoggerFactory.getLogger(JwtHelper.class);

    public static Claims parseJWT(String jsonWebToken)
    {
        try
        {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(CommonConfig.getBase64Security())).parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public static String createJWT(int userId)
        throws Exception
    {
        if (userId <= 0)
        {
            log.error("userId不能为" + userId);
            return "";
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(CommonConfig.getBase64Security());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // 添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").claim("userId", userId).signWith(signatureAlgorithm, signingKey);
        long expMillis = nowMillis + CommonConfig.getExpire();
        Date exp = new Date(expMillis);
        builder.setExpiration(exp).setNotBefore(now);

        // 生成JWT
        return builder.compact();
    }

    /**
     * 用于获取Token中的用户ID <描述方法的作用>
     * 
     * @Title: getUserId
     * @author 幸仁强
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static int getUserId(String jsonWebToken)
    {
        Claims c = parseJWT(jsonWebToken);
        return Integer.parseInt((null != c && null != c.get("userId")) ? c.get("userId").toString() : "0");
    }

    public static void main(String[] args)
        throws Exception
    {
        String jwtToken = createJWT(10);
        System.out.println(jwtToken);
        try
        {
            System.out.println(getUserId(jwtToken));
        }
        catch (ExpiredJwtException e)
        {
            System.out.println("token已过期");
        }
        catch (SignatureException e)
        {
            System.out.println("签名校验失败");
        }
        catch (Exception e)
        {
            System.out.println("其它错误");
        }

    }
}