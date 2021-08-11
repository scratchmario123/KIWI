package Games;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuessTheNumber extends ListenerAdapter {

    int dice;
    int choice;


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (!event.isWebhookMessage()) {
            if (!event.getMember().getUser().isBot()) {
                String msg = event.getMessage().getContentRaw().replaceAll("\\s{2,}", " ").trim();
                String[] args = msg.split(" ");
                if (args[0].equalsIgnoreCase("!dice")) {
                    if (args.length != 2) {
                        event.getChannel().sendMessage("Usage: !dice [0-10]").queue();
                    } else {
                        try {
                            if ((Integer.parseInt(args[1]) < 11 && Integer.parseInt(args[1]) >= 0)) {
                                String author = event.getAuthor().getName();
                                String url = event.getAuthor().getAvatarUrl();
                                rollTheDice();
                                choice = Integer.parseInt(args[1]);
                                event.getChannel().sendMessage(makeEmbed(author, url).build()).queue();
                            } else {
                                event.getChannel().sendMessage("<:baka:874633103652560956>").queue();
                            }
                        } catch (NumberFormatException E) {
                            event.getChannel().sendMessage("<:baka:874633103652560956>").queue();
                        }
                    }
                }
            }
        }
    }

    private void rollTheDice() {
        dice = new Random().nextInt(11);
    }


    private EmbedBuilder makeEmbed(String author, String url) {
        EmbedBuilder diceLayout = new EmbedBuilder();
        diceLayout.setAuthor(author,url,url);
        diceLayout.setTitle("ROLLING THE DICE... :game_die:");
        diceLayout.setDescription("Your choice is: " + choice + "\n" +
                "The number is... " + dice + "!\n");
        diceLayout.addField("You " + (dice == choice ? "win!" : "lose!"),"Rewards: 1 kiwi :kiwi: (wip)",false);
        diceLayout.setColor(0xff0000);
        return diceLayout;
    }
}
