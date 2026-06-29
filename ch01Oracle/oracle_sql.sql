--오라클 SQL
--SELECT
--전체 테이블 명세
--SELECT 컬럼명,컬럼명 FROM 테이블명
SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp;
-- * : 모든 컬럼
SELECT * FROM emp;

--특정 열 선택
SELECT ename,sal FROM emp;

--주석
SELECT * /* 주석 */ FROM emp;--주석

--dual
--dual : 함수 및 계산의 결과를 볼 때 사용할
--       공용(public) 테이블
--       일시적인 산술,날짜 등을 이용할 때

SELECT ASCII(0) FROM dual;--48
SELECT ASCII('A') FROM dual;--65
SELECT SYSDATE FROM dual;
SELECT 7 + 10 FROM dual;

--산술식:산술 연산자(+,-,*,/)
SELECT ename,sal,sal+300 FROM emp;
--연산자 우선 순위
SELECT ename,sal,12*(sal+300) FROM emp;

--NULL값 정의:NULL은 사용할 수 없거나,할당되지 않았거나,
--           적용할 수 없는 값
--           NULL은 0이나 공백과는 다름
SELECT empno,ename,job,comm FROM emp;

--산술식의 null값:null값을 포함하는 산술식은 null로 계산
SELECT ename,12*(sal+comm) FROM emp;

--열 알리아스(alias)정의
--열 이름을 바꿈
--열 이름 바로 뒤에 나옴. 열이름과 alias 사이에 as 키워드가 올 수 있음

--알리아스에 큰따옴표를 사용하는 경우
--대소문자 구별을 원할 때
--공백 포함시
--#,_ 등 특수문자 사용시(_# 맨 앞에 오면 오류 발생,문자 뒤에는 정상 동작
--,는 앞 뒤 모두 오류 발생)
--숫자로 시작할 경우

SELECT sal*12 ASal FROM emp;
SELECT sal*12 AS ASal FROM emp;
SELECT sal*12 "Annual Salary" FROM emp;
SELECT sal*12 "12sal" FROM emp;

--연결연산자 : 열이나 문자열을 다른 열에 연결.
--            두 개의 세로선(||)으로 나타냄
--            결과열로 문자식을 생성
SELECT ename || ' has $' || sal FROM emp;
SELECT ename || job AS "Employees" FROM emp;

--연결연산자와 null값:문자열에 null값을 결합할 경우 결과는 문자열
SELECT ename || comm FROM emp;

--DISTINCT : 중복행 삭제
SELECT DISTINCT deptno FROM emp;

--[실습문제]
--1)emp테이블에서 사원번호,사원이름,월급을 출력하시오.
SELECT empno,ename,sal FROM emp;
--2)emp테이블에서 사원이름과 월급을 출력하는데 
-- 컬럼명은 "이 름","월 급"으로 바꿔서 출력하시오.
SELECT ename AS "이 름",sal "월 급" FROM emp;
--3)emp테이블에서 사원번호,월급,연봉을 구하고 각각
--  컬럼명은 "사원번호","사원이름","월급","연봉"으로
--  출력하시오.
SELECT empno 사원번호, ename 사원이름, sal 월급, sal*12 연봉
FROM emp;
--4)emp테이블에서 직업(JOB)를 중복되지 않게 표시하시오.
SELECT DISTINCT(job) FROM emp;

--WHERE절 : 선택을 사용하여 행 제한
SELECT * FROM emp WHERE deptno=10;--숫자
SELECT * FROM emp WHERE ename='SMITH';--문자열
SELECT * FROM emp WHERE hiredate>'81-12-03';--날짜

--(주의)WHERE절에서는 알리아스를 사용할 수 없음
SELECT ename,sal,sal*12 ansal 
FROM emp WHERE sal*12 > 15000;

--비교연산자의 사용
SELECT * FROM emp WHERE hiredate > '81/11/17';
SELECT * FROM emp WHERE hiredate <> '81/12/03';
SELECT * FROM emp WHERE hiredate ^= '81/12/03';
SELECT * FROM emp WHERE hiredate != '81/12/03';
SELECT * FROM emp WHERE sal > 2000 AND sal < 5000;
SELECT * FROM emp WHERE sal >= 1500 AND sal <= 3000;
--between ~ and ~ : 두 값 사이(저정한 값 포함)
SELECT * FROM emp WHERE sal BETWEEN 1500 AND 3000;
SELECT * FROM emp WHERE sal NOT BETWEEN 1500 AND 3000;
--in : 값 목록 중의 값과 일치
SELECT * FROM emp WHERE sal IN (1300,2450,3000);
SELECT * FROM emp WHERE sal NOT IN (1300,2450,3000);

--like : 패턴을 통해 일치하는 정보 체크
-- %는 0개 이상의 문자를 나타냄
-- _는 한 문자를 나타냄

SELECT * FROM emp WHERE ename LIKE '%S%';--S가 처음,중간,끝에 오는 이름
SELECT * FROM emp WHERE ename NOT LIKE '%S%';

SELECT * FROM emp WHERE ename LIKE 'S%';
SELECT * FROM emp WHERE hiredate LIKE '%22';--22로 끝나는 입사일
SELECT * FROM emp WHERE ename LIKE 'FOR_';--FOR 다음에 꼭 한 글자
SELECT * FROM emp WHERE ename LIKE '_M%';--한 글자 다음의 M,M다음에 없거나 여러개

--NULL 조건 사용
SELECT * FROM emp WHERE comm IS NULL;--comm=null은 불가
SELECT * FROM emp WHERE comm IS NOT NULL;--comm!=null은 불가

--논리연산자(and,or,not)
SELECT empno,ename,job,sal FROM emp
WHERE sal >= 2000 AND job LIKE '%MAN%';

SELECT empno,ename,job,sal FROM emp
WHERE sal >= 2000 OR job LIKE '%MAN%';

SELECT ename,job FROM emp
WHERE job NOT IN ('CLERK','SALESMAN');

--[실습문제]
--1)emp테이블에서 사원번호가 7689인 사원의 이름,업무,급여를 출력하시오.
SELECT ename,job,sal FROM emp WHERE empno=7698;
--2)emp테이블에서 사원이름이 SMITH인 사람의 이름과 월급,부서번호를 구하시오.
SELECT ename,sal,deptno FROM emp WHERE ename='SMITH';
--3)emp테이블에서 월급이 2500이상 3500미만인 사원의 이름,입사일,월급을
--  구하시오.
SELECT ename,hiredate,sal FROM emp 
WHERE sal>=2500 AND sal < 3500;
--4)급여가 2000에서 3000사이에 포함되지 않는 사원의 이름,업무,급여를 
--  출력하시오.
SELECT ename,job,sal FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000;

SELECT ename,job,sal FROM emp
WHERE NOT (sal>= 2000 AND sal<=3000);
--5)81년05월01일과 81년12월03일 사이에 입사한 사원의 이름,급여,입사일을
--  출력하시오.
SELECT ename,sal,hiredate FROM emp
WHERE hiredate BETWEEN '81-05-01' AND '81-12-03';

SELECT ename,sal,hiredate FROM emp
WHERE hiredate>='81/05/01' AND hiredate<='81/12/03';
--6)사원번호가 7566,7782,7934인 사원을 제외한 사람들의 사원번호,이름,
--  월급을 출력하시오.
SELECT empno,ename,sal FROM emp 
WHERE empno NOT IN (7566,7782,7934);
--7)급여가 $2,000와$5,000사이고 부서번호가 10 또는 30인 사원의 이름과
--  급여,부서번호를 출력하시오.
SELECT ename,sal,deptno FROM emp
WHERE sal BETWEEN 2000 AND 5000 AND deptno in (10,30);

SELECT ename,sal,deptno FROM emp
WHERE sal BETWEEN 2000 AND 5000 AND (deptno=10 OR deptno=30);

--8)업무가 SALESMAN 또는 MANAGER이면서 급여가 $1,600,$2,975,$2,850이
--  아닌 모든 사원의 이름,업무 및 급여를 표시하시오.
SELECT ename,job,sal FROM emp 
WHERE job IN('SALESMAN','MANAGER') 
AND sal NOT IN(1600,2975,2850);

SELECT ename,job,sal FROM emp
WHERE (job='SALESMAN' OR job='MANAGER')
AND sal NOT IN(1600,2975,2850);

--9)업무명에 MAN이 포함되어 있고 급여를 1000~1300사이로 받는 사원의 
--  이름,급여,업무를 출력하시오.
SELECT ename,sal,job FROM emp
WHERE job LIKE '%MAN%' AND sal BETWEEN 1000 AND 2000;
--10)이름이 S로 끝나는 사원들 중에서 30번 부서에 근무하는 사원의 이름,
--   급여,부서번호를 출력하시오.
SELECT ename,sal,deptno FROM emp 
WHERE ename LIKE '%S' AND deptno=30;

