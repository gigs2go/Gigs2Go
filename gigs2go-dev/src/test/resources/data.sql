insert into users (username,password,enabled) values ('tim','password',1);
insert into users (username,password,enabled) values ('jim','password',1);

insert into authorities (id,username,authority) values(1,'tim','ROLE_USER');
insert into authorities (id,username,authority) values(2,'tim','ROLE_ADMIN');
insert into authorities (id,username,authority) values(3,'jim','ROLE_USER');

insert into artists (id,name,email) values(1,'testartist1','testartist1@gigs2go.com');
insert into artists (id,name,email) values(2,'testartist2','testartist2@gigs2go.com');
insert into artists (id,name,email) values(3,'testartist3','testartist3@gigs2go.com');
insert into artists (id,name,email) values(4,'testartist4','testartist4@gigs2go.com');

insert into venues (id,name,email,town) values(1,'testvenue1','testvenue1@gigs2go.com','Canterbury');
insert into venues (id,name,email,town) values(2,'testvenue2','testvenue2@gigs2go.com','Faversham');
insert into venues (id,name,email,town) values(3,'testvenue3','testvenue3@gigs2go.com','Faversham');
insert into venues (id,name,email,town) values(4,'testvenue4','testvenue4@gigs2go.com','Ospringe');

insert into events(id,artist_id,venue_id,dayt) values(1,1,1,'2013-03-28');
insert into events(id,artist_id,venue_id,dayt) values(2,2,2,'2013-03-28');
insert into events(id,artist_id,venue_id,dayt) values(3,3,3,'2013-03-28');
insert into events(id,artist_id,venue_id,dayt) values(4,1,1,'2013-03-27');
insert into events(id,artist_id,venue_id,dayt) values(5,1,2,'2013-03-26');
insert into events(id,artist_id,venue_id,dayt) values(6,1,3,'2013-03-25');
insert into events(id,artist_id,venue_id,dayt) values(7,2,1,'2013-03-27');
insert into events(id,artist_id,venue_id,dayt) values(8,2,2,'2013-03-26');
insert into events(id,artist_id,venue_id,dayt) values(9,2,3,'2013-03-25');
insert into events(id,artist_id,venue_id,dayt) values(10,3,1,'2013-03-27');
insert into events(id,artist_id,venue_id,dayt) values(11,3,2,'2013-03-26');
insert into events(id,artist_id,venue_id,dayt) values(12,3,3,'2013-03-25');
insert into events(id,artist_id,venue_id,dayt) values(13,1,1,'2013-03-24');
insert into events(id,artist_id,venue_id,dayt) values(14,2,2,'2013-03-24');
insert into events(id,artist_id,venue_id,dayt) values(15,3,3,'2013-03-24');
