# Roadmap

## Objetivo

Completar una libreria util de plugins para `Purpur 1.20.6` que permita montar un servidor nuevo sin volver a investigar desde cero.

## Ya Cubierto

- `Purpur 1.20.6`
- `Slimefun 1.20.6` portado
- base de addons `Slimefun` clasificada en:
  - listos sin modificar
  - portados localmente
  - en construccion
- base general actual con:
  - `LuckPerms`
  - `Vault`
  - `EssentialsX`
  - `PlaceholderAPI`
  - `TAB`
  - `DeluxeMenus`
  - `ProtectionStones`
  - `WorldGuard`
  - `CoreProtect`
  - `FastAsyncWorldEdit`

## Falta Consolidar

- decidir la lista exacta de plugins base que quedaran como stack oficial de `Drakes`
- completar la libreria fuera de `Slimefun`
- clasificar plugins por:
  - seguros para publico
  - utiles pero delicados
  - descartados por abuso, dupe o bypass de protecciones
- preparar packs de configuracion base:
  - tablist
  - scoreboard
  - menas y drops
  - protecciones
  - menus
  - permisos

## Pendientes Tecnicos

- seguir portando addons medianos y pesados de `Slimefun`
- revisar exploits adicionales en addons complejos
- probar en runtime real los jars portados mas sensibles
- documentar que addons quedan fuera por riesgo

## Pendientes Operativos

- crear una carpeta de configuraciones iniciales reutilizables
- dejar una convencion de nombres para jars confirmados
- separar mejor los plugins solo de prueba de los plugins que van directo a produccion
