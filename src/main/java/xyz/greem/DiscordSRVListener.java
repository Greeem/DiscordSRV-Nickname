package xyz.greem;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.AccountLinkedEvent;
import org.bukkit.Bukkit;

public class DiscordSRVListener {

    @Subscribe
    public void accountsLinked(AccountLinkedEvent event) {

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nick " + event.getPlayer().getName() + " " + DiscordSRV.getPlugin().getMainGuild().getMember(event.getUser()).getEffectiveName());

    }

}