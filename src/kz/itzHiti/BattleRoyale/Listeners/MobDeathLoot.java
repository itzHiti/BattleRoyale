package kz.itzHiti.BattleRoyale.Listeners;

import kz.itzHiti.BattleRoyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Random;

public class MobDeathLoot implements Listener {

    @EventHandler
    public void onMobDeath (EntityDeathEvent e) {
        Random random = new Random();
        /*Рандомы*/
        int randomNumber = random.nextInt((5 - 2)+ 1) + 2;
        int randomNumber2 = random.nextInt((5 - 3) + 1) + 3;
        int randomNumber3 = random.nextInt((3 - 2) + 1) + 2;
        int randomNumber4 = random.nextInt((3 - 2) + 1) + 2;
        int randomNumber5 = random.nextInt((4 - 3) + 1) + 3;
        int randomNumber6 = random.nextInt((8 - 5) + 1) + 5;
        if (e.getEntity() instanceof Player) {
            return;
        }
            else {
                if (e.getEntity() instanceof Monster) {
                    e.getDrops().clear(); /*Очистка дропа с моба :)*/
                    /*Айтем стаки*/
                    ItemStack stack = new ItemStack(Material.BREAD, randomNumber);
                    ItemStack stack2 = new ItemStack(Material.APPLE, randomNumber2);
                    ItemStack stack3 = new ItemStack(Material.IRON_INGOT, randomNumber3);
                    ItemStack stack4 = new ItemStack(Material.DIAMOND, randomNumber4);
                    ItemStack stack5 = new ItemStack(Material.GOLD_INGOT, randomNumber5);
                    ItemStack stack6 = new ItemStack(Material.LAPIS_ORE, randomNumber6);
                    ItemStack stack7 = new ItemStack(Material.DIAMOND_HELMET, 1);
                    ItemStack stack8 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                    ItemStack stack9 = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                    ItemStack stack10 = new ItemStack(Material.DIAMOND_BOOTS, 1);
                    ItemStack stack11 = new ItemStack(Material.IRON_HELMET, 1);
                    ItemStack stack12 = new ItemStack(Material.IRON_CHESTPLATE, 1);
                    ItemStack stack13 = new ItemStack(Material.IRON_LEGGINGS, 1);
                    ItemStack stack14 = new ItemStack(Material.IRON_BOOTS, 1);
                    ItemStack stack15 = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemStack stack16 = new ItemStack(Material.IRON_SWORD, 1);
                    ItemStack stack17 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                    ItemStack stack18 = new ItemStack(Material.IRON_PICKAXE, 1);
                    ItemStack stack19 = new ItemStack(Material.POTION, 1);
                    ItemStack stack20 = new ItemStack(Material.POTION, 1);
                    ItemStack stack21 = new ItemStack(Material.POTION, 1);
                    ItemStack stack22 = new ItemStack(Material.POTION, 1);
                    ItemStack stack23 = new ItemStack(Material.SPLASH_POTION, 1);

                    /*Мета вещей*/
                    ItemMeta stackmeta = stack7.getItemMeta();
                    stackmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack7.setItemMeta(stackmeta);
                    ItemMeta stackmeta2 = stack8.getItemMeta();
                    stackmeta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack8.setItemMeta(stackmeta2);
                    ItemMeta stackmeta3 = stack9.getItemMeta();
                    stackmeta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack9.setItemMeta(stackmeta3);
                    ItemMeta stackmeta4 = stack10.getItemMeta();
                    stackmeta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack10.setItemMeta(stackmeta4);
                    ItemMeta stackmeta5 = stack11.getItemMeta();
                    stackmeta5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack11.setItemMeta(stackmeta5);
                    ItemMeta stackmeta6 = stack12.getItemMeta();
                    stackmeta6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack12.setItemMeta(stackmeta6);
                    ItemMeta stackmeta7 = stack13.getItemMeta();
                    stackmeta7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack13.setItemMeta(stackmeta7);
                    ItemMeta stackmeta8 = stack14.getItemMeta();
                    stackmeta8.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    stack14.setItemMeta(stackmeta8);
                    ItemMeta stackmeta9 = stack15.getItemMeta();
                    stackmeta9.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                    stack15.setItemMeta(stackmeta9);
                    ItemMeta stackmeta10 = stack16.getItemMeta();
                    stackmeta10.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    stack16.setItemMeta(stackmeta10);
                    ItemMeta stackmeta11 = stack17.getItemMeta();
                    stackmeta11.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    stack17.setItemMeta(stackmeta11);
                    ItemMeta stackmeta12 = stack18.getItemMeta();
                    stackmeta12.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    stack18.setItemMeta(stackmeta12);
                    PotionMeta stackmeta13 = (PotionMeta) stack19.getItemMeta();
                    stackmeta13.setBasePotionData(new PotionData(PotionType.STRENGTH, false, false));
                    stack19.setItemMeta(stackmeta13);
                    PotionMeta stackmeta14 = (PotionMeta) stack20.getItemMeta();
                    stackmeta14.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
                    stack20.setItemMeta(stackmeta14);
                    PotionMeta stackmeta15 = (PotionMeta) stack21.getItemMeta();
                    stackmeta15.setBasePotionData(new PotionData(PotionType.REGEN, false, false));
                    stack21.setItemMeta(stackmeta15);
                    PotionMeta stackmeta16 = (PotionMeta) stack22.getItemMeta();
                    stackmeta16.setBasePotionData(new PotionData(PotionType.REGEN, false, true));
                    stack22.setItemMeta(stackmeta16);
                    PotionMeta stackmeta17 = (PotionMeta) stack23.getItemMeta();
                    stackmeta17.setBasePotionData(new PotionData(PotionType.POISON, false, false));
                    stack23.setItemMeta(stackmeta17);

                    /*Изменение дропов + шансы*/
                    int d = (int) (Math.random() * 500);
                    if (d <= 5) {
                        e.getDrops().add(stack);
                    }
                    if (d >= 6 && d <= 11) {
                        e.getDrops().add(stack2);
                    }
                    if (d >= 13 && d <= 17) {
                        e.getDrops().add(stack3);
                    }
                    if (d >= 18 && d <= 22) {
                        e.getDrops().add(stack4);
                    }
                    if (d >= 23 && d <= 27) {
                        e.getDrops().add(stack5);
                    }
                    if (d >= 28 && d <= 32) {
                        e.getDrops().add(stack6);
                    }
                    if (d >= 33 && d <= 34.4) {
                        e.getDrops().add(stack7);
                    }
                    if (d >= 34.5 && d <= 35.9) {
                        e.getDrops().add(stack8);
                    }
                    if (d >= 36 && d <= 37.4) {
                        e.getDrops().add(stack9);
                    }
                    if (d >= 38.5 && d <= 39.9) {
                        e.getDrops().add(stack10);
                    }
                    if (d >= 40 && d <= 42.4) {
                        e.getDrops().add(stack11);
                    }
                    if (d >= 42.5 && d <= 44.9) {
                        e.getDrops().add(stack12);
                    }
                    if (d >= 45 && d <= 47.4) {
                        e.getDrops().add(stack13);
                    }
                    if (d >= 47.5 && d <= 49.5) {
                        e.getDrops().add(stack14);
                    }
                    if (d >= 50 && d <= 51.2) {
                        e.getDrops().add(stack15);
                    }
                    if (d >= 51.3 && d <= 53.6) {
                        e.getDrops().add(stack16);
                    }
                    if (d >= 53.7 && d <= 55.4) {
                        e.getDrops().add(stack17);
                    }
                    if (d >= 55.5 && d <= 57.6) {
                        e.getDrops().add(stack18);
                    }
                    if (d >= 57.7 && d <= 58.9) {
                        e.getDrops().add(stack19);
                    }
                    if (d >= 59 && d <= 59.5) {
                        e.getDrops().add(stack20);
                    }
                    if (d >= 59.6 && d <= 60.8) {
                        e.getDrops().add(stack21);
                    }
                    if (d >= 60.9 && d <= 61.6) {
                        e.getDrops().add(stack22);
                    }
                    if (d >= 61.7 && d <= 62.9) {
                        e.getDrops().add(stack23);
                    }
                    if (d >= 63) {
                        if (e.getEntity().getKiller() instanceof Player) {
                            e.getEntity().getKiller().sendMessage(Main.getInstance().getMSG("NO_DROP"));
                        }
                    }
                }
        }
    }
}
