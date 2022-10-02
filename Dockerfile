FROM openjdk:19
RUN microdnf install findutils
EXPOSE 8088
EXPOSE 8087
COPY pwd /app/pwd
COPY keystore.jks /app/keystore.jks
COPY kmongoConfig /app/kmongoConfig
COPY jwtConfig /app/jwtConfig
COPY build/ /app/build/
COPY src/main/resources/ /app/resources
CMD cd /app && bash build/install/MyPage/bin/MyPage localhost=0 https=1 database_name=MyPage
