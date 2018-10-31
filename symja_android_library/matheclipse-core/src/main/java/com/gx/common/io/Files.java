/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gx.common.io;

import com.gx.common.annotations.Beta;
import com.gx.common.annotations.GwtIncompatible;
import com.gx.common.base.Optional;
import com.gx.common.base.Predicate;
import com.gx.common.collect.ImmutableSet;
import com.gx.common.collect.TreeTraverser;
import com.gx.common.graph.SuccessorsFunction;
import com.gx.common.graph.Traverser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import static com.gx.common.base.Preconditions.checkNotNull;
import static com.gx.common.io.FileWriteMode.APPEND;

/**
 * Provides utility methods for working with {@linkplain File files}.
 * <p>
 *
 * @author Chris Nokleberg
 * @author Colin Decker
 * @since 1.0
 */
@Beta
@GwtIncompatible
public final class Files {

    /**
     * Maximum loop count when creating temp directories.
     */
    private static final int TEMP_DIR_ATTEMPTS = 10000;
    private static final TreeTraverser<File> FILE_TREE_TRAVERSER =
            new TreeTraverser<File>() {
                @Override
                public Iterable<File> children(File file) {
                    return fileTreeChildren(file);
                }

                @Override
                public String toString() {
                    return "Files.fileTreeTraverser()";
                }
            };
    private static final SuccessorsFunction<File> FILE_TREE =
            new SuccessorsFunction<File>() {
                @Override
                public Iterable<File> successors(File file) {
                    return fileTreeChildren(file);
                }
            };

    private Files() {
    }

    /**
     * Returns a new {@link ByteSource} for reading bytes from the given file.
     *
     * @since 14.0
     */
    public static ByteSource asByteSource(File file) {
        return new FileByteSource(file);
    }

    /**
     * Returns a new {@link ByteSink} for writing bytes to the given file. The given {@code modes}
     * control how the file is opened for writing. When no mode is provided, the file will be
     * truncated before writing. When the {@link FileWriteMode#APPEND APPEND} mode is provided, writes
     * will append to the end of the file without truncating it.
     *
     * @since 14.0
     */
    public static ByteSink asByteSink(File file, FileWriteMode... modes) {
        return new FileByteSink(file, modes);
    }

