/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bridge.bukkit.entity;

import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;

import org.spout.vanilla.component.living.Living;
import org.spout.vanilla.component.living.hostile.Zombie;
import org.spout.vanilla.component.substance.object.ObjectEntity;
import org.spout.vanilla.protocol.entity.creature.CreatureType;
import org.spout.vanilla.protocol.entity.object.ObjectType;

/**
 * Creates BridgeEntity and BridgePlayer objects upon request
 */
public final class EntityFactory {
	/**
	 * Creates a BridgeEntity from a SpoutAPI Entity. If the Entity is a Player,
	 * this method will return a BridgePlayer object instead of a plain
	 * BridgeEntity
	 * @param entity The SpoutAPI Entity to create a BridgeEntity from
	 * @return The BridgeEntity that represents the SpoutAPI Entity
	 */
	public static BridgeEntity createEntity(Entity entity) {
		if (entity instanceof Player) {
			return createPlayer((Player) entity);
		}
		Living living = entity.get(Living.class);
		if (living != null) {
			switch (CreatureType.get(living.getClass())) {
				case BAT:
					return null; // TODO: implement Bat
				case BLAZE:
					return new BridgeBlaze(entity);
				case CAVE_SPIDER:
					return new BridgeCaveSpider(entity);
				case CHICKEN:
					return new BridgeChicken(entity);
				case COW:
					return new BridgeCow(entity);
				case CREEPER:
					return new BridgeCreeper(entity);
				case ENDER_DRAGON:
					return new BridgeEnderDragon(entity);
				case ENDERMAN:
					return new BridgeEnderman(entity);
				case GHAST:
					return new BridgeGhast(entity);
				case GIANT:
					return new BridgeGiant(entity);
				case IRON_GOLEM:
					return new BridgeIronGolem(entity);
				case MAGMA_CUBE:
					return new BridgeMagmaCube(entity);
				case MUSHROOM_COW:
					return new BridgeMushroomCow(entity);
				case OCELOT:
					return new BridgeOcelot(entity);
				case PIG:
					return new BridgePig(entity);
				case PIG_ZOMBIE:
					return new BridgePigZombie(entity);
				case SHEEP:
					return new BridgeSheep(entity);
				case SILVERFISH:
					return new BridgeSilverfish(entity);
				case SKELETON:
					return new BridgeSkeleton(entity);
				case SLIME:
					return new BridgeSlime(entity);
				case SNOW_GOLEM:
					return new BridgeSnowman(entity);
				case SPIDER:
					return new BridgeSpider(entity);
				case SQUID:
					return new BridgeSquid(entity);
				case VILLAGER:
					return new BridgeVillager(entity);
				case WOLF:
					return new BridgeWolf(entity);
				case ZOMBIE:
					return new BridgeZombie(entity);
				default:
					return null;
			}
		}
		ObjectEntity object = entity.get(ObjectEntity.class);
		if (object != null) {
			switch (ObjectType.get(object.getClass())) {
				case BOAT:
					return new BridgeBoat(entity);
				case ITEM:
					return new BridgeItem(entity);
				case MINECART:
					return new BridgeMinecart(entity);
				case STORAGE_MINECART:
					return new BridgeStorageMinecart(entity);
				case POWERED_MINECART:
					return new BridgePoweredMinecart(entity);
				case PRIMED_TNT:
					return new BridgeTNTPrimed(entity);
				case ENDER_CRYSTAL:
					return new BridgeEnderCrystal(entity);
				case ARROW:
					return new BridgeArrow(entity);
				case SNOWBALL:
					return new BridgeSnowball(entity);
				case EGG:
					return new BridgeEgg(entity);
				case ENDER_PEARL:
					return new BridgeEnderPearl(entity);
				case WITHER_SKULL:
					return null; //TODO: implement Wither skulls
				case FALLING_OBJECT:
					return new BridgeFallingSand(entity); //TODO: not sure if this is 100% correct
				case ITEM_FRAME:
					return null; //TODO: implement item frames
				case EYE_OF_ENDER:
					return null; //TODO: implement Eye of Ender
				case POTION:
					return new BridgeThrownPotion(entity);
				case DRAGON_EGG:
					return null; //TODO implement Dragon egg
				case EXP_BOTTLE:
					return new BridgeThrownExpBottle(entity);
				case FIREWORKS_ROCKET:
					return null; //TODO: implement Fireworks
				case FISHING_BOB:
					return new BridgeFish(entity);
				default:
					return null;
			}
		}
		return null;
	}

	/**
	 * Creates a BridgePlayer from a SpoutAPI Player
	 * @param player The SpoutAPI Player to create a BridgePlayer from
	 * @return The BridgePlayer that represents the SpoutAPI Player
	 */
	public static BridgePlayer createPlayer(Player player) {
		return new BridgePlayer(player);
	}
}
