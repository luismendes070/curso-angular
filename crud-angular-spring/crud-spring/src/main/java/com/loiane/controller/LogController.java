package com.loiane.controller;

import com.loiane.model.Log;

import com.loiane.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping
    public List getAllLogs() {
        return logService.getAllLogs();
    }

    @PostMapping
    public Log createLog(@RequestParam String message) {
        return logService.createLog(message);
    }
} // end class LogController
