package be.kdg.tripsspringapp.controllers;

import be.kdg.trips.core.usecases.SendInvitations;
import be.kdg.tripsspringapp.dto.InvitationDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invite")
public class InvitationController {
    private SendInvitations sendInvitations;

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    public boolean send(@RequestBody InvitationDTO invitationDTO) {
        sendInvitations.send(invitationDTO.toEntity());
        return true;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/sendall")
    public boolean send(@RequestBody List<InvitationDTO> invitationDTOS) {
        invitationDTOS.forEach(i -> sendInvitations.send(i.toEntity()));
        return true;
    }
}