--ORDER BY절 : 정렬
SELECT * FROM emp ORDER BY sal;--기본적으로 오름차순 정렬
SELECT * FROM emp ORDER BY sal ASC;--오름차순 정렬
SELECT * FROM emp ORDER BY sal DESC;--내림차순 정렬
--1차 정렬을 할 때 중복값이 있으면 2차 정렬 가능
SELECT * FROM emp ORDER BY sal, ename;

SELECT ename,job,deptno,hiredate FROM emp
ORDER BY hiredate DESC;--내림차순 정렬

--열 alias를 기준으로 정렬
SELECT empno,ename,sal*12 annsal FROM emp
ORDER BY annsal;

--열의 숫자 위치를 사용하여 정렬
--컬럼명을 명시할 경우 명시한 컬럼명 순서
--       1    2    3       4
SELECT ename,job,deptno,hiredate FROM emp
ORDER BY 3;

--테이블에 생성된 순서대로 열 숫자 위치 부여
SELECT * FROM emp ORDER BY 2;

--NULLS FIRST 또는 NULLS LAST 키워드를 사용하여 반환된 행 중
--NULL값을 포함하는 행이 정렬 순서상 맨 처음에 나타나거나 마지막에
--나타나도록 지정
SELECT * FROM emp ORDER BY comm NULLS FIRST;
SELECT * FROM emp ORDER BY comm DESC NULLS LAST;

--[실습문제]
--1)사원번호,사원이름,입사일을 출력하는데 입사일이 빠른 사람순으로 정렬
SELECT empno,ename,hiredate FROM emp ORDER BY hiredate ASC;
--2)사원이름,급여,연봉을 구하고 연봉이 많은 순으로 정렬
SELECT ename,sal,sal*12 annsal FROM emp ORDER BY annsal DESC;
--3)10번 부서 또는 20번 부서에서 근무하고 있는 사원의 이름과 부서번호를
--  출력하는데 이름을 영문자순으로 표시하시오.
SELECT ename,deptno FROM emp 
WHERE deptno IN(10,20) ORDER BY ename ASC;
--4)커미션 계약을 맺은 모든 사원의 이름,급여,커미션을 출력하는데 커미션을
--  기준으로 내림차순 정렬하시오.
SELECT ename,sal,comm FROM emp 
WHERE comm IS NOT NULL ORDER BY comm DESC;

--함수
--문자함수
--대소문자 조작 함수 : LOWER,UPPER,INICAP
SELECT LOWER('HELLO') FROM dual;--소문자로 변환
SELECT UPPER('hello') FROM dual;--대문자로 변환
SELECT INITCAP('hello wORLD') FROM dual;--첫 글자 대문자,나머지 소문자
SELECT INITCAP(ename) FROM emp;

--문자 조작 함수
--CONCAT(문자열1,문자열2):문자열1과 문자열2를 연결하여 하나의 
--문자열로 반환
SELECT CONCAT('Hello','World') FROM dual;

--SUBSTR(대상문자열,인덱스) : 대상문자열에서 지정한 인덱스부터 문자열 추출
--(주의)인덱스 1부터 시작
SELECT SUBSTR('Hello World',3) FROM dual;
--SUBSTR(대상문자열,인덱스,개수):지정한 인덱스부터 지정한 개수만큼 추출
SELECT SUBSTR('Hello World',3,3) FROM dual;
SELECT SUBSTR('Hello World',-3) FROM dual;--뒤에서 3번째부터 끝까지 추출
SELECT SUBSTR('Hello World',-3,2) FROM dual;

--LENGTH(대상문자열):문자열의 개수
SELECT LENGTH('Hello World') FROM dual;

--INSTR(대상문자열,검색문자):검색문자의 위치값 검색
SELECT INSTR('Hello World','e') FROM dual;--2
--검색문자가 없을 경우 0
SELECT INSTR('Hello World','E') FROM dual;--0
SELECT INSTR('Hello World','o') FROM dual;--5
--INSTR(대상문자열,검색문자,검색인덱스):지정한 인덱스부터 검색
SELECT INSTR('Hello World','o',6) FROM dual;--8
--INSTR(대상문자열,검색문자,검색인덱스,반복횟수)
--지정한 인덱스부터 검색,반복횟수만큼 검색 반복
SELECT INSTR('Hello World','o',1,2) FROM dual;--8

--LPAD(대상문자열,총길이,문자):지정한 길이에 문자열을 출력하는데 공백은
--왼쪽에, 지정한 문자로 채움
--RPAD(대상문자열,총길이,문자):지정한 길이에 문자열을 출력하는데 공백은
--오른쪽에, 지정한 문자로 채움
SELECT LPAD('Hello',10,'*') FROM dual;
SELECT RPAD('Hello',10,'*') FROM dual;

--TRIM : 문자열에서 공백이나 특정 문자를 제거한 다음 값을 반환
--방향:leading(왼쪽),trailing(오른쪽),both(양쪽)<-default
SELECT TRIM('h' FROM 'habchh') FROM dual;--양쪽
SELECT TRIM(LEADING 'h' FROM 'habchh') FROM dual;--왼쪽
SELECT TRIM(TRAILING 'h' FROM 'habchh') FROM dual;--오른쪽

--LTRIM(대상문자열,제거할 문자):문자열의 왼쪽에서 공백이나 특정 문자를
-- 제거한 다음 값을 반환
SELECT LTRIM('habchh','h') FROM dual;
--RTRIM(대상문자열,제거할 문자):문자열의 오른쪽에서 공백이나 특정
--문자를 제거한 다음 값을 반환
SELECT RTRIM('habchh','h') FROM dual;

--REPLACE(대상문자열,old,new):대상문자열에서 old문자를 new문자로 대체
SELECT REPLACE('010.1234.5678','.','-') FROM dual;

--함수 중첩
SELECT ename,LOWER(SUBSTR(ename,1,3)) FROM emp;

--숫자함수
--CEIL(실수):올림 처리한 정수값을 반환
SELECT CEIL(1.4) FROM dual;
--FLOOR(실수):버림 처리한 정수값을 반환
SELECT FLOOR(1.7) FROM dual;
--ROUND(대상숫자,지정자릿수):반올림
SELECT ROUND(45.926,2) FROM dual;--45.93
SELECT ROUND(45.926) FROM dual;--46
--TRUNC(대상숫자,지정자릿수):절삭
SELECT TRUNC(45.926,2) FROM dual;--45.92
SELECT TRUNC(45.926) FROM dual;--45
--MOD(대상숫자,나눌 숫자):나머지값
SELECT MOD(17,2) FROM dual;--17%2는 오류

--날짜함수
--SYSDATE(ORACLE 서버의 현재 날짜와 시간을 반환)
SELECT SYSDATE FROM dual;

--날짜에 산술 연산자 사용
SELECT ename,hiredate, 
       TRUNC((SYSDATE - hiredate)/7) AS WEEKS FROM emp 
WHERE deptno=10;

--MONTHS_BETWEEN(날짜1,날짜2):두 날짜 간의 월 수
SELECT MONTHS_BETWEEN('2024-08-29','2023-01-29') FROM dual;
SELECT ename,
       TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) months_worked
FROM emp ORDER BY months_worked;

--ADD_MONTHS : 특정 날짜의 월에 정수를 더한 다음 해당 날짜를 반환
SELECT ADD_MONTHS('2024-08-29',8) FROM dual;

--NEXT_DAY : 지정한 요일의 다음 날짜
SELECT NEXT_DAY('2026-01-07','월요일') FROM dual;
--1(일요일) ~ 7(토요일)
SELECT NEXT_DAY('2026-01-15',4) FROM dual;

--LAST_DAY : 월의 마지막 날
SELECT LAST_DAY('2024-08-29') FROM dual;

--EXTRACT():날짜 정보에서 특정한 연,월,일,시,분,초 등을 추출
SELECT EXTRACT(YEAR FROM SYSDATE) YEAR,
       EXTRACT(MONTH FROM SYSDATE) MONTH,
       EXTRACT(DAY FROM SYSDATE) DAY
FROM dual;

SELECT EXTRACT(YEAR FROM DATE '2024-03-17')YEAR,
       EXTRACT(MONTH FROM DATE '2024-03-17')MONTH,
       EXTRACT(DAY FROM DATE '2024-03-17')DAY
FROM dual;

SELECT SYSTIMESTAMP FROM dual;
SELECT EXTRACT(YEAR FROM SYSTIMESTAMP)YEAR,
       EXTRACT(MONTH FROM SYSTIMESTAMP)MONTH,
       EXTRACT(DAY FROM SYSTIMESTAMP)DAY,
       EXTRACT(HOUR FROM SYSTIMESTAMP)HOUR,
       EXTRACT(MINUTE FROM SYSTIMESTAMP)MINUTE,
       EXTRACT(SECOND FROM SYSTIMESTAMP)SECOND
FROM dual;

