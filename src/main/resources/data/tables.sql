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

CREATE TABLE IF NOT EXISTS public."termResults"
(
    id integer NOT NULL,
    "termId" integer NOT NULL,
    "studentId" integer NOT NULL,
    "studentTermNumber" integer NOT NULL,
    "registerType" character varying COLLATE pg_catalog."default" NOT NULL,
    "studentGroup" character varying COLLATE pg_catalog."default" NOT NULL,
    "startingECTS" integer NOT NULL,
    "finalECTS" integer NOT NULL,
    "obtainedECTS" integer NOT NULL,
    speciality character varying COLLATE pg_catalog."default",
    CONSTRAINT "termResults_pkey" PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."termResults"
    OWNER to postgres;