    /**
     * Returns a new {@link CharSource} for reading character data from the given file using the given
     * character set.
     *
     * @since 14.0
     */
    public static CharSource asCharSource(File file, Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    /**
     * Returns a new {@link CharSink} for writing character data to the given file using the given
     * character set. The given {@code modes} control how the file is opened for writing. When no mode
     * is provided, the file will be truncated before writing. When the {@link FileWriteMode#APPEND
     * APPEND} mode is provided, writes will append to the end of the file without truncating it.
     *
     * @since 14.0
     */
    public static CharSink asCharSink(File file, Charset charset, FileWriteMode... modes) {
        return asByteSink(file, modes).asCharSink(charset);
    }

    /**
     * Reads all bytes from a file into a byte array.
     * <p>
     * <p><b>{@link java.nio.file.Path} equivalent:</b> {@link java.nio.file.Files#readAllBytes}.
     *
     * @param file the file to read from
     * @return a byte array containing all the bytes from file
     * @throws IllegalArgumentException if the file is bigger than the largest possible byte array
     *                                  (2^31 - 1)
     * @throws IOException              if an I/O error occurs
     */
    public static byte[] toByteArray(File file) throws IOException {
        return asByteSource(file).read();
    }

    /**
     * Reads all characters from a file into a {@link String}, using the given character set.
     *
     * @param file    the file to read from
     * @param charset the charset used to decode the input stream; see {@link StandardCharsets} for
     *                helpful predefined constants
     * @return a string containing all the characters from the file
     * @throws IOException if an I/O error occurs
     * @deprecated Prefer {@code asCharSource(file, charset).read()}. This method is scheduled to be
     * removed in January 2019.
     */
    @Deprecated
    public static String toString(File file, Charset charset) throws IOException {
        return asCharSource(file, charset).read();
    }

    /**
     * Overwrites a file with the contents of a byte array.
     * <p>
     * <p><b>{@link java.nio.file.Path} equivalent:</b> {@link
     * java.nio.file.Files#write(java.nio.file.Path, byte[], java.nio.file.OpenOption...)}.
     *
     * @param from the bytes to write
     * @param to   the destination file
     * @throws IOException if an I/O error occurs
     */
    public static void write(byte[] from, File to) throws IOException {
        asByteSink(to).write(from);
    }

    /**
     * Writes a character sequence (such as a string) to a file using the given character set.
     *
     * @param from    the character sequence to write
     * @param to      the destination file
     * @param charset the charset used to encode the output stream; see {@link StandardCharsets} for
     *                helpful predefined constants
     * @throws IOException if an I/O error occurs
     * @deprecated Prefer {@code asCharSink(to, charset).write(from)}. This method is scheduled to be
     * removed in January 2019.
     */
    @Deprecated
    public static void write(CharSequence from, File to, Charset charset) throws IOException {
        asCharSink(to, charset).write(from);
    }

    /**
     * Copies all characters from a file to an appendable object, using the given character set.
     *
     * @param from    the source file
     * @param charset the charset used to decode the input stream; see {@link StandardCharsets} for
     *                helpful predefined constants
     * @param to      the appendable object
     * @throws IOException if an I/O error occurs
     * @deprecated Prefer {@code asCharSource(from, charset).copyTo(to)}. This method is scheduled to
     * be removed in January 2019.
     */
    @Deprecated
    public static void copy(File from, Charset charset, Appendable to) throws IOException {
        asCharSource(from, charset).copyTo(to);
    }

    /**
     * Appends a character sequence (such as a string) to a file using the given character set.
     *
     * @param from    the character sequence to append
     * @param to      the destination file
     * @param charset the charset used to encode the output stream; see {@link StandardCharsets} for
     *                helpful predefined constants
     * @throws IOException if an I/O error occurs
     * @deprecated Prefer {@code asCharSink(to, charset, FileWriteMode.APPEND).write(from)}. This
     * method is scheduled to be removed in January 2019.
     */
    @Deprecated
    public static void append(CharSequence from, File to, Charset charset) throws IOException {
        asCharSink(to, charset, FileWriteMode.APPEND).write(from);
    }

    /**
     * Returns true if the given files exist, are not directories, and contain the same bytes.
     *
     * @throws IOException if an I/O error occurs
     */
    public static boolean equal(File file1, File file2) throws IOException {
        checkNotNull(file1);
        checkNotNull(file2);
        if (file1 == file2 || file1.equals(file2)) {
            return true;
        }

        /*
         * Some operating systems may return zero as the length for files denoting system-dependent
         * entities such as devices or pipes, in which case we must fall back on comparing the bytes
         * directly.
         */
        long len1 = file1.length();
        long len2 = file2.length();
        if (len1 != 0 && len2 != 0 && len1 != len2) {
            return false;
        }
        return asByteSource(file1).contentEquals(asByteSource(file2));
    }

    /**
     * Atomically creates a new directory somewhere beneath the system's temporary directory (as
     * defined by the {@code java.io.tmpdir} system property), and returns its name.
     * <p>
     * <p>Use this method instead of {@link File#createTempFile(String, String)} when you wish to
     * create a directory, not a regular file. A common pitfall is to call {@code createTempFile},
     * delete the file and create a directory in its place, but this leads a race condition which can
     * be exploited to create security vulnerabilities, especially when executable files are to be
     * written into the directory.
     * <p>
     * <p>This method assumes that the temporary volume is writable, has free inodes and free blocks,
     * and that it will not be called thousands of times per second.
     * <p>
     * <p><b>{@link java.nio.file.Path} equivalent:</b> {@link
     * java.nio.file.Files#createTempDirectory}.
     *
     * @return the newly-created directory
     * @throws IllegalStateException if the directory could not be created
     */
    public static File createTempDir() {
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        String baseName = System.currentTimeMillis() + "-";

        for (int counter = 0; counter < TEMP_DIR_ATTEMPTS; counter++) {
            File tempDir = new File(baseDir, baseName + counter);
            if (tempDir.mkdir()) {
                return tempDir;
            }
        }
        throw new IllegalStateException(
                "Failed to create directory within "
                        + TEMP_DIR_ATTEMPTS
                        + " attempts (tried "
                        + baseName
                        + "0 to "
                        + baseName
                        + (TEMP_DIR_ATTEMPTS - 1)
                        + ')');
    }

    /**
     * Creates an empty file or updates the last updated timestamp on the same as the unix command of
     * the same name.
     *
     * @param file the file to create or update
     * @throws IOException if an I/O error occurs
     */
    public static void touch(File file) throws IOException {
        checkNotNull(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to update modification time of " + file);
        }
    }

    /**
     * Creates any necessary but nonexistent parent directories of the specified file. Note that if
     * this operation fails it may have succeeded in creating some (but not all) of the necessary
     * parent directories.
     *
     * @throws IOException if an I/O error occurs, or if any necessary but nonexistent parent
     *                     directories of the specified file could not be created.
     * @since 4.0
     */
    public static void createParentDirs(File file) throws IOException {
        checkNotNull(file);
        File parent = file.getCanonicalFile().getParentFile();
        if (parent == null) {
            /*
             * The given directory is a filesystem root. All zero of its ancestors exist. This doesn't
             * mean that the root itself exists -- consider x:\ on a Windows machine without such a drive
             * -- or even that the caller can create it, but this method makes no such guarantees even for
             * non-root files.
             */
            return;
        }
        parent.mkdirs();
        if (!parent.isDirectory()) {
            throw new IOException("Unable to create parent directories of " + file);
        }
    }

    /**
     * Returns the file name without its <a
     * href="http://en.wikipedia.org/wiki/Filename_extension">file extension</a> or path. This is
     * similar to the {@code basename} unix command. The result does not include the '{@code .}'.
     *
     * @param file The name of the file to trim the extension from. This can be either a fully
     *             qualified file name (including a path) or just a file name.
     * @return The file name without its path or extension.
     * @since 14.0
     */
    public static String getNameWithoutExtension(String file) {
        checkNotNull(file);
        String fileName = new File(file).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }

    /**
     * Returns a {@link TreeTraverser} instance for {@link File} trees.
     * <p>
     * <p><b>Warning:</b> {@code File} provides no support for symbolic links, and as such there is no
     * way to ensure that a symbolic link to a directory is not followed when traversing the tree. In
     * this case, iterables created by this traverser could contain files that are outside of the
     * given directory or even be infinite if there is a symbolic link loop.
     *
     * @since 15.0
     * @deprecated The returned {@link TreeTraverser} type is deprecated. Use the replacement method
     * {@link #fileTraverser()} instead with the same semantics as this method.
     */
    @Deprecated
    static TreeTraverser<File> fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    /**
     * Returns a {@link Traverser} instance for the file and directory tree. The returned traverser
     * starts from a {@link File} and will return all files and directories it encounters.
     * <p>
     * <p><b>Warning:</b> {@code File} provides no support for symbolic links, and as such there is no
     * way to ensure that a symbolic link to a directory is not followed when traversing the tree. In
     * this case, iterables created by this traverser could contain files that are outside of the
     * given directory or even be infinite if there is a symbolic link loop.
     * <p>
     * <p>If available, consider using {@link MoreFiles#fileTraverser()} instead. It behaves the same
     * except that it doesn't follow symbolic links and returns {@code Path} instances.
     * <p>
     * <p>If the {@link File} passed to one of the {@link Traverser} methods does not exist or is not
     * a directory, no exception will be thrown and the returned {@link Iterable} will contain a
     * single element: that file.
     * <p>
     * <p>Example: {@code Files.fileTraverser().breadthFirst("/")} may return files with the following
     * paths: {@code ["/", "/etc", "/home", "/usr", "/etc/config.txt", "/etc/fonts", ...]}
     *
     * @since 23.5
     */
    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    private static Iterable<File> fileTreeChildren(File file) {
        // check isDirectory() just because it may be faster than listFiles() on a non-directory
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                return Collections.unmodifiableList(Arrays.asList(files));
            }
        }

