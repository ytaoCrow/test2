package com.example.springwebservice.controller;

import com.example.springwebservice.controller.dto.response.StatusResponse;
import com.example.springwebservice.controller.dto.request.CreateUserRequest;
import com.example.springwebservice.controller.dto.request.UpdateUserRequest;
import com.example.springwebservice.model.entity.User;
import com.example.springwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getAllUsers() {
        List<User>response=this.userService.getUserList();
        return response;
    }
    //@PathVariable 唯一識別
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        User response=this.userService.getUserById(id);
        return response;
    }

    @PostMapping()
    public StatusResponse createUser(@RequestBody CreateUserRequest request) {
        String response=(this.userService.createUser(request));
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateUser(@PathVariable int id,@RequestBody UpdateUserRequest request) {
        String response=this.userService.updateUser(id,request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteUser(@PathVariable int id) {
        String reponse =this.userService.deleteUser(id);

        return new StatusResponse(reponse);
    }
} // Class end
