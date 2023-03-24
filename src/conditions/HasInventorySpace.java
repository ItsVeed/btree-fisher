package conditions;

import com.epicbot.api.shared.script.LoopScript;
import btree.Task;

import btree.Task.STATUS;

public class HasInventorySpace extends Task {

    public HasInventorySpace(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        if (ctx.inventory().isFull()) {
            return STATUS.FAILED;
        }
        return STATUS.SUCCEEDED;
    }

}
