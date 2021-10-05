package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;

import com.ricy40.songe.common.items.SongeItem;
import com.ricy40.songe.core.enums.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, Songe.MOD_ID);
	
	public static final RegistryObject<Item> SONGE = ITEMS.register("songe",
			() -> new Item(new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.COMMON)));

	public static final RegistryObject<Item> SPECIAL_SONGE = ITEMS.register("special_songe",
			() -> new SongeItem (new Item.Properties().tab(Songe.SONGE_GROUP).fireResistant().rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> SONGE_SWORD = ITEMS.register("songe_sword",
			() -> new SwordItem(ModItemTier.SONGE, 3, -2.4f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> SONGE_PICKAXE = ITEMS.register("songe_pickaxe",
			() -> new PickaxeItem(ModItemTier.SONGE, 1, -2.8f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> SONGE_SHOVEL = ITEMS.register("songe_shovel",
			() -> new ShovelItem(ModItemTier.SONGE, 1.5f, -3.0f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> SONGE_HOE = ITEMS.register("songe_hoe",
			() -> new HoeItem(ModItemTier.SONGE, 2, -1.0f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> SONGE_AXE	 = ITEMS.register("songe_axe",
			() -> new AxeItem(ModItemTier.SONGE, 6.0f, -3.1f, new Item.Properties().tab(Songe.SONGE_GROUP).rarity(Rarity.RARE)));
}
	