# noti-mcp - Model Context Protocol Server

## 📋 프로젝트 개요

noti-mcp는 Spring Boot 4.0.6와 Java 21 기반으로 구현된 Model Context Protocol(MCP) 서버입니다. 이 서버는 외부 통지 API와 연동하여 알림 전송 기능을 제공합니다.

### 🔧 주요 기능
- **MCP 서버** (Model Context Protocol): RESTful API 엔드포인트 제공
- **통지 API 연동**: 외부 통지 시스템과의 통신 기능
- **보안 인증**: JWT 토큰 및 API 키 기반 인증 시스템
- **Docker 배포**: 도커 기반 손쉬운 배포 환경

## 🏗️ 프로젝트 구조

```
noti-mcp/
├── .env.example              # 환경 변수 예시 파일
├── .env                     # 실제 환경 변수 파일 (비공개)
├── .gitignore               # Git 무시 파일 목록
├── docker-compose.yml        # Docker Compose 설정
├── Dockerfile.temurin       # Eclipse Temurin 기반 도커 파일
├── src/                     # 소스 코드
│   └── main/java/com/example/notimcp/
│       ├── NotiMcpApplication.java  # 메인 애플리케이션
│       ├── config/            # 설정 클래스들
│       ├── controller/        # HTTP 컨트롤러
│       ├── service/           # 비즈니스 로직
│       ├── client/              # API 클라이언트
│       ├── model/             # 데이터 모델
│       └── security/        # 보안 모듈
├── docs/                    # 문서화
│   ├── mcp-server-implementation.md
│   ├── security-configuration.md
│   └── system-testing-plan.md
├── pom.xml                  # Maven 빌드 설정
└── target/                  # 빌드 결과 (gitignore)
```

## ⚙️ 구성 요소

### 1. **MCP 서버 엔드포인트**
- `POST /mcp/notification` - 알림 전송
- `GET /mcp/notification/{id}` - 특정 알림 조회  
- `POST /mcp/health` - 서버 상태 확인

### 2. **보안 시스템**
- JWT 토큰 기반 인증
- API 키 기반 인가
- Spring Security 적용

### 3. **API 통신**
- HTTP GET/POST/PUT/DELETE 지원
- Bearer Token 인증 지원
- 외부 통지 API 연동

## 🛠️ 요구 사항

- **Java 21** 이상
- **Docker** 및 **Docker Compose** 
- **Maven** (빌드용)

## 🏗️ 빌드 방법

### 1. **로컬 빌드**
```bash
# 1. 프로젝트 클론
git clone https://github.com/0bliviat3/noti-mcp.git
cd noti-mcp

# 2. Maven 빌드
mvn clean package -DskipTests
```

### 2. **도커 빌드**
```bash
# 1. 도커 이미지 빌드
docker build -f Dockerfile.temurin -t noti-mcp .

# 2. 또는 도커 컴포즈로 빌드
docker-compose build
```

## 🚀 배포 방법

### 1. **Docker Compose로 배포**
```bash
# 1. .env 파일 생성 (실제 API 정보 입력)
cp .env.example .env
# 에디터로 .env 파일 수정

# 2. 도커 컴포즈로 실행
docker-compose up -d
```

### 2. **직접 실행**
```bash
# 1. JAR 파일 실행
java -jar target/noti-mcp-0.0.1-SNAPSHOT.jar

# 2. 환경 변수 설정 (선택)
export NOTI_API_URL="https://your-api.com"
export NOTI_API_TOKEN="your-token"
```

## 📊 사용 방법

### 1. **환경 변수 설정**
```bash
# .env 파일 내용 예시
NOTI_API_URL=https://your-real-api.com/api/v1/notification
NOTI_API_TOKEN=your-r...here
SERVER_PORT=8080
LOGGING_LEVEL=com.example.notimcp=INFO
```

### 2. **API 호출 예시**
```bash
# 상태 확인
curl -X GET http://localhost:8080/mcp/health

# 알림 전송
curl -X POST http://localhost:8080/mcp/notification \
  -H "Content-Type: application/json" \
  -d '{"message":"Test notification"}'
```

## 🔒 보안 설정

### 1. **환경 변수 관리**
- `.env.example`: 공개 가능한 예시 설정
- `.env`: 실제 민감 정보 (git에 포함되지 않음)
- `.gitignore`: 민감 정보 및 불필요 파일 제외

### 2. **보안 패턴**
- API 토큰은 `.env` 파일에서 관리
- JWT 시크릿 키는 환경 변수로 설정
- 모든 민감 정보는 git에서 제외됨

## 📦 의존성

### 1. **Spring Boot**
- Spring Boot 4.0.6
- Spring WebFlux
- Spring Security

### 2. **HTTP 클라이언트**
- Apache HttpClient 5.3.1

### 3. **보안**
- JWT (JSON Web Token)
- Spring Security

## 🧪 테스트

### 1. **단위 테스트**
```bash
mvn test
```

### 2. **통합 테스트**
```bash
# 도커 컴포즈로 테스트
docker-compose up -d
```

## 📋 개발 가이드

### 1. **로컬 개발 환경**
```bash
# 1. 프로젝트 클론
git clone https://github.com/0bliviat3/noti-mcp.git

# 2. IDE로 열기
# IntelliJ IDEA, VS Code 등

# 3. 로컬 실행
./mvnw spring-boot:run
```

### 2. **Docker 개발**
```bash
# 1. 도커 이미지 빌드
docker build -f Dockerfile.temurin -t noti-mcp-dev .

# 2. 개발 환경 실행
docker run -p 8080:8080 noti-mcp-dev
```

## 📞 연락처

- **GitHub**: [0bliviat3/noti-mcp](https://github.com/0bliviat3/noti-mcp)
- **문의**: 0bliviat3@gmail.com

## 📜 라이선스

MIT License - 자세한 내용은 LICENSE 파일 참조.