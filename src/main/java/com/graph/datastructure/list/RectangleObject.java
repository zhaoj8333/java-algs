package com.graph.datastructure.list;

import com.algs.util.GraphicsUtil;

import java.awt.*;

public class RectangleObject extends ShapeWithBorder {

    public RectangleObject(Point topLeft) {
        this.topLeft = topLeft;
        this.brushPoint = topLeft;
    }

    public RectangleObject(boolean isPointer) {
        Point center = new Point(GraphicsUtil.screen.width >> 1, GraphicsUtil.screen.height >> 1);
        topLeft = getTopLeftByCenterPoint(center);
        shapeWidth  = GraphConstants.RECTANGLE_WIDTH;
        shapeHeight = GraphConstants.RECTANGLE_HEIGHT;
        this.isPointer = isPointer;
    }

    @Override
    public int getOuterWidth() {
        return shapeWidth + borderWidth;
    }

    @Override
    public int getInnerWidth() {
        return shapeWidth - borderWidth;
    }

    @Override
    public int getOuterHeight() {
        return shapeHeight + borderWidth;
    }

    @Override
    public int getInnerHeight() {
        return shapeHeight - borderWidth;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    @Override
    public Point getOuterTopLeft() {
        Point point = new Point();
        point.setLocation(topLeft.getX() - (borderWidth >> 1), topLeft.getY() - (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getInnerTopLeft() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + (borderWidth >> 1), topLeft.getY() + (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getOuterBottomLeft() {
        Point point = new Point();
        point.setLocation(topLeft.getX() - (borderWidth >> 1), topLeft.getY() + shapeHeight + (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getInnerBottomLeft() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + (borderWidth >> 1), topLeft.getY() + shapeHeight - (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getOuterTopRight() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + shapeWidth + (borderWidth >> 1), topLeft.getY() - (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getInnerTopRight() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + shapeWidth - (borderWidth >> 1), topLeft.getY() + (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getOuterBottomRight() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + shapeWidth + (borderWidth >> 1), topLeft.getY() + shapeHeight + (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getInnerBottomRight() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + shapeWidth - (borderWidth >> 1), topLeft.getY() + shapeHeight - (borderWidth >> 1));
        return point;
    }

    @Override
    public Point getCenter() {
        Point point = new Point();
        point.setLocation(topLeft.getX() + (shapeWidth >> 1), topLeft.getY() + (shapeHeight >> 1));
        return point;
    }

    @Override
    public Point getTopLeftByCenterPoint(Point centerPoint) {
        Point point = new Point();
        point.setLocation(centerPoint.getX() - (shapeWidth >> 1), centerPoint.getY() - (shapeHeight >> 1));
        return point;
    }

    @Override
    public Point getTopLeftByCenterCoordinate(double x, double y) {
        Point point = new Point();
        point.setLocation(x - (shapeWidth >> 1), y - (shapeHeight >> 1));
        return point;
    }

}
