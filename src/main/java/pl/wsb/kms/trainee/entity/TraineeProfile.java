package pl.wsb.kms.trainee.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trainee_profile")
public class TraineeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 80)
    private String fullName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "fitness_goal", nullable = false, length = 60)
    private String fitnessGoal;

    @Embedded
    private BodyMetrics bodyMetrics;

    protected TraineeProfile() {
    }

    public TraineeProfile(String fullName, LocalDate birthDate, String fitnessGoal, BodyMetrics bodyMetrics) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.fitnessGoal = fitnessGoal;
        this.bodyMetrics = bodyMetrics;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public BodyMetrics getBodyMetrics() {
        return bodyMetrics;
    }
}
