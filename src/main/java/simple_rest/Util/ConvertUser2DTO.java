package simple_rest.Util;

import org.modelmapper.ModelMapper;
import simple_rest.dto.UserDTO;
import simple_rest.entity.User;

public class ConvertUser2DTO {
    public static UserDTO getUserDTO(User user){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }
}