# Drakes Slimefun 1.21.11 Port

Unofficial `Slimefun4` port for `Paper/Purpur 1.21.11`, published by `DrakesCraft-Labs`.

## What This Repository Is

This repository packages the `Slimefun4` core used by the `DrakesCraft-Labs` mono-repo for:

- `Paper 1.21.11`
- `Purpur 1.21.11`
- `Java 21`

The published jar is versioned as:

- `Slimefun v5.0-Drake-1.21.11.jar`

This line is meant to be the canonical base for the Drakes ecosystem on `1.21.11`, aligned with the rest of the reactor and its addon migration effort.

## Credits

This port would not exist without the original project and its contributors.

- Original project: [`Slimefun/Slimefun4`](https://github.com/Slimefun/Slimefun4)
- Original authors and maintainers: `TheBusyBiscuit`, `Walshy`, and the wider `Slimefun` community
- Upstream contributor base: 200+ contributors across the life of the project
- Port packaging and publication: `DrakesCraft-Labs`

This repository is a derivative publication built on top of the upstream GPL project. Credit for the plugin itself belongs first and foremost to the original Slimefun team and community.

## Technical Base

This port now tracks the Drakes mono-repo target of `1.21.11` and is wired into the shared parent POM plus the internal `dough-core` publication.

The current strategy is:

- use `Paper/Purpur 1.21.11`
- keep Java at `21`
- integrate against `dev.drake.dough:dough-core`
- preserve upstream Slimefun behavior where possible while applying compatibility fixes required for modern Paper

## What Was Changed

The goal here is no longer a frozen `1.20.6` compatibility snapshot.

- packaged a dedicated `1.21.11` release line
- marked the build as `5.0-Drake-1.21.11`
- aligned the module with the root reactor versioning
- kept the test suite in place
- migrated compatibility hotspots to direct Paper APIs where it reduces friction, such as head/profile handling

## What This Port Is Not

- It is not the official upstream repository.
- It is not a full fork that aims to outpace upstream.
- It is not a promise that every addon made for every Slimefun era will work unchanged.
- It is not a legacy `1.20.6` compatibility line anymore.

## Compatibility Notes

Expected to work with:

- `Paper 1.21.11`
- `Purpur 1.21.11`
- addons that are being migrated inside the Drakes mono-repo against the `5.0-Drake-1.21.11` core line

Potential incompatibilities may still appear with:

- addons depending on upstream branches or APIs that diverge from the Drakes reactor
- addons with their own fragile NMS logic
- addons that still assume pre-1.21 item/meta or attribute names

More detailed notes live in [PORTING.md](PORTING.md).

## Build

Requirements:

- `Java 21`
- `Maven 3.9+`

Build locally:

```powershell
.\build-release.ps1
```

Or directly:

```powershell
mvn clean package "-Dmaven.test.skip=true"
```

## Release

GitHub release metadata should match the active Drakes core line:

- `v5.0-Drake-1.21.11`
- `Slimefun v5.0-Drake-1.21.11.jar`

## Addons

The upstream Slimefun ecosystem maintains addon references in its official wiki:

- [`Slimefun/Slimefun4 Wiki - Addons`](https://github.com/Slimefun/Slimefun4/wiki/Addons)

For local server preparation, this workspace also includes an `AddonsSlimefun` folder with a curated local catalog of addon source and release links.

## License

Upstream Slimefun is licensed under `GPL-3.0`.
This repository remains a derivative publication of that GPL-licensed work.
