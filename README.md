# Drakes Slimefun Labs

Laboratorio de migracion para llevar el ecosistema de addons de Slimefun a `Paper 1.21.11`, `Java 21` y `Slimefun 6 / Drake Framework`.

Este repositorio no representa un plugin unico. Es un `mono-repo de trabajo` donde se centralizan:

- versiones compartidas
- dependencias comunes
- fixes repetidos de API/Paper
- adaptaciones de `dough-core`
- validacion por modulo antes de separar o publicar addons

## Acceso Rapido

Si entraste al repo buscando "que esta listo y que falta", arranca por aca:

- [Checklist de migracion](MIGRATION_CHECKLIST.md)
- [Guia tecnica 1.21.11](docs/MIGRATION_GUIDE_1_21_11.md)
- [Smoke test](docs/SMOKE_TEST.md)
- [Setup de desarrollo](docs/DEV_SETUP.md)
- [Arquitectura](ARCHITECTURE.md)
- [Ruta de cierre de pendientes](docs/PENDING_MODULES_ROADMAP.md)
- [Handoff de trabajo](docs/TOMORROW_HANDOFF.md)
- [Plantilla para addons nuevos](docs/NEW_ADDON_TEMPLATE.md)

## Primeros Comandos

Si acabas de entrar al repo y solo quieres lo basico, usa esto:

### Verificar herramientas

```powershell
java --version
mvn --version
gh --version
```

### Empaquetar un addon puntual

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

Ejemplos reales:

```powershell
mvn -pl sources/repos-to-port/SimpleUtils -am -DskipTests package
mvn -pl sources/repos-to-port/DynaTech -am -DskipTests package
mvn -pl sources/repos-to-port/SoundMuffler -am -DskipTests package
```

Que hace cada flag:

- `-pl`: elige el modulo a compilar
- `-am`: compila tambien dependencias necesarias dentro del reactor
- `-DskipTests`: salta tests para validacion rapida de build

### Correr el smoke test rapido

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

### Donde mirar el estado real

- si buscas que esta listo y que falta: [MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md)
- si buscas como se esta porteando: [docs/MIGRATION_GUIDE_1_21_11.md](docs/MIGRATION_GUIDE_1_21_11.md)
- si buscas comandos y entorno: [docs/DEV_SETUP.md](docs/DEV_SETUP.md)

## Estado Actual

Estado documentado del branch `1.21-latin`:

- `53` modulos activos en el reactor Maven raiz
- `25` componentes confirmados para `1.21.11`
- `28` modulos pendientes de validacion final, port o documentacion
- `dough-core`: `dev.drake.dough:dough-core:1.3.1-DRAKE`
- core activo: `sources/slimefun-core/Slimefun4-src`
- variantes activas adoptadas desde Chagui:
  - `Networks_Better_Compatibility`
  - `Cultivation_Updated`

El estado vivo y detallado se mantiene en [MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md).

## Que Es Este Repo

`drakes-slimefun-labs` existe para evitar rehacer el mismo trabajo addon por addon.

En vez de mantener decenas de ramas y POMs separados, este laboratorio permite:

- fijar una sola base para `Paper 1.21.11`
- unificar `Slimefun`, `dough-core` y librerias comunes
- compilar un addon concreto con `-pl`
- detectar rapido si un fallo es de `pom.xml`, dependencia o API
- documentar el progreso real del workspace

## Mapa Del Workspace

### Raiz del laboratorio

- [pom.xml](pom.xml): reactor Maven principal
- [MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md): tablero de estado real del port
- [ARCHITECTURE.md](ARCHITECTURE.md): decisiones y piezas principales del stack
- [docs/](docs): guias operativas y handoffs
- [scripts/slimefun/](scripts/slimefun): utilidades del flujo Slimefun
- [templates/slimefun-addon/](templates/slimefun-addon): base para addons nuevos

### Sources

- `sources/dough-core`: dough unificado del framework Drake
- `sources/slimefun-core/Slimefun4-src`: core de Slimefun 6 en esta migracion
- `sources/repos-to-port`: addons principales en cola de port o validacion
- `sources/batch-2-expansion`: librerias y addons del batch expansion
- `sources/community-addons`: archivo de addons comunitarios integrados al laboratorio

## Documentacion Recomendada Segun Lo Que Buscas

### Quiero ver el estado del proyecto

Ve a [MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md).

Ahi esta:

- que modulos estan `LISTO`
- cuantos faltan
- que fue validado de verdad
- que sigue pendiente

### Quiero entender como se esta migrando a 1.21.11

