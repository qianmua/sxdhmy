FROM java:8
EXPOSE 9527

VOLUME /tmp
ADD gateway.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar" , "/app.jar"]