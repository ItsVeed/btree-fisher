import actions.*;
import btree.Task;
import btree.composites.Sequence;
import btree.decorators.Inverter;
import com.epicbot.api.shared.GameType;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.LoopScript;
import com.epicbot.api.shared.script.ScriptManifest;
import conditions.*;

import btree.composites.Selector;

import java.util.Arrays;

@ScriptManifest(gameType = GameType.OS, name = "btree-fisher")
public class Main extends LoopScript {

    int spotId = 1528;
    Area area = new Area(3263, 3151, 3272, 3142);

    @Override
    protected int loop() {

        new Sequence(this,

                // If has inventory space move on else deposit at the bank
                new Selector(this,
                        new HasInventorySpace(this),

                        // Bank when inventory is full
                        new Sequence(this,
                            new Inverter(this, new HasInventorySpace(this)),
                            new Sequence(this,
                                new Inverter(this, new BankIsReachable(this)),
                                new WalkToNearestBank(this)
                            ),
                            new Sequence(this,
                                new Inverter(this, new BankIsOpen(this)),
                                new OpenBank(this)
                            ),
                            new DepositInventory(this)
                        )
                ),

                // If in area move on else go to area
                new Selector(this,
                        new InArea(this, area),

                        new Sequence(this,
                                new Inverter(this, new InArea(this, area)),
                                new WalkTo(this, area.getCentralTile())
                        )
                ),

                // If can see object move on else turn camera to object
                new Selector(this,
                        new CanSeeObject(this, spotId),
                        new Sequence(this,
                                new Inverter(this, new CanSeeObject(this, spotId)),
                                new TurnToObject(this, spotId)
                        )
                ),

                // Fishing after all reqs are met
                new ClickObject(this, spotId)


        ).run();

        return 1000;
    }

    @Override
    public boolean onStart(String... strings) {
        System.out.println("Starting btree-fisher");
        return true;
    }
}