Ve a [docs/MIGRATION_GUIDE_1_21_11.md](docs/MIGRATION_GUIDE_1_21_11.md).

Incluye:

- renombres tipicos de API Bukkit/Paper
- decisiones tecnicas del port
- estrategia de compilacion
- foco actual del trabajo

### Quiero validar que el repo sigue sano

Ve a [docs/SMOKE_TEST.md](docs/SMOKE_TEST.md).

### Quiero seguir el trabajo del siguiente turno

Ve a [docs/TOMORROW_HANDOFF.md](docs/TOMORROW_HANDOFF.md).

### Quiero ver el plan hasta cerrar todos los pendientes

Ve a [docs/PENDING_MODULES_ROADMAP.md](docs/PENDING_MODULES_ROADMAP.md).

### Quiero crear un addon nuevo alineado al stack

Ve a [docs/NEW_ADDON_TEMPLATE.md](docs/NEW_ADDON_TEMPLATE.md) y usa [templates/slimefun-addon/](templates/slimefun-addon).

## Reglas De Trabajo Del Laboratorio

Estas son las reglas operativas que se estan usando para no romper el reactor:

- no compilar el reactor entero salvo necesidad real
- priorizar build aislado por modulo
- revisar primero si el fallo es de `pom.xml` o de API
- si un addon ya usa `dev.drake.dough.*` pero falla por imports, revisar primero parent y dependencias
- solo actualizar el estado documental cuando hubo validacion real

Comando recomendado:

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

Ejemplos comunes:

```powershell
mvn -pl sources/dough-core -am -DskipTests package
mvn -pl sources/slimefun-core/Slimefun4-src -am -DskipTests package
mvn -pl sources/repos-to-port/SimpleUtils -am -DskipTests package
```

## Smoke Test

El smoke test sirve para revisar rapidamente que la base no se rompio sin compilar los `53` modulos.

Script:

- [scripts/slimefun/smoke-test.ps1](scripts/slimefun/smoke-test.ps1)

Uso rapido:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

Mas detalle:

- [docs/SMOKE_TEST.md](docs/SMOKE_TEST.md)

## Flujo Recomendado Para Portear Un Addon

1. Revisar su `pom.xml`.
2. Determinar si hereda del parent correcto.
3. Verificar dependencias a `Slimefun`, `dough-core` y librerias internas.
4. Correr build aislado con `-pl`.
5. Si falla, separar si el problema es de POM/dependencias o de API/codigo.
6. Validar de nuevo con build aislado.
7. Recien ahi actualizar checklist y docs.

## Checkpoint Confirmado

Entre los componentes ya documentados como listos se incluyen:

- `Slimefun 6 Core`
- `dough-core`
- `SefiLib`
- `InfinityLib`
- `Networks_Better_Compatibility`
- `Cultivation_Updated`
- `LiteXpansion`
- `SlimeTinker`
- `SMG`
- `Supreme`
- `TranscEndence`
- `CrystamaeHistoria`
- `AlchimiaVitae`
- `DankTech2`
- `InfinityExpansion`
- `PrivateStorage`
- `ElectricSpawners`
- `SFMobDrops`
- `GlobalWarming`
- `SimpleUtils`
- `SoulJars`
- `ExtraGear`
- `ColoredEnderChests`
- `DyedBackpacks`
- `ExoticGarden`

La lista fuente de verdad sigue siendo [MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md).

## Roadmap Inmediato

El frente actual del laboratorio ya no es "levantar la base", sino seguir bajando la cola de pendientes con cambios pequenos y validacion real.

Ejemplos de pendientes inmediatos que vienen apareciendo en el trabajo reciente:

- `SlimyRepair`
- `DynaTech`
- `SoundMuffler`
- `SlimeChem`
- pruebas de runtime en `Paper/Purpur 1.21.11`

## Creditos

Reconocimiento a los autores y mantenedores originales del ecosistema:

- [TheBusyBiscuit](https://github.com/TheBusyBiscuit): creador original de Slimefun
- [Sefiraat](https://github.com/Sefiraat): Networks, AlchimiaVitae, CrystamaeHistoria y librerias de expansion
- [Mooy1](https://github.com/Mooy1): InfinityExpansion
- [Sfiguz7](https://github.com/Sfiguz7): DankTech2
- [Chagui68](https://github.com/Chagui68): aportes clave y variantes activas para compatibilidad
- [Pablo Elias](https://github.com/JackStar6677-1): Drake Framework y direccion de la migracion 1.21.11

## Licencia

Este laboratorio conserva la licencia declarada en [LICENSE](LICENSE). Cada addon puede mantener su propio historial, autoria y contexto de origen.
