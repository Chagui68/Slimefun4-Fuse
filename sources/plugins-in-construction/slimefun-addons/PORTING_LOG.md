# Log de Porteo: Slimefun 1.20.6 (Drake)

Este archivo detalla el estado exacto de cada addon de Slimefun en este repositorio, los éxitos, los fallos y lo que sigue en la fase de construcción.

## Estado al 20/04/2026 (Mañana)

### ✅ Listos para Despliegue (Binarios en `deploy/purpur-1.20.6/plugins-testing`)
Estos addons han sido compilados bajo Java 21, con Slimefun RC-37 y la API de Paper 1.20.6.

1.  **ColoredEnderChests**
2.  **DyedBackpacks**
3.  **DynaTech**
4.  **EcoPower**
5.  **ElectricSpawners**
6.  **ExoticGarden**
7.  **ExtraGear**
8.  **ExtraUtils**
9.  **FluffyMachines**
10. **GlobalWarming**
11. **HotbarPets**
12. **InfinityExpansion** (Incluye fix para dupe #126)
13. **PrivateStorage**
14. **SFCalc** (Parchado para Gradle/Lombok)
15. **SFMobDrops**
16. **SimpleUtils**
17. **SlimefunLuckyBlocks** (Parchado para Materiales/Partículas 1.20.6)
18. **SlimefunOreChunks**
19. **SlimyRepair**
20. **SlimyTreeTaps**
21. **SoulJars**

### ⚠️ En Reparación (Batch 1)
- **SlimeChem**: Fallos masivos de compilación por referencias a paquetes internos de Slimefun antiguo (`me.mrCookieSlime`). Requiere refactorización profunda.
- **SoundMuffler**: Error de resolución de dependencia `ProtocolLib`. Conflictos de autenticación con el repositorio de dmulloy2.

### 🚀 Siguiente Fase: Expansión (Batch 2)
Se han clonado los siguientes repositorios de la Wiki para iniciar su porteo:
- **Networks** (Sefiraat)
- **Galactifun** (Addon Community)
- **SlimeTinker** (Sefiraat)
- **Cultivation** (Sefiraat)
- **SMG** (Sefiraat)
- **EMC2** (Sefiraat)
- **LiteXpansion**
- **Supreme**
- **TranscEndence**
- **Librerías Core**: `SefiLib` e `InfinityLib` (estamos actualizando su infraestructura de Maven a Shade 3.6.0 para soporte de Java 21).

## Notas Técnicas para el Usuario
- **ojito con el .gitignore**: El repo ahora rastrea los cambios en `sources/` y los `jars` confirmados en `deploy/`. Se ignoran las carpetas `target/` y archivos de cache de IDE.
- **Java 21**: Todos los puertos requieren JDK 21 para compilar y correr en Purpur 1.20.6.
