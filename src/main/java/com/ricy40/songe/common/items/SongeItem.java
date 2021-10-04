package com.ricy40.songe.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class SongeItem extends Item {

    public SongeItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("Healthy but Creepers? You'll find out in a second..."));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.songe.hold_shift"));
        }
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!playerIn.getCooldowns().isOnCooldown(this)) {
            playerIn.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 200, 5));
            CreeperEntity entity = new CreeperEntity(EntityType.CREEPER, worldIn);
            entity.setPos(playerIn.getX(), playerIn.getY(), playerIn.getZ());
            worldIn.addFreshEntity(entity);
            playerIn.getCooldowns().addCooldown(this, 100);
        }
        return ActionResult.fail(playerIn.getMainHandItem());
    }


}
