package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.*;

/**
 * Модель представления о стране.
 */
public class Country {

    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
    @Override
    public boolean equals(Object country) {
        if (country instanceof Country) {
            return this.name.equalsIgnoreCase(((Country) country).name)
                    && this.code.equalsIgnoreCase(((Country) country).code);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    /**
     * Возвращает экземпляр страны созданный из переданного текста в формате
     * 'Код:Название'.
     *
     * @param text текст в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка имеет неверный
     * формат.
     */
    public static Country valueOf(String text) throws ParseException {
        text.trim();
        if (!text.isEmpty()
                && text.contains(":")) {
            
            int index = text.indexOf(':');
            String code = text
                    .substring(0, index)
                    .trim();
            String name = text.substring(index + 1)
                    .trim();
            Country country = new Country(code, name); 
            return  country; 
        }
    
            throw new ParseException("Inncorrect format", 0);
        
        }
    }
