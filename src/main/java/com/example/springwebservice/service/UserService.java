package com.example.springwebservice.service;

import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.UserRepository;
import com.example.springwebservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    List<User> userList;
    @Autowired
    private UserRepository userRepository;


    public List<User> getUserList() {
        List<User> response = userRepository.findAll();
        return response;
    }

    public User getUserById(int id) {

        return this.userRepository.findById(id);
    }

    public String createUser(CreateUserRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setAge(request.getAge());
        this.userRepository.save(user);
        return "OK";
    }

    public String updateUser(int id, UpdateUserRequest request) {

//        User getUser=getUserById(id);
        User getUser = this.userRepository.findById(id);
        if (null == getUser) {
            return "Fail";
        } else {
            getUser.setName(request.getName());
            getUser.setAge(request.getAge());
            this.userRepository.save(getUser);
            return "ok";
        }
//        if (getUser !=null){

//        }


    }

    public String deleteUser(int id) {
        User user=this.userRepository.findById(id);
        if (null != user){
            //            this.userRepository.delete(user);
            this.userRepository.deleteById(id);

            return "ok";
        }else {

            return "Fail";
        }

    }
} // Class end
