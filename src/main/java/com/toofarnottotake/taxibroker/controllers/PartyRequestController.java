package com.toofarnottotake.taxibroker.controllers;


import com.toofarnottotake.taxibroker.dtos.JoinPartyRequest;
import com.toofarnottotake.taxibroker.dtos.PartyDto;
import com.toofarnottotake.taxibroker.entities.Party;
import com.toofarnottotake.taxibroker.mappers.PartyMapper;
import com.toofarnottotake.taxibroker.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/party-requests")

public class PartyRequestController {
    private final PartyMapper partyMapper;
    private final PartyRepository partyRepository;

    @PostMapping
    public String joinParty(
            @ModelAttribute JoinPartyRequest request,
            Model model) {
        Long userId = request.getUserId();
        List<Party> parties = partyRepository.findAll(Sort.by("id"));
        for (Party party : parties) {
            if (party.getDepartureId().equals(request.getDepartureId()) && party.getDestinationId().equals(request.getDestinationId())) {
                if(party.getLieutenantId() == null){
                    party.setLieutenantId(userId);
                    partyRepository.save(party);
                } else if (party.getSergeantId() == null) {
                    party.setSergeantId(userId);
                    partyRepository.save(party);
                } else if (party.getAirmanId() == null) {
                    party.setAirmanId(userId);
                    partyRepository.save(party);
                } else continue;

                return "redirect:/"+userId;
            }
        }
        Party newParty = new Party();
        newParty.setDepartureId(request.getDepartureId());
        newParty.setDestinationId(request.getDestinationId());
        newParty.setTime(request.getTime());
        newParty.setCaptainId(userId);
        newParty.setPrice(6000.00);
        partyRepository.save(newParty);
        return "redirect:/"+userId;
    }
}