SELECT EXTRACT(YEAR FROM TIMESTAMP '2024-03-17 17:31:10')YEAR,
       EXTRACT(MONTH FROM TIMESTAMP '2024-03-17 17:31:10')MONTH,
       EXTRACT(DAY FROM TIMESTAMP '2024-03-17 17:31:10')DAY,
       EXTRACT(HOUR FROM TIMESTAMP '2024-03-17 17:31:10')HOUR,
       EXTRACT(MINUTE FROM TIMESTAMP '2024-03-17 17:31:10')MINUTE,
       EXTRACT(SECOND FROM TIMESTAMP '2024-03-17 17:31:10')SECOND
FROM dual;

--[실습문제]
--1)직업(job)을 첫 글자는 대문자, 나머지는 소문자로 출력하시오.
SELECT INITCAP(job)FROM emp;
--2)사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만
--  추출하여 출력하시오.
SELECT SUBSTR(ename,1,3) FROM emp WHERE ename LIKE '%A%';
--3)사원이름의 세 번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ename FROM emp WHERE SUBSTR(ename,3,1) = 'A';
SELECT ename FROM emp WHERE ename LIKE '__A%';
--4)이름이 J,A 또는 M으로 시작하는 모든 사원의 이름(첫 글자는 대문자로,
--  나머지 글자는 소문자로 표시) 및 이름의 길이를 표시하시오.
--(열 레이블은 name과 length로 표시)
SELECT INITCAP(ename) name,LENGTH(ename) length FROM emp
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR ename LIKE 'M%';

SELECT INITCAP(ename) name,LENGTH(ename) length FROM emp
WHERE SUBSTR(ename,1,1) IN ('J','A','M');

--5)모든 사원의 이름과 급여를 표시하는 질의를 작성.
--  급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로 표기하고 
--  열 레이블은 SALARY로 지정
SELECT ename,LPAD(sal,15,'$') "SALARY" FROM emp;
--6)모든 사원의 이름,업무,급여,부서번호를 출력
--  부서번호 오름차순 정렬,사원의 이름은 10자 길이로 왼쪽 정렬,
-- 공백부분은 *로 표시
SELECT RPAD(ename,10,'*'),job,sal,deptno FROM emp
ORDER BY deptno;
--7)오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오.
SELECT LAST_DAY(SYSDATE) - SYSDATE AS "남은 날 수"
FROM dual;

--변환함수
--TO_CHAR : 숫자 -> 문자, 날짜 -> 문자
--날짜 -> 문자
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM dual;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM dual;
--숫자 -> 문자
--실제 자리수와 일치(자리수가 모자라면 오류)
SELECT TO_CHAR(1234,9999) FROM dual;
SELECT TO_CHAR(1234,'9999') FROM dual;
SELECT TO_CHAR(1234,'0000') FROM dual;--0000으로 명시하면 인식 못 함

--자리수 지정을 하지 않아도 숫자 -> 문자
SELECT TO_CHAR(1234) FROM dual;

--실제 자리수 보다 많은 자리수 지정
SELECT TO_CHAR(1234,99999) FROM dual;   -- 1234
SELECT TO_CHAR(1234,'99999') FROM dual; -- 1234
SELECT TO_CHAR(1234,'00000') FROM dual; --01234

--소수점 자리
SELECT TO_CHAR(1234,9999.99) FROM dual;     --1234.00
SELECT TO_CHAR(1234,'9999.99') FROM dual;   --1234.00
SELECT TO_CHAR(1234,'0000.00') FROM dual;   --1234.00

--반올림해서 소수점 둘째자리까지 표시
SELECT TO_CHAR(25.897,'99.99') FROM dual;--25.90
--인상된 급여를 소수점 첫째자리까지 표시
SELECT TO_CHAR(sal*1.15,'9,999.9') FROM emp;
--통화 표시
SELECT TO_CHAR(1234,'$0000') FROM dual;--$1234
--지역통화 표시
SELECT TO_CHAR(1234,'L0000') FROM dual;--\1234

--TO_DATE : 문자 -> 날짜
SELECT TO_DATE('25-01-29','YYYY-MM-DD') FROM dual;
--포맷형식 생략 가능
SELECT TO_DATE('26-01-29') FROM dual;

--TO_NUMBER : 문자 -> 숫자
SELECT TO_NUMBER('100','999') FROM dual;
--포맷 형식 생략 가능
SELECT TO_NUMBER('100') FROM dual;

--[실습]
--1)오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오.
SELECT LAST_DAY(SYSDATE) - SYSDATE AS "남은 날 수" FROM dual;
SELECT LAST_DAY('2026-01-29') - TO_DATE('2026-01-29') "남은 날 수"
FROM dual;
--2)각 사원에 대해 사원번호,이름,급여 및 15% 인상된 급여를 정수(반올림)
--  로 표시하시오. 인상된 급여열의 레이블을 New Salary로 지정하시오.
SELECT empno,ename,sal,ROUND(sal+sal*0.15) "New Salary" FROM emp;
SELECT empno,ename,sal,TO_CHAR(sal*1.15,'9999') "New Salary"
FROM emp;
--3)월급을 나눠서 4의 배수인 월급을 받는 사원의 이름과 월급을 출력하시오.
-- (세자리 단위 쉼표 표시)
SELECT ename,TO_CHAR(sal,'9,999') FROM emp 
WHERE MOD(sal,4)=0;
--4)사원이름,월급,월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력
--  하시오.단 NULL값은 나타나지 않게 작성하시오
-- (커미션 계약이 된 사람만 구하시오).
SELECT ename,sal,sal+comm 실급여 FROM emp 
WHERE comm IS NOT NULL;

--일반함수
--NVL(value1,value2):value1이 null이면 value2를 씀.
--                   value1과 value2의 자료형이 일치
SELECT ename,sal,NVL(comm,0)+sal "실급여" FROM emp;
SELECT ename,NVL(TO_CHAR(comm),'No Commission') "COMM." FROM emp;

--NVL2(value1,value2,value3):value1이 null인지 평가. null이면
--value3,null이 아니면 value2. 자료형이 일치하지 않아도 됨
SELECT ename,job,NVL2(comm,'commission','no commssion')
FROM emp;

--NULLIF(value1,value2):두 개의 값이 일치하면 null,
--                      두 개의 값이 일치하지 않으면 value1
SELECT NULLIF(LENGTH(ename),LENGTH(job)) "NULLIF" FROM emp;

--COALESCE(value1,value2,value3....):null값이 아니 값을 사용
--                                   자료형 일치
SELECT comm,sal,COALESCE(comm,sal,0) FROM emp;

--CASE 컬럼 WHEN 비교값 THEN 결과값
--          WHEN 비교값 THEN 결과값
--          WHEN 비교값 THEN 결과값
--         (ELSE 결과값)
--END

SELECT ename,sal,job,
       CASE job WHEN 'SALESMAN' THEN sal*0.1
                WHEN 'MANAGER' THEN sal*0.2
                WHEN 'ANALYST' THEN sal*0.3
                ELSE sal*0.4
       END "Bonus"
FROM emp;

SELECT ename,sal,job,
       CASE WHEN sal>=4000 AND sal<=5000 THEN 'A'
            WHEN sal>=3000 AND sal<4000 THEN 'B'
            WHEN sal>=2000 AND sal<3000 THEN 'C'
            WHEN sal>=1000 AND sal<2000 THEN 'D'
            ELSE 'F'
       END "Grade"
FROM emp ORDER BY sal DESC;

--짝수 해와 홀수 해에 입사한 사원의 정보 구하기
SELECT ename,hiredate,
       CASE MOD(EXTRACT(YEAR FROM hiredate),2)
            WHEN 0 THEN '짝수년도'
            ELSE '홀수년도'
       END AS 입사년도
FROM emp;

--오라클 전용
--DECODE: =비교만 가능. DECODE(컬럼,비교값,반환값,
--                                비교값,반환값,
--                                비교값,반환값,
--                                반환값)
SELECT ename,sal,job,
       DECODE(job,'SALESMAN',sal*0.1,
                  'MANAGER',sal*0.2,
                  'ANALYST',sal*0.3,
                  sal*0.4) "Bonus"
FROM emp;                  

SELECT ename,sal,job,
       DECODE(TRUNC(sal/1000),5,'A',
                              4,'A',
                              3,'B',
                              2,'C',
                              1,'D',
                              'F') "Grade"
FROM emp ORDER BY sal DESC;                              
                              
--특정 컬럼의 특정값을 먼저 오게 정렬하는 방법
-- ORDER BY (CASE 컬럼명 WHEN 비교값 THEN 1(순서)
--                      WHEN 비교값 THEN 2
--                      ELSE 3
--           END)

-- ORDER BY DECODE (컬럼명,비교값,1,
--                        비교값,2,
--                         3)

SELECT empno,ename,sal
FROM emp
ORDER BY (CASE empno WHEN 7698 THEN 1
          END), empno;
          
SELECT empno,ename,sal
FROM emp
ORDER BY DECODE(empno,7698,1),empno;

