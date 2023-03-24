package actions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class DepositInventory extends Task {
    public DepositInventory(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        try {
            ctx.bank().depositInventory();
        } catch (Exception e) {
            return STATUS.FAILED;
        }

        return STATUS.SUCCEEDED;
    }
}
