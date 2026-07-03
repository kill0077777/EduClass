# 🎓 EduClass - 온라인 강의 플랫폼

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/kill0077777/EduClass)

**EduClass**는 Spring Boot와 Thymeleaf를 기반으로 한 완전히 통합된 온라인 강의 플랫폼입니다. 사용자는 강의를 수강하고, 리뷰를 작성하며, Q&A를 통해 질문할 수 있습니다.

## ✨ 주요 기능

### 📚 강의 관리
- 강의 목록 조회 (페이징 지원)
- 강의 상세 정보 조회
- 강의 등록/수정/삭제 (강사/관리자)
- 강의 수강 (무료/유료)
- 강의 콘텐츠 관리

### 📢 공지사항
- 공지사항 목록 조회
- 고정 공지사항 우선 표시
- 조회수 추적
- 공지사항 작성/수정/삭제 (관리자)

### ⭐ 리뷰 시스템
- 강의별 리뷰 작성 (1-5점)
- 평점 자동 계산
- 리뷰 목록 조회
- 리뷰 수정/삭제

### ❓ Q&A 시스템
- 질문 작성 (수강생)
- 답변 작성 (강사/관리자)
- 질문/답변 목록 조회
- 질문 상태 관리 (미답변/답변완료)

### 👤 사용자 관리
- 회원 가입 (이메일 중복 체크)
- 로그인/로그아웃
- 역할 기반 접근 제어 (RBAC)
- 마이페이지 (수강 강의 조회)

### 📊 대시보드
- 통계 정보 (강의 수, 공지사항 수, 평균 평점)
- 최신 강의 카드형 표시
- 최신 공지사항 표시

## 🛠️ 기술 스택

### Backend
- **Framework**: Spring Boot 3.x
- **Language**: Java 21
- **ORM**: JPA/Hibernate
- **Database**: H2 (개발용), MySQL (프로덕션)
- **Template Engine**: Thymeleaf
- **Security**: Spring Security
- **Build Tool**: Gradle

### Frontend
- **Template Engine**: Thymeleaf
- **CSS Framework**: Bootstrap 5
- **JavaScript**: Vanilla JS
- **Responsive Design**: Mobile-First

### Database Schema
```
Member (회원)
├── id: Long (PK)
├── userId: String (Unique)
├── password: String
├── name: String
├── email: String (Unique)
├── role: Enum (ADMIN, INSTRUCTOR, STUDENT)
└── regDate: LocalDateTime

Lecture (강의)
├── id: Long (PK)
├── title: String
├── description: String
├── instructor: Member (FK)
├── category: String
├── price: Integer
├── status: Enum (OPEN, CLOSED)
├── rating: Double (평균)
└── regDate: LocalDateTime

Notice (공지사항)
├── id: Long (PK)
├── title: String
├── content: String
├── fixedFlag: Boolean
├── hit: Integer
└── regDate: LocalDateTime

Review (리뷰)
├── id: Long (PK)
├── lecture: Lecture (FK)
├── member: Member (FK)
├── rating: Integer (1-5)
├── comment: String
└── regDate: LocalDateTime

Question (질문)
├── id: Long (PK)
├── lecture: Lecture (FK)
├── member: Member (FK)
├── title: String
├── questionText: String
└── createdAt: LocalDateTime

Answer (답변)
├── id: Long (PK)
├── question: Question (FK)
├── member: Member (FK)
├── answerText: String
└── createdAt: LocalDateTime

Enrollment (수강)
├── id: Long (PK)
├── member: Member (FK)
├── lecture: Lecture (FK)
├── progress: Integer (0-100%)
└── enrollDate: LocalDateTime
```

## 🚀 빠른 시작

### 필수 요구사항
- Java 21 이상
- Gradle 7.0 이상
- Git

### 설치 및 실행

#### 1. 저장소 클론
```bash
git clone https://github.com/kill0077777/EduClass.git
cd EduClass
```

#### 2. 프로젝트 빌드
```bash
./gradlew clean build -x test
```

#### 3. 서버 실행
```bash
java -jar build/libs/lecture-app.jar
```

또는 Gradle로 직접 실행:
```bash
./gradlew bootRun
```

#### 4. 브라우저에서 접속
```
http://localhost:8089
```

### 기본 사용자 계정

| 이메일 | 아이디 | 비밀번호 | 역할 |
|--------|--------|---------|------|
| admin@example.com | admin | admin123 | 관리자 |
| instructor@example.com | instructor | instructor123 | 강사 |
| user@example.com | user1 | user123 | 학생 |
| user2@example.com | user2 | user2123 | 학생 |

