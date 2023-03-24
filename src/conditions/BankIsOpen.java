package conditions;

import btree.Task;
import com.epicbot.api.shared.script.LoopScript;

public class BankIsOpen extends Task {
    public BankIsOpen(LoopScript script) {
        super(script);
    }

    public STATUS run() {
        if (ctx.bank().isOpen()) {
            return STATUS.SUCCEEDED;
        }

        return STATUS.FAILED;
    }
}
