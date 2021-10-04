package com.ricy40.songe.core.init;

import com.ricy40.songe.Songe;

import com.ricy40.songe.common.items.SongeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Songe.MOD_ID);
	
	public static final RegistryObject<Item> SONGE = ITEMS
			.register("songe",
					() -> new Item(new Item.Properties()
							.tab(Songe.SONGE_GROUP)
							.rarity(Rarity.COMMON)));

	public static final RegistryObject<SongeItem> SPECIAL_SONGE = ITEMS
			.register("special_songe",
					() -> new SongeItem (new Item.Properties()
							.tab(Songe.SONGE_GROUP)
							.fireResistant()
							.rarity(Rarity.UNCOMMON)));

}
	