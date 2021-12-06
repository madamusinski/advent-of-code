package com.advent.of.code.daysix;

import com.advent.of.code.daysix.service.FishService;
import com.advent.of.code.shared.TextData;
import com.advent.of.code.shared.TextFileDataLoader;

public class DaySixTaskRunner {

    public static void runTaskOne() {
        TextFileDataLoader loader = new TextFileDataLoader();
        TextData data = loader.loadDataFrom("daySix/data.txt");
        FishService service = new FishService(data, 80);
        service.runService();
    }
}
