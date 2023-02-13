package net.soulsweaponry.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.soulsweaponry.config.ConfigConstructor;
import net.soulsweaponry.entity.projectile.LeviathanAxeEntity;
import net.soulsweaponry.registry.EffectRegistry;
import net.soulsweaponry.registry.PacketRegistry;
import net.soulsweaponry.util.ParticleNetworking;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class LeviathanAxe extends AxeItem implements IAnimatable {

    public AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public LeviathanAxe(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, ConfigConstructor.leviathan_axe_damage, attackSpeed, settings);
    }
    
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int sharpness = MathHelper.floor(EnchantmentHelper.getAttackDamage(stack, target.getGroup()));
        target.addStatusEffect(new StatusEffectInstance(EffectRegistry.FREEZING, 200, sharpness));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
        if (user instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)user;
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                stack.damage(3, (LivingEntity)playerEntity, (p_220045_0_) -> {
                    p_220045_0_.sendToolBreakStatus(user.getActiveHand());
                });
        
                LeviathanAxeEntity entity = new LeviathanAxeEntity(world, user, stack);
                int damage = EnchantmentHelper.getLevel(Enchantments.SHARPNESS, stack);
                entity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 1.5F, 1.0F);
                entity.setDamage(ConfigConstructor.leviathan_axe_projectile_damage + damage);
                world.spawnEntity(entity);
                world.playSound(playerEntity, playerEntity.getBlockPos(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1f, .5f);
                playerEntity.getItemCooldownManager().set(this, ConfigConstructor.leviathan_axe_throw_cooldown - damage*30);
            }
        }
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
            return TypedActionResult.fail(itemStack);
        } 
         else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    public static void iceExplosion(World world, BlockPos pos, @Nullable Entity attacker, int amplifier) {
        Box box = new Box(pos).expand(1D);
        List<Entity> entities = world.getOtherEntities(attacker, box);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity && !(entity instanceof PlayerEntity)) {
                LivingEntity livingEntity = (LivingEntity)entity;
                livingEntity.damage(DamageSource.FREEZE, (amplifier + 1) * 1.5f);
                livingEntity.addStatusEffect(new StatusEffectInstance(EffectRegistry.FREEZING, 200, amplifier));
            }
        }
        if (!world.isClient) {
            ParticleNetworking.sendServerParticlePacket((ServerWorld) world, PacketRegistry.ICE_PARTICLES_ID, pos, 300);
        }
        world.playSound(null, pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.HOSTILE, 1f, 1f);
        world.playSound(null, pos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.HOSTILE, 1f, .5f);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.soulsweapons.freeze").formatted(Formatting.AQUA));
            tooltip.add(Text.translatable("tooltip.soulsweapons.freeze_description").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.soulsweapons.permafrost").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.soulsweapons.permafrost_description_1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.soulsweapons.permafrost_description_2").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.soulsweapons.heavy_throw").formatted(Formatting.WHITE));
            tooltip.add(Text.translatable("tooltip.soulsweapons.heavy_throw_description").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.translatable("tooltip.soulsweapons.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public void registerControllers(AnimationData data) {        
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
