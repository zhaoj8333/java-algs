package com.graph.object;

import com.algs.util.GraphicsUtil;
import com.algs.util.ObjectUtil;
import com.graph.object.intrusive.node.BorderShape;

import java.awt.*;

public class ObjectDrawer {

    protected final Object dataObject;
    protected ObjectStruct objectStruct;
    protected BorderShape shape;
    protected Graphics2D g;

    public ObjectDrawer(Object dataObject) {
        this.dataObject = dataObject;
    }

    public void setG(Graphics2D g) {
        this.g = g;
    }

    public final void prepare() {
        ObjectUtil.requireNonNull(g);
        objectStruct = new ObjectStructImpl(dataObject, null);
        objectStruct.prepareStruct();
        objectStruct.prepareShape();

    }

    public final void draw() {

        GraphicsUtil.drawCoordinateSystem(g);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        prepare();
//        locateByLine();



    }

    public void locateByLine() {
        int outerWidth = shape.getOuterWidth();
        int innerWidth = shape.getInnerWidth();
        Point topLeft = shape.getOuterTopLeft();
        Point innerTopLeft = shape.getInnerTopLeft();
        g.drawLine(topLeft.x, topLeft.y, topLeft.x + outerWidth - 1, topLeft.y);

        g.drawLine(innerTopLeft.x, innerTopLeft.y, innerTopLeft.x + innerWidth - 1, innerTopLeft.y);

        int outerHeight = shape.getOuterHeight();
        int innerHeight = shape.getInnerHeight();
        g.drawLine(topLeft.x, topLeft.y, topLeft.x, topLeft.y + outerHeight - 1);
        g.drawLine(innerTopLeft.x, innerTopLeft.y, innerTopLeft.x, innerTopLeft.y + innerHeight - 1);
    }

}
