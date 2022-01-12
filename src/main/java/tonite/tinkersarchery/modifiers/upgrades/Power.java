package tonite.tinkersarchery.modifiers.upgrades;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import tonite.tinkersarchery.library.modifier.IBowModifier;
import tonite.tinkersarchery.library.projectileinterfaces.IDamageProjectile;

public class Power extends IncrementalModifier implements IBowModifier {
    public Power() {
        super(0xEAE5DE);
    }

    @Override
    public ITextComponent getDisplayName(int level) {
        // displays special names for levels of haste
        if (level <= 5) {
            return applyStyle(new TranslationTextComponent(getTranslationKey() + "." + level));
        }
        return super.getDisplayName(level);
    }

    @Override
    public void onArrowShot(IModifierToolStack tool, int level, ProjectileEntity arrow, float drawPortion, float power, World world, LivingEntity shooter) {
        float scaledLevel = getScaledLevel(tool.getPersistentData(), level);

        if (arrow instanceof IDamageProjectile) {
            ((IDamageProjectile)arrow).setDamage(((IDamageProjectile)arrow).getDamage() + 0.5f + 0.5f * scaledLevel);
        } else if (arrow instanceof AbstractArrowEntity) {
            ((AbstractArrowEntity)arrow).setBaseDamage(((AbstractArrowEntity)arrow).getBaseDamage() + 0.5f + 0.5f * scaledLevel);
        }
    }
}
