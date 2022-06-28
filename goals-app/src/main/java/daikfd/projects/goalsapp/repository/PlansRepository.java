package daikfd.projects.goalsapp.repository;

import daikfd.projects.goalsapp.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<Plans,String> {
}
