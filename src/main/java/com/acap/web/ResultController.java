
package com.acap.web;

import com.acap.domain.Result;
import com.acap.repo.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
@CrossOrigin
public class ResultController {
    private final ResultRepository repo = null;

    @GetMapping("/me")
    public ResponseEntity<List<Result>> mine(){
     
        return ResponseEntity.ok(repo.findByUserId(1L));
    }
}
