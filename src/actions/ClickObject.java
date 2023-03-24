package actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class ClickObject extends Task {
    int object;

    public ClickObject(LoopScript script, int object) {
        super(script);
        this.object = object;
    }

    public STATUS run() {
        try {
            ctx.objects().query().id(object).results().nearest().interact();
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
