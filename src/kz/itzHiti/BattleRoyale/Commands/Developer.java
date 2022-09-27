package kz.itzHiti.BattleRoyale.Commands;

import kz.itzHiti.BattleRoyale.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Developer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("itzhiti") || cmd.getName().equalsIgnoreCase("battleroyale")) {
            sender.sendMessage(ChatColor.WHITE + "Плагин создал " + ChatColor.GOLD + "" + ChatColor.BOLD + "itzHiti" + ChatColor.WHITE + ". Версия плагина - " + ChatColor.GOLD + Main.getInstance().getDescription().getVersion());
            }
        }
        return false;
    }
}
