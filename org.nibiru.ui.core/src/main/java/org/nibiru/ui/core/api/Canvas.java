package org.nibiru.ui.core.api;

import org.nibiru.ui.core.api.style.Color;

public interface Canvas extends Widget {
    Canvas arc(int x,
               int y,
               int radius,
               double startAngle,
               double endAngle);

    Canvas beginPath();

    Canvas clear();

    Canvas closePath();

    Canvas fill();

    Canvas lineTo(int x,
                  int y);

    Canvas moveTo(int x,
                  int y);

    Canvas rect(int x,
                int y,
                int width,
                int height);

    Canvas setFillStyle(Color color);

    Canvas setLineWidth(int width);

    Canvas setStrokeStyle(Color color);

    Canvas stroke();
}
