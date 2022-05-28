package com.bezkoder.springjwt.models;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * BaseConst
 */
public class BaseConst {

    // Session attribute user login
    public static final String USER_SESSION = "userSession";
    // Redirect prefix
    public static final String REDIRECT = "redirect:";
    // Error
    public static final String ERROR = "error";
    // not found
    public static final String NOT_FOUND = "not_found";
    // User ID
    public static final String UID = "uid";
    // text/html
    public static final String MAIL_TYPE = "text/html";
    // mail/send
    public static final String MAIL_ENDPOINT = "mail/send";
    // locked
    public static final String LOCKED = "locked";
    // File extensions csv
    public static final String CSV = ".csv";
    public static final String EXTENSION_CSV = "csv";
    // File extensions PDF
    public static final String PDF = ".pdf";
    // File extensions DAT
    public static final String DAT = ".DAT";
    // File extensions ZIP
    public static final String ZIP = ".zip";
    public static final String EXTENSION_ZIP = "zip";
    // Zero
    public static final int ZERO = 0;
    // One
    public static final int ONE = 1;
    // Two
    public static final int TWO = 2;
    // Three
    public static final int THREE = 3;
    // Four
    public static final int FOUR = 4;
    // Five
    public static final int FIVE = 5;
    // Six
    public static final int SIX = 6;
    // Seven
    public static final int SEVEN = 7;
    // Eight
    public static final int EIGHT = 8;
    // Nine
    public static final int NINE = 9;
    // Ten
    public static final int TEN = 10;
    // Charset Shift-JIS
    public static final Charset CHARSET_SHIFT_JIS = Charset.forName("Shift-JIS");
    // Charset Cp1047
    public static final Charset CHARSET_CP1047 = Charset.forName("Cp1047");
    // SUB character
    public static final String SUB_CHARACTER = "\u001A";
    // File type filter
    public static final List<String> FILE_TYPE_FILTERS = Arrays.asList("txt", "dat", "csv", "zip");
    // File type to merge
    public static final List<String> FILE_TYPE_TO_MERGES = Arrays.asList("txt", "dat", "csv");
    // Connect to listening server fail
    public static final String E0001 = "E0001";
    // Receiving server diAMble
    public static final String E0002 = "E0002";
    // Connect to receiving server fail
    public static final String E0003 = "E0003";
    // Send file to receiving server fail
    public static final String E0004 = "E0004";
    // File on receiving server exist
    public static final String E0005 = "E0005";
    // Copy file from listening server fail
    public static final String E0006 = "E0006";
    // Create file backup fail
    public static final String E0007 = "E0007";
    // Merge file fail
    public static final String E0008 = "E0008";
    // Unzip file require password
    public static final String E0009 = "E0009";
    // Unzip file fail
    public static final String E0010 = "E0010";
    // File size is too large
    public static final String E0011 = "E0011";
    // The file extension is not yet supported
    public static final String E0012 = "E0012";
    // The extracted file has an error
    public static final String E0013 = "E0013";
    // Target server has not setup share folder yet
    public static final String E0014 = "E0014";
    // Default times retry for batch
    public static final int timesRetry = 5;
    // Max file size
    public static final long MAX_FILE_SIZE = 1932735283L;
    // number of days to delete files
    public static final int DAY_DELETE_FILE_BACKUP = 30;
    // Set header
    public static final String CONTENT_DISPOSITION = "Content-disposition";
    public static final String ATTACHMENT_FILENAME = "attachment;filename=";
}

