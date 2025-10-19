package fr.maxlego08.cookie.command.commands;

import fr.maxlego08.cookie.CookiePlugin;
import fr.maxlego08.cookie.command.VCommand;
import fr.maxlego08.cookie.zcore.enums.Message;
import fr.maxlego08.cookie.zcore.enums.Permission;
import fr.maxlego08.cookie.zcore.utils.commands.CommandType;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.Arrays;

public class CommandCookieClickerGive extends VCommand {

    public CommandCookieClickerGive(CookiePlugin plugin) {
        super(plugin);
        this.setPermission(Permission.ZCOOKIECLICKER_GIVE);
        this.addSubCommand("give");
        this.setDescription(Message.DESCRIPTION_GIVE);
        this.addRequireArg("player");
        this.addRequireArg("amount", (a, b) -> Arrays.asList("100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"));
    }

    @Override
    protected CommandType perform(CookiePlugin plugin) {

        Player player = this.argAsPlayer(0);
        BigDecimal amount = new BigDecimal(this.argAsLong(1));
        var manager = plugin.getCookieManager();
        manager.addCookie(player, amount,true);
        message(player, Message.GIVE, "%player%", player.getName(), "%cookie%", manager.formatNumber(amount));

        return CommandType.SUCCESS;
    }

}
