package daikfd.projects.goalsapp.mapper;

import daikfd.projects.goalsapp.dto.GoalsDto;
import daikfd.projects.goalsapp.entity.Goals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoalsMapper {
     GoalsDto goalsToGoalsDto(Goals goals);
     Goals goalsDtoToGoals(GoalsDto goalsDto);
}
