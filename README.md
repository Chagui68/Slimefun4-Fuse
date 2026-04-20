# Drakes Plugin Library

Base privada de trabajo para armar una libreria real de plugins para `Purpur 1.20.6`.

La idea de este repo no es solo portar `Slimefun`, sino tener un lugar unico donde:

- guardamos los `jars` confirmados que de verdad van al servidor
- mantenemos los repos y ports que siguen en construccion
- conservamos auditorias, notas de compatibilidad y decisiones de seguridad
- evitamos volver a buscar en decenas de paginas los mismos plugins cada vez que levantamos un server nuevo

## Mision

Llegar a un punto donde podamos:

1. entrar a una carpeta de despliegue
2. tomar los plugins exactos para `Purpur 1.20.6`
3. subirlos al servidor
4. empezar a configurar gameplay, menas, Slimefun, permisos, tab, scoreboards y menus

Sin repetir la fase caotica de "buscar links, comparar versiones y adivinar compatibilidades" cada vez.

## Estructura

- `deploy/purpur-1.20.6`
  Paquete operativo actual para servidor.
- `deploy/purpur-1.20.6/plugins-confirmed/server-base`
  Plugins base ya confirmados para la linea principal del server.
- `deploy/purpur-1.20.6/plugins-confirmed/slimefun-upstream-ready`
  Addons de Slimefun que ya sirven sin port local.
- `deploy/purpur-1.20.6/plugins-confirmed/slimefun-ported`
  Addons portados o parchados localmente para `1.20.6`.
- `deploy/purpur-1.20.6/server-core`
  Jar del servidor y piezas base del runtime.
- `sources/slimefun-core/Slimefun4-src`
  Codigo fuente del port principal de `Slimefun`.
- `sources/plugins-in-construction/slimefun-addons/repos-to-port`
  Repos oficiales o forks de addons en revision, fix o port.
- `builds/compiled-jars`
  Artefactos compilados desde fuente local.
- `catalog/slimefun/audit`
  Catalogos, auditorias y clasificacion de compatibilidad.
- `docs`
  Documentacion general, roadmap y decisiones.
- `scripts/slimefun`
  Scripts para compilar, auditar y descargar piezas del ecosistema Slimefun.
- `lab`
  Espacio de pruebas locales.

## Estado Actual

### Actualización Mañana (20/04/2026)
- **Hito de Porteo**: 21 addons de Slimefun han sido portados exitosamente a **Purpur 1.20.6** con Java 21 y Slimefun RC-37.
- **Addons Listos**: `ColoredEnderChests`, `DyedBackpacks`, `DynaTech`, `EcoPower`, `ElectricSpawners`, `ExoticGarden`, `ExtraGear`, `ExtraUtils`, `FluffyMachines`, `GlobalWarming`, `HotbarPets`, `InfinityExpansion`, `PrivateStorage`, `SFCalc`, `SFMobDrops`, `SimpleUtils`, `SlimefunLuckyBlocks`, `SlimefunOreChunks`, `SlimyRepair`, `SlimyTreeTaps`, `SoulJars`.
- **En Construcción (Batch 1)**: `SlimeChem` (refactorización de paquetes antiguos) y `SoundMuffler` (conflicto de ProtocolLib).
- **Expansión iniciada (Batch 2)**: Clonación y preparación de 11 repositorios adicionales de la Wiki (Networks, Galactifun, SlimeTinker, etc.).

---

- `Slimefun 1.20.6` ya esta portado y compilado.
- Hay una base funcional de plugins generales para empezar un server `Purpur 1.20.6`.

## Flujo Recomendado

1. Revisar [deploy/purpur-1.20.6/notes/CURRENT-STACK.md](deploy/purpur-1.20.6/notes/CURRENT-STACK.md)
2. Tomar los jars desde `deploy/purpur-1.20.6/plugins-confirmed`
3. Si falta algo, revisar `docs/ROADMAP.md`
4. Si un addon requiere port o fix, trabajar desde `sources/plugins-in-construction`
5. Copiar salidas nuevas a `builds/compiled-jars` y luego a `deploy`

## Scripts Utiles

- Compilar el port principal:
  `powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\build-drake-1.20.6.ps1`
- Auditar addons de Slimefun:
  `powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\auditar-y-descargar-addons-1.20.6.ps1`
- Descargar un addon por release:
  `powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\descargar-addon-github.ps1 -Nombre ExoticGarden`

## Nota

Este repo es una base viva de operacion. Algunas piezas estan listas para entrar al servidor y otras siguen en revision, hardening o port. La libreria todavia no esta completa y todavia faltan plugins generales fuera del ecosistema Slimefun, pero ahora ya existe una estructura para crecer sin volver al desorden.
