package cat.porter.orangejuice.config;

import cat.porter.orangejuice.hud.SprintHud;
import cc.polyfrost.oneconfig.config.annotations.HUD;

public class SprintHudConfig {
    @HUD(
            name = "Sprint HUD"
    )
    public SprintHud hud = new SprintHud();
}
