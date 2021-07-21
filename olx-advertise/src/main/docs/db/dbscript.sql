-- 1. Create advertise table
CREATE TABLE public.advertise (
    id bigint NOT NULL,
    title character varying(255),
    price character varying(255),
    description character varying(255),
    created_at bigint,
    created_by bigint,
    updated_at bigint,
    updated_by bigint,
    category_id bigint,
    deleted boolean default false
);

ALTER TABLE public.advertise OWNER TO postgres;
