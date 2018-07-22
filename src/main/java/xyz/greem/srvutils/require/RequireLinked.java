package xyz.greem.srvutils.require;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class RequireLinked implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerMove(final PlayerMoveEvent event) {
        if (!this.isLinked(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
        if (!this.isLinked(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    private boolean isLinked(final Player player) {
        if (!DiscordSRV.isReady) {
            return false;
        }
        if (DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(player.getUniqueId()) != null) {
            return true;
        }
        player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "&4&lYou must link your Discord account to play. Run /discord link to get to it.");
        return false;
    }
}
