package any.brazilaesthetic.mixin;

import any.brazilaesthetic.blocks.ModBlocks;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.MusicDiscItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MusicDiscItem.class)
public class MusicDiscItemMixins {
    @WrapOperation(
        method = "useOnBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
        )
    )
    private boolean allowedBlocks(BlockState instance, Block block, Operation<Boolean> original) {
        return instance.isOf(ModBlocks.RADIO) || original.call(instance, block);
    }

}