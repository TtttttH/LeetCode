package com.achui.leetcode.middle.binarytree;

public class Nodel {
    public int val;
    public Nodel left;
    public Nodel right;
    public Nodel next;

    public Nodel() {}

    public Nodel(int _val) {
        val = _val;
    }

    public Nodel(int _val, Nodel _left, Nodel _right, Nodel _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
