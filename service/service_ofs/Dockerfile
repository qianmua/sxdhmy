FROM java:8
EXPOSE 8050

VOLUME /tmp
ADD ofs.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar" , "/app.jar"]