package com.algs.algo.unionfind.non_generic;

import com.algs.util.Connection;
import com.algs.util.DrawUtil;

/**
 * // TODO: 10/14/22
 *
 * 1.5.19
 */
public class RandomGridGeneratorGraph {

    public static void main(String[] args) throws InterruptedException {
        Object[] conns = RandomGridGenerator.get(7);

        DrawUtil.setXscale(0, conns.length + 30);
        DrawUtil.setYscale(0, conns.length + 30);
        DrawUtil.setPenRadius(0.005);

        for (Object conn : conns) {
            Connection connection = (Connection) conn;
            DrawUtil.point((int) connection.a, (int) connection.b);
            Thread.sleep(10);
        }
    }

}
