package kz.yerz.greetgotechtask.service;

import kz.yerz.greetgotechtask.dto.LoginDTO;
import kz.yerz.greetgotechtask.dto.UserDTO;
import kz.yerz.greetgotechtask.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
