CREATE TABLE audit_log (
                           id SERIAL PRIMARY KEY,
                           entity_type VARCHAR(50) NOT NULL,  -- Тип сущности (например, "Author" или "Book")
                           entity_id BIGINT NOT NULL,         -- ID сущности
                           action VARCHAR(50) NOT NULL,       -- Действие (CREATE, UPDATE, DELETE)
                           changed_by VARCHAR(100) NOT NULL,  -- Кто внес изменения
                           changed_at TIMESTAMP NOT NULL      -- Когда внесены изменения
);