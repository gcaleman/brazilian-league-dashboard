from openjdk:11

RUN mkdir -p /home/app

COPY ./target/v1-0.0.1-SNAPSHOT.jar home/app/my-app.jar

WORKDIR home/app/

CMD ["java","-jar","my-app.jar"]


