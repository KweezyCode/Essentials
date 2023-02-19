package com.earth2me.essentials.commands;

import com.earth2me.essentials.Trade;
import com.earth2me.essentials.User;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Random;

import static com.earth2me.essentials.I18n._;

public class Commandrtp extends EssentialsCommand {
    public Commandrtp() {
        super("rtp");
    }

    @Override
    protected void run(Server server, User user, String commandLabel, String[] args) throws Exception {
        if (user.isAuthorized("essentials.rtp")) {
            final Trade charge = new Trade(this.getName(), ess);
            charge.isAffordableFor(user);

            respawn(getRespawnLoc(), user, user, charge);

            throw new NoChargeException();
        }
    }

    private void respawn(Location location, final User teleportOwner, final User teleportee, final Trade charge) throws Exception
    {

        if (teleportOwner == null)
        {
            teleportee.getTeleport().now(location, false, PlayerTeleportEvent.TeleportCause.COMMAND);
        }
        else
        {
            teleportOwner.getTeleport().teleportPlayer(teleportee, location, charge, PlayerTeleportEvent.TeleportCause.COMMAND);
        }
    }

    Location getRespawnLoc() {
        Location spawnLocation = Bukkit.getWorlds().get(0).getSpawnLocation();
        for (int i = 0; i < 10; i++) {
            int newX = spawnLocation.getBlockX() + randInt(-5000, 5000);
            int newZ = spawnLocation.getBlockZ() + randInt(-5000, 5000);
            int newY = Bukkit.getWorlds().get(0).getHighestBlockAt(newX, newZ).getY() - 1;
            Block topblock = Bukkit.getWorlds().get(0).getBlockAt(newX, newY, newZ);

            if (!topblock.getType().equals(Material.STATIONARY_WATER) && !topblock.getType().equals(Material.WATER) && !topblock.getType().equals(Material.STATIONARY_LAVA) && !topblock.getType().equals(Material.LAVA)) {
                return new Location(Bukkit.getWorlds().get(0), newX + 0.5, topblock.getY() + 0.5, newZ + 0.5);
            }
            System.out.println("[EssentialsRTP] Skipping water at respawn");
        }

        return spawnLocation;
    }

    public int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
