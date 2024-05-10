package joaopepe10.com.github.mapper;

import joaopepe10.com.github.model.User;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JSR330)
public abstract class UserMapper {
    public abstract UserResponse userToUserResponse(User user);

    public abstract User toUser(UserRequest userRequest);
}
