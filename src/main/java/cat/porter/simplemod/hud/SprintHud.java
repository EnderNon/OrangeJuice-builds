package cat.porter.simplemod.hud;

import cat.porter.simplemod.SimpleMod;
import cat.porter.simplemod.config.SimpleModConfig;
import cc.polyfrost.oneconfig.hud.TextHud;

import java.util.List;

/**
 * An example OneConfig HUD that is started in the config and displays text.
 *
 * @see SimpleModConfig#hud
 */
public class SprintHud extends TextHud {
    public SprintHud() {
        super(true);
    }

    @Override
    public void getLines(List<String> lines, boolean example) {
        if(SimpleMod.INSTANCE.config.enabled && SimpleModConfig.toggleSprint && SimpleMod.INSTANCE.config.toggleSprintState) {
            lines.add(!SimpleModConfig.sprintText.isEmpty() ? SimpleModConfig.sprintText.replace("&", "§") : "§7Sprint enabled");
        }
    }
}
