# Query Dsl Example

## 첫 생성시 주의사항
* 처음 프로젝트를 만들고나서 빌드나, 컴파일을 하지 않아도 자동으로 q클래스를 생성하니 걱정말자.

## repository 만드는 방법
* dsl은 이름이 매우 중요하다. 
* 구현할 메서드의 시그니처를 정의하는 custom 인터페이스를 만들고 
* 같은 이름의 impl 인터페이스에서 구현한다. 
* XxCustom, XxImpl 로 이름이 반드시 같아야한다.
* 마지막으로 jpa를 상속받는 repository에서는 XxCustom 인터페이스도 상속받아서 
* 단 하나의 repository만 di하고 사용하면된다.

## 컴파일 에러 발생시 해결법
* generated에 있는 폴더 삭제하면 정상적으로 동작한다.

## 페치 조인 주의사항
* 집계함수와 페이징 시에는 페치조인 되지 않는다.
* 페치조인을 쓰지말고 batch_fetch_size를 걸어서 해결하자.

## 페이징시 정렬 주의사항
* 페이징 시에는 페이저블의 sort옵션이 잘 안들어간다.
* 따라서 직접 orderby절로 정렬해주어야한다.

## 수정과 삭제 쿼리
* 수정과 삭제는 모두 개수에 관계없이 벌크연산을 한다.
* 단건을 수정하더라도 벌크연산을 하니 주의 하자.

## 조인시 고민
* query dsl 뿐만 아니라 모든 sql에서 조인시 on을 써야할지 where를 써야할지 고민하는 경우가 있다.
* inner join은 on이나 where나 성능차이가 없으므로 다중일 경우 on을, 단건일 경우 where를 쓴다.
* 즉 조건에 맞게 알맞게 써라. 

## 검색쿼리 주의사항
* 검색 쿼리는 contains와 like가 있다. 
* like는 완전히 일치한 것만 리턴하고
* contains는 일반적인 검색쿼리인 %%을 의미한다. 
* 즉 포함이 되어있기만 하면 리턴한다.(가장 많이 쓰이는 검색쿼리)

## where 절 조건
* where(조건.and(조건2))
* eq : =
* ne : !=
* between
* a.goe(b) : a >= b
* a.gt(b) : a > b
* a.loe(b) : a <= b
* a.lt(b) : a < b
* like : keyword%
* contains : %keyword%

## 해당 예제에서 볼 수 있는 쿼리들
### Board
* 단건 조회
* 페이징
* 수정
* 검색(contains)
### Comment
* 리스트 + 페치조인
* 단건 + 페치조인
* 통계쿼리(count)
* 삭제