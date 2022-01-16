package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.domain.TicketInfo;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketInfo ticket1 = new TicketInfo(1, 100, "DEN", "NYC", 50);
    TicketInfo ticket2 = new TicketInfo(2, 200, "LAX", "ORL", 60);
    TicketInfo ticket3 = new TicketInfo(3, 300, "DEN", "NYC", 50);
    TicketInfo ticket4 = new TicketInfo(4, 300, "DEN", "NYC", 40);
    TicketInfo ticket5 = new TicketInfo(5, 400, "HOU", "NYC", 30);
    TicketInfo ticket6 = new TicketInfo(6, 500, "ORL", "NYC", 60);
    TicketInfo ticket7 = new TicketInfo(7, 600, "DEN", "NYC", 60);

    @BeforeEach
    public void managerInit() {
        manager.add(ticket6);
        manager.add(ticket2);
        manager.add(ticket1);
        manager.add(ticket7);
        manager.add(ticket5);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    void souldSearchByMissingAirports() {
        TicketInfo[] actual = this.manager.searchByAirports("DAL", "HOU");
        TicketInfo[] expected = new TicketInfo[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void souldSearchByOneHavingAirports() {
        TicketInfo[] actual = this.manager.searchByAirports("LAX", "ORL");
        TicketInfo[] expected = {ticket2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void souldSearchByManyHavingAirports() {
        TicketInfo[] actual = this.manager.searchByAirports("DEN", "NYC");
        TicketInfo[] expected = {ticket1, ticket3, ticket4, ticket7};
        assertArrayEquals(expected, actual);
    }
}