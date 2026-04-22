# Master Project Handover: DrakesCraft-Labs (1.21.11)
**Instrucción para la IA:**

"Actúa como un desarrollador Senior de Java y DevOps especializado en Minecraft. Estás heredando un proyecto masivo de refactorización. Lee atentamente este contexto antes de proponer cualquier cambio."

## 1. Visión del Proyecto
Estamos migrando un ecosistema de 35+ addons de Slimefun y su librería base Dough de la 1.20.6 a la 1.21.11. El objetivo es la independencia tecnológica total mediante el Framework Drake.

## 2. Arquitectura Técnica (CRÍTICO)
- **Mono-Repo Maven**: El repositorio está organizado como un proyecto multi-módulo.
- **Lógica de Versión (Version Bridge)**: No usamos código mezclado. Usamos una interfaz `VersionBridge` para abstraer la lógica entre la 1.20.6 (PDC antiguo) y la 1.21.11 (Data Components nativos).
- **Dough-Core (dev.drake.dough)**: Hemos absorbido la librería Dough, unificado sus 13 módulos en uno solo (`dough-core`) y relocalizado el paquete para evitar conflictos. Se ha purgado todo el NMS antiguo; es 100% nativo 1.21.11.
- **Stack**: Java 21, Paper/Purpur API 1.21.11, Slimefun RC-37.

## 3. Estructura del Repositorio
- **/sources/**: Todos los códigos fuente de los addons y dough-core.
- **/deploy/**: Binarios y servidores de prueba separados por versión.
- **/scripts/**: Automatización de builds.

## 4. Estado Actual
- ✅ Estructura de carpetas y Git limpia.
- ✅ Parent POM global configurado.
- ✅ Dough-Core porteado y limpio de NMS.
- ✅ 5 Plugins Piloto migrados (SlimeChem, Networks, SFCalc, SefiLib, InfinityLib).
- ⚠️ **PENDIENTE**: Migración masiva de los 30+ addons restantes siguiendo el `MIGRATION_CHECKLIST.md`.

## 5. Reglas de Oro para el Desarrollo
- **Prohibido NMS**: No uses reflexión o clases internas de Minecraft. Usa la API de Paper 1.21.11.
- **Data Components**: Los metadatos deben manejarse a través del nuevo `VersionBridge` o el `dough-core` refactorizado.
- **Traducciones**: Todo el output de los plugins debe estar en Español Latino.
- **Inmutabilidad**: Respeta la inmutabilidad de los ítems en la 1.21.11 usando `.editMeta()`.

---

**Nota para el Usuario:**
Cuando abras una nueva sesión, pasa este texto a la IA y pídele que lea el `pom.xml` raíz y el `ARCHITECTURE.md` para que esté "al día" sin explicaciones adicionales.
