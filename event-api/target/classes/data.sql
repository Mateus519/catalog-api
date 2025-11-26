INSERT INTO venues (id, name, city, address, capacity)
VALUES (1, 'Centro de Convenciones Riohacha', 'Riohacha', 'Cra 1 # 10-20', 1000);

INSERT INTO events (id, name, category, start_date, end_date, venue_id, created_at, updated_at)
VALUES (
    1,
    'Festival de Música del Caribe',
    'musica',
    DATEADD('DAY', 10, CURRENT_TIMESTAMP()),
    DATEADD('DAY', 11, CURRENT_TIMESTAMP()),
    1,
    CURRENT_TIMESTAMP(),
    CURRENT_TIMESTAMP()
);
