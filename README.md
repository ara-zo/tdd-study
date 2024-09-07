# TDD

## Chapter 02. TDD 시작
### 단위 테스트(Unit Test)를 작성해야 하는 이유
* 코드를 수정하거나 기능을 추가할 때 수시로 빠르게 검증
* 리팩토링 시에 안정성을 확보
* 개발 및 테스팅에 대한 시간과 비용을 절감

## Chapter 03. 테스트 코드 작성 순서
### 테스트 코드 작성 순서
1. 쉬운 경우에서 어려운 경우로 진행
2. 예외적인 경우에서 정상적인 경우로 진행

### 01. 초반에 복잡한 테스트부터 시작하면 안되는 이유
초반부터 다양한 조합을 검사하는 테스트로 추가하면,
해당 테스트를 통과 시키기 위해 한 번에 구현해야할 코드가 많아짐

### 02. 구현하기 쉬운 테스트부터 시작하기
가장 구현하기 쉬운 경우부터 시작하면 빠르게 테스트를 통과시킬 수 있음.
보통 수 분에서 십여 분 이내에서 구현을 완료해서 테스트를 통과 시킬 수 있을 만큼 쉬운 것을 선택

한 번에 구현하는 시간이 짧아지면 디버깅할 때에 유리
작성한 코드가 많지 않고 작성 시간도 짧으면 디버깅할 떄 문제 원인을 빠르게 찾을 수 있음

### 03. 예외 상황을 먼저 테스트해야 하는 이유
초반에 예외 상황을 테스트하면 이런 가능성이 줄어듬,

예외 상황에 따른 if-else 구조가 미리 만들어지기 때문에 많은 코드를 완성한 뒤에 
예외 상황을 반영할 때보다 코드 구조가 덜 바뀜

### 04. 완급 조절
구현 속도 조절 가능

### 05. 지속적인 리팩토링
TDD를 진행하는 과정에서 지속적으로 리팩토링을 진행하면 코드 가독성이 높아짐, 향후 유지보수에 도움

### 06. 테스트할 목록 정리하기
TDD를 시작할 때 테스트할 목록을 미리 정리하면 좋음

예를 들어

- 1만원 납부하면 한달 뒤가 만료일
- 달의 마지막 날에 납부하면 다음달 마지막 날이 만료일
- 2만원 납부하면 2개월 뒤가 만료일
- 3만원 납부하면 3개월 뒤가 만료일
- 10만원 남부하면 1년 뒤가 만료일

이 중 어떤 테스트가 구현이 쉬울지, 또는 예외적인 생각해보고, 
시간을 들여서 구현의 난이도나 구조를 검토하면 다음 테스트를 선택할 때 도움이 됨

테스트 과정에서 새로운 테스트 사례를 발견하면 그 사례를 목록에 추가해서 놓치지 않도록 해야함

한 번에 작성한 테스트 코드가 많으면 구현 초기에도 리팩토링을 마음껏 못 하게 됨, 
수정할 코드가 많을수록 리펙토링에 대한 시림적 저항이 생김

또한, 모든 테스트를 통과시키기 전까지는 계속해서 깨지는 테스트가 존재하므로 개발 리듬을 유지하는데 도움이 안됨

하나의 테스트 코드를 만들고 이를 통과시키고 리팩토링하는 과정은 비교적 짧은 리듬을 반복, 
다루는 범위가 작고 개발 주기도 짧으므로 개발 집중력도 높아짐

### 07. 시작이 안될 때는 단언부터 고민
테스트 코드를 작성하다 보면 시작이 잘 안 될 때가 있다.
이럴 땐 검증하는 코드부터 작성하기 시작하면 도움이 됨

### 08. 구현이 막히면
TDD를 진행하다 보면 구현이 막힐 때가 있음,
이럴 땐 과감하게 코드를 지우고 다시 시작!

## Chapter 04. TDD･기능 명세･설계
### 01. 기능 명세
**설계는 기능 명세로부터 시작**
스토리보드를 포함한 다양한 형태의 요구사항 문서를 이용해서 기능 명세를 구체화

### 02. 설계 과정을 지원하는 TDD

