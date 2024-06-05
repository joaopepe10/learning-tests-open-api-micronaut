package joaopepe10.com.github.service;

import joaopepe10.com.github.model.ApiResponseBody;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse save(UserRequest userRequest) throws Exception;
    List<UserResponse> findAll();
    UserResponse findById(Long id);

    Optional<ApiResponseBody> findApi();

}
