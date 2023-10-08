package ru.orlov.service;

import ru.orlov.entity.ClientProfile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**  */
public interface BookRoomService {

    /**  */
    ClientProfile addPersonToRoom(final HttpServletRequest req) throws IOException;
}