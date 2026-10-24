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

-- ===== LAB 02 · exercise =====
insert into exercise (name, muscle_group, equipment_required, difficulty_level, active) values
    ('Wyciskanie sztangi lezac', 'CHEST',     'Sztanga i lawka', 3, true),
    ('Przysiad ze sztanga',     'LEGS',      'Sztanga i stojak', 4, true),
    ('Podciaganie na drazku',    'BACK',      'Drazek',          3, true),
    ('Wznosy bokiem z hantlami', 'SHOULDERS', 'Hantle',          2, true);

-- ===== LAB 02 · trainee_profile =====
insert into trainee_profile (full_name, birth_date, fitness_goal, height_cm, weight_kg, body_fat_percentage) values
    ('Michal Kowalczyk', '1995-04-12', 'Budowa masy miesniowej', 182, 84.50, 14.5),
    ('Aleksandra Zając', '2001-09-23', 'Redukcja tkanki tluszczowej', 168, 62.00, 21.0),
    ('Piotr Wisniewski', '1988-11-05', 'Poprawa kondycji ogolnej', 175, 78.20, null);

-- ===== LAB 02 · training_plan_template =====
insert into training_plan_template (title, days_per_week, estimated_duration_minutes, description) values
    ('FBW dla poczatkujacych', 3, 60, 'Pelny trening ciala 3 razy w tygodniu'),
    ('Push Pull Legs Pro',      6, 75, 'Zaawansowany schemat masowy dla sredniozaawansowanych'),
    ('Trening domowy bez sprzetu', 4, 45, 'Trening obwodowy z ciezarem wlasnego ciala');
