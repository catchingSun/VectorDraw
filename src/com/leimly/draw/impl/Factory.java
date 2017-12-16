package com.leimly.draw.impl;

import com.leimly.draw.Pen;
import javafx.scene.shape.Shape;

/**
 * Created by lizm on 17-11-22.
 */
public interface Factory {
    Draw createPen(Pen p);
}
