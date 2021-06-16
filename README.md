# bitcoin project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## graalvm

* Fazer o download em: <https://www.graalvm.org/downloads/>
* Unzip the archive: `tar -xzf graalvm-ce-java<version>-linux-amd64-<version>.tar.gz`;
* Veja : <https://www.graalvm.org/docs/getting-started/linux/>
* Aponta a variável de ambiente:

```sh
export PATH=/home/usuario/JAVA/graalvm-ce-java11-21.1.0/bin:$PATH
export JAVA_HOME=/home/usuario/JAVA/graalvm-ce-java11-21.1.0
```

* No eclipse abrir java Build Path, editar o JRE para o graalvm;
* Instalando componete native-image: `./gu install native-image`

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Criação de um executável nativo

Você pode criar um executável nativo usando:
```shell script
./mvnw package -Pnative
```

Ou, se você não tiver o GraalVM instalado, pode executar a compilação do executável nativo em um contêiner usando:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

* obs:
Caso ocorra erro na criação da imagem nativa no linux, instalar <https://quarkus.io/guides/building-native-image>:

```sh
sudo apt-get -y install gcc libc6-dev zlib1g-dev
```

Você pode então executar seu executável nativo com: `. / Target / bitcoin-1.0.0-SNAPSHOT-runner`

Se você quiser saber mais sobre como construir executáveis nativos, consulte <https://quarkus.io/guides/maven-tooling.html>.
