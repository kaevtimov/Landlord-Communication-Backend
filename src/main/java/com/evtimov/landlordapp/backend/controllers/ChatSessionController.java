package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.services.base.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatSessionController {

    private final ChatSessionService service;

    @Autowired
    public ChatSessionController(ChatSessionService service) {
        this.service = service;
    }

    @RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.GET)
    public List<ChatSession> getAllByTenantId(@PathVariable(value = "tenantId") int tenantId){
        return service.getAllByTenantId(tenantId);
    }

    @RequestMapping(value = "/landlord/{landlordId}", method = RequestMethod.GET)
    public List<ChatSession> getAllByLandlordId(@PathVariable(value = "landlordId") int landlordId){
        return service.getAllByLandlordId(landlordId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ChatSession createChat(@RequestBody @Valid ChatSession chat){
        return service.createChat(chat);
    }

    @RequestMapping(value = "/check/{tenantId}/{landlordId}", method = RequestMethod.GET)
    public List<ChatSession> checkChatSessionIfExists(@PathVariable(value = "tenantId") int tenantId, @PathVariable(value = "landlordId") int landlordId){
        return service.checkIfChatSessionExistsByTenantIdAndLandlordId(tenantId, landlordId);
    }
}
