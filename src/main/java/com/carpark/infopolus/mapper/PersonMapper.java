package com.carpark.infopolus.mapper;

import com.carpark.infopolus.dto.PersonDto;
import com.carpark.infopolus.model.CarModel;
import com.carpark.infopolus.model.PersonModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  PersonDto mapPersonModelToPersonDto(PersonModel personModel, List<CarModel> cars);

}