--[실습문제]
--1)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,
--  업무,월급,커미션,고용날짜를 출력하시오. 단, 고용날짜는 1980-12-17
--  형태로 출력하시오.
SELECT ename,job,sal,comm,
       TO_CHAR(hiredate,'YYYY-MM-DD') AS hiredate
FROM emp WHERE sal+NVL(comm,0)>=2000;
--2)DECODE 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
--모든 사원의 등급을 표시하는 질의를 작성하시오.
--업무        등급
--PRESIDENT    A
--ANALYST      B
--MANAGER      C
--SALESMAN     D
--CLERK        E
--기타          0
SELECT job,DECODE(job,'PRESIDENT','A',
                      'ANALYST','B',
                      'MANAGER','C',
                      'SALESMAN','D',
                      'CLERK','E',
                      '0') "Grade"
FROM emp ORDER BY job;

SELECT ename,sal,job,
       CASE job WHEN 'PRESIDENT' THEN 'A'
                WHEN 'ANALYST' THEN 'B'
                WHEN 'MANAGER' THEN 'C'
                WHEN 'SALESMAN' THEN 'D'
                WHEN 'CLERK' THEN 'E'
                ELSE '0'
        END "Grade"
FROM emp ORDER BY "Grade"; 

--[실습문제]
--1)사원이름과 업무를 쉼표(,)로 연결해서 표시하고 컬럼명은
--  Employee and Job으로 표시하시오.
SELECT ename || ',' || job "Employee and Job" FROM emp;
--2)부서번호(deptno) 30에서 근무하며 월2,000달러 이하를 받는
-- 81년5월1일 이전에 입사한 사원의 이름,급여,부서번호,일사일을 출력하시오.
SELECT ename,sal,deptno,hiredate FROM emp
WHERE deptno=30 AND sal<=2000 AND hiredate < '81-05-01';
--3)사원이름에 A 또는 E가 있는 모든 사원의 이름을 표시하시오.
SELECT ename FROM emp WHERE ename LIKE '%A%' OR ename LIKE '%E%';
SELECT ename FROM emp 
WHERE INSTR(ename,'A')>0 OR INSTR(ename,'E')>0;
--4)사원이름 중 S가 포함되지 않은 사람들 중 부서번호가 20인 사원들의
-- 이름과 부서번호를 출력하시오.
SELECT ename,deptno FROM emp 
WHERE ename NOT LIKE '%S%' AND deptno=20;
--5)직속상사(mgr)가 없는 모든 사원의 이름과 업무를 표시하시오.
SELECT ename,job FROM emp WHERE mgr IS NULL;
--6)커미션 항목이 입력된 사원들의 이름과 급여,커미션을 구하시오.
SELECT ename,sal,comm FROM emp WHERE comm IS NOT NULL;
--7)이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오.
SELECT LOWER(ename) FROM emp WHERE LENGTH(ename)>=6;
--8)각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달 수)
--  를 계산하여 열레이블을 MONTHS_WORKED로 지정하시오.결과는 정수로
--  절삭하고 근무 달 수를 기준으로 오름차순으로 정렬
SELECT ename,
       TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) "MONTHS_WORKED"
FROM emp ORDER BY "MONTHS_WORKED";       
--9)이름(소문자로 표시),업무,근무연차를 출력하시오.(결과는 정수로 절삭)
SELECT LOWER(ename),job,
       TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)/12) 근무연차
FROM emp;

--그룹함수:행 집합 연산을 수행하여 그룹별로 하나의 결과를 산출
--AVG() : NULL을 제외한 모든 값들의 평균을 반환.
--        NULL값은 평균 계산에서 무시됨
SELECT AVG(sal) FROM emp;
--COUNT() : NULL을 제외한 값을 가진 모든 레코드의 수를 반환
--          COUNT(*)형식을 사용하면 NULL도 계산에 포함
SELECT COUNT(*) FROM emp;--전체 행(레코드)수
SELECT COUNT(comm) FROM emp;--커미션을 받는 수
--MAX() : 레코드 내에 있는 여러 값 중 가장 큰 값을 반환
SELECT MAX(sal) FROM emp;
SELECT MAX(ename) FROM emp;
SELECT MAX(hiredate) FROM emp;
--MIN() : 레코드 내에 있는 여러 값 중 가장 작은 값을 반환
SELECT MIN(sal) FROM emp;
SELECT MIN(ename) FROM emp;
--SUM() : 레코드들이 포함하고 있는 모든 값을 더하여 반환
SELECT SUM(sal) FROM emp;
       
SELECT MAX(sal), MIN(sal), AVG(sal), SUM(sal) FROM emp;

SELECT MAX(sal),MIN(sal),AVG(sal),SUM(sal) 
FROM emp WHERE deptno=10;
SELECT COUNT(*) FROM emp WHERE deptno=20;--20부서의 사원수       
SELECT COUNT(empno) FROM emp WHERE deptno=20;--20부서의 사원수
SELECT COUNT(NVL(comm,0)) FROM emp;--null값가지 카운트하고 싶은 경우
       
--GROUP BY 절
--SELECT문에서 그룹함수 적용시 개별 컬럼을 지정할 수 없음.
--개별 컬럼을 지정하고 싶으면 그 개별 컬럼으로 그룹핑하면 그룹함수 사용시
--개별 컬럼 사용이 가능함

--부서별 최대급여,최소급여,평균급여,급여합계를 구하기
SELECT deptno,MAX(sal),MIN(sal),AVG(sal),SUM(sal)
FROM emp GROUP BY deptno;
--부서안의 직업별 최대급여,부서번호,직업를 표시하기
SELECT MAX(sal),deptno,job FROM emp
GROUP BY deptno,job ORDER BY deptno;

--그룹핑 후 10번 부서로 한정
SELECT deptno,job,SUM(sal) FROM emp
WHERE deptno=10
GROUP BY deptno,job ORDER BY deptno;

--그룹 처리 결과를 제한하고자 할 때 HAVING절 사용
--WHERE절에는 그룹함수를 사용할 수 없고 HAVING절을 이용
--오류발생
SELECT deptno,ROUND(AVG(sal)) FROM emp
WHERE ROUND(AVG(sal))>2000
GROUP BY deptno;

--정상구문
SELECT deptno,ROUND(AVG(sal)) FROM emp
GROUP BY deptno HAVING ROUND(AVG(sal))>2000;

--그룹 함수 중첩
SELECT MAX(AVG(sal)) FROM emp GROUP BY deptno;

--짝수 해와 홀수 해에 입사한 사원의 인원수 구하기
SELECT CASE MOD(EXTRACT(YEAR FROM hiredate),2)
            WHEN 0 THEN '짝수년도'
            ELSE '홀수년도'
       END AS YEAR,
       COUNT(empno) AS employee_number
FROM emp
GROUP BY MOD(EXTRACT(YEAR FROM hiredate),2);

--1981년에 입사한 사원들의 목록으로부터 분기별 입사자의 수를 구함
SELECT TO_CHAR(hiredate,'Q') AS "Quarter",
       COUNT(empno) AS employee_number
FROM emp WHERE EXTRACT(YEAR FROM hiredate)=1981
GROUP BY TO_CHAR(hiredate,'Q') ORDER BY "Quarter";

--[실습문제]
--1)모든 사원의 급여 최고액,최저액,총액 및 평균액을 표시하고 열 레이블을
--  각각 maximum,minimum,sum 및 average로 지정하고 결과를 정수로
--  반올림하고 세자리 단위로 ,를 명시하시오.
SELECT TO_CHAR(MAX(sal),'9,999') maximum,
       TO_CHAR(MIN(sal),'9,999') minimum,
       TO_CHAR(SUM(sal),'99,999') sum,
       TO_CHAR(AVG(sal),'9,999') average
FROM emp;
--2)급여와 커미션을 더한 금액의 최고,최저,평균금액을 구하시오.
-- 평균금액은 소수점 첫째자리까지 표시하시오.
SELECT MAX(sal+NVL(comm,0)) max, MIN(sal+NVL(comm,0)) min,
       ROUND(AVG(sal+NVL(comm,0)),1) avg
FROM emp;
--3)업무와 업무가 동일한 사원수를 표시하시오.(업무별 사원수를 구하시오)
SELECT job,COUNT(*) cnt FROM emp 
GROUP BY job ORDER BY cnt DESC;
--4)30번부서의 사원수를 구하시오.
--부서번호를 명시하지 않은 경우
SELECT COUNT(*) FROM emp WHERE deptno=30;
--부서번호와 사원수 명시
SELECT deptno,COUNT(*) FROM emp 
WHERE deptno=30 GROUP BY deptno;

SELECT deptno,COUNT(*) FROM emp
GROUP BY deptno HAVING deptno=30;

