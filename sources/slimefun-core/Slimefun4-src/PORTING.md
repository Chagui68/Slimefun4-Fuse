# Slimefun 1.20.6 Port Notes

This repository is an unofficial packaging and publication of a `Slimefun4` code line suitable for `Paper/Purpur 1.20.6`.

## What This Is

- A GitHub-hosted port for `Minecraft 1.20.6`
- Built for `Paper` and `Purpur`
- Intended for `Java 21`
- Published with a clearly marked local version: `4.9-Drake-1.20.6`
- Designed to stay as close as possible to upstream behavior and API shape

## What This Is Not

- Not the official `Slimefun` upstream repository
- Not an attempt to replace or supersede upstream development
- Not a blanket compatibility promise for every addon ever made
- Not a forward-port of `1.21.x` content into `1.20.6`

## Technical Base

This port is based on the upstream `Slimefun/Slimefun4` commit:

- `4e4654683` - `Update to 1.20.5 (#4186)`

That upstream point was chosen because it already:

- treats `1.20.6` as part of the supported `1.20.5+` range
- keeps compatibility logic for older supported server lines
- is much safer for existing Slimefun addons than rebasing onto the later `1.21.x` line

## Local Changes Made Here

The local publication keeps code changes intentionally minimal.

- Maven version changed to `4.9-Drake-1.20.6` so the jar is identifiable
- Test-only `MockBukkit` dependency updated to a resolvable artifact so the project can build cleanly today
- Porting documentation added
- Release packaging script added outside this repository during local build preparation

No gameplay-facing API rewrite was introduced for this publication.

## Compatibility

Expected to be compatible with:

- `Paper 1.20.6`
- `Purpur 1.20.6`
- addons that target the same general Slimefun API line used by upstream around the `1.20.5+` transition

Should remain safer for older addon expectations than a `1.21.x`-based backport because this publication does not intentionally move the API surface forward beyond that branch point.

Potential incompatibilities still exist for:

- addons that rely on newer upstream changes after this base commit
- addons that ship their own fragile NMS hooks
- addons that assume exact upstream build metadata or updater behavior
- plugins expecting official upstream support policy

## Build Requirements

- `Java 21`
- `Maven 3.9+`

Typical build:

```powershell
mvn clean package "-Dmaven.test.skip=true"
```

## Release Artifact

The published release jar is:

- `Slimefun v4.9-Drake-1.20.6.jar`

## Support Expectations

This repository should be treated as a compatibility-focused publication for `1.20.6`, not as an official upstream support channel.
