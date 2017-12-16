package com.leimly.draw.draw;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.Draw;
import com.leimly.draw.impl.PenShape;
import com.leimly.draw.shape.TextShape;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;

/**
 * Created by lizm on 17-11-30.
 */
public class TextDraw extends Draw{
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeText = new TextShape();
        Shape shape = penShapeText.setDraw(p);

        group.getChildren().add(shape);


        return null;
    }
}
