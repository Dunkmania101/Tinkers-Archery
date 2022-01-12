package tonite.tinkersarchery.data.server;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import tonite.tinkersarchery.TinkersArchery;
import tonite.tinkersarchery.stats.BowAndArrowToolStats;
import tonite.tinkersarchery.tools.BowAndArrowDefinitions;

public class TinkersArcheryToolDefinitions extends AbstractToolDefinitionDataProvider {

    public TinkersArcheryToolDefinitions(DataGenerator generator) {
        super(generator, TinkersArchery.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {
        define(BowAndArrowDefinitions.SHORTBOW)
                //parts
                .part(TinkersArchery.bowshaft)
                .part(TinkersArchery.bowstring)
                .part(TinkersArchery.bowguide)
                //stats
                .multiplier(ToolStats.DURABILITY, 1.1f)
                .stat(ToolStats.DURABILITY, 100)
                .startingSlots(SlotType.UPGRADE, 3)
                .startingSlots(SlotType.ABILITY, 1);

        define(BowAndArrowDefinitions.CROSSBOW)
                //parts
                .part(TinkersArchery.bowshaft)
                .part(TinkersArchery.bowstring)
                .part(TinkersArchery.crossbow_arm)
                //stats
                .multiplier(ToolStats.DURABILITY, 1.3f)
                .stat(ToolStats.DURABILITY, 100)
                .multiplier(BowAndArrowToolStats.ELASTICITY, 1.1f)
                .multiplier(BowAndArrowToolStats.DRAW_SPEED, 0.8f)
                .multiplier(BowAndArrowToolStats.ACCURACY, 0.8f)
                .startingSlots(SlotType.UPGRADE, 3)
                .startingSlots(SlotType.ABILITY, 1);

        define(BowAndArrowDefinitions.LONGBOW)
                //parts
                .part(TinkersArchery.large_bowshaft)
                .part(TinkersArchery.large_bowshaft)
                .part(TinkersArchery.bowstring)
                .part(TinkersArchery.bowguide)
                //stats
                .multiplier(ToolStats.DURABILITY, 2f)
                .stat(ToolStats.DURABILITY, 200)
                .multiplier(BowAndArrowToolStats.ELASTICITY, 1.35f)
                .multiplier(BowAndArrowToolStats.DRAW_SPEED, 0.65f)
                .multiplier(BowAndArrowToolStats.ACCURACY, 1.25f)
                .startingSlots(SlotType.UPGRADE, 2)
                .startingSlots(SlotType.ABILITY, 1)
                // traits
                .trait(TinkerModifiers.twoHanded);

        define(BowAndArrowDefinitions.ARROW)
                //parts
                .part(TinkersArchery.arrowhead)
                .part(TinkersArchery.arrow_shaft)
                .part(TinkersArchery.arrow_fletching)
                //stats
                .stat(ToolStats.ATTACK_DAMAGE, 3.75f)
                .stat(ToolStats.ATTACK_SPEED, 2f)
                .multiplier(ToolStats.ATTACK_DAMAGE, 0.4f)
                .multiplier(ToolStats.MINING_SPEED, 0.75f)
                .startingSlots(SlotType.UPGRADE, 3);
    }

    @Override
    public String getName() {
        return "Tinkers Archery Tool Definitions";
    }
}
