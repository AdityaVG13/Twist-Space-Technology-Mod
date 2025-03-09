package com.Nxer.TwistSpaceTechnology.common.machine;

import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.BLUE_PRINT_INFO;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.ModName;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.StructureTooComplex;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.Text_SeparatingLine;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.Tooltip_DoNotNeedMaintenance;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.textFrontBottom;
import static com.Nxer.TwistSpaceTechnology.util.TextLocalization.textUseBlueprint;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.enums.HatchElement.OutputHatch;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_DTPF_OFF;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_DTPF_ON;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FUSION1_GLOW;
import static gregtech.api.util.GTStructureUtility.ofFrame;
import static gtPlusPlus.core.block.base.BlockBaseModular.getMaterialBlock;

import java.util.Arrays;
import java.util.Collection;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.Nxer.TwistSpaceTechnology.common.init.TstBlocks;
import com.Nxer.TwistSpaceTechnology.common.machine.MachineTexture.UITextures;
import com.Nxer.TwistSpaceTechnology.common.machine.multiMachineClasses.GTCM_MultiMachineBase;
import com.Nxer.TwistSpaceTechnology.common.recipeMap.GTCMRecipe;
import com.Nxer.TwistSpaceTechnology.util.TextEnums;
import com.Nxer.TwistSpaceTechnology.util.TextLocalization;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import galaxyspace.core.register.GSBlocks;
import goodgenerator.loader.Loaders;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.HatchElementBuilder;
import gregtech.api.util.MultiblockTooltipBuilder;
import gtPlusPlus.core.block.base.BasicBlock;
import gtPlusPlus.core.material.MaterialsAlloy;

