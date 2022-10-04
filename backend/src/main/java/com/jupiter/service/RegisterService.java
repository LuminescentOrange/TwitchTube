package com.jupiter.service;

import com.jupiter.dao.RegisterDao;
import com.jupiter.entity.db.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {

        user.setPassword(com.jupiter.util.Util.encryptPassword(user.getUserId(), user.getPassword()));
        //generate encrypted password

        return registerDao.register(user);
    }
}
