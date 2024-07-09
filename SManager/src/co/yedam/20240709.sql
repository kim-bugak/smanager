--학생정보(학생번호, 이름, 연락처, 주소, 생년월일)
--tbl_student 테이블명 (테이블이름)
create table tbl_student (
    std_no varchar2(10) primary key,
    std_name varchar2(100) not null,
    std_phone varchar2(20),-- 010-1111-2222
    address varchar2(100),
    birth_date date,
    creation_date date default sysdate
    );
    
    select *
    from creation_date;
    
--입력.
insert into tbl_student (std_no, std_name,std_phone )
values('S2024-09', '홍길동','010-1234-5678');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-03', '김수호','010-8886-2779','서울77번지');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-04', '정현우','010-4996-5386','대구40번지');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-01', '황상섭','010-5549-9171','대구1번지');

DELETE from tbl_student
where std_no = 'S2024-01';

update tbl_student
set birth_date = to_date('1991-02-17' ,'yyyy-mm-dd')
where std_no =  'S2024-01';

update tbl_student
set std_no = 'S2024-03'
where std_no =  'S2024-01';

update tbl_student
set address = '서울76번지'
where std_no =  'S2024-02';

COMMIT;

ROLLBACK;