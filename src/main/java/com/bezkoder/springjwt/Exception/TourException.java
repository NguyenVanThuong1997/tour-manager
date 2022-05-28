package com.bezkoder.springjwt.Exception;

import javax.servlet.ServletException;

public class TourException extends ServletException {

    private static final String PERMISSION_DENIED = "Access denied";
    private static final String NOT_ALLOWED_ROLE = "you're not in charge of the tour so you can't watch。";

    public TourException(String message) {
        super(message);
    }

    public static TourException permissionDenied() {
        return new TourException(PERMISSION_DENIED);
    }

    public static TourException notAllowedRole() {
        return new TourException(NOT_ALLOWED_ROLE);
    }
}