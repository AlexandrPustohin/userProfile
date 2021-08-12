package com.appl.userprofile.controller;

import com.appl.userprofile.DTOfactory.DTOfactory;
import com.appl.userprofile.dto.FilterDTO;
import com.appl.userprofile.dto.UserProfileDTO;
import com.appl.userprofile.entity.UserProfile;
import com.appl.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@Transactional
@RequestMapping("/api")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    @Autowired
    DTOfactory dtoFactory;
    @GetMapping("/users")
    public ResponseEntity<List<UserProfileDTO>> getAllUserProfile(){
        return ResponseEntity.ok(dtoFactory.createListUserProfileDTO(userProfileService.getAllUserProfile()));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserProfileDTO> getAllUserProfile(@PathVariable Long id){
        return ResponseEntity.ok(dtoFactory.createUserProfileDTO(userProfileService.getUserProfileById(id)));
    }

    @PostMapping("/user")
    public ResponseEntity saveUserProfile(@Valid @RequestBody UserProfileDTO userProfileDTO){
        UserProfile userProfile =  userProfileService.saveUserProfile(UserProfile.makeDefault(userProfileDTO));
        return ResponseEntity.ok(dtoFactory.createUserProfileDTO(userProfile));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        userProfileService.deleteUserprofileById(id);
        return ResponseEntity.ok(null);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserProfile(@RequestBody UserProfileDTO userProfileDTO, @PathVariable Long id){
        UserProfile userProfile = userProfileService.updateUserProfile(UserProfile.makeDefault(userProfileDTO), id);
        return ResponseEntity.ok(dtoFactory.createUserProfileDTO(userProfile));
    }
    @PostMapping ("/filter")
    public ResponseEntity<List<UserProfileDTO>> getByFilter(@RequestBody FilterDTO filterDTO){
        String  name = "";
        String nickName = "";
        if (filterDTO.getName()!=null) {
            name = filterDTO.getName().trim();
        }
        if (filterDTO.getNickName()!=null) {
            nickName = filterDTO.getNickName().trim();
        }
        return  ResponseEntity.ok(dtoFactory.createListUserProfileDTO(userProfileService.getAllByFilter(name, nickName)));
    }


}
