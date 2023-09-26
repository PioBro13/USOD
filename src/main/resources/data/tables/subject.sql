-- Table: public.subject

-- DROP TABLE IF EXISTS public.subject;

CREATE TABLE IF NOT EXISTS public.subject
(
    id integer NOT NULL,
    subject_name character varying COLLATE pg_catalog."default" NOT NULL,
    exam boolean NOT NULL,
    student_term_number integer,
    ects_number integer NOT NULL,
    instructor character varying COLLATE pg_catalog."default",
    grade integer,
    term_id integer,
    CONSTRAINT subject_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.subject
    OWNER to postgres;