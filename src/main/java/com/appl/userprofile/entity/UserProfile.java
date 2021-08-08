package com.appl.userprofile.entity;

import com.appl.userprofile.dto.UserProfileDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mortgage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //ИД пользователя
    private String name; //Имя
    private String pass; //Пароль
    private String nickName; //Псевдоним
    private String jndiName; //Имя JNDI
    private String description; //Описание
    private String category; //категория
    private String urlStr; //URL
    private long timeOutConnection; //Тайм-аут соединения
    private int maxNumberConn; //Максимальное число соединений
    private int minNumberConn; //Минимальное число соединен

    public static UserProfile makeDefault(UserProfileDTO userProfileDTO) {
        return builder()
                .name(userProfileDTO.getName())
                .pass(userProfileDTO.getPass())
                .nickName(userProfileDTO.getNickName())
                .jndiName(userProfileDTO.getJndiName())
                .description(userProfileDTO.getDescription())
                .category(userProfileDTO.getCategory())
                .urlStr(userProfileDTO.getUrlStr())
                .timeOutConnection(userProfileDTO.getTimeOutConnection())
                .maxNumberConn(userProfileDTO.getMaxNumberConn())
                .minNumberConn(userProfileDTO.getMinNumberConn())
                .build();
    }
}
