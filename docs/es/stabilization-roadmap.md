# Roadmap de Estabilización

## Objetivo

Esta página traduce el inventario del `README.md` a una secuencia operativa. La meta no es solo "hacer que compile", sino cerrar el backlog real sin mezclar variantes viejas, sin inflar el reactor y sin dejar estados ambiguos.

## Estado Base

- Universo del workspace: `87 addons + 2 módulos base`
- Módulos activos en reactor: `59`
- Módulos listos en reactor: `57`
- Módulos activos con fallo confirmado: `2`
- Addons fuera del reactor: `30`
- Backlog operativo real: `32 addons`

## Orden Recomendado

### Fase 1: cerrar lo que ya está dentro del reactor

Esto tiene prioridad máxima porque cualquier fallo aquí afecta el build unificado.

1. `GeneticChickengineering-Reborn`
2. `PotionExpansion`

### Fase 2: incorporar quick wins fuera del reactor

Estos son los candidatos más razonables para seguir sumando cierres rápidos:

1. `MoreResearches`
2. `SfBetterChests`
3. `SlimeHUD`
4. `SmallSpace`
5. `Quaptics`

### Fase 3: candidatos intermedios

Requieren más revisión, pero siguen siendo mejores apuestas que los casos pesados o históricos.

1. `Geyser-Slimefun-Heads`
2. `Gastronomicon`
3. `RelicsOfCthonia`
4. `VillagerTrade`
5. `Wildernether`
6. `WorldEditSlimefun`
7. `CompressionCraft`
8. `EMCTech`
9. `SaneCrafting`
10. `SpiritsUnchained`
11. `Better-Nuclear-Generator`
12. `AdvancedTech`

### Fase 4: triage primero, port después

No conviene entrar aquí sin revisar antes estructura, build y dependencia externa.

- `Galactifun`
- `Bump`
- `CustomItemGenerators`
- `FastMachines`
- `SlimefunTranslation`
- `UltimateGenerators2`
- `Netheopoiesis`
- `SlimeFrame`
- `SlimefunAdvancements`

### Fase 5: variantes históricas o ambiguas

Estos casos no deben mezclarse con las variantes activas sin una decisión explícita.

- `Cultivation`
- `Networks`
- `EMC2`
- `SlimefunWarfare`

## Criterio de Trabajo por Addon

Antes de tocar código:

1. confirmar si el problema es de `pom.xml`/dependencias o de API/código
2. revisar si ya usa `dev.drake.dough.*`
3. validar si hereda del parent del reactor
4. compilar solo el módulo con `-pl` y `-am`

Comando base:

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

## Criterio de "Listo"

Un addon puede marcarse como listo para `1.21.11` cuando:

- compila dentro del reactor o en build aislado de forma consistente
- ya no depende de coordenadas viejas como `dev.drake:Slimefun:5.0-Drake-1.21.11`
- no deja errores activos de API conocidos
- su estado quedó reflejado en `README.md` y páginas de seguimiento

## Cierre Final del Proyecto

El proyecto no se considera cerrado solo con `BUILD SUCCESS`.

Al final del backlog debe hacerse:

1. smoke test con Paper/Purpur `1.21.11`
2. validación básica de runtime para addons sensibles
3. limpieza de logs temporales no versionados
4. revisión final del inventario del `README` y la wiki

## Enlaces Útiles

- [[Checklist de Migración]]
- [[Módulos Pendientes]]
- [[Guía de Smoke Test]]
- [[Tomorrow-Handoff]]
