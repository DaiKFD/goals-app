package daikfd.projects.goalsapp.service;

import daikfd.projects.goalsapp.dto.GoalsDto;
import daikfd.projects.goalsapp.entity.Goals;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface GoalsService {
    Goals createGoals(String id, GoalsDto goalsDto) throws NotFoundException;
}
