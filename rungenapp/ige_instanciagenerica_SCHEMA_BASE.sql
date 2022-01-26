

CREATE SEQUENCE ige_fitxer_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;
CREATE SEQUENCE ige_traduccio_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;

CREATE TABLE ige_fitxer (
    fitxerid bigint DEFAULT nextval('ige_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);

CREATE TABLE ige_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);

CREATE TABLE ige_traduccio (
    traduccioid bigint DEFAULT nextval('ige_traduccio_seq'::regclass) NOT NULL
);

CREATE TABLE ige_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);

ALTER TABLE ONLY ige_fitxer
    ADD CONSTRAINT ige_fitxer_pk PRIMARY KEY (fitxerid);

ALTER TABLE ONLY ige_idioma
    ADD CONSTRAINT ige_idioma_pk PRIMARY KEY (idiomaid);

ALTER TABLE ONLY ige_traduccio
    ADD CONSTRAINT ige_traduccio_pk PRIMARY KEY (traduccioid);

ALTER TABLE ONLY ige_traducciomap
    ADD CONSTRAINT ige_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);

CREATE INDEX ige_fitxer_pk_i ON ige_fitxer USING btree (fitxerid);

CREATE INDEX ige_idioma_pk_i ON ige_idioma USING btree (idiomaid);

CREATE INDEX ige_traduccio_pk_i ON ige_traduccio USING btree (traduccioid);

CREATE INDEX ige_traducciomap_idiomaid_fk_i ON ige_traducciomap USING btree (idiomaid);

CREATE INDEX ige_traducciomap_pk_i ON ige_traducciomap USING btree (traducciomapid);

ALTER TABLE ONLY ige_traducciomap
    ADD CONSTRAINT ige_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES ige_traduccio(traduccioid);

INSERT INTO ige_idioma(idiomaid, nom, ordre) VALUES ('ca', 'Català', 0);
INSERT INTO ige_idioma(idiomaid, nom, ordre) VALUES ('es', 'Castellano', 1);
INSERT INTO ige_idioma(idiomaid, nom, ordre) VALUES ('en', 'English', 2);
    
    
