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

#### #01. 초반에 복잡한 테스트부터 시작하면 안되는 이유
초반부터 다양한 조합을 검사하는 테스트로 추가하면,
해당 테스트를 통과 시키기 위해 한 번에 구현해야할 코드가 많아짐

#### #02. 구현하기 쉬운 테스트부터 시작하기
가장 구현하기 쉬운 경우부터 시작하면 빠르게 테스트를 통과시킬 수 있음.
보통 수 분에서 십여 분 이내에서 구현을 완료해서 테스트를 통과 시킬 수 있을 만큼 쉬운 것을 선택

한 번에 구현하는 시간이 짧아지면 디버깅할 때에 유리
작성한 코드가 많지 않고 작성 시간도 짧으면 디버깅할 떄 문제 원인을 빠르게 찾을 수 있음

#### #03. 예외 상황을 먼저 테스트해야 하는 이유
초반에 예외 상황을 테스트하면 이런 가능성이 줄어듬,

예외 상황에 따른 if-else 구조가 미리 만들어지기 때문에 많은 코드를 완성한 뒤에 
예외 상황을 반영할 때보다 코드 구조가 덜 바뀜

#### #04. 완급 조절
구현 속도 조절 가능

#### #05. 지속적인 리팩토링
TDD를 진행하는 과정에서 지속적으로 리팩토링을 진행하면 코드 가독성이 높아짐, 향후 유지보수에 도움

### 테스트할 목록 정리하기
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

### 시작이 안될 때는 단언부터 고민
테스트 코드를 작성하다 보면 시작이 잘 안 될 때가 있다.
이럴 땐 검증하는 코드부터 작성하기 시작하면 도움이 됨

### 구현이 막히면
TDD를 진행하다 보면 구현이 막힐 때가 있음,
이럴 땐 과감하게 코드를 지우고 다시 시작!






