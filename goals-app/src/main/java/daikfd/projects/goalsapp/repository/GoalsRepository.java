package daikfd.projects.goalsapp.repository;

import daikfd.projects.goalsapp.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals,String> {
}
