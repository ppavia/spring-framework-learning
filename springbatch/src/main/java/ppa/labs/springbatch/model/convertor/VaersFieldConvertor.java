package ppa.labs.springbatch.model.convertor;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaersFieldConvertor {
    private final static Pattern START_POINT_PATTERN = Pattern.compile("/^./");
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public long fieldLongConvertor(String field) {
        try {
            return Long.parseLong(field);
        }
        catch(NumberFormatException e) {
            return 0L;
        }
    }

    public int fieldIntegerConvertor(String field) {
        try {
            return Integer.parseInt(field);
        }
        catch(NumberFormatException e) {
            return 0;
        }
    }

    public float fieldFloatConvertor(String field) {
        String fieldConverted = fieldNumericConvertor(field);
        Matcher matcher = START_POINT_PATTERN.matcher(fieldConverted);
        if(matcher.matches()) {
            return 0f;
        }
        try {
            return Float.parseFloat(fieldConverted);
        }
        catch(NumberFormatException e) {
            return 0f;
        }
    }

    public LocalDate fieldLocalDateConvertor(String field) {
        try {
            return LocalDate.parse(field, DATE_TIME_FORMATTER);
        }
        catch(DateTimeParseException e) {
            return null;
        }
    }

    public String fieldNumericConvertor(String field) {
        if(!StringUtils.hasLength(field) || "n/a".equals(field.toLowerCase())) {
            return "0";
        }
        return field;
    }
}
