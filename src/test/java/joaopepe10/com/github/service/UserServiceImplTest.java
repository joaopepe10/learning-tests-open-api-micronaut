package joaopepe10.com.github.service;

import joaopepe10.com.github.mapper.UserMapper;
import joaopepe10.com.github.model.User;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import joaopepe10.com.github.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private User user;

    private UserRequest userRequest;

    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(20L)
                .createdAt(ZonedDateTime.now())
                .name("Joao Pedro")
                .email("joao123@gmail.com")
                .build();
        userRequest = new UserRequest("Joao Pedro");

        userResponse = new UserResponse();
        userResponse.setCreatedAt(ZonedDateTime.now());
        userResponse.setId("id");
        userResponse.setName("Joao Pedro");
    }

    @Test
    @DisplayName("Should save user with success")
    void shouldSaveUserWithSuccess() throws Exception {
        when(userMapper.toUser(any())).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);
        when(userMapper.userToUserResponse(any())).thenReturn(userResponse);

        var userSaved = userService.save(userRequest);
        verify(userMapper, times(1)).toUser(any());
        verify(userRepository, times(1)).save(any());

        assertThat(userSaved).isNotNull();
    }

    @Test()
    @DisplayName("Should do not save when user is null")
    void shouldDoNotSaveWhenUserIsNull() throws Exception {
//        when(re)
    }
}