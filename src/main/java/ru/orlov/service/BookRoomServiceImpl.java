package ru.orlov.service;

import com.fasterxml.jackson.databind.JsonNode;
import ru.orlov.entity.ClientProfile;
import ru.orlov.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ru.orlov.util.DateUtil.parseDateFromSimpleString;
import static ru.orlov.util.StringUtil.convertStringValueToInteger;

/**
 * Сервис регистрации нового посетителя
 */
public class BookRoomServiceImpl implements BookRoomService {

    /**
     * Бронирует номер новому посетителю
     */
    public ClientProfile addPersonToRoom(final HttpServletRequest req) throws IOException {
        final JsonNode jsonNode = JsonUtil.convertStringToJson(req.getInputStream());
        ClientProfile clientProfile = null;
        if (jsonNode != null) {
            clientProfile = new ClientProfile(
                    jsonNode.get("firstName").asText(),
                    jsonNode.get("lastName").asText(),
                    jsonNode.get("secondName").asText(),
                    parseDateFromSimpleString(jsonNode.get("birthdate").asText()),
                    jsonNode.get("document").asText(),
                    jsonNode.get("documentNumber").asText(),
                    parseDateFromSimpleString(jsonNode.get("documentDate").asText()),
                    convertStringValueToInteger(jsonNode.get("numberRoom").asText()),
                    jsonNode.get("description").asText()
            );
        }
        return clientProfile;
    }
}