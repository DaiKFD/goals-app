package daikfd.projects.goalsapp.mapper;

import daikfd.projects.goalsapp.dto.PlansDto;
import daikfd.projects.goalsapp.entity.Plans;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlansMapper {

    //    @Mapping(target = "id", source = "branch.id")
//    @Mapping(target = "name", source = "branch.name")
//    @Mapping(target = "address", source = "branch.address")
//    @Mapping(target = "phoneNumber", source = "branch.phoneNumber")
//    @Mapping(target = "note", source = "branch.note")
    PlansDto plansToPlansDto(Plans plans);

    Plans plansDtoToPlans(PlansDto plansDto);

}
