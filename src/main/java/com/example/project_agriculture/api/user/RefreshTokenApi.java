package com.example.project_agriculture.api.user;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.cache.ram.CacheRefreshToken;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.jwt.JwtTokenProvider;
import com.example.project_agriculture.request.user.RefreshTokenRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshTokenApi extends AbstractApi<RefreshTokenRequest, LoginResponse> {

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/api/refreshToken")
    public ResponseData refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return handle(refreshTokenRequest);
    }

    @Override
    protected void validateRequest(RefreshTokenRequest request) {
        if (!request.validateRequest()) {
            throw new ApplicationException(ErrorCode.WRONG_FORMAT_INPUT.getValue());
        }
    }

    @Override
    protected LoginResponse execute(RefreshTokenRequest request) {
        if (!CacheRefreshToken.checkRefreshTokenExpired(request.getRefreshToken())) {
            throw new ApplicationException(ErrorCode.REFRESH_TOKEN_EXPIRED.getValue());
        }
        Users users = CacheRefreshToken.getRefreshToken(request.getRefreshToken());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = tokenProvider.generateToken(authentication);
        LoginResponse response = LoginResponse.builder().token(token).refreshToken(request.getRefreshToken()).users(users).build();
        return response;
    }
}

