package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.ChatSession;

import java.util.List;

public interface ChatSessionRepository {

    List<ChatSession> getAllByTenantId(int tenantId);

    List<ChatSession> checkIfChatSessionExistsByTenantIdAndLandlordId(int tenantId, int landlordId);

    List<ChatSession> getAllByLandlordId(int landlordId);

    ChatSession createSession(ChatSession chat);

}
