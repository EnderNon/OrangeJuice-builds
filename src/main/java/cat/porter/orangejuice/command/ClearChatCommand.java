package cat.porter.orangejuice.command;

import cat.porter.orangejuice.OrangeJuice;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see OrangeJuice
 */
@Command(value = "clearchat", description = "Clears all messages in chat.", aliases = { "cc" })
public class ClearChatCommand {
    @Main
    private void handle() {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages();
    }
}