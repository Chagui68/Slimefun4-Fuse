# Prompt de Inicio para Otra IA

Usa este prompt al comenzar una sesión nueva con este repo:

```text
Estás trabajando en el repo drakes-slimefun-labs, rama 1.21-latin.

Contexto clave:
- Este repo no es un plugin único; es un laboratorio de migración para Slimefun 6 / Drake Framework sobre Paper 1.21.11 y Java 21.
- El pom.xml raíz es un reactor Maven que centraliza versiones, dependencias y módulos.
- Estado actual documentado: 53 módulos activos, 24 confirmados, 29 pendientes.
- dough-core propio: dev.drake.dough:dough-core:1.3.1-DRAKE
- Core: sources/slimefun-core/Slimefun4-src
- Variantes activas adoptadas desde Chagui: Networks_Better_Compatibility y Cultivation_Updated

Primero haz esto:
1. Lee README.md
2. Lee MIGRATION_CHECKLIST.md
3. Lee docs/MIGRATION_GUIDE_1_21_11.md
4. Lee docs/TOMORROW_HANDOFF.md
5. Lee docs/SMOKE_TEST.md
6. Revisa git status

Reglas de trabajo:
- No compiles el reactor entero salvo que sea estrictamente necesario.
- Usa compilación aislada con: mvn -pl ruta/del/modulo -am -DskipTests package
- Antes de tocar código, determina si el fallo es de POM/dependencias o de API/código.
- Si el addon ya usa dev.drake.dough.* pero falla por imports no resueltos, revisa primero si su pom.xml aún no hereda del parent o no depende de dough-core.
- Prioriza cambios pequeños con validación real.
- Si actualizas estado de módulos, sincroniza README.md, MIGRATION_CHECKLIST.md y docs/MIGRATION_GUIDE_1_21_11.md.

Pendientes inmediatos sugeridos:
- SimpleUtils
- SlimyRepair
- DynaTech
- SoundMuffler
- luego pruebas de runtime con Paper/Purpur 1.21.11

Smoke test disponible:
- powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1

Objetivo de esta sesión:
- elegir uno de los pendientes inmediatos
- dejarlo compilando o dejar documentado con precisión por qué sigue fallando
- no terminar con cambios ambiguos o a medio mezclar
```
