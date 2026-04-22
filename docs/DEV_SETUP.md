# Dev Setup

Setup recomendado para trabajar y seguir porteando `drakes-slimefun-labs` en Windows.

## Requisitos base

- `Java 21 (JDK)` obligatorio
- `Maven 3.9+` obligatorio
- `Git` obligatorio
- `GitHub CLI (gh)` recomendado
- `Gradle 8+` opcional

## Versiones objetivo del repo

- `Minecraft`: `1.21.11`
- `Java`: `21`
- `Build principal`: `Maven`

El monorepo usa `Maven` como sistema principal de build. Algunos addons o utilidades incluidos conservan `gradlew` propio, así que `Gradle` global es útil, pero no bloqueante.

## Instalacion recomendada en Windows

### 1. Java 21

Instala un JDK 21 real, no solo un runtime. El repo no debe compilar con Java 25 como default del sistema.

Variables recomendadas:

```powershell
$env:JAVA_HOME='C:\Program Files\Eclipse Adoptium\jdk-21.x.x-hotspot'
$env:Path=\"$env:JAVA_HOME\bin;$env:Path\"
```

### 2. Maven

Instala Maven `3.9+` y agrega su carpeta `bin` al `Path`.

Ejemplo:

```powershell
$env:Path='C:\Users\pablo\Tools\apache-maven-3.9.9\bin;' + $env:Path
```

### 3. Gradle

Opcional a nivel global. Si un subproyecto ya trae `gradlew.bat`, puedes usar ese wrapper sin instalar Gradle aparte.

Ejemplo:

```powershell
$env:Path='C:\Users\pablo\Tools\gradle-8.14.3\bin;' + $env:Path
```

## Verificacion rapida

```powershell
java --version
javac --version
mvn --version
gradle --version
gh --version
```

Debes ver:

- `Java 21`
- `Maven 3.9+`
- `Gradle 8+` si instalaste Gradle global

## Flujo recomendado

### Validar herramientas

```powershell
java --version
mvn --version
```

### Correr smoke test rápido

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

Guía completa:

- [SMOKE_TEST.md](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/docs/SMOKE_TEST.md>)

### Compilar un modulo concreto

```powershell
mvn -pl sources/slimefun-core/Slimefun4-src -am -DskipTests package
```

### Compilar `dough-core`

```powershell
mvn -pl sources/dough-core -am -DskipTests package
```

### Usar wrappers Gradle cuando existan

```powershell
.\gradlew.bat build
```

## Notas para porting

- Prioriza `Paper API` directa cuando reduzca compatibilidad rota o deuda heredada.
- Mantén todo el repo alineado a `1.21.11`.
- No asumas que un addon usa Maven solo porque está dentro del monorepo.
- Si una consola nueva sigue viendo Java incorrecto, cierra y abre terminal para recargar `JAVA_HOME` y `Path`.
- Antes de pushes grandes, corre el smoke test del repo.
