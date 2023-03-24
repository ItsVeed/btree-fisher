package conditions;

import btree.Task;
import com.epicbot.api.shared.entity.SceneObject;
import com.epicbot.api.shared.script.LoopScript;

public class CanSeeObject extends Task {

    int object;

    public CanSeeObject(LoopScript script, int object) {
        super(script);
        this.object = object;
    }

    public STATUS run() {
        SceneObject obj = ctx.objects().query().id(object).results().nearest();
        if (obj != null) {
            if (obj.isVisible()) {
                return STATUS.SUCCEEDED;
            } else {
                return STATUS.FAILED;
            }
        } else {
            return STATUS.FAILED;
        }
    }
}
