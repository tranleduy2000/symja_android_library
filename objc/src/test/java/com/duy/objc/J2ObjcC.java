package com.duy.objc;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class J2ObjcC extends TestCase {

    public void test() throws IOException {
        clean();
        copySrc();
        runCommandConvertJavaToObjC();
    }


    private void clean() throws IOException {
        System.out.println("J2ObjcC.clean");
        FileUtils.deleteDirectory(getBuildDir());
    }

    private void copySrc() throws IOException {
        System.out.println("J2ObjcC.copySrc");
        File srcDir = new File("../symja_android_library/matheclipse-core/src/main/java");
        File destDir = getSourcePath();
        FileUtils.copyDirectory(srcDir, destDir);
    }

    private File getSourcePath() throws IOException {
        return new File(getBuildDir(), "java");
    }

    private File getBuildDir() throws IOException {
        File dir = new File("./build/output");
        dir.mkdirs();
        return dir.getCanonicalFile();
    }

    private void runCommandConvertJavaToObjC() throws IOException {
        System.out.println("J2ObjcC.runCommandConvertJavaToObjC");

        File j2objcProgram = new File("/Users/duy/github/j2objc-2.2/j2objc");
        assertTrue(j2objcProgram.exists());
        assertTrue(j2objcProgram.isFile());
        assertTrue(j2objcProgram.setExecutable(true, true));

        File outputDir = new File(getBuildDir(), "objc");
        outputDir.mkdirs();

        ArrayList<String> args = new ArrayList<>(
                Arrays.asList(j2objcProgram.getCanonicalPath(),
                        "-d", outputDir.getCanonicalPath(),
                        "-sourcepath", getSourcePath().getCanonicalPath()));

        for (String s : getSourceFiles()) {
            ArrayList<String> cloneArg = new ArrayList<>(args);
            cloneArg.add(s);
            Runtime.getRuntime().exec(cloneArg.toArray(new String[cloneArg.size()]));

        }
    }

    private ArrayList<String> getSourceFiles() throws IOException {
        Collection<File> files = FileUtils.listFiles(getSourcePath(), new String[]{"java"}, true);
        ArrayList<String> paths = new ArrayList<>();
        for (File file : files) {
            paths.add(file.getAbsolutePath());
        }
        return paths;
    }

}
