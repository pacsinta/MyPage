FROM gradle:7-jdk18 AS builder
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:18
EXPOSE 8088:8088
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/MyPage.jar
COPY pwd /app/pwd
COPY keystore.jks /app/keystore.jks
ENTRYPOINT ["java","-jar","/app/MyPage.jar"]
