/*
 * Copyright 2021-2023 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.qsl.rendering.entity.test;

import org.jetbrains.annotations.NotNull;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import org.quiltmc.loader.api.minecraft.ClientOnly;

// TODO - Properly adapt the ArmorItem.Type method implementations to 1.19.4 instead of "get this working"
public enum QuiltArmorMaterial implements ArmorMaterial {
	INSTANCE;

	private static final String NAME = "quilt";
	private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
	private static final int[] PROTECTION_AMOUNTS = new int[] { 3, 6, 8, 3 };
	private static final Ingredient REPAIR_INGREDIENT = Ingredient.ofTag(ItemTags.WOOL);
	@ClientOnly
	private static final Identifier TEXTURE = EntityRenderingTestmod.id("textures/models/armor/" + NAME);

	@Override
	public int m_qppofnim(ArmorItem.C_rhnguwzk c_rhnguwzk) {
		return BASE_DURABILITY[c_rhnguwzk.m_mslqofbv().getEntitySlotId()] * 50;
	}

	@Override
	public int m_eomgzgon(ArmorItem.C_rhnguwzk c_rhnguwzk) {
		return PROTECTION_AMOUNTS[c_rhnguwzk.m_mslqofbv().getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 25;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_TURTLE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return REPAIR_INGREDIENT;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public float getToughness() {
		return 4.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.15F;
	}

	@Override
	public boolean m_usaqkthb() {
		return false;
	}

	@ClientOnly
	public @NotNull Identifier getTexture() {
		return TEXTURE;
	}
}
