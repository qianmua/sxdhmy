FROM java:8
EXPOSE 8002

VOLUME /tmp
ADD factory.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar" , "/app.jar"]
# ENTRYPOINT ["java","-jar" , "/app.jar" , "--spring.profiles.active=prod"]