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

        //withExistingParent("exampleblock", modLoc("block/exampleblock"));

        //ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        //builder(itemGenerated, "example_item");

    }
    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}