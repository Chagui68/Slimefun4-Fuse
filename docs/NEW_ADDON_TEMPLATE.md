# Plantilla de Nuevo Addon

Esta plantilla sirve para crear addons nuevos orientados a este workspace y a este stack:

- `Minecraft 1.21.11`
- `Java 21`
- `Slimefun 6 / Drake Framework`
- `dough-core 1.3.1-DRAKE`

## Dónde mirar

La base reutilizable está en:

- [templates/slimefun-addon/pom.xml](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/templates/slimefun-addon/pom.xml>)
- [templates/slimefun-addon/src/main/resources/plugin.yml](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/templates/slimefun-addon/src/main/resources/plugin.yml>)
- [templates/slimefun-addon/src/main/java/dev/drake/template/TemplateAddon.java](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/templates/slimefun-addon/src/main/java/dev/drake/template/TemplateAddon.java>)
- [templates/slimefun-addon/src/main/java/dev/drake/template/items/TemplateMachine.java](</C:/Users/pablo/OneDrive/Documents/GitHub/Experimentos/drakes-slimefun-labs/templates/slimefun-addon/src/main/java/dev/drake/template/items/TemplateMachine.java>)

## Flujo recomendado

1. Copia `templates/slimefun-addon` a la carpeta que corresponda.
2. Renombra package, artifactId, clase principal y nombres visibles.
3. Ajusta `plugin.yml`.
4. Si el addon entrará al monorepo, agrega su ruta en `pom.xml` raíz.
5. Compílalo aislado con `-pl`.
6. Corre el smoke test del repo si lo integraste al reactor.

## Reglas de este ecosistema

- Hereda del parent `drakes-slimefun-labs` cuando el addon viva dentro del monorepo.
- Usa `paper-api` y `Slimefun4` como `provided`.
- Excluye `dough-api` de `Slimefun4`.
- Usa `dev.drake.dough:dough-core` como `provided`.
- No metas NMS salvo que sea absolutamente inevitable.
- Prefiere `ItemGroup`, `Research`, `SlimefunItem` y `SlimefunItemStack` modernos.

## Build de prueba

```powershell
mvn -pl ruta/del/modulo -am -DskipTests package
```

## Smoke test después de integrarlo

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\slimefun\smoke-test.ps1
```

Si el addon toca librerías base o core, usa el perfil `core` o `extended`.

## Qué trae el ejemplo

- una clase principal `JavaPlugin + SlimefunAddon`
- un `ItemGroup`
- un `Research`
- una máquina/item simple que se registra en `onEnable`
- `plugin.yml` mínimo
- `pom.xml` alineado al reactor Drake

## Cuándo no usar esta plantilla tal cual

- si el addon es externo al monorepo y no heredará del `parent`
- si requiere librerías propias como `InfinityLib`, `SefiLib` o integraciones opcionales
- si es un port de un addon legacy ya existente, porque ahí conviene partir desde el código original
