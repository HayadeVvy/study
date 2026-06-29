--오라클 PL/SQL
--PL/SQL은 Procedural language extension to Structured 
--Query Language(SQL)
--SQL을 확장한 순차적 처리 언어
--데이터베이스 질의어인 SQL과 일반 프로그래밍 언어의 특성을 결합한 언어

--PL/SQL의 기본 구조
--PL/SQL의 기본 단위는 블록(block)
--1)선언부(declarative part):사용할 변수나 상수를 선언
--                          (선언부에만 변수와 상수 선언 가능)
--2)실행부(executable part):실제 처리할 로직을 담당하는 부분
--3)예외처리부(exception-building part):실행부에서 로직을 처리하던
--                                     중 발생할 수 있는 각종 오류들
--                                     에 대해 처리

--기본 구조

--실행부만 작성
begin
    dbms_output.put_line('Hello World');
end;

--선언부와 실행부 작성
declare
    --변수를 선언할 수 있는 선언부
    message VARCHAR2(100);
begin
    --실행부에 사용할 변수는 선언부에서 미리 선언되어야 함
    message := 'Hello World!!!';
    dbms_output.put_line(message);
end;

declare
    --변수를 선언하고 초기화
    message VARCHAR2(100) := 'Hello Oracle';
begin
    dbms_output.put_line(message);
end;

declare
    counter INTEGER;
begin
    counter := counter + 1;
    if counter IS NULL then
        dbms_output.put_line('Result : counter is null');
    end if;
end;

declare
    --변수 선언
    counter INTEGER;
    i INTEGER;
begin
    --반복문 사용하기
    for i in 1..9 loop
        counter := 2 * i;
        dbms_output.put_line('2 * ' || i || '=' || counter);
    end loop;
end;

--예외처리부
declare
 --변수 선언
 counter INTEGER;
begin
 --변수의 초기화
 counter := 10;
 counter := counter/0;
 dbms_output.put_line(counter);
 exception when others then
  dbms_output.put_line('errors');
end;

declare
 --변수 선언
 counter INTEGER;
begin
 --변수의 초기화
 counter := 10;
 counter := counter/0;
 dbms_output.put_line(counter);
 exception when zero_divide then
  dbms_output.put_line('errors~~~~');
end;


--변수 선언
--emp_num1 NUMBER(9);
--grade CHAR(2);
--emp_num2 INTEGER := 1;

--상수 선언
--nYear constant INTEGER := 30; (O)
--nYear constant INTEGER; (X)

--%TYPE : 참조할 테이블에 있는 컬럼의 데이터 타입을 자동으로 가져옴
--구문형식
--변수명 테이블명.컬럼명%TYPE
--nSal emp.sal%TYPE;

--%ROWTYPE
--%TYPE은 하나의 값에 대해 적용하지만, %ROWTYPE은 하나 이상의 
--값에 대해 적용.로우타입 변수를 선언해서 테이블에 있는 로우를 대입.

--콜렉션
--콜렉션 : varray,중첩 테이블, 연관배열
--varray : variable array의 약자로 고정 길이(fixed number)를
--         가진 배열
declare
 type varray_test is varray(3) of integer;
 varray1 varray_test;--위에 선언한 varray_test 타입 변수 
begin
 varray1 := varray_test(10,20,30);
 
 dbms_output.put_line(varray1(1));
 dbms_output.put_line(varray1(2));
 dbms_output.put_line(varray1(3));
end;

--중첩 테이블
--중첩 테이블은 varray와 흡사하지만 중첩 테이블은 선언 시에 전체 크기를
--명시할 필요가 없음

declare
 type nested_test is table of varchar2(10);
 nested1 nested_test; --위에서 선언한 nested_test 타입 변수
begin
 nested1 := nested_test('A','B','C','D');
 
 dbms_output.put_line(nested1(2));
end;

--연관배열 Associative array(index-by table)
--연관배열은 index-by table이라고도 하며 키와 값의 쌍으로 구성된
--콜렉션으로,하나의 키는 하나의 값과 연관되어 있다.

declare
 type assoc_array_num_type is table of number index by pls_integer;
 --키는 pls_integer 형이며,값은 number형인 요소들로 구성
 --(주의)키에 자료형을 명시할 때 integer로 명시하면 오류 발생
 assoc1 assoc_array_num_type;
