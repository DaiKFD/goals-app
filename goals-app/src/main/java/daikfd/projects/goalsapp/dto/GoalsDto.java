package daikfd.projects.goalsapp.dto;


import daikfd.projects.goalsapp.entity.Plans;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class GoalsDto {
    private String id;

    private String name;

    private String description;

    private Plans plans;
}