## 📁 프로젝트 구조

```
EduClass/
├── src/main/
│   ├── java/com/edu/
│   │   ├── EduApplication.java          # 메인 애플리케이션
│   │   ├── DataInitializer.java         # 샘플 데이터 초기화
│   │   ├── MainController.java          # 홈페이지 컨트롤러
│   │   ├── entity/                      # JPA 엔티티
│   │   │   ├── Member.java
│   │   │   ├── Lecture.java
│   │   │   ├── Notice.java
│   │   │   ├── Review.java
│   │   │   ├── Question.java
│   │   │   ├── Answer.java
│   │   │   ├── Enrollment.java
│   │   │   ├── Role.java
│   │   │   └── LectureStatus.java
│   │   ├── lecture/                     # 강의 모듈
│   │   │   ├── LectureController.java
│   │   │   ├── LectureService.java
│   │   │   └── LectureRepository.java
│   │   ├── notice/                      # 공지사항 모듈
│   │   │   ├── NoticeController.java
│   │   │   ├── NoticeService.java
│   │   │   └── NoticeRepository.java
│   │   ├── review/                      # 리뷰 모듈
│   │   │   ├── ReviewController.java
│   │   │   ├── ReviewService.java
│   │   │   └── ReviewRepository.java
│   │   ├── question/                    # 질문 모듈
│   │   │   ├── QuestionController.java
│   │   │   ├── QuestionService.java
│   │   │   └── QuestionRepository.java
│   │   ├── answer/                      # 답변 모듈
│   │   │   ├── AnswerController.java
│   │   │   ├── AnswerService.java
│   │   │   └── AnswerRepository.java
│   │   ├── member/                      # 회원 모듈
│   │   │   ├── MemberController.java
│   │   │   ├── MemberService.java
│   │   │   └── MemberRepository.java
│   │   ├── enrollment/                  # 수강 모듈
│   │   │   ├── EnrollmentService.java
│   │   │   └── EnrollmentRepository.java
│   │   ├── security/                    # 보안 설정
│   │   │   ├── SecurityConfig.java
│   │   │   ├── PasswordEncoderConfig.java
│   │   │   ├── CustomAuthenticationProvider.java
│   │   │   └── UserSecurityService.java
│   │   ├── config/                      # 설정
│   │   └── utils/                       # 유틸리티
│   │       ├── DateFormatUtils.java
│   │       └── Paging.java
│   └── resources/
│       ├── templates/                   # Thymeleaf 템플릿
│       │   ├── index.html               # 홈페이지
│       │   ├── layout.html              # 기본 레이아웃
│       │   ├── navbar.html              # 네비게이션
│       │   ├── lecture/
│       │   │   ├── list.html
│       │   │   ├── detail.html
│       │   │   └── form.html
│       │   ├── notice/
│       │   ├── review/
│       │   ├── question/
│       │   ├── answer/
│       │   ├── member/
│       │   └── include/
│       ├── static/                      # 정적 자산
│       │   ├── bootstrap.min.css
│       │   ├── bootstrap.min.js
│       │   └── style.css
│       └── application.properties       # 애플리케이션 설정
├── build.gradle                         # Gradle 설정
├── .gitignore
└── README.md
```

## 🔌 API 엔드포인트

### 홈페이지
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/` | 홈페이지 |

### 강의
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/lecture/list` | 강의 목록 |
| GET | `/lecture/detail/{id}` | 강의 상세 |
| GET | `/lecture/form` | 강의 등록 폼 |
| POST | `/lecture/save` | 강의 저장 |
| GET | `/lecture/delete/{id}` | 강의 삭제 |

### 공지사항
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/notice/list` | 공지사항 목록 |
| GET | `/notice/detail/{id}` | 공지사항 상세 |
| GET | `/notice/form` | 공지사항 등록 폼 |
| POST | `/notice/save` | 공지사항 저장 |

### 리뷰
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| POST | `/review/save` | 리뷰 저장 |

### 질문/답변
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/question/list` | 질문 목록 |
| POST | `/question/save` | 질문 저장 |
| POST | `/answer/save` | 답변 저장 |

### 회원
| 메서드 | 엔드포인트 | 설명 |
|--------|-----------|------|
| GET | `/member/form` | 회원 가입 폼 |
| POST | `/member/save` | 회원 가입 |
| GET | `/login` | 로그인 페이지 |
| POST | `/logout` | 로그아웃 |

## 🔐 사용자 역할 및 권한

