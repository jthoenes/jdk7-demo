package de.bergischweb.kojug.jdk7.coin;

import de.bergischweb.kojug.jdk7.coin.dummy.Medication;
import de.bergischweb.kojug.jdk7.coin.dummy.Patient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalDate;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public class Diamond {

    public void withoutDiamond() {
        Map<Patient, Map<LocalDate, List<Medication>>> medications = new HashMap<Patient, Map<LocalDate, List<Medication>>>();
    }
    
    public void diamond() {
        Map<Patient, Map<LocalDate, List<Medication>>> medications = new HashMap<>();
    }
}
