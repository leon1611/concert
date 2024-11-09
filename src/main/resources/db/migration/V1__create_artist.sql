CREATE TABLE IF NOT EXISTS artist (
    id           SERIAL,
    name         VARCHAR(255) NOT NULL,
    country      VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    PRIMARY KEY(id)

);

CREATE TABLE IF NOT EXISTS event (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    day_event DATE,
    total_attendees INT,
    artist_id INT REFERENCES artist(id) ON DELETE SET NULL
    );
