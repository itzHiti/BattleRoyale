package kz.itzHiti.BattleRoyale.Listeners;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class DeathListener implements Listener {

    public int counter = 0;
    public int maxcount;

    @EventHandler
    public void onRespawnPVPEVENT(PlayerRespawnEvent pvpevent) {
        Player p = pvpevent.getPlayer();
        PlayerInventory inv = p.getInventory();
        World world = pvpevent.getPlayer().getWorld();
        if (world.getName() != "world") {
            if (p.getGameMode() != GameMode.SPECTATOR) {
                 if (p.getBedSpawnLocation() != null) {
                    if (p.hasPermission("battleroyale.lite") && !(p.isOp())) {
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.WOOD_PICKAXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.WOOD_SWORD)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.WOOD_AXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.WOOD_SPADE)});
                        p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            p.teleport(p.getBedSpawnLocation());
                        }, 20L * 3);
                    }
                    if (p.hasPermission("battleroyale.ultra") && !(p.isOp())) {
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.STONE_PICKAXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.STONE_SWORD)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.STONE_AXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.STONE_SPADE)});
                        p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            p.teleport(p.getBedSpawnLocation());
                        }, 20L * 3);
                    }
                    if (p.hasPermission("battleroyale.miner") && !(p.isOp())) {
                        ItemStack item1 = new ItemStack(Material.STONE_PICKAXE);
                        ItemMeta meta1 = item1.getItemMeta();
                        meta1.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item1.setItemMeta(meta1);
                        ItemStack item2 = new ItemStack(Material.STONE_SWORD);
                        ItemMeta meta2 = item2.getItemMeta();
                        meta2.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                        item2.setItemMeta(meta2);
                        ItemStack item3 = new ItemStack(Material.STONE_AXE);
                        ItemMeta meta3 = item3.getItemMeta();
                        meta3.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item3.setItemMeta(meta3);
                        ItemStack item4 = new ItemStack(Material.STONE_AXE);
                        ItemMeta meta4 = item4.getItemMeta();
                        meta4.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item4.setItemMeta(meta4);
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(item1);
                        p.getInventory().addItem(item2);
                        p.getInventory().addItem(item3);
                        p.getInventory().addItem(item4);
                        p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            p.teleport(p.getBedSpawnLocation());
                        }, 20L * 3);
                    }
                    if (p.hasPermission("battleroyale.exclusive") && !(p.isOp())) {
                        ItemStack item1 = new ItemStack(Material.STONE_PICKAXE);
                        ItemMeta meta1 = item1.getItemMeta();
                        meta1.addEnchant(Enchantment.DIG_SPEED, 3, true);
                        item1.setItemMeta(meta1);
                        ItemStack item2 = new ItemStack(Material.STONE_SWORD);
                        ItemMeta meta2 = item2.getItemMeta();
                        meta2.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                        item2.setItemMeta(meta2);
                        ItemStack item3 = new ItemStack(Material.STONE_AXE);
                        ItemMeta meta3 = item3.getItemMeta();
                        meta3.addEnchant(Enchantment.DIG_SPEED, 3, true);
                        item3.setItemMeta(meta3);
                        ItemStack item4 = new ItemStack(Material.STONE_AXE);
                        ItemMeta meta4 = item4.getItemMeta();
                        meta4.addEnchant(Enchantment.DIG_SPEED, 3, true);
                        item4.setItemMeta(meta4);
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(item1);
                        p.getInventory().addItem(item2);
                        p.getInventory().addItem(item3);
                        p.getInventory().addItem(item4);
                        if (maxcount == counter) {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        } else {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        }
                    }
                    if (p.hasPermission("battleroyale.elite") && !(p.isOp())) {
                        ItemStack item1 = new ItemStack(Material.IRON_PICKAXE);
                        ItemMeta meta1 = item1.getItemMeta();
                        meta1.addEnchant(Enchantment.DIG_SPEED, 1, true);
                        item1.setItemMeta(meta1);
                        ItemStack item2 = new ItemStack(Material.IRON_SWORD);
                        ItemMeta meta2 = item2.getItemMeta();
                        meta2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        item2.setItemMeta(meta2);
                        ItemStack item3 = new ItemStack(Material.IRON_AXE);
                        ItemMeta meta3 = item3.getItemMeta();
                        meta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                        item3.setItemMeta(meta3);
                        ItemStack item4 = new ItemStack(Material.IRON_AXE);
                        ItemMeta meta4 = item4.getItemMeta();
                        meta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                        item4.setItemMeta(meta4);
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(item1);
                        p.getInventory().addItem(item2);
                        p.getInventory().addItem(item3);
                        p.getInventory().addItem(item4);
                        if (maxcount == counter) {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        } else {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        }
                    }
                    if (p.hasPermission("battleroyale.legend") && !(p.isOp())) {
                        ItemStack item1 = new ItemStack(Material.IRON_PICKAXE);
                        ItemMeta meta1 = item1.getItemMeta();
                        meta1.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item1.setItemMeta(meta1);
                        ItemStack item2 = new ItemStack(Material.IRON_SWORD);
                        ItemMeta meta2 = item2.getItemMeta();
                        meta2.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                        item2.setItemMeta(meta2);
                        ItemStack item3 = new ItemStack(Material.IRON_AXE);
                        ItemMeta meta3 = item3.getItemMeta();
                        meta3.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item3.setItemMeta(meta3);
                        ItemStack item4 = new ItemStack(Material.IRON_AXE);
                        ItemMeta meta4 = item4.getItemMeta();
                        meta4.addEnchant(Enchantment.DIG_SPEED, 2, true);
                        item4.setItemMeta(meta4);
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(item1);
                        p.getInventory().addItem(item2);
                        p.getInventory().addItem(item3);
                        p.getInventory().addItem(item4);
                        if (maxcount == counter) {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        } else {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        }
                    }
                    if (p.hasPermission("battleroyale.sponsor") || p.isOp()) {
                        inv.addItem(new ItemStack[0]);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_PICKAXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_SWORD)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_AXE)});
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_SPADE)});
                        if (maxcount == counter) {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT_LAST"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        } else {
                            p.sendMessage(Main.getInstance().getMSG("RESPAWNED_WITH_LOOT"));
                            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                                p.teleport(p.getBedSpawnLocation());
                            }, 20L * 3);
                        }
                    } else {
                        p.sendMessage(Main.getInstance().getMSG("RESPAWNED"));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                            p.teleport(p.getBedSpawnLocation());
                        }, 20L * 3);
                    }
                }
            }  else {
                p.sendMessage("§cСмерть...");
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                    p.teleport(new Location(Bukkit.getWorld("game"), 0.0, 100.0, 0.0));
                }, 20L * 5);
                Bukkit.getScheduler().runTaskLater(Main.getInstance(),() -> {
                    p.setGameMode(GameMode.SPECTATOR);
                }, 20L * 6);
            }

        }
        }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        World world = e.getEntity().getWorld();
        Player pl = e.getEntity().getPlayer();
        if (world.getName() != "world") {
            if (pl.getBedSpawnLocation() != null) {
                counter = counter + 1;
                if (pl.hasPermission("battleroyale.exclusive") && !(pl.isOp())) {
                    maxcount = 2;
                }
                if ((pl.hasPermission("battleroyale.elite") || pl.hasPermission("battleroyale.legend")) && !(pl.isOp())) {
                    maxcount = 3;
                }
                if (pl.hasPermission("battleroyale.sponsor") || pl.isOp()) {
                    maxcount = 5;
                } else {
                    maxcount = 1;
                }
                if (counter > maxcount) {
                    pl.setGameMode(GameMode.SPECTATOR);
                }
            } else {
                pl.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}