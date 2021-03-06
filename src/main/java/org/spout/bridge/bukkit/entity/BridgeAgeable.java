/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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

import org.bukkit.entity.Ageable;

import org.spout.api.entity.Entity;

import org.spout.vanilla.data.VanillaData;

public abstract class BridgeAgeable extends BridgeCreature implements Ageable {
	protected BridgeAgeable(Entity handle) {
		super(handle);
	}

	@Override
	public int getAge() {
		return getHandle().getData().get(VanillaData.AGE).intValue() * 20;
	}

	@Override
	public void setAge(int i) {
		getHandle().get(org.spout.vanilla.component.entity.living.Ageable.class).setAge(i / 20);
	}

	@Override
	public void setAgeLock(boolean b) {
	}

	@Override
	public boolean getAgeLock() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBaby() {
		setAge((int) org.spout.vanilla.component.entity.living.Ageable.MIN_AGE * 20);
	}

	@Override
	public void setAdult() {
		setAge(0);
	}

	@Override
	public boolean isAdult() {
		return getAge() >= 0;
	}

	@Override
	public boolean canBreed() {
		return getAge() == 0;
	}

	@Override
	public void setBreed(boolean b) {
		if (b) {
			setAge(0);
		} else {
			setAge(6000);
		}
	}
}
