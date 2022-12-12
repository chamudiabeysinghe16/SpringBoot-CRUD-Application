package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>  { //<Entity type name, User's ID type>

    @Query(value="SELECT * FROM USER WHERE ID=?1",nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value="SELECT * FROM User WHERE ID=?1 AND ADDRESS=?2",nativeQuery = true)
    User getUserByUserIDAndAddress(String userId, String address);

    //If you are updating the query you have to put the annotation @Modifying and @Query

}