--5)업무별 최고 월급을 구하고 업무,최고 월급을 출력하시오.
SELECT job,MAX(sal) FROM emp GROUP BY job;
--6)20번부의 급여 합계를 구하고 급여 합계 금액을 출력하시오.
SELECT SUM(sal) FROM emp WHERE deptno=20;
--부서번호,급여 합계 명시
SELECT deptno,SUM(sal) FROM emp 
WHERE deptno=20 GROUP BY deptno;
--7)부서별로 지급되는 총월급에서 금액이 9,000이상을 받는 사원들의
--  부서번호,총월급을 출력하시오.
SELECT deptno,SUM(sal) FROM emp 
GROUP BY deptno HAVING SUM(sal)>=9000;

--분석함수
--RANK():순위를 표현할 때 사용하는 함수
--RANK(조건값) WITH GROUP (ORDER BY 조건값 컬럼명 [ASC|DESC])
--특정 데이터의 순위 확인
--(주의)RANK 뒤에 나오는 데이터와 ORDER BY 뒤에 나오는 데이터는
--같은 컬럼이어야 함.
SELECT RANK('SMITH') WITHIN GROUP (ORDER BY ename) "RANK"
FROM emp;--10
SELECT ename FROM emp ORDER BY ename;--SMITH가 10번재 조회됨

--전체순위보기
--RANK() OVER
--OVER절 다음 순위를 만들려면 정렬(ORDER BY)은 필수이며 그룹을
--나누어 (PARTITION BY) 순위를 만드는 경우는 선택 사항

--사원들의 empno,ename,sal,급여 순위를 출력
SELECT empno,ename,sal, 
       RANK() OVER (ORDER BY sal) AS RANK_ASC,
       RANK() OVER (ORDER BY sal DESC) AS RANK_DESC 
FROM emp;

--10번 부서에 속한 직원들의 사번과 이름,급여,해당 부서 내의 
--급여 순위를 출력
SELECT empno,ename,sal,
       RANK() OVER (ORDER BY sal DESC) "RANK"
FROM emp WHERE deptno=10;

--emp테이블을 조회하여 사번,이름,급여,부서번호,부서별 급여 순위를 출력
SELECT empno,ename,sal,deptno,
       RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;  

--emp테이블을 조회하여 empno,ename,sal,deptno,job, 같은 부서 내의
--직업별 급여 순위를 출력
SELECT empno,ename,sal,deptno,job,
       RANK()OVER(PARTITION BY deptno,job ORDER BY sal DESC) "RANK"
FROM emp;

--[실습문제]
--8)업무별로 가장 늦은 사번을 구하고 그 결과 내에서 사번이 79로 시작하는
--  결과만 보여주시오.
SELECT job,MAX(empno) FROM emp 
GROUP BY job HAVING MAX(empno) LIKE '79%';

SELECT job,MAX(empno) FROM emp
WHERE empno LIKE '79%' GROUP BY job;

--9)업무별 총월급을 출력하는데 업무가 'MANAGER'인 사원들은 제외하고 
--  총월급이 5,000보다 많은 업무와 총월급만 출력하시오.
SELECT job,SUM(sal) FROM emp WHERE job != 'MANAGER'
GROUP BY job HAVING SUM(sal)>5000;
--10)업무별로 사원의 수가 4명 이상인 업무와 인원수를 출력하시오.
SELECT job,COUNT(*) FROM emp 
GROUP BY job HAVING COUNT(*)>=4; 
--11)부서별 급여평균을 구할 때 소수점 3자리에서 반올림해서 2자리까지 
--   구하고 부서번호,급여평균을 출력하시오.
SELECT deptno,ROUND(AVG(sal),2) FROM emp GROUP BY deptno;
--12)분기별로 입사한 사원수를 구하는데 2분기에 입사한 사원수만 구하시오.
SELECT COUNT(empno) FROM emp 
WHERE TO_CHAR(hiredate,'Q')=2;

SELECT TO_CHAR(hiredate,'Q') "QUARTER",
       COUNT(empno) 사원수 
FROM emp WHERE TO_CHAR(hiredate,'Q')=2
GROUP BY TO_CHAR(hiredate,'Q');

--JOIN
--둘 이상의 테이블을 연결하여 데이터를 검색하는 방법

--카티션 곱(Cartesian Product)
--검색하고자 했던 데이터뿐 아니라 조인에 사용된 테이블들의
--모든 데이터가 반환되는 현상
SELECT * FROM emp,dept;

--오라클 전용
--동등 조인
--조건절 Equality Condition(=)에 의하여 조인이 이루어 짐
SELECT emp.ename,dept.dname FROM emp,dept
WHERE emp.deptno=dept.deptno; 

--테이블에 알리아스 부여하기
SELECT e.ename,d.dname FROM emp e,dept d
WHERE e.deptno=d.deptno;

--컬럼명을 호출할 때 테이블명 또는 테이블 알리아스를 생략
SELECT ename,e.deptno,dname FROM emp e,dept d
WHERE e.deptno=d.deptno;

--추가적인 조건 명시
SELECT e.ename,d.dname FROM emp e,dept d
WHERE e.deptno=d.deptno AND e.ename='ALLEN';

SELECT e.ename,e.sal,d.dname FROM emp e,dept d
WHERE e.deptno=d.deptno AND e.sal BETWEEN 3000 AND 4000;

--비동등 조인(NON EQUI JOIN)
--테이블의 어떤 COLUMN도 JOIN할 테이블의 COLUMN에 일치하지 않을 때
--사용하고 조인 조건은 동등(=)이외의 연산자를 갖음
--(BETWEEN AND,IS NULL,IS NOT NULL, IN, NOT IN)

--사원이름,급여,급여등급 구하기(emp,salgrade 테이블 이용)
SELECT e.ename,e.sal,s.grade FROM emp e,salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

--SELF JOIN
--사원이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원 제외)
SELECT e.ename 사원이름,m.ename 관리자이름
FROM emp e, emp m WHERE e.mgr=m.empno;

--외부 조인(OUTER JOIN)
--동등 조인은 두 개의 테이블의 두 개의 컬럼에서 공통된 값이
--없다면 테이블로부터 데이터를 반환하지 않는다.
--누락된 행을 보이게 하려면 OUTER JOIN 사용

--누락된 행의 반대 테이블의 조인 조건의 컬럼에 (+)기호 표시
SELECT DISTINCT(e.deptno) "emp의 deptno",
       d.deptno "dept의 deptno" 
FROM emp e, dept d WHERE e.deptno(+)=d.deptno;

--사원이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원도 표시)
SELECT e.ename 사원이름, m.ename 관리자이름
FROM emp e,emp m WHERE e.mgr=m.empno(+)

--[실습문제]
--1)모든 사원의 이름,부서번호,부서이름을 표시하시오.(emp,dept)
SELECT e.ename,d.deptno,d.dname FROM emp e,dept d
WHERE e.deptno = d.deptno;
--2)업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로 출력
SELECT e.ename,e.job,d.dname,d.loc FROM emp e,dept d
WHERE e.deptno=d.deptno AND e.job='MANAGER';
--3)커미션을 받고 급여가 1,600이상인 사원의 사원이름,급여,부서명,근무지를
-- 출력하시오.
SELECT e.ename,e.sal,d.dname,d.loc FROM emp e,dept d
WHERE e.deptno = d.deptno AND e.comm IS NOT NULL AND e.sal>=1600;
--4)근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 
-- 표시하시오.
SELECT e.ename,e.job,d.deptno,d.dname FROM emp e,dept d
WHERE e.deptno=d.deptno AND d.loc='CHICAGO';
--5)근무지별로 근무하는 사원의 수가 5명이하인 경우,인원이 적은 도시 순으로
--  정렬하시오.(근무 인원이 0명인 곳도 표시)
SELECT d.loc,COUNT(e.empno) emp_member FROM emp e,dept d
WHERE e.deptno(+)=d.deptno GROUP BY d.loc
HAVING COUNT(e.empno)<=5 ORDER BY emp_member ASC;
--6)사원이름 및 사원 번호를 관리자의 이름과 관리자 번호와
--  함께 표시하고 각각의 레이블은 employee,emp#,manager,magr#로
--  지정하시오(관리자가 없는 사원 미출력)
SELECT e.ename employee,e.empno "emp#",m.ename manger,
       m.empno "mgr#"
FROM emp e,emp m WHERE e.mgr = m.empno;
--7)관리자보다 먼저 입사한 모든 사원의 이름,사원 입사일,관리자 이름,
--관리자 입사일과 함께 표시하고 열 레이블을 각각 employee,emp hired,
-- manager,mgr hired로 지정하시오(관리자가 없는 사원 미출력)
SELECT e.ename employee,e.hiredate "emp hired",
       m.ename manager,m.hiredate "mgr hired"
FROM emp e,emp m 
WHERE e.mgr = m.empno 
AND e.hiredate < m.hiredate;
--8)지정한 부서번호,사원이름 및 지정한 사원과 동일한 부서에서
--  근무하는 모든 사원을 표시하도록 질의를 작성하고 부서번호는
-- department,사원이름은 employee,동일한 부서에서 근무하는
--사원은 colleague로 표시하오.(부서번호,사원이름,동료 순으로 
--오름차순 정렬)
SELECT e.deptno department, e.ename employee, c.ename colleague
FROM emp e,emp c 
WHERE e.deptno=c.deptno
AND e.empno <> c.empno
ORDER BY e.deptno,e.ename,c.ename;
--9)10번 부서에서 근무하는 사원들의 부서번호,부서이름,사원이름,월급,
--  급여등급을 출력하시오.
SELECT d.deptno,d.dname,e.ename,e.sal,s.grade
FROM emp e,dept d,salgrade s
WHERE e.deptno=d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND e.deptno=10;

