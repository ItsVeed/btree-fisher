package conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class HasItem extends Task {

    String item;

    public HasItem(LoopScript script, String item) {
        super(script);
        this.item = item;
    }

    public STATUS run() {
        if (item != null && !ctx.inventory().contains(item)) {
            return STATUS.FAILED;
        } else {
            return STATUS.SUCCEEDED;
        }
    }
}
