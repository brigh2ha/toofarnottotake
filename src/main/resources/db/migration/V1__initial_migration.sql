CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE parties
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    category_id     TINYINT NOT NULL,
    price           DECIMAL(10, 2) NOT NULL,
    time            VARCHAR(255) NOT NULL,
    captain_id      BIGINT NOT NULL,
    lieutenant_id   BIGINT,
    sergeant_id     BIGINT,
    airman_id       BIGINT,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE categories
(
    id   TINYINT AUTO_INCREMENT NOT NULL,
    departure VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE parties
    ADD CONSTRAINT fk_parties_on_category FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE NO ACTION;

CREATE INDEX fk_parties_on_category ON parties (category_id);

ALTER TABLE parties
    ADD CONSTRAINT fk_parties_on_user_captain FOREIGN KEY (captain_id) REFERENCES users (id) ON DELETE NO ACTION;

CREATE INDEX fk_parties_on_user_captain ON parties (captain_id);

ALTER TABLE parties
    ADD CONSTRAINT fk_parties_on_user_lieutenant FOREIGN KEY (lieutenant_id) REFERENCES users (id) ON DELETE NO ACTION;

CREATE INDEX fk_parties_on_user_lieutenant ON parties (lieutenant_id);

ALTER TABLE parties
    ADD CONSTRAINT fk_parties_on_user_sergeant FOREIGN KEY (sergeant_id) REFERENCES users (id) ON DELETE NO ACTION;

CREATE INDEX fk_parties_on_user_sergeant ON parties (sergeant_id);

ALTER TABLE parties
    ADD CONSTRAINT fk_parties_on_user_airman FOREIGN KEY (airman_id) REFERENCES users (id) ON DELETE NO ACTION;

CREATE INDEX fk_parties_on_user_airman ON parties (airman_id);



