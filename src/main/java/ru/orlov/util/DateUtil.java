package ru.orlov.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

/**
 * Для работы с датами
 */
public class DateUtil {
    /**
     * Преобразование даты из строки в формате "yyyy-MM-dd", например "2023-10-09"
     *
     * @param dateStr строка даты
     * @return дата
     */
    public static LocalDate parseDateFromSimpleString(final String dateStr) {
        if (dateStr == null) {
            return null;
        }
        try {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            return asLocalDate(dateFormat.parse(dateStr));
        } catch (final ParseException exc) {
            return null;
        }
    }

    /**
     * Конвертируем String в LocalDate
     *
     * @param date дата
     * @return дата
     */
    private static LocalDate asLocalDate(final Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}