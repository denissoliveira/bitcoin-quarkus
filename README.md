![GitHub package version](https://img.shields.io/github/package-json/v/denissoliveira/bitcoin-quarkus.svg)
[![GitHub pull requests](https://img.shields.io/github/issues-pr-raw/denissoliveira/bitcoin-quarkus.svg)](https://github.com/denissoliveira/bitcoin-quarkus/pulls)
[![GitHub issues](https://img.shields.io/github/issues/danielso2007/bitcoin-quarkus.svg)](https://github.com/denissoliveira/bitcoin-quarkus/issues?q=is%3Aopen+is%3Aissue)
![GitHub last commit](https://img.shields.io/github/last-commit/denissoliveira/bitcoin-quarkus.svg)
[![GitHub issue/pull request author](https://img.shields.io/github/issues/detail/u/denissoliveira/bitcoin-quarkus/1.svg)](https://github.com/denissoliveira/bitcoin-quarkus/pulls)
![GitHub contributors](https://img.shields.io/github/contributors/denissoliveira/bitcoin-quarkus.svg)
![GitHub top language](https://img.shields.io/github/languages/top/denissoliveira/bitcoin-quarkus.svg)
[![GitHub](https://img.shields.io/github/license/denissoliveira/bitcoin-quarkus.svg)](https://github.com/denissoliveira/bitcoin-quarkus)
[![GitHub All Releases](https://img.shields.io/github/downloads/danielso2007/bitcoin-quarkus/total.svg)](https://github.com/denissoliveira/bitcoin-quarkus/archive/master.zip)
[![Conventional Commits](https://img.shields.io/badge/Conventional%20Commits-1.0.0-yellow.svg)](https://conventionalcommits.org)

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

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

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

## Banco de dados

* Usando este projeto (<https://github.com/danielso2007/mariadb_using_docker>) pra criar o container MariaDB;
* Ao acessar o phpmyadmin, servidor = mariaDB com usuário e senha = root;

## Conventional Commits

[Conventional Commits](https://www.conventionalcommits.org/)

## ChangeLogs

[standard-version](https://www.npmjs.com/package/standard-version)

* Test `npm run release -- --dry-run`
* `npm run release -- --release-as 0.0.1-SNAPSHOT --dry-run`

## Versionamento

[semver](https://semver.org/)
