package daikfd.projects.goalsapp.controller;

import daikfd.projects.goalsapp.dto.GoalsDto;
import daikfd.projects.goalsapp.dto.PlansDto;
import daikfd.projects.goalsapp.service.GoalsService;
import daikfd.projects.goalsapp.service.PlansService;
import daikfd.projects.goalsapp.utils.Utils;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static daikfd.projects.goalsapp.utils.Constants.LINK_API;
import static daikfd.projects.goalsapp.utils.Constants.LINK_ID;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(LINK_API+"/plans")
@AllArgsConstructor
public class PlansController {

    @Autowired
    PlansService plansService;

    @Autowired
    GoalsService goalsService;

    @GetMapping
    public List<PlansDto> retrieveAllPlans(){
        return plansService.PLANS_DTO_LIST();
    }

    @GetMapping(LINK_ID)
    public EntityModel<PlansDto> retrievePlans(@PathVariable String id) throws NotFoundException {
        EntityModel<PlansDto> resource = EntityModel.of(plansService.getPlansById(id));

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPlans());

        resource.add(linkTo.withRel("all-plans"));

        // HATEOAS
        return resource;
    }


    @PostMapping
    public ResponseEntity<Object> createPlans(@Valid @RequestBody PlansDto plansDto) {
        return Utils.createdPath(plansService.createPlans(plansDto).getId());
    }

    @PostMapping(LINK_ID+"/goals")
    public ResponseEntity<Object> createGoal(@PathVariable String id,@Valid  @RequestBody GoalsDto goalsDto)
            throws NotFoundException {
        return Utils.createdPath(goalsService.createGoals(id,goalsDto).getId());
    }
}
