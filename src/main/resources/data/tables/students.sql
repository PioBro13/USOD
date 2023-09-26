-- Table: public.students

-- DROP TABLE IF EXISTS public.students;

CREATE TABLE IF NOT EXISTS public.students
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    surname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT students_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.students
    OWNER to postgres;

COMMENT ON TABLE public.students
    IS 'Table that stores data of students in sytstem';