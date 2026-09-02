FROM zenika/kotlin:1.9
WORKDIR /app
COPY . /app
RUN kotlinc Main.kt -include-runtime -d Main.jar
CMD ["java", "-jar", "Main.jar"]