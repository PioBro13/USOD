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