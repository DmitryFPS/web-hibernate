package ru.orlov.util;

import static java.util.Optional.ofNullable;

/**
 * Для работы со строками
 */
public class StringUtil {
    /**
     * Конвертируем String в Integer
     *
     * @param value строка
     * @return целое число
     */
    public static Integer convertStringValueToInteger(final String value) {
        try {
            return ofNullable(value).map(Integer::parseInt).orElse(null);
        } catch (final Exception exc) {
            return null;
        }
    }
}