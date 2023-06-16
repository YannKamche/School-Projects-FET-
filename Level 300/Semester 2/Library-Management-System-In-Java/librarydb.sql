
/*==============================================================*/
/* Table: CATEGORY                                              */
/*==============================================================*/

create table CATEGORY (

   CATEGORY_NAME        varchar(160),
   primary key (CATEGORY_NAME)
);

INSERT INTO CATEGORY VALUES ('Action');
INSERT INTO CATEGORY VALUES ('Adventure');
INSERT INTO CATEGORY VALUES ('Classics');
INSERT INTO CATEGORY VALUES ('Comic');
INSERT INTO CATEGORY VALUES ('Cookbooks');
INSERT INTO CATEGORY VALUES ('Detective');
INSERT INTO CATEGORY VALUES ('Essays');
INSERT INTO CATEGORY VALUES ('Fantasy');
INSERT INTO CATEGORY VALUES ('History');
INSERT INTO CATEGORY VALUES ('Horror');
INSERT INTO CATEGORY VALUES ('Literary');
INSERT INTO CATEGORY VALUES ('Poetry');
INSERT INTO CATEGORY VALUES ('Romance');
INSERT INTO CATEGORY VALUES ('Sci-Fi');
INSERT INTO CATEGORY VALUES ('Suspense');


/*==============================================================*/
/* Table: AUTHOR                                                */
/*==============================================================*/

create table AUTHOR (

   AUTHOR_NAME         varchar(80),
   PRIMARY KEY (AUTHOR_NAME)
);
INSERT INTO AUTHOR VALUES ('Moustafa Mahmoud');
INSERT INTO AUTHOR VALUES ('Mario Vargas');
INSERT INTO AUTHOR VALUES ('Milan Kundera');
INSERT INTO AUTHOR VALUES ('Salman Rushdie');
INSERT INTO AUTHOR VALUES ('Margaret Atwood');
INSERT INTO AUTHOR VALUES ('Kazuo Ishiguro');
INSERT INTO AUTHOR VALUES ('Hilary Mantel');
INSERT INTO AUTHOR VALUES ('Alice Walker');
INSERT INTO AUTHOR VALUES ('Mo Yan');
INSERT INTO AUTHOR VALUES ('Arundhati Roy');
INSERT INTO AUTHOR VALUES ('Khaled Hosseini');
INSERT INTO AUTHOR VALUES ('Mahmoud Darwish');
INSERT INTO AUTHOR VALUES ('Abdallah Kablan');

/*==============================================================*/
/* Table: MEMBER                                                */
/*==============================================================*/

create table USER (

   USERNAME				   varchar(80),
   LOGIN_PASSWORD		   varchar(80)  not null,
   USER_NAME          	varchar(80)  not null,
   EMAIL			         varchar(160) UNIQUE not null,
   PHONE                VARCHAR(80)  UNIQUE NOT NULL,
   IS_SUPER				   bool default 0,
   primary key (USERNAME)
);

INSERT INTO USER VALUES ('mhamad_ayoub', 'Ayoub123?', 'Mohammad Ayoub', 'mhamad_ayoub@hotmail.com', '76689620', '1');
INSERT INTO USER VALUES ('alaa_ballout', 'Alaa123?', 'Alaa Ballout', 'alaa_ballout@hotmail.com', '76946286', '1');
INSERT INTO USER VALUES ('bayan_cherry', 'Bayan123?', 'Bayan Cherry', 'bayan_cherry@hotmail.com', '78946136', '1');
INSERT INTO USER VALUES ('farah_ghandour', 'Farah123?', 'Farah Ghandour', 'farah_ghandour@hotmail.com', '81246232', '0');
INSERT INTO USER VALUES ('admin', 'admin', 'admin', 'admin', '00000000', '1');
INSERT INTO USER VALUES ('ali_ghandour', 'ali123?', 'Ali Ghandour', 'ali_ghandour@hotmail.com', '81246233', '0');
INSERT INTO USER VALUES ('ali_Salame', 'ali123?', 'Ali Salame', 'ali_Salame@hotmail.com', '81246234', '0');
INSERT INTO USER VALUES ('fatima_Salame', 'fatima123?', 'Fatima Salame', 'fatima_Salame@hotmail.com', '81246235', '0');
INSERT INTO USER VALUES ('Zainab_Salame', 'Zainab123?', 'Zainab Salame', 'Zainab_Salame@hotmail.com', '81122211', '0');
/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/

