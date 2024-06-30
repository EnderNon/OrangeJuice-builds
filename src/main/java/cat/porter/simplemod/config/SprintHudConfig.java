package cat.porter.simplemod.config;

import cat.porter.simplemod.hud.SprintHud;
import cc.polyfrost.oneconfig.config.annotations.HUD;

public class SprintHudConfig {
    @HUD(
            name = "Sprint HUD"
    )
    public SprintHud hud = new SprintHud();
}
