-- Table: public.overall_finances

-- DROP TABLE IF EXISTS public.overall_finances;

CREATE TABLE IF NOT EXISTS public.overall_finances
(
    id integer NOT NULL,
    student_id integer NOT NULL,
    CONSTRAINT overall_finances_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.overall_finances
    OWNER to postgres;