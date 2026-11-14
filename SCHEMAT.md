# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: training_plan_template_exercise) · kolumny: 37 · relacje: 4 × @ManyToOne, 2 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| exercise | Exercise | 6 | — |
| trainee_profile | TraineeProfile | 8 | user_account_id |
| training_plan_template | TrainingPlanTemplate | 5 | — |
| user_account | UserAccount | 5 | — |
| workout_exercise | WorkoutExercise | 6 | exercise_id, workout_session_id |
| workout_session | WorkoutSession | 7 | trainee_profile_id, training_plan_template_id |

```mermaid
erDiagram
    exercise {
        Long id PK
        Boolean active
        Integer difficulty_level
        String equipment_required
        MuscleGroup muscle_group
        String name
    }
    trainee_profile {
        Long id PK
        LocalDate birth_date
        BigDecimal body_fat_percentage
        String fitness_goal
        String full_name
        Integer height_cm
        Long user_account_id FK
        BigDecimal weight_kg
    }
    training_plan_template {
        Long id PK
        Integer days_per_week
        String description
        Integer estimated_duration_minutes
        String title
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    workout_exercise {
        Long id PK
        Long exercise_id FK
        Integer reps
        Integer sets
        BigDecimal weight_kg
        Long workout_session_id FK
    }
    workout_session {
        Long id PK
        Integer duration_minutes
        String notes
        Integer perceived_effort
        LocalDateTime performed_at
        Long trainee_profile_id FK
        Long training_plan_template_id FK
    }
    exercise ||--o{ workout_exercise : "exercise_id"
    trainee_profile ||--o{ workout_session : "trainee_profile_id"
    training_plan_template |o--o{ workout_session : "training_plan_template_id"
    training_plan_template }o--o{ exercise : "training_plan_template_exercise"
    user_account |o--o| trainee_profile : "user_account_id"
    workout_session ||--o{ workout_exercise : "workout_session_id"
```
