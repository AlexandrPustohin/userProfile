package com.appl.userprofile.repository;

import com.appl.userprofile.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    @Query("SELECT u FROM UserProfile u WHERE "+
            "LOWER(u.name) LIKE LOWER(CONCAT('%',:name,'%')) AND "+
            "LOWER(u.nickName) LIKE LOWER(CONCAT('%',:nickName,'%')) "

    )
    List<UserProfile> getByFilter(String name, String nickName);
}
