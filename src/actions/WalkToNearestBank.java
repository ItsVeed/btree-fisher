package actions;

import btree.Task;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.script.LoopScript;

public class WalkToNearestBank extends Task {

    public WalkToNearestBank(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        try {
            ctx.webWalking().walkToBank();
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
