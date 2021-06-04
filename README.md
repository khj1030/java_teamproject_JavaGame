# java_teamproject_JavaGame

## <자바를 이용한 3종 미니게임(HANGMAN, Baskin Robbins, JAVA Quiz)> 

## Description
자바 GUI를 활용한 3종 미니게임(행맨, 베스킨 라빈스 31, 자바 퀴즈) 구현
- HANGMAN: 주어진 기회의 횟수 내에, 해당하는 단어를 맞추는 게임
- Baskin Robbins: 1~3개의 숫자를 번갈아 부르며, 마지막 숫자를 부르면 지는 게임
- JAVA Quiz: 자바와 관련된 이론/실습 문제를 푸는 게임

## Environment
자바 프로그램 실행을 위한 JRE(Java SE Runtime Environment) 설치 필요

## Prerequisite
Jsoup 라이브러리 설치 필요 (해당 자바 프로젝트의 라이브러리에 Jsoup jar 파일 추가)
- 첨부 파일의 >jsoup-1.13.1< 설치

“DX국민시대Regular” 글꼴 설치 필요 (지원 OS: Windows)
- 첨부 파일의 >Nanumsquare_ac_TTF< 폴더 내의, ttf 파일 4개 설치

## Usage
### teamproject\src\gamemain\GameStart.java
gamemain package 내의 GameStart.java 파일을 실행시킴으로써 해당 게임 진행 가능.
단, HANGMAN 게임 진행에 필요한 영단어 binary file(ex. level1_word.dat)이 없을 시, 게임 진행 이전에 Crawling.java 실행 필요

## Files (Summary information)
### teamproject\src\gamemain\
- GameStart.java: 전체 게임의 메인
- BounCingBall.java: Graphics를 활용한 JPanel의 배경 설정을 위한 Class
- CircleButton.java, RoundedButton.java: 버튼 디자인 설정을 위한 Class(JButton Class 상속)
- RoundedJTextField.java: 텍스트 필드 디자인 설정을 위한 Class(JTextField Class 상속)

### teamproject\src\baskin\
- BaskinRobbins.java: Baskin Robbins 게임 실행 메인
- BaskinRobbinsSingle.java: Baskin Robbins 게임의 Single Mode Class
- BaskinRobbinsMulti.java: Baskin Robbins 게임의 Multi Mode Class

### teamproject\src\hangman\
- HangMan.java: HangMan 게임 실행 메인
- HangManSingle.java: HangMan 게임의 Single Mode Class
- HangManMulti.java: HangMan 게임의 Multi Mode Class
- Crawling.java: HangMan 게임을 위한 영단어 Text File 생성 Class (게임 도중 실행 X)

### teamproject\src\javaQuiz\
- JavaStartGame.java: JAVA Quiz 게임 실행 메인
- Login.java: 아이디 등록을 위한 Class
- JavaSelectType.java: JAVA Quiz 게임의 이론/실습 선택 Class
- TheoryDataClass.java: 이론 문제에 대한 Data Class
- TheoryJavaGame.java: 이론 문제에 대한 JAVA Quiz실행 Class
- TheoryResult.java: 이론 문제 풀이 결과의 파일 입출력 및 저장에 대한 Data Class
- LabDataClass.java: 실습 문제에 대한 Data Class
- LabJavaGame.java: 실습 문제에 대한 JAVA Quiz실행 Class
- LabResult.java: 실습 문제 풀이 결과의 파일 입출력 및 저장에 대한 Data Class
- GuiResult.java: 이론 및 실습 게임 진행 결과에 대한 순위 출력 Class
- Student.java: 아이디 및 점수 저장을 위한 Class

 
## Detailed description of the game + Files (detailed information)
## ▶ HANGMAN
### SINGLE MODE
   * nomal/hard mode 설정: 어떤 문자가 들어갈지 맞힐 수 있는 기회의 횟수 설정
     - normal mode: 총 9번의 기회가 주어짐
     - hard mode: 총 7번의 기회가 주어짐
   * level 설정: 1~3 level로 구성
     - 1 level: 5자리 이하의 단어
     - 2 level: 5~10자리 이하의 단어
     - 3 level: 10자리 이상의 단어가 존재

### 게임 방법
- single mode 버튼을 누르고 mode와 level을 설정한다.
- 입력칸에 알파벳을 하나의 입력해 확인 버튼을 누른다.
- 만약 맞을 경우 _부분이 알파벳으로 바뀌고 아닐 경우 Wrong에 알파벳이 추가되고 행맨이 그려진다.
- 만약 아무것도 입력하지 않는다면 'type error'라는 창이 뜰 것이다
- 만약 맞힌 알파벳을 한 번 더 입력한다면 'same char'라는 창이 뜨고 행맨이 하나 그려진다.
- 주어진 기회 안에 단어를 맞히면 you win. 창이 뜨고 게임이 종료된다.
- 주어진 기회 안에 단어를 맞히지 못하면 you lose. 라는 창이 뜨고 게임이 종료된다.

