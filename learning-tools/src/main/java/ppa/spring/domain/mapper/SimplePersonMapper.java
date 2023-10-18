package ppa.spring.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ppa.spring.domain.bean.SimplePerson;
import ppa.spring.domain.dto.SimplePersonDto;

@Mapper
public interface SimplePersonMapper {
    SimplePersonMapper INSTANCE = Mappers.getMapper(SimplePersonMapper.class);

    @Mapping(target = "id", ignore = true)
    SimplePerson dtoToPerson  (SimplePersonDto simplePersonDto);

    SimplePersonDto personToDto (SimplePerson simplePerson);
}
