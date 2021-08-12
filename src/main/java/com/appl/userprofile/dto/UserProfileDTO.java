package com.appl.userprofile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class UserProfileDTO {

    private long id; //ИД пользователя
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String name; //Имя
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String pass; //Пароль
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String nickName; //Псевдоним
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String jndiName; //Имя JNDI
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String description; //Описание
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String category; //категория
    
	@NotEmpty(message = "Поле не должно быть пустым!")
    private String urlStr; //URL

    @Max(1000)
    @Min(0)
    private long timeOutConnection; //Тайм-аут соединения

    @Max(1000)
    @Min(0)
    private int maxNumberConn; //Максимальное число соединений

    @Max(10000)
    @Min(0)
    private int minNumberConn; //Минимальное число соединен

}
