# Spring-programming
Spring 개념 다지기

# chapter01
- bean 설정 방법
- Bean 등록, 저장, 사용
- 빈등록 설정(xml, java 방식)
- 빈이름, 타입(클래스)

# chapter02
- 주입(의존성 주입, Dependency Injection, DI)
- A -> B 의존관계 A 객체안에서  B객체 생성

# chapter03
- 자동주입
- 빈 컨테이너에 생성되어 있는 객체만 가능
- 기본적으로 타입을 기준으로 주입

# chapter04
- 자동 빈생성
- ComponentScan
- @Component (@Controller, @Service, @Repository)


# chapter05
- 컨트롤러
* url 매핑
* 응답
* 파라미터 받기
* 데이터 저장

# chapter06
- AOP
- 주기능,  보조기능(로깅, 트랜잭션, 인증, 인가...) 분리, 외부에서 어디에 적용 설정

# chapter07
- DB연동 (MyBatis)
MyBatis
- SQL Mapper
- Java와 SQL(XML) 분리
- 자동으로 파라미터 값 매핑
insert into student (a,b,c,d,e,f) values (변수, 변수, 변수...)
- 자동으로 결과값 객체로 매핑
select * from student -> StudentVO 매핑해서 리턴
- 동적(dynamic) SQL

구조
- 바깥에 mapper 태그
- mapper안에 <select> <insert> <update> <delete>
- DAO SQL 실행할때(지정 방법)
   mapper태그의 namespace, 태그의 id => namespace.id (student.all)

- 메서드
selectList() : 여러개
selectOne() : 한개
insert(), update(), delete()

실행시 : .메서드명("namespace.id"[, 파라미터(객체)])

#{변수명} - preparedstatment : ? 처리
where id = #{id} -> where id = ?
${변수명} - statement : 그대로 처리
where id = ${id} -> where id = abc
where id = '${id}'

iBatis차이
#{변수명} -> #변수명#
${변수명} -> $변수명$

동적SQL
<where> : where 명령어를 추가/제외
<if test="조건">SQL</if> : 조건식이 참이면 포함되는 SQL
<sql> : 독립적으로 저장
<include> : 포함
<resultMap> : 결과매핑, 컬럼명과 필드명(타입)이 다른 경우
<parameterMap> : 파라미터매핑
<foreach> : 반복
<foreach collection="배열변수명" open="(" close=")" separator=","></foreach>

# chapter08
- 또 다른 마이바티스 사용법
- 인터페이스 방식 (DAO 대신)
- 버전 2.X 이상


# chapter09
- 트랜잭션
- 하나의 논리적 작업단위

member 테이블, hobby 테이블
1 : N 관계



# chapter10
- 인터셉터 (interceptor)
- 클래스를 생성해서 빈 등록, 설정(경로)
- 로그인됐는지여부 체크하는 클래스생성, 등록, /member/mypage.do, /member/order.do 설정

preHandle() : 전
postHandle() : 후
afterCompletion() : 응답후


# chapter11
- RestAPI
- jackson-databind 의존모듈 추가
- @RestController
- @RequestBody
- @CrossOrigin


# chapter12
- 파일업로드, 다운로드
- jar(commons-fileupload) 추가, 빈 설정(반드시 빈 이름은 multipartResolver)
- 컨트롤러에서 파라미터로 첨부파일 처리


# chapter13
- JUnit
- 라이브러리 추가(spring-test)
- src.test 패키지에 작성
- JUnit 버전은 4.12이상
- Servlet 버전 변경 필요