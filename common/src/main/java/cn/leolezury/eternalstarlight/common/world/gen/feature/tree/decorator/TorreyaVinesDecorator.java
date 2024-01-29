package cn.leolezury.eternalstarlight.common.world.gen.feature.tree.decorator;

import cn.leolezury.eternalstarlight.common.block.TorreyaVinesPlantBlock;
import cn.leolezury.eternalstarlight.common.init.BlockInit;
import cn.leolezury.eternalstarlight.common.init.TreeDecoratorInit;
import com.mojang.serialization.Codec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class TorreyaVinesDecorator extends TreeDecorator {
    public static final Codec<TorreyaVinesDecorator> CODEC = Codec.unit(() -> TorreyaVinesDecorator.INSTANCE);
    public static final TorreyaVinesDecorator INSTANCE = new TorreyaVinesDecorator();

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorInit.TORRETA_VINES.get();
    }

    public void place(Context context) {
        RandomSource random = context.random();
        context.leaves().forEach((pos) -> {
            if (random.nextInt(8) == 0) {
                int l = random.nextInt(6) + 5;
                for (int i = 1; i <= l; i++) {
                    if (context.isAir(pos.below(i))) {
                        if (i == 1) {
                            context.setBlock(pos.below(i), BlockInit.TORREYA_VINES_PLANT.get().defaultBlockState().setValue(TorreyaVinesPlantBlock.TOP, true));
                        }
                        context.setBlock(pos.below(i), BlockInit.TORREYA_VINES_PLANT.get().defaultBlockState());
                        if (i == l) {
                            context.setBlock(pos.below(i), BlockInit.TORREYA_VINES.get().defaultBlockState());
                        }
                    } else {
                        if (i != 1) {
                            context.setBlock(pos.below(i - 1), BlockInit.TORREYA_VINES.get().defaultBlockState());
                        }
                        break;
                    }
                }
            }
        });
    }
}
