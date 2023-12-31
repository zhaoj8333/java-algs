package com.algs.algo.sort.array.cmp_swp;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.CollectionUtil;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: 12/16/22  
class SortDescriptorTest {

    @Test
    void describe() {

        IList<Character> list = FileUtil.readChars(FilePath.TINY);
        Object[] chars = CollectionUtil.toArray(list);
        ArraysUtil.println(chars);
        Character[] array = ArraysUtil.toChars(chars);

        SortDescriptor<Character> cssd = new SortDescriptor<>(array, null);
        int[] describe = cssd.describe();

        ArraysUtil.println(array);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));


    }
}