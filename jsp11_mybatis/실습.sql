DELETE FROM BOARD03;

INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동01','글을 씁니다.01','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동02','글을 씁니다.02','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동03','글을 씁니다.03','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동04','글을 씁니다.04','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동05','글을 씁니다.05','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동06','글을 씁니다.06','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동07','글을 씁니다.07','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동08','글을 씁니다.08','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동09','글을 씁니다.09','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동10','글을 씁니다.10','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동11','글을 씁니다.11','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동12','글을 씁니다.12','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동13','글을 씁니다.13','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동14','글을 씁니다.14','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동15','글을 씁니다.15','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동16','글을 씁니다.16','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동17','글을 씁니다.17','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동18','글을 씁니다.18','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동19','글을 씁니다.19','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동20','글을 씁니다.20','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동21','글을 씁니다.21','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동22','글을 씁니다.22','내용입니다.',SYSDATE,0);
INSERT INTO BOARD03 VALUES (BOARD03_SEQ.NEXTVAL,'홍길동23','글을 씁니다.23','내용입니다.',SYSDATE,0);

commit;
SELECT * FROM
    (SELECT ROWNUM AS NUM,B.* FROM
        (SELECT * FROM BOARD03 ORDER BY NO DESC) B
    ) WHERE NUM >= 6 AND NUM <= 10;

SELECT COUNT(*) FROM BOARD03;

SELECT * FROM BOARD03;










