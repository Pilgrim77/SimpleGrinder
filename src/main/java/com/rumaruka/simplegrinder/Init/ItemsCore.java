package com.rumaruka.simplegrinder.Init;


import com.google.common.base.Strings;
import com.rumaruka.simplegrinder.Client.gui.creativetabs.SimpleGrinderCreativeTabs;
import com.rumaruka.simplegrinder.Common.items.ItemCoalGrinder;
import com.rumaruka.simplegrinder.Common.items.ItemDustGold;
import com.rumaruka.simplegrinder.Common.items.ItemDustIron;
import com.rumaruka.simplegrinder.Common.items.ItemFloar;
import com.rumaruka.simplegrinder.Common.items.ItemIFuel;
import com.rumaruka.simplegrinder.Common.items.ItemMachineCore;
import com.rumaruka.simplegrinder.Common.items.ItemMashCarrot;
import com.rumaruka.simplegrinder.Common.items.ItemMashPotato;
import com.rumaruka.simplegrinder.Common.items.ItemOmlete;
import com.rumaruka.simplegrinder.Common.items.ItemWoodChips;

import com.rumaruka.simplegrinder.Reference.Reference;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ItemsCore {

	public static Item dust_iron;
	public static Item dust_gold;
	public static Item flour;
	public static ItemFood mash_carrot;
	public static ItemFood mash_potato;
	public static ItemFood omlete;

	//For information
	public static ItemBlock itemmachinecore;
	public static ItemBlock itemcoalgrinder;
	//Fuel
	public static Item i_fuel;
	public static Item wood_chips;
	//Wiki



	public static void init() {

		//Main features
		dust_iron = new ItemDustIron().setUnlocalizedName("dust_iron").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		dust_gold = new ItemDustGold().setUnlocalizedName("dust_gold").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		wood_chips = new ItemWoodChips().setCreativeTab(CreativeTabs.MATERIALS).setUnlocalizedName("wood_chips").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		flour = new ItemFloar().setUnlocalizedName("flour").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		mash_carrot = (ItemFood) new ItemMashCarrot(4, 3.9F, false).setUnlocalizedName("mash_carrot").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		mash_potato = (ItemFood) new ItemMashPotato(3, 4.5F, false).setUnlocalizedName("mash_potato").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		omlete = (ItemFood) new ItemOmlete(2, 2.6F, false).setUnlocalizedName("omlete").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);
		//Fuel
		i_fuel = new ItemIFuel().setUnlocalizedName("i_fuel").setCreativeTab(SimpleGrinderCreativeTabs.TABS_SIMPLE_GRINDER);

		//ItemBlock
		itemmachinecore = new ItemMachineCore(BlocksCore.machine_core);
		itemcoalgrinder = new ItemCoalGrinder(BlocksCore.coal_grinder);


	}

	public static void InGameRegister(){
		ItemsCore.registerItem(dust_iron, dust_iron.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(dust_gold, dust_gold.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(flour, flour.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(mash_carrot, mash_carrot.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(mash_potato, mash_potato.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(i_fuel, i_fuel.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(wood_chips, wood_chips.getUnlocalizedName().substring(5));
		ItemsCore.registerItem(omlete, omlete.getUnlocalizedName().substring(5));





	}

	@Deprecated
	public static void registerItem(Item item, String name)
	{
		if (item.getRegistryName() == null && Strings.isNullOrEmpty(name))
			throw new IllegalArgumentException("Attempted to register a item with no name: " + item);
		if (item.getRegistryName() != null && !item.getRegistryName().toString().equals(name))
			throw new IllegalArgumentException("Attempted to register a item with conflicting names. Old: " + item.getRegistryName() + " New: " + name);
		ForgeRegistries.ITEMS.register(item.getRegistryName() == null ? item.setRegistryName(name) : item);
	}

	public static void Render(){
		Renders(dust_iron);
		Renders(dust_gold);
		Renders(flour);
		Renders(mash_carrot);
		Renders(mash_potato);
		Renders(i_fuel);
		Renders(wood_chips);
		Renders(omlete);
	}
	public static void Renders(Item i){

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(
				Reference.MODID + ":" + i.getUnlocalizedName().substring(5), "inventory"));

	}
}