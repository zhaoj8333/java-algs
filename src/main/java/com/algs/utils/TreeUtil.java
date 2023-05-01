package com.algs.utils;

import com.algs.DefaultValues;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.itr.BstIterator;
import java.util.Objects;

public class TreeUtil<K extends Comparable<K>, V> {

    // TODO: 4/6/2023  
    public static <K extends Comparable<K>, V> String toString(ITree<K, V> tree) {
        return "";
    }

    public static String emptySerializedTree() {
        return "" + DefaultValues.LEFT_SQUARE_BRACKET + DefaultValues.NULLVAL + DefaultValues.DELIMITER + DefaultValues.RIGHT_SQUARE_BRACKET;
    }

    public static <K extends Comparable<K>, V> boolean equals(ITree<K, V> a, ITree<K, V> b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return false;
        }
        BstIterator<K, V> itrA = (BstIterator<K, V>) a.iterator();
        BstIterator<K, V> itrB = (BstIterator<K, V>) b.iterator();
        try {
            while (itrA.hasNext()) {
                TreeNode<K, V> nodeA = itrA.nextNode();
                TreeNode<K, V> nodeB = itrB.nextNode();
                if (Objects.isNull(nodeA) || Objects.isNull(nodeB)) {
                    return false;
                }
                if (nodeA instanceof BstNode && nodeB instanceof BstNode) {
                    BstNode<K, V> nodea = (BstNode<K, V>) nodeA;
                    BstNode<K, V> nodeb = (BstNode<K, V>) nodeB;
                    if (!nodea.equalsWithoutParent(nodeb)) {
                        return false;
                    }
                } else {
                    return false;
                }
                // if (nodeA instanceof )    // TODO: 4/6/2023  
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
