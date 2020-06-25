package br.com.guilhermeevangelista.appium.core.utils.report.screenshot;

import br.com.guilhermeevangelista.appium.core.driver.DriverFactory;
import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioRepository {

    private static Map<Long, Scenario> repository = new HashMap<Long, Scenario>();

    private ScenarioRepository() {
    }

    public static void add(Scenario scenario) {
        if (get() == null)
            repository.put(getId(), scenario);
    }

    public static void remove() {
        if (get() != null)
            repository.remove(getId());
    }

    public static Scenario get() {
        return repository.get(getId());
    }

    public static Long getId() {
        return Thread.currentThread().getId();
    }

    public static void screenShot() {
        try {
            byte[] print = Screenshot.take(DriverFactory.getDriver());
            get().embed(print, "image/png");
        } catch (Exception ignored) {
        }
    }

    public static void addText(String texto) {
        if (texto != null)
            get().write(texto);
    }
}