begin
 --assoc_array_num_type의 키는 3, 값은 33을 넣는다
 assoc1(3) := 33;
 
 dbms_output.put_line(assoc1(3));
end;

declare
 type assoc_array_str_type2 is table of varchar2(32) 
                                       index by varchar2(64);
 assoc2 assoc_array_str_type2;                                      
begin
 assoc2('K') := 'KOREA';
 
 dbms_output.put_line(assoc2('K'));
end;

--콜렉션을 데이터베이스 객체로 생성
create type alphabet_type as varray(26) of varchar2(2);

declare
 test_alph alphabet_type;
begin
 test_alph := alphabet_type('A','B','C','D');
 dbms_output.put_line(test_alph(1));
end;

--레코드
--콜렉션에 해당하는 varray,중첩 테이블,연관배열은 모두 배열 형태의 구조
--를 가진다. 즉 이들은 구성하는 요소들의 데이터 타입은 모두 같아야 한다.
--반면 테이블의 컬럼들이 서로 다른 유형의 데이터 타입으로 구성되어 있기
--때문에 레코드를 이용해서 서로 다른 유형의 데이터 타입 데이터를 저장해서
--테이블에서 해당 데이터를 사용할 수 있도록 처리

declare
 --Type으로 선언한 레코드
 type record2 is record (deptno number not null := 50,
                         dname varchar2(14),
                         loc varchar2(13)
                         );
 --위에서 선언한 record2를 받는 변수 선언
 rec2 record2;
begin
 --record2 레코드 변수 rec1의 dname 필드에 값 할당.
 rec2.dname := 'RECORD';
 rec2.loc := 'SEOUL';
 
 --rec2 레코드 값을 dept 테이블에 insert
 INSERT INTO dept VALUES rec2;
 COMMIT;--오류 없이 정상 수행
 exception when others then
  ROLLBACK;--오류 발생
end;

--제어문
--if문

declare
 grade char(1);--변수 선언
begin
 grade := 'B';
 
 if grade = 'A' then
  dbms_output.put_line('Excellent');
 elsif grade = 'B' then
  dbms_output.put_line('Good');
 elsif grade = 'C' then
  dbms_output.put_line('Fair');
 elsif grade = 'D' then
  dbms_output.put_line('Poor');
 end if; 
end;

--case문

declare
 grade char(1);
begin
 grade := 'B';
 
 case grade 
 when 'A' then
  dbms_output.put_line('Excellent');
 when 'B' then
  dbms_output.put_line('Good');
 when 'C' then
  dbms_output.put_line('Fair');
 when 'D' then
  dbms_output.put_line('Poor');
 else
  dbms_output.put_line('Not Found');
 end case; 
end;

--loop문
declare
 test_number integer;
 result_num integer;
begin
 test_number := 1;
 
 loop
  result_num := 2 * test_number;
  if result_num > 20 then
   exit; --블록 종료
  else
   dbms_output.put_line(result_num);
  end if;
  test_number := test_number + 1;
 end loop;
 --loop 블럭을 빠져나오면 아래 코드를 실행함
 dbms_output.put_line('프로그램 끝');
end;

declare
 test_number integer;
 result_num integer;
begin
 test_number := 1;
 
 loop
  result_num := 2 * test_number;
  
  exit when result_num > 20;
  
  dbms_output.put_line(result_num);
  test_number := test_number + 1;  
 end loop; 
end;

--while-loop문

declare
 test_number integer;
 result_num integer;
begin
 test_number := 1;
 result_num := 0;
 
 while result_num < 20 loop
  result_num := 2 * test_number;
  dbms_output.put_line(result_num);
  test_number := test_number + 1;
 end loop;
end;

--for..loop문
declare
 test_number integer;
 result_num integer;
begin
 for test_number in 1..10 loop
  result_num := 2 * test_number;
  dbms_output.put_line(result_num);
 end loop;
end;

declare
 test_number integer;
 result_num integer;
begin
 for test_number in reverse 1..10 loop
  result_num := 2 * test_number;
  dbms_output.put_line(result_num);
 end loop;
end;