public class TST_HighEnergyStateThermalTransferDevice
    extends GTCM_MultiMachineBase<TST_HighEnergyStateThermalTransferDevice> {

    // region Class Constructor
    public TST_HighEnergyStateThermalTransferDevice(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public TST_HighEnergyStateThermalTransferDevice(String aName) {
        super(aName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new TST_HighEnergyStateThermalTransferDevice(this.mName);
    }
    // end region

    // region Structure
    private static final int baseHorizontalOffSet = 10;
    private static final int baseVerticalOffSet = 6;
    private static final int baseDepthOffSet = 2;
    private static final String STRUCTURE_PIECE_MAIN = "main";
    // spotless:off
    private static final String[][] shapeMain = new String[][]{
        {"                     ","                     ","                     ","       HHGGGHH       ","      HHHHHHHHH      ","     JGHHHHHHHGJ     ","    JGGGGGGGGGGGJ    ","    JGIIIIIIIIIGJ    ","    JGGGGGGGGGGGJ    ","     JGHHHHHHHGJ     ","      HHHHHHHHH      ","       HHHHHHH       ","                     ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HEEEEEEEH      ","     EECCCCCCCEE     ","  EEEGCCCCCCCCCGEEE  "," EGGGCCCCCCCCCCCGGGE "," EGGGCCCCCCCCCCCGGGE "," EGGGCCCCCCCCCCCGGGE ","  EEEGCCCCCCCCCGEEE  ","     EECCCCCCCEE     ","      HEEEEEEEH      ","       HGGGGGH       ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HDDDDDDDH      ","     GECCCCCCCEG     ","  GGGCCLLNNNLLCCGGG  "," GPPPPPPLNNNLPPPPPPG "," GPPPPPPLNNNLPPPPPPG "," GPPPPPPLNNNLPPPPPPG ","  GGGCCLLNNNLLCCGGG  ","     GECCCCCCCEG     ","      HDDDDDDDH      ","       HGGGGGH       ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HDDDDDDDH      ","     GECCCCCCCEG     ","  GQGCCLLNNNLLCCGSG  "," GPFPPPPBOOOAPPPPFPG "," GPFFFFPBOOOAPFFFFPG "," GPPPPPPBOOOAPPPPPPG ","  GGGCCLLNNNLLCCGGG  ","     GECCCCCCCEG     ","      HDDDDDDDH      ","       HGGGGGH       ","                     ","                     "},
        {"                     ","                     ","      HGGGGGGGH      ","     HKDDDDDDDKH     ","     GECCCCCCCEG     ","  GGGCCLLNNNLLCCGGG  "," GPPPPPPBOOOAPPPPPPG "," GPPPPFPBOOOAPFPPPPG "," GPPPPPPBOOOAPPPPPPG ","  GGGCCLLNNNLLCCGGG  ","     GECCCCCCCEG     ","     HKDDDDDDDKH     ","      HGGGGGGGH      ","                     ","                     "},
        {"                     ","                     ","      HGGGGGGGH      ","     HKDDDDDDDKH     ","     EECCCCCCCEE     ","  EEECCLLNNNLLCCEEE  "," ENNNPPPBOOOAPPPNNNE "," ENNNPFPBOOOAPFPNNNE "," ENNNPPPBOOOAPPPNNNE ","  EEECCLLNNNLLCCEEE  ","     EECCCCCCCEE     ","     HKDDDDDDDKH     ","      HGGGGGGGH      ","                     ","                     "},
        {"                     ","                     ","      HGGG~GGGH      ","     HKDDDDDDDKH     ","     DDCCCCCCCDD     ","  DDDCCLLNNNLLCCDDD  "," DCCCPPPBOOOAPPPCCCD "," DCCCPFPBOOOAPFPCCCD "," DCCCPPPBOOOAPPPCCCD ","  DDDCCLLNNNLLCCDDD  ","     DDCCCCCCCDD     ","     HKDDDDDDDEH     ","      HGGGGGGGH      ","                     ","                     "},
        {"                     ","                     ","      HGGGGGGGH      ","     HKDDDDDDDKH     ","     EECCCCCCCEE     ","  EEECCLLNNNLLCCEEE  "," ENNNPPPBOOOAPPPNNNE "," ENNNPFPBOOOAPFPNNNE "," ENNNPPPBOOOAPPPNNNE ","  EEECCLLNNNLLCCEEE  ","     EECCCCCCCEE     ","     HKDDDDDDDKH     ","      HGGGGGGGH      ","                     ","                     "},
        {"                     ","                     ","      HGGGGGGGH      ","     HKDDDDDDDKH     ","     GECCCCCCCEG     ","  GGGCCLLNNNLLCCGGG  "," GPPPPPPBOOOAPPPPPPG "," GPPPPFPBOOOAPFPPPPG "," GPPPPPPBOOOAPPPPPPG ","  GGGCCLLNNNLLCCGGG  ","     GECCCCCCCEG     ","     HKDDDDDDDKH     ","      HGGGGGGGH      ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HDDDDDDDH      ","     GECCCCCCCEG     ","  GRGCCLLNNNLLCCGTG  "," GPFPPPPBOOOAPPPPFPG "," GPFFFFPBOOOAPFFFFPG "," GPPPPPPBOOOAPPPPPPG ","  GGGCCLLNNNLLCCGNG  ","     GECCCCCCCEG     ","      HDDDDDDDH      ","       HGGGGGH       ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HDDDDDDDH      ","     GECCCCCCCEG     ","  GGGCCLLNNNLLCCGGG  "," GPPPPPPLNNNLPPPPPPG "," GPPPPPPLNNNLPPPPPPG "," GPPPPPPLNNNLPPPPPPG ","  GGGCCLLNNNLLCCGGG  ","     GECCCCCCCEG     ","      HDDDDDDDH      ","       HGGGGGH       ","                     ","                     "},
        {"                     ","                     ","       HGGGGGH       ","      HEEEEEEEH      ","     EECCCCCCCEE     ","  EEEGCCCCCCCCCGEEE  "," EGGGCCCCCCCCCCCGGGE "," EGGGCCCCCCCCCCCGGGE "," EGGGCCCCCCCCCCCGGGE ","  EEEGCCCCCCCCCGEEE  ","     EECCCCCCCEE     ","      HEEEEEEEH      ","       HGGGGGH       ","                     ","                     "},
        {"       MMMMMMM       ","      MMMMMMMMM      ","    MMMMMMMMMMMMM    "," MMMMMMHHGGGHHMMMMMM ","MMMMMMHHHHHHHHHMMMMMM","MMMMMGGHHHHHHHGGMMMMM","MMMMGGGGGGGGGGGGGMMMM","MMMMGGGGGGGGGGGGGMMMM","MMMMGGGGGGGGGGGGGMMMM","MMMMMGGHHHHHHHGGMMMMM","MMMMMMHHHHHHHHHMMMMMM"," MMMMMMHHHHHHHMMMMMM ","    MMMMMMMMMMMMM    ","      MMMMMMMMM      ","       MMMMMMM       "},
        {"       MMMMMMM       ","      MMMMMMMMM      ","    MMMMMMMMMMMMM    "," MMMMMMMMMMMMMMMMMMM ","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM","MMMMMMMMMMMMMMMMMMMMM"," MMMMMMMMMMMMMMMMMMM ","    MMMMMMMMMMMMM    ","      MMMMMMMMM      ","       MMMMMMM       "}
    };
    // spotless:on
    private static IStructureDefinition<TST_HighEnergyStateThermalTransferDevice> STRUCTURE_DEFINITION = null;

    @Override
    public IStructureDefinition<TST_HighEnergyStateThermalTransferDevice> getStructureDefinition() {
        if (STRUCTURE_DEFINITION == null) {
            STRUCTURE_DEFINITION = StructureDefinition.<TST_HighEnergyStateThermalTransferDevice>builder()
                .addShape(STRUCTURE_PIECE_MAIN, transpose(shapeMain))
                .addElement(
                    'A',
                    ofBlock(
                        getMaterialBlock(MaterialsAlloy.HS188A, BasicBlock.BlockTypes.STANDARD) != null
                            ? getMaterialBlock(MaterialsAlloy.HS188A, BasicBlock.BlockTypes.STANDARD)
                            : Blocks.stone,
                        0))
                .addElement(
                    'B',
                    ofBlock(
                        getMaterialBlock(MaterialsAlloy.QUANTUM, BasicBlock.BlockTypes.STANDARD) != null
                            ? getMaterialBlock(MaterialsAlloy.QUANTUM, BasicBlock.BlockTypes.STANDARD)
                            : Blocks.stone,
                        0))
                .addElement('C', ofBlock(GregTechAPI.sBlockCasings10, 11))
                .addElement('D', ofBlock(GregTechAPI.sBlockCasings2, 1))
                .addElement('E', ofBlock(GregTechAPI.sBlockCasings4, 14))
                .addElement('F', ofBlock(GregTechAPI.sBlockCasings6, 10))
                .addElement('G', ofBlock(GregTechAPI.sBlockCasings8, 7))
                .addElement('H', ofBlock(GregTechAPI.sBlockCasings8, 10))
                .addElement('I', ofBlock(GregTechAPI.sBlockCasings9, 1))
                .addElement('J', ofFrame(Materials.Iridium))
                .addElement('K', ofFrame(Materials.CosmicNeutronium))
                .addElement('L', ofBlock(Loaders.pressureResistantWalls, 0))
                .addElement('M', ofBlock(GSBlocks.DysonSwarmBlocks, 9))
                .addElement('N', ofBlock(TstBlocks.MetaBlockCasing02, 2))
                .addElement('O', ofBlock(TstBlocks.MetaBlockCasing02, 3))
                .addElement('P', ofBlock(TstBlocks.MetaBlockCasing02, 4))
                .addElement(
                    'Q',
                    HatchElementBuilder.<TST_HighEnergyStateThermalTransferDevice>builder()
                        .atLeast(InputHatch)
                        .adder(TST_HighEnergyStateThermalTransferDevice::addToMachineList)
                        .dot(1)
                        .casingIndex(TstBlocks.MetaBlockCasing02.getTextureIndex(2))
                        .buildAndChain(TstBlocks.MetaBlockCasing02, 2))
                .addElement(
                    'R',
                    HatchElementBuilder.<TST_HighEnergyStateThermalTransferDevice>builder()
                        .atLeast(OutputHatch)
                        .adder(TST_HighEnergyStateThermalTransferDevice::addToMachineList)
                        .dot(2)
                        .casingIndex(TstBlocks.MetaBlockCasing02.getTextureIndex(2))
                        .buildAndChain(TstBlocks.MetaBlockCasing02, 2))
                .addElement(
                    'S',
                    HatchElementBuilder.<TST_HighEnergyStateThermalTransferDevice>builder()
                        .atLeast(InputHatch)
                        .adder(TST_HighEnergyStateThermalTransferDevice::addToMachineList)
                        .dot(3)
                        .casingIndex(TstBlocks.MetaBlockCasing02.getTextureIndex(2))
                        .buildAndChain(TstBlocks.MetaBlockCasing02, 2))
                .addElement(
                    'T',
                    HatchElementBuilder.<TST_HighEnergyStateThermalTransferDevice>builder()
                        .atLeast(OutputHatch)
                        .adder(TST_HighEnergyStateThermalTransferDevice::addToMachineList)
                        .dot(4)
                        .casingIndex(TstBlocks.MetaBlockCasing02.getTextureIndex(2))
                        .buildAndChain(TstBlocks.MetaBlockCasing02, 2))
                .build();
        }
        return STRUCTURE_DEFINITION;
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        repairMachine();
        this.buildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            hintsOnly,
            baseHorizontalOffSet,
            baseVerticalOffSet,
            baseDepthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            baseHorizontalOffSet,
            baseVerticalOffSet,
            baseDepthOffSet,
            elementBudget,
            env,
            false,
            true);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        repairMachine();
        return checkPiece(STRUCTURE_PIECE_MAIN, baseHorizontalOffSet, baseVerticalOffSet, baseDepthOffSet);
    }

    // region Processing Logic
    @Override
    public RecipeMap<?> getRecipeMap() {
        return GTCMRecipe.RapidHeatExchangeRecipes;
    }

    @NotNull
    @Override
    public Collection<RecipeMap<?>> getAvailableRecipeMaps() {
        return Arrays.asList(GTCMRecipe.RapidHeatExchangeRecipes);
    }

    @Override
    protected boolean isEnablePerfectOverclock() {
        return false;
    }

    @Override
    protected float getSpeedBonus() {
        return 1;
    }

    @Override
    protected int getMaxParallelRecipes() {
        return 1;
    }

    @Override
    public int totalMachineMode() {
        return 2;
    }

    @Override
    public void setMachineModeIcons() {
        machineModeIcons.add(UITextures.HESTTD_HeatExchanger);
        machineModeIcons.add(UITextures.HESTTD_RapidCooling);
    }

    @Override
    public void setMachineMode(int index) {
        super.setMachineMode(index);
    }

    @Override
    public String getMachineModeName(int mode) {
        // #tr HESTTD.modeMsg.0
        // # Heat Exchanger
        // #zh_CN 热交换模式

        // #tr HESTTD.modeMsg.1
        // # Rapid cooling
        // #zh_CN 快速冷却模式
        return TextEnums.tr("HESTTD.modeMsg." + mode);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
        int colorIndex, boolean aActive, boolean aRedstone) {
        ITexture Base = Textures.BlockIcons.getCasingTextureForId(183);
        if (side == facing) {
            if (aActive) {
                return new ITexture[] { Base, TextureFactory.builder()
                    .addIcon(OVERLAY_DTPF_ON)
                    .extFacing()
                    .build(),
                    TextureFactory.builder()
                        .addIcon(OVERLAY_FUSION1_GLOW)
                        .extFacing()
                        .glow()
                        .build() };
            }
            return new ITexture[] { Base, TextureFactory.builder()
                .addIcon(OVERLAY_DTPF_OFF)
                .extFacing()
                .build() };
        }
        return new ITexture[] { Base };
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType(TextLocalization.Tooltip_Scavenger_MachineType)
            .addInfo(TextLocalization.Tooltip_Scavenger_Controller)
            .addInfo(TextLocalization.Tooltip_Scavenger_01)
            .addInfo(TextLocalization.Tooltip_Scavenger_02)
            .addInfo(TextLocalization.Tooltip_Scavenger_03)
            .addInfo(TextLocalization.Tooltip_Scavenger_04)
            .addSeparator()
            .addInfo(StructureTooComplex)
            .addInfo(BLUE_PRINT_INFO)
            .addController(textFrontBottom)
            .addInputHatch(textUseBlueprint, 1)
            .addOutputHatch(textUseBlueprint, 2)
            .addInputBus(textUseBlueprint, 1)
            .addOutputBus(textUseBlueprint, 2)
            .addEnergyHatch(textUseBlueprint, 2)
            .addStructureInfo(Text_SeparatingLine)
            .addStructureInfo(Tooltip_DoNotNeedMaintenance)
            .toolTipFinisher(ModName);
        return tt;
    }
}
