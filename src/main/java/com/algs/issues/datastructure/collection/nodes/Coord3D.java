package com.algs.issues.datastructure.collection.nodes;

import com.algs.utils.RandomUtil;

public class Coord3D implements Comparable<Coord3D> {

    double x, y, z;

    public Coord3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Coord3D that) {
        double thisEuclideanDistance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double thatEuclideanDistance = Math.sqrt(Math.pow(that.x, 2) + Math.pow(that.y, 2) + Math.pow(that.z, 2));
        if (thisEuclideanDistance > thatEuclideanDistance) {
            return 1;
        } else if (thisEuclideanDistance < thatEuclideanDistance) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Coord{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public static Coord3D random(double max) {
        return new Coord3D(
                RandomUtil.uniform(0, max),
                RandomUtil.uniform(0, max),
                RandomUtil.uniform(0, max)
        );
    }
}