TDD는 테스트를 만드는 것부터 시작

테스트 코드를 먼저 만들고 테스트를 통과시키기 위해 코드를 구현하고 리팩토링하는 과정을 반복.

### 03. 기능 명세 구체화

테스트 코드를 ㅓ자가성하기 위해 개발자는 기능 명세를 정리해야 함.

보통 개발자는 기획자가 작성한 스토리보드나 와이어프레임과 같은 형태로 요구사항 명세를 전달 받음.

모호한 상황을 만나면 이를 구체적인 예로 바꾸어 테스트 코드에 반영함.
즉, 테스트 코드는 예를 이용한 구체적인 명세가 됨.

## Chapter 05. JUnit 5 기초

https://jara102.tistory.com/85

### 01. JUnit 5 모듈 구성
JUnit 5는 크게 세 개의 요소로 구성
>JUnit 5 =  JUnit Platform + JUnit Jupiter + JUnit Vintage

- JUnit 플랫폼(Platform) : 테스팅 프레임 워크를 구동하기 위한 런처와 테스트 엔진을 위한 API를 제공
- JUnit 주피터(Jupiter) : JUnit 5를 위한 테스트 API와 실행 엔진 제공
- JUnit 빈티지(Vintage) : JUnit 3과 4로 작성된 테스트를 JUnit 5 플랫폼에서 실행하기 위한 모듈을 제공

>Jupiter,Vintage 둘다 JUnit Platform의 구현체
차이점은 Jupiter는 JUnit5의 구현체, Vintage는 하위버전들에 대한 지원을 위한 구현체

### 02. @Test 어노테이션과 테스트 메서드
JUnit 코드의 기본 구조는 간단.

테스트로 사용할 클래스를 만들고 @Test 어노테이션을 메서드에 붙이기만 하면 됨

private 또는 static으로 설정 X, 그리고 반드시 리턴 타입이 void로 되어야 함.
```
@SpringBootTest
class SumTest {
    @Test
    fun sum() {
        val result = 2 + 3;
        assertEquals(5, result);
    }
}
```

### 03. 주요 단언 메서드
Assertions 클래스는 arssertEquals 를 포함해 단언 메서드를 제공

- assertEquals : 실제 값이 기대하는 값과 같은지 검사
- assertNOtEquals : 실제 값이 특정 값과 같지 않는지 검사
- assertSame : 두 객체가 동일한 객체인지 검사
- assertNotSame : 두 객체가 동일하지 않은 객체인지 검사
- assertTrue : 값이 true인지 검사
- assertFalse : 값이 false인지 검사
- assertNull : 값이 null인지 검사
- assertNotNull : 값이 null이 아닌지 검사
- fail : 테스트를 실패 처리
- assertThrows : 지정한 타입의 익셉션이 발생하는지 검사
- assertDoesNotThrow : 실행한 결과로 익셉션이 발생하지 않는지 검사

### 04. 테스트 라이프사이클
#### @BeforeEach 어노테이션과 @AfterEach 어노테이션
JUnit은 해당 애노테이션이 존재하면 다음과 같이 코드를 실행한다.

- 테스트 메서드를 포함한 객체 생성
- (존재하면) @BeforeEach 애노테이션이 붙은 메서드 실행
- @Test 애노테이션이 붙은 메서드 실행
- (존재하면) @AfterEach 애노테이션이 붙은 메서드 실행

#### @BeforeAll 어노테이션과 @AfterAll 어노테이션
모든 메서드마다 시작과 끝에서 실행되던 Each 어노테이션과는 다르게, 전체적인 동작의 시작과 끝에서 단 한번만 수행

### 05. 테스트 메서드 간 실행 순서 의존과 필드 공유하지 않기
테스트 클래스 상단에 정적 필드를 두고 테스트 메서드들 끼리 같은 필드를 공유하는 등의 코드는 절대 작성하지 않는다.

같은 필드를 공유하면 실행 순서에 의존하게 되어 테스트 코드의 위치나 순서가 변경되면 정상적으로 작동하지 않을 확률이 크다

