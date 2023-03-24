package conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class IsAnimating extends Task {
    public IsAnimating(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        if (ctx.localPlayer().isAnimating()) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }

    }
}
