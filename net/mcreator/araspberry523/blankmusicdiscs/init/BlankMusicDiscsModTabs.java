/*    */ package net.mcreator.araspberry523.blankmusicdiscs.init;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.item.CreativeModeTab;
/*    */ import net.minecraft.world.item.CreativeModeTabs;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class BlankMusicDiscsModTabs
/*    */ {
/* 20 */   public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "blank_music_discs");
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
/* 24 */     if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
/* 25 */       tabData.accept((ItemLike)BlankMusicDiscsModItems.CAVE_DISC.get()); 
/*    */   }
/*    */ }


/* Location:              D:\blank_music_discs-1.0.0-forge-1.20.1.jar!\net\mcreator\araspberry523\blankmusicdiscs\init\BlankMusicDiscsModTabs.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */