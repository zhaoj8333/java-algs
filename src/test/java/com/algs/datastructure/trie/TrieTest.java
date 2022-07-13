package com.algs.datastructure.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Trie related algorithms:
 * Double-Array Trie
 * Suffix Tree
 * Patricia Tree
 * Crit-bit Tree
 * AC Automaton
 */
public class TrieTest {

    @Test
    public void testFunctionality() {
        Trie trie = new Trie();

        trie.add("cat");
        trie.add("dog");
        trie.add("catalog");
        trie.add("cast");
        trie.add("assets");
        trie.add("动态");

        Assert.assertEquals(6, trie.size());
        // get
        Assert.assertTrue(Objects.isNull(trie.get("c")));
        Assert.assertTrue(Objects.isNull(trie.get("ca")));
        Assert.assertTrue(Objects.nonNull(trie.get("cat")));
        Assert.assertTrue(Objects.nonNull(trie.get("cast")));
        Assert.assertTrue(Objects.nonNull(trie.get("assets")));
        Assert.assertTrue(Objects.nonNull(trie.get("动态")));

        // startsWith
        Assert.assertTrue(trie.startsWith("c"));
        Assert.assertTrue(trie.startsWith("ca"));
        Assert.assertTrue(trie.startsWith("cat"));
        Assert.assertTrue(trie.startsWith("cata"));
        Assert.assertFalse(trie.startsWith("catai"));
        Assert.assertTrue(trie.startsWith("动"));
//
        trie.remove("cat");
        trie.remove("catalog");
        Assert.assertEquals(4, trie.size());
        Assert.assertFalse(trie.contains("cat"));
        Assert.assertFalse(trie.contains("catalog"));
        Assert.assertTrue(trie.startsWith("cat"));
        Assert.assertTrue(trie.startsWith("cata"));

    }

}
