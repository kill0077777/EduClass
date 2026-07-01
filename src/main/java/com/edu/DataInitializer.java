package com.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.edu.entity.*;
import com.edu.entity.Role;
import com.edu.lecture.LectureRepository;
import com.edu.notice.NoticeRepository;
import com.edu.member.MemberRepository;
import com.edu.enrollment.EnrollmentRepository;
import com.edu.review.ReviewRepository;
import com.edu.question.QuestionRepository;
import com.edu.answer.AnswerRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private LectureRepository lectureRepository;
    
    @Autowired
    private NoticeRepository noticeRepository;
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerRepository answerRepository;
    


    @Override
    public void run(String... args) throws Exception {
        // 데이터가 이미 있으면 초기화하지 않음
        if (memberRepository.count() > 0) {
            return;
        }

        System.out.println("=== 샘플 데이터 초기화 시작 ===");

        // 1. 회원 데이터 생성
        Member admin = Member.builder()
                .email("admin@example.com")
                .name("관리자")
                .userId("admin")
                .password("admin123")
                .role(Role.ADMIN)
                .regDate(LocalDateTime.now())
                .build();

        Member instructor = Member.builder()
                .email("instructor@example.com")
                .name("강사 김철수")
                .userId("instructor")
                .password("instructor123")
                .role(Role.INSTRUCTOR)
                .regDate(LocalDateTime.now())
                .build();

        Member user1 = Member.builder()
                .email("user@example.com")
                .name("학생 이영희")
                .userId("user1")
                .password("user123")
                .role(Role.STUDENT)
                .regDate(LocalDateTime.now())
                .build();

        Member user2 = Member.builder()
                .email("user2@example.com")
                .name("학생 박민수")
                .userId("user2")
                .password("user2123")
                .role(Role.STUDENT)
                .regDate(LocalDateTime.now())
                .build();

        memberRepository.saveAll(List.of(admin, instructor, user1, user2));
        System.out.println("✓ 회원 데이터 생성 완료");

        // 2. 강의 데이터 생성
        Lecture lecture1 = Lecture.builder()
                .title("Spring Boot 완벽 가이드")
                .description("Spring Boot를 처음부터 배우는 완벽한 강의입니다. 기초부터 심화까지 모든 내용을 다룹니다.")
                .category("Backend")
                .price(49900)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        Lecture lecture2 = Lecture.builder()
                .title("React 마스터 클래스")
                .description("React의 모든 것을 배우세요. Hooks, Context API, 상태관리 등을 완벽하게 이해합니다.")
                .category("Frontend")
                .price(39900)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        Lecture lecture3 = Lecture.builder()
                .title("Python 데이터 분석")
                .description("Pandas, NumPy, Matplotlib를 사용한 데이터 분석 완벽 가이드입니다.")
                .category("DataScience")
                .price(29900)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        Lecture lecture4 = Lecture.builder()
                .title("JavaScript 기초")
                .description("JavaScript의 기초를 배우는 강의입니다. 초보자도 쉽게 따라할 수 있습니다.")
                .category("Frontend")
                .price(0)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        Lecture lecture5 = Lecture.builder()
                .title("SQL 마스터하기")
                .description("SQL을 완벽하게 배우고 데이터베이스 쿼리 최적화까지 배웁니다.")
                .category("Database")
                .price(34900)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        Lecture lecture6 = Lecture.builder()
                .title("Docker & Kubernetes")
                .description("Docker와 Kubernetes를 사용한 컨테이너 오케스트레이션을 배웁니다.")
                .category("DevOps")
                .price(59900)
                .status(LectureStatus.OPEN)
                .instructor(instructor)
                .regDate(LocalDateTime.now())
                .build();

        lectureRepository.saveAll(List.of(lecture1, lecture2, lecture3, lecture4, lecture5, lecture6));
        System.out.println("✓ 강의 데이터 생성 완료");

        // 3. 공지사항 데이터 생성
        Notice notice1 = Notice.builder()
                .title("🎉 새로운 강의 오픈 안내")
                .content("안녕하세요! 이번 주에 새로운 강의들이 오픈됩니다. Docker & Kubernetes, Python 데이터 분석 등 다양한 주제의 강의를 준비했습니다. 많은 관심 부탁드립니다!")
                .fixedFlag(true)
                .hit(245)
                .regDate(LocalDateTime.now())
                .build();

        Notice notice2 = Notice.builder()
                .title("📢 시스템 점검 안내")
                .content("2026년 7월 1일(월) 오전 2시~6시에 시스템 점검을 진행할 예정입니다. 점검 시간 중에는 서비스 이용이 불가능합니다. 양해 부탁드립니다.")
                .fixedFlag(true)
                .hit(189)
                .regDate(LocalDateTime.now().minusDays(2))
                .build();

        Notice notice3 = Notice.builder()
                .title("🏆 우수 강사 선정 결과")
                .content("지난 달 수강생 만족도 조사 결과를 바탕으로 우수 강사를 선정했습니다. 선정된 강사분들께 감사드립니다!")
                .fixedFlag(false)
                .hit(156)
                .regDate(LocalDateTime.now().minusDays(5))
                .build();

        Notice notice4 = Notice.builder()
                .title("💡 강의 추천 시스템 업데이트")
                .content("더 나은 학습 경험을 위해 강의 추천 시스템을 업데이트했습니다. 이제 더 정확한 강의 추천을 받을 수 있습니다.")
                .fixedFlag(false)
                .hit(98)
                .regDate(LocalDateTime.now().minusDays(7))
                .build();

        noticeRepository.saveAll(List.of(notice1, notice2, notice3, notice4));
        System.out.println("✓ 공지사항 데이터 생성 완료");

        // 4. 수강 정보 생성
        Enrollment enrollment1 = Enrollment.builder()
                .member(user1)
                .lecture(lecture1)
                .enrollDate(LocalDateTime.now().minusDays(10))
                .progress(45)
                .build();

        Enrollment enrollment2 = Enrollment.builder()
                .member(user1)
                .lecture(lecture2)
                .enrollDate(LocalDateTime.now().minusDays(5))
                .progress(20)
                .build();

        Enrollment enrollment3 = Enrollment.builder()
                .member(user2)
                .lecture(lecture1)
                .enrollDate(LocalDateTime.now().minusDays(3))
                .progress(10)
                .build();

        Enrollment enrollment4 = Enrollment.builder()
                .member(user2)
                .lecture(lecture4)
                .enrollDate(LocalDateTime.now().minusDays(15))
                .progress(100)
                .build();

        enrollmentRepository.saveAll(List.of(enrollment1, enrollment2, enrollment3, enrollment4));
        System.out.println("✓ 수강 정보 생성 완료");

        // 5. 리뷰 데이터 생성
        Review review1 = Review.builder()
                .lecture(lecture1)
                .member(user1)
                .userId(user1.getUserId())
                .rating(5)
                .comment("\uc815\ub9d0 \uc88b\uc740 \uac15\uc758\uc785\ub2c8\ub2e4! \uac15\uc0ac\ub2d8\uc758 \uc124\uba85\uc774 \uba85\ud655\ud558\uace0 \uc774\ud574\ud558\uae30 \uc26c\uc6cc\uc694. \uac15\ub825 \ucd94\ucc9c\ud569\ub2c8\ub2e4!")
                .regDate(LocalDateTime.now().minusDays(3))
                .build();

        Review review2 = Review.builder()
                .lecture(lecture1)
                .member(user2)
                .userId(user2.getUserId())
                .rating(4)
                .comment("\ub0b4\uc6a9\uc774 \uc54c\ucc28\uace0 \uc88b\uc2b5\ub2c8\ub2e4. \ub2e4\ub9cc \uc9c4\ub3c4\uac00 \uc870\uae08 \ube60\ub978 \uac83 \uac19\uc544\uc694.")
                .regDate(LocalDateTime.now().minusDays(5))
                .build();

        Review review3 = Review.builder()
                .lecture(lecture2)
                .member(user1)
                .userId(user1.getUserId())
                .rating(5)
                .comment("React\ub97c \uc644\ubcbd\ud558\uac8c \ubc30\uc6b8 \uc218 \uc788\ub294 \uac15\uc758\uc785\ub2c8\ub2e4. \ucd5c\uace0!")
                .regDate(LocalDateTime.now().minusDays(7))
                .build();

        Review review4 = Review.builder()
                .lecture(lecture4)
                .member(user2)
                .userId(user2.getUserId())
                .rating(5)
                .comment("\ubb34\ub8cc \uac15\uc758\uc778\ub370\ub3c4 \ub0b4\uc6a9\uc774 \uc815\ub9d0 \uc88b\uc2b5\ub2c8\ub2e4. \uac10\uc0ac\ud569\ub2c8\ub2e4!")
                .regDate(LocalDateTime.now().minusDays(10))
                .build();

        reviewRepository.saveAll(List.of(review1, review2, review3, review4));
        System.out.println("✓ 리뷰 데이터 생성 완료");

        // 6. 질문 데이터 생성
        Question question1 = Question.builder()
                .lecture(lecture1)
                .member(user1)
                .title("Spring Boot에서 데이터베이스 연결 방법")
                .questionText("Spring Boot에서 MySQL 데이터베이스를 연결하는 방법이 궁금합니다. 자세한 설명 부탁드립니다.")
                .createdAt(LocalDateTime.now().minusDays(2))
                .build();

        Question question2 = Question.builder()
                .lecture(lecture2)
                .member(user2)
                .title("React Hooks 사용법")
                .questionText("useState와 useEffect의 차이점이 뭔가요? 언제 어떤 것을 사용해야 하나요?")
                .createdAt(LocalDateTime.now().minusDays(4))
                .build();

        Question question3 = Question.builder()
                .lecture(lecture1)
                .member(user1)
                .title("JPA 쿼리 최적화")
                .questionText("JPA에서 N+1 문제를 해결하는 방법이 뭔가요?")
                .createdAt(LocalDateTime.now().minusDays(6))
                .build();

        questionRepository.saveAll(List.of(question1, question2, question3));
        System.out.println("✓ 질문 데이터 생성 완료");

        // 7. 답변 데이터 생성
        Answer answer1 = Answer.builder()
                .question(question1)
                .member(instructor)
                .answerText("application.properties 파일에 다음과 같이 설정하시면 됩니다:\nspring.datasource.url=jdbc:mysql://localhost:3306/yourdb\nspring.datasource.username=root\nspring.datasource.password=yourpassword")
                .createdAt(LocalDateTime.now().minusDays(1))
                .build();

        Answer answer2 = Answer.builder()
                .question(question2)
                .member(instructor)
                .answerText("useState는 상태를 관리하고, useEffect는 side effect를 처리합니다. useEffect는 컴포넌트가 렌더링된 후에 실행됩니다.")
                .createdAt(LocalDateTime.now().minusDays(3))
                .build();

        answerRepository.saveAll(List.of(answer1, answer2));
        System.out.println("✓ 답변 데이터 생성 완료");

        System.out.println("=== 샘플 데이터 초기화 완료 ===");
    }
}
