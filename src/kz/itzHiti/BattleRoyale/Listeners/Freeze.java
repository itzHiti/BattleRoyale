package kz.itzHiti.BattleRoyale.Listeners;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.*;


public class Freeze implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        int c = 0;
        String winner = "";
        World world = e.getPlayer().getWorld();
        WorldBorder b = world.getWorldBorder();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("obj", "dummy");
        if (Main.getInstance().game == true) {
            if (world.getName() == "game") {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getGameMode() == GameMode.SURVIVAL) {
                        c = c + 1;
                        winner = p.getName();
                    }
                }
                if (c == 1) {
                    Bukkit.broadcastMessage(Main.getInstance().getMSG("WINNER_IS") + winner);
                    Main.getInstance().game = false;
                    int taskId = Main.getInstance().animationTasks.remove(e.getPlayer().getName());
                    // И поток отключается
                    Bukkit.getScheduler().cancelTask(taskId);
                    Main.getInstance().animationTasks.clear();
                    for (Player pls : Bukkit.getOnlinePlayers()) {
                        pls.teleport(new Location(Bukkit.getWorld("world"), 26.5, 59.0, 5.5));
                        pls.setGameMode(GameMode.ADVENTURE);
                        pls.getInventory().clear();
                        pls.setHealth(20.0);
                        pls.setFoodLevel(20);
                    }
                    Bukkit.getScheduler().cancelAllTasks();
                    WorldBorder border = Bukkit.getWorld("game").getWorldBorder();
                    border.setSize(1000);
                    //delworld
                    Main.getInstance().removeWorld("game");
                    if (Bukkit.getOnlinePlayers().size() == 8) {
                        Main.getInstance().removeWorld("game");
                        WorldCreator worldCreator = new WorldCreator("game");
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            Bukkit.broadcastMessage(Main.getInstance().getMSG("GAME_START_5_SECONDS"));
                            Bukkit.createWorld(worldCreator);
                        }, 20L * 295);
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            Main.getInstance().game = true;
                            for (Player pls : Bukkit.getOnlinePlayers()) {
                                Random r = new Random();
                                double randomValue = 1 + (500 - 1) * r.nextDouble();
                                Location location = new Location(Bukkit.getWorld("game"), randomValue, 100, randomValue);
                                pls.teleport(location);
                                pls.setGameMode(GameMode.SURVIVAL);
                            }
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
                        }, 20L * 300);
                    }
                    if (Bukkit.getOnlinePlayers().size() >= 8) {
                        Bukkit.broadcastMessage(Main.getInstance().getMSG("GAME_START_5_MINUTES"));
                        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                        obj.setDisplayName("§6§lКоролевская битва");
                        obj.getScore(" ").setScore(7);
                        obj.getScore("§fСтатус: §fИгра начинается...").setScore(6);
                    } else {
                        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                        obj.setDisplayName("§6§lКоролевская битва");
                        obj.getScore(" ").setScore(7);
                        obj.getScore("§fСтатус: §eОжидание игроков.").setScore(6);
                    }
                    obj.getScore("  ").setScore(5);
                    obj.getScore("§fИгроков: §e" + Bukkit.getOnlinePlayers().size() + "§f/§632").setScore(4);
                    obj.getScore("   ").setScore(3);
                    obj.getScore("§fГраница текущей игры: §e" + (int) b.getSize()).setScore(2);
                    obj.getScore("    ").setScore(1);
                    obj.getScore("§btera-minecraft.ru").setScore(0);
                } else {
                }
            }
        }
    }
}
