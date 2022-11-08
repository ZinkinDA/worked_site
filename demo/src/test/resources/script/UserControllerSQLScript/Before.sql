insert into role(id,name) values (1,'CLIENT'),(3,'MODERATOR'),(2,'ADMIN');

insert into users(id,reputation,email,"name","password",surname,role_id)
          values (1,0,'yashtlsht@mail.ru','Dmitry','MODERATOR','Zinkin',3)
                ,(2,0,'client@mail.ru,','CLIENT','CLIENT','CLIENT',1);