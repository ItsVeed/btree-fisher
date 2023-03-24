package conditions;


import btree.Task;
import com.epicbot.api.shared.entity.details.Locatable;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.LoopScript;

public class InArea extends Task {

    Area area;

    public InArea(LoopScript script, Area area) {
        super(script);
        this.area = area;
    }

    public STATUS run() {
        if (area.contains(ctx.localPlayer().getLocation())) {
            return STATUS.SUCCEEDED;
        } else {
            return STATUS.FAILED;
        }
    }
}
