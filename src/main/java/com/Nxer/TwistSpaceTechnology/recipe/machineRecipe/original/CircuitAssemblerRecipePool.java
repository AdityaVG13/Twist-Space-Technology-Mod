package com.Nxer.TwistSpaceTechnology.recipe.machineRecipe.original;

import static gregtech.api.enums.TierEU.RECIPE_UIV;

import com.Nxer.TwistSpaceTechnology.common.init.GTCMItemList;
import com.Nxer.TwistSpaceTechnology.recipe.IRecipePool;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IRecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialMisc;
import tectech.thing.CustomItemList;

public class CircuitAssemblerRecipePool implements IRecipePool {

    @Override
    public void loadRecipes() {

        final IRecipeMap CA = RecipeMaps.circuitAssemblerRecipes;

        // Optical Soc Circuit Assembly Line

        GTValues.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Board_Optical.get(16),
                GTCMItemList.OpticalSOC.get(1),
                CustomItemList.DATApipe.get(16),
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Infinity, 3))
            .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(144 * 3))
            .itemOutputs(ItemList.Circuit_OpticalProcessor.get(16))
            .eut(RECIPE_UIV)
            .duration(20 * 60)
            .addTo(CA);
    }
}
