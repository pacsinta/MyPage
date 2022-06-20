FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN bash ./gradlew installDist

FROM openjdk:17
EXPOSE 8088:8088
COPY pwd /home/gradle/src/build/install/MyPage/bin/pwd
COPY keystore.jks /home/gradle/src/build/install/MyPage/bin/keystore.jks
CMD bash /home/gradle/src/build/install/MyPage/bin/MyPage