package xyz.greem.srvutils.main;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private DiscordSRVListener discordSRVListener = new DiscordSRVListener();

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabling!");
        DiscordSRV.api.subscribe(discordSRVListener);
        init();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabling!");
        DiscordSRV.api.unsubscribe(discordSRVListener);
    }

    public void init() {
        getLogger().info("ChangeNickname - V1.1 by Greem#1337");
        getLogger().info("hooks into DiscordSRV to change a user's nickname in-game");
        getLogger().info("to their Discord nickname upon linking their accounts with DiscordSRV.");
        getLogger().info("This plugin is entirely open source! Grab it here: https://github.com/Greeem/DiscordSRV-Nickname/");

        getLogger().info("Made with love and very little Bukkit knowledge.");

    }


}
