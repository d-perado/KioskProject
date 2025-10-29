## 기술 스택

java version "17.0.12" 2024-07-16 LTS

## 협업 툴 및 환경

---
- Git
  - 컨벤션 설정
 # KioskProject

간단한 콘솔(터미널) 기반 키오스크(Kiosk) 시뮬레이터 프로젝트  
(학습/과제 목적의 Java 콘솔 애플리케이션)

---

## 프로젝트 개요
사용자가 콘솔을 통해 카테고리를 선택하고 메뉴를 장바구니에 담아 주문까지 진행할 수 있는 **키오스크 시뮬레이터**입니다.  
장바구니 관리(담기/취소/전체취소), 할인 적용, 주문 처리 등 실제 키오스크의 기본 흐름을 연습하는 것을 목표로 합니다.

---

## 진행 기간
- 2025-10-13 ~ 2025-10-29

---

##  주요 기능
- 카테고리 및 메뉴 출력 → 사용자 선택
- 장바구니(복수 품목) 추가 / 개별 품목 제거 / 전체 취소
- 할인 타입 선택 및 할인 적용
- 주문(구매) 확정 시 장바구니 비우기 및 요약 출력
- 콘솔 출력/입력의 일관성 개선 (출력 클래스 분리 등)
- 제네릭 적용 및 코드 리팩토링 이력 존재

---

## 기술 스택
- Java 17 (LTS) — `java version "17.0.12"`
- 빌드 도구: 없음(단순 자바 프로젝트 / IDE 기반 실행 권장)
- 주요 패키지: `challengeKiosk` (예시)

---

##  설치 및 실행 (로컬)
> 아래 예시는 **로컬에서 단순 javac / java**로 실행하는 방법입니다. IntelliJ 같은 IDE에서 `src`를 프로젝트로 임포트한 뒤 `Kiosk`(또는 실제 Main 클래스)를 Run 하셔도 됩니다.

### 1) 소스 컴파일 (리눅스/맥 / Git Bash)
```bash
# 프로젝트 루트에서
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
```

### 2) 애플리케이션 실행
(메인 클래스로 `challengeKiosk.Kiosk`를 가정합니다. 실제 Main 클래스가 다르면 변경하세요.)
```bash
java -cp out challengeKiosk.Kiosk
```

### IntelliJ 사용 팁
1. IntelliJ에서 `File > New > Project from Existing Sources...`로 리포지터리 루트 선택.
2. `src` 폴더를 Sources Root로 설정.
3. `challengeKiosk.Kiosk` (또는 실제 포함된 Main 클래스를) Run configuration에 설정 후 실행.

---

## 프로젝트 구조 (예시)
```
KioskProject/
├─ src/
│  └─ challengeKiosk/
│     ├─ Kiosk.java           # (메인)
│     ├─ Menu.java
│     ├─ Cart.java
│     ├─ Item.java / MenuItem.java
│     └─ 출력 관련 클래스들
├─ .gitignore
├─ README.md
```

---

##  사용 예시 (플로우)
1. 앱 실행 → 카테고리 리스트 출력  
2. 카테고리 선택 → 메뉴 리스트 출력  
3. 메뉴 선택 → 수량 입력 → 장바구니에 담김  
4. 장바구니 확인 → 할인 선택 → 결제(주문 확정)  
5. 주문 확정 시 장바구니 초기화 및 영수증 요약 출력

---

## 개발 노트 / 의사 결정 요약
- 제네릭 적용을 통해 Cart/Item 관리 유연성 개선 시도(커밋 히스토리 참고).
- 출력 관련 클래스 분리로 콘솔 포맷 일관성 확보.
- 폴더 구조 정리 및 메소드명/컨벤션 통일(커밋 메세지 참조).

---

## 스크린샷
프로젝트 루트 README에 이미 포함된 스크린샷을 참조하세요 (콘솔 UI / 장바구니 / 할인 적용 화면 등).

등록한 카테고리 출력 및 사용자 선택

<img width="301" height="216" alt="image" src="https://github.com/user-attachments/assets/8420d1f4-d8ab-4f0a-a92c-3366ebd5179d" />

종료

<img width="299" height="137" alt="image" src="https://github.com/user-attachments/assets/2d52f55b-4e38-4c25-ae0c-052be003ec09" />

등록한 메뉴 출력 및 상품 장바구니에 담기

<img width="492" height="366" alt="image" src="https://github.com/user-attachments/assets/4d43b501-bc84-4daf-9942-8caa7380e230" />

장바구니에 담긴 상품 있을 시 ORDERMENU 활성화

<img width="610" height="485" alt="image" src="https://github.com/user-attachments/assets/b9e6a97e-a469-4024-afb1-b4ffcff2a909" />

할인 유형 선택

<img width="279" height="163" alt="image" src="https://github.com/user-attachments/assets/b5f43b07-1989-4a41-90e2-146d81256636" />

할인 적용

<img width="262" height="49" alt="image" src="https://github.com/user-attachments/assets/ea9dd1ed-3c2f-4e6a-8da4-edb974cbda29" />

주문시 할인적용 및 장바구니가 비었으므로 ORDERMENU 비활성화

<img width="363" height="307" alt="image" src="https://github.com/user-attachments/assets/df84f835-c345-4efb-9c03-57b83c8d8378" />

물품 취소

<img width="371" height="265" alt="image" src="https://github.com/user-attachments/assets/bbe93b3d-e6e0-414d-9916-7908577696e7" />

<img width="384" height="248" alt="image" src="https://github.com/user-attachments/assets/4b2127dd-1473-40e6-a991-f3f94a8b65c3" />

물품 전체 취소

<img width="379" height="201" alt="image" src="https://github.com/user-attachments/assets/afb96a1d-d527-4169-b965-ad823b8d03b6" />
---

- 작성자: `d-perado`
- 연락처: GitHub 프로필을 통해 PR/Issue로 문의 바랍니다.

---







