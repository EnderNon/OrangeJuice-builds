package cat.porter.simplemod.mixin;

import cat.porter.simplemod.SimpleMod;
import cat.porter.simplemod.config.SimpleModConfig;
import cc.polyfrost.oneconfig.libs.universal.UScreen;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

    public MixinEntityPlayerSP(World worldIn, GameProfile playerProfile) {
        super(worldIn, playerProfile);
    }

    @Redirect(
            method = "onLivingUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z"
            )
    )
    private boolean setSprintState(KeyBinding keyBinding) {
        return keyBinding.isKeyDown() || UScreen.getCurrentScreen() == null && SimpleMod.INSTANCE.config.enabled && SimpleModConfig.toggleSprint && SimpleMod.INSTANCE.config.toggleSprintState;
    }

}