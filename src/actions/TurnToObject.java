package actions;

import btree.Task;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.entity.SceneObject;
import com.epicbot.api.shared.script.LoopScript;

public class TurnToObject extends Task {

    int object;
    public TurnToObject(LoopScript script, int object) {
        super(script);
        this.object = object;
    }

    public STATUS run() {
        try {
            NPC obj = ctx.npcs().query().id(object).results().nearest();
            if (obj != null) {
                ctx.camera().turnTo(obj);
            } else {
                return STATUS.FAILED;
            }
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
