--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2022-02-16 13:47:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 171 (class 1259 OID 16395)
-- Name: ige_fitxer_seq; Type: SEQUENCE; Schema: public; Owner: instanciagenerica
--

CREATE SEQUENCE public.ige_fitxer_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ige_fitxer_seq OWNER TO instanciagenerica;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16399)
-- Name: ige_fitxer; Type: TABLE; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE public.ige_fitxer (
    fitxerid bigint DEFAULT nextval('public.ige_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE public.ige_fitxer OWNER TO instanciagenerica;

--
-- TOC entry 174 (class 1259 OID 16407)
-- Name: ige_idioma; Type: TABLE; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE public.ige_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.ige_idioma OWNER TO instanciagenerica;

--
-- TOC entry 177 (class 1259 OID 16440)
-- Name: ige_instanciagenerica_seq; Type: SEQUENCE; Schema: public; Owner: instanciagenerica
--

CREATE SEQUENCE public.ige_instanciagenerica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ige_instanciagenerica_seq OWNER TO instanciagenerica;

--
-- TOC entry 178 (class 1259 OID 16442)
-- Name: ige_instanciagenerica; Type: TABLE; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE public.ige_instanciagenerica (
    instanciagenericaid bigint DEFAULT nextval('public.ige_instanciagenerica_seq'::regclass) NOT NULL,
    numregistre character varying(50),
    uuid character varying(100),
    solicitantpersonafisica boolean NOT NULL,
    solicitanttipusadminid integer NOT NULL,
    solicitantadminid character varying(50) NOT NULL,
    solicitantnom character varying(100),
    solicitantllinatge1 character varying(100),
    solicitantllinatge2 character varying(100),
    solicitantraosocial character varying(100),
    solicitantemail character varying(100) NOT NULL,
    solicitantdireccio character varying(255) NOT NULL,
    solicitanttelefon character varying(50) NOT NULL,
    idiomaid character varying(20) NOT NULL,
    exposa text NOT NULL,
    solicita text NOT NULL,
    fitxer1id bigint,
    fitxer2id bigint,
    fitxer3id bigint,
    fitxer4id bigint,
    fitxer5id bigint,
    fitxer6id bigint,
    fitxer7id bigint,
    fitxer8id bigint,
    fitxer9id bigint,
    datacreacio timestamp without time zone NOT NULL,
    estat integer,
    error text,
    exception text,
    datafinalitzacio timestamp without time zone,
    solicitantcif character varying(50)
);


ALTER TABLE public.ige_instanciagenerica OWNER TO instanciagenerica;

--
-- TOC entry 2005 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.instanciagenericaid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.instanciagenericaid IS 'Clau primaria';


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.numregistre; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.numregistre IS 'Numero de registre de la instancia, corporatiu';


--
-- TOC entry 2007 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.uuid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.uuid IS 'Identificador de la instancia amb hash';


--
-- TOC entry 2008 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantpersonafisica; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantpersonafisica IS 'Per saber si es persona física o jurídica
';


--
-- TOC entry 2009 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitanttipusadminid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitanttipusadminid IS 'Tipus de document (DNI, NIE, Passaport, etc)';


--
-- TOC entry 2010 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantadminid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantadminid IS 'Nombre del docmuent (pot tenir lletres)';


--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.idiomaid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.idiomaid IS 'Idioma en que del que esta exposat';


--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantcif; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantcif IS 'Numero CIF de la rao social si es persona juridica';


--
-- TOC entry 172 (class 1259 OID 16397)
-- Name: ige_traduccio_seq; Type: SEQUENCE; Schema: public; Owner: instanciagenerica
--

CREATE SEQUENCE public.ige_traduccio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ige_traduccio_seq OWNER TO instanciagenerica;

--
-- TOC entry 175 (class 1259 OID 16412)
-- Name: ige_traduccio; Type: TABLE; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE public.ige_traduccio (
    traduccioid bigint DEFAULT nextval('public.ige_traduccio_seq'::regclass) NOT NULL
);


ALTER TABLE public.ige_traduccio OWNER TO instanciagenerica;

--
-- TOC entry 176 (class 1259 OID 16416)
-- Name: ige_traducciomap; Type: TABLE; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE public.ige_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE public.ige_traducciomap OWNER TO instanciagenerica;

--
-- TOC entry 1853 (class 2606 OID 16423)
-- Name: ige_fitxer_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_fitxer
    ADD CONSTRAINT ige_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 1856 (class 2606 OID 16425)
-- Name: ige_idioma_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_idioma
    ADD CONSTRAINT ige_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 1866 (class 2606 OID 16450)
-- Name: ige_instanciagenerica_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instanciagenerica_pk PRIMARY KEY (instanciagenericaid);


--
-- TOC entry 1859 (class 2606 OID 16427)
-- Name: ige_traduccio_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_traduccio
    ADD CONSTRAINT ige_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 1864 (class 2606 OID 16429)
-- Name: ige_traducmap_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_traducciomap
    ADD CONSTRAINT ige_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 1854 (class 1259 OID 16430)
-- Name: ige_fitxer_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_fitxer_pk_i ON public.ige_fitxer USING btree (fitxerid);


--
-- TOC entry 1857 (class 1259 OID 16431)
-- Name: ige_idioma_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_idioma_pk_i ON public.ige_idioma USING btree (idiomaid);


--
-- TOC entry 1867 (class 1259 OID 16506)
-- Name: ige_instanciagenerica_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instanciagenerica_pk_i ON public.ige_instanciagenerica USING btree (instanciagenericaid);


--
-- TOC entry 1868 (class 1259 OID 16509)
-- Name: ige_instgen_fitxer1id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer1id_fk_i ON public.ige_instanciagenerica USING btree (fitxer1id);


--
-- TOC entry 1869 (class 1259 OID 16510)
-- Name: ige_instgen_fitxer2id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer2id_fk_i ON public.ige_instanciagenerica USING btree (fitxer2id);


--
-- TOC entry 1870 (class 1259 OID 16511)
-- Name: ige_instgen_fitxer3id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer3id_fk_i ON public.ige_instanciagenerica USING btree (fitxer3id);


--
-- TOC entry 1871 (class 1259 OID 16512)
-- Name: ige_instgen_fitxer4id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer4id_fk_i ON public.ige_instanciagenerica USING btree (fitxer4id);


--
-- TOC entry 1872 (class 1259 OID 16513)
-- Name: ige_instgen_fitxer5id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer5id_fk_i ON public.ige_instanciagenerica USING btree (fitxer5id);


--
-- TOC entry 1873 (class 1259 OID 16514)
-- Name: ige_instgen_fitxer6id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer6id_fk_i ON public.ige_instanciagenerica USING btree (fitxer6id);


--
-- TOC entry 1874 (class 1259 OID 16515)
-- Name: ige_instgen_fitxer7id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer7id_fk_i ON public.ige_instanciagenerica USING btree (fitxer7id);


--
-- TOC entry 1875 (class 1259 OID 16516)
-- Name: ige_instgen_fitxer8id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer8id_fk_i ON public.ige_instanciagenerica USING btree (fitxer8id);


--
-- TOC entry 1876 (class 1259 OID 16517)
-- Name: ige_instgen_fitxer9id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer9id_fk_i ON public.ige_instanciagenerica USING btree (fitxer9id);


--
-- TOC entry 1877 (class 1259 OID 16508)
-- Name: ige_instgen_idiomaid_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_idiomaid_fk_i ON public.ige_instanciagenerica USING btree (idiomaid);


--
-- TOC entry 1860 (class 1259 OID 16432)
-- Name: ige_traduccio_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traduccio_pk_i ON public.ige_traduccio USING btree (traduccioid);


--
-- TOC entry 1861 (class 1259 OID 16433)
-- Name: ige_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traducciomap_idiomaid_fk_i ON public.ige_traducciomap USING btree (idiomaid);


--
-- TOC entry 1862 (class 1259 OID 16434)
-- Name: ige_traducciomap_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traducciomap_pk_i ON public.ige_traducciomap USING btree (traducciomapid);


--
-- TOC entry 1879 (class 2606 OID 16451)
-- Name: ige_instgen_fitxer_fitxer1_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer1_fk FOREIGN KEY (fitxer1id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1881 (class 2606 OID 16466)
-- Name: ige_instgen_fitxer_fitxer2_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer2_fk FOREIGN KEY (fitxer2id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1882 (class 2606 OID 16471)
-- Name: ige_instgen_fitxer_fitxer3_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer3_fk FOREIGN KEY (fitxer3id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1883 (class 2606 OID 16476)
-- Name: ige_instgen_fitxer_fitxer4_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer4_fk FOREIGN KEY (fitxer4id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1884 (class 2606 OID 16481)
-- Name: ige_instgen_fitxer_fitxer5_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer5_fk FOREIGN KEY (fitxer5id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1885 (class 2606 OID 16486)
-- Name: ige_instgen_fitxer_fitxer6_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer6_fk FOREIGN KEY (fitxer6id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1886 (class 2606 OID 16491)
-- Name: ige_instgen_fitxer_fitxer7_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer7_fk FOREIGN KEY (fitxer7id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1887 (class 2606 OID 16496)
-- Name: ige_instgen_fitxer_fitxer8_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer8_fk FOREIGN KEY (fitxer8id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1888 (class 2606 OID 16501)
-- Name: ige_instgen_fitxer_fitxer9_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer9_fk FOREIGN KEY (fitxer9id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1880 (class 2606 OID 16456)
-- Name: ige_instgen_idioma_idioma_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_idioma_idioma_fk FOREIGN KEY (idiomaid) REFERENCES public.ige_idioma(idiomaid);


--
-- TOC entry 1878 (class 2606 OID 16435)
-- Name: ige_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_traducciomap
    ADD CONSTRAINT ige_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES public.ige_traduccio(traduccioid);


--
-- TOC entry 2003 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2022-02-16 13:47:58

--
-- PostgreSQL database dump complete
--

