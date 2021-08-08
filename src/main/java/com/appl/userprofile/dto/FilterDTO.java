package com.appl.userprofile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterDTO {
    private String name; //Имя
    private String nickName; //Псевдоним
    private String jndiName; //Имя JNDI
    private String description; //Описание
    private String category; //категория
    private String urlStr; //URL
    private long timeOutConnection; //Тайм-аут соединения
    private int maxNumberConn; //Максимальное число соединений
    private int minNumberConn; //Минимальное число соединен
}
