# Log de Porteo: Slimefun 1.20.6 (Drake)

Este archivo detalla el estado exacto de cada addon de Slimefun en este repositorio.

## Estado Final (20/04/2026)

### ✅ Listos para Despliegue (Binarios en deploy/purpur-1.20.6/plugins-testing)
Estos addons han sido compilados exitosamente bajo Java 21, con Slimefun RC-37 y la API de Paper 1.20.6.

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
14. **SFCalc**
15. **SFMobDrops**
16. **SimpleUtils**
17. **SlimefunLuckyBlocks**
18. **SlimefunOreChunks**
19. **SlimyRepair**
20. **SlimyTreeTaps**
21. **SoulJars**
22. **SimpleMaterialGenerators (SMG)**

### ⚠️ Infraestructura y Core Reparados
- **SefiLib** (0.3.0) e **InfinityLib** (1.3.10) han sido consolidadas y parcheadas para 1.20.6.
- Actualización masiva de POMs y eliminación de repositorios muertos (Jeff-Media -> Maven Central).

### ❌ Requieren Refactorización Profunda (Pendientes para futuras sesiones)
Estos addons pasaron por la actualización automatizada masiva de la API, pero requieren la refactorización manual de métodos específicos y lógicas antiguas obsoletas que trascienden el regex.

- **SlimeChem**: Se tradujeron al castellano las máquinas principales (Disolvedor Químico, Ciclotrón, etc.) pero exige re-entrelazar las interfaces obsoletas de me.mrCookieSlime a los nuevos objetos atómicos de Slimefun 4.
- **Networks**, **Cultivation**, **LiteXpansion**, **EMC2**, **SlimeTinker**, **TranscEndence** y **Supreme**: Estos addons presentan choques de clases abstractas o falta de dependencias estructurales que requieren una migración a mano.

## Registro Técnico
- Se corrigieron masivamente dependencias obsoletas (dough, ProtocolLib, etc.).
- Las referencias de la API antigua (PotionData, ItemFlags, Material.SCUTE, etc.) han sido parcheadas. Todo lo restante es exclusivo de la lógica de negocio de cada addon.