### ADMIN (관리자)
- ✓ 모든 강의 관리
- ✓ 공지사항 작성/수정/삭제
- ✓ 모든 질문에 답변 가능
- ✓ 사용자 관리

### INSTRUCTOR (강사)
- ✓ 자신의 강의 관리
- ✓ 강의 콘텐츠 추가/수정
- ✓ 자신의 강의에 대한 질문 답변
- ✓ 강의 리뷰 조회

### STUDENT (학생)
- ✓ 강의 수강
- ✓ 리뷰 작성
- ✓ 질문 작성
- ✓ 마이페이지에서 수강 강의 조회

## 📊 샘플 데이터

프로젝트 시작 시 자동으로 다음 샘플 데이터가 생성됩니다:

- **회원**: 4명 (관리자 1, 강사 1, 학생 2)
- **강의**: 6개 (무료 1개, 유료 5개)
- **공지사항**: 4개 (고정 2개)
- **수강 정보**: 4개
- **리뷰**: 4개
- **질문**: 3개
- **답변**: 2개

## ⚙️ 설정

### application.properties
```properties
# 서버 포트
server.port=8089

# H2 데이터베이스 (개발용)
spring.datasource.url=jdbc:h2:mem:edu
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 콘솔
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=false

# Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### MySQL 설정 (프로덕션)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/educlass
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=validate
```

## 🐛 트러블슈팅

### 포트 8089가 이미 사용 중인 경우
```bash
# 기존 프로세스 종료
lsof -i :8089 | grep LISTEN | awk '{print $2}' | xargs kill -9

# 또는 다른 포트로 실행
java -jar build/libs/lecture-app.jar --server.port=8090
```

### 데이터베이스 초기화 문제
```bash
# 캐시 삭제 후 재빌드
rm -rf build .gradle
./gradlew clean build -x test
```

### 템플릿 렌더링 오류
- `application.properties`에서 `spring.thymeleaf.cache=false` 확인
- 브라우저 캐시 삭제 (Ctrl+Shift+Delete)

### 로그인 실패
- 기본 계정 확인: admin / admin123
- 데이터베이스 초기화 확인

## 📈 성능 최적화

### 1. 데이터베이스 쿼리 최적화
- JPA N+1 문제 해결 (fetch join 사용)
- 인덱스 추가 (lecture_id, member_id)

### 2. 캐싱
- Thymeleaf 템플릿 캐싱 활성화 (프로덕션)
- Spring Cache 추가 가능

### 3. 페이징
- 강의/공지사항 목록 페이징 구현
- 한 페이지당 10개 항목 표시

## 🚀 프로덕션 배포

### Docker 배포
```dockerfile
FROM openjdk:21-jdk-slim
COPY build/libs/lecture-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

### 빌드 및 실행
```bash
docker build -t educlass:latest .
docker run -p 8089:8089 educlass:latest
```

### 환경 변수 설정
```bash
export SPRING_PROFILES_ACTIVE=production
export SPRING_DATASOURCE_URL=jdbc:mysql://your-db-host:3306/educlass
export SPRING_DATASOURCE_USERNAME=your-username
export SPRING_DATASOURCE_PASSWORD=your-password
```

## 📝 개발 가이드

### 새로운 기능 추가 방법

1. **엔티티 생성** (`entity/` 디렉토리)
```java
@Entity
public class NewFeature {
    @Id @GeneratedValue
    private Long id;
    // ... 필드
}
```

2. **Repository 생성**
```java
public interface NewFeatureRepository extends JpaRepository<NewFeature, Long> {}
```

3. **Service 생성**
```java
@Service
public class NewFeatureService {
    @Autowired
    private NewFeatureRepository repository;
    // ... 메서드
}
```

4. **Controller 생성**
```java
@Controller
@RequestMapping("/newfeature")
public class NewFeatureController {
    @Autowired
    private NewFeatureService service;
    
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("items", service.getAll());
        return "newfeature/list";
    }
}
```

5. **Template 생성** (`templates/newfeature/list.html`)

## 🤝 기여 가이드

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

## 📞 연락처

- **프로젝트 관리자**: EduClass Dev Team
- **이메일**: dev@educlass.com
- **GitHub**: [kill0077777](https://github.com/kill0077777)

## 🙏 감사의 말

이 프로젝트는 다음 오픈소스 프로젝트를 사용합니다:
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Bootstrap](https://getbootstrap.com/)
- [Hibernate](https://hibernate.org/)

---

**마지막 업데이트**: 2026년 7월 1일  
**버전**: 1.0.0  
**상태**: ✅ 프로덕션 준비 완료
