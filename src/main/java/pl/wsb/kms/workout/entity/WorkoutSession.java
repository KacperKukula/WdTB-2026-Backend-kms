package pl.wsb.kms.workout.entity;

import jakarta.persistence.*;
import pl.wsb.kms.plan.entity.TrainingPlanTemplate;
import pl.wsb.kms.trainee.entity.TraineeProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_session")
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainee_profile_id", nullable = false)
    private TraineeProfile trainee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_plan_template_id")
    private TrainingPlanTemplate planTemplate;

    @Column(name = "performed_at", nullable = false)
    private LocalDateTime performedAt;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    // skala RPE 1-10
    @Column(name = "perceived_effort", nullable = false)
    private Integer perceivedEffort;

    @Column(name = "notes", length = 200)
    private String notes;

    @OneToMany(mappedBy = "session")
    private List<WorkoutExercise> exercises = new ArrayList<>();

    protected WorkoutSession() {
    }

    public WorkoutSession(TraineeProfile trainee, TrainingPlanTemplate planTemplate, LocalDateTime performedAt,
                          Integer durationMinutes, Integer perceivedEffort, String notes) {
        this.trainee = trainee;
        this.planTemplate = planTemplate;
        this.performedAt = performedAt;
        this.durationMinutes = durationMinutes;
        this.perceivedEffort = perceivedEffort;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public TraineeProfile getTrainee() {
        return trainee;
    }

    public TrainingPlanTemplate getPlanTemplate() {
        return planTemplate;
    }

    public LocalDateTime getPerformedAt() {
        return performedAt;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Integer getPerceivedEffort() {
        return perceivedEffort;
    }

    public String getNotes() {
        return notes;
    }

    public List<WorkoutExercise> getExercises() {
        return exercises;
    }
}
