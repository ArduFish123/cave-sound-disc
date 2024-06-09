/*    */ package net.mcreator.araspberry523.blankmusicdiscs.init;
/*    */ 
/*    */ import net.mcreator.araspberry523.blankmusicdiscs.item.BlankMusicDiscItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlankMusicDiscsModItems
/*    */ {
/* 17 */   public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "blank_music_discs");
/* 18 */   public static final RegistryObject<Item> CAVE_DISC = REGISTRY.register("cave_disc", () -> new BlankMusicDiscItem());
/*    */ }


/* Location:              D:\blank_music_discs-1.0.0-forge-1.20.1.jar!\net\mcreator\araspberry523\blankmusicdiscs\init\BlankMusicDiscsModItems.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */