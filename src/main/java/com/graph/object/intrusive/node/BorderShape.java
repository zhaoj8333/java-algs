package com.graph.object.intrusive.node;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Data
@Getter
@Setter
public abstract class BorderShape implements Locatable, Resizable, Shapable {

     protected Point topLeft;
     protected int shapeWidth;
     protected int shapeHeight;
     protected int borderWidth;
     protected int fieldMargin;
     protected Point brushPoint;
     protected Point linkedPoint;

}
