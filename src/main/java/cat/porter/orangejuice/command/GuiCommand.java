package cat.porter.orangejuice.command;

import cat.porter.orangejuice.OrangeJuice;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see OrangeJuice
 */
@Command(value = OrangeJuice.MODID, description = "Access the " + OrangeJuice.NAME + " GUI.")
public class GuiCommand {
    @Main
    private void handle() {
        OrangeJuice.INSTANCE.config.openGui();
    }
}