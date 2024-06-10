package simple_rest.Util;

import org.modelmapper.ModelMapper;
import simple_rest.dto.Many2ManyEntityDTO;
import simple_rest.entity.Many2ManyEntity;

public class ConvertMany2ManyEntity2DTO {
    public static Many2ManyEntityDTO getMany2ManyEntityDTO(Many2ManyEntity many2ManyEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(many2ManyEntity, Many2ManyEntityDTO.class);
    }
}