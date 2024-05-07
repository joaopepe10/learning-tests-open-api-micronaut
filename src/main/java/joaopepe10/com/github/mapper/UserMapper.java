package joaopepe10.com.github.mapper;

import joaopepe10.com.github.model.User;
import joaopepe10.com.github.model.UserRequest;
import joaopepe10.com.github.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JSR330)
public abstract class UserMapper {

    /*public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);*/

    public abstract UserResponse userToUserResponse(User user);

    public abstract User userRequestToUser(UserRequest userRequest);
}
