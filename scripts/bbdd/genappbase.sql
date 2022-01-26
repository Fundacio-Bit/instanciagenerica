--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.14
-- Dumped by pg_dump version 9.3.1
-- Started on 2014-08-25 12:39:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = instanciagenerica, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 150 (class 1259 OID 69544)
-- Name: ige_fitxer; Type: TABLE; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE ige_fitxer (
    fitxerid bigint DEFAULT nextval('ige_instanciagenerica_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(45) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE instanciagenerica.ige_fitxer OWNER TO instanciagenerica;

--
-- TOC entry 169 (class 1259 OID 92635)
-- Name: ige_idioma; Type: TABLE; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE ige_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE instanciagenerica.ige_idioma OWNER TO instanciagenerica;

--
-- TOC entry 184 (class 1259 OID 210385)
-- Name: ige_traduccio; Type: TABLE; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE ige_traduccio (
    traduccioid bigint DEFAULT nextval('ige_instanciagenerica_seq'::regclass) NOT NULL
);


ALTER TABLE instanciagenerica.ige_traduccio OWNER TO instanciagenerica;

--
-- TOC entry 183 (class 1259 OID 210326)
-- Name: ige_traducciomap; Type: TABLE; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE TABLE ige_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(5) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE instanciagenerica.ige_traducciomap OWNER TO instanciagenerica;

--
-- TOC entry 1836 (class 2606 OID 70326)
-- Name: ige_fitxer_pk; Type: CONSTRAINT; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY ige_fitxer
    ADD CONSTRAINT ige_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 1839 (class 2606 OID 96099)
-- Name: ige_idioma_pk; Type: CONSTRAINT; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY ige_idioma
    ADD CONSTRAINT ige_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 1846 (class 2606 OID 210396)
-- Name: ige_traduccio_pk; Type: CONSTRAINT; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY ige_traduccio
    ADD CONSTRAINT ige_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 1842 (class 2606 OID 210501)
-- Name: ige_traducciomap_pk; Type: CONSTRAINT; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY ige_traducciomap
    ADD CONSTRAINT ige_traducciomap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 1837 (class 1259 OID 202159)
-- Name: ige_fitxer_pk_i; Type: INDEX; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_fitxer_pk_i ON ige_fitxer USING btree (fitxerid);


--
-- TOC entry 1840 (class 1259 OID 202163)
-- Name: ige_idioma_pk_i; Type: INDEX; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_idioma_pk_i ON ige_idioma USING btree (idiomaid);


--
-- TOC entry 1847 (class 1259 OID 210461)
-- Name: ige_traduccio_pk_i; Type: INDEX; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traduccio_pk_i ON ige_traduccio USING btree (traduccioid);


--
-- TOC entry 1843 (class 1259 OID 210529)
-- Name: ige_traducmap_idiomaid_pk_i; Type: INDEX; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traducmap_idiomaid_pk_i ON ige_traducciomap USING btree (traducciomapid);


--
-- TOC entry 1844 (class 1259 OID 210528)
-- Name: ige_traducmap_tradmapid_pk_i; Type: INDEX; Schema: instanciagenerica; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_traducmap_tradmapid_pk_i ON ige_traducciomap USING btree (traducciomapid);


--
-- TOC entry 1848 (class 2606 OID 210469)
-- Name: ige_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: instanciagenerica; Owner: instanciagenerica
--

ALTER TABLE ONLY ige_traducciomap
    ADD CONSTRAINT ige_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES ige_traduccio(traduccioid);


-- Completed on 2014-08-25 12:39:21

--
-- PostgreSQL database dump complete
--

