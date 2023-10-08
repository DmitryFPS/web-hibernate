package ru.orlov.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.orlov.entity.ClientProfile;
import ru.orlov.injectservice.InjectService;
import ru.orlov.service.BookRoomService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

/**
 * Servlet бронирование номеров
 */
@Slf4j
@WebServlet(urlPatterns = "/book_room/")
public class BookRoomServlet extends HttpServlet {

    /** Servlet создания брони нового клиента */
    @Override
    protected void doPost(final HttpServletRequest req,
                          final HttpServletResponse resp) throws IOException {
        log.info("Пришел запрос {} на URI: {}", req.getMethod(), req.getRequestURI());
        req.setCharacterEncoding("UTF-8");

        final ClientProfile clientProfile = requireNonNull(getBookRoomService()).addPersonToRoom(req);
    }

    /** Получаем объект из кастомного DI */
    private BookRoomService getBookRoomService() {
        try {
            return (BookRoomService) InjectService.getIngectObject(BookRoomService.class.getSimpleName());
        } catch (final Exception exc) {
            log.info("Ошибка получения объекта из DI {}", exc.getMessage());
            return null;
        }
    }
}