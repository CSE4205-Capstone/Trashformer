# ================= STAGE 1: Build =================
# 자바 17 JDK가 포함된 이미지에서 빌드를 시작합니다. 'builder'라는 별명을 붙여줍니다.
FROM eclipse-temurin:17-jdk-jammy as builder

# 컨테이너 내의 작업 폴더를 /app으로 설정합니다.
WORKDIR /app

# Gradle 설정 파일을 먼저 복사합니다.
# 이렇게 하면 소스코드만 변경되었을 때, 매번 라이브러리를 새로 다운로드하지 않아 캐시를 효율적으로 사용할 수 있습니다.
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# gradle 실행 권한을 부여합니다.
RUN chmod +x ./gradlew

# 소스 코드를 복사합니다.
COPY src src

# Gradle 빌드 명령을 실행하여 실행 가능한 Jar 파일을 생성합니다.
# '--no-daemon' 옵션은 도커 빌드 환경에서 권장됩니다.
RUN ./gradlew build --no-daemon


# ================= STAGE 2: Run =================
# 더 가벼운 JRE(Java 실행 환경) 이미지를 기반으로 최종 이미지를 만듭니다.
FROM eclipse-temurin:17-jre-jammy

# 작업 폴더를 설정합니다.
WORKDIR /app

# 'builder' 스테이지에서 빌드된 결과물(Jar 파일)만 복사해옵니다.
# build/libs/ 폴더에 생성된 '-all.jar' 파일을 application.jar 라는 이름으로 복사합니다.
COPY --from=builder /app/build/libs/*-all.jar application.jar

# Ktor 서버의 기본 포트인 8080 포트를 외부에 노출합니다.
EXPOSE 8080

# 컨테이너가 시작될 때 실행할 명령어를 지정합니다.
ENTRYPOINT ["java", "-jar", "application.jar"]