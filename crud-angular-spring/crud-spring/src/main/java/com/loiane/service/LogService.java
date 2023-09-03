package com.loiane.service;

import com.loiane.model.Log;

import com.loiane.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public List getAllLogs() {
        return logRepository.findAll();
    }

    public Log createLog(String message) {
        Log log = new Log(message, new Date());
        return logRepository.save(log);
    }

    public Log updateLog(Long id, String message) {
        Log log = logRepository.findById(id).orElse(null);
        if (log != null) {
            log.setMessage(message);
            return logRepository.save(log);
        }
        return null;
    }

    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
} // end class LogService
