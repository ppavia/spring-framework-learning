package ppa.spring.springframework.dataaccess.utils;

import java.util.Optional;

public final class StringUtils {
    private StringUtils() {}

    public static boolean isNotBlank(String str) {
        return Optional.ofNullable(str).map(String::isBlank).orElse(true);
    }

    public static boolean isNotEmpty(String str) {
        return Optional.ofNullable(str).map(String::isEmpty).orElse(true);
    }
}
