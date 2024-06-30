package cat.porter.simplemod.config;

import cat.porter.simplemod.SimpleMod;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import kotlin.jvm.JvmField;
import org.polyfrost.evergreenhud.config.ModConfig;
import org.polyfrost.evergreenhud.hud.Direction;

/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class SimpleModConfig extends Config {

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
            text = "EvergreenHUD needs to be installed to use this feature.",
            type = InfoType.WARNING, // Types are: INFO, WARNING, ERROR, SUCCESS
            category = "ArmorHUD"
    )
    public static boolean armorwarning; // Useless. Java limitations with @annotation.

    @Button(
            name = "Open ArmorHUD Config",
            text = "Open Evergreen",
            category = "ArmorHUD"
    )
    Runnable openArmorHudConfig = () -> {
        if(SimpleMod.INSTANCE.hasEvergreen)
            ModConfig.INSTANCE.getArmour().openGui();
    };

    @Info(
            text = "EvergreenHUD needs to be installed to use this feature.",
            type = InfoType.WARNING, // Types are: INFO, WARNING, ERROR, SUCCESS
            category = "Direction"
    )
    public static boolean directionwarning; // Useless. Java limitations with @annotation.

    @Button(
            name = "Open DirectionHUD Config",
            text = "Open Evergreen",
            category = "Direction"
    )
    Runnable openDirectionHudConfig = () -> {
        if(SimpleMod.INSTANCE.hasEvergreen)
            ModConfig.INSTANCE.getDirection().openGui();
    };


    public SimpleModConfig() {
        super(new Mod(SimpleMod.NAME, ModType.UTIL_QOL), SimpleMod.MODID + ".json");
        initialize();
        addDependency("toggleSprintKey", "toggleSprint");
        addDependency("sprintText", "toggleSprint");
        addDependency("hidePingOnHypixel", "showServerPing");
        addDependency("hideFakePing", "showServerPing");
        addDependency("showServerPing", "showServerAddress");
        addDependency("openDirectionHudConfig", "hasEvergreen", () -> SimpleMod.INSTANCE.hasEvergreen);
        addDependency("openArmorHudConfig", "hasEvergreen", () -> SimpleMod.INSTANCE.hasEvergreen);
        addDependency("armorwarning", "hasEvergreen", () -> !SimpleMod.INSTANCE.hasEvergreen);
        addDependency("directionwarning", "hasEvergreen", () -> !SimpleMod.INSTANCE.hasEvergreen);

        registerKeyBind(toggleSprintKey, () -> {
            if(this.enabled && toggleSprint) {
                toggleSprintState = !toggleSprintState;
            }
        });
    }
}

