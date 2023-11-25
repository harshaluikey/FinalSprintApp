package com.FitBitProject.FitBit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FitBitProject.FitBit.Model.UserM;
import com.FitBitProject.FitBit.Repositary.UserRepo;

@Service
public class UserServiceIMPL implements UserService {
  @Autowired
  UserRepo obj;

  @Override
  public void addUser(UserM user) {
    obj.save(user);
  }

  @Override
  public UserM getUserById(int id) {
    return obj.findById(id).orElse(null);
  }

  @Override
  public java.util.List<UserM> getAllUsers() {
    return obj.findAll();
  }

  public void addAttribute(String string, java.util.List<UserM> users) {
  }

  public UserM findByUemail(String uemail) {
    return obj.findByUemail(uemail);
  }

  @Override
  public UserM updateUser(UserM user) {
    UserM existingUser = obj.findByUemail(user.getUemail());

    if (existingUser != null) {
      existingUser.setUname(user.getUname());

      existingUser.setUemail(user.getUemail());
      existingUser.setUmob(user.getUmob());
      existingUser.setUpassword(user.getUpassword());
      existingUser.setUconfirmpass(user.getUconfirmpass());

      return obj.save(existingUser);
    }

    return null;
  }

  public UserM save(UserM user) {
    return user;
  }

}
