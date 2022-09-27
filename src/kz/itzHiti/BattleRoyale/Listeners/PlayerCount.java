package kz.itzHiti.BattleRoyale.Listeners;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.*;

public class PlayerCount implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        World world = ((Player) pl).getWorld();
        WorldBorder b = world.getWorldBorder();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("obj", "dummy");
        int c = 0;
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                c = c + 1;
            }
        }
        Bukkit.broadcastMessage("§fИгрок §e" + pl.getName() + "§f зашёл на сервер.");
        if (Main.getInstance().game == false) {
            int taskId = Main.getInstance().animationTasks.remove(e.getPlayer().getName());
            // И поток отключается
            Bukkit.getScheduler().cancelTask(taskId);
            if (world.getName() == "game") {
                pl.teleport(new Location(Bukkit.getWorld("world"), 26.5, 59.0, 5.5));
                pl.setGameMode(GameMode.ADVENTURE);
                pl.getInventory().clear();
            }
            if (Bukkit.getOnlinePlayers().size() == 8) {
                if (Main.getInstance().gamestarting == false) {
                    Main.getInstance().gamestarting = true;
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
                    }, 20L * 300);
                }
                else {
                    return;
                }
            }
            if (Bukkit.getOnlinePlayers().size() >= 8) {
                Bukkit.broadcastMessage(Main.getInstance().getMSG("GAME_START_5_MINUTES"));
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj.setDisplayName("§6§lКоролевская битва");
                obj.getScore(" ").setScore(7);
                obj.getScore("§fСтатус: §fИгра начинается...").setScore(6);
            }  else {
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
            for (final Player p : Bukkit.getOnlinePlayers()) {
                p.setScoreboard(board);
            }
        } else {
            pl.teleport(new Location(Bukkit.getWorld("game"), 0.0, 256.0, 0.0));
            pl.setGameMode(GameMode.SPECTATOR);
            pl.sendMessage(Main.getInstance().getMSG("GAME_GOING"));
            if (world.getName() == "game") {
                pl.setGameMode(GameMode.SPECTATOR);
                pl.getInventory().clear();
            }
            else {
                pl.teleport(new Location(Bukkit.getWorld("game"), 0.0, 256.0, 0.0));
                pl.setGameMode(GameMode.SPECTATOR);
            }
            int finalC = c;
            int taskId = new BukkitRunnable() {
                @Override
                public void run() {
                    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                    obj.setDisplayName("§6§lКоролевская битва");
                    obj.getScore(" ").setScore(7);
                    obj.getScore("§fСтатус: §eИдёт игра").setScore(6);
                    obj.getScore("  ").setScore(5);
                    obj.getScore("§fИгроков: §e" + finalC + " §8§o(" + Bukkit.getOnlinePlayers().size() + "§8)§f/§632").setScore(4);
                    obj.getScore("   ").setScore(3);
                    obj.getScore("§fГраница текущей игры: §e" + (int) b.getSize()).setScore(2);
                    obj.getScore("    ").setScore(1);
                    obj.getScore("§btera-minecraft.ru").setScore(0);
                }
            }.runTaskTimer(Main.getInstance(), 20, 20).getTaskId();

            // Добавление ID потока в Map, который можно будет получить по нику игрока, чтобы остановить поток
            for (final Player p : Bukkit.getOnlinePlayers()) {
                p.setScoreboard(board);
                Main.getInstance().animationTasks.put(e.getPlayer().getName(), taskId);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("obj", "dummy");
        Player pl = e.getPlayer();
        World world = ((Player) pl).getWorld();
        WorldBorder b = world.getWorldBorder();
        Bukkit.broadcastMessage("§fИгрок §e" + pl.getName() + "§f вышел с сервера.");
        if (Main.getInstance().game == false) {
            if (Bukkit.getOnlinePlayers().size() >= 8) {
                Bukkit.broadcastMessage(Main.getInstance().getMSG("GAME_START_5_MINUTES"));
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj.setDisplayName("§6§lКоролевская битва");
                obj.getScore(" ").setScore(7);
                obj.getScore("§fСтатус: §fИгра начинается...").setScore(6);
            }  else {
                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj.setDisplayName("§6§lКоролевская битва");
                obj.getScore(" ").setScore(7);
                obj.getScore("§fСтатус: §eОжидание игроков.").setScore(6);
                Bukkit.getScheduler().cancelAllTasks();
                Main.getInstance().gamestarting = false;
            }
                obj.getScore("  ").setScore(5);
                obj.getScore("§fИгроков: §e" + Bukkit.getOnlinePlayers().size() + "§f/§632").setScore(4);
                obj.getScore("   ").setScore(3);
                obj.getScore("§fГраница текущей игры: §e" + (int) b.getSize()).setScore(2);
                obj.getScore("    ").setScore(1);
                obj.getScore("§btera-minecraft.ru").setScore(0);
            for (final Player p : Bukkit.getOnlinePlayers()) {
                p.setScoreboard(board);
            }
        } else {
            return;
        }
    }
}
