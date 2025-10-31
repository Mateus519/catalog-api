package com.ansan.tickets.catalog.service;

import com.ansan.tickets.catalog.dto.EventDTO;
import com.ansan.tickets.catalog.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EventService {

    private final Map<Long, EventDTO> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public EventDTO create(EventDTO dto) {
        long id = seq.incrementAndGet();
        dto.setId(id);
        store.put(id, dto);
        return dto;
    }

    public List<EventDTO> list() {
        return new ArrayList<>(store.values());
    }

    public EventDTO get(Long id) {
        var e = store.get(id);
        if (e == null) throw new NotFoundException("Event " + id + " no existe");
        return e;
    }

    public EventDTO update(Long id, EventDTO dto) {
        if (!store.containsKey(id)) throw new NotFoundException("Event " + id + " no existe");
        dto.setId(id);
        store.put(id, dto);
        return dto;
    }

    public void delete(Long id) {
        if (store.remove(id) == null) throw new NotFoundException("Event " + id + " no existe");
    }
}
