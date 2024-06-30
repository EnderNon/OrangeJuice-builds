package cat.porter.simplemod.config;

import cat.porter.simplemod.hud.AddressHud;
import cc.polyfrost.oneconfig.config.annotations.HUD;

public class AddressHudConfig {
    @HUD(
            name = "Address Hud"
    )
    public AddressHud hud = new AddressHud();
}
