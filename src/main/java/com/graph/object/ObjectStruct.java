package com.graph.object;

import com.graph.object.intrusive.node.BorderShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ObjectStruct {

    public String text;
    public boolean isLink;
    protected Object objectRefer;
    protected BorderShape shape;
    protected ObjectStruct parent;
    protected List<ObjectStruct> children;

    public ObjectStruct(Object thiz, ObjectStruct parent) {
        this.isLink = false;
        this.parent = parent;
        this.objectRefer = thiz;
    }

    public boolean isRoot() {
        return Objects.isNull(parent);
    }

    public boolean isNull() {
        return Objects.isNull(objectRefer);
    }

    public Object getObjectRefer() {
        return objectRefer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLink() {
        return isLink;
    }

    public void setLink(boolean link) {
        isLink = link;
    }

    public List<ObjectStruct> getChildren() {
        if (Objects.isNull(children)) {
            children = new ArrayList<>();
        }
        return children;
    }

    public boolean hasChildren() {
        return Objects.nonNull(children) && children.size() > 0;
    }

    public ObjectStruct getParent() {
        return parent;
    }

    public void clear() {
        this.children.clear();
        this.children = null;
    }

    abstract ObjectStruct addChild(Object child);
    abstract void prepareStruct();
    abstract void prepareShape();

}
