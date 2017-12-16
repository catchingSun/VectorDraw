package com.leimly.draw.impl;

import com.leimly.draw.Pen;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Created by lizm on 17-11-22.
 */
public abstract class Draw {
    public abstract Group creatDraw(Group group, Pen p, AnchorPane drawAnchorPane);
}
