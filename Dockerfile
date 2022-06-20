FROM gradle:7-jdk17 AS builder
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN bash ./gradlew installDist

FROM openjdk:17
EXPOSE 8088:8088
COPY --from=builder /home/gradle/src/build/install/MyPage/bin/MyPage /app/MyPage
COPY pwd /app/pwd
COPY keystore.jks /app/keystore.jks
CMD bash /app/MyPage