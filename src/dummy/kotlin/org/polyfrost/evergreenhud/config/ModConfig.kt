package org.polyfrost.evergreenhud.config

import cc.polyfrost.oneconfig.config.annotations.SubConfig
import org.polyfrost.evergreenhud.hud.Armour
import org.polyfrost.evergreenhud.hud.Direction

object ModConfig {
    @SubConfig var armour = Armour()
    @SubConfig var direction = Direction()
}