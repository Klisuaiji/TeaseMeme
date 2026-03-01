# TeaseMeme

A multi-platform Minecraft mod built with Architectury, supporting both Fabric and NeoForge.

## Features

### Rainbow Skeleton (彩色骷髅)

A mysterious creature that lurks in the depths of caves, emitting an enchanting rainbow glow.

**Characteristics:**
- Spawns exclusively in dark caves (below Y=60)
- Emits a beautiful rainbow-colored glow
- Semi-transparent appearance with self-illumination
- Burns in sunlight like regular skeletons
- 20 health points (10 hearts)
- Cannot wear armor

**Behavior:**
- Only attacks players, ignores other hostile mobs
- Applies "Rainbow Curse" effect on hit (causes nausea and slowness)
- Does not perform jump attacks

**Drops:**
- Custom drops can be configured

## Requirements

- Minecraft 1.21.1
- Java 21+

### Fabric
- Fabric Loader 0.16.0+
- Fabric API
- Architectury API 13.0.0+
- GeckoLib 4.7.0+

### NeoForge
- NeoForge 21.1+
- Architectury API 13.0.0+
- GeckoLib 4.7.0+

## Building

```bash
./gradlew build
```

Build outputs will be in:
- `fabric/build/libs/` - Fabric mod jar
- `neoforge/build/libs/` - NeoForge mod jar

## Development

This project uses the Architectury toolchain for multi-platform mod development:

- `common/` - Shared code between platforms
- `fabric/` - Fabric-specific code
- `neoforge/` - NeoForge-specific code

## Multi-language Support

- English (en_us)
- Simplified Chinese (zh_cn)

## License

MIT License