--커서
--SELECT문장을 실행하면 조건에 따른 결과가 추출된다. 추출되는
--결과는 한 건이 될 수도 있고 여러 건이 될 수도 있으므로 이를 결과 셋
--(result set) 혹은 결과집합이라고 부르기도 한다.
--커서(cursor)를 사용하여 이 결과집합에 접근함.

declare
 cursor emp_csr is 
 SELECT empno
 FROM emp
 WHERE deptno = 10;
 
 --empno의 값을 저장할 변수를 선언
 emp_no emp.empno%type;
begin
 open emp_csr; --커서 open
 
 loop
  fetch emp_csr into emp_no;
  --%notfound : 커서에서만 사용 가능한 속성.
  --더 이상 패치(할당)할 row가 없음을 의미
  exit when emp_csr%notfound;
   dbms_output.put_line(emp_no);
 end loop;
 
 close emp_csr; --커서 close
end;

--PL/SQL 서브프로그램
--PL/SQL 서브프로그매은 파라미터와 고유의 이름을 가진 PL/SQL 블록을
--말하며, 데이터베이스 객체로 존재한다.

--함수
--입력받은 값으로부터 10%의 세율을 얻는 함수
create or replace function tax(p_value in number)
 return number
is
begin
 return p_value * 0.1;
end;

SELECT TAX(100) FROM dual;
SELECT ename,sal,TAX(sal) tax, sal-TAX(sal) "실지급 급여"
FROM emp;

--급여와 커미션을 합쳐서 세금 계산
create or replace function tax2(p_sal in emp.sal%type,
                                p_bonus emp.comm%type)
 return number
is
begin
 return (p_sal + NVL(p_bonus,0))*0.1;
end;

SELECT empno,ename,sal,comm,TAX2(sal,comm) AS tax
FROM emp;

--급여(커미션 포함)에 대한 세율을 다음과 같이 정의함.
--급여가 월 $1,000보다 적으면 세율을 5% 적용하며,$1,000이상
--$2,000이하면 10%,$2,000을 초과하면 20%를 적용함
create or replace function tax3(p_sal in emp.sal%type,
                                p_bonus emp.comm%type)
 return number
is
 e_sum number;
 e_tax number;
begin
 e_sum := p_sal + NVL(p_bonus,0);
 
 if e_sum < 1000 then
  e_tax := e_sum * 0.05;
 elsif e_sum <= 2000 then
  e_tax := e_sum * 0.1;
 else
  e_tax := e_sum * 0.2;
 end if;
 return e_tax;
end;

SELECT empno,ename,sal,comm,TAX3(sal,comm) AS tax
FROM emp;

--사원번호를 통해서 급여를 알려주는 함수
create or replace function emp_salaries(emp_no number)
 return number 
is
 nSalaries number(9);--변수 선언
begin
 SELECT sal
 --결과행이 단일행일 경우 into를 이용해서 읽어온 값을 변수에
 --담을 수 있음
 INTO nSalaries
 FROM emp
 WHERE empno = emp_no;
 return nSalaries;
end;

SELECT emp_salaries(7839) FROM dual;

SELECT empno,ename,emp_salaries(empno) 
FROM emp WHERE deptno=10;

--부서번호를 전달하면 부서명을 구하는 함수
create or replace function get_dept_name(dept_no number)
 return varchar2 --(주의)타입 뒤에 사이즈를 명시하면 오류
is
 sDeptName varchar2(30);
begin
 SELECT dname
 INTO sDeptName
 FROM dept
 WHERE deptno=dept_no;
 
 return sDeptName;
end;

SELECT GET_DEPT_NAME(10) FROM dual;
SELECT deptno,GET_DEPT_NAME(deptno) "Department Name"
FROM dept;
SELECT empno,ename,sal,GET_DEPT_NAME(deptno) "Department Name"
FROM emp;

--생성된 함수 확인하기
--데이터 사전(Data Dictionary)을 통해 검색. 데이터 사전에 저장된
--모든 값은 대문자로 저장되기 때문에 대문자로 검색
SELECT object_name,object_type FROM user_objects
WHERE object_type='FUNCTION' AND object_name='TAX';

--작성된 함수의 소스 코드 확인
SELECT text FROM user_source
WHERE type='FUNCTION' AND name='TAX';

