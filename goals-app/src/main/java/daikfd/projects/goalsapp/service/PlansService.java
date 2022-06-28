package daikfd.projects.goalsapp.service;

import daikfd.projects.goalsapp.dto.PlansDto;
import daikfd.projects.goalsapp.entity.Plans;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlansService {
    Plans createPlans(PlansDto plansDto);

    List<PlansDto> PLANS_DTO_LIST();

    PlansDto getPlansById(String id) throws NotFoundException;
}
