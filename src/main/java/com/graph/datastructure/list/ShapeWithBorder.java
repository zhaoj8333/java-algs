package com.graph.datastructure.list;

import com.graph.object.Drawable;
import com.graph.object.Locatable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Data
@Getter
@Setter
public abstract class ShapeWithBorder implements Locatable, Drawable {

     protected Point topLeft;
     protected int shapeWidth;
     protected int shapeHeight;
     protected int borderWidth;
     protected int fieldMargin;
     protected Point brushPoint;
     protected Point linkedPoint;

}
