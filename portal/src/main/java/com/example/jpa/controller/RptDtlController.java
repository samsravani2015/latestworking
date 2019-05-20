package com.example.jpa.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.AcctInfo;
import com.example.jpa.entity.PorfolInfo;
import com.example.jpa.entity.RegnInfo;
import com.example.jpa.repository.RegnInfoRepository;

@RestController
public class RptDtlController {

    @Autowired
    private RegnInfoRepository regnInfoRepository;
    

    @GetMapping("/report")
    public List<RegnInfo> getAllPosts() {
    	System.out.println("::"+regnInfoRepository.findAll().get(2).getAccountInfo());
    	Set<AcctInfo> acctinfoSet = regnInfoRepository.findAll().get(2).getAccountInfo();
    	for(AcctInfo  acctinfo : acctinfoSet) {
    		System.out.println(acctinfo.getAcctId() + "%%%" +acctinfo.getAcctNm());
    		Set<PorfolInfo> portinfo = acctinfo.getPorfolInfo();
    		for(PorfolInfo info : portinfo) {
    			System.out.println(">>>>>>>>>>>"+info.getPorfolNm());
    		}
    	}
        return regnInfoRepository.findAll(); 
    }
    
  /*  @GetMapping("/acctInfo")
    public List<AcctInfo> getAcctInfo() {
        return acctIndoRepository.findAll();
    }
  */  
    
/*
    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
*/
}
