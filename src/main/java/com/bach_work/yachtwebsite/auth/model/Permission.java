package com.bach_work.yachtwebsite.auth.model;

public enum Permission {
    MANAGER_READ("manager:read"),
    MANAGER_WRITE("manager:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}