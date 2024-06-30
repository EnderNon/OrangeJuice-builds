package cat.porter.simplemod;

import cat.porter.simplemod.command.ClearChatCommand;
import cat.porter.simplemod.command.GuiCommand;
import cat.porter.simplemod.config.SimpleModConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = SimpleMod.MODID, name = SimpleMod.NAME, version = SimpleMod.VERSION)
public class SimpleMod {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public static final Logger logger = LogManager.getLogger(NAME);
    @Mod.Instance(MODID)
    public static SimpleMod INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static SimpleModConfig config;
    public boolean hasEvergreen = false;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        logger.info("Initializing SimpleMod v" + VERSION + " by Porter");
        config = new SimpleModConfig();
        CommandManager.INSTANCE.registerCommand(new GuiCommand());
        CommandManager.INSTANCE.registerCommand(new ClearChatCommand());
        hasEvergreen = Loader.isModLoaded("evergreenhud");
    }
}
