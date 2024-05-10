package joaopepe10.com.github.service;

import joaopepe10.com.github.model.User;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse save(UserRequest userRequest) throws Exception;
    List<UserResponse> findAll();
    UserResponse findById(Long id);

}
