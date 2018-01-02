FROM openjdk:8-jre-alpine

MAINTAINER Lucas Dornelas <lmdornelas@gmail.com>

ADD ./target/lucas-mastermind-game-0.0.1-SNAPSHOT.jar /app.jar

ENV SPRING_PROFILES_ACTIVE=local

CMD JDBC_DATABASE_URL="jdbc:$JDBC_DATABASE_URL" java $JAVA_OPTS \
-Dserver.address=0.0.0.0 \
-Dserver.port=$PORT \
-Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
-jar /app.jar
