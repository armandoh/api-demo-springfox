DROP TABLE IF EXISTS Phones;

CREATE TABLE IF NOT EXISTS Phones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(16) CHECK (LENGTH(phone_number) <= 16),
    region VARCHAR(255),
    country VARCHAR(255),
    active BOOLEAN DEFAULT TRUE,
    created_at DATETIME,
    created_by VARCHAR(50) CHECK (LENGTH(created_by) <= 50),
    updated_at DATETIME,
    updated_by VARCHAR(50) CHECK (LENGTH(updated_by) <= 50)
    );
