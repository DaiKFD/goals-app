package daikfd.projects.goalsapp.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Goals {

    @Id
    @GeneratedValue(generator = "plan_generator")
    @GenericGenerator(name = "plan_generator", strategy = "daikfd.projects.goalsapp.generator.PlanIdGenerator")
    @Column(name = "id")
    private String id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private Plans plans;

}
