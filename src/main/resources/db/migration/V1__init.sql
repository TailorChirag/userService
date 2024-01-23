CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    email      VARCHAR(255)          NULL,
    username   VARCHAR(255)          NULL,
    password   VARCHAR(255)          NULL,
    name_id    BIGINT                NULL,
    address_id BIGINT                NULL,
    phone      VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_address
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    city    VARCHAR(255)          NULL,
    street  VARCHAR(255)          NULL,
    number  VARCHAR(255)          NULL,
    zipcode VARCHAR(255)          NULL,
    geo_id  BIGINT                NULL,
    CONSTRAINT pk_useraddress PRIMARY KEY (id)
);

CREATE TABLE user_address_geo
(
    id  BIGINT AUTO_INCREMENT NOT NULL,
    lat VARCHAR(255)          NULL,
    lng VARCHAR(255)          NULL,
    CONSTRAINT pk_useraddressgeo PRIMARY KEY (id)
);

CREATE TABLE user_name
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    first VARCHAR(255)          NULL,
    last  VARCHAR(255)          NULL,
    CONSTRAINT pk_username PRIMARY KEY (id)
);

ALTER TABLE user_address
    ADD CONSTRAINT FK_USERADDRESS_ON_GEO FOREIGN KEY (geo_id) REFERENCES user_address_geo (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES user_address (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_NAME FOREIGN KEY (name_id) REFERENCES user_name (id);