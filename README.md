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
De ese total, el **reactor activo** cubre **56 módulos** (`54 addons + 2 módulos base`).

**Progreso de Migración:**
`[============================>-----] 85%`

| Métrica | Valor |
| :--- | :--- |
| 🚀 **Componentes Confirmados en Reactor** | `50` |
| ⏳ **Pendientes Dentro del Reactor** | `6` |
| 🧩 **Addons Fuera del Reactor** | `33` |
| 📚 **Pendiente Bruto del Repo** | `39 addons` |
| 📦 **Librería Core** | `dough-core:1.3.1-DRAKE` |

**Cómo leer este tablero**
- `6 pendientes` significa solo los addons que ya están declarados en el `pom.xml` raíz y todavía no quedan verdes.
- `33 fuera del reactor` significa addons presentes en el repo que aún no están incorporados al build unificado.
- El backlog real a revisar es `39 addons`, no `6`.

**Últimos cierres validados**
- `DyeBench`: integrado al reactor y alineado a dependencias Drake.
- `FoxyMachines`: eliminados usos de utilidades legacy de `commons-lang`.
- `FlowerPower`: ajustado al API moderno de atributos de Bukkit/Paper.
- `MissileWarfare`: vuelve a compilar en el reactor actual.
- `Element-Manipulation`: alineado a `dev.drake.dough.*`, serializers Adventure actuales e `InfinityLib` moderno.

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
