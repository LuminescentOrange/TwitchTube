package com.jupiter.service;

import com.jupiter.dao.LoginDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public String verifyLogin(String userId, String password) throws IOException {

        password = com.jupiter.util.Util.encryptPassword(userId, password);
        //generate encrypted password

        return loginDao.verifyLogin(userId, password);
    }
}
