-- Table: public.operation_finances

-- DROP TABLE IF EXISTS public.operation_finances;

CREATE TABLE IF NOT EXISTS public.operation_finances
(
    id integer NOT NULL,
    operation_name character varying COLLATE pg_catalog."default" NOT NULL,
    value double precision NOT NULL,
    description character varying(1000) COLLATE pg_catalog."default",
    term_finances_id integer NOT NULL,
    CONSTRAINT operation_finances_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.operation_finances
    OWNER to postgres;