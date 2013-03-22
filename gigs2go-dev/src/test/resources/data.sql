insert into users (username,password,enabled) values ('tim','password',1);
insert into users (username,password,enabled) values ('jim','password',1);

insert into authorities (id,username,authority) values(1,'tim','ROLE_USER');
insert into authorities (id,username,authority) values(2,'tim','ROLE_ADMIN');
insert into authorities (id,username,authority) values(3,'jim','ROLE_USER');

insert into artists (id,name,email) values(1,'Test Artist 1','test1@gigs2go.com');
insert into artists (id,name,email) values(2,'Test Artist 2','test2@gigs2go.com');
insert into artists (id,name,email) values(3,'Test Artist 3','test3@gigs2go.com');
insert into artists (id,name,email) values(4,'Test Artist 4','test4@gigs2go.com');
