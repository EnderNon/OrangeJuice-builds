package cat.porter.orangejuice.config;

import cat.porter.orangejuice.OrangeJuice;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import cc.polyfrost.oneconfig.utils.NetworkUtils;
import me.tellinq.potioneffects.config.PotionEffectsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import org.polyfrost.evergreenhud.config.ModConfig;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class OrangeJuiceConfig extends Config {

    public Runnable downloadEvergreenHUD = () -> {
        Minecraft.getMinecraft().displayGuiScreen(new GuiConfirmOpenLink((clicked, id) -> {
            if (clicked) {
                NetworkUtils.browseLink("https://modrinth.com/mod/evergreenhud");
                Minecraft.getMinecraft().displayGuiScreen(null);
            }
            else this.openGui();
        }, "https://modrinth.com/mod/evergreenhud", 31102009, true));
    };

    @Switch(
            name = "Toggle Sprint",
            category = "Toggle Sprint"
    )
    public static boolean toggleSprint = false;

    @KeyBind(
            name = "Toggle Sprint Key",
            category = "Toggle Sprint"
    )
    public static OneKeyBind toggleSprintKey = new OneKeyBind(UKeyboard.KEY_NONE);

    @Text(
            name = "Sprint Text",
            placeholder = "Sprint enabled",
            category = "Toggle Sprint"
    )
    public static String sprintText = "";
    public boolean toggleSprintState = false;

    @Page(
            name = "Edit Sprint HUD",
            category = "Toggle Sprint",
            location = PageLocation.BOTTOM
    )
    public SprintHudConfig sprintHudConfig = new SprintHudConfig();

    @Switch(
            name = "Show Server Address",
            category = "Server Address"
    )
    public static boolean showServerAddress = false;

    @Switch(
            name = "Show Server Ping",
            category = "Server Address"
    )
    public static boolean showServerPing = false;

    @Switch(
            name = "Hide Fake Ping",
            description = "Hides the ping when it is less than 1 or greater than 999",
            category = "Server Address"
    )
    public static boolean hideFakePing = true;

    @Switch(
            name = "Hide Ping On Hypixel (0ms)",
            category = "Server Address"
    )
    public static boolean hidePingOnHypixel = true;

    @Switch(
            name = "Hide when player list visible",
            category = "Server Address"
    )
    public static boolean hideWhenPlayerListVisible = false;

    @Page(
            name = "Edit Address HUD",
            category = "Server Address",
            location = PageLocation.BOTTOM
    )
    public AddressHudConfig addressHudConfig = new AddressHudConfig();

    @Info(
            text = "EvergreenHUD is required to use this feature.",
            type = InfoType.WARNING, // Types are: INFO, WARNING, ERROR, SUCCESS
            category = "ArmorHUD"
    )
    public static boolean armorwarning; // Useless. Java limitations with @annotation.

    @Button(
            name = "Download EvergreenHUD",
            text = "Download",
            category = "ArmorHUD"
    )
    Runnable downloadArmorHUD = downloadEvergreenHUD;

    @Button(
            name = "Open ArmorHUD Config",
            text = "Open Evergreen",
            category = "ArmorHUD"
    )
    Runnable openArmorHudConfig = () -> {
        if(OrangeJuice.INSTANCE.hasEvergreen)
            ModConfig.INSTANCE.getArmour().openGui();
    };

    @Info(
            text = "EvergreenHUD is required to use this feature.",
            type = InfoType.WARNING, // Types are: INFO, WARNING, ERROR, SUCCESS
            category = "DirectionHUD"
    )
    public static boolean directionwarning; // Useless. Java limitations with @annotation.

    @Button(
            name = "Download EvergreenHUD",
            text = "Download",
            category = "DirectionHUD"
    )
    Runnable downloadDirectionHUD = downloadEvergreenHUD;

    @Button(
            name = "Open DirectionHUD Config",
            text = "Open Evergreen",
            category = "DirectionHUD"
    )
    Runnable openDirectionHudConfig = () -> {
        if(OrangeJuice.INSTANCE.hasEvergreen)
            ModConfig.INSTANCE.getDirection().openGui();
    };

    @Info(
            text = "Tellinq's Potion Effects is required to use this feature.",
            type = InfoType.WARNING, // Types are: INFO, WARNING, ERROR, SUCCESS
            category = "Status Effects"
    )
    public static boolean statuseffectswarning; // Useless. Java limitations with @annotation.

    @Button(
            name = "Download Potion Effects",
            text = "Download",
            category = "Status Effects"
    )
    Runnable downloadPotionEffects = () -> {
        Minecraft.getMinecraft().displayGuiScreen(new GuiConfirmOpenLink((clicked, id) -> {
            if(clicked) {
                NetworkUtils.browseLink("https://github.com/Tellinq/Potion-Effects/releases/tag/v1.0");
                Minecraft.getMinecraft().displayGuiScreen(null);

            }
            else this.openGui();

        } , "https://github.com/Tellinq/Potion-Effects/releases/tag/v1.0", 31102009, true));
    };

    @Button(
            name = "Open Potion Effects Config",
            text = "Open Potion Effects",
            category = "Status Effects"
    )
    Runnable openPotionEffectsConfig = () -> {
        if(OrangeJuice.INSTANCE.hasPotionEffects)
            PotionEffectsConfig.INSTANCE.openGui();
    };


    public OrangeJuiceConfig() {
        super(new Mod(OrangeJuice.NAME, ModType.UTIL_QOL), OrangeJuice.MODID + ".json");
        initialize();
        addDependency("toggleSprintKey", "toggleSprint");
        addDependency("sprintText", "toggleSprint");
        addDependency("hidePingOnHypixel", "showServerPing");
        addDependency("hideFakePing", "showServerPing");
        addDependency("showServerPing", "showServerAddress");
        addDependency("openDirectionHudConfig", "hasEvergreen", () -> OrangeJuice.INSTANCE.hasEvergreen);
        addDependency("openArmorHudConfig", "hasEvergreen", () -> OrangeJuice.INSTANCE.hasEvergreen);
        addDependency("openPotionEffectsConfig", "hasPotionEffects", () -> OrangeJuice.INSTANCE.hasPotionEffects);
        hideIf("armorwarning", () -> OrangeJuice.INSTANCE.hasEvergreen);
        hideIf("downloadArmorHUD", () -> OrangeJuice.INSTANCE.hasEvergreen);

        hideIf("directionwarning", () -> OrangeJuice.INSTANCE.hasEvergreen);
        hideIf("downloadDirectionHUD", () -> OrangeJuice.INSTANCE.hasEvergreen);

        hideIf("statuseffectswarning", () -> OrangeJuice.INSTANCE.hasPotionEffects);
        hideIf("downloadPotionEffects", () -> OrangeJuice.INSTANCE.hasPotionEffects);

        registerKeyBind(toggleSprintKey, () -> {
            if(this.enabled && toggleSprint) {
                toggleSprintState = !toggleSprintState;
            }
        });
    }
}