--[실습문제]
--1)두 숫자를 제공하면 덧셈을 해서 결과값을 반환하는 함수를 정의하시오.
create or replace function add_num(num1 integer,
                                   num2 integer)
 return integer
is
begin
 return num1 + num2;
end;
SELECT add_num(2,5) FROM dual;
--2)부서번호를 입력하면 해당 부서에서 근무하는 사원수를 반환하는 함수를
--  정의하시오.
create or replace function get_emp_count(
                         dept_no emp.deptno%type)
 return integer
is
 emp_count integer;
begin
 SELECT COUNT(empno)
 INTO emp_count
 FROM emp WHERE deptno=dept_no;
 return emp_count;
end;

SELECT deptno,dname,GET_EMP_COUNT(deptno) 사원수 FROM dept;

--3)emp테이블의 입사일을 입력하면 근무연차를 구하는 함수를 정의
--(소수점 자리 절삭), 함수명 : get_info_hiredate
create or replace function get_info_hiredate(
                            hire_date emp.hiredate%type)
 return number
is
begin
 return TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)/12);
end;

SELECT ename,GET_INFO_HIREDATE(hiredate) 근무연차 FROM emp;
--4)emp테이블을 이용해서 사원번호를 입력하면 해당 사원의 관리자
--이름을 구하는 함수를 정의하시오, 함수명 : get_mgr_name
create or replace function get_mgr_name(
                              emp_no emp.empno%type)
 return varchar2
is
 m_name varchar2(10);--변수 선언
begin
 SELECT ename
 INTO m_name
 FROM emp WHERE empno = (SELECT mgr FROM emp 
                         WHERE empno=emp_no);
 return m_name;
end;

SELECT ename,job,deptno,GET_MGR_NAME(empno) FROM emp;
--5)emp테이블을 이용해서 사원번호를 입력하면 급여등급을 구하는
--함수를 정의하시오. 함수명 : get_sal_grade
--1000이상 2000미만 D,2000이상 3000미만 C,3000이상 4000미만 B
--4000이상 A
create or replace function get_sal_grade(
                              emp_no emp.empno%type)
 return char
is
 sgrade char(1);
begin
 SELECT CASE WHEN sal>=4000 THEN 'A'
             WHEN sal>=3000 AND sal<4000 THEN 'B'
             WHEN sal>=2000 AND sal<3000 THEN 'C'
             WHEN sal>=1000 AND sal<2000 THEN 'D'
             ELSE 'F'
        END grade --SQL문장 안에서는 end case x, end o
 INTO sgrade
 FROM emp WHERE empno=emp_no;
 return sgrade;
end;

SELECT ename,sal,GET_SAL_GRADE(empno) 급여등급 FROM emp;

--6)사원번호를 입력하면 근무지를 구하는 함수
create or replace function find_loc(emp_no emp.empno%type)
 return varchar2
is
 dept_loc varchar2(14);
begin
 SELECT loc
 INTO dept_loc
 FROM dept
 WHERE deptno = (SELECT deptno FROM emp 
                 WHERE empno=emp_no);
 return dept_loc;                
end;

SELECT FIND_LOC(7698) FROM dual;
SELECT empno,ename,FIND_LOC(empno) FROM emp;

--프로시저
create or replace procedure hello_world
is
 message varchar2(100);
begin
 message := 'Hello World';
 dbms_output.put_line(message);
end;

--프로시저 실행
--EXEC 혹은 EXECUTE 프로시저명(파라미터...)
exec hello_world;

create or replace procedure hello_world(p_message in varchar2)
is
begin
 dbms_output.put_line(p_message);
end;

exec hello_world('Korea');

--작성된 Stored Procedure 확인
SELECT object_name,object_type
FROM user_objects
WHERE object_type='PROCEDURE';

--Stored Procedure의 Source를 데이터 사전을 이용해서 얻음
SELECT text FROM user_source WHERE name='HELLO_WORLD';

--부서테이블에 부서정보를 입력하는 프로시저를 생성
create or replace procedure add_department(
                    p_deptno in dept.deptno%type,
                    p_dname in dept.dname%type,
                    p_loc in dept.loc%type)
