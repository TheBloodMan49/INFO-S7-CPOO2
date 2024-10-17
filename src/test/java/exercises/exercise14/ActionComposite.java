package exercises.exercise14;

import java.util.List;

public class ActionComposite implements Action {
    private final List<Action> actions;

    public ActionComposite(Action... actions) {
        this.actions = List.of(actions);
    }

    public void execute() {
        for (Action action : actions) {
            action.execute();
        }
    }
}