### MULTI MODE
   * nomal/hard mode 설정: 어떤 문자가 들어갈지 맞힐 수 있는 기회의 횟수 설정
     - normal mode: 총 9번의 기회가 주어짐
     - hard mode: 총 7번의 기회가 주어짐
   * member 수 설정: 최대 6명으로 구성
   * answer 입력
     - player1이 생각한 답을 입력

### 게임 방법
- multi mode 버튼을 누르고 mode와 member 수와 정답을 설정한다.
- 입력칸에 알파벳을 하나의 입력해 확인 버튼을 누른다.
- player1을 제외한 player들에게 순서대로 돌아가며 한 번씩 주어진다.
- 만약 그 player가 정답을 맞혔다면 20점이 증가되고 아닐 경우는 아무 점수도 추가되지 않는다.
- 만약 맞을 경우 _부분이 알파벳으로 바뀌고 아닐 경우 Wrong에 알파벳이 추가되고 행맨이 그려진다.
- 만약 아무것도 입력하지 않는다면 'type error'라는 창이 뜰 것이다
- 만약 맞힌 알파벳을 한 번 더 입력한다면 'same char'라는 창이 뜨고 행맨이 하나 그려진다.
- 주어진 기회 안에 단어를 맞히면 점수가 가장 높은 player가 이기고 게임이 종료된다.
- 주어진 기회 안에 단어를 맞히지 못하면 player 1이 이기고 게임이 종료된다.

### .java class 설명
- hangmanstart: hangman을 시작하는 클래스
  -내부에는 mode, level, member 수, answer들을 설정하는 내부 클래스가 있다.
- HangMan: single 모드로 게임이 실행된다.
- multiHangMan: multi 모드로 게임이 실행된다.
- Crawling.java: HangMan 게임을 위한 영단어 텍스트 파일을 생성하는 Class
  -게임 시작 전, 이미 파일에 영단어 data가 저장되어 있으며, 파일이 없는 경우 따로 실행이 필요하다.


## ▶ Baskin Robbins
### SINGLE MODE
 * KEY 값 설정
    - 유저가 31이상 50 이하의 수를 직접 선택

### 게임 방법
- 컴퓨터와 차례로 1이상 3사이의 수를 말하며 1부터 시작하여 그 수를 더해 누적된 값을 이용해 게임을 진행한다.
- 유저와 컴퓨터 둘 중 KEY값을 말하는 쪽이 패배한다. 승패 결과가 출력되어 있는 새로운 팝업창이 뜨고, 확인 버튼을 누르면 게임이 종료된다.

### MULTI MODE
 * KEY 값 설정
    - 컴퓨터에서 임의로 31이상 50이하의 수 지정

### 게임 방법
- 2명이상 4명이하의 유저들이 게임에 참여할 수 있으며, 게임 인원을 설정한 뒤 차례로 돌아가면서 1이상 3이하의 수를 말하고, 1부터 시작하여 그 수를 더해 누적된 값을 이용해 게임을 진행한다.
- 유저들 중 KEY값을 말하는 쪽이 패배한다. 승패 결과가 출력되어 있는 새로운 팝업창이 뜨고, 확인 버튼을 누르면 게임이 종료된다.

### .java class 설명
- BaskinRobbins: BaskinRobbins Game을 시작하는 클래스
- BaskinRobbinsSingle: Single 모드로 게임이 실행된다.
  - 누적값의 범위에 따라 차례로 초록색, 노란색, 빨간색 폭탄으로 바뀐다.
  - 주어진 범위를 벗어나면 에러창이 뜬다.
- BaskinRobbinsMulti: Multi 모드로 게임이 실행된다.
  - 누적값의 범위에 따라 차례로 초록색, 노란색, 빨간색 폭탄으로 바뀐다.
  - 주어진 범위를 벗어나면 에러창이 뜬다.

## ▶ JAVA Quiz
### Theory Mode, Lab Mode
   * 아이디 입력 후, 자바 이론 혹은 실습 문제에 대한 퀴즈를 진행
     - 이미 있는 아이디라면, 이전 게임 진행 결과를 보여주고, 새로 게임을 할 것인지 선택

### 게임 방법
- 아이디를 입력하고, 게임 종류 선택 화면에서 Theory 또는 Lab을 입력하여 선택한다.
- 해당 종류의 게임에서 아이디에 대한 이전 기록이 있다면, 해당 아이디에 대한 이전 기록을 보여주고, 새로 게임을 진행할 것인지 선택한다.
  - 새로 게임을 진행한다면, 해당 게임의 진행 결과로 data가 새롭게 업데이트 된다.
  - 새로 게임을 진행하지 않는다면, 아이디 입력 화면으로 돌아가게 된다.
