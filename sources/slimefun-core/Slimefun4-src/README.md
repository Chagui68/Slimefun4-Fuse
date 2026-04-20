# Drakes Slimefun 1.20.6 Port

Unofficial `Slimefun4` port for `Paper/Purpur 1.20.6`, published by `DrakesCraft-Labs`.

## What This Repository Is

This repository packages a compatibility-focused `Slimefun4` build for:

- `Paper 1.20.6`
- `Purpur 1.20.6`
- `Java 21`

The published jar is versioned as:

- `Slimefun v4.9-Drake-1.20.6.jar`

This is meant for server owners who explicitly need a `1.20.6` line without jumping to a later upstream branch that may shift compatibility expectations for existing addons.

## Credits

This port would not exist without the original project and its contributors.

- Original project: [`Slimefun/Slimefun4`](https://github.com/Slimefun/Slimefun4)
- Original authors and maintainers: `TheBusyBiscuit`, `Walshy`, and the wider `Slimefun` community
- Upstream contributor base: 200+ contributors across the life of the project
- Port packaging and publication: `DrakesCraft-Labs`

This repository is a derivative publication built on top of the upstream GPL project. Credit for the plugin itself belongs first and foremost to the original Slimefun team and community.

## Technical Base

This port is based on the upstream `Slimefun4` commit:

- `4e4654683` - `Update to 1.20.5 (#4186)`

That base was chosen because it already carried the `1.20.5+` transition work and explicitly treated `1.20.6` as part of the supported version range, making it a safer compatibility point than trying to backport from the later `1.21.x` line.

## What Was Changed

The goal here was to keep changes minimal and honest.

- packaged a dedicated `1.20.6` release line
- marked the build as `4.9-Drake-1.20.6`
- kept the upstream gameplay and API line as close as possible to that branch point
- added repository documentation and release notes for this port
- updated a test-only build dependency so the project can still be compiled cleanly today

## What This Port Is Not

- It is not the official upstream repository.
- It is not a full fork that aims to outpace upstream.
- It is not a promise that every addon made for every Slimefun era will work unchanged.
- It is not a `1.21.x` feature backport.

## Compatibility Notes

Expected to work with:

- `Paper 1.20.6`
- `Purpur 1.20.6`
- addons targeting the same general Slimefun API line around the upstream `1.20.5+` transition

Potential incompatibilities may still appear with:

- addons depending on newer upstream changes after this base commit
- addons with their own fragile NMS logic
- addons expecting exact upstream metadata, updater behavior, or newer APIs

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

GitHub release:

- [`v4.9-Drake-1.20.6`](https://github.com/DrakesCraft-Labs/Slimefun4-1.20.6-Port/releases/tag/v4.9-Drake-1.20.6)

Included asset:

- `Slimefun v4.9-Drake-1.20.6.jar`

## Addons

The upstream Slimefun ecosystem maintains addon references in its official wiki:

- [`Slimefun/Slimefun4 Wiki - Addons`](https://github.com/Slimefun/Slimefun4/wiki/Addons)

For local server preparation, this workspace also includes an `AddonsSlimefun` folder with a curated local catalog of addon source and release links.

## License

Upstream Slimefun is licensed under `GPL-3.0`.
This repository remains a derivative publication of that GPL-licensed work.
