# New Addon Template

## Purpose

The `templates/slimefun-addon` folder exists to speed up the creation of new addons aligned with the current Drake stack, without starting from an old project or outdated coordinates.

## What the template includes

- minimal Maven addon structure
- `pom.xml` oriented to the lab reactor
- easy-to-replace placeholder names
- a base README that reminds contributors of the integration flow

## What you should replace

- `TemplateAddon`
- `dev.drake.template`
- placeholder IDs such as `TEMPLATE_MACHINE`
- sample classes such as `TemplateMachine`

## If the addon will live inside this monorepo

1. move the folder into the appropriate area:
   - `sources/repos-to-port`
   - `sources/batch-2-expansion`
   - `sources/community-addons`
2. adjust the `relativePath` in `pom.xml` if the depth changes
3. add the module to the root `pom.xml`
4. validate with an isolated build

Recommended command:

```powershell
mvn -pl path/to/module -am -DskipTests package
```
