package com.FitBitProject.FitBit.UserController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FitBitProject.FitBit.Model.UserM;
import com.FitBitProject.FitBit.Repositary.UserRepo;
import com.FitBitProject.FitBit.Service.UserServiceIMPL;
import com.FitBitProject.FitBit.exception.RosourceNotFound;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCon {
    @Autowired
    UserServiceIMPL obj;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/index")
    public String indexPage() {

        System.out.println("this is index page");
        return "index";
    }

    @GetMapping("/SignupUser")
    public String signInPage() {

        return "SignupUser";
    }

    @PostMapping("/signInUser")
    public ResponseEntity<UserM> signuppage(@RequestBody UserM a) {
        obj.addUser(a);
        System.out.println("User Added");
        System.out.println(a);
        return ResponseEntity.ok(a);
    }

    @GetMapping("/uend")
    public String endpage() {
        return "uend";
    }

    @GetMapping("/signInUser")
    public String signInpage() {
        return "signInuser";
    }

    @GetMapping("/blogs")
    public String blogsPage() {
        return "blogs";
    }

    @GetMapping("/performance")
    public String performancPage() {
        return "performance";
    }

    @GetMapping("/nutritions")
    public String nutritionsPage() {
        return "nutritions";
    }

    @GetMapping("/workoutPlans")
    public String workoutPlansPage() {
        return "workoutPlans";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassPage() {
        return "forgotPassword";
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {
        UserM user = userRepo.findById(id)
                .orElseThrow(() -> new RosourceNotFound("Member not exist with id :" + id));

        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable int id, Model model) {
        UserM user = obj.getUserById(id);

        System.out.println(user);
        return "index";
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserM> updateUser(@PathVariable int id, @RequestBody UserM userDetails) {
        UserM user = obj.getUserById(id);

        user.setUname(userDetails.getUname());

        user.setUemail(userDetails.getUemail());
        user.setUmob(userDetails.getUmob());
        user.setUpassword(userDetails.getUpassword());
        user.setUconfirmpass(userDetails.getUconfirmpass());
        UserM updatedUser = obj.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<UserM> showAllUsers() {
        return obj.getAllUsers();
    }

    @PostMapping("/index")
    public String login(@RequestParam String uemail, @RequestParam String upassword, Model model) {
        UserM user = obj.findByUemail(uemail);

        if (user != null && user.getUpassword().equals(upassword) && user.getUemail().equals(uemail)) {
            System.out.println("Logged in successfully");
            return "index";
        } else {
            System.out.println("login failed");
            return "signInUser";
        }
    }

}