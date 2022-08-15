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

}
