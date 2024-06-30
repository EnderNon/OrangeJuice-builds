package cat.porter.simplemod.config;

import cat.porter.simplemod.hud.AddressHud;
import cat.porter.simplemod.hud.SprintHud;
import cc.polyfrost.oneconfig.config.annotations.HUD;

public class AddressHudConfig {
    @HUD(
            name = "Address Hud"
    )
    public AddressHud hud = new AddressHud();
}
