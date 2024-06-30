package cat.porter.orangejuice.config;

import cat.porter.orangejuice.hud.AddressHud;
import cc.polyfrost.oneconfig.config.annotations.HUD;

public class AddressHudConfig {
    @HUD(
            name = "Address Hud"
    )
    public AddressHud hud = new AddressHud();
}
