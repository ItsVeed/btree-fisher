package actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;
import com.epicbot.api.shared.util.time.Time;

public class ClickObject extends Task {
    int object;

    public ClickObject(LoopScript script, int object) {
        super(script);
        this.object = object;
    }

    public STATUS run() {
        try {
            ctx.npcs().query().id(object).results().nearest().interact();
            Time.sleep(5_000, () -> ctx.localPlayer().isAnimating());
        } catch (Exception e) {
            System.out.println("Click failed");
            return STATUS.FAILED;
        }

        System.out.println("Click succeeded");
        return STATUS.SUCCEEDED;
    }
}
