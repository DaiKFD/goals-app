package daikfd.projects.goalsapp.service.impl;

import daikfd.projects.goalsapp.dto.GoalsDto;
import daikfd.projects.goalsapp.entity.Goals;
import daikfd.projects.goalsapp.entity.Plans;
import daikfd.projects.goalsapp.mapper.GoalsMapper;
import daikfd.projects.goalsapp.repository.GoalsRepository;
import daikfd.projects.goalsapp.repository.PlansRepository;
import daikfd.projects.goalsapp.service.GoalsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoalsServiceImpl implements GoalsService {

    @Autowired
    GoalsMapper goalsMapper;

    @Autowired
    GoalsRepository goalsRepository;

    @Autowired
    PlansRepository plansRepository;

    @Override
    public Goals createGoals(String id, GoalsDto goalsDto) throws NotFoundException {
        Optional<Plans> plansOptional = plansRepository.findById(id);

        if(plansOptional.isEmpty()) {
            throw new NotFoundException("id-" + id);
        }
        Plans plans = plansOptional.get();
        goalsDto.setPlans(plans);
      return goalsRepository.save(goalsMapper.goalsDtoToGoals(goalsDto));
    }
}
