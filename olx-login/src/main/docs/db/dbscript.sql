-- 1. Create users table
CREATE TABLE public.users (
    id bigint NOT NULL,
    firstname character varying(100),
    lastname character varying(100),
    mobile_no bigint,
    email character varying(100),
    username character varying(100),
    password character varying(100),
    created_at bigint,
    created_by bigint,
    updated_at bigint,
    updated_by bigint,
    deleted boolean default false
);
ALTER TABLE public.users OWNER TO postgres;

-- 2. Create roles table
CREATE TABLE public.roles (
    id bigint NOT NULL,
    role_name character varying(20),
    role_code character varying(20),
    description character varying(200),
    created_at bigint,
    created_by bigint,
    updated_at bigint,
    updated_by bigint,
    deleted boolean default false
);
ALTER TABLE public.users OWNER TO postgres;

-- 3. Insert roles
INSERT INTO roles
(id, role_name, role_code, description, created_at, created_by, updated_at, updated_by, deleted)
VALUES
(1,'user', 'USER', 'User Role', 1626691183000, 1, 1626691183000, 1, false),
(2,'admin', 'ADMIN', 'Admin Role', 1626691183000, 1, 1626691183000, 1, false);