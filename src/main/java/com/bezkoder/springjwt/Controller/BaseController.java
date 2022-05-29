package com.bezkoder.springjwt.Controller;

import com.bezkoder.springjwt.Exception.TourException;
import com.bezkoder.springjwt.models.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

public class BaseController {
    public static final String USER_NOT_FOUND = "user not found";
    protected static final String CONVERT_MASTERS = "convertMasters";
    protected static final String ACCOUNT_DATA = "accountData";

    // ID
    protected static final String ID = "ID";
    // attribute sort
    protected static final String SORT = "sort";
    // attribute sort property
    protected static final String SORT_PROPERTY = "property";
    // attribute direction
    protected static final String DIRECTION = "direction";
    // attribute page
    protected static final String PAGE = "page";
    // attribute size
    protected static final String SIZE = "size";
    // attribute size default
    protected static final int SIZE_DEFAULT = 20;
    // attribute page number
    protected static final String PAGE_NUMBERS = "pageNumbers";
    // attribute total page
    protected static final String TOTAL_PAGES = "totalPages";
    // attribute total record
    protected static final String TOTAL_RECORD = "totalRecord";
    // attribute search condition
    protected static final String SEARCH_CONDITION = "searchCondition";
    // attribute condition maps
    protected static final String CONDITION_MAPS = "conditionMaps";
    // attribute list url
    protected static final String LIST_URL = "listUrl";
    // attribute sort default
    protected static final String SORT_DEFAULT = "created";
    // attribute logout
    protected static final String LOGOUT = "logout";
    // attribute verified
    protected static final String VERIFIED = "verified";
    // attribute reset password
    protected static final String RESET_PASSWORD = "resetPassword";
    // attribute key
    protected static final String KEY = "key";
    // attribute hash
    protected static final String HASH = "hash";
    // attribute search
    protected static final String SEARCH = "search";
    // attribute facility code default
    protected static final String PAGE_SIZE_MAP = "pageSizeMaps";
    // attribute sideMenu
    protected static final String SIDE_MENU = "sideMenu";

    protected static final String SUCCESS = "success";

    protected static final String FAILURE = "failure";

    // set search condition of request
    private <T> void setSearchCondition(T searchCondition, Model model) {
        model.addAttribute(SEARCH_CONDITION, searchCondition);
    }

    // set search condition of request
    private <T> void setSearchCondition(Map<String, T> conditionMaps, Model model) {
        if (conditionMaps != null) {
            conditionMaps.forEach(model::addAttribute);
        }
    }

    // set condition maps
    private <T> void setConditionMap(Map<String, T> conditionMaps, Model model) {
        StringBuilder condition = new StringBuilder();
        condition.append("?page={page}");
        condition.append("&sort={sort}");
        if (conditionMaps != null) {
            conditionMaps.forEach((key, value) -> {
                if (Objects.nonNull(value)) {
                    condition.append("&");
                    condition.append(key);
                    condition.append("=");
                    condition.append(URLEncoder.encode((String) value, StandardCharsets.UTF_8));
                }
            });
        }
        model.addAttribute(CONDITION_MAPS, condition);
    }

    // set page size maps
    private <T> void setPageSizeMap(Map<String, T> conditionMaps, Sort sort, Model model) {
        StringBuilder condition = new StringBuilder();
        condition.append("?page=0");
        condition.append("&sort=");

        if (sort != null) {
            sort.stream().forEach(order -> {
                condition.append(order.getProperty());
                condition.append(",");
                condition.append(order.getDirection());
            });
        }

        if (conditionMaps != null) {
            conditionMaps.forEach((key, value) -> {
                if (Objects.nonNull(value)) {
                    condition.append("&");
                    condition.append(key);
                    condition.append("=");
                    condition.append(URLEncoder.encode((String) value, StandardCharsets.UTF_8));
                }
            });
        }

        model.addAttribute(PAGE_SIZE_MAP, condition);
    }

}