is
begin
 --parameter 변수에 입력받은 값으로 부서(dept)테이블의 각 컬럼에
 --데이터를 추가.
 INSERT INTO dept
 VALUES (p_deptno,p_dname,p_loc);
 COMMIT;
 exception when others then
  dbms_output.put_line(p_dname || ' register is failed');
  ROLLBACK;
end;

exec add_department(60,'IT SERVICE','BUSAN');
SELECT * FROM dept;

--사원테이블에 사원정보를 저장
create or replace procedure register_emp(
                          e_no emp.empno%type,
                          e_name emp.ename%type,
                          e_job emp.job%type,
                          e_mgr emp.mgr%type,
                          e_sal emp.sal%type,
                          e_comm emp.comm%type,
                          e_deptno emp.deptno%type)
is
begin
 INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)
 VALUES (e_no,e_name,e_job,e_mgr,SYSDATE,e_sal,e_comm,e_deptno);
 COMMIT;
 exception when others then
  dbms_output.put_line(e_name || ' register is failed');
  ROLLBACK;
end;

exec register_emp(9000,'PETER','MANAGER',7902,6000,200,30);
SELECT * FROM emp;

--부서번호를 통해서 부서명과 부서의 위치 구하기
create or replace procedure output_department(
                         p_dept_no in dept.deptno%type)
is
 d_dname dept.dname%type;
 d_loc dept.loc%type;
begin
 SELECT dname,loc
 INTO d_dname,d_loc
 FROM dept WHERE deptno=p_dept_no;
 dbms_output.put_line(d_dname || ',' || d_loc);
end;

exec output_department(10);

--입사연도를 입력하면 사원의 사번,사원명,급여 구하는 프로시저
create or replace procedure info_hiredate(
                              p_year in varchar2)
is
 e_emp emp%rowtype;
begin
 SELECT empno,ename,sal
 INTO e_emp.empno,e_emp.ename,e_emp.sal
 FROM emp
 WHERE TO_CHAR(hiredate,'YYYY') = p_year;
 dbms_output.put_line(
       e_emp.empno || ',' || e_emp.ename || ',' || e_emp.sal);
end;

--하나의 행이 반환되 에러가 발생하지 않는 경우
exec info_hiredate('1980');
--여러개의 행이 반환되어 에러 발생
exec info_hiredate('1981');

--커서 이용하기
--커서(cursor)를 이용하여 질의 수행 결과 반환되는 여러 행을 처리
create or replace procedure info_hiredate(
                             p_year in varchar2)
is
 e_emp emp%rowtype;
 --커서 선언
 cursor emp_cur is
 SELECT empno,ename,sal
 FROM emp
 WHERE TO_CHAR(hiredate,'YYYY')=p_year;
begin
 --커서 열기
 open emp_cur;
 --커서로부터 데이터 읽기
 loop
 fetch emp_cur into e_emp.empno,e_emp.ename,e_emp.sal;
 exit when emp_cur%notfound;
 dbms_output.put_line(e_emp.empno || ',' || e_emp.ename 
                     || ',' || e_emp.sal);
 end loop;
 close emp_cur;
end info_hiredate;

exec info_hiredate('1981');

--'SALES'부서에 속한 사원의 정보 보기
create or replace procedure emp_info(p_dept dept.dname%type)
is
--커서 선언
cursor emp_cur is
SELECT empno,ename
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE dname = UPPER(p_dept);
--변수 선언
e_emp_no emp.empno%type;
e_emp_name emp.ename%type;
begin
 --커서 open
 open emp_cur;
 
 loop
  fetch emp_cur into e_emp_no,e_emp_name;
  exit when emp_cur%notfound;
  dbms_output.put_line(e_emp_no || ',' || e_emp_name);
 end loop;
 
 --커서 close
 close emp_cur;
end emp_info;

exec emp_info('SALES');

--테이블 생성
create table book(
 bookid number primary key,
 bookname varchar2(60) not null,
 publisher varchar2(60) not null,
 price number not null
);

--동일한 도서가 있는지 점검한 후 동일한 도서가 없으면
--삽입하고 동일한 도서가 있으면 가격을 업데이트하는
--프로시저를 작성하시오.
create or replace procedure change_book_info(
                            mybookid number,
                            mybookname varchar2,
                            mypublisher varchar2,
                            myprice number)
