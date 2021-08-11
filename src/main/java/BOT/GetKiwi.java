package BOT;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GetKiwi extends ListenerAdapter{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (!event.isWebhookMessage()) {
            if (!event.getMember().getUser().isBot()) {
                String msg = event.getMessage().getContentRaw().replaceAll("\\s{2,}", " ").trim();
                String[] args = msg.split(" ");
                if (args[0].equalsIgnoreCase("!kiwi")) {
                    event.getChannel().sendMessage("You have 0 kiwi :kiwi:!").queue();
                }
            }
        }
    }



}
