# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
### n대의 자동차가 m회 이동(시도)했을 때 최종 우승자를 맞추는 게임
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 프로그래밍 요구사항
### 메소드 분리
* 자바 코드 컨벤션 준수
* indent는 1depth까지만 허용
  * ex) while문 안에 if문이 들어있으면 2depth (함수 또는 메소드 등으로 분리할 것)
* java 8의 stream api 사용 금지. lambda는 허용
* else 예약어 및 switch/case 사용금지
  * if 조건절에서 return으로 처리
* 함수 또는 메소드의 길이가 10라인 이내로 구현할 것
* 일급콜렉션을 활용해 구현
* 모든 원시값과 문자열을 포장할 것
### 단위 테스트
* JUnit5 기반의 단위테스트 구현(UI 로직은 제외)

## 기능목록 To-Do List(TDD로 구현)
* [ ] 자동차(Car) 클래스 구현
  * [x] 자동차 이름 클래스 구현(validation)
  * [x] 자동차 거리 클래스 구현(전진 메소드)
  * [ ] 랜덤카운트 및 이동 함수 구현
* [ ] 자동차 경주(CarRace) 클래스 구현
  * [ ] 경주 자동차 목록 추가 메소드
  * [ ] 시도 횟수 추가 메소드
* [ ] 자동차 경주 프로세스 구현
  * [ ] 경주할 자동차 입력
  * [ ] 시도 횟수 입력
  * [ ] 실행 결과 출력
  * [ ] 우승자 출력
