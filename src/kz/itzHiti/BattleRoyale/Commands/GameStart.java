package kz.itzHiti.BattleRoyale.Commands;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class GameStart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("battleroyale.start")) {
                if (cmd.getName().equalsIgnoreCase("brstart")) {
                    Bukkit.broadcastMessage("§cИгра начинается!");
                    Bukkit.getScheduler().cancelAllTasks();
                    WorldCreator worldCreator = new WorldCreator("game");
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                        Bukkit.broadcastMessage(Main.getInstance().getMSG("GAME_START_5_SECONDS"));
                        Bukkit.createWorld(worldCreator);
                    }, 20L * 5);
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                        Main.getInstance().game = true;
                        for (Player pls : Bukkit.getOnlinePlayers()) {
                            pls.setGameMode(GameMode.SURVIVAL);
                            Random r = new Random();
                            double randomValue = 1 + (500 - 1) * r.nextDouble();
                            Location location = new Location(Bukkit.getWorld("game"), randomValue, 100, randomValue);
                            pls.teleport(location);
                        }
                        WorldBorder border = Bukkit.getWorld("game").getWorldBorder();
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            border.setSize(1000.0);
                        }, 20L * 5);
                        Bukkit.broadcastMessage(Main.getInstance().getMSG("READY"));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            border.setSize(100.0, 3600);
                            Main.getInstance().dmg = false;
                            Bukkit.broadcastMessage(Main.getInstance().getMSG("STARTED"));
                        }, 20L * 10);
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            Main.getInstance().pvp = false;
                            Bukkit.broadcastMessage(Main.getInstance().getMSG("PVP_ON"));
                        }, 20L * 300);
                        Main.getInstance().pvp = true;
                        Main.getInstance().dmg = true;
                    }, 20L * 10);
                }
            }
        }
        return false;
    }
}
