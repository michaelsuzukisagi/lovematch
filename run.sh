#!/bin/bash
if [[ -z ${MAVEN_OPTS} ]]; then
    echo "The environment variable 'MAVEN_OPTS' is not set, setting it for you";
    MAVEN_OPTS="-Xms256m -Xmx400m -XX:PermSize=300m -agentpath:/Applications/YourKit.app/Contents/Resources/mac/libyjpagent.jnilib=disablestacktelemetry,disableexceptiontelemetry,builtinprobes=none,delay=10000,sessionname=Benchmark"
fi
echo "MAVEN_OPTS is set to '$MAVEN_OPTS'";
mvn clean install -Pamp-to-war
