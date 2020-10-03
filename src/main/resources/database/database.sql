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
(DEFAULT, DEFAULT, 1,'{"name": "Alex", "age": 32}', 0),
(DEFAULT, DEFAULT, 1,'{"name": "Misha", "age": 30}', 1),
(DEFAULT, DEFAULT, 2,'{"name": "Masha", "age": 25}', 1),
-- (DEFAULT, DEFAULT, 1,'{"age": 25}', 2),
(DEFAULT, DEFAULT, 2,'{"name": "Nastya", "age": 20}', 2),
-- (DEFAULT, DEFAULT, 2,'{"age": 20}', 2),
(DEFAULT, DEFAULT, 1,'{"name": "Petya", "age": 23}', 3);

-- INSERT INTO objects (id, uid, object_type, parent_object_id) VALUES
-- (DEFAULT, DEFAULT, 1, 0),
-- (DEFAULT, DEFAULT, 1, 1),
-- (DEFAULT, DEFAULT, 2, 1),
-- (DEFAULT, DEFAULT, 1, 2),
-- (DEFAULT, DEFAULT, 2, 2),
-- (DEFAULT, DEFAULT, 2, 2),
-- (DEFAULT, DEFAULT, 1, 3);

SELECT * FROM objects;