package com.example.project_agriculture.request.user;

import com.example.project_agriculture.entity.Cooperative;

import java.util.Date;
import java.util.Set;

public class SignUpForm {
    private String name;
    private String username;
    private String address;
    private Date birthday;
    private Cooperative cooperative;
    private String mobile;
    private String avatar;
    private String groupId;
    private String password;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String mobile, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.roles = roles;
    }

    public SignUpForm(String name, String username, String address, Date birthday, Cooperative cooperative, String mobile, String avatar, String groupId, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.birthday = birthday;
        this.cooperative = cooperative;
        this.mobile = mobile;
        this.avatar = avatar;
        this.groupId = groupId;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Cooperative getCooperative() {
        return cooperative;
    }

    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