--표준 SQL
--내부 조인(inner join)
--inner join 이라고 해도 되고 join만 명시 가능
SELECT emp.ename,dept.deptno
FROM emp INNER JOIN dept
ON emp.deptno=dept.deptno;

SELECT e.ename,d.dname
FROM emp e INNER JOIN dept d
ON e.deptno=d.deptno;

--JOIN 사용시 ON절을 정의하고 부가적인 조건이 있으면 WHERE절 사용
SELECT e.ename,d.dname FROM emp e JOIN dept d
ON e.deptno=d.deptno WHERE e.ename='ALLEN';

--만약 조인 조건에 사용된 컬럼의 이름이 같다면 다음과 같이 USING절을
--사용하여 조인 조건을 정의할 수 있음.
--(주의)USING에 사용된 컬럼은 테이블명 또는 테이블 알리아스를 붙이지
--않음
SELECT e.ename,d.dname, deptno FROM emp e JOIN dept d
USING(deptno) WHERE e.ename='ALLEN';

SELECT ename,dname,deptno FROM emp JOIN dept
USING(deptno);

--SELF JOIN
--사원이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원은 제외)
SELECT e.ename name,m.ename manager_name
FROM emp e JOIN emp m
ON e.mgr = m.empno;

--외부 조인(OUTER JOIN)
--누락된 행의 방향 표시
SELECT DISTINCT(e.deptno),d.deptno
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno;

--사원이름과 해당 사원의 관리자 이름 구하기(관리자가 없는 사원도 표시)
SELECT e.ename name,m.ename manager_name
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

--10번부서에서 근무하는 사원들의 부서번호,부서이름,사원이름,월급,
--급여등급을 출력하시오.
SELECT e.deptno,d.dname,e.ename,e.sal,s.grade
FROM emp e INNER JOIN dept d
ON e.deptno=d.deptno
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.deptno=10;

--[실습문제]
--1)업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로
--  출력하시오.
SELECT e.ename,e.job,d.dname,d.loc FROM emp e JOIN dept d
ON e.deptno=d.deptno WHERE e.job='MANAGER';
--2)근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을
--  표시하시오.
SELECT e.ename,e.job,d.deptno,d.dname FROM emp e JOIN dept d
ON e.deptno=d.deptno WHERE d.loc='CHICAGO';
--3)근무지별로 근무하는 사원의 수가 5명이하인 경우,인원이 적은 도시
--  순으로 정렬하시오.(근무 인원이 0명인 곳도 표시)
SELECT d.loc, COUNT(e.empno) emp_member FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno=d.deptno GROUP BY d.loc
HAVING COUNT(e.empno)<=5 ORDER BY emp_member;
--4)지정한 부서번호,사원이름 및 지정한 사원과 동일한 부서에서 근무하는
--모든 사원을 표시하도록 질의를 작성하고 부서번호는 department,
--사원이름은 employee,동일한 부서에서 근무하는 사원은 colleague로
--표시하시오.(부서번호,사원이름,동료 순으로 오름차순 정렬)
SELECT e.deptno department, e.ename employee, c.ename colleague
FROM emp e JOIN emp c ON e.deptno=c.deptno
WHERE e.empno<>c.empno ORDER BY e.deptno,e.ename,c.ename;
--5)커미션이 책정된 사원들의 사원번호,사원이름,연봉,급여+커미션,
--  실급여등급을 출력.
SELECT e.empno 사원번호,e.ename 이름,e.sal*12 연봉, 
       e.sal+e.comm 실급여, s.grade 급여등급
FROM emp e JOIN salgrade s
ON e.sal+e.comm BETWEEN s.losal AND s.hisal
WHERE e.comm IS NOT NULL;

--집합연산자
--union(합집합 중복값 제거)
--union은 두 테이블이 결합을 나타내며, 결합시키는 두 테이블의 중복되지
--않은 값들을 반환
SELECT deptno FROM emp
UNION
SELECT deptno FROM dept;

--union all
--union과 같으나 두 테이블의 중복되는 값까지 반환
SELECT deptno FROM emp
UNION ALL
SELECT deptno FROM dept;

--intersect
--intersect는 두 행의 집합 중 공통된 행을 반환
SELECT deptno FROM emp
INTERSECT
SELECT deptno FROM dept;

--minus
--minus는 첫 번째 SELECT문에 의해 반환되는 행 중에서 두 번째 
--SELECT문에 의해 반환되는 행에 존재하지 않는 행들을 보여줌
SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

--Subquery : 하나의 SQL 문장의 절에 nested된 select 문장
--단일행 서브쿼리 : 오직 한 개의 행(값)을 반환
--사원번호가 7369인 사원과 직업이 동일한 사원의 사번,이름,월급을 구하시오
SELECT empno,ename,job FROM emp 
WHERE job=(SELECT job FROM emp 
           WHERE empno=7369);

--사원번호가 7654인 사원과 부서가 동일한 사원의 사번,이름,부서번호를 구하시오
SELECT empno,ename,deptno FROM emp
WHERE deptno=(SELECT deptno FROM emp
              WHERE empno=7654);
              
--사원번호가 7698인 사원의 급여보다 급여를 많이 받는 사원의
--사번,이름,급여를 구하시오
SELECT empno,ename,sal 
FROM emp
WHERE sal > (SELECT sal 
             FROM emp 
             WHERE empno=7698);

--다중 행 서브쿼리
--하나 이상의 행을 반환하는 서브쿼리
--IN 연산자의 사용
--부서별로 가장 급여를 적게 받는 사원과 동일한 급여를 받는 사원의
--정보를 출력하시오
SELECT empno,ename,sal,deptno 
FROM emp
WHERE sal IN(SELECT MIN(sal) 
             FROM emp 
             GROUP BY deptno);

--any(some) 연산자의 사용
--any 연산자는 서브쿼리의 결과값 중 어느 하나의 값이라도 만족이 
--되면 결과값을 반환
SELECT sal FROM emp WHERE job = 'SALESMAN';
SELECT ename,sal FROM emp 
WHERE sal>1250 OR sal>1500 OR sal>1600;
--서브쿼리로 표시
SELECT ename,sal FROM emp
WHERE sal > ANY(SELECT sal FROM emp 
                WHERE job = 'SALESMAN');

--all 연산자의 사용
--서브 쿼리의 결과와 모든 값이 일치
SELECT sal FROM emp WHERE deptno=20;
SELECT empno,ename,sal,deptno FROM emp 
WHERE sal > 800 AND sal > 2975 AND sal > 3000;
--서브쿼리로 표시
SELECT empno,ename,sal,deptno FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno=20);

--다중열 서브 쿼리
SELECT empno,ename,sal,deptno
FROM emp
WHERE (deptno,sal) IN(SELECT deptno,sal 
                      FROM emp WHERE deptno=20);    

--부서별로 가장 급여를 적게 받는 사원의 정보를 출력
SELECT empno,ename,sal,deptno FROM emp
WHERE (deptno,sal) IN (SELECT deptno,MIN(sal) 
                       FROM emp GROUP BY deptno);
--부서별로 가장 급여를 적게 받는 사원과 동일 급여를 받는
--사원의 정보를 출력
SELECT empno,ename,sal,deptno FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

--인라인뷰
--메인 쿼리의 FROM절을 서브 쿼리로 이용하는 방법
--급여가 20번부서의 평균 급여보다 많은 급여를 받는 사원의 사번,이름,
--부서명 출력
SELECT e.empno,e.ename,e.sal,d.dname 
FROM (SELECT * FROM emp 
     WHERE sal>(SELECT AVG(sal) 
                FROM emp WHERE deptno=20)) e JOIN dept d
USING(deptno);

SELECT e.empno,e.ename,e.sal,d.dname FROM emp e JOIN dept d
USING(deptno) WHERE sal > (SELECT AVG(sal) FROM emp
                           WHERE deptno=20);

--부서별로 부서번호,부서명,급여총액을 출력하시오.
SELECT deptno,dname,total FROM dept JOIN
(SELECT deptno,SUM(sal) total FROM emp GROUP BY deptno)
USING(deptno);

--스칼라 서브 쿼리
--결과값이 단일 행, 단일 열의 스칼라값(단일 값)으로 반환.
--만약 결과값이 다중 행이거나 다중 열이라면 DBMS는 그 중
--어떠한 행, 어떠한 열을 출력해야 하는지 알 수 없어 에러를
--출력
SELECT deptno,(SELECT dname FROM dept WHERE deptno=e.deptno),SUM(sal) 
FROM emp e GROUP BY deptno;

