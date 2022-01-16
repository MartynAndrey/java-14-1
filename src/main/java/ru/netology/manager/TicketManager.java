package ru.netology.manager;
import ru.netology.domain.TicketInfo;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketRepository getRepository() {
        return this.repository;
    }

    public void add(TicketInfo ticket) {
        this.repository.add(ticket);
    }

    public TicketInfo[] searchByAirports(String fromAirport, String toAirport) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticket : this.repository.getItems()) {
            if (matchesByAirports(ticket, fromAirport, toAirport)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);

        return result;
    }

    public boolean matchesByAirports(TicketInfo ticket, String fromAirport, String toAirport) {
        return ticket.getFromAirport().equals(fromAirport) && ticket.getToAirport().equals(toAirport);
    }
}