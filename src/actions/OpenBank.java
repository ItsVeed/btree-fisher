package actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class OpenBank extends Task {
    public OpenBank(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        try {
            ctx.bank().open();
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
