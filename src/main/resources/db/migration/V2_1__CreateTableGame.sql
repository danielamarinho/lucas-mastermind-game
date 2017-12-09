CREATE TABLE "master_mind_game_schema.game" (
  id SERIAL PRIMARY KEY,
  player_register_id INTEGER REFERENCES "player" (id),
  key VARCHAR
);

CREATE SEQUENCE game_register_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
