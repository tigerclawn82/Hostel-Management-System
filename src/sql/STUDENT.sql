DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT
(
   STD_ID       VARCHAR(255)   NOT NULL,
   STD_NAME     VARCHAR(255)   NOT NULL,
   STD_GENDER   VARCHAR(255)   NOT NULL,
   STD_AGE      INTEGER        NOT NULL,
   STD_DOB      TIMESTAMP      NOT NULL,
   STD_BG       VARCHAR(255)   NOT NULL,
   STD_MOB      VARCHAR(255)   NOT NULL,
   STD_NIC      VARCHAR(255)   CONSTRAINT UN_NIC UNIQUE NOT NULL,
   STD_EMAIL    VARCHAR(255)   NOT NULL,
   STD_ADDRESS  VARCHAR(255)   NOT NULL,
   STD_COUNTRY  VARCHAR(255)   NOT NULL,
   STD_FNAME    VARCHAR(255)   NOT NULL,
   STD_FWORK    VARCHAR(255)   NOT NULL,
   STD_FMOB     VARCHAR(255)   NOT NULL,
   R_NO         INTEGER        NOT NULL
);
ALTER TABLE STUDENT
   ADD CONSTRAINT PK_STD PRIMARY KEY (STD_ID);

ALTER TABLE STUDENT
  ADD CONSTRAINT FK_ROOM FOREIGN KEY (R_NO)
  REFERENCES ROOM (R_NO)
   ON UPDATE RESTRICT
   ON DELETE RESTRICT;

COMMIT;
