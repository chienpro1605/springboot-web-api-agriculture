package com.example.project_agriculture.security;

import com.example.project_agriculture.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Users users;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Users users, Collection<? extends  GrantedAuthority> authorities) {
        this.users = users;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Users users) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(users.getRoles().toString()));
        return new UserDetailsImpl(users, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    public Users getUsers() {
        return users;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) obj;
        return Objects.equals(users.getUserId(), userDetails.getUsers().getUserId());
    }
}
