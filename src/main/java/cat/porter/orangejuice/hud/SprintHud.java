package cat.porter.orangejuice.hud;

import cat.porter.orangejuice.OrangeJuice;
import cat.porter.orangejuice.config.OrangeJuiceConfig;
import cc.polyfrost.oneconfig.hud.TextHud;

import java.util.List;

public class SprintHud extends TextHud {
    public SprintHud() {
        super(true, 0, 1080);
        this.scale = 1.2f;
    }

    @Override
    public void getLines(List<String> lines, boolean example) {
        if(OrangeJuice.INSTANCE.config.enabled && OrangeJuiceConfig.toggleSprint && OrangeJuice.INSTANCE.config.toggleSprintState) {
            lines.add(!OrangeJuiceConfig.sprintText.isEmpty() ? OrangeJuiceConfig.sprintText.replace("&", "§") : "§7Sprint enabled");
        }
    }
}
