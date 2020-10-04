DROP TABLE IF EXISTS objects;
DROP SEQUENCE IF EXISTS objects_id_seq;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE SEQUENCE IF NOT EXISTS objects_id_seq ;

CREATE TABLE IF NOT EXISTS objects(
    id bigint NOT NULL DEFAULT nextval('objects_id_seq'::regclass),
    uid text COLLATE pg_catalog."default" NOT NULL DEFAULT uuid_generate_v1(),
    object_type integer NOT NULL,
    data jsonb,
    parent_object_id bigint NOT NULL DEFAULT 0,
    CONSTRAINT objects_pkey PRIMARY KEY (id)
);

INSERT INTO objects (id, uid, object_type, data, parent_object_id) VALUES
(DEFAULT, DEFAULT, 1,'{"name": "Alex", "age": 32}', 5),
(DEFAULT, DEFAULT, 1,'{"name": "Misha", "age": 30}', 4),
(DEFAULT, DEFAULT, 1,'{"name": "Misha", "age": 30}', 5),
(DEFAULT, DEFAULT, 2,'{"name": "Masha", "age": 25}', 0),
(DEFAULT, DEFAULT, 1,'{"age": 25}', 4),
(DEFAULT, DEFAULT, 2,'{"name": "Nastya", "age": 20}', 2),
(DEFAULT, DEFAULT, 2,'{"age": 20}', 5),
(DEFAULT, DEFAULT, 1,'{"name": "Petya", "age": 23}', 9),
(DEFAULT, DEFAULT, 1,'{"name": "Petya", "age": 23}', 2);

SELECT * FROM objects;