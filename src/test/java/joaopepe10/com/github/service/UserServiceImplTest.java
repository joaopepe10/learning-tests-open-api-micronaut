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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;

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

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    private User user;

    private UserRequest userRequest;

    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(20L)
                .createdAt(ZonedDateTime.now())
                .name("Joao Pedro")
                .build();
        userRequest = new UserRequest(user.getName());

        userResponse = new UserResponse()
                .id(user.getName())
                .createdAt(user.getCreatedAt());
    }

    @Test
    @DisplayName("Should save user with success")
    void shouldSaveUserWithSuccess() throws Exception {
        when(userMapper.toUser(any())).thenReturn(user);
        when(userRepository.save(userArgumentCaptor.capture())).thenReturn(user);
        when(userMapper.userToUserResponse(any())).thenReturn(userResponse);

        var userSaved = userService.save(userRequest);
        verify(userMapper, times(1)).toUser(any());
        verify(userRepository, times(1)).save(any());

        var userCaptured = userArgumentCaptor.getValue();
        assertThat(userSaved).isNotNull();
        assertThat(userSaved.getName()).isEqualTo(userCaptured.getName());
        assertThat(userSaved.getCreatedAt()).isEqualTo(userCaptured.getCreatedAt());
    }

    @Test
    @DisplayName("shouldReturnListWhenHaveUserInRepository")
    void shouldReturnListWhenHaveUserInRepository(){
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userMapper.userToUserResponse(any())).thenReturn(userResponse);

        var response = userService.save(any());

        assertThat(response).isNotNull();
    }

}