create table BOOK (

   BOOK_ID				   int  AUTO_INCREMENT,
   CATEGORY_NAME        varchar(160),
   AUTHOR_NAME          varchar(160),
   BOOK_TITLE           varchar(160) NOT NULL,
   BOOK_DATE            date,
   COPIES_NBR			   INT NOT NULL,
   DESCRIPTION          varchar(512),
   primary key (BOOK_ID),
   foreign key (CATEGORY_NAME) references CATEGORY (CATEGORY_NAME),
   foreign key (AUTHOR_NAME) references AUTHOR (AUTHOR_NAME)
);
INSERT INTO BOOK VALUES(1,'Romance','Mario Vargas','Anna Karenina','1990-11-27',5,'This is a beautifull book');
INSERT INTO BOOK VALUES(2,'Fantasy','Milan kundera','To Kill a Mockingbird','1993-01-11',2,'This is a beautifull book');
INSERT INTO BOOK VALUES(3,'Sci-Fi','Salman Rushdie','The Great Gatsby','1985-07-02',7,'This is a beautifull book');
INSERT INTO BOOK VALUES(4,'Comic','Margaret Atwood','One Hundred Years of Solitude','1995-12-15',3,'This is a beautifull book');
INSERT INTO BOOK VALUES(5,'Suspense','Kazuo Ishiguro','A Passage to India','1978-04-20',5,'This is a beautifull book');
INSERT INTO BOOK VALUES(6,'Classics','Hilary Mantel','Invisible Man','2000-09-23',9,'This is a beautifull book');
INSERT INTO BOOK VALUES(7,'Detective','Alice Walker','Don Quixote','1999-02-05',4,'This is a beautifull book');
INSERT INTO BOOK VALUES(8,'Action','Mo Yan','Beloved','1981-06-14',8,'This is a beautifull book');
INSERT INTO BOOK VALUES(9,'Essays','Arundhati Roy','Mrs. Dalloway','1997-12-01',1,'This is a beautifull book');
INSERT INTO BOOK VALUES(10,'Horror','Khaled Hosseini','Things Fall Apart','2002-04-17',6,'This is a beautifull book');
INSERT INTO BOOK VALUES(11,'Poetry','Mahmoud Darwish','Palestine','1990-11-27',5,'Free Palestine');
INSERT INTO BOOK VALUES(12,'Adventure','Abdallah Kablan','Libya','1990-11-27',5,'Libya in tech world');



/*==============================================================*/
/* Table: CLIENT                                                */
/*==============================================================*/

create table CLIENT (

   CLIENT_PHONE			VARCHAR(80),
   CLIENT_NAME          varchar(80)  not null,
   EMAIL			         varchar(160) UNIQUE not null,
   primary key (CLIENT_PHONE)
);
INSERT INTO CLIENT VALUES("70868911","Alaa Ballout","alaa@gmail.com");
INSERT INTO CLIENT VALUES("71968911","Ali Ballout","ali@gmail.com");
INSERT INTO CLIENT VALUES("70878911","Mohamad Ayoub","Mohamad@gmail.com");
INSERT INTO CLIENT VALUES("70869911","Bayan Cherry","bayan@gmail.com");
INSERT INTO CLIENT VALUES("70862911","Mohamad Nabhan","Mouhamad@gmail.com");
INSERT INTO CLIENT VALUES("70864911","Abir Nabhan","abir@gmail.com");
INSERT INTO CLIENT VALUES("70865911","Patrick haidar","patrick@gmail.com");
/*==============================================================*/
/* Table: BORROW                                                */
/*==============================================================*/

create table BORROW (

   BORROW_ID			   int  AUTO_INCREMENT,
   CLIENT_PHONE			VARCHAR(80),
   BOOK_ID				   int,
   BORROW_DATE          date    not null,
   RETURNED_DATE        date	not null,
   primary key (BORROW_ID),
   foreign key (CLIENT_PHONE) references CLIENT (CLIENT_PHONE),
   foreign key (BOOK_ID) references BOOK (BOOK_ID)
);


/*==============================================================*/
/* Table: RESERVATION                                           */
/*==============================================================*/

create table RESERVATION (

   RESERVATION_ID		   int  AUTO_INCREMENT,
   CLIENT_PHONE			VARCHAR(80),
   BOOK_ID				   int,
   RESERVATION_DATE     date    not null,
   primary key (RESERVATION_ID),
   foreign key (CLIENT_PHONE) references CLIENT (CLIENT_PHONE),
   foreign key (BOOK_ID) references BOOK (BOOK_ID)
);

/*==============================================================*/
/* Table: RESERVATION                                           */
/*==============================================================*/

create table RESERVED_BOOKS (

   BOOK_ID				   int,
   COPIES_NBR			   int,
   primary key (BOOK_ID),
   foreign key (BOOK_ID) references BOOK (BOOK_ID)
);


