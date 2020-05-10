package com.myworkout.api.service;

import com.myworkout.api.dto.PatchSessionDTO;
import com.myworkout.api.dto.SessionDTO;
import com.myworkout.api.entity.Session;
import com.myworkout.api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


   public List<Session> getSessionsByUsersId(Long id){
        return sessionRepository.findAllByUser_Id(id);
   }

   public Session postSession(Session session){
        return sessionRepository.save(session);
   }

   public void deleteSessionById(Long id){
        sessionRepository.deleteById(id);
   }

   public Session findById(Long id){
        return sessionRepository.findById(id).orElseThrow(()->new RuntimeException("asd"));
   }

   public Session updateSession(Long id, PatchSessionDTO patchSessionDTO){
        Session session = findById(id);
        if(patchSessionDTO.getComment() != null){
            session.setComment(patchSessionDTO.getComment());
        }
        if(patchSessionDTO.getDuration() != null){
            session.setDuration(patchSessionDTO.getDuration());
        }
        return sessionRepository.save(session);
   }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session getUserSessionById(Long sessionId, Long userId) {
        return sessionRepository.findByIdAndUserId(sessionId, userId)
                .orElseThrow(() -> new RuntimeException("Nie ma sesji uzytkownika o podanym id"));
    }
}
