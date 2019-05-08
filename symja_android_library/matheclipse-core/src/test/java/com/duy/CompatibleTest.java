package com.duy;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CompatibleTest extends TestCase {


    public void test() throws IOException {

        String[] unavailableSymbols = new String[]{
                "import java.nio.channels",
                "import java.net",
                "import java.security",
                ".DOUBLE_EPSILON",
                "java.util.UUID",
                "java.util.concurrent.ThreadPoolExecutor",
                "java.util.concurrent.Executors",
                "java.util.concurrent.ExecutorService",
        };

        File sourceDir = new File("../symja_android_library/matheclipse-core/src/main/java");
        assertTrue(sourceDir.exists());
        Collection<File> javaFiles = FileUtils.listFiles(sourceDir, new String[]{"java"}, true);
        for (File javaFile : javaFiles) {
            String content = FileUtils.readFileToString(javaFile);
            for (String unavailablePackage : unavailableSymbols) {
                if (content.contains(unavailablePackage)) {
                    System.err.println("Symbol " + (unavailablePackage) + " is unavailable in class " + javaFile);
                }
            }
        }
    }
}
