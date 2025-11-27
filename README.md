# java-threesixnine

369 게임은 플레이어들이 1부터 차례대로 숫자를 말하되, 숫자에 3,6,9가 포함되면 ‘clap’을 말해야 하는 규칙 게임입니다.
또한, 게임 규칙은 사용자가 선택한 Option에 따라 달라집니다.

- Option 1 (Single Clap) → 숫자에 3/6/9가 하나라도 포함되면 "clap"
- Option 2 (Multiple Clap) → 포함된 개수만큼 "clap" 반복

규칙을 어기는 순간 게임이 종료되며, 패자가 결정됩니다.


# 실행 예시

```
게임 옵션을 입력해 주세요. (1: single clap, 2: multiple clap)
1
플레이어 이름을 콤마(,)로 구분하여 입력해 주세요.
A,B,C
A: 1
B: 2
C: clap
A: 4
B: 5
C: clap
A: 7
B: 8
C: 9
게임이 종료되었습니다.
A : 3
B : 3
C : 2
패자: C

게임 옵션을 입력해 주세요. (1: single clap, 2: multiple clap)
2
플레이어 이름을 콤마(,)로 구분하여 입력해 주세요.
A,B,C
...
A: 28
B: clap
C: clap
A: clap
B: clap
C: clapclap
A: clap
B: clapclap
게임이 종료되었습니다.
A : 12
B : 11
C : 11
패자: B
```

# 패키지 구조 설명


<details>
<summary><b>controller (GameController)</b></summary>

- 게임 전체 흐름을 제어
- 전략 패턴에 따른 게임 옵션 입력 및 검증, 플레이어 이름 입력 및 파싱/검증
- 각 턴마다 model을 호출하여 비즈니스 로직 처리 및 input, outputview를 통해 입/출력 처리

</details>

<details>
<summary><b>model</b></summary>

### model
- 도메인 모델과 값 객체(vo)를 관리

#### model.vo
- **Name**: player 이름 값 객체 생성, null 검증
- **Count**: player별 실행 횟수

#### model.player
- Name, Count를 조합한 도메인 객체
- 이름 조회, count 조회, count 증가 담당

</details>


<details>
<summary><b>strategy</b></summary>

3,6,9 규칙을 캡슐화한 전략 패턴 레이어 
* 규칙이 추가되었을 때 **GameStrategy** 구현체만 추가하면 되기에 확장성 증가

### GameStrategy
- 숫자를 받아 정답 문자열을 반환하는 전략 인터페이스

### SingleClapStrategy
- 숫자에 3,6,9가 하나라도 포함되면 *clap* 반환
- 없으면 숫자 그대로 반환

### MultipleClapStrategy
- 숫자에 포함된 3,6,9 개수만큼 *clap*을 이어붙여 반환
- 없으면 숫자 그대로 반환
- 예) `33 → clapclap`

</details>

<details>
<summary><b>util</b></summary>

### util
- 검증/파싱 등 재사용 가능한 유틸리티 모음

#### GameOptionValidator
- 게임 옵션(1: singleClap, 2: multiClap)의 유효성을 검증
- 유효하지 않으면 "InvalidGameOptionException" 발생

#### NameParser
- Comma(,)로 구분된 문자열 입력을 플레이어 이름 list로 파싱

#### NameValidator
- 이름 입력값 비었는지 검사
- 최소 플레이어(2명) 충족 여부 검사
- 중복 이름 여부 검사
</details>

<details>
<summary><b>view</b></summary>

### view
- 콘솔 입출력 담당 레이어

#### InputView
- 게임 옵션 입력
- 플레이어 수 입력
- 각 플레이어의 숫자 입력

#### OutputView
- 게임 종료 메시지 출력
- 패자 출력
- 플레이어별 실행 횟수 출력

</details>

<details>
<summary><b>exception</b></summary>

- 도메인 및 입력 검증에서 사용되는 custom exception 정의

</details>

# Diagram

<img width="867" height="431" alt="Image" src="https://github.com/user-attachments/assets/b6cca93b-a49a-4083-b274-2a55dd2aed12" />

# Architecture (MVC + Strategy)

<img width="498" height="178" alt="Image" src="https://github.com/user-attachments/assets/7e04e208-5107-4397-a90d-9206123e58e5" />

해당 프로젝트는 순수 Java 기반의 콘솔 애플리케이션으로,
사용자 입력 처리와 게임 로직을 명확히 분리하기 위해 MVC 패턴과 Strategy 패턴을 적용했습니다.

- **Controller (GameController)**
    - 애플리케이션의 중심 역할을 수행하며, 사용자 요청을 받아 게임 흐름을 제어합니다.
    - Model(Player, Strategy)에 도메인 로직을 위임하고 View(InputView, OutputView)을 통해 입·출력을 처리합니다.
- **View (InputView, OutputView)**
    - 사용자 입력을 요청하고(Console 입력), 게임 결과 및 패자를 출력하는 콘솔 UI 계층
    - 비즈니스 로직은 포함하지 않습니다.
- **Model (Player, Name(vo), Count(vo), GameStrategy)**
    - 플레이어 상태(이름, 카운트)와 369 규칙(Strategy)을 관리
    - Single/Multiple Clap 규칙은 GameStrategy 구현체로 분리하여 확장성을 확보

# Testing (Junit5 + AssertJ)

<img width="730" height="167" alt="Image" src="https://github.com/user-attachments/assets/a0a8a7db-816b-4309-9fac-92dd20ec61b4" />
