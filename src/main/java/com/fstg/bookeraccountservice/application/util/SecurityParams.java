package com.fstg.bookeraccountservice.application.util;

public class SecurityParams {

    private SecurityParams() {

    }

    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "softcodeur@gmail.com";
    public static final long EXPIRATION = 86400000;
    public static final String HEADER_PREFIX = "Bearer ";
}
