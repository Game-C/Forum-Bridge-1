package com.gmail.favorlock.forumbridge.commands;

import com.gmail.favorlock.forumbridge.ForumBridge;
import org.bukkit.ChatColor;

public class FUsernameCommand extends BaseCommand {
    public FUsernameCommand() {
        this.command.add("fusername");
        this.permFlag = "bbb.fusername";
        this.requiredParameters.add("player");
        this.helpDescription = "Get a player's forum username";
    }

    public void perform() {
        String username = ForumBridge.ForumBridgeDb.getUser(this.parameters.get(0));
        if (!username.equals("")) {
            sendMessage(ChatColor.DARK_AQUA + this.parameters.get(0) + "'s forum username is " + ChatColor.WHITE + username);
        } else {
            sendMessage(ChatColor.DARK_AQUA + this.parameters.get(0) + ChatColor.RED + " isin't synced!");
        }

    }
}
