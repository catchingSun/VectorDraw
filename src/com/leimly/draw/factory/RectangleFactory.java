package com.leimly.draw.factory;

import com.leimly.draw.Pen;
import com.leimly.draw.draw.RectangleDraw;
import com.leimly.draw.impl.Draw;
import com.leimly.draw.impl.Factory;

/**
 * Created by lizm on 17-11-30.
 */
public class RectangleFactory implements Factory {
    @Override
    public Draw createPen(Pen p) {
        return new RectangleDraw();
    }
}
