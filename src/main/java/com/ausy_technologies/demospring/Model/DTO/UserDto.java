package com.ausy_technologies.demospring.Model.DTO;


import java.util.List;

public class UserDto {


    private String username;

    private String email;

    private List<String> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
