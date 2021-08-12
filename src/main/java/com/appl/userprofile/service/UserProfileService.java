package com.appl.userprofile.service;

import com.appl.userprofile.entity.UserProfile;
import com.appl.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile getUserProfileById(Long id){
        return userProfileRepository.getById(id);
    }
    public List<UserProfile> getAllUserProfile(){
        return userProfileRepository.findAll();
    }

    public UserProfile saveUserProfile(UserProfile userProfile){

        return userProfileRepository.saveAndFlush(userProfile);
    }
    public UserProfile updateUserProfile (UserProfile userProfile, Long id){
        Optional<UserProfile> temp = userProfileRepository.findById(id);
        if(!temp.isPresent()){
            throw new EntityNotFoundException("Entity with id-" + id+" not found!");
        }
        userProfile.setId(id);
        return userProfileRepository.saveAndFlush(userProfile);
    }
    public void deleteUserprofileById(Long id){
        userProfileRepository.deleteById(id);
    }

    public List<UserProfile> getAllByFilter(String name, String nickName){
        return  userProfileRepository.getByFilter(name, nickName);
    }
}
