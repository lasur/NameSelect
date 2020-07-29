-- CREATE DATABASE projekt
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Polish_Poland.1250'
--     LC_CTYPE = 'Polish_Poland.1250'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;
--
CREATE TABLE public.id_table
(
    id_im integer,
    id_username integer
)

    TABLESPACE pg_default;

ALTER TABLE public.id_table
    OWNER to postgres;

CREATE TABLE public.id_table2
(
    id_im2 integer,
    id_username2 integer,
    note integer NOT NULL DEFAULT 0
)

    TABLESPACE pg_default;

ALTER TABLE public.id_table2
    OWNER to postgres;


CREATE TABLE public.usertable
(
    id integer NOT NULL DEFAULT 1,
    username character varying(20) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    password character varying(100) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    email character varying(45) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    CONSTRAINT usertable_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.usertable
    OWNER to postgres;

