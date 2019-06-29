package vaadinspringexample.supers.services;

import org.springframework.stereotype.Component;
import vaadinspringexample.supers.domain.Super;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataService {

    private Map<String,Super> supersMap;
    private List<String> powersList;

    public DataService() {
        this.supersMap = new ConcurrentHashMap<>();
        this.powersList = new ArrayList<>();

        powersList.addAll(Arrays.asList(
            "Flying",
            "Invisibility",
            "Super Strength",
            "Super Speed",
            "Fast Healing",
            "Pyrotechnics",
            "Cryotechnics",
            "Electrotechnics"
        ));

    }

    public void createSuper(Super toCreate) {

        if (!supersMap.containsKey(toCreate.getNickname())) {

            supersMap.put(toCreate.getNickname(), toCreate);

            System.out.println("New super added to the store!");

        }

    }

    public void modifySuper(Super toModify) {

        if (supersMap.containsKey(toModify.getNickname())) {
            supersMap.put(toModify.getNickname(), toModify);
        }

    }

    public Super fetchSuper(String nickname) {

        if (supersMap.containsKey(nickname)) {
            return supersMap.get(nickname);
        }

        return null;
    }

    public void deleteSuper(Super toDelete) {

        if (supersMap.containsKey(toDelete.getNickname())) {
            supersMap.remove(toDelete.getNickname());
        }

    }

    public List<String> fetchAllPowers() {
        return powersList;
    }
}
