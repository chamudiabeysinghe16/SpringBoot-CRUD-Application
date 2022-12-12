package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service--> Saving details are going to --> UserRepo

@Service
@Transactional

public class UserService {

    //UserController class (PostMapping- saveUser)--> Take into UserService class ---> Saving in the UserRepo class through the UserService class by INJECTING(@AUTOWIRED)

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        //Taking data using UserDTO class--> Data Transfer Object
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    //User id --> user details
    // select * from User where id=2;

    public UserDTO getUserByUserID(String userID){

        User user= userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class);
    }

    //user id, address--> user details
    // select * from user where id=2 and address= "matara";

    public UserDTO getUserByUserIDAndAddress(String userId, String address){
         User user= userRepo.getUserByUserIDAndAddress(userId, address);
         return  modelMapper.map(user, UserDTO.class);
    }
}
