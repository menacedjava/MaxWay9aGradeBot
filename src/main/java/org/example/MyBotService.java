package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBotService {

    public SendMessage startmessage(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Choose language :");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowlang = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardButton buttonlang1 = new KeyboardButton();
        buttonlang1.setText("Uzbek");
        firstRow.add(buttonlang1);
        KeyboardButton buttonlang2 = new KeyboardButton();
        buttonlang2.setText("Russian");
        firstRow.add(buttonlang2);
        KeyboardButton buttonlang3 = new KeyboardButton();
        buttonlang3.setText("English");
        firstRow.add(buttonlang3);
        rowlang.add(firstRow);
        replyKeyboardMarkup.setKeyboard(rowlang);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }

    public SendMessage menu(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Choose button :");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();                               //new Row
        KeyboardButton button1 = new KeyboardButton();                      //new KeyboardButton 
        button1.setText("Order🛍️");
        row1.add(button1);                                                  // add button1 to 1st row

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Vacansies📨");
        row1.add(button2);                                                  //add button2 to 1st row 
        rowList.add(row1);                                                  //add first row to RowList

        replyKeyboardMarkup.setKeyboard(rowList);                           // make buttons public 
        replyKeyboardMarkup.setResizeKeyboard(true);                        // size
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;


    }


//    public SendMessage menu1(Long chatId) {
//
//        InlineKeyboardButton orderBtn = new InlineKeyboardButton("Order📦");
//        orderBtn.setCallbackData("ORDER");
//
//        InlineKeyboardButton vacansiesBtn = new InlineKeyboardButton("Vacansies📄");
//        vacansiesBtn.setCallbackData("VACANCIES");
//
//        List<InlineKeyboardButton> row = List.of(orderBtn, vacansiesBtn);
//        InlineKeyboardMarkup markup = new InlineKeyboardMarkup(List.of(row));
//
//        return new SendMessage(chatId.toString(), "Choose button :") {{
//            setReplyMarkup(markup);
//        }};
//
//
//    }
}
