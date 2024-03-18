package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DoneController {

    private Map<Integer, Done> dones = new HashMap<Integer, Done>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.dones.put(1,new Done(1, "Neuer Job", "5 DevOps Engineer Stellen ausgeschrieben"));
        this.dones.put(2,new Done(2, "Geschäftsleitung", "Termin für Präsentation von DevOps festlegen"));
        this.dones.put(3,new Done(3, "Unit Tests", "Neues Projekt mit Unit Tests abgeschlossen"));
        this.dones.put(4,new Done(4, "Organigramm", "Gelöscht"));
        System.out.println("Init Data");
    }

    @GetMapping("/services/done")
    public List<PathListEntry<Integer>> done() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var done : this.dones.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(done.getId(), "doneKey");
            entry.setName(done.getTitle());
            entry.getDetails().add(done.getDescription());
            entry.setTooltip(done.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/done/{key}")
    public Done getDone(@PathVariable Integer key) {
        return this.dones.get(key);
    }

    @PostMapping("/services/done")
    public void createDone(@RequestBody Done done) {
        var newId = this.dones.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        done.setId(newId);
        this.dones.put(newId, done);
    }

    @PutMapping("/services/done/{id}")
    public void createDone(@PathVariable Integer id, @RequestBody Done done) {
        done.setId(id);
        this.dones.put(id, done);
    }

    @DeleteMapping("/services/done/{key}")
    public Done deleteDone(@PathVariable Integer key) {
        return this.dones.remove(key);
    }


}
