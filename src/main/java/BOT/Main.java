package BOT;

import BOT.Games.BlackJack;
import BOT.Games.GuessTheNumber;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.entities.Activity;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDA jda;

    public static void main(String[] args) {
        ListenerAdapter[] listenerAdapters = new ListenerAdapter[]{new GetKiwi(),new GuessTheNumber(),new BlackJack(),new SlashCommands(),new OtherCommands()};
        JDABuilder jdaBuilder = JDABuilder.createDefault(System.getenv("TOKEN"));
        jdaBuilder.addEventListeners(listenerAdapters);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_PRESENCES);
        System.out.println(JDAInfo.VERSION);


        jdaBuilder.setActivity(Activity.playing("with kiwi!"));
        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
            jda.upsertCommand(new CommandData("ping","gets current ping time"));
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
