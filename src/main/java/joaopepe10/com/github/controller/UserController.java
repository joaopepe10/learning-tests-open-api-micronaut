package joaopepe10.com.github.controller;


import io.micronaut.http.annotation.Controller;
import jakarta.validation.Valid;
import joaopepe10.com.github.UserApi;
import joaopepe10.com.github.model.ApiResponseBody;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import joaopepe10.com.github.service.UserService;

import java.util.List;

@Controller("/api/v1")
public class UserController implements UserApi {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<@Valid UserResponse> findAll() {
        return null;
    }

    @Override
    public UserResponse findById(Integer id) {
        return null;
    }

    @Override
    public ApiResponseBody findRequest() {
        return userService.findApi()
                .orElseThrow(() -> new RuntimeException("Object is invalid"));
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        try {
            userService.findApi();
            return userService.save(userRequest);
        } catch (Exception e) {
            throw new RuntimeException("Do not possible register this user: " + e.getMessage());
        }
    }

}
