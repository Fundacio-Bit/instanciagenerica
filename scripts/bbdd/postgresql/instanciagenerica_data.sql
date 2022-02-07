--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2022-02-07 08:27:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1953 (class 0 OID 16407)
-- Dependencies: 174
-- Data for Name: ige_idioma; Type: TABLE DATA; Schema: public; Owner: instanciagenerica
--

INSERT INTO public.ige_idioma (idiomaid, nom, suportat, ordre) VALUES ('ca', 'Català', true, 0);
INSERT INTO public.ige_idioma (idiomaid, nom, suportat, ordre) VALUES ('es', 'Castellano', true, 1);
INSERT INTO public.ige_idioma (idiomaid, nom, suportat, ordre) VALUES ('en', 'English', false, 2);


-- Completed on 2022-02-07 08:27:28

--
-- PostgreSQL database dump complete
--

