#!/usr/bin/env bash
TEST_DIR=./src/androidTest/java/
rm -rf $TEST_DIR
cp -R ../symja_android_library/matheclipse-core/src/test/java/ $TEST_DIR
cp -R ../symja_android_library/matheclipse-io/src/test/java/ $TEST_DIR