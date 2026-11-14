package pl.wsb.kms.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.kms.workout.entity.WorkoutSession;

import java.util.List;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {

    List<WorkoutSession> findByTrainee_FullName(String fullName);

    List<WorkoutSession> findByPlanTemplate_Title(String title);
}
