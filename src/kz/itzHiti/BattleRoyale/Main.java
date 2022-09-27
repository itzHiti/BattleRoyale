package kz.itzHiti.BattleRoyale;

import kz.itzHiti.BattleRoyale.Commands.Developer;
import kz.itzHiti.BattleRoyale.Commands.GameStart;
import kz.itzHiti.BattleRoyale.Commands.GameStop;
import kz.itzHiti.BattleRoyale.Listeners.*;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class Main extends JavaPlugin {

    private static Main plugin;
    public static FileConfiguration config;
    public static FileConfiguration messages;
    public boolean game;
    public boolean pvp;
    public boolean dmg;
    public boolean gamestarting;


    public void onEnable(){
        //MainEnabling
        this.getCommand("battleroyale").setExecutor((CommandExecutor)new Developer());
        this.getCommand("brstart").setExecutor((CommandExecutor)new GameStart());
        this.getCommand("brstop").setExecutor((CommandExecutor)new GameStop());
        Bukkit.getPluginManager().registerEvents((Listener)new DeathListener(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerCount(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new MobDeathLoot(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Freeze(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Damage(), (Plugin)this);
        getLogger().info("Плагин включен успешно.");
        plugin = this;
        Main.messages = Configurations.getFile("data.yml");
        plugin.saveDefaultConfig();
        Main.config = Configurations.getFile("config.yml");
        game = false;
        pvp = false;
        dmg = false;
        gamestarting = false;
    }

    public void onDisable() {
        getLogger().info("Плагин выключен.");
        game = false;
        pvp = false;
        dmg = false;
        Bukkit.getScheduler().cancelAllTasks();
        animationTasks.clear();
        removeWorld("game");
    }

        public static Main getInstance () {
            return plugin;
        }

        public String getMSG (String path){
            return ChatColor.translateAlternateColorCodes('&', Main.config.getString("MESSAGES." + path).replace("%new%", "\n"));
        }

    public static void removeWorld(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            if (!world.getPlayers().isEmpty()) {
                throw new IllegalStateException("Мир \"" + worldName + "\" всё ещё содержит в себе игроков. Вам необходимо " +
                        "телепортировать их в другой мир, перед тем как отключать текущий.");
            }
            if (!Bukkit.unloadWorld(world, false)) {
                throw new InternalError("Не получилось отключить мир \"" + worldName + "\"");
            }
        }

        final File worldDir = Paths.get(".", worldName).toAbsolutePath().normalize().toFile();

        if (!org.apache.commons.io.FileUtils.deleteQuietly(worldDir)) {
            //worldDir is not fully deleted.
        }
    }
    public Map<String, Integer> animationTasks = new HashMap<>();
}
