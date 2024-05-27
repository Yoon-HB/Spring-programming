# Spring-programming
Spring 개념 다지기

네, 아래 내용을 그대로 복사하여 `README.md` 파일에 붙여넣으면 됩니다.

---

# Spring Framework Guide

## Chapter 01: Bean 설정 방법
- **Bean 등록, 저장, 사용**
- 빈등록 설정 (XML, Java 방식)
- 빈 이름, 타입 (클래스)

## Chapter 02: 주입 (의존성 주입, Dependency Injection, DI)
- A -> B 의존관계: A 객체 안에서 B 객체 생성

## Chapter 03: 자동주입
- 빈 컨테이너에 생성되어 있는 객체만 가능
- 기본적으로 타입을 기준으로 주입

## Chapter 04: 자동 빈생성
- **ComponentScan**
- `@Component` (`@Controller`, `@Service`, `@Repository`)

## Chapter 05: 컨트롤러
- URL 매핑
- 응답
- 파라미터 받기
- 데이터 저장

## Chapter 06: AOP
- 주기능, 보조기능 (로깅, 트랜잭션, 인증, 인가...) 분리, 외부에서 어디에 적용 설정

## Chapter 07: DB연동 (MyBatis)
### MyBatis
- **SQL Mapper**
  - Java와 SQL(XML) 분리
  - 자동으로 파라미터 값 매핑
    ```sql
    INSERT INTO student (a, b, c, d, e, f) VALUES (변수, 변수, 변수...)
    ```
  - 자동으로 결과값 객체로 매핑
    ```sql
    SELECT * FROM student -> StudentVO 매핑해서 리턴
    ```
  - 동적(dynamic) SQL

### 구조
- 바깥에 `<mapper>` 태그
- `<mapper>` 안에 `<select>`, `<insert>`, `<update>`, `<delete>`

### DAO SQL 실행할 때 (지정 방법)
- `mapper` 태그의 `namespace`, 태그의 `id` => `namespace.id` (e.g., `student.all`)

### 메서드
- `selectList()`: 여러 개
- `selectOne()`: 한 개
- `insert()`, `update()`, `delete()`

### 실행시
- `.메서드명("namespace.id"[, 파라미터(객체)])`

### 변수명 처리
- `#{변수명}` - PreparedStatement : `?` 처리
  ```sql
  WHERE id = #{id} -> WHERE id = ?
  ```
- `${변수명}` - Statement : 그대로 처리
  ```sql
  WHERE id = ${id} -> WHERE id = abc
  WHERE id = '${id}'
  ```

### iBatis 차이
- `#{변수명}` -> `#변수명#`
- `${변수명}` -> `$변수명$`

### 동적 SQL
- `<where>`: `WHERE` 명령어를 추가/제외
- `<if test="조건">SQL</if>`: 조건식이 참이면 포함되는 SQL
- `<sql>`: 독립적으로 저장
- `<include>`: 포함
- `<resultMap>`: 결과 매핑, 컬럼명과 필드명(타입)이 다른 경우
- `<parameterMap>`: 파라미터 매핑
- `<foreach>`: 반복
  ```xml
  <foreach collection="배열변수명" open="(" close=")" separator=","></foreach>
  ```

### 목요일날 할 것
- 검색 조건 추가
- Map
- MyBatis 또 다른 사용법

## Chapter 08: 또 다른 MyBatis 사용법
- 인터페이스 방식 (DAO 대신)
- 버전 2.X 이상

## Chapter 09: 트랜잭션
- 하나의 논리적 작업 단위
- `member` 테이블, `hobby` 테이블: 1 : N 관계

## Chapter 10: 인터셉터 (Interceptor)
- 클래스를 생성해서 빈 등록, 설정 (경로)
- 로그인 여부 체크하는 클래스 생성, 등록, `/member/mypage.do`, `/member/order.do` 설정

### 메서드
- `preHandle()`: 전
- `postHandle()`: 후
- `afterCompletion()`: 응답 후

## Chapter 11: RestAPI
- `jackson-databind` 의존 모듈 추가
- `@RestController`
- `@RequestBody`
- `@CrossOrigin`

## Chapter 12: 파일 업로드, 다운로드
- `jar` (`commons-fileupload`) 추가, 빈 설정 (반드시 빈 이름은 `multipartResolver`)
- 컨트롤러에서 파라미터로 첨부파일 처리

## Chapter 13: JUnit
- 라이브러리 추가 (`spring-test`)
- `src.test` 패키지에 작성
- JUnit 버전은 4.12 이상
- Servlet 버전 변경 필요

---
