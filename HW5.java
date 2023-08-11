package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Homework {
    /**
     * В Книге рекордов Гиннесса зафиксировано самое длинное слово в русском языке —
     * превысокомногорассмотрительствующий (35 букв)
     */
    final static int MAX_WORDS_LENGHT = 35;

    /**
     * Дан текст. Нужно отсортировать слова по длине (по возрастанию) и вывести
     * статистику на экран.
     * Регистр слова не имеет значения. Формат вывода произвольный.
     * Программа-минимум:
     * 1. Слова, состоящие из дефисов, считаем одним словом. Т.е. каких-то - одно
     * слово из 8 символов.
     * 2. Точки и запятые не должны входить в статистику.
     * <p>
     * Доп. задание
     * 1. * Не включать дефис в длину слова. Т.е. каких-то - одно слово из 7
     * символов.
     * <p>
     * Пример:
     * <p>
     * Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того,
     * чтобы выполнить тестовое задание GB.
     * Данный текст не несет в себе какого-либо смысла, он просто содержит набор
     * слов.
     * <p>
     * 1 -> [и, в]
     * 2 -> [он, из, gb, не]
     * 3 -> [мой, для]
     * 4 -> [слов, того, себе]
     * 5 -> [текст, нужен, чтобы, несет, набор]
     * ...
     */
    static void printStats(String text) {
        // 1. Split текста, приведение его к нижнему регистру, удаление запятых и точек.
        // 2. Сбор структуры со статистикой.
        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
        String[] words = pattern.split(text.toLowerCase());
        Map<Integer, List<String>> stats = new HashMap<>(); // Структура, в которой ключ - длина слова, значение -
                                                            // список таких слов.
        for (int i = 0; i < MAX_WORDS_LENGHT; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (String s : words) {
                if (s.length() == i + 1 && s.contains("-") == false || s.length() == i + 2 && s.contains("-")) {
                    temp.add(s);
                }
            }
            stats.put(i + 1, temp);
        }
        for (int i = 0; i < stats.size(); i++) {
            try {
                if (stats.get(i).size() == 0) {
                    continue;
                }
                System.out.printf("%s -> %s \n", i + 1, stats.get(i).toString());
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB. "
                +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        printStats(text);
    }
}