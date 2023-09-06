-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;

CREATE TABLE IF NOT EXISTS public.cc_user
(
    id serial NOT NULL,
    full_name character varying(50) NOT NULL,
    user_name character varying(15) NOT NULL,
    password character varying(50) NOT NULL,
    phone_number character varying(20),
    access_level character varying(10) NOT NULL,
    status integer NOT NULL,
    cc_address_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_field
(
    id serial NOT NULL,
    name character varying(50) NOT NULL,
    code character varying(20) NOT NULL,
    application integer NOT NULL,
    status integer NOT NULL,
    type integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_department
(
    id serial NOT NULL,
    name character varying(50) NOT NULL,
    code character varying(10),
    status integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_collaborator
(
    id serial NOT NULL,
    phone_number character varying(20),
    full_name character varying(50) NOT NULL,
    rg character varying(20),
    cpf character varying(20),
    code character varying(10),
    status integer NOT NULL,
    cc_company_id integer NOT NULL,
    cc_sector_id integer NOT NULL,
    cc_function_id integer NOT NULL,
    cc_address_id integer NOT NULL,
    hiring_date timestamp with time zone,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_company
(
    id serial NOT NULL,
    fantasy_name character varying(50) NOT NULL,
    company_name character varying(50),
    cnpj character varying(20),
    state_registration character varying(20),
    site_url character varying(50),
    email character varying(50),
    phone_number character varying,
    cc_address_id integer NOT NULL,
    foundation_date timestamp with time zone,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_entry
(
    id serial NOT NULL,
    fixed_entry integer NOT NULL,
    status integer NOT NULL,
    cc_user_id integer NOT NULL,
    cc_collaborator_id integer NOT NULL,
    cc_field_id integer NOT NULL,
    cc_value_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_value
(
    id serial NOT NULL,
    content character varying(20) NOT NULL,
    status integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_function
(
    id serial NOT NULL,
    name character varying(50) NOT NULL,
    code character varying(10),
    status integer NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_note
(
    id serial NOT NULL,
    title character varying(50) NOT NULL,
    description character varying(150) NOT NULL,
    status integer NOT NULL,
    cc_user_id integer NOT NULL,
    cc_collaborator_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_address
(
    id serial NOT NULL,
    "number" integer,
    status integer NOT NULL,
    cep character varying(15) NOT NULL,
    street character varying(50) NOT NULL,
    district character varying(50) NOT NULL,
    city character varying(20) NOT NULL,
    state character varying(20) NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    updated_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_company_department
(
    id serial NOT NULL,
    cc_company_id integer NOT NULL,
    cc_department_id integer NOT NULL,
    created_at timestamp with time zone DEFAULT now(),
    update_at timestamp with time zone DEFAULT now(),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.cc_department_function
(
    id serial NOT NULL,
    cc_department_id integer NOT NULL,
    cc_function_id integer NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    update_at timestamp with time zone NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.cc_user
    ADD CONSTRAINT cc_address_id_fk FOREIGN KEY (cc_address_id)
    REFERENCES public.cc_address (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;