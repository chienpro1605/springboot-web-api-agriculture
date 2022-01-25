package com.example.project_agriculture.api.user;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.cache.ram.CacheRefreshToken;
import com.example.project_agriculture.cache.redis.LogoutCache;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.request.user.RefreshTokenRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.user.LogoutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutApi extends AbstractApi<RefreshTokenRequest, LogoutResponse> {

    @Autowired
    private LogoutCache logoutCache;

    @Override
    protected void validateRequest(RefreshTokenRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @PostMapping("/api/logout")
    public ResponseData logout(@RequestBody RefreshTokenRequest request) {
        return handle(request);
    }

    @Override
    protected LogoutResponse execute(RefreshTokenRequest request) {
        CacheRefreshToken.removeRefreshToken(request.getRefreshToken());
        CacheRefreshToken.removeRefreshTokenExpired(request.getRefreshToken());
        logoutCache.addLogoutCache(request.getToken());
        return new LogoutResponse();
    }
}

