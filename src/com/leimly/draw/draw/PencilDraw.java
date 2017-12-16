package com.leimly.draw.draw;

import com.leimly.draw.Pen;
import com.leimly.draw.shape.LineShape;
import com.leimly.draw.impl.PenShape;
import com.leimly.draw.impl.Draw;
import com.leimly.draw.shape.PencilShape;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;

/**
 * Created by lizm on 17-11-30.
 */
public class PencilDraw extends Draw {

    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {

        PenShape penShapePencil = new PencilShape();
        Shape shape = penShapePencil.setDraw(p);
        p.setStartX(p.endX);
        p.setStartY(p.endY);
        group.getChildren().add(shape);
        return null;
    }
}
