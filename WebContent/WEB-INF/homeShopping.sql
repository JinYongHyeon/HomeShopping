CREATE TABLE HOMESHOPPING_USER(
	ID VARCHAR2(100) PRIMARY KEY,
	PASSWORD VARCHAR2(200) NOT NULL,
	NAME VARCHAR2(200) NOT NULL,
	TEL VARCHAR2(200) NOT NULL,
	ADDRESS VARCHAR2(300) NOT NULL,
	EMAIL VARCHAR2(200) NOT NULL,
	TOTAL_BUY NUMBER DEFAULT 0
);

SELECT * FROM HOMESHOPPING_USER;

CREATE TABLE HOMESHOPPING_PRODUCT(
	PRODUCT_NO NUMBER PRIMARY KEY, --상품번호
	PRODUCT_NAME VARCHAR2(200) NOT NULL, -- 상품이름
	PRODUCT_PRICE NUMBER NOT NULL, --상품가격
	PRODUCT_CONTENT CLOB NOT NULL, --상품내용
	PRODCUT_IMG_PATH VARCHAR2(1000) NOT NULL, -- 상품메인 이미지
	PRODUCT_COUNT NUMBER DEFAULT 0 NOT NULL, -- 상품재고
	PRODUCT_KINDS_NAME VARCHAR2(200) NOT NULL, -- 상품 종류
	PRODUCT_NEW VARCHAR2(100), --신상 유무 체크
	PRODUCT_DATE DATE NOT NULL -- 상품 등록일
);

CREATE SEQUENCE HOMESHOPPING_PRODUCT_SEQ;

--글 갯수
CREATE TABLE GRADE(
	USER_GRADE VARCHAR2(100) PRIMARY KEY,
	USER_PRODUCTBUY_LOW NUMBER,
	USER_PRODUCTBUY_HI NUMBER
);
/*
CREATE TABLE BUY_RECORD(
	RECORD_NO NUMBER NOT NULL,
	RECORD_PRODUCT_NAME VARCHAR2(200) NOT NULL,
	RECORD_PRODUCT_PRICE NUMBER NOT NULL,
	RECORD_PRODCUT_COUNT NUMBER NOT NULL
);*/



--상품 샘플 DB
INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE) VALUES(
HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,'테스트상품1',13500,'테스트상품내용입니다','resources/img/product/main/product_test.jpg',0,'반팔','NO',SYSDATE
);
INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE) VALUES(
HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,'테스트상품2',13500,'테스트상품내용입니다2','resources/img/product/main/product_test.jpg',0,'반팔','NO',SYSDATE
);
INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE) VALUES(
HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,'테스트상품3',13500,'테스트상품내용입니다3','resources/img/product/main/product_test.jpg',0,'반팔','NO',SYSDATE
);
INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE) VALUES(
HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,'테스트상품4',13500,'테스트상품내용입니다4','resources/img/product/main/product_test.jpg',0,'반팔','NEW',SYSDATE
);
INSERT INTO HOMESHOPPING_PRODUCT(PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CONTENT,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,PRODUCT_DATE) VALUES(
HOMESHOPPING_PRODUCT_SEQ.NEXTVAL,'테스트상품5',13500,'테스트상품내용입니다5','resources/img/product/main/product_test.jpg',0,'반팔','NEW',SYSDATE
);

SELECT * FROM HOMESHOPPING_PRODUCT;

SELECT TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') FROM HOMESHOPPING_PRODUCT


SELECT PRODUCT_NO,PRODUCT_NAME,PRODUCT_PRICE,PRODCUT_IMG_PATH,PRODUCT_COUNT,PRODUCT_KINDS_NAME,PRODUCT_NEW,TO_CHAR(PRODUCT_DATE,'YYYY/MM/DD') AS 등록일 FROM HOMESHOPPING_PRODUCT

