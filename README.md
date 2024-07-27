<h1 align="center">⚫️신개념 TUI 오★목⚪️</h1>
<h2 align="center">Java 2차원 배열 Project</h2>

<br>

<div align="center">
	<!-- 프로그램 주요 화면 -->
  <img width="350" src="https://github.com/user-attachments/assets/e357b894-94e7-4644-9b2b-5ef8f5df0038"/>
  <div align="left">
    흑돌 육목 및 백돌 승리 화면
  </div>
</div>

<br>

## 프로젝트 개요

> 개요

<br>

## 개발 기간

> 2024.03.13 ~ 2024.03.17

<br>

## 개발 인원

|팀원명|담당업무|
|:---:|---|
|[우승훈](https://github.com/bluewhale36)|PPT 제작, 오류 테스트<br>오목 판단 로직 구현|
|[차명규](https://github.com/ChaMyeongGyu97)|PPT 제작, 오류 테스트<br>육목 이상 판단 로직 구현|
|[문형욱](https://github.com/ssamjagod)|PPT 제작, 오류 테스트<br>게임 진행 알림 팝업 창 구현|
|이혜민|PPT 제작 총괄, 오류 테스트<br>선공 플레이어 선정 로직 구현|


<br>

## 개발 환경

> | BE |
> | :---: |
> | <img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat&logo=eclipse&logoColor=white"/> <img src="https://img.shields.io/badge/Java-F80000?style=flat&logoColor=white"/> |

<br>

## 요구사항 정의서

<img width="75%" src="https://github.com/user-attachments/assets/3dce4a7a-032d-4169-acd8-290e9b2d0a6f">

<br>

## 주요 기능

### 승리 판단
- 하나의 돌을 가로, 세로, 대각선 중 하나에 일렬로 5개를 먼저 놓은 플레이어가 승리한다.
- 일렬로 6개 이상의 돌을 놓는 육목 이상일 경우 승리로 인정되지 않는다.

### 플레이어 돌 착수
- 오목판의 좌표를 입력하여 돌을 착수 할 수 있다.
- 중복된 곳이나, 잘못된 좌표를 입력 할 수 없다.

### 플레이어 공격 순서 선정
- Random Class를 활용하여 0 ~ 9 중 더 높은 수를 뽑은 사람이 흑돌(선공)이다.
