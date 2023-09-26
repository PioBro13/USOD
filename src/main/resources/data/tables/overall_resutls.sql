-- Table: public.overall_results

-- DROP TABLE IF EXISTS public.overall_results;

CREATE TABLE IF NOT EXISTS public.overall_results
(
    id integer NOT NULL,
    term_id integer NOT NULL,
    student_id integer NOT NULL,
    student_term_number integer NOT NULL
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.overall_results
    OWNER to postgres;