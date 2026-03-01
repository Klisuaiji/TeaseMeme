# TeaseMeme

A multi-platform Minecraft mod built with Architectury, supporting both Fabric and NeoForge.

## Features

- Multi-platform support (Fabric & NeoForge)
- Built with Architectury API for cross-platform compatibility
- GeckoLib integration for custom entity animations

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

## License

MIT License
