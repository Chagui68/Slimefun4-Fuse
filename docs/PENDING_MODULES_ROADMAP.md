# Ruta De Cierre De Modulos Pendientes

Hoja de ruta operativa para bajar la cola de modulos pendientes del branch `1.21-latin` hasta dejar el reactor completamente validado para `Paper 1.21.11`, `Java 21` y `Slimefun 6 / Drake Framework`.

## Estado Base

Checkpoint actual del reactor:

- `53` modulos activos
- `26` componentes confirmados
- `27` modulos pendientes

Fuente de verdad del estado:

- [MIGRATION_CHECKLIST.md](../MIGRATION_CHECKLIST.md)
- [docs/MIGRATION_GUIDE_1_21_11.md](MIGRATION_GUIDE_1_21_11.md)
- [docs/TOMORROW_HANDOFF.md](TOMORROW_HANDOFF.md)

## Objetivo Final

Cerrar los `27` modulos restantes con evidencia real, no con estimaciones.

Cada modulo debe terminar en uno de estos estados:

- `LISTO`: compila con build aislado y queda documentado
- `BLOQUEADO DOCUMENTADO`: no compila, pero queda explicado con precision tecnica y siguiente paso concreto
- `POSTERGADO CON JUSTIFICACION`: se decide conscientemente dejarlo fuera del batch actual

## Regla Operativa

Para cada addon pendiente:

1. Revisar primero `pom.xml`.
2. Determinar si el fallo es de parent/dependencias o de API/codigo.
3. Compilar solo el modulo con:

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

4. Si falla por POM, arreglar eso antes de tocar Java.
5. Si falla por API, hacer el fix minimo necesario y volver a validar.
6. Actualizar `README.md`, `MIGRATION_CHECKLIST.md` y `docs/MIGRATION_GUIDE_1_21_11.md` solo cuando el resultado sea real.
7. Hacer push cuando el avance quede satisfactorio y validado.

## Definicion De Terminado

Un modulo cuenta como cerrado para este roadmap cuando:

- hereda correctamente del parent o tiene dependencias coherentes con el reactor
- no depende de versiones viejas de `dev.drake:Slimefun`
- no queda colgado de repositorios muertos o artefactos externos innecesarios
- pasa build aislado con `-pl`
- su estado queda reflejado en la documentacion

## Lista Completa De Pendientes

### Repos To Port

- `DynaTech`
- `EcoPower`
- `ExtraUtils`
- `FluffyMachines`
- `HardcoreSlimefun`
- `HotbarPets`
- `luckyblocks-sf`
- `SFCalc`
- `SlimeChem`
- `SlimefunOreChunks`
- `SlimyTreeTaps`
- `SoundMuffler`

### Community Addons

- `Element-Manipulation`
- `ExtraTools`
- `FlowerPower`
- `FN-FAL-s-Amplifications`
- `FoxyMachines`
- `GeneticChickengineering-Reborn`
- `Liquid`
- `Magic-8-Ball`
- `MissileWarfare`
- `PotionExpansion`
- `RykenSlimeCustomizer-EN`
- `SfChunkInfo`
- `Simple-Storage`
- `SlimeCustomizer`
- `VillagerUtil`

## Orden Recomendado De Ataque

La idea no es ir alfabeticamente. La idea es bajar primero lo mas barato de validar.

## Fase 1: Quick Wins De Infraestructura Maven

Meta: convertir varios pendientes en `LISTO` con cambios chicos de `pom.xml`, parent, versiones o dependencias del reactor.

Orden sugerido:

1. `SFCalc`
2. `Magic-8-Ball`
3. `SfChunkInfo`
4. `Element-Manipulation`
5. `VillagerUtil`

Por que entran aca:

- ya se ven relativamente alineados al parent
- ya usan `dev.drake:Slimefun` y `dough-core`
- no muestran de entrada dependencias externas especialmente toxicas
- es probable que fallen por detalles chicos o incluso ya compilen

Resultado esperado de la fase:

- bajar rapidamente el numero de pendientes
- descubrir patrones repetidos
- reutilizar fixes cortos como paso con `SimpleUtils` y `SlimyRepair`

## Fase 2: Dependencias Y Alineacion Media

Meta: limpiar addons que probablemente no esten muy lejos, pero que pueden traer dependencia vieja, version hardcodeada o integraciones legacy moderadas.

