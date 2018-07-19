package xyz.greem.discordsrvnickname;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpdateCommand implements CommandExecutor {

    private DiscordSRV srv = DiscordSRV.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        if (cmd.getName().toLowerCase().equals("/updatenickname") || cmd.getName().toLowerCase().equals("/upnick")) {
            if (srv.getAccountLinkManager().getLinkedAccounts().containsValue(player.getUniqueId())) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nick " + player.getName() + " " + srv.getAccountLinkManager().getDiscordId(player.getUniqueId()));
                return true;
            } else {
                player.sendRawMessage(ChatColor.AQUA + "You do not have a linked Discord account! Please run " + ChatColor.DARK_RED + "/discord link");
                return true;
            }

            }
        return false;

    }

}
