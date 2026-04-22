# Handoff para Mañana

Estado actual del branch:

- Rama: `1.21-latin`
- Reactor: `53` módulos activos
- Confirmados: `24`
- Pendientes: `29`

## Qué quedó listo hoy

- `PrivateStorage` compila en `1.21.11`
- `ElectricSpawners` compila en `1.21.11`
- `SFMobDrops` verificado con build aislado
- `GlobalWarming` verificado con build aislado
- plantilla base para nuevos addons en `templates/slimefun-addon`
- smoke test del repo en `scripts/slimefun/smoke-test.ps1`
- `README` principal actualizado con smoke test y plantilla
- `About` del repo GitHub configurado con descripción y topics

## Prioridades reales para mañana

### 1. Pendientes de infraestructura Maven

- `SimpleUtils`
  - problema detectado: sigue buscando `dev.drake:Slimefun` fuera del reactor
  - objetivo: alinearlo al parent/reactor como se hizo con `PrivateStorage` y `ElectricSpawners`

- `SlimyRepair`
  - problema detectado: misma clase de fallo que `SimpleUtils`
  - objetivo: heredar parent, limpiar dependencia a `Slimefun`, validar build con `-pl`

- `DynaTech`
  - problema detectado: dependencia externa a `io.github.thebusybiscuit:ExoticGarden:UNOFFICIAL`
  - objetivo: reemplazar esa dependencia por integración reactor/local o volverla opcional

### 2. Pendientes de port real

- `SoundMuffler`
  - problema detectado: usa mezcla de APIs legacy de Slimefun/CSCoreLib
  - no quedó tocado finalmente
  - objetivo: migrarlo bien a APIs actuales o decidir si se posterga

- `SlimeChem`
  - sigue siendo uno de los candidatos fuertes del siguiente batch

### 3. Pruebas de runtime

- correr Paper/Purpur 1.21.11 con el core y una selección de addons ya confirmados
- validar:
  - apertura de `SlimefunGuide`
  - recetas
  - researches
  - items básicos
  - que no explote consola por Data Components/PDC

## Comandos útiles

### Smoke test rápido

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

### Build aislado de un módulo

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

### Smoke test extendido

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1 -Profile extended
```

## Regla de trabajo recomendada

- no compilar todo el reactor de una
- trabajar con `-pl`
- actualizar docs solo cuando el build del módulo esté realmente validado
- si un addon falla solo por `pom.xml`, arreglar eso primero antes de tocar código
