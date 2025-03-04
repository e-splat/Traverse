package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OceanConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreePlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier;

import java.util.ArrayList;
import java.util.List;

import static com.terraformersmc.traverse.feature.TraverseConfiguredFeatures.register;

public class TraversePlacedFeatures {

	/* Shrubs */
	public static final RegistryEntry<PlacedFeature> ARID_SHRUBS = createPlacedFeature("arid_shrubs", TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(0, 0.5f, 1));
	public static final RegistryEntry<PlacedFeature> DESERT_SHRUBS = createPlacedFeature("desert_shrubs", TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(1, 0.1f, 1));

	/* Autumnal Trees */
	private static final RegistryEntry<PlacedFeature> RED_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("red_autumnal_tree", TraverseConfiguredFeatures.RED_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> ORANGE_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("orange_autumnal_tree", TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> YELLOW_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("yellow_autumnal_tree", TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> BROWN_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("brown_autumnal_tree", TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE);
	private static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> AUTUMNAL_TREES_CONFIGURED = register("autumnal_trees",
			Feature.RANDOM_SELECTOR,
			new RandomFeatureConfig(
					ImmutableList.of(
							new RandomFeatureEntry(RED_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(ORANGE_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(YELLOW_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(BROWN_AUTUMNAL_TREE, 0.25F)
					), TreePlacedFeatures.OAK_CHECKED
			)
	);
	public static final RegistryEntry<PlacedFeature> AUTUMNAL_TREES = createPlacedFeature("autumnal_trees", AUTUMNAL_TREES_CONFIGURED, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(10, 0.1f, 1));

	/* Low Ores */
	public static final RegistryEntry<PlacedFeature> LOW_DIRT = createPlacedFeature("low_dirt", TraverseConfiguredFeatures.LOW_DIRT, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(70)), SquarePlacementModifier.of(), CountPlacementModifier.of(10));
	public static final RegistryEntry<PlacedFeature> LOW_GRAVEL = createPlacedFeature("low_gravel", TraverseConfiguredFeatures.LOW_GRAVEL, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(70)), SquarePlacementModifier.of(), CountPlacementModifier.of(8));
	public static final RegistryEntry<PlacedFeature> LOW_GRANITE = createPlacedFeature("low_granite", TraverseConfiguredFeatures.LOW_GRANITE, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(70)), SquarePlacementModifier.of(), CountPlacementModifier.of(10));
	public static final RegistryEntry<PlacedFeature> LOW_DIORITE = createPlacedFeature("low_diorite", TraverseConfiguredFeatures.LOW_DIORITE, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(70)), SquarePlacementModifier.of(), CountPlacementModifier.of(10));
	public static final RegistryEntry<PlacedFeature> LOW_ANDESITE = createPlacedFeature("low_andesite", TraverseConfiguredFeatures.LOW_ANDESITE, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(70)), SquarePlacementModifier.of(), CountPlacementModifier.of(10));

	/* Fir Trees */
	public static final RegistryEntry<PlacedFeature> CONIFEROUS_TREES = createPlacedFeature("coniferous_trees", TraverseConfiguredFeatures.FIR_TREE, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(7, 0.1f, 1));

	/* Swamp Trees */
	public static final RegistryEntry<PlacedFeature> TALL_SWAMP_TREE = createPlacedFeature("tall_swamp_tree", TraverseConfiguredFeatures.TALL_SWAMP_TREE, SurfaceWaterDepthFilterPlacementModifier.of(1));
	public static final RegistryEntry<PlacedFeature> LUSH_SWAMP_TREES = createPlacedFeature("lush_swamp_trees", TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(2, 0.1f, 1), SurfaceWaterDepthFilterPlacementModifier.of(1));

	/* Lush Vegetation */
	public static final RegistryEntry<PlacedFeature> LUSH_FLOWERS = createPlacedFeature("lush_flowers", TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, CountPlacementModifier.of(10));
	public static final RegistryEntry<PlacedFeature> MEADOW_GRASS = createPlacedFeature("meadow_grass", TraverseConfiguredFeatures.MEADOW_GRASS, VegetationPlacedFeatures.modifiers(15));
	public static final RegistryEntry<PlacedFeature> MEADOW_TREES = createPlacedFeature("meadow_trees", TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.createCountExtraModifier(0, 0.2F, 1));
	public static final RegistryEntry<PlacedFeature> ROLLING_HILLS_GRASS = createPlacedFeature("rolling_hills_grass", TraverseConfiguredFeatures.ROLLING_HILLS_GRASS, VegetationPlacedFeatures.modifiers(3));
	public static final RegistryEntry<PlacedFeature> ROLLING_HILLS_TREES = createPlacedFeature("rolling_hills_trees", TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(2, 0.2f, 1));

	/* Mini Jungle */
	public static final RegistryEntry<PlacedFeature> MINI_JUNGLE_SEAGRASS = createPlacedFeature("mini_jungle_seagrass", OceanConfiguredFeatures.SEAGRASS_SHORT, PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP);
	public static final RegistryEntry<PlacedFeature> MINI_JUNGLE_TREES = createPlacedFeature("mini_jungle_trees", TraverseConfiguredFeatures.MINI_JUNGLE_TREES, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), PlacedFeatures.createCountExtraModifier(50, 0.1f, 1));

	/* Rocky Edge */
	public static final RegistryEntry<PlacedFeature> ROCKY_EDGE_BOULDER = createPlacedFeature("rocky_edge_boulder", TraverseConfiguredFeatures.ROCKY_EDGE_BOULDER, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(),  CountPlacementModifier.of(2));

	/* Woodlands */
	private static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WOODLANDS_TREES_CONFIGURED = register("woodlands_trees", Feature.RANDOM_SELECTOR,
					new RandomFeatureConfig(
							ImmutableList.of(
									new RandomFeatureEntry(createPlacedFeatureWithoutBiomeFilter("oak_shrub", TraverseConfiguredFeatures.OAK_SHRUB), 0.2F),
									new RandomFeatureEntry(createPlacedFeatureWithoutBiomeFilter("fallen_oak_tree", register("fallen_aok_tree", Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG)), 0.3F)
							), TreePlacedFeatures.OAK_CHECKED));
	public static final RegistryEntry<PlacedFeature> WOODLANDS_TREES = createPlacedFeature("woodlands_trees", WOODLANDS_TREES_CONFIGURED, PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), CountPlacementModifier.of(7));

	public static void init(){
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		list.add(BiomePlacementModifier.of());
		return createPlacedFeature(id, feature, list);
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeatureWithoutBiomeFilter(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		return createPlacedFeature(id, feature, list);
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
		Identifier realID = new Identifier(Traverse.MOD_ID, id);
		if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
			throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

		return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
	}
}
