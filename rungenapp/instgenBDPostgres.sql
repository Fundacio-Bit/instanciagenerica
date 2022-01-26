CREATE TABLE public.ige_instanciagenerica
(
   instanciagenericaid bigint NOT NULL DEFAULT nextval('ige_instanciagenerica_seq'), 
   numregistre character varying(50) NOT NULL, 
   uuid character varying(100) NOT NULL, 
   solicitantpersonafisica boolean NOT NULL, 
   solicitanttipusadminid integer NOT NULL, 
   solicitantadminid character varying(50) NOT NULL, 
   solicitantnom character varying(100) NOT NULL, 
   solicitantllinatge1 character varying(100), 
   solicitantllinatge2 character varying(100), 
   solicitantraosocial character varying(100), 
   solicitantemail character varying(100) NOT NULL, 
   solicitantdireccio character varying(255) NOT NULL, 
   solicitanttelefon character varying(50) NOT NULL, 
   titol bigint NOT NULL, 
   idioma character varying(20) NOT NULL, 
   exposa text NOT NULL, 
   solicita text NOT NULL, 
   fitxer1 bigint, 
   fitxer2 bigint, 
   fitxer3 bigint, 
   fitxer4 bigint, 
   fitxer5 bigint, 
   fitxer6 bigint, 
   fitxer7 bigint, 
   fitxer8 bigint, 
   fitxer9 bigint, 
   CONSTRAINT ige_instanciagenerica_pk PRIMARY KEY (instanciagenericaid), 
   CONSTRAINT ige_instgen_fitxer_fitxer1_fk FOREIGN KEY (fitxer1) REFERENCES ige_fitxer (fitxerid) ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT ige_instgen_idioma_idioma_fk FOREIGN KEY (idioma) REFERENCES ige_idioma (idiomaid) ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.ige_instanciagenerica
  OWNER TO instanciagenerica;
COMMENT ON COLUMN public.ige_instanciagenerica.instanciagenericaid IS 'Clau primaria';
COMMENT ON COLUMN public.ige_instanciagenerica.numregistre IS 'Numero de registre de la instancia, corporatiu';
COMMENT ON COLUMN public.ige_instanciagenerica.uuid IS 'Identificador de la instancia amb hash';
COMMENT ON COLUMN public.ige_instanciagenerica.solicitantpersonafisica IS 'Per saber si es persona física o jurídica
';
COMMENT ON COLUMN public.ige_instanciagenerica.solicitanttipusadminid IS 'Tipus de document (DNI, NIE, Passaport, etc)';
COMMENT ON COLUMN public.ige_instanciagenerica.solicitantadminid IS 'Nombre del docmuent (pot tenir lletres)';
COMMENT ON COLUMN public.ige_instanciagenerica.titol IS 'Prova per ser traduible';
COMMENT ON COLUMN public.ige_instanciagenerica.idioma IS 'Idioma en que del que esta exposat';


ALTER TABLE ige_instanciagenerica RENAME titol  TO titolid;
ALTER TABLE ige_instanciagenerica RENAME idioma  TO idiomaid;
ALTER TABLE ige_instanciagenerica RENAME fitxer1  TO fitxer1id;
ALTER TABLE ige_instanciagenerica RENAME fitxer2  TO fitxer2id;
ALTER TABLE ige_instanciagenerica RENAME fitxer3  TO fitxer3id;
ALTER TABLE ige_instanciagenerica RENAME fitxer4  TO fitxer4id;
ALTER TABLE ige_instanciagenerica RENAME fitxer5  TO fitxer5id;
ALTER TABLE ige_instanciagenerica RENAME fitxer6  TO fitxer6id;
ALTER TABLE ige_instanciagenerica RENAME fitxer7  TO fitxer7id;
ALTER TABLE ige_instanciagenerica RENAME fitxer8  TO fitxer8id;
ALTER TABLE ige_instanciagenerica RENAME fitxer9  TO fitxer9id;
ALTER TABLE ige_instanciagenerica
  ADD CONSTRAINT ige_instgen_traduccio_titol_fk FOREIGN KEY (titolid) REFERENCES ige_traduccio (traduccioid) ON UPDATE NO ACTION ON DELETE NO ACTION;
COMMENT ON COLUMN ige_instanciagenerica.titolid IS 'Prova per ser traduible';
COMMENT ON COLUMN ige_instanciagenerica.idiomaid IS 'Idioma en que del que esta exposat';

