insert into users (username,password,enabled) values ("tim","password",1);
insert into users (username,password,enabled) values ("jim","password",1);

insert into authorities (id,username,authority) values(1,"tim","ROLE_USER");
insert into authorities (id,username,authority) values(2,"tim","ROLE_ADMIN");
insert into authorities (id,username,authority) values(3,"jim","ROLE_USER");


