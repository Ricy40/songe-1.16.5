package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;

import com.ricy40.songe.common.items.SongeItem;
import com.ricy40.songe.core.enums.ModArmorMaterial;
import com.ricy40.songe.core.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Songe.MOD_ID);

	public static final RegistryObject<Item> SONGE = ITEMS.register("songe", () -> new Item(new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.COMMON)));
	public static final RegistryObject<Item> SPECIAL_SONGE = ITEMS.register("special_songe", () -> new SongeItem (new Item.Properties().tab(Songe.SONGE_GROUP).fireResistant().rarity(Rarity.UNCOMMON)));

	//Songe Tools

	public static final RegistryObject<Item> SONGE_SWORD = ITEMS.register("songe_sword", () -> new SwordItem(ModItemTier.SONGE, 3, -2.4f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_PICKAXE = ITEMS.register("songe_pickaxe", () -> new PickaxeItem(ModItemTier.SONGE, 1, -2.8f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_SHOVEL = ITEMS.register("songe_shovel", () -> new ShovelItem(ModItemTier.SONGE, 1.5f, -3.0f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_HOE = ITEMS.register("songe_hoe", () -> new HoeItem(ModItemTier.SONGE, 2, -1.0f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_AXE = ITEMS.register("songe_axe", () -> new AxeItem(ModItemTier.SONGE, 6.0f, -3.1f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	//Songe Armor

	public static final RegistryObject<Item> SONGE_HELMET = ITEMS.register("songe_helmet", () -> new ArmorItem(ModArmorMaterial.SONGE, EquipmentSlotType.HEAD, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_CHESTPLATE = ITEMS.register("songe_chestplate", () -> new ArmorItem(ModArmorMaterial.SONGE, EquipmentSlotType.CHEST, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_LEGGINGS = ITEMS.register("songe_leggings", () -> new ArmorItem(ModArmorMaterial.SONGE, EquipmentSlotType.LEGS, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> SONGE_BOOT	= ITEMS.register("songe_boots", () -> new ArmorItem(ModArmorMaterial.SONGE, EquipmentSlotType.FEET, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	//Raw Stuff

	public static final  RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties().tab(Songe.SONGE_GROUP)));
	public static final  RegistryObject<Item> RAW_THALLASIUM = ITEMS.register("raw_thallasium", () -> new Item(new Item.Properties().tab(Songe.SONGE_GROUP)));
	public static final  RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", () -> new Item(new Item.Properties().tab(Songe.SONGE_GROUP)));

	//Brass Tools
	
	public static final RegistryObject<Item> BRASS_PICKAXE = ITEMS.register("brass_pickaxe", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, new Item.Properties().tab(Songe.SONGE_GROUP)));
	public static final RegistryObject<Item> BRASS_SHOVEL = ITEMS.register("brass_shovel", () -> new ShovelItem(ItemTier.IRON, 1.5F, -3.0F, new Item.Properties().tab(Songe.SONGE_GROUP)));
	public static final RegistryObject<Item> BRASS_HOE = ITEMS.register("brass_hoe", () -> new HoeItem(ItemTier.IRON, 0, -3.0F, new Item.Properties().tab(Songe.SONGE_GROUP)));
	public static final RegistryObject<Item> BRASS_AXE = ITEMS.register("brass_axe", () -> new AxeItem(ItemTier.IRON, 6.0F, -3.0F, new Item.Properties().tab(Songe.SONGE_GROUP)));


}
	