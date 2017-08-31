FROM anapsix/alpine-java

VOLUME /tmp

ADD build/libs/discovery.jar /app.jar
EXPOSE 8761

ENTRYPOINT ["java","-Xmx256m","-jar","/app.jar"]