package com.appl.userprofile.DTOfactory;

import com.appl.userprofile.dto.UserProfileDTO;
import com.appl.userprofile.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DTOfactory {


    public UserProfileDTO createUserProfileDTO(UserProfile userProfile){
    return  UserProfileDTO.builder()
            .id(userProfile.getId())
            .pass(userProfile.getPass())
            .name(userProfile.getName())
            .nickName(userProfile.getNickName())
            .jndiName(userProfile.getJndiName())
            .description(userProfile.getDescription())
            .category(userProfile.getCategory())
            .urlStr(userProfile.getUrlStr())
            .timeOutConnection(userProfile.getTimeOutConnection())
            .maxNumberConn(userProfile.getMaxNumberConn())
            .minNumberConn(userProfile.getMinNumberConn())
            .build();
    }
    public List<UserProfileDTO> createListUserProfileDTO(List<UserProfile> userProfiles){
        return userProfiles
                .stream()
                .map(this::createUserProfileDTO)
                .collect(Collectors.toList());
    }


}
