package com.service;

import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {
public boolean validateUser(User user) {
    if(user.getUsername().equals("validUser")) {
        return true;
    }
    return false;
}
}
