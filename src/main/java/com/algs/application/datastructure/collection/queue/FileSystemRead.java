package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.LinkedListQueueImpl;

import java.io.File;
import java.util.Objects;

public class FileSystemRead {

    public IQueue<String> read(String path) {
        IQueue<String> files = new LinkedListQueueImpl<>();
        File file = new File(path);
        if (file.isDirectory()) {
            read(file, files);
        } else {
            files.enque(file.getAbsolutePath());
        }
        return files;
    }

    private void read(File file, IQueue<String> files) {
        files.enque(file.getAbsolutePath());
        File[] subDirectory = file.listFiles();
        if (Objects.nonNull(subDirectory)) {
            for (File subFile : subDirectory) {
                files.enque(subFile.getAbsolutePath());
                if (subFile.isDirectory()) {
                    read(subFile, files);
                }
            }
        }
    }

}