Orden sugerido:

1. `DynaTech`
2. `SlimeChem`
3. `Simple-Storage`
4. `SlimeCustomizer`
5. `EcoPower`
6. `SlimefunOreChunks`
7. `luckyblocks-sf`
8. `SlimyTreeTaps`

Riesgos tipicos de esta fase:

- `5.0-Drake-1.21.11` hardcodeado en algun `pom.xml`
- dependencias a `Slimefun4`
- dependencia externa a `ExoticGarden:UNOFFICIAL` o similares
- integraciones que se pueden volver opcionales

Notas destacadas:

- `DynaTech` ya esta marcado como candidato claro porque todavia depende de `ExoticGarden:UNOFFICIAL`
- `SlimeChem` viene apareciendo como siguiente batch fuerte

## Fase 3: Port De Codigo De Riesgo Medio

Meta: resolver addons donde el problema ya probablemente no es solo Maven, sino mezcla de API vieja, cambios Paper 1.21 o clases heredadas.

Orden sugerido:

1. `ExtraUtils`
2. `FluffyMachines`
3. `HardcoreSlimefun`
4. `HotbarPets`
5. `FlowerPower`
6. `RykenSlimeCustomizer-EN`

Que esperar:

- renombres de API Bukkit/Paper
- imports viejos de Slimefun
- ajustes menores de `Material`, `Enchantment`, `Particle`, `PotionEffectType`
- reemplazo de reflection innecesaria

## Fase 4: Port De Riesgo Alto O Legacy

Meta: dejar para el final lo que tiene mas chances de consumir tiempo, traer deuda historica o requerir decisiones de alcance.

Orden sugerido:

1. `SoundMuffler`
2. `ExtraTools`
3. `FoxyMachines`
4. `GeneticChickengineering-Reborn`
5. `Liquid`
6. `MissileWarfare`
7. `PotionExpansion`
8. `FN-FAL-s-Amplifications`

Motivo de dejar estos mas tarde:

- mezcla de APIs legacy
- mas probabilidad de codigo roto que de POM roto
- mayor chance de dependencias cruzadas o comportamiento runtime delicado
- algunos pueden requerir decision de "portear completo ahora" versus "postergar con criterio"

Nota especial:

- `SoundMuffler` ya esta identificado como addon con mezcla de APIs legacy de Slimefun y CSCoreLib

## Fase 5: Runtime Y Cierre Del Batch

Una vez cerrada la mayor parte del backlog de compilacion:

1. correr smoke test extendido
2. levantar Paper o Purpur `1.21.11`
3. validar `SlimefunGuide`
4. validar recipes y researches
5. revisar consola por problemas de `PDC` o `Data Components`
6. confirmar que los addons mas tocados cargan sin errores

Comandos utiles:

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1 -Profile extended
```

## Ruta Practica Turno A Turno

Para no dispersarse, cada turno deberia intentar cerrar entre `1` y `3` modulos maximo.

Plantilla de trabajo por turno:

1. elegir un modulo de la fase activa
2. revisar `pom.xml`
3. correr build aislado
4. corregir solo lo minimo necesario
5. volver a correr build aislado
6. actualizar docs si quedo realmente listo
7. push del avance validado

## Siguiente Secuencia Recomendada

Si hubiera que seguir hoy mismo, el orden recomendado seria:

1. `SFCalc`
2. `Magic-8-Ball`
3. `SfChunkInfo`
4. `Element-Manipulation`
5. `VillagerUtil`
6. `DynaTech`
7. `SlimeChem`

## Criterio Para Reordenar

Este roadmap no es rigido. Se puede reordenar si aparece una de estas situaciones:

- un modulo compila casi gratis y conviene aprovechar el momentum
- un addon bloquea a otro por dependencia del reactor
- aparece una dependencia externa caida y conviene patear ese modulo
- una prueba de runtime descubre que algun addon "confirmado" necesita volver a revisión

## Resultado Esperado

Si se respeta este orden:

- primero caen los quick wins
- luego se limpia la capa de dependencias medianas
- despues se entra al port real de codigo
- al final se reserva el tiempo caro para runtime y legacy dificil

Eso deberia evitar mezclar en una misma sesion:

- refactors grandes
- arreglos de POM chicos
- pruebas runtime
- actualizacion documental desordenada
