package pl.wsb.kms.trainee.entity;

import jakarta.persistence.*;
import pl.wsb.kms.account.domain.UserAccount;
import pl.wsb.kms.workout.entity.WorkoutSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    @OneToMany(mappedBy = "trainee")
    private List<WorkoutSession> sessions = new ArrayList<>();

    protected TraineeProfile() {
    }

    public TraineeProfile(String fullName, LocalDate birthDate, String fitnessGoal, BodyMetrics bodyMetrics, UserAccount account) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.fitnessGoal = fitnessGoal;
        this.bodyMetrics = bodyMetrics;
        this.account = account;
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

    public UserAccount getAccount() {
        return account;
    }

    public List<WorkoutSession> getSessions() {
        return sessions;
    }
}
