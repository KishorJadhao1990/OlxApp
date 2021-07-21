--1. Create Table `category`

CREATE TABLE public.category (
    id bigint NOT NULL,
    category character varying(255),
    description character varying(255),
    status character varying(255),
    created_at bigint,
    created_by bigint,
    updated_at bigint,
    updated_by bigint,
    deleted boolean default false
);
ALTER TABLE public.category OWNER TO postgres;

--2. Insert Below Master data

Insert into category (id, category, description, status, created_at, created_by, updated_at, updated_by, deleted)
values
(1, 'Furniture', 'Furniture advertise category', 'OPEN', 1626604273000, 1, 1626604273000, 1, false),
(2, 'Real Estate', 'Real Estate advertise category', 'CLOSE', 1626604273000, 1, 1626604273000, 1, false),
(3, 'Electronic', 'Electronic advertise category', 'OPEN', 1626604273000, 1, 1626604273000, 1, false),
(4, 'Vehicles', 'Vehicles advertise category', 'OPEN', 1626604273000, 1, 1626604273000, 1, false);
