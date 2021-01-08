use `ds`;
INSERT INTO departments VALUES (1,'ADMIN',NULL);
INSERT INTO users VALUES(0,'Adam','Smith','address','6980808080',1,"admin","$2a$10$qU.zkvG17NZ6f/m3N22wG.NWpuJwJh/zqqeAbnpBbj9uCA2G.wOni",1);
update departments set super_id=1 where dept_name="Admin";
INSERT INTO roles VALUES("ROLE_ADMIN");
INSERT INTO roles VALUES("ROLE_HR");
INSERT INTO roles VALUES("ROLE_SUPERVISOR");
INSERT INTO roles VALUES("ROLE_DIRECTOR");

INSERT INTO authorities VALUES("ROLE_ADMIN","admin");
select * from roles;