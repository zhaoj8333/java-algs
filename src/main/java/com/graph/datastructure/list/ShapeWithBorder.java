package com.graph.datastructure.list;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Data
@Getter
@Setter
public abstract class ShapeWithBorder implements Locatable {

     protected Point topLeft;
     protected int shapeWidth;
     protected int shapeHeight;
     protected int borderWidth;
     protected int fieldMargin;
     protected Point brushPoint;
     protected boolean isPointer;

     abstract int getOuterWidth();

     abstract int getInnerWidth();

     abstract int getOuterHeight();

     abstract int getInnerHeight();

     abstract Point getTopLeft();

     abstract Point getOuterTopLeft();

     abstract Point getInnerTopLeft();

     abstract Point getOuterBottomLeft();

     abstract Point getInnerBottomLeft();

     abstract Point getOuterTopRight();

     abstract Point getInnerTopRight();

     abstract Point getOuterBottomRight();

     abstract Point getInnerBottomRight();

     abstract Point getCenter();

     abstract Point getTopLeftByCenterPoint(Point centerPoint);

     abstract Point getTopLeftByCenterCoordinate(double x, double y);

}
