package com.leimly.draw.draw;

import com.leimly.draw.Pen;
import com.leimly.draw.shape.EraserShape;
import com.leimly.draw.impl.PenShape;
import com.leimly.draw.impl.Draw;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Created by lizm on 17-11-30.
 */
public class EraserDraw extends Draw {
    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeEraser = new EraserShape();
        javafx.scene.shape.Shape shape = penShapeEraser.setDraw(p);
        p.setStartX(p.endX);
        p.setStartY(p.endY);
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
