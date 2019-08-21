create table if not exists persistent_login (
  username VARCHAR (50) NOT NULL,
  series VARCHAR (64) primary key,
  token VARCHAR (64) not null,
  last_used timestamp not null
);

-- для чего???