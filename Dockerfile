FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:17
EXPOSE 8088:8088
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/MyPage.jar
COPY --from=build /home/gradle/src/pwd /app/pwd
COPY --from=build /home/gradle/src/keystore.jks /app/keystore.jks
ENTRYPOINT ["java","-jar","/app/MyPage.jar"]