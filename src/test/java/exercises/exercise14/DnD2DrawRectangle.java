package exercises.exercise14;

import java.awt.*;

public class DnD2DrawRectangle implements Action{

    private final Canvas drawingArea;

    public DnD2DrawRectangle(Canvas drawingArea) {
        this.drawingArea = drawingArea;
    }

    public void execute() {
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.press();
        Robot.moveTo(Robot.getRandomPointIn(drawingArea));
        Robot.release();
    }
}
