package cat.porter.simplemod.command;

import cat.porter.simplemod.SimpleMod;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see SimpleMod
 */
@Command(value = SimpleMod.MODID, description = "Access the " + SimpleMod.NAME + " GUI.")
public class GuiCommand {
    @Main
    private void handle() {
        SimpleMod.INSTANCE.config.openGui();
    }
}