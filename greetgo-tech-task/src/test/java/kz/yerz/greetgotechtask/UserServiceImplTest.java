package kz.yerz.greetgotechtask;

import kz.yerz.greetgotechtask.dto.LoginDTO;
import kz.yerz.greetgotechtask.dto.UserDTO;
import kz.yerz.greetgotechtask.entity.User;
import kz.yerz.greetgotechtask.repository.UserRepository;
import kz.yerz.greetgotechtask.response.LoginResponse;
import kz.yerz.greetgotechtask.service.Impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeClass
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@test.com");
        userDTO.setFullName("Test User");
        userDTO.setPassword("password");

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setPassword("encoded_password");

        when(bCryptPasswordEncoder.encode(userDTO.getPassword())).thenReturn("encoded_password");
        when(userRepository.save(user)).thenReturn(user);

        userService.addUser(userDTO);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testLoginUserSuccess() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@test.com");
        loginDTO.setPassword("password");

        User user = new User();
        user.setEmail(loginDTO.getEmail());
        user.setPassword("encoded_password");

        when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(user);
        when(bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword())).thenReturn(true);
        when(userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), user.getPassword())).thenReturn(Optional.of(user));

        LoginResponse response = userService.loginUser(loginDTO);

        assert response.getStatus();
        assert response.getMessage().equals("Login Success");
    }

    @Test
    public void testLoginUserWrongPassword() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("test@test.com");
        loginDTO.setPassword("wrong_password");

        User user = new User();
        user.setEmail(loginDTO.getEmail());
        user.setPassword("encoded_password");

        when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(user);
        when(bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword())).thenReturn(false);

        LoginResponse response = userService.loginUser(loginDTO);

        assert !response.getStatus();
        assert response.getMessage().equals("password Not Match");
    }

    @Test
    public void testLoginUserEmailNotExists() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("non_existing@test.com");
        loginDTO.setPassword("password");

        when(userRepository.findByEmail(loginDTO.getEmail())).thenReturn(null);

        LoginResponse response = userService.loginUser(loginDTO);

        assert !response.getStatus();
        assert response.getMessage().equals("Email not exists");
    }
}