--[실습문제]
--1)"BLAKE"와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데
--  "BLAKE"는 제외하고 출력하시오.
SELECT ename,hiredate FROM emp 
WHERE deptno IN(select deptno FROM emp
                WHERE ename='BLAKE')
AND ename != 'BLAKE';
--2)평균급여보다 많은 급여를 받는 사원들의 사원번호,이름,월급을
--  출력하는데 월급이 높은 사람순으로 출력하시오.
SELECT empno,ename,sal FROM emp
WHERE sal>(SELECT AVG(sal) FROM emp)
ORDER BY sal DESC;
--3)10번부서에서 급여를 가장 적게 받는 사원과 동일한 급여를 받는
--사원의 이름과 월급을 출력하시오.
SELECT ename,sal FROM emp 
WHERE sal = (SELECT MIN(sal) FROM emp WHERE deptno=10);
--4)부서별 사원수를 구하고 사원수가 3명이하의 부서의 부서명과 사원수를
--  출력하시오.
SELECT d.dname,COUNT(e.empno)cnt
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno
GROUP BY d.dname
HAVING COUNT(E.empno) <=3;

SELECT d.dname,NVL(b.cnt,0) FROM dept d, 
                    (SELECT deptno,COUNT(empno) cnt 
                     FROM emp GROUP BY deptno) b
WHERE d.deptno=b.deptno(+) AND NVL(b.cnt,0) <= 3;                     
--5)사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 
--  출력하시오.
SELECT ename,hiredate FROM emp
WHERE hiredate < (SELECT hiredate FROM emp WHERE empno=7844);
--6)직속상사(mgr)가 KING인 모든 사원의 이름과 급여를 출력하시오.
SELECT ename,sal FROM emp
WHERE mgr IN (SELECT empno FROM emp WHERE ename='KING');
--7)20번 부서에서 가장 큰 급여를 많이 받는 사원과 동일한 급여를 받는
--  사원의 이름과 부서명,급여,급여등급을 출력하시오.
SELECT e.ename,d.dname,e.sal,s.grade 
FROM emp e JOIN dept d
ON e.deptno=d.deptno
JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.sal = (SELECT MAX(sal) FROM emp WHERE deptno=20);
--8)총급여(sal+comm)가 평균 급여(AVG(sal))보다 많은 급여를 받는 
--  사람의 부서번호,이름,총급여,커미션을 출력하시오.(커미션 유(O),
--  무(X)로 표시하고 컬럼명은 "comm유무"로 출력)
SELECT deptno,ename,sal+NVL(comm,0) AS 총급여,
       CASE WHEN comm IS NOT NULL THEN 'O'
            ELSE 'X'
       END AS comm유무
FROM emp
WHERE sal+NVL(comm,0)>(SELECT AVG(sal) FROM emp);

SELECT deptno,ename,sal+NVL(comm,0) AS 총급여,
       NVL2(comm,'O','X') AS comm유무
FROM emp
WHERE sal+NVL(comm,0)>(SELECT AVG(sal) FROM emp);

--9)CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는
--  사원의 이름과 급여,지역명을 출력하시오.
SELECT e.ename,e.sal,d.loc FROM emp e, dept d
WHERE e.deptno=d.deptno
AND e.sal > (SELECT AVG(e.sal) FROM emp e, dept d
             WHERE e.deptno=d.deptno
             AND d.loc='CHICAGO');
             
SELECT e.ename,e.sal,d.loc FROM emp e,dept d
WHERE e.deptno=d.deptno
AND e.sal > (SELECT AVG(sal) FROM emp 
             WHERE deptno IN (SELECT deptno FROM dept 
                              WHERE loc='CHICAGO'));
             
--10)커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을
--  출력하시오.
SELECT e.ename,s.grade FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
AND e.sal = (SELECT MAX(sal) FROM emp WHERE comm IS NULL);
--11)SMITH의 직속상사(mgr)의 이름과 부서명,근무지역을 출력하시오.
SELECT e.ename,d.dname,d.loc FROM emp e JOIN dept d
USING(deptno)
WHERE e.empno IN (SELECT mgr FROM emp WHERE ename='SMITH');
--12)ALLEN 보다 급여를 많이 받는 사람 중에서 입사일이 가장 빠른 사원과
--   동일한 날짜에 입사한 사원의 이름과 입사일, 급여를 출력하시오.
SELECT ename,hiredate,sal FROM emp 
WHERE hiredate = (SELECT MIN(hiredate) FROM emp 
                  WHERE sal > ALL(SELECT sal FROM emp 
                                  WHERE ename='ALLEN'));

--INSERT문
--테이블에 행을 삽입
--전체 데이터 삽입(전체 컬럼 명시)
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8000,'DENNIS','SALESMAN',7698,'99/02/02',1700,200,30);

--전체 데이터를 삽입할 때는 컬럼명 생략 가능
INSERT INTO emp 
VALUES (8001,'SUNNY','SALESMAN',7698,'99/03/01',1000,100,30);

--NULL 삽입 방법
--값이 입력되지 않는 컬럼은 제외
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,deptno)
VALUES (8002,'PETER','CLERK',7698,'99/11/06',1800,20);

--값이 입력되지 않는 컬럼을 제외하지 않았을 경우
INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)
VALUES (8003,'MICHAEL','CLERK',7698,'99/12/01',1500,NULL,30);

--UPDATE문
--행 단위로 데이터 갱신
UPDATE emp SET mgr=7900 WHERE empno=8000;
UPDATE emp SET ename='KIM',sal=1200 WHERE empno=8001;

--(주의)WHERE절을 명시하지 않으면 모든 행의 데이터가 변경
UPDATE emp SET job='MANAGER' WHERE empno=8001;

--서브 쿼리로 두 열 갱신
UPDATE emp 
SET job = (SELECT job FROM emp
           WHERE empno=7839),
    sal = (SELECT sal FROM emp
           WHERE empno=7839)
WHERE empno=7369;

--DELETE문
--행을 삭제
--(주의)WHERE절을 명시하지 않으면 모든 행이 삭제됨
DELETE FROM emp WHERE empno=8000;

--데이터베이스 객체
--테이블,뷰,시퀀스,인덱스,동의어

--테이블
--사용자 테이블 : 사용자가 생성 및 유지 관리하는 테이블
--데이터 딕셔너리 : Oracle Server가 생성 및 유지 관리하는 테이블

--데이터 딕셔너리 질의
--사용자가 소유한 테이블의 이름
SELECT table_name FROM user_tables;

--사용자가 소유한 개별 객체 유형
SELECT DISTINCT object_type FROM user_objects;

--사용자가 소유한 테이블,뷰,동의어 및 시퀀스
SELECT * FROM user_catalog;

--컬럼의 구조에 대한 상세정보 조회
DESCRIBE emp;
DESC emp;

--테이블 생성
CREATE TABLE employee(
 empno NUMBER(6),
 name VARCHAR2(30) NOT NULL,
 salary NUMBER(8,2),
 hire_date DATE DEFAULT SYSDATE,
 CONSTRAINT employee_pk PRIMARY KEY (empno)
);

DESC employee;

INSERT INTO employee (empno,name,salary)
VALUES (100,'홍길동',100.23);
COMMIT;
SELECT * FROM employee;

--Primary Key & Foreign Key 제약조건 사용하기
CREATE TABLE suser(
 id VARCHAR2(20),
 name VARCHAR2(30),
 CONSTRAINT suser_pk PRIMARY KEY(id)
);

CREATE TABLE sboard(
 num NUMBER,
 id VARCHAR2(20) NOT NULL,
 content VARCHAR2(4000) NOT NULL,
 CONSTRAINT sboard_pk PRIMARY KEY(num),
 CONSTRAINT sboard_fk FOREIGN KEY (id) REFERENCES suser(id)
);

INSERT INTO suser (id,name) VALUES ('SKY','홍길동');
INSERT INTO suser (id,name) VALUES ('BLUE','박문수');
INSERT INTO suser (id,name) VALUES ('ONE','장영실');
COMMIT;

SELECT * FROM suser;

INSERT INTO sboard (num,id,content) VALUES (1,'SKY','하하');
INSERT INTO sboard (num,id,content) VALUES (2,'BLUE','호호');
INSERT INTO sboard (num,id,content) VALUES (3,'ONE','크크');
COMMIT;

--FOREIGN KEY 제약 조건이 적용되어서 자식 데이터가 있을 경우
--부모 데이터를 삭제할 수 없음
DELETE FROM suser WHERE id='SKY';

