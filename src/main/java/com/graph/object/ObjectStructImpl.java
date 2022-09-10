package com.graph.object;

import com.algs.util.ObjectUtil;
import com.graph.object.intrusive.node.BorderShape;
import com.graph.object.intrusive.node.RectangleObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class ObjectStructImpl extends ObjectStruct {

    public ObjectStructImpl(Object obj, ObjectStruct parent) {
        super(obj, parent);
    }

    @Override
    public ObjectStruct addChild(Object child) {
        ObjectStruct node = new ObjectStructImpl(child, this);
        getChildren().add(0, node);
        return node;
    }

    @Override
    protected void prepareStruct() {
        if (isNull()) {
            setText("null");
            return;
        }
        Class<?> clazz = objectRefer.getClass();
        setText(clazz.getSimpleName());
        setLink(Objects.nonNull(clazz.getClassLoader()));
        while (Objects.nonNull(clazz)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    Method declaredMethod = clazz.getDeclaredMethod(ObjectUtil.getGetterMethodName(field));
                    // field Object
                    Object fieldValue = declaredMethod.invoke(getObjectRefer());
                    Class<?> type = field.getType();
                    ObjectStruct childNode = addChild(fieldValue);
                    if (type.isPrimitive() || Objects.isNull(type.getClassLoader())) {
                        childNode.setLink(false);
                        childNode.setText(field.getName() + " (" + fieldValue.toString() + ")");
                    } else {
                        childNode.setLink(true);
                        childNode.setText(field.getName());
                    }
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    @Override
    protected void prepareShape() {
        shape = new RectangleObject();
        if (isNull()) {
            prepareNullShape();
            return;
        }
        prepareObjectShape();

    }

    private void prepareObjectShape() {
        RectangleObject ro = new RectangleObject();
        ro.setShapeWidth(200);
        ro.setBorderWidth(1);
        int shapeHeight = 0;
        for (ObjectStruct child : this.children) {

        }


    }

    protected void prepareNullShape() {
        BorderShape ro = new RectangleObject();
        ro.setShapeWidth(200);
        ro.setShapeHeight(150);
        ro.setBorderWidth(1);
    }


}
