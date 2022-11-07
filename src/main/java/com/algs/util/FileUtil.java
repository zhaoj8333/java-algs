package com.algs.util;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class FileUtil {

    public static IList<Connection<Integer>> readPairs(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Connection<Integer>> pairs = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            LineNumberReader lnr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                lnr = new LineNumberReader(isr);
                String line;
                while ((line = lnr.readLine()) != null) {
                    if (!line.contains(" ")) {
                        continue;
                    }
                    String[] s = line.split(" ");
                    pairs.add(new Connection<>(Integer.valueOf(s[0]), Integer.valueOf(s[1])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, lnr);
            }
        }
        return pairs;
    }

    public static IList<Integer> readInts(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Integer> ints = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            LineNumberReader lnr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                lnr = new LineNumberReader(isr);
                String line;
                while ((line = lnr.readLine()) != null) {
                    ints.add(Integer.valueOf(line.trim()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, lnr);
            }
        }
        return ints;
    }

    public static IList<Character> readChars(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Character> chars = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                int len;
                while ((len = isr.read()) != -1) {
                    if (!Objects.equals(len, 32) && !Objects.equals(len, 10)) {
                        chars.add((char) len);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return chars;
    }

    private static void close(InputStreamReader isr, LineNumberReader lnr) {
        try {
            if (isr != null) {
                isr.close();
            }
            if (lnr != null) {
                lnr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile(String fileName) {
        URL resource = FileUtil.class.getClassLoader().getResource(fileName);
        if (Objects.isNull(resource)) {
            try {
                throw new FileNotFoundException("File: " + fileName + " not exist");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
        return new File(resource.getFile());
    }


}
