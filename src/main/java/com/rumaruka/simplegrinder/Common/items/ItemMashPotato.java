package com.rumaruka.simplegrinder.Common.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemMashPotato extends ItemFood {
	public final int itemUseDuration;
	/** The amount this food item heals the player. */
	private final int healAmount;
	private final float saturationModifier;
	/** Whether wolves like this food (true for raw and cooked porkchop). */
	private final boolean isWolfsFavoriteMeat;
	/**
	 * If this field is true, the food can be consumed even if the player don't
	 * need to eat.
	 */
	private boolean alwaysEdible;
	/**
	 * represents the potion effect that will occurr upon eating this food. Set
	 * by setPotionEffect
	 */
	private int potionId;
	/** set by setPotionEffect */
	private int potionDuration;
	/** set by setPotionEffect */
	private int potionAmplifier;
	/** probably of the set potion effect occurring */
	private float potionEffectProbability;
	private static final String __OBFID = "CL_00000036";

	public ItemMashPotato(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		this.itemUseDuration = 32;
		this.healAmount = p_i45339_1_;
		this.isWolfsFavoriteMeat = p_i45339_3_;
		this.saturationModifier = p_i45339_2_;
		
	}

	 protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	    {
	        if (!worldIn.isRemote)
	        {
	            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0));
	        }

	        else
	        {
	            super.onFoodEaten(stack, worldIn, player);
	        }
	    }

	@Override
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add("Add after eating give" +TextFormatting.DARK_RED+ " Strength");
	}
}


