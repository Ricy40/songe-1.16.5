package com.ricy40.songe.data.client;

import com.ricy40.songe.Songe;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SongeModelProvider extends ItemModelProvider
{
    public SongeModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Songe.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {

        withExistingParent("marble_cobblestone", modLoc("block/marble_cobblestone"));
        withExistingParent("jasper_cobblestone", modLoc("block/jasper_cobblestone"));
        withExistingParent("slate_cobblestone", modLoc("block/slate_cobblestone"));
        withExistingParent("basalt_cobblestone", modLoc("block/basalt_cobblestone"));

        withExistingParent("marble_cobblestone_slab", modLoc("block/marble_cobblestone_slab"));
        withExistingParent("jasper_cobblestone_slab", modLoc("block/jasper_cobblestone_slab"));
        withExistingParent("slate_cobblestone_slab", modLoc("block/slate_cobblestone_slab"));
        withExistingParent("basalt_cobblestone_slab", modLoc("block/basalt_cobblestone_slab"));

        withExistingParent("marble_cobblestone_stairs", modLoc("block/marble_cobblestone_stairs"));
        withExistingParent("jasper_cobblestone_stairs", modLoc("block/jasper_cobblestone_stairs"));
        withExistingParent("slate_cobblestone_stairs", modLoc("block/slate_cobblestone_stairs"));
        withExistingParent("basalt_cobblestone_stairs", modLoc("block/basalt_cobblestone_stairs"));

        withExistingParent("marble_cobblestone_wall", modLoc("block/marble_cobblestone_wall_inventory"));
        withExistingParent("jasper_cobblestone_wall", modLoc("block/jasper_cobblestone_wall_inventory"));
        withExistingParent("slate_cobblestone_wall", modLoc("block/slate_cobblestone_wall_inventory"));
        withExistingParent("basalt_cobblestone_wall", modLoc("block/basalt_cobblestone_wall_inventory"));

        withExistingParent("marble_cobblestone_vertical_slab", modLoc("block/marble_cobblestone_vertical_slab"));
        withExistingParent("jasper_cobblestone_vertical_slab", modLoc("block/jasper_cobblestone_vertical_slab"));
        withExistingParent("slate_cobblestone_vertical_slab", modLoc("block/slate_cobblestone_vertical_slab"));
        withExistingParent("basalt_cobblestone_vertical_slab", modLoc("block/basalt_cobblestone_vertical_slab"));
        
        //ModelFile itemGenerated = getExistingFile(mcLoc("block/marble_cobblestone"));
        //builder(itemGenerated, "marble_cobblestone");

    }
    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

}