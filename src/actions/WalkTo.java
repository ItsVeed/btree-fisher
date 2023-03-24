package actions;

import btree.Task;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.script.LoopScript;

public class WalkTo extends Task {

    Tile location;

    public WalkTo(LoopScript script, Tile location) {
        super(script);
        this.location = location;
    }

    public STATUS run() {
        try {
            if (location.distanceTo(ctx) < 15) {
                ctx.walking().walkTo(location);
            } else {
                ctx.webWalking().walkTo(location);
            }
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
