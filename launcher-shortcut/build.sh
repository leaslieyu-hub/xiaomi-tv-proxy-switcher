#!/bin/bash
set -euo pipefail
cd "$(dirname "$0")"
TOOLCHAIN_ROOT="${TOOLCHAIN_ROOT:-/Users/leslieyu/Documents/Codex/2026-10-23/https-github-com-gathin23-cleanyourtv-blob}"
export JAVA_HOME="${JAVA_HOME:-$TOOLCHAIN_ROOT/work/toolchain/jdk-17.0.20.1+1/Contents/Home}"
SDK="${ANDROID_HOME:-$TOOLCHAIN_ROOT/work/toolchain/sdk}"
BT="$SDK/build-tools/34.0.0"
mkdir -p build/classes build/dex
"$BT/aapt" package -f -M AndroidManifest.xml -S res -I "$SDK/platforms/android-34/android.jar" -F build/resources.apk
"$JAVA_HOME/bin/javac" -source 8 -target 8 -bootclasspath "$SDK/platforms/android-34/android.jar" -d build/classes src/local/tv/store/MainActivity.java
"$BT/d8" --min-api 26 --lib "$SDK/platforms/android-34/android.jar" --output build/dex build/classes/local/tv/launcher/MainActivity.class
cp build/resources.apk build/unsigned.apk
(cd build/dex && zip -q ../unsigned.apk classes.dex)
"$BT/zipalign" -f 4 build/unsigned.apk build/aligned.apk
if [ ! -f build/local.keystore ]; then
 "$JAVA_HOME/bin/keytool" -genkeypair -keystore build/local.keystore -storepass android -keypass android -alias local -dname 'CN=Local TV Shortcut' -keyalg RSA -validity 10000
fi
"$BT/apksigner" sign --ks build/local.keystore --ks-key-alias local --ks-pass pass:android --out launcher-shortcut.apk build/aligned.apk
"$BT/apksigner" verify launcher-shortcut.apk
