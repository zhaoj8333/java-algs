package com.algs.issues.datastructure.collection.queue;

import com.algs.datastructure.collection.queue.array.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;

import java.io.File;
import java.util.Objects;

public class FileSystemRead {

    public IQueue<String> readRecursively(String path) {
        IQueue<String> files = new ArrayQueueImpl<>();
        File file = new File(path);
        files.enque(file.getAbsolutePath());
        if (file.isDirectory()) {
            readRecursively(file, files);
        }
        return files;
    }

    private void readRecursively(File file, IQueue<String> files) {
        File[] subDirectory = file.listFiles();
        if (Objects.nonNull(subDirectory)) {
            for (File subFile : subDirectory) {
                files.enque(subFile.getAbsolutePath());
                if (subFile.isDirectory()) {
                    readRecursively(subFile, files);
                }
            }
        }
    }

    public IQueue<String> read(String path) {
        IQueue<File> readSequence = new LinkedQueueImpl<>();
        IQueue<String> q = new ArrayQueueImpl<>();
        File file = new File(path);
        if (!file.isDirectory()) {
            q.enque(file.getAbsolutePath());
        } else {
            readSequence.enque(file);
            while (!readSequence.isEmpty()) {
                File dir = readSequence.deque();
                q.enque(dir.getAbsolutePath());
                File[] files = dir.listFiles();
                if (Objects.isNull(files)) {
                    continue;
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        readSequence.enque(f);
                    } else {
                        q.enque(f.getAbsolutePath());
                    }
                }
            }
        }
        return q;
   }
}