테스트 메서드가 하나 실행될 때마다 새로운 객체를 만드는데, 같은 필드를 사용하여 이어지는 테스트 작성하게 되면 당연히 오류가 나게 되고, static 등을 사용하여 공유한다고 해도 이전 테스트의 실행결과에 따라 다음 테스트의 실행 결과가 달라지면 안되기 때문에 이런 설계는 옳지 않다.

테스트 코드는 꼭 독립된 단위로 실행될 수 있도록 만들어야한다.

### 06. 추가 애노테이션: @DisplayName, @Disabled
**@DisplayName** 어노테이션을 사용해서 테스트에 표시 이름을 붙일 수 있다.

**@Disabled** 어노테이션이 붙은 클래스나 메서드는 테스트 실행 대상에서 제외

## Chapter 06. 테스트 코드의 구성
### 01. 기능에서의 상황
기능은 주어진 상황에 따라 다르게 동작
- 파일에서 숫자를 읽어와 숫자의 합을 구한다.
- 한 줄마다 한 개의 숫자를 포함한다.

이 기능을 구현하려면 고려할 것이 있다.
- 파일이 없는 상황을 처리해야 한다.
- 데이터를 읽을 파일이 없다면 인자가 잘못되었다는 익셉션을 발생한다.
- 문제 상황을 알려줄 수 있는 값을 리턴해야 한다.
- 숫자가 아닌 잘못된 데이터가 존재하는 경우에도 알맞은 결과를 생성해야 한다.

### 02. 테스트 코드의 구성 요소 : 상황, 실행, 결과 확인
테스트 코드는 기능을 실행하고 그 결과를 확인하므로 상황, 실행, 결과 확인의 세가지 요소로 테스트 구성할 수 있다.

상황, 실행, 결과 확인은 영어 표현 given, when, then에 대응한다.
하지만 이 기본 골격은 메 테스트 경우마다 존재하는 것은 아니다.
```
@Test
fun `모든 규칙을 충족하는 경우`() {
assertStrength("ab12!@AB", PasswordStrength.STRONG)
assertStrength("abc1!Add", PasswordStrength.STRONG)
}
```
암호 강도 측정의 경우 결과에 영향을 주는 상화아이 존재하지 않으므로 테스트는 다음처럼 기능을 실행하고 
결과를 확인하는 코드만 포함하고 있다.

결과값이 항상 존재하는 것은 아니다
```
@Test
fun `테스트_실패_알림`() {
    val thrown = assertThrows<IllegalArgumentException> {
        val dateTime1 = LocalDate.now()
        val dateTime2 = dateTime1.minusDays(1) // 날짜를 다르게 설정하여 테스트

        // 이부분 안넣으면 AssertionFailedError가 뜸
        if (dateTime1 != dateTime2) {
            throw IllegalArgumentException("dateTime1 and dateTime2 are not equal")
        }

        assertEquals(dateTime1, dateTime2)
    }
    assertTrue(thrown.message?.contains("dateTime1") == true)
}
```
실행 결과로 익셉션을 발생하는 것이 정상인 경우도 있다.

상황-실행-결과 확인 구조에 너무 집착하지 말자!

### 03. 외부상황과 외부 결과

상황 설정이 테스트 대상으로 국한된 것은 아니다.
 
상황에는 외부 요인도 있다.

```
val dataFile = File("data.txt")
val sum = MathUtils.sum(dataFile)
```

MathUtils.sum() 메서드를 테스트하려면 존재하지 않는 상황에서의 결과도 확인해야 한다.

가장 쉬운 방법으로 존재하지 않는 파일을 경로로 사용하는 것이다.

하지만 우연이라도 해당 파일이 존재 할 수 있다. 테스트는 실행할 때마다 동일 결과를 보장해야 한다.

더욱 확실한 방법은 명시적으로 파일을 없는 상황을 만드는 것이다.

```
@Test
@DisplayName("파일이 없을때")
fun noDataFile_Then_Exception() {
    givenNoFile("badpath.txt")

    val dataFile = File("badpath.txt")
    assertThrows<IllegalArgumentException> {
        MathUtils.sum(dataFile)
    }
}

private fun givenNoFile(path: String) {
    val file = File(path)
    if(file.exists()) {
        val deleted = file.delete()
        if(!deleted) throw RuntimeException("fail givenNoFile" + path)
    }
}
```

