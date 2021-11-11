package com.ricy40.songe.data.client;


import com.ricy40.songe.Songe;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SongeBlockStateProvider extends BlockStateProvider
{
    public SongeBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Songe.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        //simpleBlock(BlockInit.EXAMPLEBLOCK.get());
    }
}