is
 mycount number;
begin
 SELECT COUNT(*) INTO mycount FROM book
 WHERE bookname = mybookname;
 
 if mycount!=0 then
  -- 동일한 도서가 있는 경우
  UPDATE book SET price = myprice
  WHERE bookname = mybookname;
 else
  -- 동일한 도서가 없는 경우
  INSERT INTO book (bookid,bookname,publisher,price)
  VALUES (mybookid,mybookname,mypublisher,myprice);
 end if;
 COMMIT; --오류 없이 정상 수행
 exception when others then
  dbms_output.put_line('errors');
  ROLLBACK; 
end;

exec change_book_info(2,'오라클','부산',3000);
SELECT * FROM book;

--[실습문제]
--1)사원번호를 입력받아 해당 사원의 급여를 출력하는 프로시저를 작성
--프로시저명:GET_SALARY
--출력예시) SMITH의 급여 800
create or replace procedure get_salary(
                                p_empno in emp.empno%type)
is
 v_ename emp.ename%type;
 v_sal emp.sal%type;
begin
 SELECT ename,sal
 INTO v_ename,v_sal
 FROM emp WHERE empno=p_empno;
 dbms_output.put_line(v_ename || '의 급여 ' || v_sal);
end;

exec get_salary(7698);

--2)부서번호를 입력받아 해당 부서의 인원수을 출력하는 프로시저를 작성
--프로시저명:COUNT_DEPT_EMP
--출력예시):부서 10의 인원수 3명
create or replace procedure count_dept_emp(
                           p_deptno in emp.deptno%type)
is
 v_count NUMBER;
begin
 SELECT COUNT(*)
 INTO v_count
 FROM emp
 WHERE deptno=p_deptno;
 dbms_output.put_line(
    '부서 ' || p_deptno || '의 인원수 ' || v_count || '명');
end;

exec count_dept_emp(30);

--3)업무를 입력하여 해당 업무를 수행하는 사원들의 사원번호,이름,
--  급여,업무를 출력하시오.
--프로시저명:JOB_INFO
create or replace procedure job_info(
                          p_job emp.job%type)
is
 --커서 선언
 cursor emp_cur is
 SELECT empno,ename,sal,job
 FROM emp
 WHERE job = p_job;
 --변수 선언
 e_emp emp%rowtype;
begin
 --커서 open
 open emp_cur;
 
 loop
  fetch emp_cur into e_emp.empno,e_emp.ename,e_emp.sal,e_emp.job;
  exit when emp_cur%notfound;
  dbms_output.put_line(e_emp.empno || ',' || e_emp.ename || ',' 
                   || e_emp.sal || ',' || e_emp.job || ',' || e_emp.comm);
 end loop;
 --커서 close
 close emp_cur;
end;

--for..loop로 처리하기(자동으로 open/fetch/close)
create or replace procedure job_info(p_job emp.job%type)
is
 --커서 선언
 cursor emp_cur is
 SELECT empno,ename,sal,job
 FROM emp WHERE job=p_job;
begin
 for emp_rec in emp_cur loop
  dbms_output.put_line(emp_rec.empno || ',' || emp_rec.ename 
    || ',' || emp_rec.sal || ',' || emp_rec.job);
 end loop;
end;

exec job_info('MANAGER');

--4)사원번호와 새 업무를 입력하면 emp테이블의 해당 사원의 업무를
--  갱신할 수 있는 프로시저를 작성하시오.
--프로시저명:CHANGE_JOB
create or replace procedure change_job(
                           e_no emp.empno%type,
                           e_job emp.job%type)
is
begin
 UPDATE emp SET job=e_job WHERE empno=e_no;
 COMMIT;
 exception when others then
  dbms_output.put_line(e_no || ' update is failed');
  ROLLBACK;
end;

exec change_job(7369,'DRIVER');
SELECT * FROM emp;

--5)사원번호와 인상금액을 입력받아 해당 사원의 급여를 인상하는 
-- 프로시저를 작성하시오
--프로시저명 : RAISE_SALARY
--출력예시 : 
--사원 : SMITH
--인상 전 : 800(v_old_sal)
--인상 후 : 900(v_new_sal)

create or replace procedure raise_salary(
                        p_empno emp.empno%type,
                        p_amount number)
