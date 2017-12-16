package com.leimly.draw.draw;

import com.leimly.draw.Pen;
import com.leimly.draw.shape.LineShape;
import com.leimly.draw.impl.PenShape;
import com.leimly.draw.impl.Draw;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Created by lizm on 17-11-30.
 */
public class LineDraw extends Draw {

    @Override
    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeLine = new LineShape();
        javafx.scene.shape.Shape shape = penShapeLine.setDraw(p);

        group.getChildren().clear();
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
