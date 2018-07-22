package xyz.greem.srvutils.commands.discord;

import com.sun.istack.internal.NotNull;
import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordGuildMessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ColourCommand implements Listener {

    private DiscordSRV srv = DiscordSRV.getPlugin();

    @Subscribe
    public void onGuildMessageReceived(@NotNull DiscordGuildMessageReceivedEvent event) {
        String args;
        if (srv.getAccountLinkManager().getLinkedAccounts().containsKey(event.getAuthor().getId())) {
            if (event.getMessage().getContentRaw().toLowerCase().startsWith("!colour")) {
                args = event.getMessage().getContentRaw().replaceFirst("!colour", "");
                switch (args.toLowerCase()) {
                    case "dark_blue":
                        args = "&1";
                    case "dark_green":
                        args = "&2";
                        break;
                    case "dark_aqua":
                        args = "&3";
                }

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nick " + Bukkit.getPlayer(
                        srv.getAccountLinkManager().getUuid(event.getAuthor().getId())) + " " + args +
                        srv.getMainGuild().getMemberById(event.getAuthor().getId()));
            }
            if (event.getMessage().getContentRaw().toLowerCase().startsWith("!color")) {
                args = event.getMessage().getContentRaw().replaceFirst("!color", "");
            }

        }
    }

}
