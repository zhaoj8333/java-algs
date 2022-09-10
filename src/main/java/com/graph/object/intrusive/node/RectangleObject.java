package com.graph.object.intrusive.node;

import com.graph.object.AlgoWindow;
import com.graph.object.GraphConstants;

import java.awt.*;

public class RectangleObject extends BorderShape {

    public RectangleObject() {
        this.shapeWidth  = GraphConstants.RECTANGLE_WIDTH;
        this.shapeHeight = GraphConstants.RECTANGLE_HEIGHT;
        this.borderWidth = GraphConstants.RECTANGLE_BOARDER_WIDTH;
        Point center = new Point(AlgoWindow.dimension.width >> 1, (int) (AlgoWindow.dimension.height * 0.3));
        this.topLeft = getTopLeftByCenterPoint(center);
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

    @Override
    public void toShape(Graphics2D g) {
        BasicStroke stroke = new BasicStroke(borderWidth, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
        g.setStroke(stroke);
        g.drawRect(topLeft.x, topLeft.y, shapeWidth, shapeHeight);
        g.fillRect(topLeft.x, topLeft.y, shapeWidth, shapeHeight);
    }

    @Override
    public String toString() {
        return "RectangleObject" + topLeft;
    }

    @Override
    public void resize(Graphics2D g) {

    }

    @Override
    public void move(Graphics2D g) {

    }
}
