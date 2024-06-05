package joaopepe10.com.github.service;

import jakarta.inject.Singleton;
import joaopepe10.com.github.client.ExternalApiClient;
import joaopepe10.com.github.mapper.UserMapper;
import joaopepe10.com.github.model.ApiResponseBody;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import joaopepe10.com.github.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ExternalApiClient externalApiClient;

    @Override
    public UserResponse save(UserRequest userRequest){
        var user = userMapper.toUser(userRequest);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }

    @Override
    public List<UserResponse> findAll() {
        var users = userRepository.findAll();
        var usersResponse = new ArrayList<UserResponse>();
        for (var user : users){
            usersResponse.add(userMapper.userToUserResponse(user));
        }
        return usersResponse;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }
    @Override
    public Optional<ApiResponseBody> findApi(){
        var response = externalApiClient.response();
        if (response.isEmpty()){
            throw new IllegalArgumentException("Response is invalid");
        }
        return response;
    }
}
