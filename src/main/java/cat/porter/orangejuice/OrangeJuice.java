package cat.porter.orangejuice;

import cat.porter.orangejuice.command.ClearChatCommand;
import cat.porter.orangejuice.command.GuiCommand;
import cat.porter.orangejuice.config.OrangeJuiceConfig;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = OrangeJuice.MODID, name = OrangeJuice.NAME, version = OrangeJuice.VERSION)
public class OrangeJuice {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public static final Logger logger = LogManager.getLogger(NAME);
    @Mod.Instance(MODID)
    public static OrangeJuice INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static OrangeJuiceConfig config;
    public boolean hasEvergreen = false;
    public boolean hasPotionEffects = false;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        logger.info("Initializing OrangeJuice v" + VERSION + " by Porter");
        config = new OrangeJuiceConfig();
        CommandManager.INSTANCE.registerCommand(new GuiCommand());
        CommandManager.INSTANCE.registerCommand(new ClearChatCommand());
        hasEvergreen = Loader.isModLoaded("evergreenhud");
        hasPotionEffects = Loader.isModLoaded("potioneffects");
    }
}
