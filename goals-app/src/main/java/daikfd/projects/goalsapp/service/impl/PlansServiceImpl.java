package daikfd.projects.goalsapp.service.impl;

import daikfd.projects.goalsapp.dto.PlansDto;
import daikfd.projects.goalsapp.entity.Plans;
import daikfd.projects.goalsapp.mapper.PlansMapper;
import daikfd.projects.goalsapp.repository.PlansRepository;
import daikfd.projects.goalsapp.service.PlansService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    PlansRepository plansRepository;

    @Autowired
    PlansMapper plansMapper;

    @Override
    public Plans createPlans(PlansDto plansDto) {
        return plansRepository.save(plansMapper.plansDtoToPlans(plansDto));
    }

    @Override
    public List<PlansDto> PLANS_DTO_LIST() {
        return plansRepository.findAll().stream().map(plansMapper::plansToPlansDto).collect(Collectors.toList());
    }

    @Override
    public PlansDto getPlansById(String id) throws NotFoundException {
        if(plansRepository.findById(id).isEmpty()){
            throw new NotFoundException("id-"+id);
        }
        return plansMapper.plansToPlansDto(plansRepository.findById(id).get());
    }
}
