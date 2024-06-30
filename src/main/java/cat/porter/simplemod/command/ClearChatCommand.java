package cat.porter.simplemod.command;

import cat.porter.simplemod.SimpleMod;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see SimpleMod
 */
@Command(value = "clearchat", description = "Clears all messages in chat.", aliases = { "cc" })
public class ClearChatCommand {
    @Main
    private void handle() {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages();
    }
}