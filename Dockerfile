FROM java:8-jre
MAINTAINER Lucas Dornelas <lmdornelas@gmail.com>

ADD  . /app
CMD ROCKET_ADDRESS=0.0.0.0 ROCKET_PORT=$PORT /app/target/lucas-mastermind-game

ENV PORT 8888