이렇게 구성하면 테스트가 항상 올바른 상황에서 동작한다는 것을 보장할 수 있다.

다음으로 존재하는 상황을 만드는 가장 쉬운 방법은 상황에 맞는 파일을 미리 만들어 두는 것이다.

이 경우 파일이 항상 테스트 코드와 같이 제공될 수 있어야 한다.

```
@Test
@DisplayName("파일이 있을때")
fun dataFileSumeTest() {
    val dataFile = File("src/test/resources/datafile.txt")
    val sum = MathUtils.sum(dataFile)
    assertEquals(10L, sum)
}
```

파일을 미리 만들지 않고 테스트 코드에서 상황에 맞는 파일을 생성하는 방법도 있다.

```
@Test
@DisplayName("파일이 있을때")
fun dataFileSumeTest() {
    givenDataFile("src/test/resources/datafile.txt", "1", "2", "3", "4")

    val dataFile = File("src/test/resources/datafile.txt")
    val sum = MathUtils.sum(dataFile)
    assertEquals(10L, sum)
}

private fun givenDataFile(path: String, vararg lines: String) {
    try {
        val dataPath = Path(path)
        if(Files.exists(dataPath)) {
            Files.delete(dataPath)
        }
        Files.write(dataPath, lines.toList())
    } catch(e: IOException) {
        throw RuntimeException(e)
    }
}
```

이 방법의 장점은 테스트 코드 내에 필요한 것이 다 있다는 것이다.

테스트 대상이 아닌 외부에서 결과를 확인해야 할 때도 있다.

처리 결과를 지정한 경로의 파일에 저장하는 기능을 생각해보면, 해당 경로에 파일이 원하는 내용으로 만들어졌는지 확인해야 한다.

### 04. 외부 상태가 테스트 결과에 영향을 주지 않게 하기
테스트 코드는 한번만 실행하고 끝나지 않는다.
TDD 진행중에도 계속 실행하고 개발이 끝난 이후에도 반복적으로 테스트를 실행해서 문제가 없는지 검증한다.

그렇기 때문에 테스트는 언제 실행해도 항상 정상적으로 동작하는 것이 중요하다.

외부 상태에 따라 테스트의 성공 여부가 바뀌지 않으려면 테스트 실행 전에 외부를 원하는 상태로 만들거나 테스트 실행 후에 외부 상태를 원래대로 되돌려 놓아야 한다.

### 05. 외부 상태와 테스트 어려움
상황과 결과에 영향을 주는 외부 요인은 다양하며, 이들을 테스트에 맞게 구성하는 것이 항상 가능한 것은 아니다.

이를테면 자동이체 등록 기능을 생각해보자.
금융사에서 제공하는 REST API를 사용한다면 다음 상황에서의 결과를 확인할 수 있어야 한다.

- API 응답 결과가 유효한 계좌 번호인 상황
- API 응답 결과가 유효하지 않은 계좌 번호인 상황
- API 서버에 연결할 수 없는 상황
- API 서버에서 응답을 5초 이내에 받지 못하는 상황
- 응답 유효성을 검증하는 경우는 정보를 받아 테스트를 해볼 수 있으나, 서버와 관련된 부분은 제공사의 상황에 따라 해결하기가 어려울 수 있다.

이처럼 테스트 대상이 아닌 외부 요인은 테스트 코드에서 다루기 힘든 존재이다. 이런 외부 요인이 관여하는 상황에는 대역을 사용하면 테스트 작성이 쉬워진다.

대역은 테스트 대상이 의존하는 대상의 실제 구현을 대신하는 구현인데 이 대역을 통해 외부 상황, 결과를 대체할 수 있다.

## Chapter 07. 대역
### 01. 대역의 필요성
테스트를 작성하다 보면 외부 요인이 필요한 시점이 있다.
- 테스트 대상에서 파일 시스템을 사용
- 테스트 대상에서 DB로부터 데이터를 조회하거나 데이터를 추가
- 테스트 대상에서 외부의 HTTP 서버와 통신

