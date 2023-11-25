package com.FitBitProject.FitBit.Service;

import java.util.List;

import com.FitBitProject.FitBit.Model.UserM;

public interface UserService {
    public void addUser(UserM user);
    public UserM getUserById(int id);
    UserM updateUser(UserM user);
    public List<UserM> getAllUsers();
}
