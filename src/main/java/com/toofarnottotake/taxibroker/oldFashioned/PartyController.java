package com.toofarnottotake.taxibroker.oldFashioned;

import com.toofarnottotake.taxibroker.dtos.JoinPartyRequest;
import com.toofarnottotake.taxibroker.dtos.PartyDto;
import com.toofarnottotake.taxibroker.entities.Party;
import com.toofarnottotake.taxibroker.mappers.PartyMapper;
import com.toofarnottotake.taxibroker.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/parties")
public class PartyController {
    private final PartyMapper partyMapper;
    private final PartyRepository partyRepository;

    @GetMapping
    public Iterable<PartyDto> getAllUsers(){

        return  partyRepository.findAll(Sort.by("id"))
                .stream()
                .map(partyMapper::toDto)
                .toList();
    }

    @PostMapping("/join-party/{userId}")
    public ResponseEntity<PartyDto> joinParty(
            @PathVariable Long userId,
            @RequestBody JoinPartyRequest request) {
        List<Party> parties = partyRepository.findAll(Sort.by("id"));
        for (Party party : parties) {
            if (party.getDepartureId().equals(request.getDepartureId()) && party.getDestinationId().equals(request.getDestinationId())) {
                if(party.getLieutenantId() == null){
                    party.setLieutenantId(userId);
                    partyRepository.save(party);
                    return ResponseEntity.ok(partyMapper.toDto(party));
                } else if (party.getSergeantId() == null) {
                    party.setSergeantId(userId);
                    partyRepository.save(party);
                    return ResponseEntity.ok(partyMapper.toDto(party));
                } else if (party.getAirmanId() == null) {
                    party.setAirmanId(userId);
                    partyRepository.save(party);
                    return ResponseEntity.ok(partyMapper.toDto(party));
                }
            }
        }
        Party newParty = new Party();
        newParty.setDepartureId(request.getDepartureId());
        newParty.setDestinationId(request.getDestinationId());
        newParty.setTime(request.getTime());
        newParty.setCaptainId(userId);
        newParty.setPrice(6000.00);
        partyRepository.save(newParty);
        return ResponseEntity.ok(partyMapper.toDto(newParty));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id){
        var party = partyRepository.findById(id).orElse(null);
        if(party == null) {
            return ResponseEntity.notFound().build();
        }
        partyRepository.delete(party);
        return ResponseEntity.noContent().build();
    }
}
