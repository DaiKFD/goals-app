package daikfd.projects.goalsapp.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Plans {
    @Id
    @GeneratedValue(generator = "plan_generator")
    @GenericGenerator(name = "plan_generator", strategy = "daikfd.projects.goalsapp.generator.PlanIdGenerator")
    @Column(name = "id")
    private String id;

    private String title;

    private Date deadline;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "plans")
    @ToString.Exclude
    private List<Goals> goals;


    @ManyToOne
    @JoinColumn(name = "periods_id", referencedColumnName = "id")
    private Periods periods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Plans plans = (Plans) o;
        return id != null && Objects.equals(id, plans.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
