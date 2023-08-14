CREATE TABLE public.students
(
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    surname character varying(100) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.students
    OWNER to postgres;

COMMENT ON TABLE public.students
    IS 'Table that stores data of students in sytstem';

CREATE TABLE IF NOT EXISTS public.overall_results
(
    id integer NOT NULL,
    term_id integer NOT NULL,
    student_id integer NOT NULL,
    student_term_number integer NOT NULL,
    register_type character varying COLLATE pg_catalog."default" NOT NULL,
    student_group character varying COLLATE pg_catalog."default" NOT NULL,
    starting_ects integer NOT NULL,
    final_ects integer NOT NULL,
    nominal_ects integer NOT NULL,
    obtained_ects integer NOT NULL,
    speciality character varying COLLATE pg_catalog."default"

)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.overallresults
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.term
(
    id integer NOT NULL,
    term_number integer NOT NULL,
    CONSTRAINT term_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.term
    OWNER to postgres;

