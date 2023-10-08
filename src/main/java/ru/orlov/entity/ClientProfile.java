package ru.orlov.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Анкета посетителя
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ClientProfile {
    /** id посетителя */
    private Long id;
    /** имя посетителя */
    private String firstName;
    /** фамилия посетителя */
    private String lastName;
    /** отчество посетителя */
    private String secondName;
    /** дата рождения посетителя */
    private LocalDate birthdate;
    /** тип документа посетителя */
    private String document;
    /** номер документа посетителя */
    private String documentNumber;
    /** дата выдачи документа посетителя */
    private LocalDate documentDate;
    /** номер комнаты посетителя */
    private Integer numberRoom;
    /** комментарии */
    private String description;

    /**
     * Пустой конструктор
     */
    public ClientProfile() {
        // Пустой конструктор
    }

    /**
     * Конструктор
     *
     * @param firstName      имя посетителя
     * @param lastName       фамилия посетителя
     * @param secondName     отчество посетителя
     * @param birthdate      дата рождения посетителя
     * @param document       тип документа посетителя
     * @param documentNumber номер документа посетителя
     * @param documentDate   дата выдачи документа посетителя
     * @param numberRoom     номер комнаты посетителя
     * @param description    комментарии
     */
    public ClientProfile(final String firstName,
                         final String lastName,
                         final String secondName,
                         final LocalDate birthdate,
                         final String document,
                         final String documentNumber,
                         final LocalDate documentDate,
                         final Integer numberRoom,
                         final String description) {
        this.lastName = firstName;
        this.firstName = lastName;
        this.secondName = secondName;
        this.birthdate = birthdate;
        this.document = document;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.numberRoom = numberRoom;
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ClientProfile that = (ClientProfile) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}