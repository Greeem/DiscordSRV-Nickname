package xyz.greem;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private DiscordSRVListener discordSRVListener = new DiscordSRVListener();

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabling!");
        DiscordSRV.api.subscribe(discordSRVListener);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabling!");
        DiscordSRV.api.unsubscribe(discordSRVListener);
    }


}
