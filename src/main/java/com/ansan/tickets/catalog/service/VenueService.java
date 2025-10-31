package com.ansan.tickets.catalog.service;

import com.ansan.tickets.catalog.dto.VenueDTO;
import com.ansan.tickets.catalog.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class VenueService {

    private final Map<Long, VenueDTO> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public VenueDTO create(VenueDTO dto) {
        long id = seq.incrementAndGet();
        dto.setId(id);
        store.put(id, dto);
        return dto;
    }

    public List<VenueDTO> list() {
        return new ArrayList<>(store.values());
    }

    public VenueDTO get(Long id) {
        var v = store.get(id);
        if (v == null) throw new NotFoundException("Venue " + id + " no existe");
        return v;
    }

    public VenueDTO update(Long id, VenueDTO dto) {
        if (!store.containsKey(id)) throw new NotFoundException("Venue " + id + " no existe");
        dto.setId(id);
        store.put(id, dto);
        return dto;
    }

    public void delete(Long id) {
        if (store.remove(id) == null) throw new NotFoundException("Venue " + id + " no existe");
    }
}
