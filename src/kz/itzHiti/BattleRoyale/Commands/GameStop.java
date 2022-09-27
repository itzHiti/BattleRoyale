package kz.itzHiti.BattleRoyale.Commands;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameStop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("battleroyale.stop")) {
                if (cmd.getName().equalsIgnoreCase("brstop")) {
                    Bukkit.broadcastMessage("§bИгра останавливается!");
                    Main.getInstance().game = false;
                    Main.getInstance().pvp = false;
                    Main.getInstance().dmg = false;
                    Bukkit.getScheduler().cancelAllTasks();
                    Main.getInstance().animationTasks.clear();
                    for (Player pls : Bukkit.getOnlinePlayers()) {
                        Location location = new Location(Bukkit.getWorld("world"), 26.5, 59.5, 5.5);
                        pls.teleport(location);
                        pls.getInventory().clear();
                        pls.setHealth(20.0);
                        pls.setFoodLevel(20);
                        pls.setGameMode(GameMode.ADVENTURE);
                    }
                    //delworld
                    Main.getInstance().removeWorld("game");
                    // И поток отключается
                }
            }
        }
        return false;
    }
}