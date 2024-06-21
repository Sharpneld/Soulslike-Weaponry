package net.soulsweaponry.items;

import com.google.common.collect.Multimap;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.network.SerializableDataTicket;
import mod.azure.azurelib.platform.services.AzureLibNetwork;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.soulsweaponry.client.renderer.item.DraupnirSpearItemRenderer;
import net.soulsweaponry.config.ConfigConstructor;
import net.soulsweaponry.entity.projectile.DraupnirSpearEntity;
import net.soulsweaponry.registry.EffectRegistry;
import net.soulsweaponry.util.IKeybindAbility;
import net.soulsweaponry.particles.ParticleEvents;
import net.soulsweaponry.particles.ParticleHandler;
import net.soulsweaponry.util.WeaponUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DraupnirSpear extends ChargeToUseItem implements GeoItem, IKeybindAbility {

    private final AnimatableInstanceCache factory = AzureLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public static final String SPEARS_ID = "thrown_spears_id";

    public DraupnirSpear(ToolMaterial toolMaterial, float attackSpeed, Settings settings) {
        super(toolMaterial, ConfigConstructor.draupnir_spear_damage, attackSpeed, settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                int enchant = WeaponUtil.getEnchantDamageBonus(stack);
                DraupnirSpearEntity entity = new DraupnirSpearEntity(world, playerEntity, stack);
                entity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 5.0F, 1.0F);
                entity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                world.spawnEntity(entity);
                world.playSoundFromEntity(null, entity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                this.saveSpearData(stack, entity);
                playerEntity.getItemCooldownManager().set(this, ConfigConstructor.draupnir_spear_throw_cooldown - enchant * 5);
                stack.damage(1, (LivingEntity)playerEntity, (p_220045_0_) -> p_220045_0_.sendToolBreakStatus(user.getActiveHand()));
            }
        }
    }

    private PlayState predicate(mod.azure.azurelib.core.animation.AnimationState<GeoAnimatable> event){
        event.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public double getBoneResetTime() {
        return GeoItem.super.getBoneResetTime();
    }

    @Override
    public boolean shouldPlayAnimsWhileGamePaused() {
        return GeoItem.super.shouldPlayAnimsWhileGamePaused();
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private final DraupnirSpearItemRenderer renderer = new DraupnirSpearItemRenderer();

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            WeaponUtil.addAbilityTooltip(WeaponUtil.TooltipAbilities.INFINITY, stack, tooltip);
            WeaponUtil.addAbilityTooltip(WeaponUtil.TooltipAbilities.DETONATE_SPEARS, stack, tooltip);
        } else {
            tooltip.add(Text.translatable("tooltip.soulsweapons.shift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void saveSpearData(ItemStack stack, DraupnirSpearEntity entity) {
        if (stack.hasNbt()) {
            List<Integer> ids = new ArrayList<>();
            if (stack.getNbt().contains(SPEARS_ID)) {
                int[] arr = stack.getNbt().getIntArray(SPEARS_ID);
                ids = WeaponUtil.arrayToList(arr);
            }
            ids.add(entity.getId());
            stack.getNbt().putIntArray(SPEARS_ID, ids);
        }
    }

    @Override
    public void useKeybindAbilityServer(ServerWorld world, ItemStack stack, PlayerEntity player) {
        if (!player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
            if (player.isSneaking()) {
                if (!player.hasStatusEffect(EffectRegistry.COOLDOWN)) {
                    int r = 4;
                    world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.PLAYERS, 1f, 1f);
                    for (int theta = 0; theta < 360; theta += 45) {
                        double x0 = player.getX();
                        double z0 = player.getZ();
                        double x = x0 + r * Math.cos(theta * Math.PI / 180);
                        double z = z0 + r * Math.sin(theta * Math.PI / 180);
                        double x1 = Math.cos(theta * Math.PI / 180);
                        double z1 = Math.sin(theta * Math.PI / 180);
                        DraupnirSpearEntity entity = new DraupnirSpearEntity(world, player, stack);
                        entity.setPos(x, player.getY() + 5, z);
                        entity.setVelocity(x1, -3, z1);
                        entity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                        world.spawnEntity(entity);
                        this.saveSpearData(stack, entity);
                        ParticleHandler.particleOutburst(world, 10, x, player.getY() + 5, z, ParticleTypes.CLOUD, new Vec3d(4, 4, 4), 0.5f);
                    }
                    if (!player.isCreative()) player.addStatusEffect(new StatusEffectInstance(EffectRegistry.COOLDOWN, ConfigConstructor.draupnir_spear_summon_spears_cooldown, 0));
                } else {
                    player.sendMessage(Text.literal("Can't cast this ability with Cooldown effect!"), true);
                }
            } else {
                Box box = player.getBoundingBox().expand(3);
                List<Entity> entities = world.getOtherEntities(player, box);
                float power = ConfigConstructor.draupnir_spear_projectile_damage;
                for (Entity entity : entities) {
                    if (entity instanceof LivingEntity) {
                        entity.damage(world.getDamageSources().mobAttack(player), power + EnchantmentHelper.getAttackDamage(stack, ((LivingEntity) entity).getGroup()));
                        entity.addVelocity(0, .1f, 0);
                    }
                }
                ParticleHandler.particleOutburstMap(world, 250, player.getX(), player.getY(), player.getZ(), ParticleEvents.DEFAULT_GRAND_SKYFALL_MAP, 0.5f);
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1f, 1f);
                player.getItemCooldownManager().set(stack.getItem(), ConfigConstructor.draupnir_spear_detonate_cooldown);
                if (stack.hasNbt() && stack.getNbt().contains(DraupnirSpear.SPEARS_ID)) {
                    int[] ids = stack.getNbt().getIntArray(DraupnirSpear.SPEARS_ID);
                    for (int id : ids) {
                        Entity entity = world.getEntityById(id);
                        if (entity instanceof DraupnirSpearEntity spear) {
                            spear.detonate();
                        }
                    }
                    stack.getNbt().putIntArray(DraupnirSpear.SPEARS_ID, new int[0]);
                }
            }
        }
    }

    @Override
    public void useKeybindAbilityClient(ClientWorld world, ItemStack stack, ClientPlayerEntity player) {
    }

    @Override
    public double getTick(Object itemStack) {
        return GeoItem.super.getTick(itemStack);
    }

    @Override
    public boolean isPerspectiveAware() {
        return GeoItem.super.isPerspectiveAware();
    }

    @Override
    public <D> @Nullable D getAnimData(long instanceId, SerializableDataTicket<D> dataTicket) {
        return GeoItem.super.getAnimData(instanceId, dataTicket);
    }

    @Override
    public <D> void setAnimData(Entity relatedEntity, long instanceId, SerializableDataTicket<D> dataTicket, D data) {
        GeoItem.super.setAnimData(relatedEntity, instanceId, dataTicket, data);
    }

    @Override
    public <D> void syncAnimData(long instanceId, SerializableDataTicket<D> dataTicket, D data, Entity entityToTrack) {
        GeoItem.super.syncAnimData(instanceId, dataTicket, data, entityToTrack);
    }

    @Override
    public void triggerAnim(Entity relatedEntity, long instanceId, @Nullable String controllerName, String animName) {
        GeoItem.super.triggerAnim(relatedEntity, instanceId, controllerName, animName);
    }

    @Override
    public void triggerAnim(long instanceId, @Nullable String controllerName, String animName, AzureLibNetwork.IPacketCallback packetCallback) {
        GeoItem.super.triggerAnim(instanceId, controllerName, animName, packetCallback);
    }

    @Override
    public @Nullable AnimatableInstanceCache animatableCacheOverride() {
        return GeoItem.super.animatableCacheOverride();
    }

    @Override
    public boolean allowNbtUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return super.allowNbtUpdateAnimation(player, hand, oldStack, newStack);
    }

    @Override
    public boolean allowContinuingBlockBreaking(PlayerEntity player, ItemStack oldStack, ItemStack newStack) {
        return super.allowContinuingBlockBreaking(player, oldStack, newStack);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        return super.getAttributeModifiers(stack, slot);
    }

    @Override
    public boolean isSuitableFor(ItemStack stack, BlockState state) {
        return super.isSuitableFor(stack, state);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return super.getRecipeRemainder(stack);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return super.isEnabled(enabledFeatures);
    }
}
