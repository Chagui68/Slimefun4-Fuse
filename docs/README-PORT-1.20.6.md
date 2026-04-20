# Drake Slimefun 1.20.6 Port

This workspace contains a local `Slimefun4` source checkout prepared for `Purpur/Paper 1.20.6`.

Source base:
- Upstream repository: `https://github.com/Slimefun/Slimefun4`
- Local source folder: `source/Slimefun4-src`
- Local branch: `drake/port-1.20.6`
- Base commit: `4e4654683` (`Update to 1.20.5 (#4186)`)

Why this base was chosen:
- It already compiles against `1.20.6`.
- It explicitly treats `1.20.6` as part of the supported `1.20.5+` range.
- Its end-to-end workflow includes `1.16.5`, `1.17.1`, `1.18.2`, `1.19.4`, `1.20.4`, and `1.20.6`.
- It is much safer for Slimefun addons than force-backporting the later `1.21.x` line.

What was changed locally:
- Kept upstream API/package layout intact to avoid breaking addons.
- Kept the upstream compatibility model intact for older supported versions.
- Changed only the local Maven version string so the built jar is clearly identifiable.
- Added a build script that packages the jar and copies it to `artifacts/runtime-pack-1.20.6`.

Build requirements:
- Java `21`
- Maven `3.9+`

Build command:
- Run `.\scripts\build-drake-1.20.6.ps1` from the workspace root.

Output:
- Built jar is copied to `artifacts/runtime-pack-1.20.6`
