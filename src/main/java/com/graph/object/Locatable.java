package com.graph.object;

import java.awt.*;

public interface Locatable {

//    void locate();

    int getOuterWidth();

    int getInnerWidth();

    int getOuterHeight();

    int getInnerHeight();

    Point getTopLeft();

    Point getOuterTopLeft();

    Point getInnerTopLeft();

    Point getOuterBottomLeft();

    Point getInnerBottomLeft();

    Point getOuterTopRight();

    Point getInnerTopRight();

    Point getOuterBottomRight();

    Point getInnerBottomRight();

    Point getCenter();

    Point getTopLeftByCenterPoint(Point centerPoint);

    Point getTopLeftByCenterCoordinate(double x, double y);

}
