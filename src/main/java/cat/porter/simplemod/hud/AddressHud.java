package cat.porter.simplemod.hud;

import cat.porter.simplemod.SimpleMod;
import cat.porter.simplemod.config.SimpleModConfig;
import cc.polyfrost.oneconfig.hud.TextHud;
import cc.polyfrost.oneconfig.platform.Platform;
import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;

import java.util.List;

public class AddressHud extends TextHud {
    public AddressHud() {
        super(true, 1920 / 2, 10);
    }

    @Override
    public boolean shouldShow() {
        return super.shouldShow() && Minecraft.getMinecraft().gameSettings.keyBindPlayerList.isKeyDown() ^  SimpleModConfig.hideWhenPlayerListVisible ;
    }

    @Override
    public void getLines(List<String> lines, boolean example) {
        if (SimpleMod.INSTANCE.config.enabled && SimpleModConfig.showServerAddress && Platform.getServerPlatform().inMultiplayer()) {
            String text = Minecraft.getMinecraft().getCurrentServerData().serverIP;
            if (SimpleModConfig.showServerPing) {
                if (HypixelUtils.INSTANCE.isHypixel() && !SimpleModConfig.hidePingOnHypixel) {
                    NetworkPlayerInfo info = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getGameProfile().getId());
                    if (info != null) {
                        int ping = info.getResponseTime();
                        if((ping > 1 && ping < 999) || !SimpleModConfig.hideFakePing) {
                            text += " (" + ping + "ms)";

                        }
                    }
                }
            }
            lines.add(text);
        }
    }
}
