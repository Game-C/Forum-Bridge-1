package com.favorlock.ForumBridge;

import com.favorlock.ForumBridge.extras.lib.PatPeter.SQLibrary.MySQL;

import java.sql.SQLException;

public class ForumBridgeWebsiteDB {
	public static MySQL dbm;
	public static int taskID;

	public ForumBridgeWebsiteDB(ForumBridge thePlugin) throws SQLException {
		dbm = new MySQL(thePlugin.getLogger(), "com/favorlock/ForumBridge", ForumBridgeConfig.databaseHost, ForumBridgeConfig.databasePort, ForumBridgeConfig.databaseDB, ForumBridgeConfig.databaseUser, ForumBridgeConfig.databasePassword);
		dbm.open();
		if (!dbm.checkConnection()) {
			throw new SQLException("Impossible to connect to MySQL database.");
		}
		taskID = thePlugin.getServer().getScheduler().scheduleSyncRepeatingTask(thePlugin, new Runnable() {
			public void run() {
				try {
					dbm.query("SELECT 1 FROM DUAL");
				} catch (Exception e) {
				}
			}
		}, 300, (30 * 20));
	}
}