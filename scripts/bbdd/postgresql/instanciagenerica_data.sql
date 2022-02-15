--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.25
-- Dumped by pg_dump version 9.3.25
-- Started on 2022-02-11 14:03:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

SET default_tablespace = '';

SET default_with_oids = false;

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
-- TOC entry 1977 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.instanciagenericaid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.instanciagenericaid IS 'Clau primaria';


--
-- TOC entry 1978 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.numregistre; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.numregistre IS 'Numero de registre de la instancia, corporatiu';


--
-- TOC entry 1979 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.uuid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.uuid IS 'Identificador de la instancia amb hash';


--
-- TOC entry 1980 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantpersonafisica; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantpersonafisica IS 'Per saber si es persona física o jurídica
';


--
-- TOC entry 1981 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitanttipusadminid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitanttipusadminid IS 'Tipus de document (DNI, NIE, Passaport, etc)';


--
-- TOC entry 1982 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantadminid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantadminid IS 'Nombre del docmuent (pot tenir lletres)';


--
-- TOC entry 1983 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.idiomaid; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.idiomaid IS 'Idioma en que del que esta exposat';


--
-- TOC entry 1984 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN ige_instanciagenerica.solicitantcif; Type: COMMENT; Schema: public; Owner: instanciagenerica
--

COMMENT ON COLUMN public.ige_instanciagenerica.solicitantcif IS 'Numero CIF de la rao social si es persona juridica';


--
-- TOC entry 1843 (class 2606 OID 16450)
-- Name: ige_instanciagenerica_pk; Type: CONSTRAINT; Schema: public; Owner: instanciagenerica; Tablespace: 
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instanciagenerica_pk PRIMARY KEY (instanciagenericaid);


--
-- TOC entry 1844 (class 1259 OID 16506)
-- Name: ige_instanciagenerica_pk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instanciagenerica_pk_i ON public.ige_instanciagenerica USING btree (instanciagenericaid);


--
-- TOC entry 1845 (class 1259 OID 16509)
-- Name: ige_instgen_fitxer1id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer1id_fk_i ON public.ige_instanciagenerica USING btree (fitxer1id);


--
-- TOC entry 1846 (class 1259 OID 16510)
-- Name: ige_instgen_fitxer2id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer2id_fk_i ON public.ige_instanciagenerica USING btree (fitxer2id);


--
-- TOC entry 1847 (class 1259 OID 16511)
-- Name: ige_instgen_fitxer3id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer3id_fk_i ON public.ige_instanciagenerica USING btree (fitxer3id);


--
-- TOC entry 1848 (class 1259 OID 16512)
-- Name: ige_instgen_fitxer4id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer4id_fk_i ON public.ige_instanciagenerica USING btree (fitxer4id);


--
-- TOC entry 1849 (class 1259 OID 16513)
-- Name: ige_instgen_fitxer5id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer5id_fk_i ON public.ige_instanciagenerica USING btree (fitxer5id);


--
-- TOC entry 1850 (class 1259 OID 16514)
-- Name: ige_instgen_fitxer6id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer6id_fk_i ON public.ige_instanciagenerica USING btree (fitxer6id);


--
-- TOC entry 1851 (class 1259 OID 16515)
-- Name: ige_instgen_fitxer7id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer7id_fk_i ON public.ige_instanciagenerica USING btree (fitxer7id);


--
-- TOC entry 1852 (class 1259 OID 16516)
-- Name: ige_instgen_fitxer8id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer8id_fk_i ON public.ige_instanciagenerica USING btree (fitxer8id);


--
-- TOC entry 1853 (class 1259 OID 16517)
-- Name: ige_instgen_fitxer9id_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_fitxer9id_fk_i ON public.ige_instanciagenerica USING btree (fitxer9id);


--
-- TOC entry 1854 (class 1259 OID 16508)
-- Name: ige_instgen_idiomaid_fk_i; Type: INDEX; Schema: public; Owner: instanciagenerica; Tablespace: 
--

CREATE INDEX ige_instgen_idiomaid_fk_i ON public.ige_instanciagenerica USING btree (idiomaid);


--
-- TOC entry 1855 (class 2606 OID 16451)
-- Name: ige_instgen_fitxer_fitxer1_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer1_fk FOREIGN KEY (fitxer1id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1857 (class 2606 OID 16466)
-- Name: ige_instgen_fitxer_fitxer2_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer2_fk FOREIGN KEY (fitxer2id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1858 (class 2606 OID 16471)
-- Name: ige_instgen_fitxer_fitxer3_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer3_fk FOREIGN KEY (fitxer3id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1859 (class 2606 OID 16476)
-- Name: ige_instgen_fitxer_fitxer4_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer4_fk FOREIGN KEY (fitxer4id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1860 (class 2606 OID 16481)
-- Name: ige_instgen_fitxer_fitxer5_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer5_fk FOREIGN KEY (fitxer5id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1861 (class 2606 OID 16486)
-- Name: ige_instgen_fitxer_fitxer6_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer6_fk FOREIGN KEY (fitxer6id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1862 (class 2606 OID 16491)
-- Name: ige_instgen_fitxer_fitxer7_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer7_fk FOREIGN KEY (fitxer7id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1863 (class 2606 OID 16496)
-- Name: ige_instgen_fitxer_fitxer8_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer8_fk FOREIGN KEY (fitxer8id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1864 (class 2606 OID 16501)
-- Name: ige_instgen_fitxer_fitxer9_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_fitxer_fitxer9_fk FOREIGN KEY (fitxer9id) REFERENCES public.ige_fitxer(fitxerid);


--
-- TOC entry 1856 (class 2606 OID 16456)
-- Name: ige_instgen_idioma_idioma_fk; Type: FK CONSTRAINT; Schema: public; Owner: instanciagenerica
--

ALTER TABLE ONLY public.ige_instanciagenerica
    ADD CONSTRAINT ige_instgen_idioma_idioma_fk FOREIGN KEY (idiomaid) REFERENCES public.ige_idioma(idiomaid);


-- Completed on 2022-02-11 14:03:00

--
-- PostgreSQL database dump complete
--

