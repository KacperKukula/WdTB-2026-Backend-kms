-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

insert into user_account (email, display_name, role, created_at) values
    ('mateusz.krowczynski@student.merito.pl', 'Mateusz', 'USER', current_timestamp),
    ('szczepan.kurtek@student.merito.pl',     'Szczepan', 'USER', current_timestamp),
    ('kacper.kukula@student.merito.pl',       'Kacper',  'USER', current_timestamp);

-- LAB 03: konta podopiecznych trenera (id 8, 9, 10), wskazywane z trainee_profile.user_account_id
insert into user_account (email, display_name, role, created_at) values
    ('michal.kowalczyk@example.com',  'Michal',     'USER', current_timestamp),
    ('aleksandra.zajac@example.com',  'Aleksandra', 'USER', current_timestamp),
    ('piotr.wisniewski@example.com',  'Piotr',      'USER', current_timestamp);

-- ===== LAB 02 · exercise =====
insert into exercise (name, muscle_group, equipment_required, difficulty_level, active) values
    ('Wyciskanie sztangi lezac', 'CHEST',     'Sztanga i lawka', 3, true),
    ('Przysiad ze sztanga',     'LEGS',      'Sztanga i stojak', 4, true),
    ('Podciaganie na drazku',    'BACK',      'Drazek',          3, true),
    ('Wznosy bokiem z hantlami', 'SHOULDERS', 'Hantle',          2, true);

-- ===== LAB 02 · trainee_profile =====
-- user_account_id: konta podopiecznych z sekcji user_account (8 = Michal, 9 = Aleksandra, 10 = Piotr)
insert into trainee_profile (full_name, birth_date, fitness_goal, height_cm, weight_kg, body_fat_percentage, user_account_id) values
    ('Michal Kowalczyk', '1995-04-12', 'Budowa masy miesniowej', 182, 84.50, 14.5, 8),
    ('Aleksandra Zając', '2001-09-23', 'Redukcja tkanki tluszczowej', 168, 62.00, 21.0, 9),
    ('Piotr Wisniewski', '1988-11-05', 'Poprawa kondycji ogolnej', 175, 78.20, null, 10);

-- ===== LAB 02 · training_plan_template =====
insert into training_plan_template (title, days_per_week, estimated_duration_minutes, description) values
    ('FBW dla poczatkujacych', 3, 60, 'Pelny trening ciala 3 razy w tygodniu'),
    ('Push Pull Legs Pro',      6, 75, 'Zaawansowany schemat masowy dla sredniozaawansowanych'),
    ('Trening domowy bez sprzetu', 4, 45, 'Trening obwodowy z ciezarem wlasnego ciala');

-- ===== LAB 03 · training_plan_template_exercise =====
-- cwiczenia w planach: (plan, cwiczenie); 1 = FBW, 2 = Push Pull Legs, 3 = trening domowy
insert into training_plan_template_exercise (training_plan_template_id, exercise_id) values
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (3, 3);

-- ===== LAB 03 · workout_session =====
-- trainee_profile_id: 1 = Michal, 2 = Aleksandra, 3 = Piotr; training_plan_template_id: plan, wedlug ktorego cwiczyl
insert into workout_session (trainee_profile_id, training_plan_template_id, performed_at, duration_minutes, perceived_effort, notes) values
    (1, 1, '2026-11-02 18:00:00', 62, 7, 'Dobra forma, rekord w przysiadzie'),
    (1, 1, '2026-11-05 18:30:00', 58, 8, null),
    (2, 3, '2026-11-03 07:00:00', 45, 6, 'Trening w domu przed praca'),
    (3, 2, '2026-11-04 17:00:00', 80, 9, 'Ciezki dzien nog');

-- ===== LAB 03 · workout_exercise =====
-- wykonane cwiczenia: (trening, cwiczenie, serie, powtorzenia, ciezar w kg)
insert into workout_exercise (workout_session_id, exercise_id, sets, reps, weight_kg) values
    (1, 1, 4, 8,  80.00),
    (1, 2, 4, 6, 100.00),
    (1, 3, 3, 10, null),
    (2, 1, 4, 8,  82.50),
    (2, 2, 4, 6, 105.00),
    (3, 3, 4, 8,  null),
    (4, 2, 5, 5,  90.00),
    (4, 4, 3, 12,  8.00);
