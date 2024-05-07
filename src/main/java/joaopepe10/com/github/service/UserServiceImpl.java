package joaopepe10.com.github.service;

import jakarta.inject.Singleton;
import joaopepe10.com.github.mapper.UserMapper;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import joaopepe10.com.github.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse save(UserRequest userRequest) {
        var user = userMapper.userRequestToUser(userRequest);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }

    @Override
    public List<UserResponse> findAll() {
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }
}
