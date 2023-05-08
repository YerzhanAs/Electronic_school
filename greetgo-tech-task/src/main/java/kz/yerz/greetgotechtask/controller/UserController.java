package kz.yerz.greetgotechtask.controller;


import kz.yerz.greetgotechtask.dto.LoginDTO;
import kz.yerz.greetgotechtask.dto.UserDTO;
import kz.yerz.greetgotechtask.response.LoginResponse;
import kz.yerz.greetgotechtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO){

        System.out.println(userDTO.getFullName());
        String id=userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){

        LoginResponse loginMessage=userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
