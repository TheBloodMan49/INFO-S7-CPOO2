package exercises.exercise14;

import java.awt.*;

public class SelectRectangleMode implements Action {

    private final Canvas canvas;

    public SelectRectangleMode(Canvas canvas) {
        this.canvas = canvas;
    }

    public void execute() {
        canvas.setEditingMode(EditingMode.RECTANGLE);
    }
}
