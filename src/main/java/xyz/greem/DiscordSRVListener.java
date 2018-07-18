package xyz.greem;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.AccountLinkedEvent;
import github.scarsz.discordsrv.dependencies.jda.core.entities.Member;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class DiscordSRVListener implements Listener {

    @Subscribe
    public void accountsLinked(AccountLinkedEvent event) {
        Bukkit.dispatchCommand( Bukkit.getConsoleSender(), "nick " +
                event.getPlayer().getName() + " " +
                DiscordSRV.getPlugin().getMainGuild().getMember( event.getUser() ).getEffectiveName() );
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        if (!DiscordSRV.getPlugin().getAccountLinkManager().getLinkedAccounts().containsValue(event.getPlayer().getUniqueId())) {
            event.getPlayer().sendRawMessage(ChatColor.GREEN +
                    "Please link your Discord account to your Minecraft account via " +
                    ChatColor.AQUA + "/discord link" +
                    ChatColor.GREEN + ", and follow the on-screen instructions.");
        }

        Member discordUser = DiscordSRV.getPlugin().getMainGuild().getMemberById(DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(event.getPlayer().getUniqueId()));
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nick " + event.getPlayer().getName() + " " +
                discordUser.getEffectiveName());
    }

    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event) {
        if (!DiscordSRV.getPlugin().getAccountLinkManager().getLinkedAccounts().containsValue(event.getPlayer().getUniqueId())) {
            event.getPlayer().sendRawMessage(ChatColor.GREEN + "You cannot chat until you've linked your Discord account!");
            event.setCancelled(true);
        }
    }
}