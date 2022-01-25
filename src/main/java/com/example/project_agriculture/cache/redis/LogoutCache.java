package com.example.project_agriculture.cache.redis;

import com.example.project_agriculture.cache.BaseRedisCache;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class LogoutCache extends BaseRedisCache {
    private static String LOGOUT_TOKEN = "logout_token";

    public void addLogoutCache(String token) {
        sadd(LOGOUT_TOKEN, token);
    }

    public Set<String> getLogoutTokens() {
        return smembers(LOGOUT_TOKEN);
    }

    public void removeLogoutToken(String value) {
        srem(LOGOUT_TOKEN, value);
    }

    public static void main(String[] args) {
        LogoutCache logoutCache = new LogoutCache();
        System.out.println(logoutCache.getLogoutTokens());
    }

}