/*    */ package net.mcreator.araspberry523.blankmusicdiscs;
/*    */ 
/*    */ import java.util.AbstractMap;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.ConcurrentLinkedQueue;
/*    */ import java.util.function.BiConsumer;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.mcreator.araspberry523.blankmusicdiscs.init.BlankMusicDiscsModItems;
/*    */ import net.mcreator.araspberry523.blankmusicdiscs.init.BlankMusicDiscsModTabs;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import net.minecraftforge.fml.util.thread.SidedThreadGroups;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ import net.minecraftforge.network.NetworkRegistry;
/*    */ import net.minecraftforge.network.simple.SimpleChannel;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod("blank_music_discs")
/*    */ public class BlankMusicDiscsMod
/*    */ {
/* 34 */   public static final Logger LOGGER = LogManager.getLogger(BlankMusicDiscsMod.class);
/*    */   
/*    */   public static final String MODID = "blank_music_discs";
/*    */   private static final String PROTOCOL_VERSION = "1";
/*    */   
/*    */   public BlankMusicDiscsMod() {
/* 40 */     MinecraftForge.EVENT_BUS.register(this);
/* 41 */     IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
/*    */     
/* 43 */     BlankMusicDiscsModItems.REGISTRY.register(bus);
/*    */     
/* 45 */     BlankMusicDiscsModTabs.REGISTRY.register(bus);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 54 */   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("blank_music_discs", "blank_music_discs"), () -> "1", "1"::equals, "1"::equals);
/* 55 */   private static int messageID = 0;
/*    */   
/*    */   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
/* 58 */     PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
/* 59 */     messageID++;
/*    */   }
/*    */   
/* 62 */   private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
/*    */   
/*    */   public static void queueServerWork(int tick, Runnable action) {
/* 65 */     if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
/* 66 */       workQueue.add(new AbstractMap.SimpleEntry<>(action, Integer.valueOf(tick))); 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void tick(TickEvent.ServerTickEvent event) {
/* 71 */     if (event.phase == TickEvent.Phase.END) {
/* 72 */       List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
/* 73 */       workQueue.forEach(work -> {
/*    */             work.setValue(Integer.valueOf(((Integer)work.getValue()).intValue() - 1));
/*    */             if (((Integer)work.getValue()).intValue() == 0)
/*    */               actions.add(work); 
/*    */           });
/* 78 */       actions.forEach(e -> ((Runnable)e.getKey()).run());
/* 79 */       workQueue.removeAll(actions);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\blank_music_discs-1.0.0-forge-1.20.1.jar!\net\mcreator\araspberry523\blankmusicdiscs\BlankMusicDiscsMod.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */