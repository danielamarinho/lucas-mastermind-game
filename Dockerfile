FROM openjdk:8-jre-alpine

MAINTAINER Lucas Dornelas <lmdornelas@gmail.com>

ADD ./target/lucas-mastermind-game-0.0.1-SNAPSHOT.jar /app.jar

CMD java $JAVA_OPTS -Dserver.address=0.0.0.0 -Dserver.port=$PORT -jar /app.jar

