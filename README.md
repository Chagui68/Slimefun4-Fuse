# 🐉 DrakesCraft-Labs: Slimefun Ecosystem
### *The Ultimate 1.21.11 Migration & Tech Independence Framework*

<div align="center">

![Version](https://img.shields.io/badge/Minecraft-1.21.11-green?style=for-the-badge&logo=minecraft)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Build](https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge)

**Drake Framework** es la respuesta definitiva para un ecosistema de Slimefun moderno, eficiente e independiente. 
Estamos reconstruyendo más de 35 addons desde sus cimientos para abrazar el paradigma de la versión 1.21.11.

[Explorar Código](/sources) • [Checklist de Migración](MIGRATION_CHECKLIST.md) • [Arquitectura](ARCHITECTURE.md)

</div>

---

## ⚡ La Visión "Drake"
Dejar atrás el "caos de los ports individuales". Hemos unificado todo en un **Mono-Repo Multi-módulo** para garantizar que cada addon hable el mismo idioma técnico. No más parches rápidos; esto es ingeniería avanzada para servidores de alto rendimiento.

## 🏗️ Pilares de la Arquitectura
| Componente | Descripción |
| :-- | :-- |
| **`dough-core`** | Nuestra versión "nativizada" de Dough. Purgada de NMS, relocalizada a `dev.drake.dough` y optimizada para Java 21 y Data Components. |
| **`Version Bridge`** | Abstracción total entre el antiguo NBT/PDC y los nuevos componentes de ítem de la 1.21. |
| **`Latin-First`** | Localización integral a Español Latino integrada en el ciclo de vida del build. |

## 📂 Organización del Proyecto
```bash
/
├── sources/               # El Corazón: Dough-Core y todos los Addons
│   ├── dough-core/        # Nuestra librería base unificada
│   ├── repos-to-port/     # Batch 1: Prioridad de migración inmediata
│   └── batch-2-expansion/ # Batch 2: Expansión y lógica compleja
├── deploy/                # El Laboratorio: Entornos de prueba aislados
│   ├── purpur-1.21.11/    # Target actual de despliegue
│   └── purpur-1.20.6/     # Herencia estable con configuraciones
├── scripts/               # La Fábrica: Automatización de builds y JARs
└── docs/                  # El Cerebro: Documentación y Roadmaps
```

## 🚀 Estado del Dashboard
> [!IMPORTANT]
> **Rama Actual**: `1.21-latin`
> 
> Estamos en la fase de **Refactorización Masiva**. Hemos completado la base arquitectónica y los 5 plugins piloto.

- [x] **Consolidación de Núcleo**: `dough-core` 100% funcional.
- [x] **Estandarización Maven**: Parent POM configurado para todo el ecosistema.
- [/] **Porteo de Addons**: 
    - `[x]` SefiLib, InfinityLib, DynaTech.
    - `[x]` Networks, SFCalc, SlimeChem.
    - `[ ]` +30 Addons en proceso de refactorización de imports.

## 🛠️ Guía de Inicio Rápido
Para el equipo de desarrollo:
1. Asegúrate de tener **Java 21** instalado.
2. Clona este repositorio en la rama `1.21-latin`.
3. Compila el ecosistema completo:
   ```powershell
   mvn clean package
   ```
4. Recoge tus JARs en `sources/**/target/`.

---

## 🤖 Handover Context (AI-Ready)
Este repositorio está diseñado para ser co-creado con IA. 
- Si eres un nuevo desarrollador o una IA asistente, lee **[IA_INSTRUCTIONS.md](IA_INSTRUCTIONS.md)** antes de empezar.
- Consulta el **[MIGRATION_CHECKLIST.md](MIGRATION_CHECKLIST.md)** para tu siguiente ticket de trabajo.

---
<div align="center">
Desarrollado con ❤️ por <b>DrakesCraft-Labs</b>
</div>
