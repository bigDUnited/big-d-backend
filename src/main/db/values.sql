/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  berger
 * Created: Aug 26, 2016
 */
CREATE TABLE PERSON
  (     PERSONID INT PRIMARY KEY, 
  	FIRSTNAME VARCHAR(30),
        LASTNAME VARCHAR(30),
        BIRTHDATE DATE
  );

Insert into VOICE (VOICEID,NAME) values (1,'Bass');
Insert into VOICE (VOICEID,NAME) values (2,'Tenor');
Insert into VOICE (VOICEID,NAME) values (3,'Sopran');

Insert into PERSON (PERSONID,FIRSTNAME,LASTNAME,BIRTHDATE) values (1,'Doe','John',date('1998-03-25'));
Insert into PERSON (PERSONID,FIRSTNAME,LASTNAME,BIRTHDATE) values (2,'Mustermann','Max',date('1981-01-12'));
Insert into PERSON (PERSONID,FIRSTNAME,LASTNAME,BIRTHDATE) values (3,'And','Anders',date('1978-12-04'));

Insert into MEMBER (PERSONID,VOICEID,PHONE,EMAIL) values (1,3,'+45-12345678','john@doe.org');
Insert into MEMBER (PERSONID,VOICEID,PHONE,EMAIL) values (2,2,'+45-87654321','max@m.org');
Insert into MEMBER (PERSONID,VOICEID,PHONE,EMAIL) values (3,1,'+45-43218765','anders@and.org');
