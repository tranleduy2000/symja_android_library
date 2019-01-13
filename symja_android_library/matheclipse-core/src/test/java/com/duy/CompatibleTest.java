package com.duy;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CompatibleTest extends TestCase {


    public void test() throws IOException {
        String[] unavailablePackages = new String[]{
                java.nio.channels.AlreadyConnectedException.class.getPackage().getName(),
                java.net.URISyntaxException.class.getPackage().getName(),
                java.security.AccessControlException.class.getPackage().getName(),
        };
        File sourceDir = new File("../symja_android_library/matheclipse-core/src/main/java");
        assertTrue(sourceDir.exists());
        Collection<File> javaFiles = FileUtils.listFiles(sourceDir, new String[]{"java"}, true);
        for (File javaFile : javaFiles) {
            String content = FileUtils.readFileToString(javaFile);
            for (String unavailablePackage : unavailablePackages) {
                if (content.contains("import " + unavailablePackage)) {
                    new RuntimeException("Unavailable package " + (unavailablePackage) + " in class " + javaFile.getCanonicalPath()).printStackTrace();
                }
            }
        }
    }
}
