FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y wget unzip && \
    wget https://github.com/JetBrains/kotlin/releases/download/v1.9.23/kotlin-compiler-1.9.23.zip && \
    unzip kotlin-compiler-1.9.23.zip -d /opt && \
    rm kotlin-compiler-1.9.23.zip

ENV PATH="/opt/kotlinc/bin:${PATH}"

WORKDIR /app
COPY . /app

RUN wget https://repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.8.1/kotlinx-coroutines-core-jvm-1.8.1.jar

RUN kotlinc ./src/kotlin/thread-1.kt \
    -classpath kotlinx-coroutines-core-jvm-1.8.1.jar \
    -include-runtime \
    -d Main.jar

CMD ["java", "-cp", "Main.jar:kotlinx-coroutines-core-jvm-1.8.1.jar", "Thread_1Kt"]