is
 v_ename emp.ename%type;
 v_old_sal emp.sal%type;
 v_new_sal emp.sal%type;
begin
 --기존 급여 조회
 SELECT sal,ename
 INTO v_old_sal,v_ename
 FROM emp WHERE empno=p_empno;
 
 --급여 인상
 UPDATE emp SET sal = sal + p_amount
 WHERE empno=p_empno;
 
 v_new_sal := v_old_sal + p_amount;
 
 dbms_output.put_line('사원 : ' || v_ename);
 dbms_output.put_line('인상 전 : ' || v_old_sal);
 dbms_output.put_line('인상 후 : ' || v_new_sal);
 COMMIT;
 exception 
   when NO_DATA_FOUND then
    dbms_output.put_line('해당 사원이 없습니다.');
   when others then
    dbms_output.put_line('errors');
    ROLLBACK;
end;

exec raise_salary(7369,100);

--6)사원을 다른 부서로 이동시키는 프로시저를 작성
-- 이동 전후 부서 정보를 출력
--프로시저명 : TRANSFER_DEPT
--출력예시:
--사원 : SMITH
--이전부서 : 20(v_old_deptno)
--새 부서 : 10(p_new_deptno)
create or replace procedure transfer_dept(
                             p_empno emp.empno%type,
                             p_new_deptno emp.deptno%type)
is
 v_ename emp.ename%type;
 v_old_deptno emp.deptno%type;
begin
 --현재 정보 조회
 SELECT ename,deptno
 INTO v_ename,v_old_deptno
 FROM emp WHERE empno=p_empno;
 
 --같은 부서인지 확인
 if v_old_deptno = p_new_deptno then
    dbms_output.put_line('이미 해당 부서에 소속되어 있습니다.');
    return;
 end if;
 
 --부서 이동
 UPDATE emp SET deptno = p_new_deptno
 WHERE empno=p_empno;
 
 dbms_output.put_line('사원 : ' || v_ename);
 dbms_output.put_line('이전 부서 : ' || v_old_deptno);
 dbms_output.put_line('새 부서 : ' || p_new_deptno);
 
 COMMIT;
 
 exception 
   when NO_DATA_FOUND then
    dbms_output.put_line('해당 사원이 없습니다.');
   when others then
    dbms_output.put_line('errors');
    ROLLBACK;
end;

exec transfer_dept(7654,10);

--패키지(Package)
--패키지는 업무와 관련되 Stored Procedure와 Stored Function을
--관리하고, 이를 패키지 단위로 배포할 때 유용하게 사용됨.

--선언부 생성
create or replace
 package employee_pkg as
  procedure print_ename(p_empno number);
  procedure print_sal(p_empno number);
end employee_pkg;

--본문 생성
create or replace
 package body employee_pkg as
  procedure print_ename(p_empno number)
  is
   l_ename emp.ename%type;
  begin
   SELECT ename
   INTO l_ename
   FROM emp WHERE empno=p_empno;
   dbms_output.put_line(l_ename);
   exception when NO_DATA_FOUND then 
    dbms_output.put_line('Invalid employee number');
  end print_ename;
  
  procedure print_sal(p_empno number)
  is
   l_sal emp.sal%type;
  begin
   SELECT sal
   INTO l_sal
   FROM emp
   WHERE empno=p_empno;
   dbms_output.put_line(l_sal);
   exception when NO_DATA_FOUND then 
    dbms_output.put_line('Invalid employee number');
  end print_sal;
end employee_pkg;

--실행
exec employee_pkg.print_ename(7369);--SMITH
exec employee_pkg.print_sal(7369);--900

--트리거(TRIGGER)
--트리거는 데이터의 변경(INSERT,DELETE,UPDATE)문이 실행될 때
--자동으로 같이 실행되는 프로시저를 말함.
--오라클은 실행 전 BEFORE와 실행 후 AFTER 트리거를 지원

create or replace trigger print_message
after insert on dept
begin
 dbms_output.put_line(
         'DEPT 테이블에 정상적으로 데이터가 추가되었습니다.');
end;

--DEPT 테이블에 데이터 추가
INSERT INTO dept VALUES (70,'EDUCATION','SEOUL');
COMMIT;







