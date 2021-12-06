package com.advent.of.code.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileDataLoader implements IDataLoader<TextData, String> {

    private static final Logger LOG = LoggerFactory.getLogger(TextFileDataLoader.class);

    public TextData loadDataFrom(String path) {
        TextData textFile = new TextData();
        List<String> lines = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream != null) {
            Scanner fileReader = new Scanner(inputStream);
            while (fileReader.hasNextLine()) {
                var line = fileReader.nextLine();
                if (line.isBlank()) {
                    continue;
                }
                lines.add(line);
            }
            fileReader.close();
            try {
                inputStream.close();
            } catch (IOException e) {
                LOG.error("Problem while closing input stream");
            }
        }
        textFile.setData(lines);
        return textFile;
    }

    public List<TextData> loadDataForBoardsFrom(String path) {
        List<TextData> dataList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream != null) {
            Scanner fileReader = new Scanner(inputStream);
            while (fileReader.hasNextLine()) {
                var line = fileReader.nextLine();
                if (line.isBlank()) {
                    TextData data = new TextData();
                    data.setData(lines);
                    dataList.add(data);
                    lines = new ArrayList<>();
                    continue;
                }
                lines.add(line);
            }
            fileReader.close();
            try {
                inputStream.close();
            } catch (IOException e) {
                LOG.error("Problem while closing input stream");
            }
        }
        TextData data = new TextData();
        data.setData(lines);
        dataList.add(data);
        return dataList;
    }
}