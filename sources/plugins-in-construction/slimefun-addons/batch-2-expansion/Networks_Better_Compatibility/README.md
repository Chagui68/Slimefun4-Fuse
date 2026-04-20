<p align="center">
  <img width="800" src="https://github.com/Sefiraat/Networks/blob/master/images/logo/logo.svg"><br><br>
</p>

# 🌐 Networks - Better Compatibility (Unofficial)

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.20.6-brightgreen.svg)](https://www.spigotmc.org/)
[![Slimefun](https://img.shields.io/badge/Slimefun4-RC--37-blue.svg)](https://github.com/Slimefun/Slimefun4)
[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.java.com/)

> [!IMPORTANT]
> This is an **UNOFFICIAL** fork of the original [Networks](https://github.com/Sefiraat/Networks) addon by **Sefiraat**.
> It has been updated to provide better compatibility with Minecraft **1.20.6** and resolve critical initialization issues.

---

Networks is a Slimefun4 addon that brings a simple yet powerful item storage and movement network that works along side cargo.

## 🚀 Key Fixes in this Version
- **Full 1.20.6 Support**: Resolved all compilation errors related to modern Minecraft enchantment and particle renames.
- **Robust Initialization**: Fixed the `NullPointerException` and `ExceptionInInitializerError` by refactoring the static initialization order.
- **Improved Stability**: Removed circular dependencies between core Slimefun items.

---

## 📋 Requirements

### Server
- **Minecraft**: 1.20.6
- **Server Software**: Spigot or Paper 1.20.6
- **Java**: 21 or higher
- **Slimefun4**: RC-37 or newer

---

## 📦 Installation

1. **Install Slimefun4**
   - Download from [Slimefun4 Builds](https://blob.build/project/Slimefun4)
   - Place in `/plugins/` folder

2. **Install Networks**
   - Download the latest `.jar` from this repository.
   - Place in `/plugins/` folder

3. **Restart Server**

---

## 📖 About Networks

You can find a fuller guide to Networks including all items and blocks in the original [Documentation Pages](https://sefiraat.dev)

![](https://github.com/Sefiraat/Networks/blob/master/images/wiki/setup.png?raw=true)

### Network Grid / Crafting Grid
It can access every single item in the network and display it to you on a single GUI. Items can be inserted directly through this grid and a special crafting grid can craft both vanilla AND slimefun items using ingredients directly from the network.

![](https://github.com/Sefiraat/Networks/blob/master/images/wiki/grid.png?raw=true)

### Network Cells & Quantum Storage
- **Network Cells**: Single block holding a double-chests worth of items.
- **Network Quantum Storage**: Massive storage for a single item type, upgradable from 4k to 2 billion items.

### Autocrafting
The Network Autocrafter can take recipes encoded by the Network Encoder and craft them periodically using items and power directly from the network.

---

## 🛠️ Development

### Building from Source
```bash
git clone https://github.com/Chagui68/Networks_Better_Compatibility.git
cd Networks_Better_Compatibility
mvn clean package
```

---

## 🙏 Credits & Original Authors
- **Sefiraat** - Original creator and lead developer.
- Special thanks to Boomer, Cai, and Lucky for testing.
- Shoutout to the community members who supported the original project.

---

## 📄 License
This project is licensed under the **GPL-3.0 License** - see the original project for full details.
