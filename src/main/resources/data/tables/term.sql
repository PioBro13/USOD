-- Table: public.term

-- DROP TABLE IF EXISTS public.term;

CREATE TABLE IF NOT EXISTS public.term
(
    id integer NOT NULL,
    term_number integer NOT NULL,
    overall_results_id integer NOT NULL,
    term_finances_id integer,
    register_type character varying(500) COLLATE pg_catalog."default",
    student_group character varying(500) COLLATE pg_catalog."default",
    starting_ects integer,
    final_ects integer,
    nominal_ects integer,
    obtained_ects integer,
    speciality character varying(500) COLLATE pg_catalog."default",
    CONSTRAINT term_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.term
    OWNER to postgres;