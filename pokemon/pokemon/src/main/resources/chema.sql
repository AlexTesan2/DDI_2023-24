CREATE TABLE IF NOT EXISTS REGION(
   id bigint  primary key auto_increment,
   nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS POKEMON(
   id bigint primary key auto_increment,
   nombre varchar(50),
   region INT,
   FOREIGN KEY (region) REFERENCES REGION(id)
);
