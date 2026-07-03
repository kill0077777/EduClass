# 🤝 EduClass 기여 가이드

EduClass 프로젝트에 기여해주셔서 감사합니다! 이 가이드는 프로젝트에 기여하는 방법을 설명합니다.

## 📋 목차

1. [기여 방법](#기여-방법)
2. [개발 환경 설정](#개발-환경-설정)
3. [코드 스타일 가이드](#코드-스타일-가이드)
4. [커밋 메시지 가이드](#커밋-메시지-가이드)
5. [Pull Request 프로세스](#pull-request-프로세스)
6. [이슈 보고](#이슈-보고)

## 🚀 기여 방법

### 1. Fork 저장소
GitHub에서 EduClass 저장소를 Fork합니다.

```bash
# GitHub 웹사이트에서 Fork 버튼 클릭
```

### 2. Clone 저장소
```bash
git clone https://github.com/your-username/EduClass.git
cd EduClass
```

### 3. Upstream 설정
```bash
git remote add upstream https://github.com/kill0077777/EduClass.git
```

### 4. Feature Branch 생성
```bash
git checkout -b feature/your-feature-name
```

### 5. 변경사항 커밋
```bash
git add .
git commit -m "feat: 기능 설명"
```

### 6. Push
```bash
git push origin feature/your-feature-name
```

### 7. Pull Request 생성
GitHub에서 Pull Request를 생성합니다.

## 🛠️ 개발 환경 설정

### 필수 요구사항
- Java 21 이상
- Gradle 7.0 이상
- Git
- IDE (IntelliJ IDEA 권장)

### 1. 저장소 클론
```bash
git clone https://github.com/kill0077777/EduClass.git
cd EduClass
```

### 2. IDE 설정 (IntelliJ IDEA)
```bash
# IntelliJ IDEA에서 프로젝트 열기
# File > Open > EduClass 디렉토리 선택
```

### 3. 프로젝트 빌드
```bash
./gradlew clean build -x test
```

### 4. 서버 실행
```bash
./gradlew bootRun
```

### 5. 브라우저 접속
```
http://localhost:8089
```

## 📝 코드 스타일 가이드

### Java 코드 스타일

#### 1. 네이밍 컨벤션
```java
// 클래스: PascalCase
public class UserController { }

// 메서드: camelCase
public void getUserList() { }

// 상수: UPPER_SNAKE_CASE
public static final int MAX_SIZE = 100;

// 변수: camelCase
private String userName;
```

#### 2. 들여쓰기
- 4개 공백 사용 (탭 사용 금지)

#### 3. 라인 길이
- 최대 120자

#### 4. 주석
```java
/**
 * 사용자 목록을 조회합니다.
 *
 * @return 사용자 목록
 */
public List<User> getUserList() {
    // 구현
}
```

#### 5. 클래스 구조
```java
public class UserService {
    // 1. 필드
    private UserRepository userRepository;
    
    // 2. 생성자
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // 3. Public 메서드
    public User getUser(Long id) {
        // 구현
    }
    
    // 4. Private 메서드
    private void validateUser(User user) {
        // 구현
    }
}
```

### HTML/Thymeleaf 스타일
```html
<!-- 들여쓰기: 2개 공백 -->
<div class="container">
  <h1 th:text="${title}">제목</h1>
  <div th:each="item : ${items}">
    <p th:text="${item.name}">항목</p>
  </div>
</div>
```

### CSS 스타일
```css
/* 클래스명: kebab-case */
.user-card {
  display: flex;
  gap: 1rem;
}

/* 속성 순서: 레이아웃 -> 박스 모델 -> 타이포그래피 -> 시각 효과 */
.button {
  display: inline-block;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  color: #333;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 4px;
}
```

## 💬 커밋 메시지 가이드

### 커밋 메시지 형식
```
<type>(<scope>): <subject>

<body>

<footer>
```

### Type 종류
- `feat`: 새로운 기능
- `fix`: 버그 수정
- `docs`: 문서 수정
- `style`: 코드 스타일 변경 (기능 변화 없음)
- `refactor`: 코드 리팩토링
- `perf`: 성능 개선
- `test`: 테스트 추가/수정
- `chore`: 빌드 설정, 의존성 업데이트 등

### Scope 예시
- `lecture`: 강의 관련
- `notice`: 공지사항 관련
- `review`: 리뷰 관련
- `question`: 질문 관련
- `member`: 회원 관련
- `security`: 보안 관련

### 커밋 메시지 예시
```bash
# 새 기능 추가
git commit -m "feat(lecture): 강의 검색 기능 추가"

# 버그 수정
git commit -m "fix(review): 리뷰 평점 계산 오류 수정"

# 문서 업데이트
git commit -m "docs: README.md 설치 가이드 추가"

# 상세한 커밋 메시지
git commit -m "feat(lecture): 강의 필터링 기능 추가

- 카테고리별 필터링 추가
- 가격대별 필터링 추가
- 평점순 정렬 기능 추가

Fixes #123"
```

## 🔄 Pull Request 프로세스

### 1. PR 생성 전 확인사항
- [ ] 코드가 프로젝트의 코드 스타일을 따르는가?
- [ ] 새로운 기능에 대한 테스트를 추가했는가?
- [ ] 기존 테스트가 모두 통과하는가?
- [ ] 문서를 업데이트했는가?
- [ ] 커밋 메시지가 명확한가?

### 2. PR 제목
```
[Type] 기능 설명

예시:
[Feature] 강의 검색 기능 추가
[Fix] 리뷰 평점 계산 오류 수정
[Docs] API 문서 업데이트
```

### 3. PR 설명 템플릿
```markdown
## 설명
이 PR은 [기능/버그]에 대한 변경사항입니다.

## 변경사항
- 변경사항 1
- 변경사항 2
- 변경사항 3

## 관련 이슈
Fixes #123

## 테스트 방법
1. 다음 단계를 따르세요
2. 결과를 확인하세요

## 스크린샷 (해당하는 경우)
[스크린샷 추가]

## 체크리스트
- [ ] 코드 스타일 확인
- [ ] 테스트 추가
- [ ] 문서 업데이트
- [ ] 기존 테스트 통과
```

### 4. PR 검토 프로세스
- 프로젝트 관리자가 코드를 검토합니다
- 피드백이 있으면 요청사항을 반영합니다
- 모든 체크가 통과하면 Merge됩니다

## 🐛 이슈 보고

### 이슈 생성 전 확인
- [ ] 이미 보고된 이슈가 없는가?
- [ ] 최신 버전에서도 발생하는가?
- [ ] 재현 단계를 명확히 설명할 수 있는가?

### 이슈 제목
```
명확하고 간결한 제목

예시:
로그인 시 "사용자를 찾을 수 없음" 오류 발생
강의 목록 페이징이 작동하지 않음
```

### 이슈 설명 템플릿
```markdown
## 버그 설명
버그에 대한 명확한 설명

## 재현 단계
1. 다음 단계를 따르세요
2. ...
3. 버그가 발생합니다

## 예상 동작
예상되는 동작

## 실제 동작
실제 발생하는 동작

## 환경
- OS: [예: Ubuntu 20.04]
- Java 버전: [예: 21]
- 브라우저: [예: Chrome 120]

## 스크린샷
[스크린샷 추가]

## 추가 정보
기타 관련 정보
```

## 📚 개발 팁

### 1. 로컬 테스트
```bash
# 전체 테스트 실행
./gradlew test

# 특정 테스트 클래스 실행
./gradlew test --tests UserServiceTest

# 테스트 커버리지 확인
./gradlew test jacocoTestReport
```

### 2. 코드 포맷팅
```bash
# Gradle 포맷팅 플러그인 사용
./gradlew spotlessApply
```

### 3. 정적 분석
```bash
# SonarQube 분석
./gradlew sonarqube
```

### 4. 빌드 최적화
```bash
# 병렬 빌드
./gradlew build --parallel

# 빌드 캐시 사용
./gradlew build --build-cache
```

## 🎯 기여 아이디어

### 새로운 기능
- [ ] 강의 카테고리 추가
- [ ] 강의 추천 시스템
- [ ] 사용자 알림 기능
- [ ] 강의 다운로드 기능
- [ ] 자막 기능

### 개선사항
- [ ] UI/UX 개선
- [ ] 성능 최적화
- [ ] 보안 강화
- [ ] 에러 처리 개선
- [ ] 로깅 개선

### 문서화
- [ ] API 문서 작성
- [ ] 사용자 가이드 작성
- [ ] 개발자 가이드 작성
- [ ] 배포 가이드 작성

## 📞 질문이 있으신가요?

- GitHub Issues에서 질문을 등록하세요
- 토론이 필요한 경우 GitHub Discussions를 사용하세요
- 긴급한 경우 dev@educlass.com으로 연락하세요

## 📄 라이선스

이 프로젝트에 기여함으로써, 귀하는 귀하의 기여가 MIT 라이선스 하에 배포될 수 있음에 동의합니다.

---

**감사합니다! 🙏**

EduClass 프로젝트에 기여해주셔서 정말 감사합니다. 함께 더 좋은 프로젝트를 만들어갑시다!
