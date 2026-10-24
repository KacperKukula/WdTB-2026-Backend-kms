package pl.wsb.kms.plan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "training_plan_template")
public class TrainingPlanTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true, length = 64)
    private String title;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "days_per_week", nullable = false)
    private Integer daysPerWeek;

    @Column(name = "estimated_duration_minutes", nullable = false)
    private Integer estimatedDurationMinutes;

    protected TrainingPlanTemplate() {}

    public TrainingPlanTemplate(String title, String description, Integer daysPerWeek, Integer estimatedDurationMinutes) {
        this.title = title;
        this.description = description;
        this.daysPerWeek = daysPerWeek;
        this.estimatedDurationMinutes = estimatedDurationMinutes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDaysPerWeek() {
        return daysPerWeek;
    }

    public String getDescription() { return description; }

    public Integer getEstimatedDurationMinutes() { return estimatedDurationMinutes; }
}
