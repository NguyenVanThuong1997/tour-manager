package com.bezkoder.springjwt.Common;

public class RequestPath {
    // Home path
    public static final String HOME = "/";
    // Screen M path

    public static final String AM = "/AM";
    // Error page
    public static final String PAGE_ERROR = "/error";

    // ------------------------------------------------------------------------
    // LIST PATH MANAGE
    // ------------------------------------------------------------------------

    // T
    public static final String T001_LOGIN = "/T/T001/login";
    public static final String T001_ADD_USER = "/T/T001/add-user";



    public static final String AM001_FORGET_PASSWORD = "/AM/AM001/forget-password";
    public static final String AM001_SEND_MAIL = "/AM/AM001/send-mail";
    public static final String AM001_VERIFY_USER = "/AM/AM001/verify_user";
    public static final String AM001_RESET_PASSWORD = "/AM/AM001/reset_password";

    // ------------------------------------------------------------------------
    // LIST ERROR
    // ------------------------------------------------------------------------
    public static final String PAGE_FORBIDDEN = "forward:/view/403.html";
    public static final String PAGE_NOT_FOUND = "forward:/view/404.html";
    public static final String ALL_ERROR = "forward:/view/500.html";
}
