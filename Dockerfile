FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 8088:8088
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/MyPage.jar
ENTRYPOINT ["java","-jar","/app/MyPage.jar"]