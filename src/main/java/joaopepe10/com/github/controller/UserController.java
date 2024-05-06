package joaopepe10.com.github.controller;

import io.micronaut.http.annotation.Controller;
import joaopepe10.com.github.UserApi;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;

import java.time.ZonedDateTime;
import java.util.UUID;

@Controller("/api/v1")
public class UserController implements UserApi {
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse response = new UserResponse();
        response.setCreatedAt(ZonedDateTime.now());
        response.setName("Joao Pedro");
        response.setId(String.valueOf(UUID.randomUUID()));
        return response;
    }
}
