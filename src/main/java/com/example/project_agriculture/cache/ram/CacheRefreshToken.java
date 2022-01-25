package com.example.project_agriculture.cache.ram;

import com.example.project_agriculture.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
public class CacheRefreshToken {
    private static Map<String, Long> refreshTokensExpired = new ConcurrentHashMap<>();
    private static Map<String, Users> refreshTokens = new ConcurrentHashMap<>();

    public static void saveRefreshTokenExpired(String refreshToken, Long expireTime) {
        refreshTokensExpired.put(refreshToken, expireTime);
    }

    public static boolean checkRefreshTokenExpired(String refreshToken) {
        return refreshTokensExpired.get(refreshToken)!=null;
    }

    public static void saveRefreshToken(String refreshToken, Users users) {
        refreshTokens.put(refreshToken, users);
    }

    public static Users getRefreshToken(String refreshToken) {
        return refreshTokens.get(refreshToken);
    }

    public static void removeRefreshTokenExpired(String refreshToken) {
        refreshTokensExpired.remove(refreshToken);
    }

    public static void removeRefreshToken(String refreshToken) {
        refreshTokens.remove(refreshToken);
    }

    public static Map<String, Long> getAllRefreshTokensExpired() {
        return refreshTokensExpired;
    }
}