--테이블의 관리
--ADD연산자 : 테이블에 새로운 컬럼 추가
ALTER TABLE employee ADD(addr VARCHAR2(50));
--제약조건 추가
ALTER TABLE employee ADD CONSTRAINT employee_pk PRIMARY KEY(empno);
--MODIFY 연산자 : 테이블의 컬럼을 수정하거나 NOT NULL컬럼으로 변경
ALTER TABLE employee MODIFY(salary NUMBER(10,2) NOT NULL);
--DROP 연산자 : 컬럼의 삭제
ALTER TABLE employee DROP COLUMN name;
--RENAME 연산자 : 컬럼명 변경
ALTER TABLE employee RENAME COLUMN salary TO sal;
--테이블명 변경
RENAME employee TO employee2;
--테이블 삭제
DROP TABLE employee2;

--ON DELETE CASCADE : 부모 테이블의 컬럼을 삭제하면 자식 테이블의 
--데이터를 모두 삭제
CREATE TABLE s_member(
 id VARCHAR2(20) PRIMARY KEY,
 name VARCHAR2(30)
);
CREATE TABLE s_member_detail(
 num NUMBER PRIMARY KEY,
 content VARCHAR2(4000) NOT NULL,
 id VARCHAR2(20) NOT NULL REFERENCES s_member(id) 
                          ON DELETE CASCADE
);

DELETE FROM s_member WHERE id='SKY';

SELECT * FROM s_member_detail;

--ON DELETE SET NULL
CREATE TABLE s_member2(
 id VARCHAR2(20) PRIMARY KEY,
 name VARCHAR2(20)
);
CREATE TABLE s_member_detail2(
 num NUMBER PRIMARY KEY,
 text VARCHAR2(4000) NOT NULL,
 id VARCHAR2(20) REFERENCES s_member2(id) ON DELETE SET NULL 
);

DELETE FROM s_member2 WHERE id='SKY';

SELECT * FROM s_member_detail2;

--[실습문제]
--1)student라는 이름으로 테이블을 생성
--컬럼명     id           name         age       score
--데이터타입 varchar2(10) varchar2(30) number(3)  number(3)
--제약 조건  primary key   not null    not null    not null
CREATE TABLE student(
 id VARCHAR2(10) PRIMARY KEY,
 name VARCHAR2(30) NOT NULL,
 age NUMBER(3) NOT NULL,
 score NUMBER(3) NOT NULL
);
--2)아래와 같이 데이터 입력
--id       name     age     score
--dragon  홍길동    21      100
--sky     장영실    22      99
--blue    박문수    34      88
INSERT INTO student (id,name,age,score) 
VALUES ('dragon','홍길동',21,100);
INSERT INTO student (id,name,age,score) 
VALUES ('sky','장영실',22,99);
INSERT INTO student (id,name,age,score) 
VALUES ('blue','박문수',34,98);
COMMIT;
--3)데이터 읽기 : Student 테이블에서 성적 합계를 구하시오.
SELECT SUM(score) FROM student;

--뷰(VIEW)
--논리적으로 하나 이상의 테이블에 있는 데이터의 부분 집합
--1)복잡한 질의를 쉽게 작성하기 위해
--2)데이터 독립성을 제공하기 위해
--3)동일한 데이터로부터 다양한 결과를 얻기 위해

--뷰 생성
CREATE OR REPLACE VIEW emp10_view
AS SELECT empno id_number,ename name,sal*12 ann_salary
   FROM emp WHERE deptno=10;

SELECT * FROM emp10_view;

--view의 구조 확인
DESC emp10_view;

CREATE OR REPLACE VIEW emp_info_view 
AS SELECT e.empno,e.ename,d.deptno,d.loc,d.dname
   FROM emp e, dept d
   WHERE e.deptno=d.deptno;
   
SELECT * FROM emp_info_view;

--VIEW를 통한 데이터 변경하기
--일반적으로 view는 조회용으로 많이 사용되지만 
--아래와 같이 데이터를 변경할 수 있음
UPDATE emp10_view SET name='SCOTT' WHERE id_number=7839;
SELECT * FROM emp10_view;
SELECT * FROM emp;--emp테이블의 KING이 SCOTT로 변경됨

INSERT INTO emp10_view (id_number,name,ann_salary)
VALUES (8000,'JOHN',19000);--"가상 열은 사용할 수 없습니다." 오류 발생

INSERT INTO emp10_view (id_number,name)
VALUES (8000,'JOHN');

--10번부서만 보여지게 제한이 걸려서 삽입한 것이 안 보여짐
SELECT * FROM emp10_view;
SELECT * FROM emp;--emp테이블에 1행이 추가됨

rollback;

--with read only : 읽기 전용 뷰를 생성하는 옵션
CREATE OR REPLACE VIEW emp20_view
AS SELECT empno id_number,ename name,sal*12 ann_salary
   FROM emp WHERE deptno=20
WITH READ ONLY;

SELECT * FROM emp20_view;

--"읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다." 오류 발생
UPDATE emp20_view SET name='DAVID' WHERE id_number=7902;

--with check option:조건 컬럼값을 변경하지 못 하게 하는 옵션
CREATE OR REPLACE VIEW emp30_view
AS SELECT empno,ename,deptno 
   FROM emp WHERE deptno=30
WITH CHECK OPTION;

SELECT * FROM emp30_view;

--"뷰의 WITH CHECK OPTION의 조건에 위배 됩니다" 오류 발생
UPDATE emp30_view SET deptno=10 WHERE empno=7499;

--view의 수정
--CREATE OR REPLACE VIEW절에서 열 별칭을 지정하는 경우
--서브 쿼리의 열과 동일한 순서로 나열해야 함
CREATE OR REPLACE VIEW emp10_view 
 (id_number,name,sal,department_id)
AS SELECT empno,ename,sal,deptno
   FROM emp WHERE deptno=10;
   
SELECT * FROM emp10_view;   

--VIEW삭제
DROP VIEW emp10_view;

--sequence : 유일한 값을 생성해주는 오라클 객체
--시퀀스를 생성하면 기본키와 같이 순차적으로 증가나는 컬럼을 자동적으로
--생성할 수 있음. 보통 primary key 값을 생성하기 위해 사용

--시퀀스 생성
--시작 값이 1이고 1씩 증가하고, 최대값이 100000이 되는 시퀀스 생성
CREATE SEQUENCE test_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 100000;

--CURRVAL : 현재 값을 반환
--NEXTVAL : 현재 시퀀스 값의 다음 값 반환

SELECT test_seq.nextval FROM dual;
SELECT test_seq.currval FROM dual;

--시퀀스의 수정
--START WITH는 수정할 수 없음
ALTER SEQUENCE test_seq
INCREMENT BY 10;

--시퀀스의 삭제
DROP SEQUENCE test_seq;

--인덱스(index)
--인덱스는 데이터 검색을 빨리 하기 위해 사용한다.
--테이블의 컬럼에 대한 제약 조건을 설정할 때 Primary Key나 Unique로
--설정하면 Oracle은 자동으로 이 컬럼에 대해 Unique Index를 설정.

--인덱스 만들기
--자동 : 테이블 정의에 Primary Key 또는 Unique 제약 조건을 정의하면
--      고유 인덱스가 자동으로 생성
--수동 : 사용자가 열에 고유하지 않은 인덱스를 생성하여 행에 대한 엑세스
--      시간을 줄일 수 있다.

--유일한 값을 가지는 컬럼에 인덱스 설정 : Unique Index
CREATE UNIQUE INDEX dname_idx ON dept(dname);

--유일한 값을 가지지 않는 컬럼에 인덱스 설정 : Non Unique Index
CREATE INDEX emp_ename_idx ON emp (ename);

--인덱스 삭제
DROP INDEX dname_idx;

--동의어
--객체의 다른 이름을 생성하여 객체 액세스를 단순화
--1)다른 사용자가 소유한 테이블을 쉽게 참조
--2)긴 객체 이름을 짧게 만든다.

--동의어 생성
CREATE SYNONYM emp20
FOR emp20_view;

SELECT * FROM emp20;

--동의어 삭제
DROP SYNONYM emp20;

--권한
--관리자 계정의 역할
--데이터베이스의 생성과 관리를 담당하는 슈퍼유저(Super User)계정이며
--데이터베이스 객체의 생성,벼경,삭제 등의 작업이 가능하다.

--사용자 계정의 역할
--사용자 계정은 데이터베이스에 접근하여 데이터를 조작(삽입,삭제,수정,
--검색)하고 관리하는 일을 수행할 수 있는 계정이다.

--사용자 생성
--sqlplus를 구동해서 
--사용자명 입력:system
--비밀번호 입력:a1234

--SQL>conn /as sysdba
--연결되었습니다.

--사용자 생성
--create user c##user01 identified by a1234;
--사용자가 생성되었습니다.

--권한 부여
--grant resource,connect to c##user01;
--CONNECT : DB에 접속할 수 있는 권한
--RESOURCE : 객체 생성 권한 묶음

--필요한 것만 권한 부여
--GRANT SESSION TO c##user01;
--GRANT CREATE TABLE,CREATE VIEW,CREATE SEQUENCE TO C##USER01;

--사용자 제거
--drop user c##user01;

--객체가 존재할 경우 사용자 제거
--drop user c##user01 cascade;

--비밀번호 변경
--alter user user02 identified by lion;







