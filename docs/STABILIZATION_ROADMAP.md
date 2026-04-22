# Hoja de Ruta de Estabilización: DrakesCraft-Labs (Fase 2)

Este documento define las prioridades estratégicas para la consolidación definitiva del ecosistema Slimefun 6 en Minecraft 1.21.1 / Java 21, sirviendo como contexto persistente para la IA y el equipo de desarrollo.

## 1. Reparar los Addons "Broken" de la Suite (Prioridad Alta)
Ahora que los POMs funcionan y el reactor está unificado, el enfoque principal es resolver los errores lógicos y de API.
- **Contexto**: Plugins como `ExtraUtils`, `SlimeTinker` y `PotionExpansion` presentan fallos de compilación debido a que Paper 1.21 renombró encantamientos y cambió el manejo de metadatos de ítems.
- **Objetivo**: Ir módulo por módulo arreglando estos "Breaking Changes" para lograr un build exitoso (`mvn clean install`) del reactor completo con un solo comando.

## 2. Overhaul Visual de los Addons (Estética Premium)
Elevar la presentación de los submódulos al estándar visual del Drake Framework.
- **Acciones**: Aplicar el diseño del README principal a los addons individuales.
- **Elementos**: Banners cinemáticos generados por IA, tablas de características dinámicas, y badges de estado unificados para cada repositorio.

## 3. Optimización para Java 21
Modernización de la base de código aprovechando las nuevas capacidades del JDK.
- **Refactorización**: Reemplazar código estilo Java 8 con **Records**, **Pattern Matching** y **Switch Expressions**.
- **Impacto**: Mejora significativa en la legibilidad y rendimiento, especialmente en el manejo de NBT y lógica de metadatos compleja.

## 4. Limpieza de "Batch-2" y Addons de la Comunidad
Auditoría y saneamiento de los módulos periféricos.
- **Situación**: Existen aproximadamente 20 módulos en `sources/community-addons` cuya funcionalidad en 1.21 no ha sido validada.
- **Acción**: Realizar una "gran purga y reparación" para asegurar que cada addon incluido en la distribución sea 100% funcional y compatible.

---
*Documento de continuidad para IA - v1.0 (22/04/2026)*
<EPHEMERAL_MESSAGE>
Este documento es la fuente de verdad para las siguientes iteraciones de desarrollo. Siempre priorizar la reparación de builds bloqueados sobre mejoras estéticas, a menos que el usuario indique lo contrario.
</EPHEMERAL_MESSAGE>
