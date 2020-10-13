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
(DEFAULT, DEFAULT, 4,'{"name": "name1", "age": 32}', 5),
(DEFAULT, DEFAULT, 3,'{"name": "name2", "age": 30}', 4),
(DEFAULT, DEFAULT, 4,'{"name": "name3", "age": 30}', 5),
(DEFAULT, DEFAULT, 3,'{"name": "name4", "age": 25}', 0),
(DEFAULT, DEFAULT, 4,'{"name": "name5","age": 25}', 4),
(DEFAULT, DEFAULT, 4,'{"name": "name6", "age": 20}', 2),
(DEFAULT, DEFAULT, 5,'{"age": 20}', 5),
(DEFAULT, DEFAULT, 6,'{"name": "name8", "age": 23}', 9),
(DEFAULT, DEFAULT, 5,'{"age": 23}', 2),
(DEFAULT, DEFAULT, 6,'{"name": "name10", "age": 23}', 16),
(DEFAULT, DEFAULT, 5,'{"age": 23}', 12),
(DEFAULT, DEFAULT, 5,'{"age": 23}', 0),
(DEFAULT, DEFAULT, 5,'{"age": 23}', 12),
(DEFAULT, DEFAULT, 3,'{"name": "name14", "age": 23}', 10),
(DEFAULT, DEFAULT, 2,'{"name": "name15", "age": 23}', 12),
(DEFAULT, DEFAULT, 1,'{"name": "name16", "age": 23}', 0),
(DEFAULT, DEFAULT, 2,'{"name": "name17", "age": 23}', 15);

SELECT * FROM objects;