-- Table: public.term_finances

-- DROP TABLE IF EXISTS public.term_finances;

CREATE TABLE IF NOT EXISTS public.term_finances
(
    id integer NOT NULL,
    term_id integer NOT NULL,
    overall_finances_id integer NOT NULL,
    CONSTRAINT term_finances_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.term_finances
    OWNER to postgres;