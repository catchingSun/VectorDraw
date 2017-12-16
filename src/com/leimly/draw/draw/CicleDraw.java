package com.leimly.draw.draw;

import com.leimly.draw.Pen;
import com.leimly.draw.shape.CicleShape;
import com.leimly.draw.impl.PenShape;
import com.leimly.draw.impl.Draw;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Created by lizm on 17-11-30.
 */
public class CicleDraw extends Draw {

    public Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane) {
        PenShape penShapeCicle = new CicleShape();
        javafx.scene.shape.Shape shape = penShapeCicle.setDraw(p);
        group.getChildren().clear();
        group.getChildren().add(shape);
        drawAnchorPane.getChildren().remove(group);
        drawAnchorPane.getChildren().add(group);
        return group;
    }
}
