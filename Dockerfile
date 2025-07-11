FROM eclipse-temurin:21-jre-alpine

RUN addgroup --system spring && adduser --system spring --ingroup spring

COPY projetJEE-web/target/projetJEE-web-2024.q4.jar app.jar

RUN chown spring:spring app.jar

USER spring

EXPOSE 8080

ENV JAVA_OPTS="-Xmx512m -Xms256m -server"

ENTRYPOINT ["sh", "-c", "sleep 10 && java $JAVA_OPTS -jar /app.jar"]