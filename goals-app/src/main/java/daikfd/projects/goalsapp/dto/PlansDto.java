package daikfd.projects.goalsapp.dto;

import daikfd.projects.goalsapp.entity.Goals;
import daikfd.projects.goalsapp.entity.Periods;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PlansDto {

    private String id;
    @NotBlank(message = "{plans.title.validation}")
    private String title;
    @Future(message = "{plans.deadline.future.validation}")
    @NotNull(message = "{plans.deadline.validation}")
    private Date deadline;
    private List<Goals> goals;
    private Periods periods;

}