외부요인은 테스트 작성을 어렵게 만들 뿐만 아니라 테스트 결과도 예측할 수 없게 만든다.

test double : 테스트에서 사용할 대역

### 04. 대역의 종류
- 스텀(Stub)
  - 구현을 단순한 것으로 대체한다. 테스트에 맞게 단순히 원하는 동작을 수행
  - StubCardNumberValidator가 스텁 대역에 해당
- 가짜(Fake)
  - 제품엔는 적합하지 않지만 실제 동작하는 구현을 제공
  - DB대신에 메모리를 이용해서 구현한 MemoryAutoDebitInfoRepository가 가짜 대역에 해당
- 스파이(Spy)
  - 호출된 내역을 기록
  - 기록한 내용은 테스트 결과를 검증할 때 사용
- 모의(Mock)
  - 기대한 대로 상호작용하는지 행위를 검증
  - 기대한 대로 동작하지 않으면 Exception 을 발생할 수 있음
  - 스텁이자 스파이도 됨

### 06. 대역과 개발 속도
TDD 과정에서 대역을 사용하지 않고 실제 구현을 사용한다면?
- 제공 업체에서 해당 테스트 데이터를 줄 때까지 테스트를 기다려야 함
- 제공 API가 비정상 응답을 주는 상황을 테스트하기 위해 업체의 변경 대응을 기다려야 함
- 회원 가입 테스트를 한 뒤 편지가 도착할 때까지 메일함을 확인 해야함
- 약한 암호 검사 기능을 개발할 때까지 회원 가입 테스트를 대기 해야함

모두 대기 시간이 발생

대역을 사용하면 실제 구현 없이도
- 다양한 상황에 대해 테스트할 수 있다
- 실행결과를 확인할 수 있다
- 개발 속도를 올리는 데 도움이 된다

### 07. 모의 객체를 과하게 사용하지 않기
- 모의 객체를 과하게 사용하면 오히려 테스트 코드가 복잡해지는 경우 발생
  - 모의 객체를 사용하면 대역 클래스를 만들지 않아 편할 수는 있지만, 결과 값을 확인 하는 수단으로 모의 객체를 사용하면 검증 코드가 길어지고 복잡해진다.
- 모의 객체는 메서드 호출 여부를 검증하는 수단
  - 메서드 호출 여부를 결과 검증 수단으로 사용하는 것을 주의
  - DAO나 Repository와 같이 저장소에 대한 대역은 모의 객체를 사용하는 것보다 메모리를 이용한 가짜 구현이 유리

## Chapter 08. 테스트 가능한 설계
### 01. 테스트가 어려운 코드
개발을 진행하다 보면 테스트할 수 없는 상황이 발생하게 된다
- 하드코딩된 경로 존재
  - 파일 경로가 하드 코딩 되어 있어 반드시 해당 경로에 파일이 위치해야 테스트가 가능
- 의존 객체를 직접 생성
  - 필요한 환경을 모두 구성해야 함
- 정적 메서드 사용
- 실행 시점에 따라 달라지는 결과
- 역할이 섞여있는 코드
- 그 외
  - 메서드 중간에 소켓 통신 코드가 포함
  - 콘솔에서 입력받거나 결과를 콘솔에 출력
  - 테스트 대상이 사용하는 의존 대상 클래스나 메서드가 final (대역으로 대체가 어려울 수 있음)
  - 테스트 대상의 소스를 소유하고 있지 않아 수정 어려움

### 02. 테스트가 가능한 설계
의존하는 코드를 교체할 수 있는 수단이 없기 때문에 테스트가 어려운 것,
상황에 맞게 알맞은 방법을 활용하여 해결할 수 있다.

- 하드 코딩된 상수를 생성자나 메서드 파라미터로 받기
- 의존 대상을 주입 받기
- 테스트하고 싶은 코드를 분리
- 시간이나 임의 값 생성 기능 분리
- 외부 라이브러리는 직접 사용하지 말고 감싸서 사용

## Chapter 09. 테스트 범위와 종류
### 01. 테스트 범위
- 단위 테스트
- 통합 테스트
- 기능 테스트

