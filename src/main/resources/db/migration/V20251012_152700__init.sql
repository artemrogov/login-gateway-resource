CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS profiles
(
    guid              UUID                  NOT NULL,
    login VARCHAR(100)          NOT NULL UNIQUE,
    email    VARCHAR(255)           NOT NULL,
    full_name    VARCHAR(300)           NOT NULL,
    verify    BOOLEAN           DEFAULT FALSE     NOT NULL,
    created_at      TIMESTAMP WITHOUT TIME ZONE,
    updated_at      TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_profiles PRIMARY KEY (guid)
);

COMMENT ON TABLE  profiles                           IS 'Таблица профилей пользователей';
COMMENT ON COLUMN profiles.guid                      IS 'Уникальный guid - локальный идентификатор пользователя';
COMMENT ON COLUMN profiles.login                      IS 'Уникальное имя пользователя - login';
COMMENT ON COLUMN profiles.email                      IS 'email пользователя';
COMMENT ON COLUMN profiles.full_name                      IS 'ФИО пользователя';
COMMENT ON COLUMN profiles.verify                      IS 'Флаг верификации пользовательского аккаунта по умолчанию имеет значение false';