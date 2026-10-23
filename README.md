# Xiaomi TV Proxy Switcher

[简体中文说明](README.zh-CN.md)

An Android TV app for switching between HTTP proxy presets shared by phones or other devices. It supports Android 9/API 28 and newer.

## Features

- Store up to four proxy presets with a device name, host, and port.
- Save a preset or apply it immediately with **Use**.
- Show the active proxy name and address.
- Green/red status indicator and green highlight for the active row.
- Chinese and English interface switching.
- TV-friendly D-pad and USB/2.4 GHz mouse support.

The app changes Android's global HTTP proxy through `Settings.Global`. It does not implement a VPN and does not store proxy credentials.

## Install

```bash
adb install -r proxy-switcher.apk
adb shell pm grant local.proxy.switcher android.permission.WRITE_SECURE_SETTINGS
```

Use the language button in the top right to switch between English and Chinese.

## Interface

![TV proxy control interface](docs-proxy-control-en.png)

## Xiaomi TV launcher shortcut

`launcher-shortcut/` provides a small app that opens the installed clean launcher `com.gathin.tvhome` after a reboot. It does not change the TV's HDMI startup input.

## Mouse connection

Bluetooth may be unavailable on some MiTV-ASTP0 firmware. A wired USB mouse or a 2.4 GHz wireless mouse with its USB receiver is recommended. Plug the receiver into the TV's USB port and wait a few seconds.

## Build

```bash
./gradlew assembleRelease
```

## License

MIT License. See [LICENSE](LICENSE). Contributions are welcome through forks and pull requests; see [CONTRIBUTING.md](CONTRIBUTING.md).
