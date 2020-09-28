package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class AridHighlandsBiomes {
	static final Biome ARID_HIGHLANDS = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(TraverseSurfaceBuilders.ARID_HIGHLANDS, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.DESERT_LAKES, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DESERT_VEGETATION, DefaultFeature.DESERT_FEATURES, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.SAVANNA_GRASS, DefaultFeature.SAVANNA_TREES)
			.addStructureFeature(ConfiguredStructureFeatures.VILLAGE_DESERT)
			.addStructureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_DESERT)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG)
					.decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.5F, 1))))
			.precipitation(Biome.Precipitation.NONE)
			.addDefaultAmbientSpawnEntries()
			.addDefaultMonsterSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.HUSK, 80, 4, 4))
			.category(Biome.Category.DESERT)
			.depth(1.3F)
			.scale(0.3F)
			.temperature(2.0F)
			.downfall(0.0F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0xBACD78)
					.foliageColor(0x80A02E)
			)
			.build();
}
