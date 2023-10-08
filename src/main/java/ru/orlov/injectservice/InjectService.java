package ru.orlov.injectservice;

import ru.orlov.service.BookRoomService;
import ru.orlov.service.BookRoomServiceImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Кастомный DI */
public class InjectService {

    /** Кастомный контейнер DI */
    private static final Map<String, Object> INJECT_OBJECTS = new ConcurrentHashMap<>();

    static {
        INJECT_OBJECTS.put(BookRoomService.class.getSimpleName(), new BookRoomServiceImpl());
    }

    /** Получить объект из DI */
    public static Object getIngectObject(final String name) {
        if (name == null) {
            return null;
        }
        if (INJECT_OBJECTS.containsKey(name)) {
            return INJECT_OBJECTS.get(name);
        }
        return null;
    }
}