- 게임이 진행되고, 정답 입력란에 정답을 입력하고 NEXT 버튼을 누를 시, 1초 동안 채점 결과를 보여주고 다음 문제로 넘어가게 된다.
  - Theory 게임은 문제에 대한 답을 작성하고, Lab 게임은 화면 왼쪽에 주어진 코드를 보고 틀린 코드와 수정 결과 코드를 작성한다.
  - Lab 게임의 경우, 틀린 코드와 수정할 코드를 입력하게 되는데, 틀린 코드가 없이 수정할 코드만 쓰게 되는 경우가 있다. 이 때에는 큰 따옴표 두 개("")를 위쪽 입력란(틀린 코드 작성란)에 입력하고, 아래쪽 입력란(수정할 코드 작성란)에 답을 써넣으면 된다.
  - Lab 게임의 경우, 코드의 수정할 부분을 '일부' 작성하는 것이 아닌, 수정할 부분이 있는 코드 '한 줄' 전체를 수정하여야 한다.
  - 문제를 푸는 도중 BACK를 누르게 되더라도 이전의 채점 결과를 유지하고 있다. 이때, 답안을 수정할 시 수정이 불가하다는 안내 메시지가 뜨게 되며, 가장 처음 입력했던 답안을 고정시킨다.
- 중간에 EXIT 버튼을 누르거나, 문제가 끝이 나게 되면 게임은 종료 되고, 현재 사용자의 정보에서 (맞힌 문제 수 / 전체 문제 수)를 보여주며, 최종적으로 순위 결과 화면을 띄운다.
  - 만약, 이전 사용자들 중 동점자가 있다면, 아이디 및 점수 기록이 되지 않는다.

### .java class 설명
- JavaStartGame: JAVA Quiz 게임 실행 메인
- Login: 아이디 등록을 위한 Class
  - Login class에서 입력받은 아이디를 JavaSelectType class로 넘겨주며 해당 class를 실행시킨다.
- JavaSelectType: JAVA Quiz 게임의 이론/실습 선택 Class
  -. TheoryResult 또는 LabResult class 객체를 통해, 선택한 종류의 게임에서 Login class로부터 넘겨받은 아이디가 있는지 확인하고, 게임을 진행할 것인지 선택하도록 한다. 게임을 진행하겠다고 선택한다면, TheoryJavaGame 또는 LabJavaGame class에 아이디를 넘겨주며 해당 class를 실행시킨다.

- TheoryDataClass: 이론 문제에 대한 Data가 저장된 Class
  - 한 개의 문제에 대해, 문제 번호, 문제 풀이 여부, 채점 결과 이미지, 문제에 대한 data, 사용자가 작성한 답안을 저장하는 class이다.
- TheoryJavaGame: 이론 문제에 대한 JAVA Quiz실행 Class
  - 이론 문제를 풀면서, Thread를 통해 1초간 채점결과를 보여주고, 다음 문제로 넘어간다. 이때, 각 문제를 각 Panel에 쓰고, ArrayList<Panel> 객체를 통해 화면에 서로 다른 문제 정보를 보이도록 하였다.
  - 채점 결과를 화면에 보이도록 하는 것은 repaint()를 통해 구현하였다.
  - 게임이 끝나고, 사용자에 대한 정보는 Student 객체에 저장되어, TheoryResult 객체의 TreeSet<Student> 멤버 변수에 저장되게 된다. 그 후, 업데이트 된 TreeSet<Student>의 정보를 TheoryResult.dat 파일에 쓰게 된다.
  - 그 후, 최종적으로 GuiResult class의 String type의 parameter를 갖는 생성자를 호출한다. 
- TheoryResult: 이론 문제 풀이 결과의 파일 입출력 및 저장에 대한 Data Class
  - Theory 게임에 대한 사용자 set(TreeSet<Student>로 구현)을 가지고 있고, 이러한 사용자들의 data를 바이너리 파일에 쓰고 읽는 역할을 하는 class이다.

- LabDataClass: 실습 문제에 대한 Data가 저장된 Class
- LabJavaGame: 실습 문제에 대한 JAVA Quiz실행 Class
- LabResult: 실습 문제 풀이 결과의 파일 입출력 및 저장에 대한 Data Class
     (7~9는 각각 4~6 Theory 관련 class와 같은 방식으로 동작한다.)

- GuiResult: 이론 및 실습 게임 진행 결과에 대한 순위 출력 Class
  - parameter에 입력된 문자열이 “Theory”인지, “Lab”인지에 따라, TheoryResult 또는 LabResult 객체를 생성하여, 객체 내의 TreeSet<Student> 순서를 보여준다. (간단한 순위 표기를 위해 TreeSet을 사용하였다.)
- Student: 아이디 및 점수 저장을 위한 Class
  - 아이디, 맞힌 문제 수, 총 문제 수에 대한 data를 저장하는 class이다.

### .txt class 설명
- theory: 자바 이론 문제가 저장된 텍스트 파일
  - 문제 설명, 문제, 정답으로 구성되어 있다. 총 세 라인이 하나의 문제가 된다. 
- lab: 자바 실습 문제가 저장된 텍스트 파일
  - 문제 설명, 문제, 틀린 부분 정답, 수정 결과 정답으로 구성되어 있다.
  - 실습 문제의 길이가 모두 다르기에, 정답이 될 두 라인 이전에 ‘#’ 문자를 추가함으로써 구분하였다.


