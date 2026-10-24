package pl.wsb.kms.exercise.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "muscle_group", nullable = false, length = 32)
    private MuscleGroup muscleGroup;

    @Column(name = "equipment_required", nullable = false, length = 60)
    private String equipmentRequired;

    // TODO: Enum
    @Column(name = "difficulty_level", nullable = false)
    private Integer difficultyLevel;

    @Column(name = "active", nullable = false)
    private Boolean active;

    protected Exercise() {
    }

    public Exercise(String name, MuscleGroup muscleGroup, String equipmentRequired, Integer difficultyLevel, Boolean active) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.equipmentRequired = equipmentRequired;
        this.difficultyLevel = difficultyLevel;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public String getEquipmentRequired() {
        return equipmentRequired;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public Boolean getActive() {
        return active;
    }
}
