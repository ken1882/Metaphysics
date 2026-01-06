# Metaphysics

This repository is a **heavy rewrite** of
[https://github.com/KallenKas024/Metaphysics](https://github.com/KallenKas024/Metaphysics)

The goal of this rewrite is to modernize the codebase and make it compatible with the **Create 6 / Valkyrien Skies 2.4 / CC:Tweaked**, removing outdated mixins, internal class usage, and legacy dependencies.

## Compatibility Targets

This rewrite is tested and works with:
* **Minecraft**: 1.20.1
* **Forge**: 47.x
* **Valkyrien Skies**: **2.4.6**
* **Create**: **6.0.8 (Create 6)**
* **CC: Tweaked**: **1.170+**

> ⚠️ Earlier versions of these mods are **not supported**.
> You should use original version if you want to use in Create 5.

## What This Mod Does

### Coordinate & World Query Lua API

Exposed under `coord` / `coordinate`, providing:

* Computer position (block / turtle / pocket)
* Dimension & absolute coordinates
* Block queries (air, solidity, replaceable, explosion resistance, etc.)
* Entity scanning (players, mobs, motion vectors, health, armor)
* Monster-only scans
* Map color sampling & terrain height scanning
* **Valkyrien Skies ship awareness**:
  * Detect nearby ships
  * Convert ship-local → world coordinates
  * Query ship AABBs
  * Get/set ship slug


## Major Changes from the Original Project

* ❌ Removed all CC internal class usage (`ServerComputer`, `Computer`, etc.)
* ❌ Removed outdated mixins targeting removed CC client classes
* ✅ Uses dependency's API instead direct mixins
* ✅ Server-safe world access (no client-only classes)
* ✅ Modern Gradle + Java 17 toolchain

## Building

```bash
./gradlew clean build
```

The output jar will be in:

```
build/libs/
```

Use the **jar without `-all`** in your `mods/` folder.

## License

GPL (same intent as the original project).
