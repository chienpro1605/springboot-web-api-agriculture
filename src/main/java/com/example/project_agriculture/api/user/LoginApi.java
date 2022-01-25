package com.example.project_agriculture.api.user;

import com.example.project_agriculture.api.AbstractApi;
import com.example.project_agriculture.cache.ram.CacheRefreshToken;
import com.example.project_agriculture.constant.ErrorCode;
import com.example.project_agriculture.exception.ApplicationException;
import com.example.project_agriculture.jwt.JwtTokenProvider;
import com.example.project_agriculture.request.user.LoginRequest;
import com.example.project_agriculture.response.ResponseData;
import com.example.project_agriculture.response.user.LoginResponse;
import com.example.project_agriculture.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApi extends AbstractApi<LoginRequest, LoginResponse> {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/api/login")
    public ResponseData login(@RequestBody LoginRequest loginRequest) {
        return handle(loginRequest);
    }

    @Override
    protected void validateRequest(LoginRequest request) {
    }

    @Override
    protected LoginResponse execute(LoginRequest request) {
        LoginResponse response;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String token = tokenProvider.generateToken(authentication);
            String refreshToken = tokenProvider.generateRefreshToken();
            CacheRefreshToken.saveRefreshToken(refreshToken, userDetails.getUsers());
            response = LoginResponse.builder().token(token).refreshToken(refreshToken).users(userDetails.getUsers()).build();
        } catch (InternalAuthenticationServiceException | BadCredentialsException e) {
            throw new ApplicationException(ErrorCode.ACCOUNT_NOT_EXISTS.getValue());
        }
        return response;
    }
}

