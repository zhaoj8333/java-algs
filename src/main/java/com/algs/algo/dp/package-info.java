package com.algs.algo.dp;

/**
 * 什么样的暴力递归可以优化：
 *  出现重复解的暴力递归
 *  如果没有重复解，也就是说所有子问题的解都是不同的，是不能优化的
 *  暴力递归优化的目的是为了防止重复计算，直接将计算结果缓存起来，后续计算直接拿即可
 */