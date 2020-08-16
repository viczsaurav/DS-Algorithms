package general.findDuplicateFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 *
 * https://www.interviewcake.com/question/java/find-duplicate-files
 *
 * Some ideas for further improvements:
 * 1.   If a file wasn't last edited around the time your friend got a hold of your computer, you know it probably
 *      wasn't created by your friend. Similarly, if a file wasn't accessed (sometimes your filesystem stores the last
 *      accessed time for a file as well) around that time, you know it wasn't copied by your friend. You can use these
 *      facts to skip some files.
 * 2.   Make the file size the fingerprint—it should be available cheaply as metadata on the file (so you don't need
 *      to walk through the whole file to see how long it is). You'll get lots of false positives, but that's fine if
 *      you treat this as a "preprocessing" step. Maybe you then take hash-based fingerprints only on the files which
 *      have matching sizes. Then you fully compare file contents if they have the same hash.
 * 3.   Some file systems also keep track of when a file was created. If your filesystem supports this, you could use
 *      this as a potentially-stronger heuristic for telling which of two copies of a file is the dupe.
 * 4.   When you do compare full file contents to ensure two files are the same, no need to read the entire files into
 *      memory. Open both files and read them one block at a time. You can short-circuit as soon as you find two blocks
 *      that don't match, and you only ever need to store a couple blocks in memory.
 *
 * Bonus:
 * 1.   If we wanted to get this code ready for a production system, we might want to make it a bit more modular.
 *      Try separating the file traversal code from the duplicate detection code.
 *
 * 2.   What about concurrency? Can we go faster by splitting this procedure into multiple threads? Also, what
 *      if a background process edits a file while our script is running? Will this cause problems?
 *
 * 3.   What about link files (files that point to other files or folders)? One gotcha here is that a link file can
 *      point back up the file tree. How do we keep our file traversal from going in circles?
 */
public class duplicateFiles {
    public static class FilePaths {
        private Path duplicatePath;
        private Path originalPath;

        public FilePaths(Path duplicatePath, Path originalPath) {
            this.duplicatePath = duplicatePath;
            this.originalPath  = originalPath;
        }

        public Path getDuplicatePath() {
            return duplicatePath;
        }

        public Path getOriginalPath() {
            return originalPath;
        }

        @Override
        public String toString() {
            return String.format("(duplicate: %s, original: %s)", duplicatePath, originalPath);
        }
    }

    private static class FileInfo {

        long timeLastEdited;
        Path path;

        FileInfo(long timeLastEdited, Path path) {
            this.timeLastEdited = timeLastEdited;
            this.path = path;
        }
    }

    public static List<FilePaths> findDuplicateFiles(Path startingDirectory) {
        Map<String, FileInfo> filesSeenAlready = new HashMap<>();
        Deque<Path> stack = new ArrayDeque<>();
        stack.push(startingDirectory);

        List<FilePaths> duplicates = new ArrayList<>();

        while (!stack.isEmpty()) {

            Path currentPath = stack.pop();
            File currentFile = new File(currentPath.toString());

            // if it's a directory,
            // put the contents in our stack
            if (currentFile.isDirectory()) {
                for (File file : currentFile.listFiles()) {
                    stack.push(file.toPath());
                }

                // if it's a file
            } else {

                // get its hash
                String fileHash;
                try {
                    fileHash = utils.sampleHashFile(currentPath);
                } catch (IOException | NoSuchAlgorithmException e) {

                    // show error and skip this file
                    e.printStackTrace();
                    continue;
                }

                // get its last edited time
                long currentLastEditedTime = currentFile.lastModified();

                // if we've seen it before
                if (filesSeenAlready.containsKey(fileHash)) {

                    FileInfo fileInfo = filesSeenAlready.get(fileHash);
                    long existingLastEditedTime = fileInfo.timeLastEdited;
                    Path existingPath = fileInfo.path;

                    if (currentLastEditedTime > existingLastEditedTime) {

                        // current file is the dupe!
                        duplicates.add(new FilePaths(currentPath, existingPath));

                    } else {

                        // old file is the dupe!
                        duplicates.add(new FilePaths(existingPath, currentPath));

                        // but also update filesSeenAlready to have the new file's info
                        filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
                    }

                    // if it's a new file, throw it in filesSeenAlready
                    // and record its path and last edited time,
                    // so we can tell later if it's a dupe
                } else {
                    filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
                }
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        Path start = Path.of("/Users/saurav/Desktop");
        List<FilePaths> files =  findDuplicateFiles(start);

        for (FilePaths file : files) {
            System.out.println(file.toString());
        }
    }
}
