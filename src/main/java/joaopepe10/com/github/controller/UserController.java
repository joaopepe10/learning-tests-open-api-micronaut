package joaopepe10.com.github.controller;

import io.micronaut.http.annotation.Controller;
import joaopepe10.com.github.UserApi;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import joaopepe10.com.github.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/api/v1")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public UserResponse save(UserRequest userRequest) {
        var response = userService.save(userRequest);
        return response;
    }
}
