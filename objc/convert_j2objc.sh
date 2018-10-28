#!/usr/bin/env bash
J2OBJC_VERSION="2.2"
J2OBJC="../../j2objc-${J2OBJC_VERSION}/j2objc"
SOURCE_PATH="../symja_android_library/matheclipse-core/src/main/java"
OUTPUT_DIR="./build/output"


echo ${J2OBJC}

echo "cleanup"
rm -rf ${OUTPUT_DIR}
mkdir ${OUTPUT_DIR}

${J2OBJC} -d ${OUTPUT_DIR} -sourcepath ${SOURCE_PATH} `find ${SOURCE_PATH} -name *.java`
