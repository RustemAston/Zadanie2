package simple_rest.Util;

import org.modelmapper.ModelMapper;
import simple_rest.dto.One2ManyEntityDTO;
import simple_rest.entity.One2ManyEntity;

public class ConvertOne2ManyEntity2DTO {
    public static One2ManyEntityDTO getOne2ManyEntityDTO(One2ManyEntity one2ManyEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(one2ManyEntity, One2ManyEntityDTO.class);
    }
}
