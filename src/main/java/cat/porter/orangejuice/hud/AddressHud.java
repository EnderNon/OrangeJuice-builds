package cat.porter.orangejuice.hud;

import cat.porter.orangejuice.OrangeJuice;
import cat.porter.orangejuice.config.OrangeJuiceConfig;
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
        return super.shouldShow() && !(OrangeJuiceConfig.hideWhenPlayerListVisible && Minecraft.getMinecraft().gameSettings.keyBindPlayerList.isKeyDown());
    }

    @Override
    public void getLines(List<String> lines, boolean example) {
        if(example) {
            String text = "mc.hypixel.net";
            if(OrangeJuiceConfig.showServerPing) text += " (35ms)";
            return;
        }

        if (OrangeJuice.INSTANCE.config.enabled && OrangeJuiceConfig.showServerAddress && Platform.getServerPlatform().inMultiplayer()) {
            String text = Minecraft.getMinecraft().getCurrentServerData().serverIP;
            if (OrangeJuiceConfig.showServerPing) {
                if (HypixelUtils.INSTANCE.isHypixel() && !OrangeJuiceConfig.hidePingOnHypixel) {
                    NetworkPlayerInfo info = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getGameProfile().getId());
                    if (info != null) {
                        int ping = info.getResponseTime();
                        if ((ping > 1 && ping < 999) || !OrangeJuiceConfig.hideFakePing) {
                            text += " (" + ping + "ms)";

                        }
                    }
                }
            }
            lines.add(text);
        }
    }
}
