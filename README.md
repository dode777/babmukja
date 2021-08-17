# 🍱 babmukja

- **프로젝트 소개** : 혼자 밥 먹는 사람들을 위해 사람을 매칭시켜 주는 플랫폼입니다.

<br>

## ⏳ 작업 기간 (2021. 08 ~ 진행중)

- Phase 1 (2021. 08.11 ~ 09. 30)

<br>

## 1차 기능

- 사용자는 **소셜로그인을 통해서만 로그인/가입** 한다.
- 가입 후 **소셜에서 들어오지 않는 데이터는 사용자가 추가로 기입**한다.

    ⇒ 소셜에서 들어오는 데이터 이름, 이메일, 성별, 프로필 사진

    ⇒ 이름, 이메일, 성별, 프로필사진, 별명 + 관심지역설정 + 관심 카테고리(한식, 분식, 카페/차, 디저트, 일식, 양식, 중식, 패스트푸드, 아시안 etc..)

    ⇒ 수정은 로그인 후 마이페이지에서 가능

- 로그인을 완료한 사용자는 **메인페이지에서 현재 등록된 요청 데이터를 리스트로 확인**한다.
    - 등록된 리스트는 **필터링 기능이 포함된 검색**이 가능하다.
    - 메인페이지의 리스트에서 특정 데이터를 선택하면 해당 요청에 대한 **상세 정보 페이지**로 이동한다.
    - 상세 페이지에서는 **등록한 사람, 날짜, 시간, 식당 위치 or 먹고싶은 음식**에 대한 정보가 표시된다.
    - 상세 페이지에서 원하는 식당이라면 **참여하기**를 통해 참여 신청이 가능하다.
    - **지도와 연동**되어 정확한 위치 확인이 가능하다.
    - 해당 상세 페이지에서 **댓글 작성**이 가능하다.
- 등록 요청 페이지에서 특정 가게 or 음식에 대해서 같이 갈 사람을 모으는 요청을 등록할 수 있다.
    - **날짜, 시간, 식당 위치 or 먹고싶은 음식, 원하는 성별, 나이대**에 대한 정보를 입력하여 등록한다.
    - 정해진 정보 외에 추가적인 정보는 **editor에서 추가정보**를 작성한다.
    - **지도를 통해** 식당 위치를 정확히 확인 후 등록한다.
- **내 정보 페이지**에서 사용자 정보를 확인한다.


<br>

## 🎨 [밥묵자 디자인 확인하기](https://www.figma.com/file/Potf9ZNZrFr4VM4lTdsP9y?embed_host=notion&kind=&viewer=1)

<br>

## 💻 Front 기술 스택

| 역할 | 스택명 |
| --- | --- |
| 프레임워크 | ![Next JS](https://img.shields.io/badge/Next-black?style=for-the-badge&logo=next.js&logoColor=white) |
| CSS-in-JS | ![Emotion](https://img.shields.io/badge/Emotion-DB7093?style=for-the-badge&logo=Styled-components&logoColor=white) |
| 상태관리 | ![Redux](https://img.shields.io/badge/redux-%23593d88.svg?style=for-the-badge&logo=redux&logoColor=white) <br> ![ReduxSaga](https://img.shields.io/badge/redux--saga-%23593d88.svg?style=for-the-badge&logo=reduxsaga&logoColor=white) |
| 기본 언어 | ![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white) |

<br>

## 💻 Back 기술 스택

| 역할 | 스택명 |
| --- | --- |
| 프레임워크 | ![SpringBoot](https://img.shields.io/badge/spring--boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white) |
| 기본 언어 | ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) |
| 데이터베이스 | ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white) |

<br>