        return Collections.emptyList();
    }

    /**
     * Returns a predicate that returns the result of {@link File#isDirectory} on input files.
     *
     * @since 15.0
     */
    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    /**
     * Returns a predicate that returns the result of {@link File#isFile} on input files.
     *
     * @since 15.0
     */
    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }

    private enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY {
            @Override
            public boolean apply(File file) {
                return file.isDirectory();
            }

            @Override
            public String toString() {
                return "Files.isDirectory()";
            }
        },

        IS_FILE {
            @Override
            public boolean apply(File file) {
                return file.isFile();
            }

            @Override
            public String toString() {
                return "Files.isFile()";
            }
        }
    }

    private static final class FileByteSource extends ByteSource {

        private final File file;

        private FileByteSource(File file) {
            this.file = checkNotNull(file);
        }

        @Override
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(file);
        }

        @Override
        public Optional<Long> sizeIfKnown() {
            if (file.isFile()) {
                return Optional.of(file.length());
            } else {
                return Optional.absent();
            }
        }

        @Override
        public long size() throws IOException {
            if (!file.isFile()) {
                throw new FileNotFoundException(file.toString());
            }
            return file.length();
        }

        @Override
        public byte[] read() throws IOException {
            Closer closer = Closer.create();
            try {
                FileInputStream in = closer.register(openStream());
                return ByteStreams.toByteArray(in, in.getChannel().size());
            } catch (Throwable e) {
                throw closer.rethrow(e);
            } finally {
                closer.close();
            }
        }

        @Override
        public String toString() {
            return "Files.asByteSource(" + file + ")";
        }
    }

    private static final class FileByteSink extends ByteSink {

        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        private FileByteSink(File file, FileWriteMode... modes) {
            this.file = checkNotNull(file);
            this.modes = ImmutableSet.copyOf(modes);
        }

        @Override
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(file, modes.contains(APPEND));
        }

        @Override
        public String toString() {
            return "Files.asByteSink(" + file + ", " + modes + ")";
        }
    }
}
