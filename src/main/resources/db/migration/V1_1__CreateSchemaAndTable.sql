CREATE SCHEMA "master_mind_game_schema";

CREATE TABLE 'master_mind_game_schema'.'player' (
  id                  SERIAL PRIMARY KEY,
  name                VARCHAR
);

CREATE SEQUENCE player_register_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