#### 01. 기능 테스트(Function Testing)와 E2E(End to End) 테스트
- 사용자 입장에서 시스템이 제공하는 기능이 올바르게 동작하는지 확인 (= 인수 테스트)
- 모든 구성 요소를 하나로 엮어서 진행

#### 02. 통합 테스트(Integration Testing)
- 시스템의 각 구성 요소가 올바르게 연동되는지 확인
- 소프트웨어의 코드를 직접 테스트
- 스프링 부트에서는 클래스 상단에 @SpringBootTest 어노테이션을 붙여 통합 테스트를 수행할 수 있다.

#### 03. 단위 테스트(Unit Testing)

- 개별 코드나 컴포넌트가 기대한대로 동작하는지 확인
- 한 클래스나 한 메서드와 같은 작은 범위 테스트
- 일부 의존 대상은 스텁이나 모의 객체 등을 이용해서 대역으로 대체

#### 04. 테스트 범위 간 차이
- 기능 테스트
  - 테스트하기 가장 어려움 (클라이언트부터 DB까지 모든 환경 갖춰야함)
  - 정기적 기능 테스트는 몇가지 특수한 상황만 테스트 범위로 잡음
- 통합 테스트
  - 시스템 내부 구성 요소에 대한 테스트도 가능
  - 유연하게 구성할 수 있기 때문에 기능 테스트보다 통합 테스트를 많이 작성
- 단위 테스트
  - 더 작은 단위를 대상으로 테스트 코드를 만들고 다룸

테스트 속도가 빠른 단위 테스트에서 다양한 상황을 다루고 통합 테스트나 기능 테스트는 주요 상황에 초점을 맞춰야 함

피드백이 느려지는 것을 방지할 수 있음

### 05. 외부 연동이 필요한 테스트 예

#### 01. 스프링 부트와 DB 통합 테스트

통합 테스트는 실제로 DB를 사용한다.

동일한 테스트를 여러번 실행해도 결과가 같게 나와야하므로 테스트 코드에서 DB 데이터를 알맞게 제어해야한다.

단위 테스트와 비교해보면 단위 테스트는 상황을 만들기 위해 대역을 사용한다.

통합테스트와 단위 테스트는 실행 시간에도 차이가 있다.

스프링 부트를 이용한 통합 테스트는 테스트 메서드를 실행하기 전에 스프링 컨테이너를 생성하는 과전이 필요하다.

반면에 단위 테스트는 이런 과정이 없으므로 테스트를 실행하는 시간이 매우 짧다.

#### 02. WireMock을 이용한 REST 클라이언트 테스트

WireMock을 사용하면 서버 API를 스텁으로 대체할 수 있다.

스프링 부트에서 사용하기 위해 아래를 임포트 해주었다.

```
implementation("org.wiremock:wiremock-standalone:3.9.1")
```

## Chapter 10. 테스트 코드와 유지보수
### 01. 테스트 코드와 유지보수
테스트 코드는 그 자체로 코드이기 때문에 제품 코드와 동일하게 유지보수 대상이 된다.

깨지는 테스트를 방치하는 상황이 길어지면 다음과 같은 문제가 발생할 수 있다
- 실패한 테스트가 새로 발생해도 무감각해진다. 테스트 실패 여부에 상관없이 빌드하고 배포하기 시작한다.
- 빌드를 통과시키기 위해 실패한 테스트를 주석 처리하고 실패한 테스트는 고치지 않는다.

이런 상황이 발생하면 테스트 코드는 가치를 일기 시작한다.

회귀 테스트(regression test)를 자동화 하는 수단으로 사용되는데 깨진 테스트를 방치하기 시작하면 회귀 테스트가 검증하는 범위가 줄어든다.
이는 코드에 버그가 발생했을 때 이를 놓칠 가능성이 커지는 것을 의미.

즉, 소프트웨어 품질이 낮아질 가능성이 커지는 것.

```
깨진 유리창 이론 - 깨진 유리창 하나를 방치하면, 그 지점을 중심으로 범죄가 확산 되기 시작한다는 이론
```


