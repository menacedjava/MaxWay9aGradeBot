package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public MyBotService myBotService;

    public MyBot(MyBotService service) {
        this.myBotService = service;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String username = update.getMessage().getChat().getFirstName();

            info(chatId, username, message);
            if (message.equals("/start")) {
                try {
                    execute(myBotService.startmessage(chatId));

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if(message.equals("Uzbek")) {
                try {
                    execute(myBotService.menu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "MaxWaywith9aBot";
    }

    @Override
    public String getBotToken() {
        return "8161343386:AAH4V3SaOCu6_DRml0IRoivjXQVcb1lvREQ";
    }

    public void info(Long chatId, String username, String message) {
        System.out.println(chatId + " " + username + " " + message + " ");
    }
}
