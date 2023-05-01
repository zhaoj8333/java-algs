package com.algs.utils;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;
import java.util.Objects;

public class CollectionUtil<E> {

    public static <E> void println(ICollection<E> collection) {
        System.out.println(toString(collection));
    }

    public static <E> E[] toArray(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        E[] array =  (E[]) new Object[collection.size()];
        int i = 0;
        while (itr.hasNext()) {
            array[i++] = itr.next();
        }
        return array;
    }

    public static <E> String toString(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_BRACE_BRACKET);
        int i = 0;
        while (itr.hasNext()) {
            i++;
            E next = itr.next();
            if (Objects.isNull(next)) {
                sb.append(DefaultValues.NULLVAL);
            } else {
                sb.append(next);
            }
            sb.append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_BRACE_BRACKET);
        return sb.toString();
    }

    public static <E> String[] toStringArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        String[] strs = new String[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            E obj = collection.get(i);
            if (Objects.isNull(obj)) {
                strs[i] = String.valueOf(DefaultValues.NULLVAL);
            } else {
                strs[i] = String.valueOf(obj);
            }
        }
        return strs;
    }

    public static <E> Byte[] toByteArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Character;
        if (!b) {
            throw new ClassCastException("Unable to convert to Character");
        }
        Byte[] bytes = new Byte[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            bytes[i] = (Byte) collection.get(i);
        }
        return bytes;
    }

    public static <E> Short[] toShortArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Character;
        if (!b) {
            throw new ClassCastException("Unable to convert to Character");
        }
        Short[] shorts = new Short[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            shorts[i] = (Short) collection.get(i);
        }
        return shorts;
    }

    public static <E> Character[] toCharArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Character;
        if (!b) {
            throw new ClassCastException("Unable to convert to Character");
        }
        Character[] chars = new Character[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            chars[i] = (Character) collection.get(i);
        }
        return chars;
    }

    public static <E> Integer[] toIntegerArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Integer;
        if (!b) {
            throw new ClassCastException("Unable to convert to Integer");
        }
        Integer[] integers = new Integer[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            integers[i] = (Integer) collection.get(i);
        }
        return integers;
    }

    public static <E> Float[] toFloatArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Float;
        if (!b) {
            throw new ClassCastException("Unable to convert to Float");
        }
        Float[] floats = new Float[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            floats[i] = (Float) collection.get(i);
        }
        return floats;
    }

    public static <E> Double[] toDoubleArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Double;
        if (!b) {
            throw new ClassCastException("Unable to convert to Double");
        }
        Double[] doubles = new Double[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            doubles[i] = (Double) collection.get(i);
        }
        return doubles;
    }

    public static <E> Long[] toLongArray(ICollection<E> collection) {
        ObjectUtil.requireNonNull(collection);
        ObjectUtil.requireNonEmpty(collection);
        boolean b = collection.get(0) instanceof Long;
        if (!b) {
            throw new ClassCastException("Unable to convert to Long");
        }
        Long[] longs = new Long[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            longs[i] = (Long) collection.get(i);
        }
        return longs;
    }

}
