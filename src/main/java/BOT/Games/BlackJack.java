package BOT.Games;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class BlackJack extends ListenerAdapter implements Runnable {

    Map<String,Integer> JQK = new HashMap<>();

    public BlackJack() {
        JQK.put("J",10);
        JQK.put("Q",10);
        JQK.put("K",10);
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (!event.isWebhookMessage()) {
            if (!event.getMember().getUser().isBot()) {
                String msg = event.getMessage().getContentRaw().replaceAll("\\s{2,}", " ").trim();
                String[] args = msg.split(" ");
                if (args[0].equalsIgnoreCase("!bj")) {
                    String author = event.getAuthor().getName();
                    String url = event.getAuthor().getAvatarUrl();
                    startGame();
                    event.getChannel().sendMessage(makeEmbed(author, url).build()).queue();
                }
            }
        }
    }

    private void startGame() {
        Thread thread = new Thread(this);
        thread.start();
    }


    private EmbedBuilder makeEmbed(String author, String url) {
        EmbedBuilder diceLayout = new EmbedBuilder();
        diceLayout.setAuthor(author,url,url);
        diceLayout.setTitle("The Game of BlackJack");
        diceLayout.setDescription("games");
        diceLayout.setColor(0xff0000);
        return diceLayout;
    }

    @Override
    public void run() {
        boolean inGame = true;
        String[] words = {"J","Q","K","A"};
        while (inGame) {

        }
    }
}
