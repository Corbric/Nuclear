package io.github.corbric.nuclear.world.gen;

import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkCoordinateRange;
import net.minecraft.world.chunk.ChunkProvider;
import net.minecraft.world.chunk.EndChunkGenerator;

public class EmptyChunkProvider extends EndChunkGenerator {
	private final World accessibleWorld;

	public EmptyChunkProvider(World world, long l) {
		super(world, l);
		this.accessibleWorld = world;
	}

	@Override
	public void method_1516(int i, int j, ChunkCoordinateRange chunkCoordinateRange) {
	}

	@Override
	public void method_1517(ChunkCoordinateRange chunkCoordinateRange) {
	}
}
