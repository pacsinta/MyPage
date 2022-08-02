FROM gradle:7-jdk18 AS builder
COPY src /home/gradle/src/src
COPY build.gradle.kts /home/gradle/src/build.gradle.kts
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:18
EXPOSE 8088
EXPOSE 8087
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/MyPage.jar
COPY pwd /app/pwd
COPY keystore.jks /app/keystore.jks
COPY kmongoConfig /app/kmongoConfig
CMD cd /app && java -jar MyPage.jar localhost=0 https=1 database_name=MyPage
