<div align="center">

![Drakes Slimefun Labs Banner](docs/img/banner.png)

# 🔬 Drakes Slimefun Labs
### *The Next Evolution of Slimefun Addons for Minecraft 1.21.11*

[![Java Version](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://adoptium.net/)
[![Paper Version](https://img.shields.io/badge/Paper-1.21.11-blue?style=for-the-badge&logo=minecraft)](https://papermc.io/)
[![Slimefun Version](https://img.shields.io/badge/Slimefun-6.0--Drake-green?style=for-the-badge)](https://github.com/Slimefun/Slimefun4)
[![License](https://img.shields.io/badge/License-GPL%20v3-red?style=for-the-badge)](LICENSE)

---

**Drakes Slimefun Labs** es el centro neurálgico de la migración masiva del ecosistema Slimefun. 
Aquí centralizamos el desarrollo de más de 35 addons, unificando dependencias y aplicando el **Drake Framework** para garantizar una estabilidad absoluta en la versión **1.21.11**.

[Wiki Oficial](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki) • [Arquitectura](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki/Arquitectura-del-Ecosistema) • [Guía de Migración](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki/Referencia-Técnica-(Paper-1.21.1))

</div>

## 📊 Estado del Proyecto
> [!IMPORTANT]
> **Versión Actual**: `1.21.11` | **Estado**: 🧪 En Fase de Pruebas (Beta) | **Framework**: Drake 1.0

Actualmente, el laboratorio trabaja sobre un universo de **87 addons** más `dough-core` y `Slimefun4-src`.
De ese total, el **reactor activo** cubre **59 módulos** (`57 addons + 2 módulos base`).

**Progreso de Migración:**
`[=============================>----] 89%`

| Métrica | Valor |
| :--- | :--- |
| 🚀 **Módulos Listos en Reactor** | `57` |
| ⛔ **Módulos Activos con Fallo Confirmado** | `2` |
| 🧩 **Addons Fuera del Reactor** | `30` |
| 📚 **Pendiente Bruto del Repo** | `32 addons` |
| 📦 **Librería Core** | `dough-core:1.3.1-DRAKE` |

**Cómo leer este tablero**
- `57 listos` significa módulos que hoy compilan para `1.21.11` dentro del stack Drake.
- `2 activos con fallo` significa módulos ya integrados al `pom.xml` raíz, pero todavía no cerrados.
- `30 fuera del reactor` significa addons presentes en el repo que aún no están incorporados al build unificado.
- El backlog operativo real hoy es `32 addons`, no `2`.

**Últimos cierres validados**
- `DyeBench`: integrado al reactor y alineado a dependencias Drake.
- `MapJammers`: integrado al reactor con `DynmapCoreAPI` resuelto y imports `dev.drake.dough.*`.
- `HeadLimiter`: integrado al reactor y limpiado de dependencia muerta a `ExtraUtils`.
- `MiniBlocks`: integrado al reactor, alineado con `InfinityLib` local y `Java 21`.
- `FoxyMachines`: eliminados usos de utilidades legacy de `commons-lang`.
- `FlowerPower`: ajustado al API moderno de atributos de Bukkit/Paper.
- `MissileWarfare`: vuelve a compilar en el reactor actual.
- `Element-Manipulation`: alineado a `dev.drake.dough.*`, serializers Adventure actuales e `InfinityLib` moderno.

## 📦 Inventario Explícito 1.21.11
Esta sección es la fuente de verdad humana del repo. Si un conteo viejo contradice esta lista, manda esta lista.

### ✅ Base/Core listo para 1.21.11

| Componente | Estado | Observación |
| :--- | :--- | :--- |
| `sources/dough-core` | `Listo` | `dev.drake.dough:dough-core:1.3.1-DRAKE` unificado para el stack actual. |
| `sources/slimefun-core/Slimefun4-src` | `Listo` | Core estabilizado con puentes de compatibilidad para addons legacy. |

### ✅ Batch 1 `sources/repos-to-port` listo para 1.21.11
Los `26/26` módulos de esta carpeta están considerados listos en esta rama.

| Addon | Estado | Observación |
| :--- | :--- | :--- |
| `ColoredEnderChests` | `Listo` | Sin observación especial actual. |
| `DyedBackpacks` | `Listo` | Sin observación especial actual. |
| `DynaTech` | `Listo` | Se alineó el `pom.xml` al reactor Drake y dependencias actuales. |
| `EcoPower` | `Listo` | Se corrigió herencia del parent y dependencia a `dough-core`. |
| `ElectricSpawners` | `Listo` | Sin observación especial actual. |
| `ExoticGarden` | `Listo` | Ya trabajado para este stack; revisar runtime si se usan integraciones externas no incluidas. |
| `ExtraGear` | `Listo` | Sin observación especial actual. |
| `ExtraHeads` | `Listo` | Convertido/integrado al reactor Maven unificado. |
| `ExtraUtils` | `Listo` | Referencia útil para dependencias comunitarias que antes apuntaban a JitPack. |
| `FluffyMachines` | `Listo` | Sin observación especial actual. |
| `GlobalWarming` | `Listo` | Sin observación especial actual. |
| `HardcoreSlimefun` | `Listo` | Sin observación especial actual. |
| `HotbarPets` | `Listo` | Se corrigieron errores de API en el port a 1.21.11. |
| `InfinityExpansion` | `Listo` | Depende del `InfinityLib` local del reactor. |
| `luckyblocks-sf` | `Listo` | Sin observación especial actual. |
| `MobCapturer` | `Listo` | Convertido/integrado al reactor Maven unificado. |
| `PrivateStorage` | `Listo` | Se corrigieron errores de API durante la migración. |
| `SFCalc` | `Listo` | Validado como quick win. |
| `SFMobDrops` | `Listo` | Sin observación especial actual. |
| `SimpleUtils` | `Listo` | Su cierre dependió de alinear `InfinityLib` al reactor actual. |
| `SlimeChem` | `Listo` | Se corrigieron errores de API en el port. |
| `SlimefunOreChunks` | `Listo` | Sin observación especial actual. |
| `SlimyRepair` | `Listo` | Validado como quick win. |
| `SlimyTreeTaps` | `Listo` | Compila en esta rama; revisar runtime si se toca protección externa. |
| `SoulJars` | `Listo` | Sin observación especial actual. |
| `SoundMuffler` | `Listo` | Se corrigieron errores de API legacy. Recomendable smoke test porque toca eventos/sonidos. |

### ✅ Batch 2 activo listo para 1.21.11
Estas son las variantes y librerías actualmente activas dentro del stack.

| Componente | Estado | Observación |
| :--- | :--- | :--- |
| `SefiLib` | `Listo` | Librería de soporte de expansiones. |
| `InfinityLib` | `Listo` | Alineado al parent y usado por varios addons del ecosistema. |
| `Cultivation_Updated` | `Listo` | Esta es la variante activa adoptada; `Cultivation` original queda fuera del reactor. |
| `LiteXpansion` | `Listo` | Sin observación especial actual. |
| `Networks_Better_Compatibility` | `Listo` | Esta es la variante activa adoptada; `Networks` original queda fuera del reactor. |
| `SlimeTinker` | `Listo` | Quedó alineado al parent del reactor y a `Slimefun 6.0-Drake-1.21.11`. |
| `SMG` | `Listo` | En el reactor figura como `SimpleMaterialGenerators`. |
| `Supreme` | `Listo` | Sin observación especial actual. |
| `TranscEndence` | `Listo` | Sin observación especial actual. |

### ✅ Community addons activos listos para 1.21.11
Estos módulos ya están integrados al reactor y hoy compilan en esta rama.

| Addon | Estado | Observación |
| :--- | :--- | :--- |
| `AlchimiaVitae` | `Listo` | Sin observación especial actual. |
| `CrystamaeHistoria` | `Listo` | Sin observación especial actual. |
| `DankTech2` | `Listo` | Sin observación especial actual. |
| `DyeBench` | `Listo` | Integrado al reactor y migrado a `dev.drake.dough.*`. |
| `Element-Manipulation` | `Listo` | Tuvo port real de API/serializers; conviene smoke test cuando se arme runtime. |
| `ExtraTools` | `Listo` | Verificado en build aislado. |
| `FlowerPower` | `Listo` | Ajustado a API moderna de atributos de Bukkit/Paper. |
| `FN-FAL-s-Amplifications` | `Listo` | Verificado en build aislado. |
| `FoxyMachines` | `Listo` | Limpiado de usos legacy de utilidades viejas. |
| `HeadLimiter` | `Listo` | Integrado al reactor. `Towny` es opcional y su comportamiento de protección debe probarse en runtime. |
| `Liquid` | `Listo` | Verificado en build aislado. |
| `Magic-8-Ball` | `Listo` | Validado como quick win. |
| `MapJammers` | `Listo` | Requiere `squaremap` o `dynmap` en runtime para que su funcionalidad tenga sentido. |
| `MiniBlocks` | `Listo` | Integrado con `InfinityLib` local. Mantiene warnings por API deprecated de Bukkit, pero compila en Java 21. |
| `MissileWarfare` | `Listo` | Corregidas partículas obsoletas; recomendable smoke test por tratarse de efectos/runtime. |
| `RykenSlimeCustomizer-EN` | `Listo` | Verificado en build aislado. |
| `SfChunkInfo` | `Listo` | Validado como quick win. |
| `Simple-Storage` | `Listo` | Verificado en build aislado. Conviene prueba de runtime por inventarios/red. |
| `SlimeCustomizer` | `Listo` | Verificado en build aislado. Conviene prueba de runtime por ser addon muy configurable. |
| `VillagerUtil` | `Listo` | Verificado en build aislado. |

### ⚠️ Activos en reactor pero todavía NO listos
Estos módulos ya están dentro del build unificado, pero todavía presentan fallo confirmado o requieren port técnico adicional.

| Addon | Estado | Observación |
| :--- | :--- | :--- |
| `GeneticChickengineering-Reborn` | `Pendiente` | Fallo confirmado de dependencias/anotaciones: faltan `lombok` y `bstats` en el `pom.xml`, antes de entrar al port fino. |
| `PotionExpansion` | `Pendiente` | Fallo confirmado de API: sigue usando `SlimefunItemStack.item()` y `CustomItemStack.create(...)` con firma vieja. |

### ⏳ Addons presentes en el repo pero fuera del reactor
Estos addons todavía faltan por integrar, revisar o cerrar. Mientras estén aquí, no deben contarse como listos para `1.21.11`.

| Addon | Estado | Observación |
| :--- | :--- | :--- |
| `Cultivation` | `Fuera del reactor` | Variante vieja; la activa hoy es `Cultivation_Updated`. |
| `EMC2` | `Fuera del reactor` | Variante histórica; requiere triage antes de gastar tiempo. |
| `Galactifun` | `Fuera del reactor` | Probable caso pesado o con tooling propio. |
| `Networks` | `Fuera del reactor` | Variante vieja; la activa hoy es `Networks_Better_Compatibility`. |
| `AdvancedTech` | `Fuera del reactor` | Pendiente de triage. |
| `Better-Nuclear-Generator` | `Fuera del reactor` | Pendiente de triage. |
| `Bump` | `Fuera del reactor` | Sospechoso de necesitar trabajo extra de build/tooling. |
| `CompressionCraft` | `Fuera del reactor` | Pendiente de integración. |
| `CustomItemGenerators` | `Fuera del reactor` | Sospechoso de requerir trabajo extra de build/tooling. |
| `EMCTech` | `Fuera del reactor` | Pendiente de integración. |
| `FastMachines` | `Fuera del reactor` | Sospechoso de requerir trabajo extra de build/tooling. |
| `Gastronomicon` | `Fuera del reactor` | Candidato intermedio. |
| `Geyser-Slimefun-Heads` | `Fuera del reactor` | Candidato intermedio. |
| `MoreResearches` | `Fuera del reactor` | Quick win candidato. |
| `Netheopoiesis` | `Fuera del reactor` | Pendiente de triage. |
| `Quaptics` | `Fuera del reactor` | Quick win candidato. |
| `RelicsOfCthonia` | `Fuera del reactor` | Candidato intermedio. |
| `SaneCrafting` | `Fuera del reactor` | Pendiente de integración. |
| `SfBetterChests` | `Fuera del reactor` | Quick win candidato. |
| `SlimeFrame` | `Fuera del reactor` | Probable caso pesado. |
| `SlimefunAdvancements` | `Fuera del reactor` | Probable caso pesado. |
| `SlimefunTranslation` | `Fuera del reactor` | Sospechoso de requerir tooling/conversión extra. |
| `SlimefunWarfare` | `Fuera del reactor` | Variante histórica; triage antes de integrar. |
| `SlimeHUD` | `Fuera del reactor` | Quick win candidato. |
| `SmallSpace` | `Fuera del reactor` | Quick win candidato. |
| `SpiritsUnchained` | `Fuera del reactor` | Pendiente de integración. |
| `UltimateGenerators2` | `Fuera del reactor` | Sospechoso de requerir tooling/conversión extra. |
| `VillagerTrade` | `Fuera del reactor` | Candidato intermedio. |
| `Wildernether` | `Fuera del reactor` | Candidato intermedio. |
| `WorldEditSlimefun` | `Fuera del reactor` | Candidato intermedio; revisar integración con WorldEdit actual. |

### 📝 Observaciones importantes por plugin/stack

- `MapJammers`: compila, pero su utilidad real depende de que el servidor tenga `squaremap` o `dynmap`.
- `HeadLimiter`: compila y carga su lógica propia; si se usa `Towny`, conviene validar wilderness/claims en runtime.
- `MiniBlocks`: compila en Java 21, pero mantiene warnings por API deprecated de Bukkit (`JavaPluginLoader`).
- `MissileWarfare`: compila después del ajuste de partículas obsoletas; por ser addon visual/combate, requiere smoke test real.
- `Element-Manipulation`: ya quedó alineado a serializers y utilidades modernas; igual conviene validación runtime por efectos y mecánicas.
- `Simple-Storage`: compila, pero al tocar inventarios y red conviene prueba con servidor real.
- `SlimeCustomizer` y `RykenSlimeCustomizer-EN`: compilan, pero por ser addons altamente configurables conviene validación con configs reales.
- `Cultivation_Updated` y `Networks_Better_Compatibility`: son las variantes activas. No mezclar con `Cultivation` y `Networks` originales al hablar de “listo”.
- `GeneticChickengineering-Reborn`: hoy está trabado primero por `pom.xml`/dependencias, no por un port profundo de API.
- `PotionExpansion`: hoy está trabado por cambios reales de API/código, no solo por Maven.

---

## 💎 Addons Destacados (Premium)
Explora los pilares del laboratorio, ahora con rediseño visual y estabilización completa para 1.21.1:

<p align="center">
  <a href="sources/repos-to-port/InfinityExpansion/README.md"><b>Infinity Expansion</b></a> • 
  <a href="sources/repos-to-port/DynaTech/README.md"><b>DynaTech</b></a> • 
  <a href="sources/repos-to-port/SlimeChem/README.md"><b>SlimeChem</b></a> • 
  <a href="sources/repos-to-port/ExtraUtils/README.md"><b>ExtraUtils</b></a> • 
  <a href="sources/community-addons/PotionExpansion/README.md"><b>PotionExpansion</b></a>
</p>

<p align="center">
  <sub>Haz clic en los nombres para ver la documentación detallada y el arte cinemático de cada addon.</sub>
</p>

---

## 🏗️ Arquitectura (Drake Framework)

Este ecosistema utiliza el **Drake Framework**, una evolución técnica diseñada para desacoplar a Slimefun de dependencias legacy y NMS.

*   **Modularidad Atómica**: Compila cualquier addon con `mvn -pl <path> -am package`.
*   **Dough-Core Unificado**: 13 librerías consolidadas en un único núcleo relocalizado (`dev.drake.dough`).
*   **Persistencia Nativa**: Optimizado para Minecraft 1.21.1 Data Components.

---

## 📖 Documentación y Guías
Toda la documentación técnica ha sido movida a la **[Wiki Oficial](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki)** para mantener la raíz del repositorio limpia.

*   🔍 **[Checklist de Migración](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki/Checklist-de-Migración)**: Revisa qué addons están listos.
*   💻 **[Referencia Técnica 1.21.1](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki/Referencia-Técnica-(Paper-1.21.1))**: Descubrimientos de la API 1.21.
*   🧪 **[Guía de Smoke Test](https://github.com/DrakesCraft-Labs/drakes-slimefun-labs/wiki/Guía-de-Smoke-Test)**: Valida la salud de tu build.
*   📝 **[Plantilla de Addon](templates/slimefun-addon)**: Comienza a desarrollar tu propio addon Drake.

---

## 👥 Colaboradores y Créditos

Este proyecto es posible gracias al legado de grandes desarrolladores del ecosistema:

| Dev | Contribución |
| :--- | :--- |
| **TheBusyBiscuit** | Autor original de Slimefun 4. |
| **Sefiraat** | Mentor de las librerías de expansión y addons técnicos. |
| **Mooy1** | Creador de InfinityExpansion y arquitectura modular. |
| **Chagui68** | Variantes de compatibilidad y lógica de transición. |
| **[Pablo Elías](https://github.com/JackStar6677-1)** | Liderazgo del port 1.21.11 y creación del Drake Framework. |

---

<div align="center">
  <sub>Drakes Slimefun Labs es un proyecto independiente. Todas las marcas registradas pertenecen a sus respectivos dueños.</sub>
</div>
