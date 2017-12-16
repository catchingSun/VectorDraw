package com.leimly.draw.factory;

import com.leimly.draw.Pen;
import com.leimly.draw.draw.PencilDraw;
import com.leimly.draw.impl.Draw;
import com.leimly.draw.impl.Factory;

/**
 * Created by lizm on 17-11-30.
 */
public class PencilFactory implements Factory{
    @Override
    public Draw createPen(Pen p) {
        return new PencilDraw();
    }
}
