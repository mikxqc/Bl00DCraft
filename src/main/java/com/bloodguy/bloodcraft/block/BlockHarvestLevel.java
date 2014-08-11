package com.bloodguy.bloodcraft.block;

import com.bloodguy.bloodcraft.Main;

public class BlockHarvestLevel {

	public static void SetHarvestLevel() {
		//Tier 0
		Main.trilliumOre.setHarvestLevel("pickaxe", 2);
		//Tier 0.5
		Main.cobaltOre.setHarvestLevel("pickaxe", 3);
		//Tier 1
		Main.DesolatedOre.setHarvestLevel("pickaxe", 4);
		Main.DesolatedStone.setHarvestLevel("pickaxe", 4);
	}

}
