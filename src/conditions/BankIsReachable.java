package conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class BankIsReachable extends Task {
    public BankIsReachable(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        if (ctx.bank().isReachable()) {
            return STATUS.SUCCEEDED;
        }

        return STATUS.FAILED;
    }
}
