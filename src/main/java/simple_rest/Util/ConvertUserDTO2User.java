package simple_rest.Util;

import org.modelmapper.ModelMapper;
import simple_rest.dto.UserDTO;
import simple_rest.entity.User;

public class ConvertUserDTO2User {
    public static User getUser(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}