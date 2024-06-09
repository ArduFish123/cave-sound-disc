/*    */ package net.mcreator.araspberry523.blankmusicdiscs.item;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.item.RecordItem;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ public class BlankMusicDiscItem
/*    */   extends RecordItem {
/*    */   public BlankMusicDiscItem() {
/* 13 */     super(1, () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), (new Item.Properties()).stacksTo(1).rarity(Rarity.COMMON), 1000);
/*    */   }
/*    */ }


/* Location:              D:\blank_music_discs-1.0.0-forge-1.20.1.jar!\net\mcreator\araspberry523\blankmusicdiscs\item\BlankMusicDiscItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */