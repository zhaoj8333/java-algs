package com.algs.utils.file;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.CollectionUtil;
import com.algs.utils.Connection;

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

    public static IList<Byte> readBytes(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Byte> bytes = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                int len;
                while ((len = isr.read()) != -1) {
                    if (!Objects.equals(len, 32) && !Objects.equals(len, 10)) {
                        bytes.add((byte) len);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return bytes;
    }

    public static IList<Short> readShorts(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Short> shorts = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                int len;
                while ((len = isr.read()) != -1) {
                    if (!Objects.equals(len, 32) && !Objects.equals(len, 10)) {
                        shorts.add((short) len);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return shorts;
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

    public static IList<String> readEnglishWords(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<String> strings = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            LineNumberReader lnr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                lnr = new LineNumberReader(isr);
                String line;
                while ((line = lnr.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        strings.add(word);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return strings;
    }

    public static IList<Long> readLongs(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Long> longs = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            LineNumberReader lnr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                lnr = new LineNumberReader(isr);
                String line;
                while ((line = lnr.readLine()) != null) {
                    longs.add(Long.valueOf(line.trim()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, lnr);
            }
        }
        return longs;
    }

    public static IList<Float> readFloats(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Float> floats = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                int len;
                while ((len = isr.read()) != -1) {
                    if (!Objects.equals(len, 32) && !Objects.equals(len, 10)) {
                        floats.add((float) len);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return floats;
    }

    public static IList<Double> readDoubles(String fileName) {
        File file = getFile(fileName);
        if (file == null) return null;
        IList<Double> doubles = new SinglyLinkedListImpl<>();
        if (file.isFile() && file.exists()) {
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(new FileInputStream(file));
                int len;
                while ((len = isr.read()) != -1) {
                    if (!Objects.equals(len, 32) && !Objects.equals(len, 10)) {
                        doubles.add((double) len);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(isr, null);
            }
        }
        return doubles;
    }

    public static Byte[] readBytesAsArray(String fileName) {
        return CollectionUtil.toByteArray(readBytes(fileName));
    }

    public static String[] readEnglishWordsAsArray(String fileName) {
        return CollectionUtil.toArray(readEnglishWords(fileName));
    }

    public static Short[] readShortsAsArray(String fileName) {
        return CollectionUtil.toShortArray(readShorts(fileName));
    }

    public static Float[] readFloatsAsArray(String fileName) {
        return CollectionUtil.toFloatArray(readFloats(fileName));
    }

    public static Long[] readLongsAsArray(String fileName) {
        return CollectionUtil.toLongArray(readLongs(fileName));
    }

    public static Double[] readDoublesAsArray(String fileName) {
        return CollectionUtil.toDoubleArray(readDoubles(fileName));
    }

    public static Integer[] readIntsAsArray(String fileName) {
        return CollectionUtil.toIntegerArray(readInts(fileName));
    }

    public static Character[] readCharsAsArray(String fileName) {
        return CollectionUtil.toCharArray(readChars(fileName));
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
