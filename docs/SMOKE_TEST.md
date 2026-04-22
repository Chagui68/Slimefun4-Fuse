# Smoke Test

Smoke test rápido para validar que el workspace sigue sano sin compilar los `53` módulos de una sola vez.

## Script

- [scripts/slimefun/smoke-test.ps1](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/scripts/slimefun/smoke-test.ps1>)

## Objetivo

Este smoke test valida tres cosas:

- que `Maven` y el entorno estén bien resueltos
- que `dough-core` y `Slimefun 6 Core` sigan compilando
- que un set de addons representativos no se haya roto por cambios recientes

## Perfiles disponibles

### `quick`

Perfil recomendado para uso diario.

Valida:

- `sources/dough-core`
- `sources/slimefun-core/Slimefun4-src`
- `sources/repos-to-port/PrivateStorage`
- `sources/repos-to-port/ElectricSpawners`

### `core`

Perfil para revisar la base de framework y librerías.

Valida:

- `sources/dough-core`
- `sources/slimefun-core/Slimefun4-src`
- `sources/batch-2-expansion/SefiLib`
- `sources/batch-2-expansion/InfinityLib`
- `sources/batch-2-expansion/Networks_Better_Compatibility`
- `sources/batch-2-expansion/Cultivation_Updated`

### `extended`

Perfil más completo para checkpoints antes de pushs grandes.

Incluye:

- base (`dough-core`, core Slimefun)
- librerías de expansión
- batch-2 ya validados
- addons ya verificados como `PrivateStorage`, `ElectricSpawners`, `SFMobDrops` y `GlobalWarming`

## Uso

### Quick

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

### Core

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1 -Profile core
```

### Extended

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1 -Profile extended
```

### Offline

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1 -Profile quick -Offline
```

## Cuándo correrlo

- después de tocar `pom.xml` raíz
- después de tocar `dough-core`
- después de tocar `Slimefun4-src`
- antes de hacer push de cambios grandes
- después de integrar un addon nuevo al reactor

## Qué no hace

- no reemplaza tests unitarios ni pruebas in-game
- no compila todos los módulos pendientes
- no valida runtime dentro de Paper/Purpur

Es una red de seguridad rápida, no una certificación final.
