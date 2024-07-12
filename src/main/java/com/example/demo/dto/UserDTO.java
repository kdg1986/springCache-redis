package com.example.demo.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String id;
    private String username;
    private String email;
    private String password;
    private String created_at;   
}
