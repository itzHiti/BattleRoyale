package kz.itzHiti.BattleRoyale.Listeners;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {
    @EventHandler
    public void onDamage (EntityDamageByEntityEvent edmg) {
        if (Main.getInstance().pvp == true) {
            if (edmg.getEntity() instanceof Player) {
                if (edmg.getDamager() instanceof Player)
                    edmg.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onDamage (EntityDamageEvent edmg) {
        if (Main.getInstance().dmg == true) {
            if (edmg.getEntity() instanceof Player) {
                    edmg.setCancelled(true);
            }
        }
    }
}
