package kz.yerz.greetgotechtask.service.Impl;

import kz.yerz.greetgotechtask.dto.LoginDTO;
import kz.yerz.greetgotechtask.dto.UserDTO;
import kz.yerz.greetgotechtask.entity.User;
import kz.yerz.greetgotechtask.repository.UserRepository;
import kz.yerz.greetgotechtask.response.LoginResponse;
import kz.yerz.greetgotechtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(UserDTO userDTO) {

        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setPassword(this.bCryptPasswordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);

        return user.getFullName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user =userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = bCryptPasswordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user2 = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user2.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new  LoginResponse("Login Failed", false);
                }
            } else {

                return new  LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
