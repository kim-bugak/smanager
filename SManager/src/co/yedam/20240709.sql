--�л�����(�л���ȣ, �̸�, ����ó, �ּ�, �������)
--tbl_student ���̺�� (���̺��̸�)
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
    
--�Է�.
insert into tbl_student (std_no, std_name,std_phone )
values('S2024-09', 'ȫ�浿','010-1234-5678');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-03', '���ȣ','010-8886-2779','����77����');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-04', '������','010-4996-5386','�뱸40����');

insert into tbl_student (std_no, std_name,std_phone,address)
values('S2024-01', 'Ȳ��','010-5549-9171','�뱸1����');

DELETE from tbl_student
where std_no = 'S2024-01';

update tbl_student
set birth_date = to_date('1991-02-17' ,'yyyy-mm-dd')
where std_no =  'S2024-01';

update tbl_student
set std_no = 'S2024-03'
where std_no =  'S2024-01';

update tbl_student
set address = '����76����'
where std_no =  'S2024-02';

COMMIT;

ROLLBACK;