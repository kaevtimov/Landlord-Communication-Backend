package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.ChatSession;

import java.util.List;

public interface ChatSessionService {

    List<ChatSession> getAllByUserId(int userId);

    ChatSession createSession(ChatSession chat);

}