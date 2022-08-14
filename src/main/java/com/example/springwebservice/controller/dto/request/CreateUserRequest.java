package com.example.springwebservice.controller.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private int id;
    private String name;
    private int age;
}
